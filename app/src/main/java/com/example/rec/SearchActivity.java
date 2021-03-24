package com.example.rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    EditText editText;
    RecyclerView recyclerView;
    ArrayList<Job> jobs;
    JobAdapter jobAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        recyclerView = findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        editText = findViewById(R.id.edittext1);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        jobs = new ArrayList<Job>();
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Front-end Developer","desc1"));
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Backend Developer","desc2"));
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Full-stack Developer","desc3"));
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Middle-Tier Developer","desc4"));
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Web Developer","desc5"));
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Desktop Developer","desc6"));
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Mobile Developer","desc7"));
        jobs.add(new Job(R.drawable.ic_search_black_24dp,"Graphics Developer","desc8"));
        jobAdapter = new JobAdapter(this, jobs);
        recyclerView.setAdapter(jobAdapter);
    }

    private void filter(String text) {
        ArrayList<Job> filteredList = new ArrayList<>();

        for (Job item : jobs) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        jobAdapter.filterList(filteredList);
    }
}