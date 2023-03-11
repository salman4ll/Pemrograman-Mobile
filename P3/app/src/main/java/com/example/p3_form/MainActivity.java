package com.example.p3_form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btampil;
    EditText enim,enama,etempatlahir;
    RadioGroup rgkelamin;
    Spinner sprodi,sagama;
    TextView teksOut;

    EditText etgllahir;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dataFormatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btampil = (Button) findViewById(R.id.tmbtampil);
        enim =(EditText)  findViewById(R.id.nim);
        enama =(EditText)  findViewById(R.id.nama);
        etempatlahir =(EditText)  findViewById(R.id.tmptlhr);
        rgkelamin = (RadioGroup) findViewById(R.id.jk);
        sprodi = (Spinner) findViewById(R.id.prodi);
        sagama = (Spinner) findViewById(R.id.agama);
        teksOut = (TextView) findViewById(R.id.tvout);

        etgllahir =(EditText)  findViewById(R.id.tgllhr);
        dataFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        etgllahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog();
            }
        });

        btampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nimnya = String.valueOf(enim.getText().toString());
                String namanya = String.valueOf(enama.getText().toString());
                String tmptnya = String.valueOf(etempatlahir.getText().toString());

                //ngambil pilihan kelamin dari user
                int idterpilih = rgkelamin.getCheckedRadioButtonId();
                RadioButton jkkepilih = (RadioButton) findViewById(idterpilih);
                String jknya = String.valueOf(jkkepilih.getText().toString());

                //ngambil data dari spinner
                String prodinya = sprodi.getSelectedItem().toString();
                String agamanya = sagama.getSelectedItem().toString();

                String tglnya = String.valueOf(etgllahir.getText().toString());

                String inputnya;


                inputnya = "NIM\t\t\t:"+nimnya;
                inputnya = inputnya +"\nNama\t\t\t:"+namanya;
                inputnya = inputnya +"\nKelamin\t\t\t:"+jknya;
                inputnya = inputnya +"\nProgram Studi\t:"+prodinya;
                inputnya = inputnya +"\nAgama\t\t\t:"+agamanya;
                inputnya = inputnya +"\n\nTempat Lahir\t:"+tmptnya;
                inputnya = inputnya +"\nTanggal Lahir\t:"+tglnya;
                teksOut.setText(inputnya);

            }
        });
    }

    void showDataDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year,monthOfYear,dayOfMonth);
                etgllahir.setText(dataFormatter.format(newDate.getTime()));
            }
        },
                newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }
}