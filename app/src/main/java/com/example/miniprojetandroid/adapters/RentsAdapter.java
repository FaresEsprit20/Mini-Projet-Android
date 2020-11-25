package com.example.miniprojetandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.models.Location;


public class RentsAdapter  extends RecyclerView.Adapter<RentsAdapter.RentsViewHolder> {

    private final ArrayList<Location> rents;
    private Context mContext;

    public RentsAdapter(Context mContext, ArrayList<Location> rents) {
        this.mContext = mContext ;
        this.rents = rents;
    }

    @NonNull
    @Override
    public RentsAdapter.RentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = LayoutInflater.from(mContext).inflate(R.layout.rent_list_item, parent, false);

        return new RentsViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RentsAdapter.RentsViewHolder holder, int position) {
        final Location singleItem = rents.get(position);

        holder.RentName.setText(singleItem.getDateLocation());

        holder.RentImage.setBackgroundResource(singleItem.getBike().getImage());

    }

    @Override
    public int getItemCount() {
        return rents.size();
    }

    public class RentsViewHolder extends RecyclerView.ViewHolder {

        public final TextView RentName;
        public final ImageView RentImage;
        final RentsAdapter mAdapter;

        public RentsViewHolder(@NonNull View itemView, RentsAdapter mAdapter) {
            super(itemView);
            this.RentName = itemView.findViewById(R.id.rentName);
            this.RentImage = itemView.findViewById(R.id.rentImage);
            this.mAdapter = mAdapter;
        }
    }



}
