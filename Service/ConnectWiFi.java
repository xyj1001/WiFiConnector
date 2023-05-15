package wificonnector.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectWiFi {
//    public static void main(String[] args) throws Exception {
//        ConnectWxxy();
//    }
    public static int ConnectWxxy() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");


        String command = Cmd.command("netsh wlan connect name=i-wxxy");
        System.out.print("Wifi 连接成功！ ");
        System.out.print(dateFormat.format(new Date()));
        System.out.println(" ");

        int respCode=0;
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

            HttpURLConnection http = new HttpURLConnection();
            respCode = http.sendURL();

            System.out.println("============================"+respCode);


            if (respCode==200) System.out.print("Wifi 认证成功！ ");
            if (respCode==0) System.out.print("Wifi 认证失败！ ");
            System.out.print(dateFormat.format(new Date()));

        }


        return respCode;
    }
}
