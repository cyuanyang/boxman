package com.cyy.boxman.views.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.cyy.boxman.R;
import com.cyy.boxman.tools.ScreenTools;

/**
 * Created by study on 17/3/29.
 *
 * 推箱子的人
 */

public class Person extends Sprite {


    public Person(Context context) {
        super(context);

        setBackgroundResource(R.drawable.p_forward);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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
