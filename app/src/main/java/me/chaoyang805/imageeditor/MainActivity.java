package me.chaoyang805.imageeditor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setPrimaryColor(View view) {
        Intent i = new Intent(MainActivity.this, PrimaryColorActivity.class);
        startActivity(i);

    }

    public void colorMatrix(View view) {
        Intent i = new Intent(this, ColorMatrixActivity.class);
        startActivity(i);
    }

    public void imagePixels(View view) {
        Intent i = new Intent(this, ImagePixelsActivity.class);
        startActivity(i);
    }

}
