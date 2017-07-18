package mobidoo.co.kr.androidmvpsample.presenter;

import android.content.Context;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.data.ImageItem;
import mobidoo.co.kr.androidmvpsample.data.SampleImageData;

/**
 * Created by xc200 on 2017-07-18.
 */

public interface MainContract {

    interface View {

        void addItems(ArrayList<ImageItem> items,boolean isClear);

        void notifyAdapter();
    }

    interface Presenter {

        void attachView(View view);

        void detachView();

        void setSampleImageData(SampleImageData sampleImageData);

        void loadItems(Context context, boolean isClear);
    }
}
