package me.chaoyang805.imageeditor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by chaoyang805 on 2015/8/2.
 */
public class ImageHelper {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;


    public static Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(RED, hue);
        hueMatrix.setRotate(GREEN, hue);
        hueMatrix.setRotate(BLUE, hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bm, 0, 0, paint);

        return bmp;
    }

    public static Bitmap handleImageNegative(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] oldPxs = new int[width * height];
        int[] newPxs = new int[width * height];
        bm.getPixels(oldPxs, 0, width, 0, 0, width, height);
        int tmpColor;
        int a, r, g, b;
        for (int i = 0; i < oldPxs.length; i++) {
            tmpColor = oldPxs[i];
            a = Color.alpha(tmpColor);
            r = Color.red(tmpColor);
            g = Color.green(tmpColor);
            b = Color.blue(tmpColor);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (g < 0) {
                g = 0;
            }
            if (b > 255) {
                b = 255;
            } else if (b < 0) {
                b = 0;
            }
            newPxs[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPxs, 0, width, 0, 0, width, height);
        return bmp;
    }

    public static Bitmap oldPhoto(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] oldPxs = new int[width * height];
        int[] newPxs = new int[width * height];
        bm.getPixels(oldPxs, 0, width, 0, 0, width, height);
        int tmpColor;
        int a, r, g, b;
        int r1, g1, b1;
        for (int i = 0; i < oldPxs.length; i++) {
            tmpColor = oldPxs[i];
            a = Color.alpha(tmpColor);
            r = Color.red(tmpColor);
            g = Color.green(tmpColor);
            b = Color.blue(tmpColor);

            r1 = (int) (0.393 * r + 0.769 * g + 0.189 * b);
            g1 = (int) (0.349 * r + 0.686 * g + 0.168 * b);
            b1 = (int) (0.272 * r + 0.534 * g + 0.131 * b);

            if (r1 > 255) {
                r1 = 255;
            }
            if (g1 > 255) {
                g1 = 255;
            }
            if (b1 > 255) {
                b1 = 255;
            }
            newPxs[i] = Color.argb(a, r1, g1, b1);
        }
        bmp.setPixels(newPxs, 0, width, 0, 0, width, height);
        return bmp;
    }

    public static Bitmap reliefPhoto(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] oldPxs = new int[width * height];
        int[] newPxs = new int[width * height];
        bm.getPixels(oldPxs, 0, width, 0, 0, width, height);
        int exColor, nowColor;
        int a, r, g, b;
        int r1, g1, b1;
        for (int i = 1; i < oldPxs.length; i++) {
            exColor = oldPxs[i - 1];
            a = Color.alpha(exColor);
            r = Color.red(exColor);
            g = Color.green(exColor);
            b = Color.blue(exColor);

            nowColor = oldPxs[i];
            r1 = Color.red(nowColor);
            g1 = Color.green(nowColor);
            b1 = Color.blue(nowColor);

            r = (r - r1 + 127);
            g = (g - g1 + 127);
            b = (b - b1 + 127);
            if (r > 255) {
                r = 255;
            }
            if (g > 255) {
                g = 255;
            }
            if (b > 255) {
                b = 255;
            }
            newPxs[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPxs, 0, width, 0, 0, width, height);
        return bmp;
    }
}
