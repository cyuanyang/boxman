package com.cyy.boxman.views.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.cyy.boxman.views.sprite.Sprite;

import java.util.List;

/**
 * 地图View
 */
public class MapView extends ViewGroup{

    public static final int DEFAULT_HORIZONTAL_NUM = 10;
    public static final int DEFAULT_VERTICAL_NUM = 10;

    private int horizontalNum = DEFAULT_HORIZONTAL_NUM; //地图上水平方向墙的数量
    private int verticalNum = DEFAULT_VERTICAL_NUM;//地图上垂直方向墙的数量

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), widthMeasureSpec));

        int count = getChildCount();
        for (int i = 0; i < count; i++) {

            //计算精灵的宽高
            int mapViewWidth  = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
            View child = getChildAt(i);
            final int childWidthMeasureSpec = getChildMeasureSpec(mapViewWidth/horizontalNum);
            child.measure(childWidthMeasureSpec , childWidthMeasureSpec);

        }
    }

    private int getChildMeasureSpec(int childDimension){
        return MeasureSpec.makeMeasureSpec(childDimension , MeasureSpec.EXACTLY);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        for (int i = 0; i < getChildCount(); i++) {
            Sprite sprite = (Sprite) getChildAt(i);
            int childWidth = sprite.getMeasuredWidth();
            int childHeight = sprite.getMeasuredHeight();

            int pointX = sprite.getPoint().x;
            int pointY = sprite.getPoint().y;

            int l = pointX*childWidth;
            int t = pointY*childHeight;
            //计算每一个精灵应该在的位置
            sprite.layout(l , t , l + childWidth , t + childHeight);
        }
    }

    public void setupSprites(List<List<Sprite>> spriteList){
        for (List<Sprite> sprites : spriteList){
            for (Sprite sprite : sprites) {
                addView(sprite);
            }
        }
    }

    /**
     * 设置竖直和水平方向上墙的数量
     * @param horizontalNum
     * @param verticalNum
     */
    public void setHorizontalNumAndVertical(int horizontalNum , int verticalNum){
        this.verticalNum = verticalNum;
        this.horizontalNum = horizontalNum;
    }

    public int getHorizontalNum() {
        return horizontalNum;
    }

    public int getVerticalNum() {
        return verticalNum;
    }
}
