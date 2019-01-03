package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_TournamentChat extends AppCompatActivity implements View.OnClickListener {

    TextView main_text_title;
    Typeface face;
    ImageView ivSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentchat);

        init();
    }

    private void init() {

        main_text_title = (TextView)findViewById(R.id.main_text_title);
        face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Bold.otf");

        main_text_title.setTypeface(face);

        ivSend = (ImageView)findViewById(R.id.ivSend);
        ivSend.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivSend:

                Intent intent = new Intent(Activity_TournamentChat.this,Activity_JoinTour.class);
                startActivity(intent);
                break;
        }
    }
}
