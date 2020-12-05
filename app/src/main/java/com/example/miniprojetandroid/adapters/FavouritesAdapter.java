package com.example.miniprojetandroid.adapters;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.database.AppDataBase;
import com.example.miniprojetandroid.models.Bike;
import com.squareup.picasso.Picasso;


public class FavouritesAdapter  extends RecyclerView.Adapter<FavouritesAdapter.BikesViewHolder> {

    private final ArrayList<Bike> bikes;
    private Context mContext;
    private Callback mCallback;

    public FavouritesAdapter(Context mContext, ArrayList<Bike> bikes) {
        this.mContext = mContext ;
        this.bikes = bikes;
    }

    @NonNull
    @Override
    public FavouritesAdapter.BikesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(mContext).inflate(R.layout.favourites_item, parent, false);
        return new BikesViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesAdapter.BikesViewHolder holder, int position) {
        final Bike singleItem = bikes.get(position);

        holder.BikeName.setText(singleItem.getModel());
        //holder.BikeImage.setBackgroundResource(singleItem.getImage());
        Picasso.with(mContext).load("http://10.0.2.2:3000/"+singleItem.getImage()).resize(40, 40).into(holder.BikeImage);
        holder.bikeDelete.setOnClickListener(new View.OnClickListener()
                                             {
                                                 @Override
                                                 public void onClick(View v) {
                                                     AppDataBase.getAppDatabase(mContext).bikeDao().delete(singleItem);
                                                     Toast.makeText(mContext,"Favourite deleted successfully !",Toast.LENGTH_SHORT).show();
                                                 }
                                             }

        );

        holder.bikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onItemClicked(singleItem);
            }
        });
        holder.BikeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,singleItem.getModel(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bikes.size();
    }

    public class BikesViewHolder extends RecyclerView.ViewHolder {

        public final TextView BikeName;
        public final ImageView BikeImage;
        public final Button bikeView,bikeDelete;
        final FavouritesAdapter mAdapter;

        public BikesViewHolder(@NonNull View itemView, FavouritesAdapter mAdapter) {
            super(itemView);
            this.BikeName = itemView.findViewById(R.id.bikeName);
            this.BikeImage = itemView.findViewById(R.id.bikeImage);
            this.bikeView = itemView.findViewById(R.id.btn_view);
            this.bikeDelete = itemView.findViewById(R.id.deleteFav);
            this.mAdapter = mAdapter;
        }
    }


    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    public interface Callback {
        void onItemClicked(Bike bike);
    }

}

