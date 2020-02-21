package com.stratpoint.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Player> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    MyAdapter(Context context, List<Player> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Player player = mData.get(position);
        holder.myTextView.setText("Player name: " + player.getName());
        holder.scoreView.setText("Score: " + player.getScore());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        TextView scoreView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.name);
            scoreView = itemView.findViewById(R.id.score);
        }
    }

    // convenience method for getting data at click position
    Player getItem(int id) {
        return mData.get(id);
    }
}
