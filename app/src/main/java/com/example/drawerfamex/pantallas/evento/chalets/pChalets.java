package com.example.drawerfamex.pantallas.evento.chalets;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

import com.example.drawerfamex.TabAdapter3;
import com.example.drawerfamex.adapters.pMenu;
import com.example.drawerfamex.pantallas.evento.pabellones.FragPabs;
import com.example.drawerfamex.popups.tutorial.fragPantallaTutorial;
import com.example.drawerfamex.R;
import com.google.android.material.tabs.TabLayout;

public class pChalets extends pMenu {

    private boolean francia = false;
    private final String claveFR = "FR";
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.aah_8_chalets);
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        if(getIntent().hasExtra(claveFR)){
            francia = getIntent().getBooleanExtra(claveFR,false);
        }

        FragChalets fragment = new FragChalets(francia,prefs.getInt(IDIOMA_POP,0));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framechalets, fragment, "ff");
        //fragment.setVa
        ft.commit();



            drawerLayout = findViewById(R.id.drawer_Layout);
            tabLayout = findViewById(R.id.mytabLayout);
            viewPager = findViewById(R.id.myViewPager);

            //Code for the TabAdapter
            //Use to join TabLayout with ViewPager
        if(!francia) {
            tabLayout.setVisibility(View.INVISIBLE);
            viewPager.setVisibility(View.INVISIBLE);
        }
            tabLayout.setupWithViewPager(viewPager);
            TabAdapter3 tabAdapter = new TabAdapter3(getSupportFragmentManager());
            tabAdapter.addFragments(new FragChalPab(2, francia, prefs.getInt(IDIOMA_POP, 0)), "C");
            tabAdapter.addFragments(new FragChalPab(5, francia, prefs.getInt(IDIOMA_POP, 0)), "F");
            viewPager.setAdapter(tabAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //Pantalla tutorial
   /*     SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.p_chalets), false);

        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.p_chalets), Boolean.TRUE);
            edit.commit();
            fragPantallaTutorial popup = new fragPantallaTutorial(5);
            popup.show(getSupportFragmentManager(),"DialogFrag");
        }*/

    }


    public static void closeDrawer(DrawerLayout drawerLayout) {
        //CloseDrawerLayout
        //Check for Condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When Drawer is Open
            //Close Drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize Intent
        Intent intent = new Intent(activity,aClass);
        //SetFlag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start Activity
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        closeDrawer(drawerLayout);
    }

}