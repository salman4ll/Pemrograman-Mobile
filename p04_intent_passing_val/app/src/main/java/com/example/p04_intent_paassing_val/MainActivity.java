package com.example.p04_intent_paassing_val;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etData1 = (EditText) findViewById(R.id.et_data1);
        final EditText etData2 = (EditText) findViewById(R.id.et_data2);
        Button btSubmit = (Button) findViewById(R.id.bt_submit);
        Button btSubmitIntent = (Button) findViewById(R.id.bt_submitintent);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("token1", etData1.getText().toString());
                bundle.putString("token2", etData2.getText().toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btSubmitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("tok01", etData1.getText().toString());
                intent.putExtra("tok02", etData2.getText().toString());
                startActivity(intent);
            }
        });
    }
}