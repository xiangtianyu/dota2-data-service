package ty.xiang.Service;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;
import ty.xiang.Model.dto.MatchDTO;
import ty.xiang.Model.dto.MatchHistoryByAccountId;
import ty.xiang.Model.dto.MatchHistoryDTO;
import ty.xiang.Utils.Constains;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiangtianyu on 2017/10/26.
 */
@Service
public class Dota2ApiService extends BaseService {
    public List<MatchDTO> getMatchBetweenTwoPlayers (String pidA, String pidB) throws IOException {
        List<MatchDTO> matchListA = getAllMatchHistoryByAccountId(pidA);
        List<MatchDTO> matchListB = getAllMatchHistoryByAccountId(pidB);

//        List<String> mA = matchListA.stream().map(MatchDTO::getMatch_id).collect(Collectors.toList());
//        List<String> mB = matchListB.stream().map(MatchDTO::getMatch_id).collect(Collectors.toList());

        HashSet<MatchDTO> sa = new HashSet<>(matchListA);
        sa.retainAll(matchListB);
        return new ArrayList<>(sa);
    }

    public List<MatchDTO> getAllMatchHistoryByAccountId (String accountId) throws IOException {
        //垃圾v社对这个接口做了限制，只能获取到最多500场比赛的信息
        List<MatchDTO> matchDTOList = new ArrayList<>();
        String matchId = "";
        boolean isEnd = false;

        while (!isEnd) {
            OkHttpClient client_p = new OkHttpClient();

            Request request_p = new Request.Builder()
                    .url(Constains.BASE_URL + Constains.GET_MATCH_HISTORY
                            + "?key=" + Constains.VALVE_KEY + "&account_id=" + accountId + "&start_at_match_id=" + matchId)
                    .get()
                    .addHeader("content-type", "application/json").addHeader("cache-control", "no-cache")
                    .build();

            Response response_p = client_p.newCall(request_p).execute();

            Gson gson = new Gson();
            MatchHistoryByAccountId matchHistoryByAccountId = gson.fromJson(response_p.body().string(), MatchHistoryByAccountId.class);

            if (matchHistoryByAccountId.getResult().getNum_results() > 0) {
                matchDTOList.addAll(matchHistoryByAccountId.getResult().getMatches());
            }

            if (matchHistoryByAccountId.getResult().getResults_remaining() == 0) {
                isEnd = true;
            }

            List<MatchDTO> matches = matchHistoryByAccountId.getResult().getMatches();

            matchId = matches.get(matches.size()-1).getMatch_id();
        }

        return matchDTOList;
    }

}
