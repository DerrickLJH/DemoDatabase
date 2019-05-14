package com.myapplicationdev.android.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnGetTasks;
    TextView tvResults;
    ArrayAdapter adapter;
    ArrayList<Task> taskArrayList;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        lv = findViewById(R.id.lv);
        taskArrayList = new ArrayList<Task>();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "14 May 2019");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<Task> data = db.getTasks();
                ArrayList<String> dataForTv = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i + ". " + dataForTv.get(i));
                    txt += i + ". " + dataForTv.get(i) + "\n";
                }
                tvResults.setText(txt);

                 adapter = new TaskAdapter(MainActivity.this, R.layout.row_task, data);
                 lv.setAdapter(adapter);
            }
        });
    }
}
