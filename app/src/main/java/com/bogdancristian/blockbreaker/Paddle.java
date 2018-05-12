package com.bogdancristian.blockbreaker;

import android.graphics.RectF;

/**
 * Created by Bogdan on 30-Apr-18.
 */

public class Paddle {

    // Padul va avea 3 zone diferite pt lovirea mingii
    private RectF rect;//pentru coordonatele generale ale padului
    private RectF rectLeft; // zona din stanga
    private RectF rectRight; // zona din dreapta
    private RectF rectMid; // zona din centru
    private float length1;//lungimea zonelor laterale
    private float length2;//lungimea centrala
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
        length1 = 40;
        length2 = 50;
        height = 20;

        //punem paddul in centru
        x = screenX / 2 - 50;
        y = screenY -300;

        rectLeft = new RectF(x, y, x+length1, y+height);
        rectMid = new RectF(x + length1, y, x + length1 + length2, y + height);
        rectRight = new RectF(x + length1 + length2, y, x + length1 + length1 + length2, y+height);
        paddleSpeed = 350;
    }
    //Getter pentru Rect
    public RectF getRectLeft(){
        return rectLeft;
    }

    public RectF getRectMid() {
        return rectMid;
    }

    public RectF getRectRight() {
        return rectRight;
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
        rectLeft.left = x;
        rectLeft.right = x + length1;
        rectMid.left = x + length1;
        rectMid.right = x + length1 + length2;
        rectRight.left = x + length1 + length2;
        rectRight.right = x + length1 + length2 + length1 ;

    }
}
