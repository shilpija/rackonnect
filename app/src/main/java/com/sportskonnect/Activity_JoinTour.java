package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_JoinTour extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit;
    Typeface face;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jointour);

        init();
    }

    private void init() {

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Bold.otf");

        btnSubmit.setTypeface(face);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubmit:

                Intent intent = new Intent(Activity_JoinTour.this,Activity_Tour1.class);
                startActivity(intent);
                break;
        }
    }
}
