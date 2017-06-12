package com.littonishir.mvpdemo.contract;


import com.littonishir.mvpdemo.base.BasePresenter;
import com.littonishir.mvpdemo.base.BaseView;
import com.littonishir.mvpdemo.bean.Girl;

import java.util.List;

/**
 * Created by littonishir on 2017/6/12.
 * 契约接口
 */

public interface GirlContract {

    interface IGirlView extends BaseView<GirlPresenter> {
        //加载进度条
        void showLoading();
        //显示Girls
        void showGirls(List<Girl> girls);
        //加载完成
        void showComplete();
    }

    interface GirlPresenter extends BasePresenter {
        //绑定数据
        void bindData();
    }
}
