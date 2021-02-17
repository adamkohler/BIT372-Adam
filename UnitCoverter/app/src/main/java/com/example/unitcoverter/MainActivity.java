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
        EditText finput = findViewById(R.id.conversion_input);
        TextView ctxt = findViewById(R.id.converted_text);

        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            else {
            int spinnerkey = (int) spinner.getSelectedItemId();
            switch (spinnerkey) {
                case 0:
                    double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
                    ctxt.setText(String.format("%.2f ºC", celcius));
                    break;
                case 1:
                    double kg = pound_to_kg_converter.toKg(Float.parseFloat(finput.getText().toString()));
                    ctxt.setText(String.format("%.4f kilogram", kg));
                    break;
                case 2:
                    double km = milesTokilometers_conversion.toKilo(Float.parseFloat(finput.getText().toString()));
                    ctxt.setText(String.format("%.2f Kilometers", km));
                    break;
                case 3:
                    double meter = feetTometer_conversion.toMeter(Float.parseFloat(finput.getText().toString()));
                    ctxt.setText(String.format("%.2f meters", meter));
                    break;
            }
            }
        });
    }
}