package com.sportskonnect;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Setting extends AppCompatActivity implements View.OnClickListener {

    Button btnPush;
    TextView main_text_title;
    Typeface face1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        init();
    }

    private void init() {

        btnPush = (Button) findViewById(R.id.btnPush);
        main_text_title = (TextView) findViewById(R.id.main_text_title);
        face1 = Typeface.createFromAsset(getAssets(), "fonts/" + "Calibre Bold.otf");
        main_text_title.setTypeface(face1);
        btnPush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPush:

//                Intent intent = new Intent(Activity_Setting.this, Activity_MatchDetails.class);
//                startActivity(intent);
                break;
        }
    }
}
