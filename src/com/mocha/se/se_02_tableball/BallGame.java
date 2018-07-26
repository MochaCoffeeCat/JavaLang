package com.mocha.se.se_02_tableball;

import java.awt.*;
import javax.swing.*;

/**
 * @author Mocha@15025153960@163.com
 */

public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    // ball's x axies
    private double x = 100;
    // ball's y axies
    private double y = 100;

    boolean right = true;

    // 画窗口的方法
    @Override
    public void paint(Graphics g) {
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        if (right) {
            x += 5;
        } else {
            x -= 5;
        }

        if (x >= 786) {
            right = false;
        }
        if (x <= 40) {
            right = true;
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
        while (true) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // main 方法是程序执行入口
    public static void main(String[] args) {
        BallGame bg = new BallGame();
        bg.launchFrame();
    }
}
