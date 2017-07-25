package mobidoo.co.kr.androidmvpsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.adapter.contract.ImageAdapterContract;
import mobidoo.co.kr.androidmvpsample.adapter.holder.ImageViewHolder;
import mobidoo.co.kr.androidmvpsample.data.ImageItem;

/**
 * Created by xc200 on 2017-07-14.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements ImageAdapterContract.Model, ImageAdapterContract.View{

    private Context mContext;
    private OnItemClickListener onItemClickListener;

    private ArrayList<ImageItem> mImageItems;

    public ImageAdapter(Context context){
        mContext = context;
    }



    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(mContext,parent,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        if(holder == null)return;
        holder.onBind(mImageItems.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mImageItems!=null ? mImageItems.size() : 0;
    }

    @Override
    public void setOnClickListener(OnItemClickListener clickListener) {
        this.onItemClickListener = clickListener;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItems(ArrayList<ImageItem> imageItems) {
        mImageItems = imageItems;
    }

    @Override
    public void clearItems() {
        if(mImageItems != null){
            mImageItems.clear();
        }
    }

    @Override
    public ImageItem getItem(int position) {
        return mImageItems.get(position);
    }
}
