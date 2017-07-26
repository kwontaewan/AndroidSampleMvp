package mobidoo.co.kr.androidmvpsample.view.main.di;

import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import mobidoo.co.kr.androidmvpsample.adapter.ImageAdapter;
import mobidoo.co.kr.androidmvpsample.data.source.image.SampleImageLocalDataSource;
import mobidoo.co.kr.androidmvpsample.utill.ActivityScope;
import mobidoo.co.kr.androidmvpsample.view.main.MainActivity;
import mobidoo.co.kr.androidmvpsample.view.main.presenter.MainContract;

/**
 * Created by xc200 on 2017-07-26.
 */

@Module
public class MainActivityModule {

    private MainContract.View mView;
    private MainActivity mainActivity;
    public MainActivityModule(MainContract.View view,MainActivity mainActivity){
        this.mView = view;
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainContract.View provideMainContractView(){
        return mView;
    }

    @Provides
    @ActivityScope
    SampleImageLocalDataSource provideSampleImageLocalDataSource(){
        return new SampleImageLocalDataSource();
    }

    @Provides
    @ActivityScope
    ImageAdapter provideImageAdapter(){
        return new ImageAdapter(mainActivity);
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(){
        return new LinearLayoutManager(mainActivity);
    }



}
