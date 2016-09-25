package aptech.stormy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentWeather {




    private String mIcon , mSummary;
    private long mTime;
    private long mSunriseTime;

    public long getmSunsetTime() {
        return mSunsetTime;

    }

    public String getSunsetTimeAm(){



        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getDefault());
        Date d = new Date(getmSunsetTime() * 1000 );
        String theString = formatter.format(d);
        return theString;


    }
    public String getSunriseTimeAm(){



        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getDefault());
        Date d = new Date(getmSunriseTime() * 1000 );
        String theString = formatter.format(d);
        return theString;


    }

    public void setmSunsetTime(long mSunsetTime) {
        this.mSunsetTime = mSunsetTime;

    }

    public long getmSunriseTime() {
        return mSunriseTime;
    }

    public void setmSunriseTime(long mSunriseTime) {
        this.mSunriseTime = mSunriseTime;
    }

    private long mSunsetTime;

    private double mTemp,mHumidity,mPrecipChance;



    public String getFormattedTime(){


        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getDefault());
        Date d = new Date(getmTime() * 1000 +10000 * 90 );
        String theString = formatter.format(d);
        return  theString;


    }

    public int getIconId(){


        int iconId= R.drawable.clear_day;
        if (mIcon.equals("clear-day")) {
            iconId = R.drawable.clear_day;
        }
        else if (mIcon.equals("clear-night")) {
            iconId = R.drawable.clear_night;
        }
        else if (mIcon.equals("rain")) {
            iconId = R.drawable.rain;
        }
        else if (mIcon.equals("snow")) {
            iconId = R.drawable.snow;
        }
        else if (mIcon.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (mIcon.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (mIcon.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (mIcon.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (mIcon.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (mIcon.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }
    return iconId;
    }



    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmSummary() {
        return mSummary;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public long getmTime() {
        return mTime;
    }

    public void setmTime(long mTime) {
        this.mTime = mTime;
    }

    public int getmTemp() {
        return (int) Math.round(mTemp);
    }

    public void setmTemp(double mTemp) {
        this.mTemp = mTemp;
    }

    public double getmHumidity() {
        return mHumidity * 100;
    }

    public void setmHumidity(double mHumidity) {
        this.mHumidity = mHumidity;
    }

    public double getmPrecipChance() {
        double percent =  mPrecipChance * 100;
        return (int)percent;
    }

    public void setmPrecipChance(double mPrecipChance) {
        this.mPrecipChance = mPrecipChance;
    }


}
