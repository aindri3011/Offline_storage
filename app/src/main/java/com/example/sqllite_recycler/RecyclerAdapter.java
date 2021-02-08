package com.example.sqllite_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

        MyViewHolder myViewHolder;
        ArrayList<UserModel> arrayList=new ArrayList<>();
        Context context;
        public RecyclerAdapter(ArrayList<UserModel>arrayList,Context context){
            this.arrayList=arrayList;
            this.context=context;
        }



        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.activity_single_view,null);
            myViewHolder=new MyViewHolder(view);

            return myViewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.text_1.setText(arrayList.get(position).getName());
            holder.text_2.setText(arrayList.get(position).getEmail());
            holder.image_1.setImageResource(arrayList.get(position).getImg());

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public  class MyViewHolder extends RecyclerView.ViewHolder{
            TextView text_1,text_2;
            ImageView image_1;
            public MyViewHolder(View itemView){
                super(itemView);

                text_1=itemView.findViewById(R.id.text_1);
                text_2=itemView.findViewById(R.id.text_2);
                image_1=itemView.findViewById(R.id.image_1);
            }
        }

    }
