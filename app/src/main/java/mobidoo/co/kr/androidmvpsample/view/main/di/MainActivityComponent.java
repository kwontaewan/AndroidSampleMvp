package mobidoo.co.kr.androidmvpsample.view.main.di;

import dagger.Component;
import mobidoo.co.kr.androidmvpsample.utill.ActivityScope;
import mobidoo.co.kr.androidmvpsample.view.main.MainActivity;

/**
 * Created by xc200 on 2017-07-26.
 */

@ActivityScope
@Component(modules = {MainActivityModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
