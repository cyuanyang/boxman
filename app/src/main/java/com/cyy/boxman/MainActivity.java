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
    private MapView mapView;
    private ControlManager controlManager;

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.activity_main);
        initView();

        //初始化地 和 强墙
        List<Sprite> mapSprites = initSprites();
        mapView.setupMapSprites(mapSprites);

        List<Sprite> controlSprite = new ArrayList<>();
        //初始化箱子
        controlSprite.addAll(initBoxSprites());
        //初始化人物
        initPersionSprite();
        controlSprite.add(person);
        mapView.setupControlSprite(controlSprite);
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
    }

    /**
     * 初始化地图不可动资源
     *
     * @return 返回sprites
     */
    protected List<Sprite> initSprites() {
        return Collections.emptyList();
    }

    /**
     * 初始化地图移动箱子资源
     *
     * @return 返回sprites
     */
    protected List<Sprite> initBoxSprites() {
        return Collections.emptyList();
    }

    /**
     * 初始化人物
     *
     * @return
     */
    private void initPersionSprite() {
        this.person = new Person(this);
        this.person.setPoint(getPersonPoint());
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
        }
    }
}
