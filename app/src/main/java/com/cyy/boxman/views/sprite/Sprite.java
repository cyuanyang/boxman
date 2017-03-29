package com.cyy.boxman.views.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

import com.cyy.boxman.tools.ScreenTools;

/**
 * Created by study on 17/3/29.
 *
 * 精灵类
 *
 */

public class Sprite extends View {

    private Point point; //精灵的位置

    private Paint paint;

    public Sprite(Context context) {
        super(context);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(ScreenTools.dp2px(16));
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("地"  , getWidth()/2 , getHeight()/2 , paint);
    }
}
