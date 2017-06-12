package com.littonishir.mvpdemo.presenter;

import android.os.Handler;

import com.littonishir.mvpdemo.bean.Girl;
import com.littonishir.mvpdemo.contract.GirlContract;
import com.littonishir.mvpdemo.model.GirlModelImp;
import com.littonishir.mvpdemo.model.IGirlModel;

import java.util.List;

/**
 * Created by littonishir on 2017/6/12.
 * Presenter中持有View和MOdel的接口
 */

public class GirlPresenter implements GirlContract.GirlPresenter {
    //View interface
    GirlContract.IGirlView iGirlView;

    //Model interface
    IGirlModel iGirlModel = new GirlModelImp();

    public GirlPresenter(GirlContract.IGirlView iGirlView) {
        super();
        this.iGirlView = iGirlView;
        //注意要设置Presenter不然Activity中Presenter会空指针
        iGirlView.setPresenter(this);
    }

    //bind data
    public void bindData() {
        iGirlView.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (iGirlModel != null) {
                    iGirlModel.loadGirl(new IGirlModel.GirlOnLoadListener() {
                        @Override
                        public void onComplete(List<Girl> girls) {
                            iGirlView.showComplete();
                            //传给view显示
                            iGirlView.showGirls(girls);
                        }
                    });
                }
            }
        }, 2000);


    }

    @Override
    public void start() {
        bindData();
    }
}
