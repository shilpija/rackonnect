package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Activity_TourList extends AppCompatActivity implements View.OnClickListener {

    TextView tvName2,tvName12,tvJoinMa,tvJoinMa1;
    Typeface face2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourlist);

        init();
    }

    private void init() {

        tvName2 = (TextView)findViewById(R.id.tvName2);
        tvName12 = (TextView)findViewById(R.id.tvName12);
        tvJoinMa = (TextView)findViewById(R.id.tvJoinMa);
        tvJoinMa1 = (TextView)findViewById(R.id.tvJoinMa1);
        face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");

        tvName2.setTypeface(face2);
        tvName12.setTypeface(face2);
        tvJoinMa.setTypeface(face2);
        tvJoinMa1.setTypeface(face2);
        tvJoinMa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvJoinMa:

                Intent intent = new Intent(Activity_TourList.this,Activity_TourForm.class);
                startActivity(intent);
                break;
        }
    }
}
