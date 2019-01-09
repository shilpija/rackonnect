package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Splash extends AppCompatActivity {

    Button btnStart;
    TextView tvWel,tvWel1;
    Typeface typeface,typeface1;
    String first = "TO";
    String Second = "<font color=#ffffff>  <b> RAC</font><font color=#00FF00>KONNECT  <b> </font>";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    private void init() {

        tvWel = (TextView)findViewById(R.id.tvWel);
        tvWel1 = (TextView)findViewById(R.id.tvWel1);
        btnStart = (Button)findViewById(R.id.btnStart);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/" + "Akzidenz Grotesk Next Bold.otf");
        typeface1 = Typeface.createFromAsset(getAssets(), "fonts/" + "Calibre Bold.otf");
        tvWel.setTypeface(typeface);

        tvWel1.setText(Html.fromHtml(first + "  " + Second));
        tvWel1.setTypeface(typeface1);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Calibre Black.otf");
        btnStart.setTypeface(typeface1);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Splash.this,Activity_Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
