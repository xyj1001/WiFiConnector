package wificonnector.Service;

public class trimIP {

    //    public static void main(String[] args) {
//        String ip = getIP();
//        System.out.println(ip);
//        System.out.println(ip.length());
//
//
//    }
    static String str;
    static String ip;

    public static void main(String[] args) {
        String ip1 = getIP();
        System.out.println(ip);
    }
    public static String getIP() {
        try {
            str = Cmd.command("ipconfig");
            int i = str.indexOf("10.2");
            String strIP = new String(str);
            String tempIP = strIP.substring(i, i + 13);
            ip = tempIP.replaceAll("\\s*", "");
            return ip;
        } catch (RuntimeException e) {
//            e.printStackTrace();
        } finally {

                  ip="0.0.0.0";
        }




//      String trimIP = ip.trim();

//        System.out.println(ip);


        return ip;

    }


}
