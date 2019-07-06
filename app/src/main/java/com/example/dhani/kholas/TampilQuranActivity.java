package com.example.dhani.kholas;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TampilQuranActivity extends AppCompatActivity {

    int posisi;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tampil_quran);
        ImageView tampil = findViewById(R.id.tampil_quran);

        posisi = this.getIntent().getIntExtra("posisi",0);
        setImageQuran(posisi+1);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setImageQuran(int page){
        AssetManager assetManager = getAssets();
        ImageView imageView = (ImageView) findViewById(R.id.tampil_quran);
        try (
                //declaration of inputStream in try-with-resources statement will automatically close inputStream
                // ==> no explicit inputStream.close() in additional block finally {...} necessary
                InputStream inputStream = assetManager.open("pages/page00"+page+".png")
        ) {
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);
        } catch (IOException ex) {
            //ignored
        }
    }
}
