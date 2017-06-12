package com.littonishir.mvpdemo.model;


import com.littonishir.mvpdemo.R;
import com.littonishir.mvpdemo.bean.Girl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by littonishir on 2017/6/12.
 */

public class GirlModelImp implements IGirlModel {


    @Override
    public void loadGirl(GirlOnLoadListener listener) {
        List<Girl> data = new ArrayList<>();
        data.add(new Girl(R.mipmap.a,"唇不点而含丹 眉不画而横翠","染指指数:10分"));
        data.add(new Girl(R.mipmap.b,"粉面含春威不露,丹唇未启笑先闻","染指指数:10分"));
        data.add(new Girl(R.mipmap.c,"从此丹唇并皓齿","染指指数:10分"));
        data.add(new Girl(R.mipmap.d,"媚眼含羞合 丹唇逐笑开","染指指数:10分"));
        data.add(new Girl(R.mipmap.e,"风卷葡萄带 日照石榴裙","染指指数:10分"));
        data.add(new Girl(R.mipmap.f,"走来窗下笑相扶 爱道画眉深浅","染指指数:10分"));
        //回调
        listener.onComplete(data);
    }
}
