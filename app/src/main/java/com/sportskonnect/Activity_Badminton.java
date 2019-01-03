package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_Badminton extends AppCompatActivity implements View.OnClickListener, FragmentDrawer.FragmentDrawerListener {

    TextView tvFinalName, tvAvaPlayers, tvMin, tvAreaName, tvChat, tvName, tvAreaName2, tvChat1, tvName2, tvAreaName3, tvV1, tvJoinMa, main_text_title;
    LinearLayout llSingles, llDoubles, llSingle, llDouble;
    View view1, view2;
    String text = "<font color=#ffffff>RAC</font><font color=#00FF00>KONNECT</font>";
    Toolbar mToolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton);

        init();
    }

    private void init() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        tvFinalName = (TextView) findViewById(R.id.tvFinalName);
        tvAvaPlayers = (TextView) findViewById(R.id.tvAvaPlayers);
        tvMin = (TextView) findViewById(R.id.tvMin);
        tvAreaName = (TextView) findViewById(R.id.tvAreaName);
        tvAreaName2 = (TextView) findViewById(R.id.tvAreaName2);
        tvName = (TextView) findViewById(R.id.tvName);
        tvChat = (TextView) findViewById(R.id.tvChat);
        tvChat1 = (TextView) findViewById(R.id.tvChat1);
        tvName2 = (TextView) findViewById(R.id.tvName2);
        tvAreaName3 = (TextView) findViewById(R.id.tvAreaName3);
        tvJoinMa = (TextView) findViewById(R.id.tvJoinMa);
        main_text_title = (TextView) findViewById(R.id.main_text_title);
        tvV1 = (TextView) findViewById(R.id.tvV1);

        view1 = (View) findViewById(R.id.view1);
        view2 = (View) findViewById(R.id.view2);

        llDoubles = (LinearLayout) findViewById(R.id.llDoubles);
        llSingles = (LinearLayout) findViewById(R.id.llSingles);
        llSingle = (LinearLayout) findViewById(R.id.llSingle);
        llDouble = (LinearLayout) findViewById(R.id.llDouble);

        llSingle.setOnClickListener(this);
        llDouble.setOnClickListener(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Semibold.otf");

        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");

        tvFinalName.setTypeface(typeface);
        tvAvaPlayers.setTypeface(face2);
        tvChat.setTypeface(face2);
        tvChat1.setTypeface(face2);
        tvMin.setTypeface(face2);
        tvName2.setTypeface(face2);
        tvName.setTypeface(face2);
        tvJoinMa.setTypeface(face2);
        tvAreaName.setTypeface(typeface);
        tvAreaName2.setTypeface(typeface);
        tvAreaName3.setTypeface(typeface);
        tvV1.setTypeface(typeface);
        tvChat.setOnClickListener(this);
        tvChat1.setOnClickListener(this);
        main_text_title.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END);
        setSupportActionBar(mToolbar);

        FragmentDrawer drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, drawerLayout, mToolbar);
        drawerFragment.setDrawerListener(this);
        drawerLayout.setOnClickListener(this);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.llSingle:
                llSingles.setVisibility(View.VISIBLE);
                llDoubles.setVisibility(View.GONE);
                view1.setBackgroundResource(R.color.color_white);
                view2.setBackgroundResource(R.color.colorPrimary);
                tvAvaPlayers.setText("12 players available");
                break;

            case R.id.llDouble:
                llSingles.setVisibility(View.GONE);
                llDoubles.setVisibility(View.VISIBLE);
                view1.setBackgroundResource(R.color.colorPrimary);
                view2.setBackgroundResource(R.color.color_white);
                tvAvaPlayers.setText("5 matches available");
                break;

            case R.id.tvChat:
                Intent intent = new Intent(Activity_Badminton.this, Activity_Chat.class);
                startActivity(intent);
                break;

            case R.id.tvChat1:
                Intent intent1 = new Intent(Activity_Badminton.this, Activity_Chat.class);
                startActivity(intent1);
                break;

        }
    }
}
