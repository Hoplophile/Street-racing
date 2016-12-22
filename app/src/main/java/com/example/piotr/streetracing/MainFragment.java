package com.example.piotr.streetracing;

import android.content.Context;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationListener;
import com.mapbox.mapboxsdk.location.LocationServices;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

//import com.example.piotr.streetracing.MyLocation.LocationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainFragment extends Fragment {
    private MapboxMap map;
    private MapView mapView;
    private FloatingActionButton floatingActionButton;
    private LocationServices locationServices;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 124;

    private String current_location_latitude, current_location_longitude;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        MapboxAccountManager.start(getContext(), "pk.eyJ1IjoibXEwMDciLCJhIjoiY2l3dGZrZmxlMDBwbDJ6bWcyZnN4azYzdSJ9.ccx2gEnhH6Bm8QHz0vKMhg");
        View android = inflater.inflate(R.layout.fragment_main, container, false);
        //insertDummyContactWrapper();
        Context context = getContext();
        locationServices = LocationServices.getLocationServices(context);

        mapView = (MapView)android.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;

            }
        });


        floatingActionButton = (FloatingActionButton) android.findViewById(R.id.location_toggle_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map != null) {
                    MapboxMap mapboxMap;
                    toggleGps(!map.isMyLocationEnabled());
                    //Lokazlicazja
                    /*LocationResult locationResult = new LocationResult(){
                        @Override
                        public void gotLocation(Location location){
                            //Got the location!
                            current_location_latitude = Location.convert(location.getLatitude(), Location.FORMAT_DEGREES);
                            current_location_longitude = Location.convert(location.getLongitude(), Location.FORMAT_DEGREES);
                            Toast.makeText(getActivity(), current_location_latitude+"  "+current_location_longitude, Toast.LENGTH_LONG).show();
                        }
                    };
                    MyLocation myLocation = new MyLocation();
                    myLocation.getLocation(getActivity(), locationResult);
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(new LatLng(Double.parseDouble(current_location_latitude),Double.parseDouble(current_location_longitude)))
                            .zoom(17)
                            .build();
                    mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),7000);*/
                }
            }
        });
        return android;
    }

    private void insertDummyContactWrapper() {
        int hasWriteContactsPermission = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            if (!shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                showMessageOKCancel("You need to allow access to Localization",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
                                        REQUEST_CODE_ASK_PERMISSIONS);
                            }
                        });
                return;
            }
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_ASK_PERMISSIONS);
            return;
        }
        // ===== = XDDDD === insertDummyContact();
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    //enableLocation(true);
                } else {
                    // Permission Denied
                    Toast.makeText(getActivity(), "ACCESS_FINE_LOCATION Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void toggleGps(boolean enableGps) {
        if (enableGps) {
            // Check if user has granted location permission
            if (!locationServices.areLocationPermissionsGranted()) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.LOCATION_HARDWARE,
                        Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSIONS);
            } else {
                enableLocation(true);
            }
        } else {
            enableLocation(false);
        }
    }

    private void enableLocation(boolean enabled) {
        if (enabled) {
            // If we have the last location of the user, we can move the camera to that position.
            Location lastLocation = locationServices.getLastLocation();
            if (lastLocation != null) {
                map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lastLocation)));
            }

            locationServices.addLocationListener(new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    if (location != null) {
                        /* Move the map camera to where the user location is and then remove the
                         *listener so the camera isn't constantly updating when the user location
                         *changes. When the user disables and then enables the location again, this
                         *listener is registered again and will adjust the camera once again.
                         */

                        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location)));
                        //locationServices.removeLocationListener(this);
                    }
                }
            });
            floatingActionButton.setImageResource(R.drawable.myloc);
        } else {
            floatingActionButton.setImageResource(R.drawable.myloc);
        }
        // Enable or disable the location layer on the map
        map.setMyLocationEnabled(enabled);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
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
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
