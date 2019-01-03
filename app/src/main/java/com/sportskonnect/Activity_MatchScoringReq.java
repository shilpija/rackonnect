package com.sportskonnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_MatchScoringReq extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchscorerequest);
        
        init(); 
    }

    private void init() {

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubmit:

                Intent intent = new Intent(Activity_MatchScoringReq.this,Activity_ValidScore.class);
                startActivity(intent);
                break;
        }
    }
}
