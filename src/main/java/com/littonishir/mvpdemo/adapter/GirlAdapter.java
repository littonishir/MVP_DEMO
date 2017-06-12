package com.littonishir.mvpdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.littonishir.mvpdemo.R;
import com.littonishir.mvpdemo.bean.Girl;

import java.util.List;

/**
 * Created by littonishir on 2017/6/12.
 */

public class GirlAdapter extends RecyclerView.Adapter< GirlHolder> {

    private final List<Girl> list;

    public GirlAdapter(List<Girl> girls) {
        this.list = girls;
    }

    @Override
    public  GirlHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局的两种方法(共三种这里不深究第三种)
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        //View itemView = View.inflate(parent.getContext(), R.layout.item_viewpager, null);
        return new  GirlHolder(itemView);
    }

    @Override
    public void onBindViewHolder( GirlHolder holder, int position) {
        holder.tv_detail.setText(list.get(position).detail);
        holder.tv_star.setText(list.get(position).star);
        holder.iv_girl.setImageResource(list.get(position).icon);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

//继承 RecyclerView.ViewHolder类型
class GirlHolder extends RecyclerView.ViewHolder {
    TextView tv_detail;
    ImageView iv_girl;
    TextView tv_star;
    public  GirlHolder(View itemView) {
        super(itemView);
        tv_detail = (TextView) itemView.findViewById(R.id.tv_detail);
        iv_girl = (ImageView) itemView.findViewById(R.id.iv_girl);
        tv_star = (TextView) itemView.findViewById(R.id.tv_star);
    }
}