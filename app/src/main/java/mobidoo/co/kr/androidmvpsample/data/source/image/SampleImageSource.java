package mobidoo.co.kr.androidmvpsample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.data.ImageItem;

/**
 * Created by xc200 on 2017-07-25.
 */

public interface SampleImageSource {

    interface LoadImageCallBack{
        void onImageLoaded(ArrayList<ImageItem> list);
    }

    void getImages(Context context,int size, LoadImageCallBack loadImageCallBack);
}
