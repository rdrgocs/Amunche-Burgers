package com.erci.amuncheburgers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.ArrayList;

public class HamburguesasActivity extends AppCompatActivity {
    final ArrayList<Hamburguesas> burgers = new ArrayList<Hamburguesas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburguesas);
        setTitle(R.string.menu_hamburguesas);

        LinearLayout linear = (LinearLayout)findViewById(R.id.layoutHamburguesas);
        //DATOS PARA MÁRGENES DE LOS BOTONES DE SANDWICHES
        int margin_left = 15;
        int margin_top = 40;
        int margin_right = 15;
        int margin_bottom = 0;
        int tamano_botones = 62;
        LinearLayout.LayoutParams auxiliar = generarMargenesBoton(tamano_botones, margin_left, margin_top, margin_right, margin_bottom);


        generarHamburguesa(getString(R.string.nombre_americana), getString(R.string.tipo_sandwich), getString(R.string.imagen_americana), getString(R.string.detalle_americana), getString(R.string.precio_americana), getString(R.string.promocion_americana));
        generarHamburguesa(getString(R.string.nombre_europea), getString(R.string.tipo_sandwich), getString(R.string.imagen_europea), getString(R.string.detalle_europea), getString(R.string.precio_europea), getString(R.string.promocion_europea));
        generarHamburguesa(getString(R.string.nombre_asiatica), getString(R.string.tipo_sandwich), getString(R.string.imagen_asiatica), getString(R.string.detalle_asiatica), getString(R.string.precio_asiatica), getString(R.string.promocion_asiatica));
        generarHamburguesa(getString(R.string.nombre_africana), getString(R.string.tipo_sandwich), getString(R.string.imagen_africana), getString(R.string.detalle_africana), getString(R.string.precio_africana), getString(R.string.promocion_africana));
        generarHamburguesa(getString(R.string.nombre_oceanica), getString(R.string.tipo_sandwich), getString(R.string.imagen_oceanica), getString(R.string.detalle_oceanica), getString(R.string.precio_oceanica), getString(R.string.promocion_oceanica));

        for (Hamburguesas i: burgers){

            Button burgerBoton = new Button (this);
            burgerBoton.setLayoutParams(auxiliar);
            burgerBoton.setBackground(getResources().getDrawable(R.drawable.botones));
            burgerBoton.setTextSize(14);
            burgerBoton.setText(i.nombre);


            burgerBoton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast mensaje = Toast.makeText(getApplicationContext(),"Error al mostrar la hamburguesa",Toast.LENGTH_SHORT);
                    Button test = (Button) view;
                    int n = burgers.size();
                    int j;

                    for(j=0; j<n; j=j+1){
                        if (burgers.get(j).nombre.equals(null)){
                            mensaje.show();
                        }
                        else if(burgers.get(j).nombre.equals(test.getText())){
                            break;
                        }
                    }

                    //se crea el objeto con la posición encontrada
                    Hamburguesas hamburguesa =burgers.get(j);
                    generarIntent(hamburguesa);

                }
            });
            linear.addView(burgerBoton);
        }
    }

    public void generarHamburguesa (String nombre, String tipo, String imagen, String detalle, String precio, String promocion ){
        String hamburguesa = nombre;
        String hamburguesatipo = tipo;
        String hamburguesaImagen = imagen;
        int codigo_imagen = getResources().getIdentifier(hamburguesaImagen,"drawable",this.getPackageName());
        String hamburguesadescripcion = detalle;
        String hamburguesaprecio = precio;
        String hamburguesapromocion = promocion;
        Hamburguesas nuevo = new Hamburguesas (hamburguesa, hamburguesatipo, codigo_imagen, hamburguesadescripcion, hamburguesaprecio, hamburguesapromocion);
        burgers.add(nuevo);
    }

    public LinearLayout.LayoutParams generarMargenesBoton(int botones, int margin_l, int margin_t, int margin_r, int margin_b){
        /*REFERENCIA: https://www.tutorialspoint.com/how-to-set-margins-in-an-android-linearlayout-programmatically
                      https://developer.android.com/reference/android/view/ViewGroup.MarginLayoutParams*/
        final float scale = getResources().getDisplayMetrics().density;
        int dpapixeles = (int) (botones * scale + 0.5f);
        int aux_scale = (int)(scale);
        int aux_conversion = (int)(0.5f);
        LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, dpapixeles);
        parametros.setMargins(
                (margin_l*aux_scale + aux_scale),
                (margin_t*aux_scale + aux_conversion),
                (margin_r*aux_scale + aux_conversion),
                margin_b*aux_scale + aux_conversion);
        return parametros;
    };

    public void generarIntent(Hamburguesas hamburguesa){
        /*REFERENCIA: https://medium.com/@kkunalandroid/serializable-in-android-with-example-38eb8b7334ea*/
        Intent intent = new Intent(HamburguesasActivity.this,HamburguesaDetalleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("serializable", hamburguesa);
        intent.putExtras(bundle);
        startActivity(intent);
        /*FIN REFERENCIA*/
    };

}
