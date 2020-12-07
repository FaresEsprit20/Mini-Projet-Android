package com.example.miniprojetandroid.ui.activities;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.miniprojetandroid.R;
import com.example.miniprojetandroid.models.Bike;
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

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;


public class MapBoxActivity extends AppCompatActivity {

    private MapView mapView;
    private  ArrayList<Shop> shops = new ArrayList<Shop>();
    private  ArrayList<BikeCyclist> cyclists = new ArrayList<BikeCyclist>();
    private  ArrayList<Community> communities = new ArrayList<Community>();
    private  ArrayList<Circuit> circuits = new ArrayList<Circuit>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                Shop shop1 = new Shop("bike shop 1",36.553015,10.592774);
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
                circuits.add(c3);

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
}