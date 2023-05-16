package wificonnector.Service;

import static wificonnector.Utils.SomeStatic.userIP;
import static wificonnector.Utils.UersInfo.GetUser.*;

public class getURL {
    String ip = userIP;
    String URL;

    public String getURL() {

        this.URL = "http://10.1.99.100:801/eportal/portal/login?callback=dr1003&login_method=1&user_account=%2C0%2C" +
                STU_NUM +
                "%40" +
                STU_OP +
                "&user_password=" +
                STU_PSD +
                "&wlan_user_ip=" +
                trimIP.getIP() +
                "&wlan_user_ipv6=&wlan_user_mac=000000000000&wlan_ac_ip=10.1.1.1&wlan_ac_name=&jsVersion=4.1.3&terminal_type=1&lang=zh-cn&v=2965&lang=zh";

// 如果wifi没有在发送认证请求之前连上就 将ip 默认成 0.0.0.0 表示wifi未能及时连接

        if (ip.equals("0.0.0.0")) this.URL = "0";//返回状态码0
        return URL;
    }

    public static String URL() {
        return new getURL().getURL();
    }
}
