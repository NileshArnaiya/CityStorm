package crystal.Labs.stormy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import aptech.ListActivit;
import aptech.stormy.R;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



    }

    public void gotoMainList(View view) {



            Intent intent = new Intent(SplashScreen.this, ListActivit.class);
            startActivity(intent);
            finish();

    }
}
