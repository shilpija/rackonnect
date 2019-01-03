package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_ChatDoubles extends AppCompatActivity implements View.OnClickListener {

    ImageView ivSend;
    Typeface face;
    TextView main_text_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatdoubles);

        init();
    }

    private void init() {

        ivSend = (ImageView)findViewById(R.id.ivSend);
        ivSend.setOnClickListener(this);
        main_text_title = (TextView)findViewById(R.id.main_text_title);
        face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Black.otf");

        main_text_title.setTypeface(face);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivSend:
                Intent intent = new Intent(Activity_ChatDoubles.this,Activity_TournamentChat.class);
                startActivity(intent);
                break;
        }
    }
}
