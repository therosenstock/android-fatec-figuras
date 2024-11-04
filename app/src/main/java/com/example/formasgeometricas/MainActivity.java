package com.example.formasgeometricas;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */

    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            carregaFragment(bundle);
        }
    }

    private void carregaFragment(Bundle bundle) {
        String tipo = bundle.getString("tipo");
        if(tipo.equals("retangulo")){
            fragment = new RetanguloFragment();
        } else {
            fragment = new CirculoFragment();

        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        Intent i = new Intent(this, MainActivity.class);
        if( id == R.id.act1){
            bundle.putString("tipo", "circulo");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        if( id == R.id.act2){
            bundle.putString("tipo", "retangulo");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}