package com.example.hamodi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamodi.Admin.AddProductActivity;
import com.example.hamodi.Admin.ShowProduct;
import com.example.hamodi.User.CartFragment;
import com.example.hamodi.User.Homefragment;
import com.example.hamodi.User.Homefragment;
import com.example.hamodi.User.InfoFragment;
import com.example.hamodi.User.ProductFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    FirebaseAuth fauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        fauth = FirebaseAuth.getInstance();
        TextView username,email;
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FirebaseUser user = fauth.getCurrentUser();
        if (user != null) {
            if(user.getDisplayName().startsWith("admin:")){
                Intent i = new Intent(MainActivity.this, ShowProduct.class);
                startActivity(i);
            }
            View header = navigationView.getHeaderView(0);
            username = header.findViewById(R.id.tvUsermame);
            email = header.findViewById(R.id.tvUserEmail);
            username.setText(user.getEmail());
            email.setText(user.getEmail());

        } else {
            Intent i = new Intent(MainActivity.this,loginpage2.class);
            startActivity(i);
        }
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Homefragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(R.id.nav_home==item.getItemId()){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Homefragment()).commit();

        }
        else if(R.id.nav_Product==item.getItemId()){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductFragment()).commit();
        }
        else if(R.id.nav_Cart==item.getItemId()){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CartFragment()).commit();
        }
        else if(R.id.nav_Info==item.getItemId()){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InfoFragment()).commit();
        }
        else if(R.id.nav_logout==item.getItemId()){
            startActivity(new Intent(this,loginpage2.class));
            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}