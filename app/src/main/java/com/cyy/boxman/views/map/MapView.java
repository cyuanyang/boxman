package com.cyy.boxman.views.map;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.cyy.boxman.views.sprite.Sprite;
import com.cyy.boxman.views.sprite.Wall;

import java.util.ArrayList;
import java.util.List;

/**
 * 地图View
 *
 * 说明 ：
 * 地图分为上下两层
 * 下层是地图上不能移动的资源 墙 地 推箱子的目的地
 * 上层为地图上可移动的资源 背景颜色为透明  推箱子的人 箱子
 */
public class MapView extends ViewGroup{

    public static final int DEFAULT_HORIZONTAL_NUM = 10;
    public static final int DEFAULT_VERTICAL_NUM = 10;

    private int horizontalNum = DEFAULT_HORIZONTAL_NUM; //地图上水平方向墙的数量
    private int verticalNum = DEFAULT_VERTICAL_NUM;//地图上垂直方向墙的数量

    private MapView controlMapView; //地图上可以移动的图层

    private List<Point> wallPoint = new ArrayList<>(); //地图上墙的位置 作用是做人与墙的碰撞检测

    public MapView(Context context) {
        super(context);
        initMapView(null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMapView(attrs);
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initMapView(attrs);
    }

    private void initMapView(AttributeSet attrs){
        if (attrs!=null){

        }
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
            if (child instanceof Sprite){
                final int childWidthMeasureSpec = getChildMeasureSpec(mapViewWidth/horizontalNum);
                child.measure(childWidthMeasureSpec , childWidthMeasureSpec);
            }else {
                //计算控制层的背景的大小
                child.measure(widthMeasureSpec , heightMeasureSpec);
            }
        }
    }

    private int getChildMeasureSpec(int childDimension){
        return MeasureSpec.makeMeasureSpec(childDimension , MeasureSpec.EXACTLY);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof Sprite){
                Sprite sprite = (Sprite) getChildAt(i);
                int childWidth = sprite.getMeasuredWidth();
                int childHeight = sprite.getMeasuredHeight();

                int pointX = sprite.getPoint().x;
                int pointY = sprite.getPoint().y;

                int l = pointX*childWidth;
                int t = pointY*childHeight;
                //计算每一个精灵应该在的位置
                sprite.layout(l , t , l + childWidth , t + childHeight);
            }else {
                //布局控制层背景在的位置
                getChildAt(i).layout(left , top , right , bottom);
            }
        }
    }

    /**
     * 初始化地图资源
     * @param spriteList 地图底图的资源 墙 地 推箱子的目的地
     */
    public void setupMapSprites(List<Sprite> spriteList){
        wallPoint.clear();
        for (Sprite sprite : spriteList){
            if (sprite instanceof Wall){
                wallPoint.add(sprite.getPoint());
            }
            addView(sprite);
        }
    }

    /**
     * 初始化游戏控制的资源 例如推箱子的人 推的箱子
     * @param spriteList
     */
    public void setupControlSprite(List<Sprite> spriteList){
        if (controlMapView == null){
            controlMapView = new MapView(this.getContext());
            controlMapView.setBackgroundColor(Color.TRANSPARENT);
            addView(controlMapView);
        }

        for (Sprite sprite : spriteList) {
            controlMapView.addView(sprite);
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

    public MapView getControlMapView() {
        return controlMapView;
    }

    public List<Point> getWallPoint() {
        return wallPoint;
    }
}
