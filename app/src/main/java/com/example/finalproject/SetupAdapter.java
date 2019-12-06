package com.example.finalproject;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class SetupAdapter extends RecyclerView.Adapter<SetupAdapter.MyViewHolder> {
    //all the users names
    private ArrayList<String> names;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public EditText editText;
        public MyViewHolder(View v) {
            super(v);
            editText = v.findViewById(R.id.name);
        }
    }
    public SetupAdapter(ArrayList<String> mDataset) {
        names = mDataset;
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

    }
    @Override
    public int getItemCount() {
        return names.size();
    }


}
