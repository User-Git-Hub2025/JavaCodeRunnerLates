package com;

import javax.swing.*;

public class MFrame extends JFrame {
    public MFrame() {
        setTitle("商场管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        add(new ProductPanel());   // 主窗口放商品管理面板
        ProductPanel productPanel = new ProductPanel();
        setContentPane(productPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MFrame().setVisible(true);
        });
    }
}
