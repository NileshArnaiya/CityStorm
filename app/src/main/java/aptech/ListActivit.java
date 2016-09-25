package aptech;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import aptech.stormy.Mumbai;
import aptech.stormy.R;
import crystal.Labs.stormy.Agra;
import crystal.Labs.stormy.Ahmedabad;
import crystal.Labs.stormy.Allahabad;
import crystal.Labs.stormy.Ambaji;
import crystal.Labs.stormy.Amritsar;
import crystal.Labs.stormy.Aurangabad;
import crystal.Labs.stormy.Ayodhya;
import crystal.Labs.stormy.Bengaluru;
import crystal.Labs.stormy.Bhopal;
import crystal.Labs.stormy.Bhuj;
import crystal.Labs.stormy.Bikaner;
import crystal.Labs.stormy.Chandigarh;
import crystal.Labs.stormy.Chennai;
import crystal.Labs.stormy.Chittorgarh;
import crystal.Labs.stormy.Coimbatore;
import crystal.Labs.stormy.Dalhousie;
import crystal.Labs.stormy.Darjeeling;
import crystal.Labs.stormy.Dharamsala;
import crystal.Labs.stormy.Gangtok;
import crystal.Labs.stormy.Goa;
import crystal.Labs.stormy.Gulmarg;
import crystal.Labs.stormy.Gurgaon;
import crystal.Labs.stormy.Guwahati;
import crystal.Labs.stormy.Gwalior;
import crystal.Labs.stormy.Haridwar;
import crystal.Labs.stormy.Hyderabad;
import crystal.Labs.stormy.Igatpuri;
import crystal.Labs.stormy.Indore;
import crystal.Labs.stormy.Jaipur;
import crystal.Labs.stormy.Jaisalmer;
import crystal.Labs.stormy.Jodhpur;
import crystal.Labs.stormy.Kanpur;
import crystal.Labs.stormy.Karjat;
import crystal.Labs.stormy.Kasauli;
import crystal.Labs.stormy.Kashmir;
import crystal.Labs.stormy.Kochi;
import crystal.Labs.stormy.Kodaikanal;
import crystal.Labs.stormy.Kolkata;
import crystal.Labs.stormy.Kufri;
import crystal.Labs.stormy.Kullu;
import crystal.Labs.stormy.Lavasa;
import crystal.Labs.stormy.Lehladak;
import crystal.Labs.stormy.Lonavla;
import crystal.Labs.stormy.Lucknow;
import crystal.Labs.stormy.Mahabaleshwar;
import crystal.Labs.stormy.Manali;
import crystal.Labs.stormy.Matheran;
import crystal.Labs.stormy.Mountabu;
import crystal.Labs.stormy.Mussoorie;
import crystal.Labs.stormy.Nagpur;
import crystal.Labs.stormy.Nainital;
import crystal.Labs.stormy.Nashik;
import crystal.Labs.stormy.Noida;
import crystal.Labs.stormy.Ooty;
import crystal.Labs.stormy.Palanpur;
import crystal.Labs.stormy.Panchgani;
import crystal.Labs.stormy.Panhala;
import crystal.Labs.stormy.Patna;
import crystal.Labs.stormy.Pune;
import crystal.Labs.stormy.Rajkot;
import crystal.Labs.stormy.Rishikesh;
import crystal.Labs.stormy.Rohtangpass;
import crystal.Labs.stormy.Saputara;
import crystal.Labs.stormy.Shillong;
import crystal.Labs.stormy.Shimla;
import crystal.Labs.stormy.Srinagar;
import crystal.Labs.stormy.Surat;
import crystal.Labs.stormy.Udaipur;
import crystal.Labs.stormy.Vadodara;
import crystal.Labs.stormy.Vapi;
import crystal.Labs.stormy.Varanasi;
import crystal.Labs.stormy.Vishakapatnam;
import crystal.Labs.stormy.newdelhi;

public class ListActivit extends ActionBarActivity {

        // List view
        private ListView listview;

        // Listview Adapter
        ArrayAdapter<String> adapter;


    // Search EditText
        EditText inputSearch;



        ArrayList<HashMap<String, String>> productList;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.listactivity_main);
           final LinearLayout listlayout = (LinearLayout) findViewById(R.id.listlayout);
           final Random random = new Random();






//            final Handler handler = new Handler();
//            Runnable runnable=new Runnable() {
//                @Override
//                public void run() {
//                    if (listlayout != null) {
//                        listlayout.setBackgroundResource(arrImg[randomNumber]);
//                    }
//                    handler.postDelayed(this,2000);
//
//                }
//            };
//            handler.postDelayed(runnable,2000);

            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                int i = 0;
                public void run() {
                    if (listlayout != null) {
                        int red = random.nextInt(200);
                        int blue = random.nextInt(200);
                        int green = random.nextInt(200);
                        listlayout.setBackgroundColor(Color.rgb(red,green,blue));

                    }
                    i++;
                    handler.postDelayed(this, 3400);  //for interval...
                }
            };
            handler.postDelayed(runnable, 2000); //for initial delay..


            // Listview Data
             String products[] = {"Mumbai", "Goa","Bengaluru", "Kolkata", "Jaipur", "Chennai", "Hyderabad", "Pune",
                    "Ahmedabad", "Agra","Ayodhya", "Surat", "Varanasi","Chandigarh","New Delhi","Vishakapatnam","Indore","Udaipur","Shimla","Lucknow","Kochi","Kanpur","Patna","Bhopal","Nagpur","Amritsar","Gwalior","Lonavla","Matheran","Mahabaleshwar","Karjat","Igatpuri","Lavasa","Noida","Nashik","Kodaikanal","Jodhpur","Gurgaon","Vadodara","Srinagar","Rishikesh","Dharamsala","Leh-Ladak","Mussoorie","Manali","Haridwar","Vapi","Bhuj","Ooty","Saputara","Kullu","Nainital","Kasauli","Rohtang Pass","Darjeeling","Kufri","Dalhousie","Gulmarg","Allahabad","Coimbatore","Guwahati","Panhala","Panchgani","Gangtok","Shillong","Rajkot","Jaisalmer","Bikaner","Kashmir","Chittorgarh","Aurangabad","Ambaji","Mount Abu", "Palanpur"};

            listview = (ListView) findViewById(R.id.list_view);
            inputSearch = (EditText) findViewById(R.id.inputSearch);
            List<String> sortedMonthsList = Arrays.asList(products);
            Collections.sort(sortedMonthsList);

            products = (String[]) sortedMonthsList.toArray();
            adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
            listview.setAdapter(adapter);
            inputSearch.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                    ListActivit.this.adapter.getFilter().filter(cs);

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                }

                @Override
                public void afterTextChanged(Editable arg0) {


                }
            });



            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String a = (String) parent.getAdapter().getItem(position);

                    if(a ==  "Mumbai"){
                        Intent intent = new Intent(ListActivit.this, Mumbai.class);
                        startActivity(intent);

                    }

                    if(a ==  "Bengaluru"){
                        Intent intent = new Intent(ListActivit.this, Bengaluru.class);
                        startActivity(intent);

                    }


                    if(a ==  "Kolkata"){
                        Intent intent = new Intent(ListActivit.this, Kolkata.class);
                        startActivity(intent);

                    }
                    if(a ==  "Jaipur"){
                        Intent intent = new Intent(ListActivit.this, Jaipur.class);
                        startActivity(intent);

                    }
                    if(a ==  "Chennai"){
                        Intent intent = new Intent(ListActivit.this, Chennai.class);
                        startActivity(intent);

                    }

                    if(a ==  "Hyderabad"){
                        Intent intent = new Intent(ListActivit.this, Hyderabad.class);
                        startActivity(intent);

                    }


                    if(a ==  "Pune"){
                        Intent intent = new Intent(ListActivit.this, Pune.class);
                        startActivity(intent);

                    }

                    if(a ==  "Goa"){
                        Intent intent = new Intent(ListActivit.this, Goa.class);
                        startActivity(intent);

                    }

                    if(a ==  "Ahmedabad"){
                        Intent intent = new Intent(ListActivit.this, Ahmedabad.class);
                        startActivity(intent);

                    }

                    if(a ==  "Agra"){
                        Intent intent = new Intent(ListActivit.this, Agra.class);
                        startActivity(intent);

                    }
                    if(a ==  "Ayodhya"){
                        Intent intent = new Intent(ListActivit.this, Ayodhya.class);
                        startActivity(intent);

                    }
                    if(a ==  "Surat"){
                        Intent intent = new Intent(ListActivit.this, Surat.class);
                        startActivity(intent);

                    }
                    if(a ==  "Varanasi"){
                        Intent intent = new Intent(ListActivit.this, Varanasi.class);
                        startActivity(intent);

                    }
                    if(a ==  "Chandigarh"){
                        Intent intent = new Intent(ListActivit.this, Chandigarh.class);
                        startActivity(intent);

                    }
                    if(a ==  "New Delhi"){
                        Intent intent = new Intent(ListActivit.this, newdelhi.class);
                        startActivity(intent);

                    }
                    if(a ==  "Vishakapatnam"){
                        Intent intent = new Intent(ListActivit.this, Vishakapatnam.class);
                        startActivity(intent);

                    }

                    if(a ==  "Indore"){
                        Intent intent = new Intent(ListActivit.this, Indore.class);
                        startActivity(intent);

                    }

                    if(a ==  "Udaipur"){
                        Intent intent = new Intent(ListActivit.this, Udaipur.class);
                        startActivity(intent);

                    }

                    if(a ==  "Shimla"){
                        Intent intent = new Intent(ListActivit.this, Shimla.class);
                        startActivity(intent);

                    }
                    if(a ==  "Lucknow"){
                        Intent intent = new Intent(ListActivit.this, Lucknow.class);
                        startActivity(intent);

                    }
                    if(a ==  "Kochi"){
                        Intent intent = new Intent(ListActivit.this, Kochi.class);
                        startActivity(intent);

                    }
                    if(a ==  "Kanpur"){
                        Intent intent = new Intent(ListActivit.this, Kanpur.class);
                        startActivity(intent);

                    }
                    if(a ==  "Patna"){
                        Intent intent = new Intent(ListActivit.this, Patna.class);
                        startActivity(intent);

                    }
                    if(a ==  "Bhopal"){
                        Intent intent = new Intent(ListActivit.this, Bhopal.class);
                        startActivity(intent);

                    }
                    if(a ==  "Nagpur"){
                        Intent intent = new Intent(ListActivit.this, Nagpur.class);
                        startActivity(intent);

                    }
                    if(a ==  "Amritsar"){
                        Intent intent = new Intent(ListActivit.this, Amritsar.class);
                        startActivity(intent);

                    }
                    if(a ==  "Gwalior"){
                        Intent intent = new Intent(ListActivit.this, Gwalior.class);
                        startActivity(intent);

                    }
                    if(a ==  "Lonavla"){
                        Intent intent = new Intent(ListActivit.this, Lonavla.class);
                        startActivity(intent);

                    }
                    if(a ==  "Matheran"){
                        Intent intent = new Intent(ListActivit.this, Matheran.class);
                        startActivity(intent);

                    }
                    if(a ==  "Mahabaleshwar"){
                        Intent intent = new Intent(ListActivit.this, Mahabaleshwar.class);
                        startActivity(intent);

                    }
                    if(a ==  "Karjat"){
                        Intent intent = new Intent(ListActivit.this, Karjat.class);
                        startActivity(intent);

                    }
                    if(a ==  "Igatpuri"){
                        Intent intent = new Intent(ListActivit.this, Igatpuri.class);
                        startActivity(intent);

                    }
                    if(a ==  "Lavasa"){
                        Intent intent = new Intent(ListActivit.this, Lavasa.class);
                        startActivity(intent);

                    }
                    if(a ==  "Noida"){
                        Intent intent = new Intent(ListActivit.this, Noida.class);
                        startActivity(intent);

                    }
                    if(a ==  "Nashik"){
                        Intent intent = new Intent(ListActivit.this, Nashik.class);
                        startActivity(intent);

                    }
                    if(a ==  "Kodaikanal"){
                        Intent intent = new Intent(ListActivit.this, Kodaikanal.class);
                        startActivity(intent);

                    }
                    if(a ==  "Jodhpur"){
                        Intent intent = new Intent(ListActivit.this, Jodhpur.class);
                        startActivity(intent);

                    }
                    if(a ==  "Gurgaon"){
                        Intent intent = new Intent(ListActivit.this, Gurgaon.class);
                        startActivity(intent);

                    }
                    if(a ==  "Vadodara"){
                        Intent intent = new Intent(ListActivit.this, Vadodara.class);
                        startActivity(intent);

                    }
                    if(a ==  "Srinagar"){
                        Intent intent = new Intent(ListActivit.this, Srinagar.class);
                        startActivity(intent);

                    }
                    if(a ==  "Rishikesh"){
                        Intent intent = new Intent(ListActivit.this, Rishikesh.class);
                        startActivity(intent);

                    }
                    if(a ==  "Dharamsala"){
                        Intent intent = new Intent(ListActivit.this, Dharamsala.class);
                        startActivity(intent);

                    }
                    if(a ==  "Leh-Ladak"){
                        Intent intent = new Intent(ListActivit.this, Lehladak.class);
                        startActivity(intent);

                    }
                    if(a ==  "Mussoorie"){
                        Intent intent = new Intent(ListActivit.this, Mussoorie.class);
                        startActivity(intent);

                    }
                    if(a ==  "Manali"){
                        Intent intent = new Intent(ListActivit.this, Manali.class);
                        startActivity(intent);

                    }
                    if(a ==  "Haridwar"){
                        Intent intent = new Intent(ListActivit.this, Haridwar.class);
                        startActivity(intent);

                    }
                    if(a ==  "Vapi"){
                        Intent intent = new Intent(ListActivit.this, Vapi.class);
                        startActivity(intent);

                    }
                    if(a ==  "Palanpur"){
                        Intent intent = new Intent(ListActivit.this, Palanpur.class);
                        startActivity(intent);

                    }
                    if(a ==  "Bhuj"){
                        Intent intent = new Intent(ListActivit.this, Bhuj.class);
                        startActivity(intent);

                    }
                    if(a ==  "Ooty"){
                        Intent intent = new Intent(ListActivit.this, Ooty.class);
                        startActivity(intent);

                    }
                    if(a ==  "Saputara"){
                        Intent intent = new Intent(ListActivit.this, Saputara.class);
                        startActivity(intent);

                    }



                    if(a ==  "Kullu"){
                        Intent intent = new Intent(ListActivit.this, Kullu.class);
                        startActivity(intent);

                    }
                    if(a ==  "Nainital"){
                        Intent intent = new Intent(ListActivit.this, Nainital.class);
                        startActivity(intent);

                    }
                    if(a ==  "Kasauli"){
                        Intent intent = new Intent(ListActivit.this, Kasauli.class);
                        startActivity(intent);

                    }
                    if(a ==  "Rohtang Pass"){
                        Intent intent = new Intent(ListActivit.this, Rohtangpass.class);
                        startActivity(intent);

                    }
                    if(a ==  "Darjeeling"){
                        Intent intent = new Intent(ListActivit.this, Darjeeling.class);
                        startActivity(intent);

                    }
                    if(a ==  "Kufri"){
                        Intent intent = new Intent(ListActivit.this, Kufri.class);
                        startActivity(intent);

                    }
                    if(a ==  "Dalhousie"){
                        Intent intent = new Intent(ListActivit.this, Dalhousie.class);
                        startActivity(intent);

                    }
                    if(a ==  "Gulmarg"){
                        Intent intent = new Intent(ListActivit.this, Gulmarg.class);
                        startActivity(intent);

                    }
                    if(a ==  "Allahabad"){
                        Intent intent = new Intent(ListActivit.this, Allahabad.class);
                        startActivity(intent);

                    }
                    if(a ==  "Coimbatore"){
                        Intent intent = new Intent(ListActivit.this, Coimbatore.class);
                        startActivity(intent);

                    }
                    if(a ==  "Guwahati"){
                        Intent intent = new Intent(ListActivit.this, Guwahati.class);
                        startActivity(intent);

                    }
                    if(a ==  "Panhala"){
                        Intent intent = new Intent(ListActivit.this, Panhala.class);
                        startActivity(intent);

                    }




                    if(a ==  "Panchgani"){
                        Intent intent = new Intent(ListActivit.this, Panchgani.class);
                        startActivity(intent);

                    }
                    if(a ==  "Gangtok"){
                        Intent intent = new Intent(ListActivit.this, Gangtok.class);
                        startActivity(intent);

                    }
                    if(a ==  "Shillong"){
                        Intent intent = new Intent(ListActivit.this, Shillong.class);
                        startActivity(intent);

                    }
                    if(a ==  "Rajkot"){
                        Intent intent = new Intent(ListActivit.this, Rajkot.class);
                        startActivity(intent);

                    }
                    if(a ==  "Jaisalmer"){
                        Intent intent = new Intent(ListActivit.this, Jaisalmer.class);
                        startActivity(intent);

                    }
                    if(a ==  "Bikaner"){
                        Intent intent = new Intent(ListActivit.this, Bikaner.class);
                        startActivity(intent);

                    }
                    if(a ==  "Kashmir"){
                        Intent intent = new Intent(ListActivit.this, Kashmir.class);
                        startActivity(intent);

                    }
                    if(a ==  "Chittorgarh"){
                        Intent intent = new Intent(ListActivit.this, Chittorgarh.class);
                        startActivity(intent);

                    }
                    if(a ==  "Aurangabad"){
                        Intent intent = new Intent(ListActivit.this, Aurangabad.class);
                        startActivity(intent);

                    }
                    if(a ==  "Ambaji"){
                        Intent intent = new Intent(ListActivit.this, Ambaji.class);
                        startActivity(intent);

                    }
                    if(a ==  "Mount Abu"){
                        Intent intent = new Intent(ListActivit.this, Mountabu.class);
                        startActivity(intent);

                    }












                }
            });

        }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }

    public void clear(View view) {

       inputSearch.setText("");


    }


}


