package wificonnector.Utils.UersInfo;

import wificonnector.GUI.RegistryUser;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class UserConfig  {
   private String StuNum;
   private String StuPsd;
   private String OP;

    public String getStuNum() {
        return StuNum;
    }

    public void setStuNum(String stuNum) {
        StuNum = stuNum;
    }

    public String getStuPsd() {
        return StuPsd;
    }

    public void setStuPsd(String stuPsd) {
        StuPsd = stuPsd;
    }

    public String getOP() {
        return OP;
    }

    public void setOP(String OP) {
        this.OP = OP;
    }
public UserConfig(){

        setStuNum(RegistryUser.stuID.getText());
        setStuPsd(RegistryUser.psd.getText());

        if (RegistryUser.yd.isSelected()){setOP("cmcc");}
        if (RegistryUser.dx.isSelected()){setOP("telecom");}
        if (RegistryUser.lt.isSelected()){setOP("unicom");}
        if (RegistryUser.wxu.isSelected()){setOP("");}

        System.out.println(getStuNum()+" "+getStuPsd()+" "+getOP());


}
}
