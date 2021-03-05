package com.example.unitcoverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextViewModel textviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fbtn = findViewById(R.id.convert_btn);
        EditText finput = findViewById(R.id.conversion_input);
        TextView ctxt = findViewById(R.id.converted_text);

        textviewmodel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TextViewModel.class);
        final Observer<Double> textObserver = new Observer<Double>() {
            @Override
            public void onChanged(Double s) {
                if (!(s.toString().length() == 0))
                    ctxt.setText(s.toString());
            }
        };
        textviewmodel.getCurrentInput().observe(this, textObserver);

        Spinner spinner = (Spinner) findViewById(R.id.conversion_selection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversionChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
                    double kg = Converter.toKg(Float.parseFloat(finput.getText().toString()));
                    ctxt.setText(String.format("%.4f kilogram", kg));
                    break;
                case 2:
                    double km = Converter.toKilo(Float.parseFloat(finput.getText().toString()));
                    ctxt.setText(String.format("%.2f Kilometers", km));
                    break;
                case 3:
                    double meter = Converter.toMeter(Float.parseFloat(finput.getText().toString()));
                    ctxt.setText(String.format("%.2f meters", meter));
                    break;
            }
            }
        });

        /*if (finput.getText().length() == 0){}
        else {
            //textviewmodel.getCurrentInput().setValue(Converter.toCelcius(Float.parseFloat(finput.getText().toString())));
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        }*/
    }
}