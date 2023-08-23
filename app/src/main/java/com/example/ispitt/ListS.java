package com.example.ispitt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListS extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TextView  receiver_msg = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        receiver_msg.setText(str);
        listView = findViewById(R.id.listViewHeroes);

        //calling the method to display the heroes
        getHeroes();
    }
    private void getHeroes() {
        Call<List<Job>> call = RetrofitClient.getInstance().getMyApi().getJobs();
        call.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                List<Job> jobList = response.body();

                //Creating an String array for the ListView
                String[] jobs = new String[jobList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < jobList.size(); i++) {
                    jobs[i] = jobList.get(i).getName();
                }
                adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, jobs);
                //displaying the string array into listview
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        String values =adapter.getItem(position);
                       // Toast.makeText(getApplicationContext(),values,Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ListS.this, ListDetail.class);
                        Job jobss =  jobList.get(position);
                        i.putExtra("aa",jobss);
                        startActivity(i);
                    }
                });







            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
