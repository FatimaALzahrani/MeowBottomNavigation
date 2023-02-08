package com.example.meowbottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation=findViewById(R.id.navi);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.fu));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_add));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.cartt));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_person));
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(),"Clicked " +item.getId(),Toast.LENGTH_LONG).show();
            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment;
                if (item.getId() == 2) {
                    fragment=new all();
                }else if (item.getId() == 3) {
                    fragment=new add();
                }else if (item.getId() == 4) {
                    fragment=new Cart();
                }else if(item.getId()==5){
                    fragment=new Profile();
                } else
                    fragment = new Home();
                loadFragment(fragment);
            }
        });
        bottomNavigation.show(1,true);
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "Reselected " + item.getId(), Toast.LENGTH_LONG).show();
            }
            });

        bottomNavigation.setCount(4,"5");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }
    //define a load method to feed the screen
    private void loadFragment(Fragment fragment) {
        //replace the fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag,fragment, null)
                .commit();
}
}