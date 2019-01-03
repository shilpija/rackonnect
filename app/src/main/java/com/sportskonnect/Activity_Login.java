package com.sportskonnect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    TextView tvHead;
    EditText etMobile;
    String mobile;
    Button btnSubmit;
    private static final int RC_SIGN_IN = 1;
    private final String TAG = Activity_Login.this.getClass().getName();
    LoginButton LoginWithFaceBook;
    CallbackManager callbackManager;
    ImageView fb, ivGoogle;
    ProgressDialog progressDialog;
    private GoogleApiClient mGoogleApiClient;
    Profile profile;
    String Facebook_email = "noemail";
    private AccessToken accessToken;
    TextView main_text_title , give_us_a_review_landmine_text_2;
    String text = "<font color=#ffffff>RAC</font><font color=#00FF00>KONNECT</font>";
    Typeface face1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {

        main_text_title = (TextView)findViewById(R.id.main_text_title);
        give_us_a_review_landmine_text_2 = (TextView)findViewById(R.id.give_us_a_review_landmine_text_2);

        main_text_title.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/Calibre Black.otf");

        face1 = Typeface.createFromAsset(getAssets(), "fonts/" + "Calibre Bold.otf");

        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold.otf");
        give_us_a_review_landmine_text_2.setTypeface(face2);

        main_text_title.setTypeface(face);
//        tvHead.setTypeface(face1);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        accessToken = AccessToken.getCurrentAccessToken();
        callbackManager = CallbackManager.Factory.create();

        fb = (ImageView) findViewById(R.id.ivFb);
        ivGoogle = (ImageView) findViewById(R.id.ivGoogle);
        callbackManager = CallbackManager.Factory.create();

        LoginWithFaceBook = (LoginButton) findViewById(R.id.login_button);
        LoginWithFaceBook.setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);

        LoginWithFaceBook.setReadPermissions(Arrays.asList(new String[]{"email"}));
        LoginWithFaceBook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {

                // final String userid = loginResult.getAccessToken().toString();
                // Log.e("user id", userid);
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    //                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        Log.d("facebookData", "Graph Object :" + object);
                        try {
                            //                            Log.e("Login_facebook: ", object.getId() + Facebook_email + object.getName() + object.getProfilePictureUri(200, 200));
                            String name = object.getString("name");
                            String id = object.getString("id");
                            String email = object.getString("email");
                            String first_name = object.getString("first_name");
                            String last_name = object.getString("last_name");
                            String profile = object.getString("picture");
                            JSONObject jsonObject = object.getJSONObject("picture");
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            String url = jsonObject1.getString("url");
                            Toast.makeText(Activity_Login.this, name + " " + email + " " + id + " " + url, Toast.LENGTH_SHORT).show();
                            Log.d("urlGet", url);
                            if (email.equalsIgnoreCase("")) {
                                Facebook_email = "noemail";
                            } else {
                                Facebook_email = object.getString("email");
                            }
                            // Login_facebook(name,id,Facebook_email,first_name,last_name,url);

                            Log.d("data", "Name :" + name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });

                Bundle bundle = new Bundle();
                bundle.putString("fields", "first_name,last_name,email,name,id,picture");

                graphRequest.setParameters(bundle);
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("onError: ", error.getMessage());
            }
        });


//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.sportskonnect", PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//
//        } catch (NoSuchAlgorithmException e) {
//
//        }

        tvHead = (TextView) findViewById(R.id.tvHead);
        etMobile = (EditText) findViewById(R.id.etMobile);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setTypeface(face2);
        etMobile.setTypeface(face2);
        btnSubmit.setOnClickListener(this);
        fb.setOnClickListener(this);
        ivGoogle.setOnClickListener(this);

        doTask();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        profile = Profile.getCurrentProfile();
        if (profile != null) {
            Log.e("onResume: ", profile.getFirstName());
            Log.e("onResume", profile.getId());
        }
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            Log.d(TAG, "handleSignInResult:" + result.isSuccess());
            if (result.isSuccess()) {
                // Signed in successfully, show authenticated UI.
                GoogleSignInAccount acct = result.getSignInAccount();
//                tvDetails.setText("Profile Name :" + acct.getDisplayName() +
//                        "\nEmail : " + acct.getEmail() +
//                        "\nFamily Name :" + acct.getFamilyName() +
//                        "\n Given Name :" + acct.getGivenName() +
//                        "\n ID :" + acct.getId());

                Toast.makeText(this, acct.getDisplayName() + " " + acct.getEmail() + " " + acct.getGivenName(), Toast.LENGTH_SHORT).show();

//                Picasso.with(SignInActivity.this)
//                        .load(acct.getPhotoUrl())
//                        .into(ivProfileImage);
            } else {
                // Signed out, show unauthenticated UI.
                Toast.makeText(this, "error occured..!", Toast.LENGTH_SHORT).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    // to signout the gmail account.
    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // ...
                        Log.d("status", String.valueOf(status));
                    }
                });
    }


    private void doTask() {

        // Specify the text/word to highlight inside TextView
        String first = "Please enter your mobile number to get started with ";
        String Second = "<font color=#000000>  <b> RAC</font><font color=#00FF00>KONNECT  <b> </font>";

        tvHead.setText(Html.fromHtml(first + Second));
      //  tvHead.setTypeface(face1);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:

                mobile = etMobile.getText().toString();

                if (!mobile.isEmpty()) {
                    if ((mobile.length() == 10)) {
                        Intent intent = new Intent(Activity_Login.this, Activity_Otp.class);
                        intent.putExtra("mobile", mobile);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Please Enter 10 digits mobile number ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.ivFb:

                LoginWithFaceBook.performClick();

                break;

            case R.id.ivGoogle:

                signIn();

                break;
        }

    }

    private void signIn() {

        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "Connection Failed : " + connectionResult);
    }
}


