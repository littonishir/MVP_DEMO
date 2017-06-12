package com.littonishir.mvpdemo.model;


import com.littonishir.mvpdemo.bean.Girl;

import java.util.List;

/**
 * Created by littonishir on 2017/6/12.
 */

public interface IGirlModel {
    //加载数据
    void loadGirl(GirlOnLoadListener listener);
    //回调监听
    interface GirlOnLoadListener{
        void onComplete(List<Girl> girls);
    }

}
