package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PresentacionActivity extends AppCompatActivity {

    private String idAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        recibirDatos();



        Button empezarPresentacion = findViewById(R.id.buttonEmpezarPresentacion);
        empezarPresentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // método para crear documentos en la base de datos
                createDbDocument();
            }
        });

    }

    private void recibirDatos(){
        Bundle idRecibido = getIntent().getExtras();
        idAsignatura = idRecibido.getString("Id asignatura");
        Log.d("!!!", idAsignatura);
    }

    private void createDbDocument(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> presentation = new HashMap<>();
        presentation.put("nombre", "Señales y Sistemas");


        db.collection("presentaciones").document(idAsignatura).set(presentation)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d("¡¡¡", "DocumentSnapshot successfully written!");
                }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("¡¡¡", "Error writing document", e);
                    }
                });;

    }
}
