package wificonnector.Utils;

import wificonnector.Service.trimIP;

import java.io.File;
import java.text.SimpleDateFormat;

public class SomeStatic {

    public static String path = "C:\\WiFiConnectorUserConfig\\UserConfig.conf";

    public static File file = new File(path);
    public static  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
    public static String userIP = trimIP.getIP();
    public static String AutoRunPath = "C:\\WiFiConnectorUserConfig\\AutoRunConfig.conf";
    public static String AutoConnectPath = "C:\\WiFiConnectorUserConfig\\AutoConnectConfig.conf";
    public static String AutoClothPath = "C:\\WiFiConnectorUserConfig\\AutoClothConfig.conf";
    public static File AutoConnectfile = new File(AutoConnectPath);
    public static File AutoRunfile = new File(AutoRunPath);
    public static File AutoClothfile = new File(AutoClothPath);

}
