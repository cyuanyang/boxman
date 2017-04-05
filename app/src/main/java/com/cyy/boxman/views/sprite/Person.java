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

    public void up(boolean change){
        getPoint().offset(0 , -1);
        requestLayout();
        if (change){
            this.setBackgroundResource(R.drawable.p_back);
        }
    }

    public void down(boolean change){
        getPoint().offset(0 , 1);
        requestLayout();
        if (change){
            this.setBackgroundResource(R.drawable.p_forward);
        }
    }
    public void left(boolean change){
        getPoint().offset(-1 , 0);
        requestLayout();
        if (change){
            this.setBackgroundResource(R.drawable.p_left);
        }
    }

    public void right(boolean change){
        getPoint().offset(1 , 0);
        requestLayout();
        if (change){
            this.setBackgroundResource(R.drawable.p_right);
        }
    }
}
