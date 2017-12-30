package com.example.hat1012kurama.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;


public class MainActivity extends AppCompatActivity {
    int count = 0;
    int block[] = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        addContentView( new DrawView(this), params);


        CountDownTimer countDownTimer = new CountDownTimer(10000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                ((TextView) findViewById(R.id.countdown)).setText("あと" + millisUntilFinished + "秒");
                ((TextView) findViewById(R.id.count)).setText(+count + "回");

            }

            @Override
            public void onFinish() {
                ((TextView) findViewById(R.id.countdown)).setText("おわり～～");
            }
        }.start();
    }


    static public class DrawView extends View {

        public DrawView(Context context) {
            super(context);
        }

        // 描画処理を記述
        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.argb(255, 255, 0, 0));

            Rect rect = new Rect(100, 200, 300, 400);
            canvas.drawRect(rect, paint);

            RectF rectF = new RectF(40.5f, 20.5f, 60.5f, 40.5f);
            canvas.drawRect(rectF, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(12);
            canvas.drawRect(10, 50, 30, 80, paint);

        }
    }


    public void onGreenButton(View v) {
        if (block[count] == 1) {
            count++;
        } else {
            ((TextView) findViewById(R.id.alert)).setText("だめ！！！！");
        }

    }

    public void onBlueButton(View v) {
        if (block[count] == 0) {
            count++;
        } else {
            ((TextView) findViewById(R.id.alert)).setText("だめ！！！！");
        }

    }

}


