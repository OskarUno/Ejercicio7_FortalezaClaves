package com.awakelab.oskar.ejercicio7_fortalezaclaves;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.awakelab.oskar.ejercicio7_fortalezaclaves.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements VistaPresentador {
    private Presentador presentando;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presentando = new Presentador(this);
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override  //Recupera el texto ingresado
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presentando.evaluarContraseña(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void mostrarClaveDebil() {
        Toast.makeText(this, "Debil", Toast.LENGTH_SHORT).show();
        binding.tvColor.setBackgroundColor(Color.RED);
        binding.tvColor.setText("DEBIL");
    }

    @Override
    public void mostrarClaveMedia() {
        Toast.makeText(this, "Medio", Toast.LENGTH_SHORT).show();
        binding.tvColor.setBackgroundColor(Color.YELLOW);
        binding.tvColor.setText("MEDIA");
    }

    @Override
    public void mostrarClaveFuerte() {
        Toast.makeText(this, "Fuerte", Toast.LENGTH_SHORT).show();
        binding.tvColor.setBackgroundColor(Color.GREEN);
        binding.tvColor.setText("FUERTE");
    }

    @Override
    public void mostrarClaveError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        binding.tvColor.setBackgroundColor(Color.GRAY);
        binding.tvColor.setText("ERROR");
    }
}