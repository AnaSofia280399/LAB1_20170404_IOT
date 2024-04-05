package com.example.repaso_1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.repaso_1.databinding.HistorialBinding;

import java.util.ArrayList;


public class HistorialActivity extends AppCompatActivity {

   HistorialBinding binding;

    @Override
    //logica para el hsitorial de operaciones
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding =HistorialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Double> histOperaciones = (ArrayList<Double>) getIntent().getSerializableExtra("historialOperaciones");
        for (int i=0; i< histOperaciones.size(); i++){
            LinearLayout linearLayout = binding.linearLayoutHistorial;
            TextView textView = new TextView(HistorialActivity.this);

            if(histOperaciones.get(i) != 0.00){
                textView.setText("Resultado "+(i+1)+": "+ histOperaciones.get(i));

            }

            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            float escala = getResources().getDisplayMetrics().density;
            int dp = (int) (10*escala*0.5f);
            textView.setPadding(dp,dp,dp,dp);
            linearLayout.addView(textView);
            Log.d("OPERACION", String.valueOf(histOperaciones.get(i)));
        }


    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu){
        getSupportActionBar().setTitle("TeleMath");
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
