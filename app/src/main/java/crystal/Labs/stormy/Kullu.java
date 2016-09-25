package crystal.Labs.stormy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

import aptech.stormy.CurrentWeather;
import aptech.stormy.Mumbai;
import aptech.stormy.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Kullu extends AppCompatActivity {

    public static final String TAG = Mumbai.class.getSimpleName();
    private CurrentWeather current;
    Runnable refresh;


    private TextView temperature;
    private TextView time;
    private TextView location;
    private TextView humidity;
    private TextView rain;
    private TextView summary;
    private ImageView iconview;

    private TextView msunrise;
    private TextView msunset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullu);
        msunrise = (TextView) findViewById(R.id.sunrise);
        msunset = (TextView) findViewById(R.id.sunset);
        SwipeRefreshLayout swiper;
        swiper = (SwipeRefreshLayout) findViewById(R.id.swiper);
        if (swiper != null) {
            swiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    Toast.makeText(getApplicationContext(), "Data Refreshed", Toast.LENGTH_SHORT).show();
                    refreshForecaster();
                }
            });
        }
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7459061532362827/4305904390");


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        temperature = (TextView) findViewById(R.id.temperature);
        location = (TextView) findViewById(R.id.LocationLabel);
        time = (TextView) findViewById(R.id.time);
        summary = (TextView) findViewById(R.id.textView);
        humidity = (TextView) findViewById(R.id.humidityValue);
        rain = (TextView) findViewById(R.id.rainprobab);
        iconview = (ImageView) findViewById(R.id.IconimageView);

        RelativeLayout relativeLayout;
        relativeLayout = (RelativeLayout) findViewById(R.id.kullu);
        TextView humidityLabel = (TextView) findViewById(R.id.HumidityLabel);
        TextView rainLabel = (TextView) findViewById(R.id.rainLabel);
        TextView msunriseLabel;
        TextView msunsetLabel;
        msunriseLabel = (TextView) findViewById(R.id.sunriseLabel);
        msunsetLabel = (TextView) findViewById(R.id.sunsetLabel);
        Random random = new Random();
        int red = random.nextInt(200);
        int green = random.nextInt(200);
        int blue = random.nextInt(200);
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(Color.rgb(red, green, blue));
        }
        if (red > 150 && green > 150 && blue > 150) {

            temperature.setTextColor(Color.BLACK);
            location.setTextColor(Color.BLACK);
            time.setTextColor(Color.BLACK);
            summary.setTextColor(Color.BLACK);
            humidity.setTextColor(Color.BLACK);
            rain.setTextColor(Color.BLACK);
            msunrise.setTextColor(Color.BLACK);
            msunset.setTextColor(Color.BLACK);
            humidityLabel.setTextColor(Color.BLACK);
            rainLabel.setTextColor(Color.BLACK);
            msunriseLabel.setTextColor(Color.BLACK);
            msunsetLabel.setTextColor(Color.BLACK);

        } else {
            temperature.setTextColor(Color.WHITE);
            location.setTextColor(Color.WHITE);
            humidity.setTextColor(Color.WHITE);
            rain.setTextColor(Color.WHITE);
            time.setTextColor(Color.WHITE);
            summary.setTextColor(Color.WHITE);
            msunset.setTextColor(Color.WHITE);
            msunrise.setTextColor(Color.WHITE);
            msunriseLabel.setTextColor(Color.WHITE);
            msunsetLabel.setTextColor(Color.WHITE);
        }
        refreshForecaster();
//        final Handler handler = new Handler();
//
//
//        refresh = new Runnable() {
//            @Override
//            public void run() {
//                refreshForecaster();
//                handler.postDelayed(refresh,180000);
//                refreshForecaster();
//            }
//        };
//        handler.post(refresh);




    }


    public void moreinfo(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Kullu"));
        startActivity(browserIntent);


    }


    private void refreshForecaster() {

        if (isNetworkThere()) {


            String apiKey = "f54021bfc6e536f70c212e24c1b628dc";
            double latitude = 31.8246     ;
            double longitude = 77.4702;
            String forecastUrl = "https://api.forecast.io/forecast/" + apiKey + "/" + latitude + "," + longitude;


            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(forecastUrl).build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                    Log.e(TAG, "Excaught");


                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });

                    try {

                        String jsondata = response.body().string();
                        if (response.isSuccessful()) {
                            current = getAllDetails(jsondata);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    temperature.setText((current.getmTemp() - 32) * 5 / 9 + "");
                                    time.setText("AT " + current.getFormattedTime() + " it will be");
                                    humidity.setText(current.getmHumidity() + "%");
                                    rain.setText(current.getmPrecipChance() + "%");
                                    summary.setText(current.getmSummary() + "");
                                    Drawable drawable = getResources().getDrawable(current.getIconId());
                                    iconview.setImageDrawable(drawable);
                                    location.setText("Kullu, India");
                                    msunrise.setText(current.getSunriseTimeAm() + "");
                                    msunset.setText( current.getSunsetTimeAm() + "");


                                }
                            });


                        } else {
                            Handler a = new Handler(Looper.getMainLooper());
                            a.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Kullu.this, "What's up something wrong ?", Toast.LENGTH_SHORT).show();
                                }
                            }, 500);


                        }
                    } catch (JSONException e)

                    {
                        Log.e(TAG, "JSON caught", e);

                    }


                }
            });
        } else {

            Toast.makeText(Kullu.this, "Network is Unavailable", Toast.LENGTH_SHORT).show();
        }
    }


    private CurrentWeather getAllDetails(String jsondata) throws JSONException {
        JSONObject forecast = new JSONObject(jsondata);


        JSONObject currentForecast = forecast.getJSONObject("currently");

        JSONObject dailyForecast = forecast.getJSONObject("daily");
        JSONArray dailyArray = dailyForecast.getJSONArray("data");
        JSONObject arrayfromdata;


        arrayfromdata = dailyArray.getJSONObject(0);


        Log.i("aa", "sha" + time);


        CurrentWeather curr = new CurrentWeather();
        curr.setmHumidity(currentForecast.getDouble("humidity"));
        curr.setmTime(currentForecast.getLong("time"));
        curr.setmIcon(currentForecast.getString("icon"));
        curr.setmPrecipChance(currentForecast.getDouble("precipProbability"));
        curr.setmSummary(currentForecast.getString("summary"));
        curr.setmTemp(currentForecast.getDouble("temperature"));
        curr.setmSunriseTime(arrayfromdata.getLong("sunriseTime"));
        curr.setmSunsetTime(arrayfromdata.getLong("sunsetTime"));


        return curr;

    }

    private boolean isNetworkThere() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {

            isAvailable = true;
        }
        return isAvailable;

    }
}

