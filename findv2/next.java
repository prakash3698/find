package com.example.findv2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class next extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ListView listView;
    List<Worker> workerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent = getIntent();
        final String location= intent.getStringExtra("location");
        final String job= intent.getStringExtra("job");

        listView = findViewById(R.id.listView);
        workerList = new ArrayList<>();

         //final ArrayList<String> list = new ArrayList<>();
        // final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_layout, list);
        //listView.setAdapter(adapter);

        mDatabase = FirebaseDatabase.getInstance().getReference().child(location).child(job);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                workerList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Worker worker = snapshot.getValue(Worker.class);

                    workerList.add(worker);
                }

                WorkerList adapter = new WorkerList(next.this,workerList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
