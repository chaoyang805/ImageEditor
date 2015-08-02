package me.chaoyang805.imageeditor;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by chaoyang805 on 2015/8/2.
 */
public class ImagePixelsActivity extends Activity {

    private ImageView image1,image2,image3,image4;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_pixels_activity);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);

        image1.setImageBitmap(mBitmap);
        image2.setImageBitmap(ImageHelper.handleImageNegative(mBitmap));
        image3.setImageBitmap(ImageHelper.oldPhoto(mBitmap));
        image4.setImageBitmap(ImageHelper.reliefPhoto(mBitmap));

    }
}
