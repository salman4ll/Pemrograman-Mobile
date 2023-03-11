package com.example.p04_intent_paassing_val;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvData1 = (TextView) findViewById(R.id.tv_data1);
        TextView tvData2 = (TextView) findViewById(R.id.tv_data2);

        Intent intentnya = getIntent();
        if(intentnya.hasExtra("token1")){
            Bundle bundle = getIntent().getExtras();
            tvData1.setText(bundle.getString("token1"));
            tvData2.setText(bundle.getString("token2"));
            Toast.makeText(this, "Kiriman menggunakan bundle", Toast.LENGTH_SHORT).show();
        }
        else{
            tvData1.setText(getIntent().getStringExtra("tok01"));
            tvData2.setText(getIntent().getStringExtra("tok02"));
            Toast.makeText(this, "Kiriman tanpa bundle", Toast.LENGTH_SHORT).show();
        }
    }
}