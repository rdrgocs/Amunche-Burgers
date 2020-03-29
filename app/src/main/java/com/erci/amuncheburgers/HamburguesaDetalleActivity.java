package com.erci.amuncheburgers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HamburguesaDetalleActivity extends AppCompatActivity {
    Hamburguesas hamburguesa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburguesa_detalle);


        hamburguesa = (Hamburguesas) getIntent().getSerializableExtra("serializable");
        TextView nombre = findViewById(R.id.hamburguesa_nombre);
        TextView tipo = findViewById(R.id.hamburguesa_tipo);
        ImageView imagen = findViewById(R.id.hamburguesa_imagen);
        TextView detalle = findViewById(R.id.hamburguesa_detalle);
        TextView precio = findViewById(R.id.hamburguesa_precio);
        TextView promocion = findViewById(R.id.hamburguesa_promocion);

        setTitle(getResources().getString(R.string.titulo_detalle)+" "+hamburguesa.nombre);
        imagen.setImageResource(hamburguesa.imagen);
        nombre.setText(hamburguesa.nombre);
        tipo.setText(hamburguesa.tipo);
        detalle.setText(hamburguesa.detalle);
        precio.setText(hamburguesa.precio);
        promocion.setText(hamburguesa.promocion);
    }
}
