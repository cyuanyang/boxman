package com.cyy.boxman;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.ViewGroup;

import com.cyy.boxman.views.MapView;

/**
 * Created by cyy on 17/3/15.
 *
 */

public class BaseActivity extends Activity {

    protected MapView mapView; //主要的地图场景

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initMap();
    }

    //初始化地图
    private void initMap(){
        mapView = new MapView(this);
        ViewGroup.LayoutParams lp = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT);
        mapView.setLayoutParams(lp);
        setContentView(mapView);

        mapView.setBackgroundColor(Color.RED);
    }
}
