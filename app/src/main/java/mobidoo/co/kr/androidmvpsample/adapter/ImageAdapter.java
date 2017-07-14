package mobidoo.co.kr.androidmvpsample.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobidoo.co.kr.androidmvpsample.R;
import mobidoo.co.kr.androidmvpsample.data.ImageItem;

/**
 * Created by xc200 on 2017-07-14.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;

    private ArrayList<ImageItem> mImageItems;

    public ImageAdapter(Context context){
        mContext = context;
    }

    public void setImageItems(ArrayList<ImageItem> imageItems){
        mImageItems = imageItems;
    }

    public void clear(){
        if(mImageItems != null){
            mImageItems.clear();
            mImageItems = null;
        }
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_image,parent,false));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        if(holder == null)return;

        final ImageItem imageItem = mImageItems.get(position);
        new ImageAsync(holder.imageView).execute(imageItem.getImageRes());
    }

    @Override
    public int getItemCount() {
        return mImageItems!=null ? mImageItems.size() : 0;
    }

    private class ImageAsync extends AsyncTask<Integer,Void,Bitmap> { //이미지 리사이즈를 위해 나중에 Glide 쓰면 이거 안써두됨
        private final WeakReference<ImageView> imageViewWeakReference; //약한 객체로 설정해야 화면넘어갈떄 ImageView 가 GC 처리됨

        ImageAsync(ImageView imageView){imageViewWeakReference = new WeakReference<ImageView>(imageView);}

        @Override
        protected Bitmap doInBackground(Integer... params) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            return BitmapFactory.decodeResource(mContext.getResources(),params[0],options);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imageViewWeakReference.get().setImageResource(0);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageViewWeakReference.get().setImageBitmap(bitmap);
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_view)
        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
