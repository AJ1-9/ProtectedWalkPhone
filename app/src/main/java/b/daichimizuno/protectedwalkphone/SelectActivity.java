package b.daichimizuno.protectedwalkphone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import b.daichimizuno.protectedwalkphone.ArroundElectorics.ArroundElectoricsActivity;
import b.daichimizuno.protectedwalkphone.acceleration.AccelerationActivity;
import b.daichimizuno.protectedwalkphone.camera.FaceTrackerActivity;
import b.daichimizuno.protectedwalkphone.gps.GPSActivity;
import b.daichimizuno.protectedwalkphone.gyro.GyroActivity;

public class SelectActivity extends AppCompatActivity implements Button.OnClickListener{
    private final static String TAG = SelectActivity.class.getSimpleName();

    private Button mFaceTrackerButton;
    private Button mAccelerationButton;
    private Button mGyroButton;
    private Button mGpsButton;
    private Button mArroundEleButotn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        mFaceTrackerButton = (Button)findViewById(R.id.faceTracker);
        mAccelerationButton = (Button)findViewById(R.id.acceleration);
        mGyroButton = (Button)findViewById(R.id.gyro);
        mGpsButton = (Button)findViewById(R.id.gps);
        mArroundEleButotn = (Button)findViewById(R.id.aroundElectorics);

        mFaceTrackerButton.setOnClickListener(this);
        mAccelerationButton.setOnClickListener(this);
        mGyroButton.setOnClickListener(this);
        mGpsButton.setOnClickListener(this);
        mArroundEleButotn.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1);

            return;
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,}, 1);

            return;
        }

    }

    @Override
    public void onClick(View v) {
        if(v == mFaceTrackerButton){
            Intent intent = new Intent(SelectActivity.this, FaceTrackerActivity.class);
            startActivity(intent);
        }else if(v == mAccelerationButton){
            Intent intent = new Intent(SelectActivity.this, AccelerationActivity.class);
            startActivity(intent);
        }else if(v == mGyroButton){
            Intent intent = new Intent(SelectActivity.this, GyroActivity.class);
            startActivity(intent);
        }else if(v == mGpsButton){
            Intent intent = new Intent(SelectActivity.this, GPSActivity.class);
            startActivity(intent);
        }
        else if(v == mArroundEleButotn){
            Intent intent = new Intent(SelectActivity.this, ArroundElectoricsActivity.class);
            startActivity(intent);
        }
    }

    private void initSensorService(){
        Intent intent = new Intent(SelectActivity.this, SensorService.class);
        startService(intent);
    }
}
