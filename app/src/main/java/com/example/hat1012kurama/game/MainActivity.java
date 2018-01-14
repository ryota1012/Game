package com.example.hat1012kurama.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

import static android.graphics.Color.WHITE;
import static com.example.hat1012kurama.game.information.count;
import static com.example.hat1012kurama.game.information.num;

class information {
    static int count = 0;
    static int num = 100;
    static int[] block = new int[num];
}

public class MainActivity extends AppCompatActivity implements Runnable {
    Dice dice;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);


        handler = new Handler();
        handler.postDelayed(this, 10);

        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            information.block[i] = rand.nextInt(2);
        }

        Point point = new Point();
        int width = point.x;
        int height = point.y;
        dice = new Dice(this);
        dice.x = 10;
        dice.y = 10;

        addContentView(dice, params);


        final CountDownTimer countDownTimer = new CountDownTimer(10000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int time = (int) millisUntilFinished / 1000;
                ((TextView) findViewById(R.id.countdown)).setText("あと" + time + "秒");
                ((TextView) findViewById(R.id.count)).setText(+count + "回");

            }

            @Override
            public void onFinish() {
                ((TextView) findViewById(R.id.countdown)).setText("おわり～～");
                for (int i = 0; i < 100; i++) {
                    information.block[i] = 2;
                }
                //information.count=100;
/*
                new AlertDialog.Builder(this)
                        .setTitle("結果発表")
                        .setMessage("Congratulations!!\n"+information.count+"回成功");
                        */
            }
        }.start();

    }

/*
    static public class DrawView extends View {

        public DrawView(Context context) {
            super(context);
        }

        // 描画処理を記述
        @Override
        public void onDraw(Canvas canvas) {
            Paint paint1 = new Paint();
            paint1.setColor(Color.argb(255, 255, 255, 200));

            Rect rect = new Rect(10, 600, 500, 750);
            canvas.drawRect(rect,paint1);


        }
    }
    */


    @Override
    public void run() {
        //Dice dice = new Dice(this);
        if (dice.flag1 == 1) {
            dice.color1 = Color.argb(0, 0, 0, 0);
        } else if (information.block[count] == 0) {
            dice.x += 3;
            dice.color1 = Color.BLUE;
        } else {
            dice.x += 2;
            dice.y += 2;
            dice.color1 = Color.GREEN;
        }
        if (information.block[count + 1] == 0) {
            dice.color2 = Color.BLUE;
        } else {
            dice.color2 = Color.GREEN;
        }
        if (information.block[count + 2] == 0) {
            dice.color3 = Color.BLUE;
        } else {
            dice.color3 = Color.GREEN;
        }
       /* if(information.block[count+3] == 0 ){
            dice.color4 = Color.BLUE;
        }else{
            dice.color4=Color.GREEN;
        }
        */
        dice.invalidate();
        handler.postDelayed(this, 10);

        Paint paint1 = new Paint();
        paint1.setColor(Color.argb(255, 0, 255, 0));

        Paint paint2 = new Paint();
        paint2.setColor(Color.argb(255, 0, 0, 255));

        Rect rect = new Rect(100, 200, 300, 400);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);


    }

    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(this);
    }

    public Runnable run1 = new Runnable() {
        @Override
        public void run() {
            information.count++;
            dice.flag1 = 0;
        }
    };

    public Runnable run2 = new Runnable() {
        public void run() {
            ((TextView) findViewById(R.id.alert)).setText("");

        }
    };

    public void onGreenButton(View v) {
        if (information.block[count] == 1) {
            dice.flag1 = 1;

            TranslateAnimation translate = new TranslateAnimation(0, 0, 0, 150);
            translate.setDuration(50);
            dice.startAnimation(translate);
            handler.postDelayed(run1, 50);
        } else {
            ((TextView) findViewById(R.id.alert)).setText("だめ！！！！");
            handler.postDelayed(run2, 1000);

        }

    }

    public void onBlueButton(View v) {
        if (information.block[count] == 0) {
            dice.flag1 = 1;

            TranslateAnimation translate = new TranslateAnimation(0, 0, 0, 150);
            translate.setDuration(100);
            dice.startAnimation(translate);
            handler.postDelayed(run1, 100);

        } else {
            ((TextView) findViewById(R.id.alert)).setText("だめ！！！！");
            handler.postDelayed(run2, 1000);
        }

    }

}


