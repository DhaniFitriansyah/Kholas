package com.example.dhani.kholas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dhani.kholas.adapter.TabFragmentPagerAdapter;
import com.example.dhani.kholas.fragmen.Surat;

public class MainActivity extends AppCompatActivity {
    
        private Toolbar toolbar;
        private ViewPager pager;
        private TabLayout tabs;
        TextView tampiltarget;
        Button button;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Menampilkan SLider
            /*findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PrefManager prefManager = new PrefManager(getApplicationContext());
                    prefManager.setFirstTimeLaunch(true);
                    startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                    finish();
                }
            });*/
            //Menampilkan target
            String tampil_target;

            tampiltarget = (TextView) findViewById(R.id.tampil_target);
            Intent intents = getIntent();
            tampil_target = intents.getStringExtra("TARGET");

            tampiltarget.setText("Target Anda " + tampil_target);

            //set up toolbar
            toolbar = (Toolbar) findViewById(R.id.tool_bar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("KHOLAS");

            //inisialisasi tab dan pager
            pager = (ViewPager) findViewById(R.id.pager);
            tabs = (TabLayout) findViewById(R.id.tabs);

            //set object adapter kedalam ViewPager
            pager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));

            //Manipulasi sedikit untuk set TextColor pada Tab
            tabs.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark),
                    getResources().getColor(android.R.color.white));

            //set tab ke ViewPager
            tabs.setupWithViewPager(pager);

            //konfigurasi Gravity Fill untuk Tab berada di posisi yang proposional
            tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate berfungsi untuk menampilkan menu yang sudah dibuat pada.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    //OptionItemSelected berfungsi untuk memberikan perintah ke setiap menu
    //berfungsi mendapatkan id dari item yang dibuat pada optionmenu.xml ketika di klik akan menampilkan activity yang dituju menggunakan intent.
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== R.id.target) {
            startActivity(new Intent(this, TargetActivity.class));
        } else if (item.getItemId() == R.id.about){
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.setting) {
            startActivity(new Intent(this, SettingActivity.class));
        } else if (item.getItemId() == R.id.help) {
            startActivity(new Intent(this, HelpActivity.class));
        }

        return true;
    }
//Notifikasi keluar
    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Apakah anda ingin keluar?");
        builder.setCancelable(true);
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
