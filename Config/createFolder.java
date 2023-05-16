package wificonnector.Config;

import java.io.File;

public class createFolder {
    public static void createUserConfigFolder()

    {

        // 在C盘创建一个文件夹
        File file = new File("C:", "WiFiConnectorUserConfig");// 或者 File file = new File("C:\\123");

        if (file.mkdirs()) {
            System.out.println("文件夹创建成功！");
        } else {
            System.out.println("文件夹创建失败！");
        }

    }



}
