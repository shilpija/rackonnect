package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_MatchDetails3 extends AppCompatActivity implements View.OnClickListener {

    TextView main_text_title;
    Typeface face1;
    Button btnJoin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchdetails3);

        init();
    }

    private void init() {

        main_text_title = (TextView) findViewById(R.id.main_text_title);
        btnJoin = (Button)findViewById(R.id.btnJoin);
        face1 = Typeface.createFromAsset(getAssets(), "fonts/" + "Calibre Bold.otf");
        main_text_title.setTypeface(face1);
        btnJoin.setTypeface(face1);
        btnJoin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnJoin:

                Intent intent = new Intent(Activity_MatchDetails3.this,Activity_MatchScoringReq.class);
                startActivity(intent);

                break;
        }
    }
}
