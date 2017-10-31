package com.example.kumud.busapplication2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kumud on 10/14/17.
 */

public class TimingAdapter extends RecyclerView.Adapter<TimingAdapter.TiminigViewHolder> {
    private List<String> timingList;
    private Context context;

    public TimingAdapter(Context context,List<String> timinglist){
        this.context = context;
        this.timingList = timinglist;
    }

    @Override
    public void onBindViewHolder(TiminigViewHolder holder, int position) {
       holder.textTiming.setText(timingList.get(position));

        holder.btnNotify.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

        holder.btnTrackMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    @Override
    public TiminigViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_schedule_cardview,parent,false);


        return new TiminigViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return timingList.size();
    }

    public static  class TiminigViewHolder extends RecyclerView.ViewHolder {
        protected TextView textTiming;
        protected ImageButton btnTrackMap;
        protected ImageButton btnNotify;

        public TiminigViewHolder(View v){
            super(v);
            textTiming = (TextView) v.findViewById(R.id.textViewTime);
            btnTrackMap = (ImageButton) v.findViewById(R.id.imageButtonMap);
            btnNotify = (ImageButton) v.findViewById(R.id.imageButtonNotify);

        }

    }// end of class TimingViewHolder

}//end of class
