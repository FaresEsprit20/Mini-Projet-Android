package com.example.miniprojetandroid.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.Retrofit.EventService;
import com.example.miniprojetandroid.Retrofit.TrackService;
import com.example.miniprojetandroid.models.Event;
import com.example.miniprojetandroid.models.Participants;
import com.example.miniprojetandroid.models.Record;
import com.example.miniprojetandroid.models.Shop;

import java.util.ArrayList;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ParticipantsViewHolder>{

    private final ArrayList<Participants> participants;
    private Context mContext;



    public ParticipantsAdapter(Context mContext, ArrayList<Participants> participants) {
        this.mContext = mContext ;
        this.participants = participants;
    }

    @NonNull
    @Override
    public ParticipantsAdapter.ParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(mContext).inflate(R.layout.p_list_item, parent, false);
        return new ParticipantsAdapter.ParticipantsViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantsAdapter.ParticipantsViewHolder holder, int position) {
        final Participants singleItem = participants.get(position);
        holder.PEmail.setText(singleItem.getEmail());

    }


    @Override
    public int getItemCount() {
        return participants.size();
    }

    public class ParticipantsViewHolder extends RecyclerView.ViewHolder {

        public final TextView PEmail;

        final ParticipantsAdapter mAdapter;

        public ParticipantsViewHolder(@NonNull View itemView, ParticipantsAdapter  mAdapter) {
            super(itemView);
            this.PEmail = itemView.findViewById(R.id.pEmail);
            this.mAdapter = mAdapter;
        }
    }





}
