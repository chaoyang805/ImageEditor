package me.chaoyang805.imageeditor;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by chaoyang805 on 2015/8/2.
 */
public class PrimaryColorActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;
    private SeekBar mSeekbarHue;
    private SeekBar mSeekbarSaturation;
    private SeekBar mSeekbarLum;

    private float mHue,mSaturation,mLum;

    private static final int MAX_VALUE = 255;
    private static final int MID_VALUE = 127;

    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primary_color);
        initViews();
        initEvents();
    }

    private void initEvents() {
        mSeekbarHue.setMax(MAX_VALUE);
        mSeekbarSaturation.setMax(MAX_VALUE);
        mSeekbarLum.setMax(MAX_VALUE);

        mSeekbarHue.setProgress(MID_VALUE);
        mSeekbarSaturation.setProgress(MID_VALUE);
        mSeekbarLum.setProgress(MID_VALUE);


    }

    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.imageview);
        mSeekbarHue = (SeekBar) findViewById(R.id.seekbar_hue);
        mSeekbarSaturation = (SeekBar) findViewById(R.id.seekbar_saturation);
        mSeekbarLum = (SeekBar) findViewById(R.id.seekbar_lum);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test3);
        mImageView.setImageBitmap(bitmap);

        mSeekbarHue.setOnSeekBarChangeListener(this);
        mSeekbarSaturation.setOnSeekBarChangeListener(this);
        mSeekbarLum.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbar_hue:
                mHue = (progress - MID_VALUE) * 1.0f / MID_VALUE * 180;
                break;
            case R.id.seekbar_saturation:
                mSaturation = progress * 1.0f / MID_VALUE;
                break;
            case R.id.seekbar_lum:
                mLum = progress * 1.0f / MID_VALUE;
                break;
        }

        mImageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap, mHue, mSaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
