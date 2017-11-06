package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Base extends JPanel implements ActionListener {


    int chunkSideLength = 10;
    int rows = 840/chunkSideLength;
    int cols = 640/chunkSideLength;
    Random r = new Random();

    Timer timer=new Timer(100, this);
    Pixel pixelArr [][] = new Pixel[840/chunkSideLength][640/chunkSideLength];


    public Base() {

        timer.start();// Start the timer here.

        int yCoord = 0;

        for (int y = 0; y < rows; ++y) {

            int xCoord = 0;

            for (int x = 0; x < cols; ++x) {

                Color c;

                //TODO:SETTLEMENT CONTROLLER
                if (r.nextInt(25)<2) c = Color.BLACK; else c = Color.WHITE;

                pixelArr[y][x] = new Pixel(xCoord,yCoord,chunkSideLength+xCoord,
                        chunkSideLength+yCoord,c);

                xCoord += chunkSideLength;
            }
            yCoord += chunkSideLength;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.BLUE);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g.setColor(pixelArr[i][j].color);
                g.fillRect(pixelArr[i][j].startX,pixelArr[i][j].startY,pixelArr[i][j].endX,pixelArr[i][j].endY);
            }
        }

    }

    private static final int[][] NEIGHBOURS = {
            {-1, -1}, {-1, 0}, {-1, +1},
            { 0, -1},          { 0, +1},
            {+1, -1}, {+1, 0}, {+1, +1}};

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (neighbours(pixelArr,i,j)==3 && pixelArr[i][j].color == Color.WHITE)
                            pixelArr[i][j].color = Color.BLACK;
                    else if ((neighbours(pixelArr,i,j)<2 || neighbours(pixelArr,i,j)>3) && pixelArr[i][j].color == Color.BLACK)
                        pixelArr[i][j].color = Color.WHITE;
                }
            }

            repaint();// this will call at every 1 second
        }

    }

    private int neighbours(Pixel pixels [] [],int i,int j) throws IndexOutOfBoundsException{
        int count = 0;

        for (int[] offset : NEIGHBOURS) {
            if (isValid(i + offset[1], j + offset[0]) && pixels[i + offset[1]][j + offset [0] ].color == Color.BLACK) {
                count++;
            }
        }
        return count;
    }

    public boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

}
