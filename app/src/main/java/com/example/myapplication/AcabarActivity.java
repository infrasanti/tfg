package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AcabarActivity extends AppCompatActivity {

    private int media;
    private String nombrePresentacion;

    public static void startActivity(Context context, String nombrepresentacion, int media) {

        Intent intentAcabarActivity = new Intent(context, AcabarActivity.class);
        intentAcabarActivity
                .putExtra("nombre_presentacion", nombrepresentacion)
                .putExtra("media", media);

        context.startActivity(intentAcabarActivity);
    }

    private void recibirDatos(){
        Bundle idRecibido = getIntent().getExtras();
        nombrePresentacion = idRecibido.getString("nombre_presentacion");
        media = idRecibido.getInt("media");
        Log.d("!!!", "Nombre Presentacion = "+nombrePresentacion+"   Media = "+media);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acabar);

        recibirDatos();

        TextView nombrePresentacionText = findViewById(R.id.nombre_presentacion);
        nombrePresentacionText.setText(nombrePresentacion);

        TextView mediaText = findViewById(R.id.media);
        mediaText.setText(nombrePresentacion);

        Button SalirPresentacion = findViewById(R.id.buttonSalir);
        SalirPresentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
