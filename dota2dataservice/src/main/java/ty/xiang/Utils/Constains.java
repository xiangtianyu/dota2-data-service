package ty.xiang.Utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by xiangtianyu on 2017/10/25.
 */

@ConfigurationProperties(prefix = "localconfig")
public class Constains {
    public static final String          VALVE_KEY = "";

    public static final String          STEAMID_BASE_KEY = "76561197960265728";

    public static final String          BASE_URL = "https://api.steampowered.com/";

    public static final String          GET_MATCH_HISTORY = "IDOTA2Match_570/GetMatchHistory/v001";
}
