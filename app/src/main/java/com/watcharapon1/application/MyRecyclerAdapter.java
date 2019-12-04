package com.watcharapon1.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.Holder>{
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private String[] mDataSet;

    class Holder extends RecyclerView.ViewHolder{
        TextView textTitle;
        TextView textDescription;

        public Holder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);
        }

        public void setItem(int position){
            textTitle.setText(mDataSet[position]);
            textDescription.setText("index = " + position);
        }

        public MyRecyclerAdapter(String[] dataSet){
            mDataSet = dataSet;
        }

        public int getItemCount() {
            return mDataSet.length;
        }

    }
}
