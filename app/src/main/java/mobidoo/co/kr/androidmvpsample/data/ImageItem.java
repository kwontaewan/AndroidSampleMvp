package mobidoo.co.kr.androidmvpsample.data;

/**
 * Created by xc200 on 2017-07-14.
 */

public class ImageItem {
    private int imageRes;
    private String title;

    public ImageItem(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getTitle() {
        return title;
    }
}
