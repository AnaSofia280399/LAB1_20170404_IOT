package com.example.LAB1_20170404;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.LAB1_20170404.databinding.IndicacionesBinding;

public class InstructionsActivity extends AppCompatActivity {

    IndicacionesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = IndicacionesBinding.inflate(getLayoutInflater());
        getSupportActionBar().setTitle("TeleMath");

        setContentView(binding.getRoot());

        binding.buttonCal.setOnClickListener(view -> {
            //Manda a la calculadora
            Intent intent = new Intent(InstructionsActivity.this, CalculatorActivity.class);
            startActivity(intent); //empieza el intento (operacion)
        });

    }

}
