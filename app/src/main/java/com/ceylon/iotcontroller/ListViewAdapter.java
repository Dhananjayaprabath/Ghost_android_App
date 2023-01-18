package com.ceylon.iotcontroller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {
    private List<Posts> postsList;
    private Context context;
    Activity activity;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public ListViewAdapter(List<Posts> postsList, Context context) {

        this.postsList = postsList;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater =LayoutInflater.from(context);
        v =inflater.inflate(R.layout.list_items,parent,false);
                return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


          holder.tital.setText(postsList.get(position).getName());
          holder.id.setText(postsList.get(position).getImageUrl());
         Picasso.get().load(postsList.get(position).getFeature_image()).into(holder.imageView);

         holder.layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openNewActivity();
             }

             public void openNewActivity() {
                 Intent intent = new Intent(context,BlogviewActivity.class);
                 intent.putExtra("htmlpost",postsList.get(position).getHtml());
                 intent.putExtra("titals",postsList.get(position).getName());
                 intent.putExtra("coverimgs",postsList.get(position).getFeature_image());

                 context.startActivity(intent);
             }


         });
    }



    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
TextView tital,id;
ImageView imageView;
LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tital =itemView.findViewById(R.id.textViewName);
            id= itemView.findViewById(R.id.textViewImageUrl);
            imageView=itemView.findViewById(R.id.img);
            layout=itemView.findViewById(R.id.layout1);
        }
    }

}
