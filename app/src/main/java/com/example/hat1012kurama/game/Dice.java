package com.example.hat1012kurama.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Dice extends View {
    int x, y, radius;
    Paint paint;

    public Dice(Context context) {
        super(context);
        radius = 30;
        x = y = 30;
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(100,200,300,400,paint);
            }
}


