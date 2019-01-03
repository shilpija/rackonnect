package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_updateProfile extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit , btnAdd;
    TextView main_text_title , tvHead , tvGender , tvMale , tvFemale;
    EditText etMobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        init();
    }

    private void init() {

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        main_text_title = (TextView) findViewById(R.id.main_text_title);
        etMobile = (EditText)findViewById(R.id.etMobile);

        tvHead = (TextView) findViewById(R.id.tvHead);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvMale = (TextView) findViewById(R.id.tvMale);
        tvFemale = (TextView) findViewById(R.id.tvFemale);

        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Bold.otf");

        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Regular.otf");

        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");

        btnAdd.setTypeface(face1);

        main_text_title.setTypeface(face);
        tvHead.setTypeface(face2);
        etMobile.setTypeface(face2);
        tvGender.setTypeface(face2);
        tvMale.setTypeface(face2);
        tvFemale.setTypeface(face2);
        btnSubmit.setTypeface(face2);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubmit:

                Intent intent = new Intent(Activity_updateProfile.this,Activity_ChooseSports.class);
                startActivity(intent);
                break;
        }
    }
}
