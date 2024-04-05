package com.example.LAB1_20170404;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.LAB1_20170404.databinding.CalcularBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorActivity extends AppCompatActivity {

    private String log = "OPERACION";
    CalcularBinding binding;

    private ArrayList<Double> histOperaciones = new ArrayList<>();

    private  boolean startOperacion = true;

    private double resultado = 0;
     private String operacionActual = "";

     private String operador = "";



    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = CalcularBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Button> botones = new ArrayList<>(Arrays.asList(binding.buttonInd0, binding.buttonInd1,
                binding.buttonInd2,binding.buttonInd3, binding.buttonInd4, binding.buttonInd5,binding.buttonInd6,
                binding.buttonInd7, binding.buttonInd8, binding.buttonInd9));

        // opcion igual
        for (Button button :botones){
            button.setOnClickListener(view ->{
                if(startOperacion){
                    binding.seccionB.setText("");
                    startOperacion = false;
                }
                binding.seccionB.setText(binding.seccionB.getText().toString() + button.getText().toString());

            });
        }


        View.OnClickListener operacionListener = view -> {
            Button button2 = (Button) view;
            operador = button2.getText().toString();
            if (!startOperacion){
                operacionActual = binding.seccionB.getText().toString()+" "+ operador;
                binding.seccionA.setText(operacionActual);
                resultado = Double.parseDouble(binding.seccionB.getText().toString());
                binding.seccionB.setText("");
                startOperacion = true;
            }
        };

        binding.buttonIndsum.setOnClickListener(operacionListener);
        binding.buttonInddiv.setOnClickListener(operacionListener);

        binding.buttonIndmen.setOnClickListener(operacionListener);
        binding.buttonIndmul.setOnClickListener(operacionListener);

        binding.buttonIndigual.setOnClickListener(view ->{
            if (!startOperacion && !operador.isEmpty()){
                double numeroActual = Double.parseDouble(binding.seccionB.getText().toString());

                switch (operador){
                    case "+":
                        resultado += numeroActual;
                        break;
                    case "-":
                        resultado -= numeroActual;
                        break;
                    case "*":
                        resultado *= numeroActual;
                        break;
                    case "/":
                        if (numeroActual == 0){
                            Toast.makeText(getApplicationContext(), "Error: Division por 0", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            resultado /= numeroActual;

                        }
                        break;

                }

                binding.seccionB.setText(String.valueOf(resultado));
                operacionActual += " " + numeroActual;
                binding.seccionA.setText(operacionActual);

                histOperaciones.add(resultado);
                operador = " ";
                startOperacion=true;

            }
        });

        binding.buttonIndCLR.setOnClickListener(viex -> {
            binding.seccionB.setText("0");
            startOperacion = true;
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        getSupportActionBar().setTitle("TeleMath");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int itemId = item.getItemId();
        if(itemId == R.id.historialIcon){

            View menuItemViem = findViewById(R.id.historialIcon);
            PopupMenu popupMenu = new PopupMenu(CalculatorActivity.this, menuItemViem);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(menuItem ->{

                if (menuItem.getItemId() == R.id.historial){
                    Intent intent = new Intent(CalculatorActivity.this, HistorialActivity.class) ;
                    intent.putExtra("historialOperaciones", histOperaciones);
                    startActivity(intent);
                }

                return true;
            });
            popupMenu.show();
        }
        return super.onOptionsItemSelected(item);
    }


}
