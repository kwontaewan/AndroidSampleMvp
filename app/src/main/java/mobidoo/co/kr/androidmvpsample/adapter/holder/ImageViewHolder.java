package mobidoo.co.kr.androidmvpsample.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobidoo.co.kr.androidmvpsample.R;
import mobidoo.co.kr.androidmvpsample.adapter.OnItemClickListener;
import mobidoo.co.kr.androidmvpsample.data.ImageItem;
import mobidoo.co.kr.androidmvpsample.utill.ImageAsync;

/**
 * Created by xc200 on 2017-07-18.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder{

    private Context context;

    private OnItemClickListener onItemClickListener;

    @BindView(R.id.img_view) ImageView imageView;

    public ImageViewHolder(Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;

        ButterKnife.bind(this, itemView);
    }

    public void onBind(ImageItem item, final int position){

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(position); //presenter로 callback할꺼임 왜냐면 view가 아닌 presenter에서 터치 이벤트를 받을꺼니깐..
                }
            }
        });

        new ImageAsync(context,imageView).execute(item.getImageRes());
    }


}
