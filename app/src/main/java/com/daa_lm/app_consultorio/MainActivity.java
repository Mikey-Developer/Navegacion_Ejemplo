package com.daa_lm.app_consultorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController control_nav;
    private AppBarConfiguration appbarConfig;
    private DrawerLayout drawerLayout;
    private NavigationView nav_view;

    private static final String TAG = "MainActivity: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            control_nav = Navigation.findNavController(this, R.id.nav_fragment);
            drawerLayout = findViewById(R.id.drawer_layout);

            nav_view = findViewById(R.id.nav_lateral);
            NavigationUI.setupWithNavController(nav_view, control_nav);

            appbarConfig = new AppBarConfiguration.Builder(R.id.inicio, R.id.citas)
                    .setOpenableLayout(drawerLayout)
                    .build();

            NavigationUI.setupActionBarWithNavController(this, control_nav, appbarConfig);
        }catch (Exception e){
            Log.i(TAG, e.getMessage());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_fragment);
        return NavigationUI.navigateUp(navController, appbarConfig);
    }
}