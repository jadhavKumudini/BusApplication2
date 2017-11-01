package com.example.kumud.busapplication2;

import android.content.Context;
import android.content.Intent;
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
    private String pickup;
    private String tour;

    public TimingAdapter(Context context,List<String> timinglist,String pickup, String tour){
        this.context = context;
        this.timingList = timinglist;
        this.pickup = pickup;
        this.tour = tour;
    }

    @Override
    public void onBindViewHolder(final TiminigViewHolder holder, int position) {
       holder.textTiming.setText(timingList.get(position));

        holder.btnNotify.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String textTime = holder.textTiming.toString();
               Intent intent = new Intent(context, NotificationActivity.class);
               intent.putExtra("textTime",textTime);
               context.startActivity(intent);
           }
       });

        holder.btnTrackMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapActivity.class);
                intent.putExtra("pickupLocation",pickup);
                intent.putExtra("tour",tour);
                context.startActivity(intent);
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
