package com.iesvirgendelcarmen.dam.materialdesign11;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Material11 extends AppCompatActivity {

    private String titulo;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material11);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigator);

        titulo = getResources().getString(R.string.menu1_1);
        if(savedInstanceState == null) {
            respuesta(titulo);
        }

        setSupportActionBar(toolbar);
        final ActionBar abar = getSupportActionBar();

        if( abar != null){
            abar.setHomeAsUpIndicator(R.drawable.menu);
            abar.setDisplayHomeAsUpEnabled(true);
        }

        if (navigationView != null){
            configurarDrawer(navigationView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)){
            getMenuInflater().inflate(R.menu.main,menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.opcion1:
                Toast.makeText(getApplication(),"TOCADA OPCION 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion2:
                Toast.makeText(getApplication(),"TOCADA OPCION 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion3:
                Toast.makeText(getApplication(),"TOCADA OPCION 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion4:
                Toast.makeText(getApplication(),"TOCADA OPCION 4", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void configurarDrawer(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                String title = menuItem.getTitle().toString();
                respuesta(title);
                return true;
            }
        });
    }

    private void respuesta(String title){
        Toast.makeText(getBaseContext(), title, Toast.LENGTH_SHORT).show();
        Bundle args = new Bundle();
        args.putString(Fragmentos.ARG_SECTION_TITLE,title);
        Fragment fragment = Fragmentos.newInstance(title);
        fragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.contenido, fragment).commit();
        drawerLayout.closeDrawers();
        setTitle(title);
    }
}
