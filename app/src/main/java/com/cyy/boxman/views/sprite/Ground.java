package com.cyy.boxman.views.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.cyy.boxman.tools.ScreenTools;

/**
 * Created by study on 17/3/29.
 *
 *
 */

public class Ground extends Sprite {

    private Paint paint;

    public Ground(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(ScreenTools.dp2px(8));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("地"+getPoint().x+" "+getPoint().y , getWidth()/2 , getHeight()/2 , paint);
    }
}
