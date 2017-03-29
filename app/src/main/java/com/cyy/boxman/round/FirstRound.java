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

    @Override
    protected void configMapView(MapView mapView) {
        super.configMapView(mapView);

    }

    @Override
    protected List<Sprite> initSprites() {
        List<Sprite> spriteList = new ArrayList<>(
                MapView.DEFAULT_VERTICAL_NUM*MapView.DEFAULT_HORIZONTAL_NUM);

        //这里可优化
        for (int i = 0; i < MapView.DEFAULT_VERTICAL_NUM; i++) {

            for (int j = 0; j < MapView.DEFAULT_HORIZONTAL_NUM; j++) {
                if (j == 0){
                    Wall wall = new Wall(this);
                    wall.setPoint(new Point(i , j));
                    wall.setBackgroundColor(Color.RED);
                    spriteList.add(wall);
                }else {
                    Ground ground = new Ground(this);
                    ground.setPoint(new Point(i , j));
                    ground.setBackgroundColor(Color.WHITE);
                    spriteList.add(ground);
                }
            }
        }
        return spriteList;
    }

    @Override
    protected Point getPersonPoint() {
        return new Point(5 ,5);
    }
}
