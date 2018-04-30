package com.bogdancristian.blockbreaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BlockBreaker extends AppCompatActivity {


    BreakoutView breakoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initializam breakoutView si-l setam ca view
        breakoutView = new BreakoutView(this);
        setContentView(breakoutView);
    }
    //Implementarea clasei breakoutView. Aceasta va implementa Runnable pt a putea fi actionata ca un thread

    class BreakoutView extends SurfaceView implements Runnable {
        Thread gameThread = null;
        SurfaceHolder ourHolder;

        volatile boolean playing;
        boolean paused = true;

        Canvas canvas;
        Paint paint;

        long fps;

        private long timeThisFrame;
        int screenX;
        int screenY;

        public BreakoutView(Context context) {
            super(context);

            ourHolder = getHolder();
            paint = new Paint();

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            screenX = size.x;
            screenY = size.y;

        }

        public void run() {
            while (playing) {

                long startFrameTime = System.currentTimeMillis();

                if(!paused){
                    update();
                }
                // Draw the frame
                draw();

                timeThisFrame = System.currentTimeMillis() - startFrameTime;
                if (timeThisFrame >= 1) {
                    fps = 1000 / timeThisFrame;
                }

            }

        }

        public void update() {

        }

        // Draw the newly updated scene
        public void draw() {

            // Make sure our drawing surface is valid or we crash
            if (ourHolder.getSurface().isValid()) {
                // Lock the canvas ready to draw
                canvas = ourHolder.lockCanvas();

                // Draw the background color
                canvas.drawColor(Color.argb(255,  26, 128, 182));

                // Choose the brush color for drawing
                paint.setColor(Color.argb(255,  255, 255, 255));

                // Draw the paddle

                // Draw the ball

                // Draw the bricks

                // Draw the HUD

                // Draw everything to the screen
                ourHolder.unlockCanvasAndPost(canvas);
            }

        }
        public void pause() {
            playing = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                Log.e("Error:", "joining thread");
            }

        }
        public void resume() {
            playing = true;
            gameThread = new Thread(this);
            gameThread.start();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {

            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                // Player has touched the screen
                case MotionEvent.ACTION_DOWN:

                    break;

                // Player has removed finger from screen
                case MotionEvent.ACTION_UP:

                    break;
            }
            return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Tell the gameView resume method to execute
        breakoutView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Tell the gameView pause method to execute
        breakoutView.pause();
    }
}










