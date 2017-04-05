package com.cyy.boxman;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cyy.boxman.views.map.MapView;
import com.cyy.boxman.views.sprite.Person;
import com.cyy.boxman.views.sprite.Sprite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public abstract class MainActivity extends Activity implements View.OnClickListener {

    protected Button upBtn;
    protected Button downBtn;
    protected Button leftBtn;
    protected Button rightBtn;
    private MapView mapView;
    private ControlManager controlManager;

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.activity_main);
        initView();

        mapView.setupMapSprites();
        mapView.setupWallAndTermail(initMapPoint() , initTerminalPoint());

        initControlSprite();

        //初始化移动控制
        controlManager = new ControlManager(mapView, person);
    }

    private void initView() {
        mapView = (MapView) findViewById(R.id.mapView);
        configMapView(mapView);
        upBtn = (Button) findViewById(R.id.upBtn);
        upBtn.setOnClickListener(MainActivity.this);
        downBtn = (Button) findViewById(R.id.downBtn);
        downBtn.setOnClickListener(MainActivity.this);
        leftBtn = (Button) findViewById(R.id.leftBtn);
        leftBtn.setOnClickListener(MainActivity.this);
        rightBtn = (Button) findViewById(R.id.rightBtn);
        rightBtn.setOnClickListener(MainActivity.this);
    }

    /**
     * 初始化地图墙的资源
     *
     * @return 返回Points
     */
    protected List<Point> initMapPoint() {
        return Collections.emptyList();
    }

    /**
     * 初始化 箱子目的地 points
     * @return points
     */
    protected List<Point> initTerminalPoint(){
        return Collections.emptyList();
    }

    //初始化可移动资源
    private void initControlSprite(){
        List<Sprite> controlSprite = new ArrayList<>();
        //初始化箱子
        List<Point> boxPoints = initBoxSprites();
        for (Point p : boxPoints){
            controlSprite.add(mapView.makeBoxWithPoint(p));
        }
        //初始化人物
        this.person = mapView.makePersonWithPoint(getPersonPoint());
        controlSprite.add(person);
        mapView.setupControlSprite(controlSprite);
    }

    /**
     * 初始化地图移动箱子资源
     *
     * @return 返回sprites
     */
    protected List<Point> initBoxSprites() {
        return Collections.emptyList();
    }

    protected Point getPersonPoint() {
        return new Point(0, 0);
    }

    /**
     * config map view
     *
     * @param mapView
     */
    protected void configMapView(MapView mapView) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.upBtn) {
            controlManager.up();
        } else if (view.getId() == R.id.downBtn) {
            controlManager.down();
        } else if (view.getId() == R.id.leftBtn) {
            controlManager.left();
        } else if (view.getId() == R.id.rightBtn) {
            controlManager.right();
        }
    }
}
