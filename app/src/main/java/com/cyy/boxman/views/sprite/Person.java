package com.cyy.boxman.views.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.cyy.boxman.tools.ScreenTools;

/**
 * Created by study on 17/3/29.
 *
 * 推箱子的人
 */

public class Person extends Sprite {

    private Paint paint;

    public Person(Context context) {
        super(context);

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(ScreenTools.dp2px(10));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("人"+getPoint().x+" "+getPoint().y  , getWidth()/2 , getHeight()/2 , paint);
    }

    public void up(){
        getPoint().offset(0 , -1);
        requestLayout();
    }

    public void down(){
        getPoint().offset(0 , 1);
        requestLayout();
    }
    public void left(){
        getPoint().offset(-1 , 0);
        requestLayout();
    }

    public void right(){
        getPoint().offset(1 , 0);
        requestLayout();
    }
}
