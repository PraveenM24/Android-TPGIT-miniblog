package com.example.tpgit_miniblog;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        Home_page.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        Home_page.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        Home_page.redirectActivity(this,Home_page.class);
    }
    public void ClickProfile(View view){
        recreate();
    }
    public void ClickContactUs(View view){
        Home_page.redirectActivity(this,ContactUs.class);
    }
    public void ClickLogout(View view){
        Home_page.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Home_page.closeDrawer(drawerLayout);
    }
}