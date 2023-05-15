package wificonnector.Config;

import java.io.File;

public class createFolder {
    public static void main(String[] args) {
        createUserConfigFolder();
    }
    public static void createUserConfigFolder()

    {

        // 在D盘创建一个文件夹123
        File file = new File("C:", "WiFiConnectorUserConfig");// 或者 File file = new File("D:\\123");

        if (file.mkdirs()) {
            System.out.println("123文件夹创建成功！");
        } else {
            System.out.println("文件夹创建失败！");
        }

    }



}
