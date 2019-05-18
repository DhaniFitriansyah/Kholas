package com.example.dhani.kholas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TargetActivity extends AppCompatActivity {

    private Spinner spNamen;
    Button mulai;
    String jml_target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        spNamen = (Spinner) findViewById(R.id.sp_target);
        mulai = (Button) findViewById(R.id.bt_target);

        mulai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    jml_target = spNamen.getSelectedItem().toString();
                    Intent intent = new Intent(TargetActivity.this, MainActivity.class);
                    intent.putExtra("TARGET", jml_target);
                   startActivity(intent);
                    finish();

            }
        });

    }

}
