package com.sportskonnect;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Activity_cam extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView capturedPhoto;
    private static final int TAKE_PICTURE = 1;
    private static final int REQUEST_READ_PERMISSION = 100;
    private Uri capturedImageUri;
    private String selectedImagePath;
    private Bitmap bitmap;
    private ExifInterface exifObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        capturedPhoto = (ImageView) findViewById(R.id.photo_placeholder);
        Button cameraButton = (Button) findViewById(R.id.capture_image_with_camera);
        assert cameraButton != null;

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Activity_cam.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Activity_cam.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

                } else {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, TAKE_PICTURE);
                }

            }
        });

        Button changeOrientationButton = (Button) findViewById(R.id.image_orientation_change);
        assert changeOrientationButton != null;
        changeOrientationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (capturedPhoto.getDrawable() != null) {
                    try {
                        exifObject = new ExifInterface(selectedImagePath);

                        Log.d("selectedPath", selectedImagePath);
                        // /storage/emulated/0/DCIM/Camera/V455120_20181224_142859.jpg
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    float[] latLong = new float[2];
                    double[] latLng = exifObject.getLatLong();
                    Log.d("latLng", String.valueOf(latLng));
                    boolean hasLatLong = exifObject.getLatLong(latLong);
                    if (hasLatLong) {
                        Toast.makeText(Activity_cam.this, latLong[0] + " " + latLong[1], Toast.LENGTH_SHORT).show();
                        System.out.println("Latitude: " + latLong[0]);
                        System.out.println("Longitude: " + latLong[1]);
                    }

//                    String lati = exifObject.getAttribute (ExifInterface.TAG_GPS_LATITUDE);
//                    String longi = exifObject.getAttribute (ExifInterface.TAG_GPS_LONGITUDE);
//                    Toast.makeText(Activity_cam.this, lati + " " + longi, Toast.LENGTH_SHORT).show();
                    int orientation = exifObject.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);
                    // Toast.makeText(Activity_cam.this, exifObject.getLatLong(TAG_GPS_LONGITUDE, TAG_GPS_LATITUDE), Toast.LENGTH_SHORT).show();
                    Bitmap imageRotate = rotateBitmap(bitmap, orientation);
                    capturedPhoto.setImageBitmap(imageRotate);
                } else {
                    Toast.makeText(Activity_cam.this, "Image photo is not yet set", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            String result = data.toURI();
//            capturedImageUri = data.getData();
            try {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Activity_cam.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_PERMISSION);
                } else {
//                    selectedImagePath = getRealPathFromURIPath(capturedImageUri);
//                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), capturedImageUri);
                    Bitmap photo = (Bitmap) data.getExtras().get("data");

                    capturedImageUri = getImageUri(getApplicationContext(), photo);

                    // CALL THIS METHOD TO GET THE ACTUAL PATH
                    File finalFile = new File(getRealPathFromURI(capturedImageUri));
                    selectedImagePath = getRealPathFromURI(capturedImageUri);
                    capturedPhoto.setImageBitmap(photo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d(TAG, "Image path return" + result);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_READ_PERMISSION) {
            if (grantResults.length == 0) {
                // permission denied
            } else {
                // permission granted
            }
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (getContentResolver() != null) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int orientation) {
        Matrix matrix = new Matrix();
        switch (orientation) {
            case ExifInterface.ORIENTATION_NORMAL:
                return bitmap;
            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                matrix.setScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                matrix.setRotate(180);
                break;
            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                matrix.setRotate(180);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_TRANSPOSE:
                matrix.setRotate(90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_90:
                matrix.setRotate(90);
                break;
            case ExifInterface.ORIENTATION_TRANSVERSE:
                matrix.setRotate(-90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                matrix.setRotate(-90);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return bmRotated;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}

