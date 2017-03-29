package com.cyy.boxman;

import android.graphics.Point;
import android.widget.Toast;

import com.cyy.boxman.views.map.MapView;
import com.cyy.boxman.views.sprite.Person;

/**
 * Created by study on 17/3/29.
 * 控制管理类
 */

public class ControlManager {

    private Person person;
    private MapView mapView;

    public ControlManager(MapView mapView , Person person){
        this.person = person;
        this.mapView = mapView;
    }

    public void up(){
        boolean isWall = false;
        for (Point wallPoint : mapView.getWallPoint()) {
            if (wallPoint.equals(person.getPoint().x , person.getPoint().y-1)){
                isWall = true;
                break;
            }
        }
        if (!isWall){
            person.up();
        }else {
            Toast.makeText(App.getInstance(), "墙啊", Toast.LENGTH_SHORT).show();
        }
    }

    public void down(){
        person.down();
    }

    public void left(){
        person.left();
    }

    public void right(){
        person.right();
    }

}
