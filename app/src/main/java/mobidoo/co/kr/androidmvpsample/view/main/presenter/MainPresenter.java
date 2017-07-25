package mobidoo.co.kr.androidmvpsample.view.main.presenter;

import android.content.Context;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.adapter.OnItemClickListener;
import mobidoo.co.kr.androidmvpsample.adapter.contract.ImageAdapterContract;
import mobidoo.co.kr.androidmvpsample.data.ImageItem;
import mobidoo.co.kr.androidmvpsample.data.source.image.SampleImageRepository;
import mobidoo.co.kr.androidmvpsample.data.source.image.SampleImageSource;

/**
 * Created by xc200 on 2017-07-18.
 */

public class MainPresenter implements MainContract.Presenter, OnItemClickListener{

    private MainContract.View view;

    private ImageAdapterContract.Model adapterModel;
    private ImageAdapterContract.View adapterView;

    private SampleImageRepository sampleImageData;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setSampleImageData(SampleImageRepository sampleImageData) {
        this.sampleImageData = sampleImageData;
    }


    @Override
    public void setImageAdapterModel(ImageAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setImageAdapterView(ImageAdapterContract.View adapterView) {
        this.adapterView = adapterView;
        this.adapterView.setOnClickListener(this);
    }

    @Override
    public void loadItems(Context context, final boolean isClear) {
        sampleImageData.getImages(context, 10, new SampleImageSource.LoadImageCallBack() {
            @Override
            public void onImageLoaded(ArrayList<ImageItem> list) {
                if(list != null){
                    if(isClear){
                        adapterModel.clearItems();
                    }
                }

                adapterModel.addItems(list);
                adapterView.notifyAdapter();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        ImageItem imageItem = adapterModel.getItem(position);
        view.showToast(imageItem.getTitle());
    }
}
