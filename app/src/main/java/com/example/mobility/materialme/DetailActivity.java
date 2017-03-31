package com.example.mobility.materialme;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        if(drawer !=null){
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener(this);
        }
        TextView sportTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView sportImage = (ImageView)findViewById(R.id.sportsImageDetail);
        sportTitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent().getIntExtra("imageResource",0)).into(sportImage);

    }


    public void favourite(View view) {
        Toast.makeText(this, "you have maked it as favourite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        switch ((item.getItemId())){
            case R.id.nav_camera:
                displayToast(getString(R.string.choose_camera));
                drawer.closeDrawer(GravityCompat.START);

                return true;
            case R.id.nav_gallery:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.choose_gallery));
                return true;
            case R.id.nav_manage:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.choose_tools));
                return true;
            case R.id.nav_slideshow:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.choose_slideshow));
                return true;
            case R.id.nav_share:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.choose_share));
                return true;
            case R.id.nav_send:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.choose_send));
                return true;
            default:
                return false;
        }

    }

    private void displayToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
