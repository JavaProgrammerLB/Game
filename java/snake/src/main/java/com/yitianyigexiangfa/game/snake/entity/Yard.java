package com.yitianyigexiangfa.game.snake.entity;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {

    private final static int ROWS = 50;
    private final static int COLS = 50;
    private final static int BLOCK_SIZE = 20;

    public void launch(){
        this.setLocation(200, 10);
        this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < ROWS - 1; i ++){
            g.drawLine(0, i * BLOCK_SIZE,ROWS * BLOCK_SIZE, i * BLOCK_SIZE);
        }
        for (int i = 0; i < COLS - 1;i ++){
            g.drawLine(i * BLOCK_SIZE, 0, i * BLOCK_SIZE, COLS * BLOCK_SIZE);
        }
        g.setColor(color);
    }

    public static void main(String[] args) {
        Yard yard = new Yard();
        yard.launch();
    }

}
