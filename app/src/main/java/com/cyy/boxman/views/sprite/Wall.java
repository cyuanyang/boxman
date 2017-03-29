package com.cyy.boxman.views.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.cyy.boxman.R;
import com.cyy.boxman.tools.ScreenTools;

/**
 * Created by cyy on 17/3/15.
 * 障碍物 墙
 */

public class Wall extends Sprite {

    private Paint paint;

    public Wall(Context context) {
        super(context);
        this.setBackgroundResource(R.color.wall_color);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(ScreenTools.dp2px(16));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("墙"  , getWidth()/2 , getHeight()/2 , paint);
    }
}
