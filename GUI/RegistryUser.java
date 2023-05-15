package wificonnector.GUI;


import wificonnector.Config.WriteUserConfig;
import wificonnector.Config.createFolder;
import wificonnector.Utils.UersInfo.GetUser;
import wificonnector.Utils.UersInfo.UserConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class RegistryUser extends JFrame implements MouseListener {
//    public static void main(String[] args) {
//        RegistryUser mainJf = new RegistryUser();
//
//    }
    static String path = "C:\\WiFiConnectorUserConfig\\UserConfig.conf";


    public static JTextField stuID = new JTextField();
    public static JTextField psd = new JTextField();
    public static JRadioButton  yd=new JRadioButton("移动");
    public static JRadioButton dx =new JRadioButton("电信");
    public static JRadioButton lt =new JRadioButton("联通") ;
    public static JRadioButton wxu=new JRadioButton("内网") ;
    public  static JLabel user = new JLabel("学号:");
    public  static JLabel password = new JLabel("密码:");



public static JButton cancel=new JButton("取消");
public static JButton determine=new JButton("保存");
    String actionCommand;

    public RegistryUser() {
        File file = new File(path);
        if (file.exists()==true){

            stuID.setText(GetUser.STU_NUM);
            psd.setText(GetUser.STU_PSD);
            if (GetUser.STU_OP.equals("cmcc")){yd.setSelected(true);}
            if (GetUser.STU_OP.equals("telecom")){dx.setSelected(true);}
            if (GetUser.STU_OP.equals("unicom")){lt.setSelected(true);}
            if (GetUser.STU_OP.equals("")){wxu.setSelected(true);}

        }
        initRegistry();
        initView();
        this.setVisible(true);
        setFont(new Font("仿宋", Font.BOLD, 30));
    }

    private void initView() {

        this.user.setBounds(55, 32, 50, 50);
        this.getContentPane().add(user);

        this.stuID.setBounds(90, 40, 200, 36);
        this.getContentPane().add(stuID);



        this.password.setBounds(55,80,50,50);
        this.getContentPane().add(password);

        this.psd.setBounds(90,86,200,36);
        this.getContentPane().add(psd);




        this.yd.setBounds(70, 130, 60, 40);
        this.getContentPane().add(yd);


        this.dx.setBounds(130, 130, 60, 40);
        this.getContentPane().add(dx);


        this.lt.setBounds(190, 130, 60, 40);
        this.getContentPane().add(lt);


        this.wxu.setBounds(250, 130, 60, 40);
        this.getContentPane().add(wxu);

        ButtonGroup group = new ButtonGroup();
        group.add(yd);
        group.add(dx);
        group.add(lt);
        group.add(wxu);




//        actionCommand = group.getSelection().getActionCommand();


        /**************************取消 or 保存 **************************************/

        this.cancel.setBounds(90,180,80,35);
        this.getContentPane().add(cancel);
        cancel.addMouseListener(this);

        this.determine.setBounds(200,180,80,35);
        this.getContentPane().add(determine);
        determine.addMouseListener(this);


        /****************************************************************/
    }

    private void initRegistry() {
        this.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon.png"));
        this.setIconImage(icon);
        this.setSize(400, 300);//设置宽高
        this.setTitle("WiFiConnector");//设置标题
        this.setDefaultCloseOperation(2);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {



        if(e.getSource()==cancel){ this.setVisible(false); }  //关闭窗口


        // 如果用户点击保存按钮 写入用户配置到文件
        if(e.getSource()==determine){

            //创建用户配置文件夹
            File file = new File("C:\\WiFiConnectorUserConfig");

            if (file.exists()==false){
                createFolder.createUserConfigFolder();           // 缺乏健壮性
            }

            // 写入用户配置到文件
            UserConfig uc = new UserConfig();

            String userConfig = "U" + uc.getStuNum() + "U"+"P" + uc.getStuPsd() +"P" + "O" + uc.getOP()+"O";
            try {
                WriteUserConfig.writeUserConfigToFile(userConfig);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            // 关闭窗口

            this.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



}
