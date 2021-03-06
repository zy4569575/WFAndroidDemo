package com.whiskeyfei.adapter;

import android.content.Context;

import com.whiskeyfei.model.ImageModel;
import com.whiskeyfei.R;

import java.util.List;

/**
 * Created by whiskeyfei on 15-7-30.
 */
public class MeituanAdapter extends DPBasePageAdapter<ImageModel> {
    public MeituanAdapter(Context context, List<ImageModel> list, int layoutId, boolean isInfiniteLoop) {
        super(context, list, layoutId, isInfiniteLoop);
    }

    public MeituanAdapter(Context context, List<ImageModel> list, int layoutId) {
        super(context, list, layoutId);
    }

    @Override
    public void convert(DPAdapterViewHolder holder, ImageModel imageModel) {
        holder.setImageResource(R.id.meituan_imageview,imageModel.getImageId());
        holder.setText(R.id.meituan_title,imageModel.getContent());
    }

    public MeituanAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        mIsInfiniteLoop = isInfiniteLoop;
        return this;
    }

    public boolean getInfiniteLoop(){
        return mIsInfiniteLoop;
    }
}
