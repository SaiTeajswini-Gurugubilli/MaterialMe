package com.example.mobility.materialme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Mobility on 30/03/17.
 */

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder>{
   private ArrayList<Sports> mSportData;
    private Context mContext;

    public SportsAdapter(Context context, ArrayList<Sports> sportData) {
        this.mSportData = sportData;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Sports currentSport = mSportData.get(position);

        holder.bindTo(currentSport);
        /* holder.mSportTitle.setText(currentSport.getSportTitle());
        holder.mSportInfo.setText(currentSport.getSportInfo());*/
        Glide.with(mContext).load(currentSport.getImageResource()).into(holder.mSportImage);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {

        return mSportData.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitleText,mInfoText,mLabel;
         ImageView mSportImage;

         @Override
         public void onClick(View v) {

             Sports currentSport = mSportData.get(getAdapterPosition());
             Intent detailIntent = new Intent(mContext,DetailActivity.class);
             detailIntent.putExtra("title",currentSport.getSportTitle());
             detailIntent.putExtra("imageResource",currentSport.getImageResource());
             mContext.startActivity(detailIntent);
         }

         ViewHolder(View v) {
            super(v);
             v.setOnClickListener(this);
             mTitleText = (TextView)v.findViewById(R.id.title);
             mInfoText = (TextView)v.findViewById(R.id.subTitle);
             mSportImage = (ImageView)v.findViewById(R.id.sportsImage);

        }

          void bindTo(Sports currentSport) {
            mTitleText.setText(currentSport.getSportTitle());
              mInfoText.setText(currentSport.getSportInfo());
         }
     }
}
