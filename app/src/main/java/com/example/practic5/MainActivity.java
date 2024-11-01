package com.example.practic5;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new FirstFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.exit) {
                    setFragment(new ExitFragment());
                } else if (id==R.id.home) {
                    setFragment(new HomeFragment());
                } else if (id==R.id.info) {
                    setFragment(new InfoFragment());
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.action_settings){
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.firstflag) {
            setFragment(new FirstFragment());
        } else if (id==R.id.secondflag) {
            setFragment(new SecondFragment());
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.selectedMenu,fragment,null).commit();
    }
}