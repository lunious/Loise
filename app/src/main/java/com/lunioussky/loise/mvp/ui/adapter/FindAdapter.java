package com.lunioussky.loise.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.lunioussky.loise.R;
import com.lunioussky.loise.mvp.model.entity.GankEntity;
import com.lunioussky.loise.mvp.ui.holder.FindHolder;

import java.util.List;

/**
 * @Author: lunious
 * @Date: 2018/5/31 15:15
 * @Description:
 */
public class FindAdapter extends BaseQuickAdapter<GankEntity.ResultsBean,FindHolder>  {

    public FindAdapter(@Nullable List<GankEntity.ResultsBean> data) {
        super(R.layout.item_girls, data);
    }

    @Override
    protected void convert(FindHolder helper, GankEntity.ResultsBean item) {
        helper.mImageLoader.loadImage(helper.mAppComponent.appManager().getCurrentActivity() == null
                        ? helper.mAppComponent.application() : helper.mAppComponent.appManager().getCurrentActivity(),
                ImageConfigImpl
                        .builder()
                        .url(item.url)
                        .imageView(helper.getView(R.id.ivImage))
                        .build());
    }
}
