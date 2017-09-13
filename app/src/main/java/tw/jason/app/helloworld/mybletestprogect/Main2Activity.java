package tw.jason.app.helloworld.mybletestprogect;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    private Button m,f,backto1,nextto3;
    private boolean maleischosen,feamaleischosen;
    private NumberPicker numberPicker;
    private Calendar calendar;
    private EditText ft,inch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        m=(Button)findViewById(R.id.M);
        f=(Button)findViewById(R.id.F);
        backto1=(Button)findViewById(R.id.back2);
        nextto3=(Button)findViewById(R.id.next);
        ft = (EditText)findViewById(R.id.ft);
        inch = (EditText)findViewById(R.id.inch);

        backto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setClass(Main2Activity.this,Main1Activity.class);
                startActivity(intent);
            }
        });
        nextto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("ft",ft.getText().toString());
                bundle.putString("inch",inch.getText().toString());
                bundle.putString("isMale",String.valueOf(maleischosen));
                bundle.putString("isFemale",String.valueOf(feamaleischosen));

                Intent intent =new Intent();
                intent.setClass(Main2Activity.this,Main3Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        numberPicker=(NumberPicker)findViewById(R.id.year);
        numberPicker.setMinValue(1900);
        numberPicker.setMaxValue(year);
        numberPicker.setValue(1980);
    }
    public void chooseM(View view){
        if(!maleischosen) {
            m.setBackgroundColor(Color.parseColor("#a6a6a6"));
            f.setBackgroundColor(Color.TRANSPARENT);

        }
        Log.i("brad:male",String.valueOf(maleischosen));
    }



    public void chooseF(View view){
        if(!feamaleischosen) {
        f.setBackgroundColor(Color.parseColor("#a6a6a6"));
        m.setBackgroundColor(Color.TRANSPARENT);
        }
        Log.i("brad:female",String.valueOf(feamaleischosen));
    }
}
