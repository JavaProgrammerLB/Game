package com.yitianyigexiangfa.game.snake.entity;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {

    private final static int ROWS = 200;
    private final static int COLS = 200;
    private final static int BLOCK_SIZE = 5;

    public void launch(){
        this.setLocation(200, 10);
        this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        g.setColor(color);
    }

    public static void main(String[] args) {
        Yard yard = new Yard();
        yard.launch();
    }

}
