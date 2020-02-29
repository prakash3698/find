package com.example.findv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class home extends AppCompatActivity {

    ImageView carp,elec;
    Spinner sp;
    String locations[] = {"Ranipet","Vellore"};

    ArrayAdapter<String> adapter;
    String record = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carp = findViewById(R.id.carpenter);
        elec = findViewById(R.id.electrician);

        sp = findViewById(R.id.loc);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,locations);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 1:
                        record = "Ranipet";
                        break;
                    case 2:
                        record = "Vellore";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void next(View view) {
        carp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, next.class);
                intent.putExtra("location", record);
                intent.putExtra("job","Carpenter");
                startActivity(intent);
            }
        });
    }
    public void elect(View view) {
        elec.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, next.class);
                intent.putExtra("location", record);
                intent.putExtra("job","Electrician");
                startActivity(intent);
            }
        });
    }


}
