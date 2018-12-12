package com.example.equipo.procede;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Aperture extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,cliente.OnFragmentInteractionListener,proveedor.OnFragmentInteractionListener,productos.OnFragmentInteractionListener,compras.OnFragmentInteractionListener,ventas.OnFragmentInteractionListener,historial.OnFragmentInteractionListener,Sucursales.OnFragmentInteractionListener,fondo.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aperture);
        FragmentManager fragmentManager12 = getSupportFragmentManager();
        fragmentManager12.beginTransaction().replace(R.id.contenedor , new fondo()).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aperture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view
        // item clicks here.
        FragmentManager fragmentManager = getSupportFragmentManager();
        int id = item.getItemId();

        boolean frac = false;

        if (id == R.id.nav_client) {
            fragmentManager.beginTransaction().replace(R.id.contenedor , new cliente()).commit();


        } else if (id == R.id.nav_Providers) {
            fragmentManager.beginTransaction().replace(R.id.contenedor , new proveedor()).commit();

        } else if (id == R.id.nav_Products) {
            fragmentManager.beginTransaction().replace(R.id.contenedor , new productos()).commit();
        } else if (id == R.id.nav_Buy) {
            fragmentManager.beginTransaction().replace(R.id.contenedor , new compras()).commit();
        } else if (id == R.id.nav_Sale) {
            fragmentManager.beginTransaction().replace(R.id.contenedor , new ventas()).commit();
        } else if (id == R.id.nav_History) {
            fragmentManager.beginTransaction().replace(R.id.contenedor , new historial()).commit();
        } else if (id == R.id.nav_Sucursal) {
            fragmentManager.beginTransaction().replace(R.id.contenedor , new Sucursales()).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}