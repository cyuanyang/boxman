package com.cyy.boxman;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.ViewGroup;

/**
 * Created by cyy on 17/3/15.
 *
 */

public class BaseActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMap();
    }

    //初始化地图
    private void initMap(){
//        mapView = new MapView(this);
//        ViewGroup.LayoutParams lp = new ActionBar.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT);
//        mapView.setLayoutParams(lp);
//        setContentView(mapView);
//
//        mapView.setBackgroundColor(Color.RED);
    }
}
