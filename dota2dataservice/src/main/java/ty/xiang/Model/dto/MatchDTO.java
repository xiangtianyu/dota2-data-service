package ty.xiang.Model.dto;

import java.util.List;

/**
 * Created by xiangtianyu on 2017/10/26.
 */
public class MatchDTO {
    private int             dire_team_id;

    private int             lobby_type;

    private String          match_id;

    private String          match_seq_num;

    private int             radiant_team_id;

    private String          start_time;

    private List<PlayerDTO> players;

    public int getDire_team_id() {
        return dire_team_id;
    }

    public void setDire_team_id(int dire_team_id) {
        this.dire_team_id = dire_team_id;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(int lobby_type) {
        this.lobby_type = lobby_type;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getMatch_seq_num() {
        return match_seq_num;
    }

    public void setMatch_seq_num(String match_seq_num) {
        this.match_seq_num = match_seq_num;
    }

    public int getRadiant_team_id() {
        return radiant_team_id;
    }

    public void setRadiant_team_id(int radiant_team_id) {
        this.radiant_team_id = radiant_team_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(obj instanceof MatchDTO){
            MatchDTO matchDTO = (MatchDTO) obj;
            if(matchDTO.getMatch_id().equals(this.match_id))
                return true;
        }
        return false;
    }
}
