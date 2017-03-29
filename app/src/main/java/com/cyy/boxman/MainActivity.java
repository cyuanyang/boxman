package com.cyy.boxman;

import android.app.Activity;
import android.os.Bundle;

import com.cyy.boxman.views.map.MapView;
import com.cyy.boxman.views.sprite.Sprite;

import java.util.Collections;
import java.util.List;

/**
 *
 */
public abstract class MainActivity extends Activity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.activity_main);
        initView();

        mapView.setupSprites(initSprites());
    }

    private void initView() {
        mapView = (MapView) findViewById(R.id.mapView);
        configMapView(mapView);
    }

    protected List<List<Sprite>> initSprites(){
        return Collections.emptyList();
    }

    /**
     * config map view
     * @param mapView
     */
    protected void configMapView(MapView mapView){

    }
}
