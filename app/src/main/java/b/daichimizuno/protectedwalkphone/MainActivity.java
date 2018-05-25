package b.daichimizuno.protectedwalkphone;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = MainActivity.class.getSimpleName();

    private final static String START = "START";
    private final static String STOP = "STOP";

    private boolean isStart = false;

    private Button mMaleButton;
    private Button mFemaleButton;
    private Button mStartButton;

    private NumberPicker mAgeNumberPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();

    }

    private void initComponent(){
        mMaleButton = (Button)findViewById(R.id.malebutton);
        mFemaleButton =(Button)findViewById(R.id.femailbutton);
        mStartButton = (Button)findViewById(R.id.startbutton);
        mAgeNumberPicker = (NumberPicker)findViewById(R.id.numberpicker);

        mMaleButton.setOnClickListener(this);
        mFemaleButton.setOnClickListener(this);
        mStartButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mMaleButton){
            mMaleButton.setBackgroundColor(Color.BLUE);
            mFemaleButton.setBackgroundColor(Color.GRAY);
        }else if(v == mFemaleButton){
            mFemaleButton.setBackgroundColor(Color.rgb(255,105,180));
            mMaleButton.setBackgroundColor(Color.GRAY);
        }

        if(v == mStartButton ){
            if(isStart){
                mStartButton.setText(STOP);
            }else if(!isStart){
                mStartButton.setText(START);
            }
        }

    }
}
