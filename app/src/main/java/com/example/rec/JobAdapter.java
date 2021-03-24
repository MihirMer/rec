package com.example.rec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
    private Context context;
    private ArrayList<Job> jobs;

    public JobAdapter(Context context, ArrayList<Job> jobs) {
        this.context = context;
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_big, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobs.get(position);
        holder.titleTextView.setText(job.getTitle());
        holder.descTextView.setText(job.getDesc());
        holder.imageView.setImageResource(job.getLogo());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView, descTextView;
        ImageView imageView;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_big);
            descTextView = itemView.findViewById(R.id.desc_big);
            imageView = itemView.findViewById(R.id.image_big);
        }
    }

    public void filterList(ArrayList<Job> filteredList) {
        jobs= filteredList;
        getItemCount();
        notifyDataSetChanged();
    }
}
