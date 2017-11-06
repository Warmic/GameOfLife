package com.company;

import java.awt.*;

public class Pixel {

    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public Color color;

    public Pixel(int x,int y,int endX,int endY,Color  color){
        this.startX = x;
        this.startY = y;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
    }
}
