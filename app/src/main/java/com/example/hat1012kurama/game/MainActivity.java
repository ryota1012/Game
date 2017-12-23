package com.example.hat1012kurama.game;


import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountDownTimer countDownTimer = new CountDownTimer(10000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                ((TextView)findViewById(R.id.countdown)).setText("あと"+millisUntilFinished+"秒");
                ((TextView)findViewById(R.id.count)).setText(+count+"回");

            }

            @Override
            public void onFinish() {
                ((TextView)findViewById(R.id.countdown)).setText("おわり～～");
            }
        }.start();


    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                count++;
                break;
        }
        return super.onTouchEvent(event);
    }
}
