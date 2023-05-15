package wificonnector.Utils.UersInfo;

import wificonnector.Config.LoadConfig;

import java.io.IOException;

public class GetUser {
//    public static void main(String[] args) {
//        System.out.println(STU_NUM);
//    }
    static String uc;
    static {
        try {
            uc = LoadConfig.LoadUserConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static int indexOfStuNum = uc.indexOf("U");
    static int indexOfStuPsd = uc.indexOf("P");
    static int indexOfOP = uc.indexOf("O");




    static int lastIndexOfStuNum = uc.lastIndexOf("U");
    static int lastIndexOfStuPsd = uc.lastIndexOf("P");
    static int lastIndexOfOP = uc.lastIndexOf("O");



    public static String STU_NUM = uc.substring(indexOfStuNum + 1, lastIndexOfStuNum);
    public static String STU_PSD = uc.substring(indexOfStuPsd + 1, lastIndexOfStuPsd);
    public static String STU_OP = uc.substring(indexOfOP + 1, lastIndexOfOP);






















}
