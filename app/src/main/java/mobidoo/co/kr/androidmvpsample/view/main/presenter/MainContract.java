package mobidoo.co.kr.androidmvpsample.view.main.presenter;

import android.content.Context;

import mobidoo.co.kr.androidmvpsample.adapter.contract.ImageAdapterContract;
import mobidoo.co.kr.androidmvpsample.data.source.image.SampleImageRepository;

/**
 * Created by xc200 on 2017-07-18.
 */

public interface MainContract {

    interface View {
        void showToast(String title);
    }

    interface Presenter {

        //void attachView(View view);

        void detachView();

        void setSampleImageData(SampleImageRepository sampleImageData);

        void setImageAdapterModel(ImageAdapterContract.Model adapterModel);

        void setImageAdapterView(ImageAdapterContract.View imageAdapterView);

        void loadItems(Context context, boolean isClear);
    }
}
