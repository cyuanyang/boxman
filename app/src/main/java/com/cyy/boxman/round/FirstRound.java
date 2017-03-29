package com.cyy.boxman.round;

import android.graphics.Color;
import android.graphics.Point;

import com.cyy.boxman.MainActivity;
import com.cyy.boxman.views.map.MapView;
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
    protected List<List<Sprite>> initSprites() {
        List<List<Sprite>> spriteList = new ArrayList<>(
                MapView.DEFAULT_VERTICAL_NUM*MapView.DEFAULT_HORIZONTAL_NUM);

        for (int i = 0; i < MapView.DEFAULT_VERTICAL_NUM; i++) {

            List<Sprite> sprites = new ArrayList<>(MapView.DEFAULT_VERTICAL_NUM);
            for (int j = 0; j < MapView.DEFAULT_HORIZONTAL_NUM; j++) {
                if (j == 0){
                    Wall wall = new Wall(this);
                    wall.setPoint(new Point(i , j));
                    wall.setBackgroundColor(Color.RED);
                    sprites.add(wall);
                }else {
                    Sprite sprite = new Sprite(this);
                    sprite.setPoint(new Point(i , j));
                    sprite.setBackgroundColor(Color.WHITE);
                    sprites.add(sprite);
                }
            }
            spriteList.add(sprites);
        }
        
        return spriteList;
    }
}
