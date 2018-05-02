package com.bogdancristian.blockbreaker;

import android.graphics.RectF;

/**
 * Created by Bogdan on 30-Apr-18.
 */

public class Paddle {

    private RectF rect;//pentru coordonate
    private float length;//lungimea padului
    private float height;//inaltimea padului
    private float x;
    private float y;//coordonatele din stanga sus pt pad
    private float paddleSpeed;//pixeli pe secunda

    //Directii pt miscarea padului;
    public final int STOPPED = 0;
    public final int LEFT = 1;
    public final int RIGHT = 2;

    //starea curenta a padului
    private int paddleMoving = STOPPED;

    //Constructorul padului va lua ca argumente dimensiunile ecranului
    public Paddle(int screenX, int screenY){
        length = 130;
        height = 20;

        //punem paddul in centru
        x = screenX / 2;
        y = screenX -20;

        rect = new RectF(x, y, x+length, y+height);

        paddleSpeed = 350;
    }
    //Getter pentru Rect
    public RectF getRect(){
        return rect;
    }

    //Setter pentru starea padului
    public void setMovementState(int state){
        paddleMoving = state;
    }

    //Metoda de update a pozitiei padului
    public void update ( long fps){
        if(paddleMoving == LEFT){
            x = x - paddleSpeed/fps;
        }
        if(paddleMoving == RIGHT){
            x = x + paddleSpeed/fps;
        }
        rect.left = x;
        rect.right = x + length;
    }
}
