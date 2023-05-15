package wificonnector.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadConfig {
    public static String LoadUserConfig() throws IOException {
        Path path = Paths.get("C:\\WiFiConnectorUserConfig\\UserConfig.conf");
        byte[] data = Files.readAllBytes(path);
        String result = new String(data, "utf-8");
        return  result;
    }
}
