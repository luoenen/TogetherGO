package com.huel.luosenen.togethergo.core;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.huel.luosenen.togethergo.R;
import com.huel.luosenen.togethergo.fragment.FragmentFive;
import com.huel.luosenen.togethergo.fragment.FragmentFour;
import com.huel.luosenen.togethergo.fragment.FragmentOne;
import com.huel.luosenen.togethergo.fragment.FragmentSix;
import com.huel.luosenen.togethergo.fragment.FragmentThree;
import com.huel.luosenen.togethergo.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private FragmentFour fragmentFour;
    private FragmentFive fragmentFive;
    private FragmentSix fragmentSix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
        getMenuInflater().inflate(R.menu.main, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        if (id == R.id.information) {

            showNav(R.id.information);

        } else if (id == R.id.setting) {

            showNav(R.id.setting);
        } else if (id == R.id.beginning) {

            showNav(R.id.beginning);
        } else if (id == R.id.update) {

            showNav(R.id.update);
        } else if (id == R.id.share) {

            showNav(R.id.share);
        } else if (id == R.id.send) {

            showNav(R.id.send);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init(){
        fragmentOne=new FragmentOne();
        fragmentTwo=new FragmentTwo();
        fragmentThree=new FragmentThree();
        fragmentFour = new FragmentFour();
        fragmentFive = new FragmentFive();
        fragmentSix = new FragmentSix();
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.content,fragmentOne).add(R.id.content,fragmentTwo).add(R.id.content,fragmentThree).add(R.id.content,fragmentFour).add(R.id.content,fragmentFive).add(R.id.content,fragmentSix);//开启一个事务将fragment动态加载到组件
        beginTransaction.hide(fragmentOne).hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);//隐藏fragment
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        showNav(R.id.beginning);
    }
    private void showNav(int id){
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        switch (id){
            case R.id.information:
                beginTransaction.hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);
                beginTransaction.show(fragmentOne);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.setting:
                beginTransaction.hide(fragmentOne).hide(fragmentThree).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);
                beginTransaction.show(fragmentTwo);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.beginning:
                beginTransaction.hide(fragmentTwo).hide(fragmentOne).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);
                beginTransaction.show(fragmentThree);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.update:
                beginTransaction.hide(fragmentTwo).hide(fragmentOne).hide(fragmentThree).hide(fragmentFive).hide(fragmentSix);
                beginTransaction.show(fragmentFour);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.share:
                beginTransaction.hide(fragmentTwo).hide(fragmentOne).hide(fragmentThree).hide(fragmentFour).hide(fragmentSix);
                beginTransaction.show(fragmentFive);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.send:
                beginTransaction.hide(fragmentSix).hide(fragmentOne).hide(fragmentThree).hide(fragmentFour).hide(fragmentFive);
                beginTransaction.show(fragmentSix);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
        }
    }

}

