package com.cyy.boxman.views;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

import com.cyy.boxman.Constants;

/**
 * Created by study on 17/3/15.
 *
 * 箱子View
 */

public class Box extends View {

    private final int BOX_WIDTH = Constants.boxWidth;

    private Point startPoint;//箱子的起始位置

    public Box(Context context) {
        super(context);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


    }
}
