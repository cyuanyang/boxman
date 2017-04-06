package com.cyy.boxman;

import android.graphics.Point;
import android.widget.Toast;

import com.cyy.boxman.views.map.MapView;
import com.cyy.boxman.views.sprite.Box;
import com.cyy.boxman.views.sprite.Person;
import com.cyy.boxman.views.sprite.Sprite;
import com.cyy.boxman.views.sprite.Wall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by study on 17/3/29.
 * 控制管理类
 */

public class ControlManager {

    public enum PersonAction{
        Up,
        Down,
        Left,
        Right,
    }

    private Person person;
    private MapView mapView;
    private PersonAction preAction = PersonAction.Down;

    private List<Box> boxSprite = new ArrayList<>(); //地图上的箱子
    private List<Point> terminalPoints = new ArrayList<>();//地图上的箱子的终点

    public ControlManager(MapView mapView ){
        this.mapView = mapView;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //设置箱子
    public void setBoxSprite(Box boxSprite) {
        this.boxSprite.add(boxSprite);
    }

    public void setTerminalPoints(List<Point> terminalPoints) {
        this.terminalPoints = terminalPoints;
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

    private boolean isOtherBox(int nextX , int nextY){
        boolean isBox = false;
        for (Box box : this.boxSprite) {
            if (box.getPoint().equals(nextX ,nextY)){
                isBox = true;
                break;
            }
        }
        return isBox;
    }

    /**
     * 人的下一步是否需要移动箱子
     * @return
     */
    private Box isPushBox(int nextX , int nextY){
        for (Box b : this.boxSprite) {
            if (b.getPoint().equals(nextX , nextY)){
                return b;
            }
        }
        return null;
    }

    /**
     * 根据箱子的下一步 确定箱子是否进入目的地
     * @param boxNextX box x
     * @param boxNextY box y
     * @return ""
     */
    private Boolean isEnterTerminal(int boxNextX , int boxNextY){
        for (Point tp : this.terminalPoints) {
            if (tp.equals(boxNextX, boxNextY)) {
                return true;
            }
        }
        return false;
    }

    public void up(){
        int nextX = person.getPoint().x;
        int nextY = person.getPoint().y-1;
        if (!isWall(nextX , nextY)){
            Box moveBox = isPushBox(nextX , nextY);
            if (moveBox!=null){
                //移动箱子 箱子的下一步不能是墙和其他的箱子
                int boxNextX = moveBox.getPoint().x;
                int boxNextY = moveBox.getPoint().y-1;
                if (!isWall(boxNextX , boxNextY)&&!isOtherBox(boxNextX , boxNextY)){
                    moveBox.up(isEnterTerminal(boxNextX , boxNextY));
                }else {
                    return;
                }

            }
            person.up(preAction != PersonAction.Up);
            preAction = PersonAction.Up;
        }
    }

    public void down(){
        int nextX = person.getPoint().x;
        int nextY = person.getPoint().y+1;
        if (!isWall(nextX , nextY)){
            Box moveBox = isPushBox(nextX , nextY);
            if (moveBox!=null){
                //移动箱子 箱子的下一步不能是墙和其他的箱子
                int boxNextX = moveBox.getPoint().x;
                int boxNextY = moveBox.getPoint().y+1;
                if (!isWall(boxNextX , boxNextY)&&!isOtherBox(boxNextX , boxNextY)){
                    moveBox.down(isEnterTerminal(boxNextX , boxNextY));
                }else {
                    return;
                }

            }
            person.down(preAction != PersonAction.Down);
            preAction = PersonAction.Down;
        }
    }

    public void left(){
        int nextX = person.getPoint().x-1;
        int nextY = person.getPoint().y;
        if (!isWall(nextX , nextY)){
            Box moveBox = isPushBox(nextX , nextY);
            if (moveBox!=null){
                //移动箱子 箱子的下一步不能是墙和其他的箱子
                int boxNextX = moveBox.getPoint().x-1;
                int boxNextY = moveBox.getPoint().y;
                if (!isWall(boxNextX , boxNextY)&&!isOtherBox(boxNextX , boxNextY)){
                    moveBox.left(isEnterTerminal(boxNextX , boxNextY));
                }else {
                    return;
                }

            }
            person.left(preAction != PersonAction.Left);
            preAction = PersonAction.Left;
        }
    }

    public void right(){
        int nextX = person.getPoint().x+1;
        int nextY = person.getPoint().y;
        if (!isWall(person.getPoint().x + 1, person.getPoint().y)){
            Box moveBox = isPushBox(nextX , nextY);
            if (moveBox!=null){
                //移动箱子 箱子的下一步不能是墙和其他的箱子
                int boxNextX = moveBox.getPoint().x+1;
                int boxNextY = moveBox.getPoint().y;
                if (!isWall(boxNextX , boxNextY)&&!isOtherBox(boxNextX , boxNextY)){
                    moveBox.right(isEnterTerminal(boxNextX , boxNextY));
                }else {
                    return;
                }

            }
            person.right(preAction != PersonAction.Right);
            preAction = PersonAction.Right;
        }
    }

}
