package com.example.iraq.recycel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by iraq on 2/15/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //bind the data to view
        Log.d(TAG, "onBindViewHolder: called "+String.valueOf(position));

       // Glide.with(mContext).load(mImages.get(position)).into(holder.circleImage);
        Picasso.with(mContext).load(mImages.get(position)).into(holder.circleImage);

        holder.iamgename.setText(mImageNames.get(position));

        // on item click
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: "+mImageNames.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    //view holder for all item
    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImage;
        TextView iamgename;
        RelativeLayout parentlayout;
        public ViewHolder(View itemView) {
            super(itemView);
            circleImage=itemView.findViewById(R.id.image);
            iamgename=itemView.findViewById(R.id.image_name);
            parentlayout=itemView.findViewById(R.id.parent_layout);

        }
    }
}
