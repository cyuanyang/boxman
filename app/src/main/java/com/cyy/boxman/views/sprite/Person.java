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
        setPoint(new Point(getPoint().x , getPoint().y-1));
        requestLayout();
    }

    public void down(){
        setPoint(new Point(getPoint().x , getPoint().y+1));
        requestLayout();
    }
    public void left(){
        setPoint(new Point(getPoint().x-1 , getPoint().y));
        requestLayout();
    }

    public void right(){
        setPoint(new Point(getPoint().x+1 , getPoint().y));
        requestLayout();
    }
}
