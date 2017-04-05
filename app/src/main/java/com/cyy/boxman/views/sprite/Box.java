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
}
