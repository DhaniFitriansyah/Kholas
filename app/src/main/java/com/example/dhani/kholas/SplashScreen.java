package com.example.dhani.kholas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


/*import com.easyandroidanimations.library.BounceAnimation;*/
import com.wang.avi.AVLoadingIndicatorView;

public class SplashScreen extends AppCompatActivity {

    private LinearLayout lv_loading;
    private AVLoadingIndicatorView avi;
boolean MY_PERMISSIONS_REQUEST_READ_CONTACTS=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        lv_loading = (LinearLayout) findViewById(R.id.lv_loading);

        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator("BallClipRotateMultipleIndicator");
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Here, thisActivity is the current activity
               /* if (ContextCompat.checkSelfPermission(SplashScreen.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)) {

                        // Show an expanation to the user *asynchronously* -- don't block
                        // this thread waiting for the user's response! After the user
                        // sees the explanation, try again to request the permission.

                    } else {

                        // No explanation needed, we can request the permission.

                        //ActivityCompat.requestPermissions(SplashScreen.this,
                          //      new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            //    MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    }
                }*/
                //setelah loading maka akan langsung berpindah ke Welcome activity activity
                Intent home=new Intent(SplashScreen.this, WelcomeActivity.class);
                startActivity(home);
                finish();

            }
        },2000);

    }

}
