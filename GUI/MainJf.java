package wificonnector.GUI;

import wificonnector.Config.WriteUserConfig;
import wificonnector.Service.ConnectWiFi;
import wificonnector.Service.trimIP;
import wificonnector.Utils.ShowDialog;
import wificonnector.Utils.Start;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainJf extends JFrame implements MouseListener {

    static String userIP = trimIP.getIP();


    static int code = 0;
    static String path = "C:\\WiFiConnectorUserConfig\\UserConfig.conf";
    static String AutoPath = "C:\\WiFiConnectorUserConfig\\AutoConfig.conf";

    static String AutoRunPath = "C:\\WiFiConnectorUserConfig\\AutoRunConfig.conf";

    static String AutoClothPath = "C:\\WiFiConnectorUserConfig\\AutoClothConfig.conf";

    static File file = new File(path);
    static File Autofile = new File(AutoPath);

    static File AutoRunfile = new File(AutoRunPath);

    static File AutoClothfile = new File(AutoClothPath);
    /**************************************************************************/
    JMenuItem replayItem = new JMenuItem("使用介绍");
    JMenuItem reLoginItem = new JMenuItem("问题说明");
    JMenuItem closeItem = new JMenuItem("开源地址");
    JMenuItem accountItem = new JMenuItem("支持一下");
    /**************************************************************************/


    JButton userConfig = new JButton("设置登录信息");

    JButton Connection = new JButton("一键连接WiFi");
    JRadioButton AutoRun = new JRadioButton("开机自启(慎用)");
    JRadioButton AutoConnect = new JRadioButton("自动连接");
    JRadioButton AfterCloth = new JRadioButton("自动关闭");

//


    public static JLabel ifWiFiConnected = new JLabel();
    public static JLabel ifWiFiSucceed = new JLabel();


    public MainJf() {

//        this.getContentPane().setBackground(Color.red);
//        this.getContentPane().setVisible(true);//如果改为true那么就变成了红色。


        if (file.exists() == true) {
            userConfig.setText("修改登录信息");
        }
        if (Autofile.exists() == true) {
            AutoConnect.setSelected(true);
            try {
                code = ConnectWiFi.ConnectWxxy();
                System.out.println("respCode: " + code);

            } catch (Exception ex) {

            } finally {
                if (code == 200) {
                    System.out.println("连接成功！");
                    Connection.setBackground(Color.GREEN);


                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

                    ifWiFiSucceed.setText("Wifi 认证成功！ " + dateFormat.format(new Date()) + "   RespCode: 200");


                } else {
                    ifWiFiSucceed.setText("连接失败，请检测WiFi是否连接后重试！");

                    Connection.setBackground(Color.RED);
                }
            }

        }
        if (AutoRunfile.exists() == true) {
            AutoRun.setSelected(true);
        }

        if (AutoClothfile.exists() == true) {
            AfterCloth.setSelected(true);
            if (code == 200) {
                System.exit(0);

            }
        }


        initJFrame();
        initView();
        initJMenuBar();
        this.setVisible(true);

    }

    private void initView() {
//        ButtonGroup bg=new ButtonGroup();
//        bg.add(AutoRun);

//this.setBackground(Color.BLACK);

        //添加背景图片
//        JLabel background = new JLabel(new ImageIcon("C:\\Users\\tuyup\\Desktop\\java课件\\puzzlegame(1) - 副本\\puzzlegame\\src\\wificonnector\\image"));
//        background.setBounds(40, 40, 508, 560);
//        //把背景图片添加到界面当中
//        this.getContentPane().add(background);


        //刷新一下界面

        this.userConfig.setBounds(225, 40, 150, 60);
        this.getContentPane().add(userConfig);
        userConfig.addMouseListener(this);

        this.Connection.setBounds(225, 110, 150, 60);
        this.getContentPane().add(Connection);
        Connection.addMouseListener(this);

        this.AutoRun.setBounds(120, 200, 140, 30);
        this.getContentPane().add(AutoRun);
        AutoRun.addMouseListener(this);


        this.AutoConnect.setBounds(260, 200, 100, 30);
        this.getContentPane().add(AutoConnect);
        AutoConnect.addMouseListener(this);


        this.AfterCloth.setBounds(400, 200, 100, 30);
        this.getContentPane().add(AfterCloth);
        AfterCloth.addMouseListener(this);


        this.getContentPane().add(ifWiFiSucceed);
        this.getContentPane().add(ifWiFiConnected);
        ifWiFiConnected.setBounds(235, 240, 300, 30);
        ifWiFiSucceed.setBounds(150, 260, 350, 30);
        this.getContentPane().repaint();
    }

    private void initJFrame() {
//
//        JLabel icon = new JLabel(new ImageIcon("C:\\Users\\tuyup\\Desktop\\java课件\\puzzlegame(1) - 副本\\puzzlegame\\src\\wificonnector\\image\\bg.jpg"));
//        background.setBounds(0, 0, 600, 400);
//        //把背景图片添加到界面当中
//        this.getContentPane().add(background);

        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon.png"));
        this.setIconImage(icon);
        this.setResizable(false);
        this.setSize(600, 400);//设置宽高
        this.setTitle("WiFiConnector");//设置标题
        this.setDefaultCloseOperation(3);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);
        this.getContentPane().repaint();

    }


    private void initJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面的两个选项的对象 （功能  关于我们）
        JMenu functionJMenu = new JMenu("菜单");
        JMenu aboutJMenu = new JMenu("关于");


        //将每一个选项下面的条目天极爱到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);


        //给条目绑定事件
        replayItem.addMouseListener(this);
        reLoginItem.addMouseListener(this);
        closeItem.addMouseListener(this);
        accountItem.addMouseListener(this);

        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }


    @Override
    public void mouseClicked(MouseEvent e) {


        if (e.getSource() == userConfig) {

            // 如果存在文件， new Dialog 提示 修改 或 取消
            // 上句业务逻辑已经在RegistryUser中实现 通过 做数据的回显 提示用户

            // 不存在 进行配置用户信息 配置 学号，密码，op
            new RegistryUser();

        }

        if (e.getSource() == Connection) {


            // 如果 有配置文件 进行 进行连接


            if (file.exists() == true) {
                try {


                    code = ConnectWiFi.ConnectWxxy();
                    System.out.println("respCode: " + code);

                } catch (Exception ex) {

                } finally {


                    if (code == 200) {
                        System.out.println("连接成功！");
                        System.out.println(code);
                        Connection.setBackground(Color.GREEN);
                        ifWiFiConnected.setText("您的IP是: " + userIP);


                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

                        ifWiFiSucceed.setText("Wifi 认证成功！ " + dateFormat.format(new Date()) + "   RespCode: 200");


                    } else {
                        ifWiFiSucceed.setText("连接失败，请检测WiFi是否连接后重试！");
                        ifWiFiConnected.setText("您的IP是: " + userIP);

                        System.out.println(code);
                        Connection.setBackground(Color.RED);
                    }

                }
            }
        }


        //如果没有  配置文件 new Dialog 提示先 填写用户信息


    }

    @Override
    public void mousePressed(MouseEvent e) {

//       if (file.exists()==false){
//           ShowDialog.showJDialog("设置登录信息后重试！");
//       }else {

        if (e.getSource() == AutoConnect) {

            if (Autofile.exists() == true) {
                Autofile.delete();
            } else {
                try {
                    WriteUserConfig.writeAutoConfigToFile("status:1");
                    System.out.println("===========autoconnect===================");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }


        if (e.getSource() == AutoRun) {

            if (AutoRunfile.exists() == true) {
                AutoRunfile.delete();
                try {
                    Start.ChangeStart(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("================autorun====ddd==========");
            } else {
                try {

                    Start.ChangeStart(true);

                    System.out.println("================autorun==============");
                    WriteUserConfig.writeAutoRunConfigToFile("status:1");
                    Start.ChangeStart(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

        if (e.getSource() == AfterCloth) {

            if (AutoClothfile.exists() == true) {
                AutoClothfile.delete();

                System.out.println("================autorun====ddd==========");
            } else {
                try {


                    System.out.println("================autorun==============");
                    WriteUserConfig.writeAutoClothConfigToFile("status:1");

                    if (code == 200) {
                        System.exit(0);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }


    }






    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource()==replayItem) {
            ShowDialog.showJDialog("必须最先设置登录信息！");
        }
        if (e.getSource()==reLoginItem) {
            try {
                Runtime.getRuntime().exec("https://blog.csdn.net/agabq?spm=1010.2135.3001.5343");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource()==closeItem) {
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www.baidu.com");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource()==accountItem) {
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon(this.getClass().getResource("money.jpg")));
            //设置位置和宽高
            jLabel.setBounds(0,0,325,450);
            //把图片添加到弹框当中
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(325,450);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }






}
