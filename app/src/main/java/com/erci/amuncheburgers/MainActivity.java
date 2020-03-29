package com.erci.amuncheburgers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button about = (Button) findViewById(R.id.buttonSobreNosotros);
        final Button burgers = (Button) findViewById(R.id.buttonSandwich);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(MainActivity.this,
                        about.class);
                startActivity(about);
            }
        });

        burgers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent burgers = new Intent(MainActivity.this,
                        HamburguesasActivity.class);
                startActivity(burgers);
            }
        });
    }

}
