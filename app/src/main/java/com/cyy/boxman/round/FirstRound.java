package com.cyy.boxman.round;

import android.graphics.Color;
import android.graphics.Point;

import com.cyy.boxman.MainActivity;
import com.cyy.boxman.views.map.MapView;
import com.cyy.boxman.views.sprite.Ground;
import com.cyy.boxman.views.sprite.Person;
import com.cyy.boxman.views.sprite.Sprite;
import com.cyy.boxman.views.sprite.Wall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by study on 17/3/29.
 * 第一关
 */

public class FirstRound extends MainActivity {

    public static final int HORIZONTAL_NUM = 10;
    public static final int VERTICAL_NUM = 10;

    @Override
    protected void configMapView(MapView mapView) {
        super.configMapView(mapView);
        mapView.setHorizontalNumAndVertical(HORIZONTAL_NUM , VERTICAL_NUM);
    }

    @Override
    protected List<Point> initMapPoint() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(2,2));
        return points;
    }

    @Override
    protected List<Point> initTerminalPoint() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(7,7));
        return points;
    }

    @Override
    protected List<Point> initBoxSprites() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1,1));
        return points;
    }

    @Override
    protected Point getPersonPoint() {
        return new Point(5 ,5);
    }
}
