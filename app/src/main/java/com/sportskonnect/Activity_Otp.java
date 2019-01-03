package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Otp extends AppCompatActivity implements View.OnClickListener {

    String mobile, numGet;
    TextView Tvphn , tvHead;
    Button btnSubmit;
    EditText etMobile;
    TextView main_text_title , give_us_a_review_landmine_text_2 , tvResend;
    String text = "<font color=#ffffff>RAC</font><font color=#00FF00>KONNECT</font>";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        init();
    }

    private void init() {

        main_text_title = (TextView) findViewById(R.id.main_text_title);
        tvHead = (TextView) findViewById(R.id.tvHead);
        give_us_a_review_landmine_text_2 = (TextView) findViewById(R.id.give_us_a_review_landmine_text_2);
        tvResend = (TextView) findViewById(R.id.tvResend);

        main_text_title.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);

        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Bold.otf");

        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Regular.otf");

        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");
        main_text_title.setTypeface(face);
        tvHead.setTypeface(face1);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mobile = bundle.getString("mobile");
            Log.d("mobileGet", mobile);
        }

        Tvphn = (TextView) findViewById(R.id.Tvphn);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        etMobile = (EditText) findViewById(R.id.etMobile);
        btnSubmit.setOnClickListener(this);
        Tvphn.setText("+91" + " " + mobile);
        Tvphn.setTypeface(face1);
        etMobile.setTypeface(face2);
        btnSubmit.setTypeface(face2);
        give_us_a_review_landmine_text_2.setTypeface(face2);
        tvResend.setTypeface(face2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSubmit:

                numGet = etMobile.getText().toString().trim();

                if (!numGet.isEmpty()) {
                    Intent intent = new Intent(Activity_Otp.this, Activity_updateProfile.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
