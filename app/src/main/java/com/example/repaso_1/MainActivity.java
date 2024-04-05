package com.example.repaso_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.repaso_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    //para realizar el binding

    public static String TAG = "MAINTAGDEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.telemath);
        //unimos el texto telemath al context menu, para el cambio de colores

        //Boton para ir a la calculadora
        binding.buttonCal.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
            startActivity(intent); //empieza el intento (operacion)
        });

        Button button = findViewById(R.id.buttonInd);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InstructionsActivity.class);
            startActivity(intent);

        });

       /* EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "oncreate"); //Logs que reportan
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }); */

    }






    //Declaracion de la logica del menu


    //----- Texto de ayuda
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Elije un color para Telemath");
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
    }

    //--------Seleccion de colores
    public boolean onContextItemSelected(MenuItem item){
        TextView titleTextView = findViewById(R.id.telemath);
        int itemId = item.getItemId();
        if (itemId ==R.id.opcionAzul){
            binding.telemath.setTextColor(Color.BLUE);
            return true;
        }else if (itemId == R.id.opcionVerde){
            binding.telemath.setTextColor(Color.GREEN);
        } else if (itemId == R.id.opcionRojo) {
            binding.telemath.setTextColor(Color.RED);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}