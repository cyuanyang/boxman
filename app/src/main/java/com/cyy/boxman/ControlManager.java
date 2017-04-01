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

    //移动的时候判断 下一步是不是墙
    //返回 true 确实是墙  false 不是墙
    private boolean isWall(int nextX , int nextY){
        boolean isWall = false;
        for (Point wallPoint : mapView.getWallPoint()) {
            if (wallPoint.equals(nextX ,nextY)){
                isWall = true;
                break;
            }
        }

        return isWall;
    }

    public void up(){
//        boolean isWall = false;
//        for (Point wallPoint : mapView.getWallPoint()) {
//            if (wallPoint.equals(person.getPoint().x , person.getPoint().y-1)){
//                isWall = true;
//                break;
//            }
//        }
        if (!isWall(person.getPoint().x , person.getPoint().y-1)){
            person.up();
        }else {
            Toast.makeText(App.getInstance(), "墙啊", Toast.LENGTH_SHORT).show();
        }
    }

    public void down(){
        if (!isWall(person.getPoint().x , person.getPoint().y+1)){
            person.down();
        }else {
            Toast.makeText(App.getInstance(), "墙啊", Toast.LENGTH_SHORT).show();
        }
    }

    public void left(){
        if (!isWall(person.getPoint().x-1 , person.getPoint().y)){
            person.left();
        }else {
            Toast.makeText(App.getInstance(), "墙啊", Toast.LENGTH_SHORT).show();
        }
    }

    public void right(){
        if (!isWall(person.getPoint().x + 1, person.getPoint().y)){
            person.right();
        }else {
            Toast.makeText(App.getInstance(), "墙啊", Toast.LENGTH_SHORT).show();
        }
    }

}
