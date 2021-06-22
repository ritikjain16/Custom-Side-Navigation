package com.ritik.customnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ImageButton menu,close;
    private LinearLayout navigation_menu,menu_items,toolbar;
    private Animation menuAnimation;
    private FrameLayout frameLayout;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menu);
        close=findViewById(R.id.close);
        navigation_menu = findViewById(R.id.navigation_menu);
        menu_items=findViewById(R.id.menu_items);
        frameLayout=findViewById(R.id.framelayout);
        constraintLayout=findViewById(R.id.conslayout);
        toolbar=findViewById(R.id.toolbar);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuAnimation= AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_from_left);
                navigation_menu.setAnimation(menuAnimation);
                navigation_menu.setVisibility(View.VISIBLE);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuAnimation= AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slideout_from_left);
                navigation_menu.setAnimation(menuAnimation);
                navigation_menu.setVisibility(View.GONE);
            }
        });

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuAnimation= AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slideout_from_left);
                navigation_menu.setAnimation(menuAnimation);
                navigation_menu.setVisibility(View.GONE);
            }
        });

        setDefaultFragment(new HomeFragment());


        hideMenu(0,new HomeFragment(),"#E37B7B");
        hideMenu(1,new MyOrdersFragment(),"#7BE3D7");
        hideMenu(2,new MycartFragment(),"#8E7BE3");
        hideMenu(3,new MyWishlistFragment(),"#CCE37B");
        hideMenu(4,new SettingsFragment(),"#E37BC0");
        hideMenu(5,new HomeFragment(),"#E37B7B");

    }

    private void hideMenu(int pos, Fragment fragment, String color){

        menu_items.getChildAt(pos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuAnimation= AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slideout_from_left);
                navigation_menu.setAnimation(menuAnimation);
                navigation_menu.setAnimation(menuAnimation);
                navigation_menu.setVisibility(View.GONE);
//                toolbar.setBackgroundColor(Color.parseColor(color));
                setDefaultFragment(fragment);
            }
        });

    }

    private void setDefaultFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }


}