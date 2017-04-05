package com.cyy.boxman.views.sprite;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;

import com.cyy.boxman.Constants;
import com.cyy.boxman.R;

/**
 * Created by study on 17/3/15.
 *
 *  推的箱子
 */

public class Box extends Sprite {

    private final int BOX_WIDTH = Constants.boxWidth;

    private Point startPoint;//箱子的起始位置

    public Box(Context context) {
        super(context);

        setBackgroundResource(R.drawable.box);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
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
