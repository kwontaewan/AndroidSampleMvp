package mobidoo.co.kr.androidmvpsample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.data.ImageItem;

/**
 * Created by xc200 on 2017-07-14.
 */

public class SampleImageLocalDataSource implements SampleImageSource{

    @Override
    public void getImages(Context context, int size, LoadImageCallBack loadImageCallBack) {
        ArrayList<ImageItem> items = new ArrayList<>();

        for(int i = 0 ; i < size ; i++){
            final int random = (int) (Math.random() * 15);
            final String name = String.format("sample_%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
        }

        if(loadImageCallBack !=null )loadImageCallBack.onImageLoaded(items);
    }
}
