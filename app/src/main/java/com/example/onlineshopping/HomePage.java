package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.adapter.ProductAdapter;
import com.example.onlineshopping.adapter.ProductCategoryAdapter;
import com.example.onlineshopping.model.ProductCategory;
import com.example.onlineshopping.model.Products;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;
    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Trending"));
        productCategoryList.add(new ProductCategory(2, "Most Popular"));
        productCategoryList.add(new ProductCategory(3, "All Fashion Products"));
        productCategoryList.add(new ProductCategory(4, "Men"));
        productCategoryList.add(new ProductCategory(5, "Women"));
        productCategoryList.add(new ProductCategory(6, "Kids"));
        productCategoryList.add(new ProductCategory(7, "Baby"));

        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Floral White Frock", "M", "Rs.7500", R.drawable.frock4));
        productsList.add(new Products(2, "Ladies Watch", "Pink", "Rs.1500", R.drawable.watch));
        productsList.add(new Products(1, "Designer Saree", "Green", "Rs.9000", R.drawable.saree));
        productsList.add(new Products(2, "Fashionable Lehenga", "Blue", "Rs.10000", R.drawable.lehenga));
        productsList.add(new Products(1, "Handmade Jwellery", "Silver & Thread", "Rs.1000", R.drawable.jewellery));
        productsList.add(new Products(2, "Ladies Wallet", "Pink", "Rs.750", R.drawable.ladwallet));

        setProdItemRecycler(productsList);

    }




    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;

                case R.id.nav_men_fashion:
                Intent intent = new Intent(HomePage.this,MenFashion.class);
                startActivity(intent);
                break;

                case R.id.nav_kids_fashion:
                    intent = new Intent(HomePage.this, KidsFashion.class);
                startActivity(intent);
                break;

                case R.id.nav_women_fashion:
                intent = new Intent(HomePage.this, WomenFashion.class);
                startActivity(intent);
                break;

                case R.id.nav_profile:
                intent = new Intent(HomePage.this, Profile.class);
                startActivity(intent);
                break;

                case R.id.nav_rate:
                intent = new Intent(HomePage.this, StarRating.class);
                startActivity(intent);
                break;

                case R.id.nav_login: menu.findItem(R.id.nav_logout).setVisible(true);
                menu.findItem(R.id.nav_profile).setVisible(true);
                menu.findItem(R.id.nav_login).setVisible(false);
                break;


                case R.id.nav_logout: menu.findItem(R.id.nav_logout).setVisible(false);
                menu.findItem(R.id.nav_login).setVisible(true);
                break;
            case R.id.nav_share: Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
            break;
        }
         return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }
}