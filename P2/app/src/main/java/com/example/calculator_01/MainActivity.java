package com.example.calculator_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hsl;
    EditText b01,b02;
    Button tmb,tmb_2,tmb_3;

    Integer a1,a2,a3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b01 = (EditText) findViewById(R.id.bil01);
        b02 = (EditText) findViewById(R.id.bil02);
        hsl = (TextView) findViewById(R.id.hasil);
        tmb = (Button) findViewById(R.id.tombol_add);
        tmb_2 = (Button) findViewById(R.id.tombol_sub);
        tmb_3 = (Button) findViewById(R.id.tombol_mul);



        tmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a1 = Integer.parseInt(b01.getText().toString());
                a2 = Integer.parseInt(b02.getText().toString());
                a3 = a1 + a2;
                hsl.setText("hasilnya: " + String.valueOf(a3));
            }
        });

        tmb_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a1 = Integer.parseInt(b01.getText().toString());
                a2 = Integer.parseInt(b02.getText().toString());
                a3 = a1 - a2;
                hsl.setText("hasilnya: " + String.valueOf(a3));
            }
        });

        tmb_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a1 = Integer.parseInt(b01.getText().toString());
                a2 = Integer.parseInt(b02.getText().toString());
                a3 = a1 * a2;
                hsl.setText("hasilnya: " + String.valueOf(a3));
            }
        });
    }

    public void aksiBagi(View view){
        Float a4;
        Float a5 = Float.parseFloat(b01.getText().toString());
        float a6 = Float.parseFloat(b02.getText().toString());
        a4 = a5 / a6;
        hsl.setText("hasilnya: " + String.valueOf(a4));
    }
}