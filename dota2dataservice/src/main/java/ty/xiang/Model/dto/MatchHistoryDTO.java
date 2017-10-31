package ty.xiang.Model.dto;

import java.util.List;

/**
 * Created by xiangtianyu on 2017/10/26.
 */
public class MatchHistoryDTO {
    private int             num_results;

    private int             results_remaining;

    private int             status;

    private int             total_results;

    private List<MatchDTO>  matches;

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public int getResults_remaining() {
        return results_remaining;
    }

    public void setResults_remaining(int results_remaining) {
        this.results_remaining = results_remaining;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }
}
