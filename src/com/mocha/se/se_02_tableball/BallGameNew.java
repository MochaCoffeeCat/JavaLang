package com.mocha.se.se_02_tableball;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mocha@15025153960@163.com
 */

public class BallGameNew extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    // ball's x axies
    private double x = 100;
    // ball's y axies
    private double y = 100;

    double initSpeed = 10;

    double degree = 3.14 / 3;

    // 画窗口的方法
    @Override
    public void paint(Graphics g) {
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        x = x + initSpeed * Math.cos(degree);
        y = y + initSpeed * Math.sin(degree);

        if (y > 430 || y < 80) {
            degree = -degree;
        }
        if (x > 786 || x < 40) {
            degree = 3.14 - degree;
        }

        if (initSpeed > 0) {
            initSpeed -= 0.05;
        } else {
            initSpeed = 0;
        }
    }

    /**
     * 加载窗口
     */
    void launchFrame() {
        // 设置Size
        setSize(856, 500);
        // 设置定位
        setLocation(50, 50);
        // 设置可见
        setVisible(true);

        // 重画窗口
        while (initSpeed != 0) {
            repaint();
            try {
                Thread.sleep(15);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // main 方法是程序执行入口
    public static void main(String[] args) {
        BallGameNew bg = new BallGameNew();
        bg.launchFrame();
    }
}
