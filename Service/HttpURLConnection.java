package wificonnector.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpURLConnection {
//    public static void main(String[] args) throws Exception {
//        int i = HttpURLConnection.sendURL();
//        System.out.println(i);
//    }
    private final static String USER_AGENT = "Mozilla/5.0";

    // HTTP GET请求
    public static int sendURL() throws Exception {

        String url = getURL.URL();
        System.out.println(url);

        if (url.equals("0")) {
            return 0;
        }


        URL obj = new URL(url);
        java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();

        //默认值我GET
        con.setRequestMethod("GET");

        //添加请求头
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        /********************************************************
         System.out.println("\nSending 'GET' request to URL : " + url);

         System.out.println("Response Code : " + responseCode);
         ********************************************************/

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        /***************打印结果*****************************************
         System.out.println(response.toString());
         ********************************************************/
        return responseCode;
    }


}