package mobidoo.co.kr.androidmvpsample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import javax.inject.Inject;

import mobidoo.co.kr.androidmvpsample.data.ImageItem;

/**
 * Created by xc200 on 2017-07-25.
 */

public class SampleImageRepository implements SampleImageSource {
/*    private static SampleImageRepository sampleImageRepository;

    public static SampleImageRepository getInstance(){
        if(sampleImageRepository == null){
            sampleImageRepository = new SampleImageRepository();
        }

        return sampleImageRepository;
    }*/

    private SampleImageLocalDataSource sampleImageLocalDataSource;


    //생성자에 Inject를 선언하여 SampleImageLocalDataSource를 주입할려고하면 빌드할떄 SampleImageRepository가 저정로 인스턴스화됨
    @Inject
    public SampleImageRepository(SampleImageLocalDataSource sampleImageLocalDataSource){
        this.sampleImageLocalDataSource = sampleImageLocalDataSource;
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
