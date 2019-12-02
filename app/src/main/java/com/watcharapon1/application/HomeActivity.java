package com.watcharapon1.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);

        recyclerView.setAdapter(new RecyclerViewAdapter());
    }

    public class RecyclerViewAdapter extends  RecyclerView.Adapter<ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_main1,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textViewhome.setText("TEST RecyclerView");

        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView textViewhome;
    ImageView imageViewhome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewhome = (TextView)itemView.findViewById(R.id.textView4);
            imageViewhome = (ImageView)itemView.findViewById(R.id.imageView2);


        }
    }
}
