package com.sportskonnect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_ChooseSports extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit;
    LinearLayout llBad1, llBad, llTableTenn, llTableTenn1, llSquash1, llSquash, llTennis1, llTennis, llBad11, llBad12, llBad13, llBad14, llTT1, llTT2, llTT3, llTT4, llsaq2, llsaq3, llsaq4, llten1, llten2, llten3, llten4;
    TextView main_text_title, tvSquash1, tvTable, tvBad1, tvTennis1, tvSq1, tvtb1, tvBad11, tvtt1;
    ImageView ivCrossBad, ivBad4, ivBad3, ivBad2, ivBad1, ivCrosstt, ivtt1, ivtt2, ivtt3, ivtt4, ivsaq2, ivsaq3, ivsaq4, ivCrossBadd, ivCrossTen, ivten1, ivten2, ivten3, ivten4;
    View viewBad1, viewBad2, viewBad3, viewtt1, viewtt2, viewtt3, viewsaq1, viewsaq2, viewsaq3, viewTen1, viewTen2, viewTen3;

    int bad = 0;
    boolean badRev = false;
    int tt = 0;
    boolean ttRev = false;
    int squash = 0;
    boolean sqhRev = false;
    int ten = 0;
    boolean tenRev = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosesports);

        init();
    }

    private void init() {

        main_text_title = (TextView) findViewById(R.id.main_text_title);
        tvSquash1 = (TextView) findViewById(R.id.tvSquash1);
        tvTable = (TextView) findViewById(R.id.tvTable);
        tvBad1 = (TextView) findViewById(R.id.tvBad1);
        tvTennis1 = (TextView) findViewById(R.id.tvTennis1);
        tvtt1 = (TextView) findViewById(R.id.tvtt1);
        tvSq1 = (TextView) findViewById(R.id.tvSq1);
        tvtb1 = (TextView) findViewById(R.id.tvtb1);
        tvBad11 = (TextView) findViewById(R.id.tvBad11);
        ivCrossBad = (ImageView) findViewById(R.id.ivCrossBad);
        ivCrosstt = (ImageView) findViewById(R.id.ivCrosstt);
        ivCrossBadd = (ImageView) findViewById(R.id.ivCrossBadd);
        ivCrossTen = (ImageView) findViewById(R.id.ivCrossTen);
        ivBad2 = (ImageView) findViewById(R.id.ivBad2);
        ivBad3 = (ImageView) findViewById(R.id.ivBad3);
        ivBad4 = (ImageView) findViewById(R.id.ivBad4);
        ivten2 = (ImageView) findViewById(R.id.ivten2);
        ivten3 = (ImageView) findViewById(R.id.ivten3);
        ivten4 = (ImageView) findViewById(R.id.ivten4);
        ivtt2 = (ImageView) findViewById(R.id.ivtt2);
        ivtt3 = (ImageView) findViewById(R.id.ivtt3);
        ivtt4 = (ImageView) findViewById(R.id.ivtt4);
        ivsaq2 = (ImageView) findViewById(R.id.ivsaq2);
        ivsaq3 = (ImageView) findViewById(R.id.ivsaq3);
        ivsaq4 = (ImageView) findViewById(R.id.ivsaq4);
        ivCrossBad.setOnClickListener(this);
        ivCrosstt.setOnClickListener(this);
        ivCrossBadd.setOnClickListener(this);
        ivCrossTen.setOnClickListener(this);

        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Bold.otf");

        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Regular.otf");

        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");


        main_text_title.setTypeface(face);
        tvSquash1.setTypeface(face);
        tvTable.setTypeface(face);
        tvBad1.setTypeface(face);
        tvTennis1.setTypeface(face);
        tvSq1.setTypeface(face);
        tvtb1.setTypeface(face);
        tvBad11.setTypeface(face);
        tvtt1.setTypeface(face);

        llBad1 = (LinearLayout) findViewById(R.id.llBad1);
        llBad = (LinearLayout) findViewById(R.id.llBad);
        llTableTenn = (LinearLayout) findViewById(R.id.llTableTenn);
        llTableTenn1 = (LinearLayout) findViewById(R.id.llTableTenn1);
        llSquash1 = (LinearLayout) findViewById(R.id.llSquash1);
        llSquash = (LinearLayout) findViewById(R.id.llSquash);
        llTennis1 = (LinearLayout) findViewById(R.id.llTennis1);
        llTennis = (LinearLayout) findViewById(R.id.llTennis);
        llBad12 = (LinearLayout) findViewById(R.id.llBad12);
        llBad13 = (LinearLayout) findViewById(R.id.llBad13);
        llBad14 = (LinearLayout) findViewById(R.id.llBad14);
        llTT2 = (LinearLayout) findViewById(R.id.llTT2);
        llTT3 = (LinearLayout) findViewById(R.id.llTT3);
        llTT4 = (LinearLayout) findViewById(R.id.llTT4);
        llsaq2 = (LinearLayout) findViewById(R.id.llsaq2);
        llsaq3 = (LinearLayout) findViewById(R.id.llsaq3);
        llsaq4 = (LinearLayout) findViewById(R.id.llsaq4);
        llten2 = (LinearLayout) findViewById(R.id.llten2);
        llten3 = (LinearLayout) findViewById(R.id.llten3);
        llten4 = (LinearLayout) findViewById(R.id.llten4);
        viewBad1 = (View) findViewById(R.id.viewBad1);
        viewBad2 = (View) findViewById(R.id.viewBad2);
        viewBad3 = (View) findViewById(R.id.viewBad3);
        viewtt1 = (View) findViewById(R.id.viewtt1);
        viewtt2 = (View) findViewById(R.id.viewtt2);
        viewtt3 = (View) findViewById(R.id.viewtt3);
        viewsaq1 = (View) findViewById(R.id.viewsaq1);
        viewsaq2 = (View) findViewById(R.id.viewsaq2);
        viewsaq3 = (View) findViewById(R.id.viewsaq3);
        viewTen1 = (View) findViewById(R.id.viewTen1);
        viewTen2 = (View) findViewById(R.id.viewTen2);
        viewTen3 = (View) findViewById(R.id.viewTen3);

        llTennis.setOnClickListener(this);
        llBad.setOnClickListener(this);
        llTableTenn.setOnClickListener(this);
        llBad12.setOnClickListener(this);

        llBad1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!badRev) {
                        bad++;
                        if (bad == 1) {
                            viewBad1.setBackgroundResource(R.color.color_white);
                            ivBad2.setBackgroundResource(R.drawable.rectangle_non);
                        }

                        if (bad == 2) {

                            ivBad3.setBackgroundResource(R.drawable.rectangle_non);
                            viewBad2.setBackgroundResource(R.color.color_white);
                        }
                        if (bad == 3) {

                            badRev = true;
                            viewBad3.setBackgroundResource(R.color.color_white);
                            ivBad4.setBackgroundResource(R.drawable.rectangle_non);
                        }
                    } else if (badRev) {
                        bad--;
                        if (bad == 2) {
                            viewBad3.setBackgroundResource(R.color.color_blue);
                            ivBad4.setBackgroundResource(R.drawable.rectangle_non1);
                        }
                        if (bad == 1) {
                            ivBad3.setBackgroundResource(R.drawable.rectangle_non1);
                            viewBad2.setBackgroundResource(R.color.color_blue);
                        }

                        if (bad == 0) {
                            viewBad1.setBackgroundResource(R.color.color_blue);
                            ivBad2.setBackgroundResource(R.drawable.rectangle_non1);
                            badRev = false;
                        }
                    }
                }
                return true;
            }
        });

        llTableTenn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!ttRev) {
                        tt++;

                        if (tt == 1) {
                            viewtt1.setBackgroundResource(R.color.color_white);
                            ivtt2.setBackgroundResource(R.drawable.rectangle_non);
                        }

                        if (tt == 2) {
                            ivtt3.setBackgroundResource(R.drawable.rectangle_non);
                            viewtt2.setBackgroundResource(R.color.color_white);
                        }
                        if (tt == 3) {
                            ttRev = true;
                            viewtt3.setBackgroundResource(R.color.color_white);
                            ivtt4.setBackgroundResource(R.drawable.rectangle_non);
                        }
                    } else if (ttRev) {
                        tt--;
                        if (tt == 2) {
                            viewtt3.setBackgroundResource(R.color.color_blue);
                            ivtt4.setBackgroundResource(R.drawable.rectangle_non1);
                        }
                        if (tt == 1) {
                            ivtt3.setBackgroundResource(R.drawable.rectangle_non1);
                            viewtt2.setBackgroundResource(R.color.color_blue);
                        }

                        if (tt == 0) {
                            viewtt1.setBackgroundResource(R.color.color_blue);
                            ivtt2.setBackgroundResource(R.drawable.rectangle_non1);
                            ttRev = false;
                        }
                    }
                }
                return true;
            }
        });

        llSquash1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!sqhRev) {
                        squash++;

                        if (squash == 1) {
                            viewsaq1.setBackgroundResource(R.color.color_white);
                            ivsaq2.setBackgroundResource(R.drawable.rectangle_non);
                        }

                        if (squash == 2) {
                            ivsaq3.setBackgroundResource(R.drawable.rectangle_non);
                            viewsaq2.setBackgroundResource(R.color.color_white);
                        }
                        if (squash == 3) {
                            sqhRev = true;
                            viewsaq3.setBackgroundResource(R.color.color_white);
                            ivsaq4.setBackgroundResource(R.drawable.rectangle_non);
                        }
                    } else if (sqhRev) {
                        squash--;
                        if (squash == 2) {
                            viewsaq3.setBackgroundResource(R.color.color_blue);
                            ivsaq4.setBackgroundResource(R.drawable.rectangle_non1);
                        }
                        if (squash == 1) {
                            ivsaq3.setBackgroundResource(R.drawable.rectangle_non1);
                            viewsaq2.setBackgroundResource(R.color.color_blue);
                        }

                        if (squash == 0) {
                            viewsaq1.setBackgroundResource(R.color.color_blue);
                            ivsaq2.setBackgroundResource(R.drawable.rectangle_non1);
                            sqhRev = false;
                        }
                    }
                }

                return true;
            }
        });

        llTennis1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!tenRev) {
                        ten++;

                        if (ten == 1) {
                            viewTen1.setBackgroundResource(R.color.color_white);
                            ivten2.setBackgroundResource(R.drawable.rectangle_non);
                        }

                        if (ten == 2) {
                            ivten3.setBackgroundResource(R.drawable.rectangle_non);
                            viewTen2.setBackgroundResource(R.color.color_white);
                        }
                        if (ten == 3) {
                            tenRev = true;
                            viewTen3.setBackgroundResource(R.color.color_white);
                            ivten4.setBackgroundResource(R.drawable.rectangle_non);
                        }
                    } else if (tenRev) {
                        ten--;

                        if (ten == 2) {
                            viewTen3.setBackgroundResource(R.color.color_blue);
                            ivten4.setBackgroundResource(R.drawable.rectangle_non1);
                        }
                        if (ten == 1) {
                            ivten3.setBackgroundResource(R.drawable.rectangle_non1);
                            viewTen2.setBackgroundResource(R.color.color_blue);
                        }

                        if (ten == 0) {
                            viewTen1.setBackgroundResource(R.color.color_blue);
                            ivten2.setBackgroundResource(R.drawable.rectangle_non1);
                            tenRev = false;
                        }
                    }
                }


                return true;
            }
        });


        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setTypeface(face2);
        btnSubmit.setOnClickListener(this);
        llSquash.setOnClickListener(this);

        llTennis1.setOnClickListener(this);
        llBad1.setOnClickListener(this);
        llSquash1.setOnClickListener(this);
        llTableTenn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSubmit:

                if (llBad.getVisibility() == View.VISIBLE) {
                    Intent intent = new Intent(Activity_ChooseSports.this, Activity_Badminton.class);
                    startActivity(intent);
                } else {

                    Intent intent = new Intent(Activity_ChooseSports.this, Activity_UserProfile.class);
                    startActivity(intent);
                }

                break;

            case R.id.llBad:
                llBad.setVisibility(View.GONE);
                llBad1.setVisibility(View.VISIBLE);
                break;

            case R.id.ivCrossBad:

                llBad1.setVisibility(View.GONE);
                llBad.setVisibility(View.VISIBLE);


                break;

            case R.id.llTableTenn:

                llTableTenn.setVisibility(View.GONE);
                llTableTenn1.setVisibility(View.VISIBLE);
                break;

            case R.id.ivCrosstt:
                llTableTenn1.setVisibility(View.GONE);
                llTableTenn.setVisibility(View.VISIBLE);

                break;

            case R.id.llSquash:

                llSquash.setVisibility(View.GONE);
                llSquash1.setVisibility(View.VISIBLE);
                break;

            case R.id.ivCrossBadd:
                llSquash1.setVisibility(View.GONE);
                llSquash.setVisibility(View.VISIBLE);

                break;

            case R.id.llTennis:

                llTennis.setVisibility(View.GONE);
                llTennis1.setVisibility(View.VISIBLE);
                break;

            case R.id.ivCrossTen:

                llTennis1.setVisibility(View.GONE);
                llTennis.setVisibility(View.VISIBLE);

                break;


        }

    }
}
