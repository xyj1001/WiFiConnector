package wificonnector.Utils;

import java.io.IOException;

public class Start {

    public static void ChangeStart(boolean isStartAtLogon) throws IOException{

        String regKey = "HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run";
        String myAppName = "WiFiConnector";
        String exePath = "D:\\WiFiConnector\\WiFiConnector.exe";//开机启动程序本地目录
        Runtime.getRuntime().exec("reg " + (isStartAtLogon?"add ":"delete ") + regKey + " /v "
                + myAppName + (isStartAtLogon?" /t reg_sz /d " + exePath:" /f"));
    }


    public static void main(String[] args) {
        try{
         ChangeStart(true);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}