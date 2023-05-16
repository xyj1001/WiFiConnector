package wificonnector.Config;

import java.io.*;

import static wificonnector.Utils.SomeStatic.*;

public class WriteUserConfig {
    /**
     * 将字符串写入文件中
     * @throws IOException
     */





    public static void writeUserConfigToFile(String str) throws IOException {

        //文件目录
        File writefile;
        BufferedWriter bw;
        boolean append = true;  //  是否追加

        writefile = new File(path);
        if (writefile.exists() == false)   // 判断文件是否存在，不存在则生成
        {
            try {
                writefile.createNewFile();
                writefile = new File(path);
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        } else {        // 存在先删除，再创建
            writefile.delete();
            try {
                writefile.createNewFile();
                writefile = new File(path);
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter(writefile, append);
            bw = new BufferedWriter(fw);
            fw.write(str);
            fw.flush();
            fw.close();

        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public static void writeAutoConfigToFile(String str) throws IOException {

        //文件目录
        File writefile;
        BufferedWriter bw;
        boolean append = true;  //  是否追加
        writefile = new File(AutoConnectPath);
        if (writefile.exists() == false)   // 判断文件是否存在，不存在则生成
        {
            try {
                writefile.createNewFile();
                writefile = new File(AutoConnectPath);
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }


    public static void writeAutoRunConfigToFile(String str) throws IOException {
        File writefile;
        BufferedWriter bw;
        boolean append = true;  //  是否追加

        writefile = new File(AutoRunPath);
        if (writefile.exists() == false)   // 判断文件是否存在，不存在则生成
        {
            try {
                writefile.createNewFile();
                writefile = new File(AutoRunPath);
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }

    public static void writeAutoClothConfigToFile(String str) throws IOException {
        File writefile;
        BufferedWriter bw;
        boolean append = true;  //  是否追加

        writefile = new File(AutoClothPath);
        if (writefile.exists() == false)   // 判断文件是否存在，不存在则生成
        {
            try {
                writefile.createNewFile();
                writefile = new File(AutoClothPath);
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }
}
