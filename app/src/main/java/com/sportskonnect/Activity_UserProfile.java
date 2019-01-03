package com.sportskonnect;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Activity_UserProfile extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llBadQues, llBadAns, llTTQues, llTTAns, llSQUASHAns, llSQUASHQues, llTennisQues, llTennisAns;
    SeekBar seekBar_luminosite2, seekBar_luminosite1, seekBar_luminosite, seekBar_luminosite3;
    ImageView ivBadTop, ivBadBottom, ivTop1, ivBottom1, ivTop2, ivBottom2, ivTop3, ivBottom3;
    boolean llBad = false;
    boolean llTT = false;
    boolean llSquash = false;
    boolean llTennis = false;
    TextView tvMin, tvRank,main_text_title, tvRate, tvBadmintn, tvRate1, tvTableT, tvSq, tvRate2, tvRate3, tvTen, tvName, tvName1,tvAreaName , tvV , tvJoinM,tvAreaName1,tvV1,tvJoinMa;
    Typeface face1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        init();
    }

    private void init() {

        seekBar_luminosite2 = (SeekBar) findViewById(R.id.seekBar_luminosite2);
        seekBar_luminosite = (SeekBar) findViewById(R.id.seekBar_luminosite);
        seekBar_luminosite1 = (SeekBar) findViewById(R.id.seekBar_luminosite1);
        seekBar_luminosite3 = (SeekBar) findViewById(R.id.seekBar_luminosite3);

        seekBar_luminosite2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        seekBar_luminosite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        seekBar_luminosite1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        seekBar_luminosite3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Black.otf");

        face1 = Typeface.createFromAsset(getAssets(), "fonts/" + "Calibre Bold.otf");

        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");

        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Semibold.otf");

        tvMin = (TextView) findViewById(R.id.tvMin);
        tvRank = (TextView) findViewById(R.id.tvRank);
        tvRate = (TextView) findViewById(R.id.tvRate);
        tvBadmintn = (TextView) findViewById(R.id.tvBadmintn);
        tvTableT = (TextView) findViewById(R.id.tvTableT);
        tvTen = (TextView) findViewById(R.id.tvTen);
        tvSq = (TextView) findViewById(R.id.tvSq);
        tvRate2 = (TextView) findViewById(R.id.tvRate2);
        tvRate1 = (TextView) findViewById(R.id.tvRate1);
        tvRate3 = (TextView) findViewById(R.id.tvRate3);
        tvName = (TextView) findViewById(R.id.tvName);
        tvName1 = (TextView) findViewById(R.id.tvName1);
        tvAreaName = (TextView) findViewById(R.id.tvAreaName);
        tvV = (TextView) findViewById(R.id.tvV);
        tvV1 = (TextView) findViewById(R.id.tvV1);
        tvJoinM = (TextView) findViewById(R.id.tvJoinM);
        tvJoinMa = (TextView) findViewById(R.id.tvJoinMa);
        tvAreaName1 = (TextView) findViewById(R.id.tvAreaName1);
        main_text_title = (TextView) findViewById(R.id.main_text_title);

        ivBadBottom = (ImageView) findViewById(R.id.ivBadBottom);
        ivBadTop = (ImageView) findViewById(R.id.ivBadTop);
        ivBottom1 = (ImageView) findViewById(R.id.ivBottom1);
        ivTop1 = (ImageView) findViewById(R.id.ivTop1);
        ivBottom2 = (ImageView) findViewById(R.id.ivBottom2);
        ivTop2 = (ImageView) findViewById(R.id.ivTop2);

        ivBottom3 = (ImageView) findViewById(R.id.ivBottom3);
        ivTop3 = (ImageView) findViewById(R.id.ivTop3);

        tvBadmintn.setTypeface(face);
        tvName.setTypeface(face);
        tvTableT.setTypeface(face);
        tvRate1.setTypeface(face);
        tvSq.setTypeface(face);
        tvTen.setTypeface(face);
        tvRate3.setTypeface(face);
        tvRate2.setTypeface(face);
        tvRate.setTypeface(face);
        tvMin.setTypeface(face2);
        tvJoinM.setTypeface(face2);
        tvJoinMa.setTypeface(face2);
        tvRank.setTypeface(face2);
        tvName.setTypeface(face2);
        tvName1.setTypeface(face2);
        tvAreaName.setTypeface(typeface);
        tvAreaName1.setTypeface(typeface);
        tvV.setTypeface(typeface);
        tvV1.setTypeface(typeface);
        main_text_title.setTypeface(face1);

        llBadQues = (LinearLayout) findViewById(R.id.llBadQues);
        llBadAns = (LinearLayout) findViewById(R.id.llBadAns);
        llTTQues = (LinearLayout) findViewById(R.id.llTTQues);
        llTTAns = (LinearLayout) findViewById(R.id.llTTAns);
        llSQUASHAns = (LinearLayout) findViewById(R.id.llSQUASHAns);
        llSQUASHQues = (LinearLayout) findViewById(R.id.llSQUASHQues);
        llTennisQues = (LinearLayout) findViewById(R.id.llTennisQues);
        llTennisAns = (LinearLayout) findViewById(R.id.llTennisAns);
        llBadQues.setOnClickListener(this);
        llTTQues.setOnClickListener(this);
        llSQUASHQues.setOnClickListener(this);
        llTennisQues.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llBadQues:

                if (!llBad) {
                    llBadAns.setVisibility(View.VISIBLE);
                    ivBadTop.setVisibility(View.GONE);
                    ivBadBottom.setVisibility(View.VISIBLE);
                    llBad = true;
                } else if (llBad) {

                    llBadAns.setVisibility(View.GONE);
                    ivBadTop.setVisibility(View.VISIBLE);
                    ivBadBottom.setVisibility(View.GONE);
                    llBad = false;
                }

                break;

            case R.id.llTTQues:

                if (!llTT) {
                    llTTAns.setVisibility(View.VISIBLE);
                    ivTop1.setVisibility(View.GONE);
                    ivBottom1.setVisibility(View.VISIBLE);
                    llTT = true;
                } else if (llTT) {
                    llTTAns.setVisibility(View.GONE);
                    ivTop1.setVisibility(View.VISIBLE);
                    ivBottom1.setVisibility(View.GONE);
                    llTT = false;
                }
                break;

            case R.id.llSQUASHQues:

                if (!llSquash) {
                    llSQUASHAns.setVisibility(View.VISIBLE);
                    ivTop2.setVisibility(View.GONE);
                    ivBottom2.setVisibility(View.VISIBLE);
                    llSquash = true;
                } else if (llSquash) {
                    llSQUASHAns.setVisibility(View.GONE);
                    ivTop2.setVisibility(View.VISIBLE);
                    ivBottom2.setVisibility(View.GONE);
                    llSquash = false;
                }

                break;

            case R.id.llTennisQues:

                if (!llTennis) {
                    llTennisAns.setVisibility(View.VISIBLE);
                    ivTop3.setVisibility(View.GONE);
                    ivBottom3.setVisibility(View.VISIBLE);
                    llTennis = true;
                } else if (llTennis) {
                    llTennisAns.setVisibility(View.GONE);
                    ivTop3.setVisibility(View.VISIBLE);
                    ivBottom3.setVisibility(View.GONE);
                    llTennis = false;
                }
                break;
        }
    }


}
