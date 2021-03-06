package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_StartScoring extends AppCompatActivity implements View.OnClickListener {

    TextView tvMin,tvName,tv1,tv2,tvPl;
    Typeface face1, face2;
    RelativeLayout relLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscoring);

        init();
    }

    private void init() {

        tvMin = (TextView)findViewById(R.id.tvMin);
        tvName = (TextView)findViewById(R.id.tvName);
        tvPl = (TextView)findViewById(R.id.tvPl);
        tv1 = (TextView)findViewById(R.id.tv1);
        relLayout = (RelativeLayout)findViewById(R.id.relLayout);
        relLayout.setOnClickListener(this);
        tv2 = (TextView)findViewById(R.id.tv2);
        face1 = Typeface.createFromAsset(getAssets(), "fonts/" + "Calibre Bold.otf");
        tvMin.setTypeface(face1);

        face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");
        tvName.setTypeface(face2);
        tv1.setTypeface(face2);
        tv2.setTypeface(face2);
        tvPl.setTypeface(face2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relLayout:

                Intent intent = new Intent(Activity_StartScoring.this,Activity_StartScoring1.class);
                startActivity(intent);

                break;
        }
    }
}
