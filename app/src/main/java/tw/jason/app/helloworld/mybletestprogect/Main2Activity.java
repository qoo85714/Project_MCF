package tw.jason.app.helloworld.mybletestprogect;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class Main2Activity extends AppCompatActivity {
    private Button m,f,backto1,nextto3;
    private boolean maleischosen,feamaleischosen;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        m=(Button)findViewById(R.id.M);
        f=(Button)findViewById(R.id.F);
        backto1=(Button)findViewById(R.id.back2);
        nextto3=(Button)findViewById(R.id.next);

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
                Intent intent =new Intent();
                intent.setClass(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        numberPicker=(NumberPicker)findViewById(R.id.year);
        numberPicker.setMinValue(1900);
        numberPicker.setMaxValue(2017);
        numberPicker.setValue(1980);
    }
    public void chooseM(View view){
        if(!maleischosen) {
            m.setBackgroundColor(Color.parseColor("#8c8c8c"));
            f.setBackgroundColor(Color.TRANSPARENT);
        }
    }
    public void chooseF(View view){
        if(!feamaleischosen) {
        f.setBackgroundColor(Color.parseColor("#8c8c8c"));
        m.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
