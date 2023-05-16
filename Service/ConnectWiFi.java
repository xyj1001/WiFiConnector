package wificonnector.Service;

public class ConnectWiFi {

    private static int respCode = 0;

    public static int ConnectWxxy() throws Exception {


        /***************下面方法需要做好关键优化***************/

        Cmd.command("netsh wlan connect name=i-wxxy");

        /***************上面方法需要做好关键优化***************/


        try {

            Thread.sleep(1500);

            HttpURLConnection http = new HttpURLConnection();
            respCode = http.sendURL();

            System.out.println(respCode);

        } catch (RuntimeException e) {
            System.out.println("wifi连接失败，接下来会重连......");
            e.printStackTrace();

        } finally {
            if (respCode != 200) {
                Thread.sleep(1500);

                HttpURLConnection http = new HttpURLConnection();
                respCode = http.sendURL();

                System.out.println("===========响应状态码=================" + respCode);

//            if (respCode == 200) {
//                System.out.print("Wifi 认证成功！ ");
//            }else {
//                System.out.print("Wifi 认证失败！ ");
//            }
//            System.out.print(dateFormat.format(new Date()));
            }
        }


        return respCode;
    }
}
