package com.littonishir.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.littonishir.mvpdemo.R;
import com.littonishir.mvpdemo.adapter.GirlAdapter;
import com.littonishir.mvpdemo.bean.Girl;
import com.littonishir.mvpdemo.contract.GirlContract;
import com.littonishir.mvpdemo.presenter.GirlPresenter;

import java.util.List;

/**
 * Created by littonishir on 2017/6/12.
 */

public class MainActivity extends AppCompatActivity implements GirlContract.IGirlView {

    private RecyclerView rv;
    private GirlContract.GirlPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);
        new GirlPresenter(this);
        //中间者
        presenter.start();
    }


    @Override
    public void showLoading() {
        Toast.makeText(this, "努力加载中...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showComplete() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showGirls(List<Girl> girls) {

        //多行多列的展示模式
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(new GirlAdapter(girls));
    }

    @Override
    public void setPresenter(GirlContract.GirlPresenter presenter) {
        this.presenter = presenter;
    }
}
