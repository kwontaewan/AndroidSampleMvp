package mobidoo.co.kr.androidmvpsample.adapter.contract;

import java.util.ArrayList;

import mobidoo.co.kr.androidmvpsample.adapter.OnItemClickListener;
import mobidoo.co.kr.androidmvpsample.data.ImageItem;

/**
 * Created by xc200 on 2017-07-18.
 */

public interface ImageAdapterContract {

    interface View {

        void setOnClickListener(OnItemClickListener clickListener);

        void notifyAdapter();

    }

    interface Model {

        void addItems(ArrayList<ImageItem> imageItems);

        void clearItems();

        ImageItem getItem(int position);
    }
}
