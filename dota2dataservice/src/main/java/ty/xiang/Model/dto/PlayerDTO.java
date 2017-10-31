package ty.xiang.Model.dto;

/**
 * Created by xiangtianyu on 2017/10/26.
 */
public class PlayerDTO {
    private String      account_id;

    private int         hero_id;

    private int         player_slot;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public void setPlayer_slot(int player_slot) {
        this.player_slot = player_slot;
    }
}
