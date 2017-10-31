package ty.xiang.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ty.xiang.Model.dto.MatchDTO;
import ty.xiang.Model.dto.MatchHistoryByAccountId;
import ty.xiang.Model.dto.MatchHistoryDTO;
import ty.xiang.Service.Dota2ApiService;

import java.io.IOException;
import java.util.List;

/**
 * Created by xiangtianyu on 2017/10/26.
 */
@CrossOrigin
@RestController
public class Dota2ApiController extends BaseController {
    @Autowired
    private Dota2ApiService     dota2ApiService;

    @ResponseBody
    @RequestMapping(value = "/dota2/getHistoryByAccountId", method = RequestMethod.GET)
    public List<MatchDTO> getMatchHistoryByAccountId(String accountId) throws IOException {
        return dota2ApiService.getAllMatchHistoryByAccountId(accountId);
    }

    @ResponseBody
    @RequestMapping(value = "/dota2/getMatchBetweenTwoPlayers", method = RequestMethod.GET)
    public List<MatchDTO> getMatchBetweenTwoPlayers(String pidA, String pidB) throws IOException {
        return dota2ApiService.getMatchBetweenTwoPlayers(pidA, pidB);
    }
}
