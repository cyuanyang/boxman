package com.cyy.boxman.tools;

import com.cyy.boxman.App;

/**
 * Created by cyy on 17/3/15.
 * 关于屏幕的工具类
 */

public class ScreenTools {

    //dp转换屏幕px
    public static int dp2px(int dpValue){
        float scale;
        try {
            scale = App.getInstance().getResources().getDisplayMetrics().density;
        } catch (Exception e) {
            return dpValue;
        }
        return (int) (dpValue * scale + 0.5f);
    }

}
