package com.example.miniprojetandroid.ui.fragments;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyMapFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap googleMap;

    public MyMapFragment()  {
        getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap gmap) {
        this.googleMap = gmap;

        // Set default position
        // Add a marker in Sydney and move the camera
        LatLng shop = new LatLng( 36.861001, 10.164021);  // 14.0583° N, 108.2772° E
        LatLng shop2 = new LatLng(36.807616, 10.137191);

        LatLng community1 = new LatLng(36.58534834154057, 10.864349191947655);
        LatLng community2 = new LatLng(36.460272, 10.758579);
        LatLng community3 = new LatLng(35.792413, 10.592968);

        LatLng cyclist1 = new LatLng(37.139099, 9.803709);
        LatLng cyclist2 = new LatLng(36.838368, 10.096169);
        LatLng cyclist3 = new LatLng(37.284892, 9.852577);

        this.googleMap.addMarker(new MarkerOptions().position(shop).title("Baskel Shop"));
        this.googleMap.addMarker(new MarkerOptions().position(shop2).title("Baskel Shop 2"));
        this.googleMap.addMarker(new MarkerOptions().position(community1).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("Bike Community 1"));
        this.googleMap.addMarker(new MarkerOptions().position(community2).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("Bike Community 2"));
        this.googleMap.addMarker(new MarkerOptions().position(community3).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("Bike Community 3"));

        this.googleMap.addMarker(new MarkerOptions().position(community2).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).title("Bike Cyclist 1"));
        this.googleMap.addMarker(new MarkerOptions().position(community3).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).title("Bike Cyclist 2"));
        this.googleMap.addMarker(new MarkerOptions().position(community3).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).title("Bike Cyclist 3"));


        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(shop));

        this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude + " : "+ latLng.longitude);
                // Clear previously click position.
                googleMap.clear();
                // Zoom the Marker
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                // Add Marker on Map
                googleMap.addMarker(markerOptions);
            }
        });
    }
}
