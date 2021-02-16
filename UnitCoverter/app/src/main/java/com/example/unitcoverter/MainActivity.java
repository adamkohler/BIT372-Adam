package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.conversion_selection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversionChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button fbtn = findViewById(R.id.convert_btn);

        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);
        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });

        Button poundbtn = findViewById(R.id.pounds_convert_btn);
        EditText pound_input = findViewById(R.id.pounds_input);
        TextView kg_txt = findViewById(R.id.kg_text);

        poundbtn.setOnClickListener(v -> {
            if (pound_input.getText().length() == 0)
                return;
            double kg = pound_to_kg_converter.toKg(Float.parseFloat(pound_input.getText().toString()));
            kg_txt.setText(String.format("%.2f Kg", kg));

        });
    }
}