package mobidoo.co.kr.androidmvpsample.presenter;

import android.content.Context;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.data.ImageItem;
import mobidoo.co.kr.androidmvpsample.data.SampleImageData;

/**
 * Created by xc200 on 2017-07-18.
 */

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;

    private SampleImageData sampleImageData;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setSampleImageData(SampleImageData sampleImageData) {
        this.sampleImageData = sampleImageData;
    }

    @Override
    public void loadItems(Context context, boolean isClear) {
        ArrayList<ImageItem> items = sampleImageData.getImages(context,10);
        view.addItems(items,isClear);
        view.notifyAdapter();
    }
}
