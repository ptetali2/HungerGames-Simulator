package com.example.finalproject;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SetupAdapter extends RecyclerView.Adapter<SetupAdapter.MyViewHolder> {
    //all the users names
    private ArrayList<String> names;
    private ArrayList<String> labels;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public EditText editText;
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);
            editText = v.findViewById(R.id.name);
            textView = v.findViewById(R.id.label);
        }
    }
    public SetupAdapter(ArrayList<String> mDataset, ArrayList<String> lDataset) {
        names = mDataset;
        labels = lDataset;

    }
    @Override
    public SetupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.namesetup_row, null, false);
        //EditText editText = v.findViewById(R.id.name);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.editText.setText(names.get(position));
        holder.textView.setText(labels.get(position));
    }
    @Override
    public int getItemCount() {
        return names.size();
    }


}
