package com;

import com.Entity.userEntity;
import com.service.userService;

import javax.swing.*;

public class login {
    public static void main(String[] args) {
//        System.out.println("请输入你的账号和密码");
//        Scanner sc = new Scanner(System.in);
//        String name, pwd;
//        name = sc.nextLine();
//        pwd = sc.nextLine();
//        userEntity model = userService.login(name);
//
//        if (model == null) {
//            System.out.println("用户名不存在");
//        } else if (model.getPassword().equals(pwd)) {
//            System.out.println("登录成功！");
//        } else {
//            System.out.println("密码不正确");
//        }

        JFrame frame = new JFrame("登录窗口");
        frame.setSize(300, 200);
        //frame.setLayeredPane(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel labUser = new JLabel("用户名：");
        labUser.setBounds(20, 20, 60, 25);
        JTextField txtUser = new JTextField();
        txtUser.setBounds(90,20,150,25);

        JLabel labPwd = new JLabel("密码: ");
        labPwd.setBounds(20, 60, 60, 25);
        JPasswordField txtPwd = new JPasswordField();
        txtPwd.setBounds(90,60,150,25);

        JButton btnLogin = new JButton("登录");
        btnLogin.setBounds(150,100,90,30);

        JButton btnResnet = new JButton("重置");
        btnResnet.setBounds(30,100,90,30);

        btnLogin.addActionListener(e -> {
            String name = txtUser.getText();
            String pwd = new String(txtPwd.getPassword());
            if (name.isEmpty() || pwd.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "账号或者密码不能为空");
            } else {
                userEntity model = userService.login(name);
                if (model == null) {
                    JOptionPane.showMessageDialog(frame, "用户名不存在");
                } else if (! model.getPassword().equals(pwd)) {
                    JOptionPane.showMessageDialog(frame, "密码不正确");
                }  else {
                    JOptionPane.showMessageDialog(frame, "登录成功");
                    frame.dispose();
                    new MFrame().setVisible(true);
                }
            }
        });

        btnResnet.addActionListener(e -> {
            txtUser.setText("");
            txtPwd.setText("");
        });

        frame.add(labUser);
        frame.add(txtUser);
        frame.add(labPwd);
        frame.add(txtPwd);
        frame.add(btnLogin);
        frame.add(btnResnet);

        frame.setVisible(true);
    }
}
