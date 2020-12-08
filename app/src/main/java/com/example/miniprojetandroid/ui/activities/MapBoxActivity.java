package com.example.miniprojetandroid.ui.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.Retrofit.MapService;
import com.example.miniprojetandroid.Retrofit.RetrofitClient;
import com.example.miniprojetandroid.models.BikeCyclist;
import com.example.miniprojetandroid.models.Circuit;
import com.example.miniprojetandroid.models.Community;
import com.example.miniprojetandroid.models.Shop;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;


public class MapBoxActivity extends AppCompatActivity {

    private  MapView mapView;
    private  MapService apiService;
    private  ArrayList<Shop> shops = new ArrayList<Shop>();
    private  ArrayList<BikeCyclist> cyclists = new ArrayList<BikeCyclist>();
    private  ArrayList<Community> communities = new ArrayList<Community>();
    private  ArrayList<Circuit> circuits = new ArrayList<Circuit>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = RetrofitClient.getClient().create(MapService.class);
        fillDataShops();
        fillDataCircuits();
        fillDataCommunities();
        fillDataCyclists();
// Mapbox access token is configured here. This needs to be called either in your application
// object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.accessToken));

// This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.activity_map_box);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {




                //static markers and positions
               /* Shop shop1 = new Shop("bike shop 1",36.553015,10.592774);
                Shop shop2 = new Shop("bike shop 2",35.499414,10.824846);
                Shop shop3 = new Shop("bike shop 3",35.945377,9.451555);
                shops.add(shop1);
                shops.add(shop2);
                shops.add(shop3);
                Community com1 = new Community("Community 1", 37.276943 , 9.748186);
                Community com2 = new Community("Community 2", 35.427828, 10.934709);
                Community com3 = new Community("Community 3", 36.140808, 8.847307);
                communities.add(com1);
                communities.add(com2);
                communities.add(com3);
                BikeCyclist cyclist1 = new BikeCyclist("Bike Cyclist 1", 35.785118 , 10.000871);
                BikeCyclist cyclist2 = new BikeCyclist("Bike Cyclist 2", 36.900100  , 10.901750);
                BikeCyclist cyclist3 = new BikeCyclist("Bike Cyclist 3",35.900893 , 9.154924);
                cyclists.add(cyclist1);
                cyclists.add(cyclist2);
                cyclists.add(cyclist3);

                Circuit c1 = new Circuit("Circuit 1", 33.773035, 10.857805);
                Circuit c2 = new Circuit("Circuit 2", 36.882526, 8.957170);
                Circuit c3 = new Circuit("Circuit 3", 36.574341, 8.429827);
                circuits.add(c1);
                circuits.add(c2);
                circuits.add(c3);*/


                List<MarkerOptions> shopsOptions = new ArrayList<>();
                List<MarkerOptions> communitiesOptions = new ArrayList<>();
                List<MarkerOptions> cyclistsOptions = new ArrayList<>();
                List<MarkerOptions> circuitsOptions = new ArrayList<>();


                for(Shop s : shops){
                    shopsOptions.add(new MarkerOptions().position(new LatLng(s.getLatitude(),s.getLongitude())).setTitle(s.getTitle()) );
                }

                for(Community s : communities){
                    communitiesOptions.add(new MarkerOptions().position(new LatLng(s.getLatitude(),s.getLongitude())).setTitle(s.getTitle()) );
                }

                for(BikeCyclist s : cyclists){
                    cyclistsOptions.add(new MarkerOptions().position(new LatLng(s.getLatitude(),s.getLongitude())).setTitle(s.getTitle()) );
                }

                for(Circuit s : circuits){
                    circuitsOptions.add(new MarkerOptions().position(new LatLng(s.getLatitude(),s.getLongitude())).setTitle(s.getTitle()) );
                }
                Log.e("Community LIST", communities.toString());
                Log.e("Community OPTIONS", communitiesOptions.toString());
                mapboxMap.addMarkers(shopsOptions);
                mapboxMap.addMarkers(cyclistsOptions);
                mapboxMap.addMarkers(communitiesOptions);
                mapboxMap.addMarkers(circuitsOptions);



                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                        // Map is set up and the style has loaded. Now you can add data or make other map adjustments
                    }
                });

            }
        });
    }



    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();



    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }



    public void fillDataShops(){

        Call<List<Shop>> call = apiService.getShops();
        call.enqueue(new Callback<List<Shop>>() {
            @Override
            public void onResponse(Call<List<Shop>> call, Response<List<Shop>> response) {
                if(response.isSuccessful()){
                    shops.addAll(response.body());
                    Log.e("SHOP LIST", shops.toString());
                }
            }
            @Override
            public void onFailure(Call<List<Shop>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }

    public void fillDataCircuits(){

        Call<List<Circuit>> call = apiService.getCircuits();
        call.enqueue(new Callback<List<Circuit>>() {
            @Override
            public void onResponse(Call<List<Circuit>> call, Response<List<Circuit>> response) {
                if(response.isSuccessful()){
                    circuits.addAll(response.body());
                    Log.e("Circuit LIST", circuits.toString());
                }
            }
            @Override
            public void onFailure(Call<List<Circuit>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }

    public void fillDataCommunities(){

        Call<List<Community>> call = apiService.getCommunities();
        call.enqueue(new Callback<List<Community>>() {
            @Override
            public void onResponse(Call<List<Community>> call, Response<List<Community>> response) {
                if(response.isSuccessful()){
                    communities.addAll(response.body());
                    Log.e("Community LIST", communities.toString());
                }
            }
            @Override
            public void onFailure(Call<List<Community>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }

    public void fillDataCyclists(){

        Call<List<BikeCyclist>> call = apiService.getCyclists();
        call.enqueue(new Callback<List<BikeCyclist>>() {
            @Override
            public void onResponse(Call<List<BikeCyclist>> call, Response<List<BikeCyclist>> response) {
                if(response.isSuccessful()){
                    cyclists.addAll(response.body());
                    Log.e("Cyclist LIST", cyclists.toString());
                }
            }
            @Override
            public void onFailure(Call<List<BikeCyclist>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }


    public static Icon drawableToIcon(@NonNull Context context, @DrawableRes int id) {
        Drawable vectorDrawable = ResourcesCompat.getDrawable(context.getResources(), id, context.getTheme());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return IconFactory.getInstance(context).fromBitmap(bitmap);
    }













}