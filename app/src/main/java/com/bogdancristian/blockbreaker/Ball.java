package com.bogdancristian.blockbreaker;

import android.graphics.RectF;

import java.util.Random;

public class Ball {

    RectF rect;
    float xVelocity;
    float yVelocity;
    float ballWidth = 10;
    float ballHeight = 10;

    public Ball ( int screenX, int screenY){
        xVelocity = 200;
        yVelocity = -400;

        rect = new RectF();
    }

    public RectF getRect() {
        return rect;
    }

    public void update(long fps){
        rect.left = rect.left + (xVelocity / fps);
        rect.top = rect.top + (yVelocity / fps);
        rect.right = rect.left + ballWidth;
        rect.bottom = rect.top - ballHeight;
    }

    public void reverseYVelocity(){
        yVelocity = -yVelocity;
    }

    public void reverseXVelocity(int answer){
        xVelocity = - xVelocity + answer;
    }

    public void reverseXVelocity(){
        xVelocity = - xVelocity ;
    }


    public void setRandomXVelocity(){
        Random generator = new Random();
        int answer = generator.nextInt(10);

            reverseXVelocity(answer);
    }
    public void setXVelocityZero(){
        Random generator = new Random();
        int answer = generator.nextInt(10);
        xVelocity = 0 + answer;
    }
    public void setNegativeXvelocity(){
           if(xVelocity > 0 ){
               xVelocity = -xVelocity;
           }
           if(xVelocity > -30 || xVelocity < 30){
               xVelocity = xVelocity - 80;
           }
    }
    public void setPositiveXvelocity(){
        if(xVelocity < 0 ){
            xVelocity = -xVelocity;
        }
        if(xVelocity > -30 || xVelocity < 30){
            xVelocity = xVelocity + 80;
        }
    }

    public void clearObstacleY(float y){
        rect.bottom = y;
        rect.top = y - ballHeight;
    }

    public void clearObstacleX(float x){
        rect.left = x;
        rect.right = x + ballWidth;
    }

    public void reset(int x, int y){
        rect.left = x / 2;
        rect.top = y - 20;
        rect.right = x / 2 + ballWidth;
        rect.bottom = y - 20 - ballHeight;
    }
}
