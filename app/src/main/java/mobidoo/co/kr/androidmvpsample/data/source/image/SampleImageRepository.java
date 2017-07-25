package mobidoo.co.kr.androidmvpsample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.data.ImageItem;

/**
 * Created by xc200 on 2017-07-25.
 */

public class SampleImageRepository implements SampleImageSource {
    private static SampleImageRepository sampleImageRepository;

    public static SampleImageRepository getInstance(){
        if(sampleImageRepository == null){
            sampleImageRepository = new SampleImageRepository();
        }

        return sampleImageRepository;
    }

    private SampleImageLocalDataSource sampleImageLocalDataSource;

    private SampleImageRepository(){
        sampleImageLocalDataSource = new SampleImageLocalDataSource();
    }

    @Override
    public void getImages(Context context, int size, final LoadImageCallBack loadImageCallBack) {
        sampleImageLocalDataSource.getImages(context, size, new LoadImageCallBack() {
            @Override
            public void onImageLoaded(ArrayList<ImageItem> list) {
                if(loadImageCallBack != null){
                    loadImageCallBack.onImageLoaded(list);
                }
            }
        });
    }
}
