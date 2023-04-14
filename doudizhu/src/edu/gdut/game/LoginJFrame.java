package edu.gdut.game;

import edu.gdut.Util.CodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginJFrame extends JFrame implements ActionListener {
    //创建一个登录按钮
    JButton loginJButton = new JButton();
    //创建一个注册按钮
    JButton registerJButton = new JButton();

    //创建一个用户名输入框
    JTextField usernameJTextField = new JTextField();
    //创建一个密码输入框
    JPasswordField passwordJPasswordField = new JPasswordField();
    //创建一个验证码输入框
    JTextField codeJTextField = new JTextField();
    //创建一个右侧验证码
    JLabel rightCode = new JLabel();

    String codeStr;

    public LoginJFrame() {
        //设置任务栏的图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java_project\\java-Advanced learning\\doudizhu\\image\\poker\\dizhu.png"));

        //初始化窗口
        initJFrame();

        //初始化登录界面
        initView();

        //设置可见，建议放在最后
        this.setVisible(true);
    }

    //初始化登录界面
    private void initView() {
        //1.添加用户名
        JLabel usernameJLabel = new JLabel("用户名");
        //字体加粗，加特别粗
        usernameJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        //设置字体颜色
        usernameJLabel.setForeground(Color.WHITE);
        usernameJLabel.setBounds(140, 55, 65, 22);
        this.getContentPane().add(usernameJLabel);

        //2.添加用户名输入框
        usernameJTextField.setBounds(223, 46, 200, 30);
        this.getContentPane().add(usernameJTextField);

        //3.添加密码
        JLabel passwordJLabel = new JLabel("密码");
        passwordJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        passwordJLabel.setForeground(Color.WHITE);
        passwordJLabel.setBounds(197, 95, 50, 22);
        this.getContentPane().add(passwordJLabel);

        //4.添加密码输入框
        passwordJPasswordField.setBounds(263, 87, 160, 30);
        this.getContentPane().add(passwordJPasswordField);

        //5.添加验证码
        JLabel codeJLabel = new JLabel("验证码");
        codeJLabel.setFont(new Font("宋体", Font.BOLD, 20));
        codeJLabel.setForeground(Color.WHITE);
        codeJLabel.setBounds(215, 142, 65, 22);
        this.getContentPane().add(codeJLabel);

        //6.添加验证码输入框
        codeJTextField.setBounds(291, 133, 100, 30);
        this.getContentPane().add(codeJTextField);

        //7.添加右侧验证码
        codeStr = CodeUtil.generateCode();
        rightCode.setText(codeStr);
        rightCode.setBounds(400, 133, 100, 30);
        rightCode.setFont(new Font("宋体", Font.BOLD, 20));
        rightCode.setForeground(Color.RED);
        this.getContentPane().add(rightCode);

        //设置按钮的背景图片
        ImageIcon loginImage = new ImageIcon("D:\\Java_project\\java-Advanced learning\\doudizhu\\image\\login\\登录按钮.png");
        loginJButton.setIcon(loginImage);
        //设置按钮的位置和大小
        loginJButton.setBounds(150, 320, 128, 47);
        //去除按钮的背景
        loginJButton.setBorderPainted(false);
        //去除按钮的背景
        loginJButton.setContentAreaFilled(false);
        //把按钮添加到界面上
        this.getContentPane().add(loginJButton);

        //设置按钮的背景图片
        ImageIcon registerImage = new ImageIcon("D:\\Java_project\\java-Advanced learning\\doudizhu\\image\\login\\注册按钮.png");
        registerJButton.setIcon(registerImage);
        //设置按钮的位置和大小
        registerJButton.setBounds(330, 320, 128, 47);
        //去除按钮的背景
        registerJButton.setBorderPainted(false);
        //去除按钮的背景
        registerJButton.setContentAreaFilled(false);
        //把按钮添加到界面上
        this.getContentPane().add(registerJButton);

        //添加背景图片。先加载的图片放在上面，后加载的图片放在下面
        ImageIcon background = new ImageIcon("D:\\Java_project\\java-Advanced learning\\doudizhu\\image\\login\\background.png");
        JLabel jLabel = new JLabel(background);
        jLabel.setBounds(0,0,633,423);
        this.getContentPane().add(jLabel);
    }

    //初始化窗口
    private void initJFrame() {
        //设置标题
        this.setTitle("斗地主 V1.0登录界面");
        //设置大小
        this.setSize(633, 430);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭按钮，这个是关闭整个程序
        //DO_NOTHING_ON_CLOSE：点击关闭但不做任何操作 0
        //HIDE_ON_CLOSE：点击关闭隐藏界面 1 默认
        //DISPOSE_ON_CLOSE：点击关闭释放资源 2 ，如果你有很多界面，只有当你关闭最后一个界面时才会关闭虚拟机 如果你的界面有很多资源，比如数据库连接，网络连接，文件连接，那么这个选项就很有用
        //EXIT_ON_CLOSE：点击关闭退出程序 3 ，只要关掉一个界面，整个程序就会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体的布局管理器，取消默认的居中布置，改为绝对布局，只有取消了默认的居中布局，才能设置组件的xy位置
        this.setLayout(null);
        //设置窗口无法进行调节
        this.setResizable(false);

        //给按钮添加监听事件
        loginJButton.addActionListener(this);
        registerJButton.addActionListener(this);
        //给右方验证码添加监听事件
       rightCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //鼠标点击右侧验证码的时候，重新生成验证码
                codeStr = CodeUtil.generateCode();
                rightCode.setText(codeStr);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == loginJButton){
            //更换登录的背景图片
            ImageIcon loginImage = new ImageIcon("D:\\Java_project\\java-Advanced learning\\doudizhu\\image\\login\\登录按下.png");
            loginJButton.setIcon(loginImage);
            //重新绘制按钮
            loginJButton.repaint();

            //获取用户名，密码，验证码
            String userName = usernameJTextField.getText();
            String password = new String(passwordJPasswordField.getPassword());
            String code = codeJTextField.getText();
            if("".equals(userName)){
                //当用户名为空的时候，弹出提示框，并且重置所有输入框和验证码
                JOptionPane.showMessageDialog(this,"用户名不能为空");
                reset();
            }else if("".equals(password)){
                //当密码为空的时候，弹出提示框，并且重置所有输入框和验证码
                JOptionPane.showMessageDialog(this,"密码不能为空");
                reset();
            }else if("".equals(code)){
                //当验证码为空的时候，弹出提示框，并且重置验证码
                JOptionPane.showMessageDialog(this,"验证码不能为空");
                //重新生成验证码
                codeStr = CodeUtil.generateCode();
                rightCode.setText(codeStr);
            }else if(!checkCode(codeStr,code)){
                //当验证码错误的时候，弹出提示框，并且重置验证码输入框和验证码
                JOptionPane.showMessageDialog(this,"验证码错误");
                codeJTextField.setText("");
                //重新生成验证码
                codeStr = CodeUtil.generateCode();
                rightCode.setText(codeStr);
            }else if(!login(userName,password)){
                //当用户名或密码错误的时候，弹出提示框，并且重置所有输入框和验证码
                JOptionPane.showMessageDialog(this,"用户名或密码错误");
                reset();
            }else{//登录成功
                //关闭当前界面
                this.setVisible(false);
                //打开游戏界面
                new GameJFrame();
            }

            //更换登录的背景图片
            ImageIcon loginImage2 = new ImageIcon("D:\\Java_project\\java-Advanced learning\\doudizhu\\image\\login\\登录按钮.png");
            loginJButton.setIcon(loginImage2);
            //重新绘制按钮
            loginJButton.repaint();

        }else if(source == registerJButton){
            //更换注册的背景图片
            ImageIcon registerImage = new ImageIcon("D:\\Java_project\\java-Advanced learning\\doudizhu\\image\\login\\注册按下.png");
            registerJButton.setIcon(registerImage);
            //重新绘制按钮
            registerJButton.repaint();

            //关闭当前界面
            this.setVisible(false);
            //打开注册界面
            //new RegisterJFrame();
        }
    }

    //清除全部输入框的内容并且重新生成验证码
    private void reset() {
        //清除全部输入框的内容
        usernameJTextField.setText("");
        passwordJPasswordField.setText("");
        codeJTextField.setText("");
        //重新生成验证码
        codeStr = CodeUtil.generateCode();
        rightCode.setText(codeStr);
    }

    //判断用户名和密码是否正确
    private static boolean login(String username,String password) {
        //每次进入文件，指针都会从头开始
        try {
            //fileReader是字符流，只能读取文本文件，不能读取图片、视频、音频等文件
            FileReader fileReader = new FileReader("doudizhu/src/edu/gdut/userinfo.txt");
            //2.读取数据
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                //判断用户名和密码是否正确
                if(line.split(",")[0].equals(username) && line.split(",")[1].equals(password)){
                    return true;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //判断验证码是否正确
    private static boolean checkCode(String codeStr,String code) {
        //判断用户输入的验证码是否正确，忽略大小写
        return codeStr.equalsIgnoreCase(code);
    }
}
