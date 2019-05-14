package com.myapplicationdev.android.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> task;
    private Context context;
    private TextView tvId;
    private TextView tvDesc;
    private TextView tvDate;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        task = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_task, parent, false);

        tvId = rowView.findViewById(R.id.tvId);
        tvDesc = rowView.findViewById(R.id.tvDesc);
        tvDate = rowView.findViewById(R.id.tvDate);

        Task currentTask = task.get(position);
        String id = Integer.toString(currentTask.getId());
        tvId.setText(id);
        tvDesc.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());
        return rowView;
    }
}
