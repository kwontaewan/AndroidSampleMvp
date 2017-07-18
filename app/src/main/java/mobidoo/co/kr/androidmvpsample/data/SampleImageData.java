package mobidoo.co.kr.androidmvpsample.data;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by xc200 on 2017-07-14.
 */

public class SampleImageData {

    private SampleImageData() {
    }

    private static SampleImageData sampleImageData;

    public static SampleImageData getInstance(){
        if(sampleImageData == null){
            sampleImageData = new SampleImageData();
        }
        return sampleImageData;
    }

    public ArrayList<ImageItem> getImages(Context context,int size){
        ArrayList<ImageItem> items = new ArrayList<>();

        for(int i = 0 ; i < size ; i++){
            final int random = (int) (Math.random() * 15);
            final String name = String.format("sample_%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
        }

        return items;
    }
}
