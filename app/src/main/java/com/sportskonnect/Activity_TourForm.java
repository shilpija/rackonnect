package com.sportskonnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_TourForm extends AppCompatActivity implements View.OnClickListener {

    Button btnCreateTour;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourform);

        init();
    }

    private void init() {

        btnCreateTour = (Button)findViewById(R.id.btnCreateTour);
        btnCreateTour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreateTour:

                Intent intent = new Intent(Activity_TourForm.this, Activity_MatchDetails.class);
                startActivity(intent);
                break;
        }
    }
}
