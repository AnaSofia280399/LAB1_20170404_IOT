package com.example.repaso_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.repaso_1.databinding.IndicacionesBinding;

public class InstructionsActivity extends AppCompatActivity {

    IndicacionesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = IndicacionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCal.setOnClickListener(view -> {
            Intent intent = new Intent(InstructionsActivity.this, CalculatorActivity.class);
            startActivity(intent); //empieza el intento (operacion)
        });

    }

}
