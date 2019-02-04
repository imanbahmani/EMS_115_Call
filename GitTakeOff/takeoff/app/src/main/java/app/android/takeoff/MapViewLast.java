package org.se.project;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.orm.query.Select;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapViewLast extends AppCompatActivity implements OnMapReadyCallback {
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private GoogleMap mMap;
    //TextView text;
    String newString;
    double distanceCalcute = 0;
    double sppedAvrageCalcute = 0;
    ArrayList<LatLng> coordList = new ArrayList<LatLng>();
    List<gpsPoint> pointList = new ArrayList<gpsPoint>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //G.overrideFont(getApplicationContext(), "SERIF", "Yekan.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view_last);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        //text = (TextView)findViewById(R.id.text);

        GlobalClass.context = this;
        ViewGroup group = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        GlobalClass.setAllTextView(group);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googlemap);
        mapFragment.getMapAsync(MapViewLast.this);

//        if (savedInstanceState == null) {
//            Bundle extras = getIntent().getExtras();
//            if(extras == null) {
//                newString= null;
//            } else {
//                newString= extras.getString("STRING_I_NEED");
//            }
//        } else {
//            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
//        }

        //webServiceLastLocation("");
    }

    public void onMapReady(final GoogleMap googleMap) {

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                // Code here will run in UI thread
                mMap = googleMap;
                System.out.println();
                final List<BookDataBase> books = Select.from(BookDataBase.class).list();
                for (int i = 0; i < books.size(); i++) {
                    LatLng sydney = new LatLng(Double.parseDouble(books.get(i).getLat()), Double.parseDouble(books.get(i).getLon()));
                    //LatLng sydney = new LatLng(29.622, 52.523);
                    mMap.addMarker(new MarkerOptions()
                            .position(sydney)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_icon))
                            .title(books.get(i).getNamemin()+"\n"+books.get(i).getNoemin()+"\n"+books.get(i).getMekanizm()));

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                    mMap.animateCamera( CameraUpdateFactory.zoomTo( 12.0f ) );
                }
                mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                    @Override
                    public View getInfoWindow(Marker arg0) {
                        return null;
                    }

                    @Override
                    public View getInfoContents(Marker marker) {

                        LinearLayout info = new LinearLayout(getApplicationContext());
                        info.setOrientation(LinearLayout.VERTICAL);

                        TextView title = new TextView(getApplicationContext());
                        title.setTextColor(Color.BLACK);
                        title.setGravity(Gravity.LEFT);
                        title.setTypeface(null, Typeface.BOLD);
                        title.setText(marker.getTitle());

                        TextView snippet = new TextView(getApplicationContext());
                        snippet.setTextColor(Color.GRAY);
                        snippet.setText(marker.getSnippet());

                        info.addView(title);
                        info.addView(snippet);

                        return info;
                    }
                });
            }
        });


    }

    String secToTime(int sec) {
        int seconds = sec % 60;
        int minutes = sec / 60;
        if (minutes >= 60) {
            int hours = minutes / 60;
            minutes %= 60;
            if (hours >= 24) {
                int days = hours / 24;
                return String.format("%d days %02d:%02d:%02d", days, hours % 24, minutes, seconds);
            }
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
        return String.format("00:%02d:%02d", minutes, seconds);
    }

    private double meterDistanceBetweenPoints(double lat_a, double lng_a, double lat_b, double lng_b) {
        float pk = (float) (180.f / Math.PI);

        double a1 = lat_a / pk;
        double a2 = lng_a / pk;
        double b1 = lat_b / pk;
        double b2 = lng_b / pk;

        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
        double t3 = Math.sin(a1) * Math.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);

        return 6366000 * tt;
    }

    public class gpsPoint {
        private double latitude;
        private double longitude;

        public gpsPoint(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }


        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    public String CalculateTimeDiffrence(String dateStart, String dateStop) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2018-08-07 23:08:42
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
            // in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;

            long diffMinutes = diff / (60 * 1000) % 60;

            long diffHours = diff / (60 * 60 * 1000) % 24;

            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days");

            System.out.print(diffHours + " hours, ");

            System.out.print(diffMinutes + " minutes, ");

            System.out.print(diffSeconds + " seconds.");

            int secound = Integer.valueOf((int) diff) / 1000;
            return "" + secToTime(secound);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return "";
    }
}