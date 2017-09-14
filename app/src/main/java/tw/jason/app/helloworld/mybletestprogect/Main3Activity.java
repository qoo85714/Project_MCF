package tw.jason.app.helloworld.mybletestprogect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private Button edit;
    private TextView height;
    private TextView gender2;
    private TextView age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edit = (Button)findViewById(R.id.back3);
        height = (TextView)findViewById(R.id.height);
        gender2=(TextView)findViewById(R.id.gender2);
        age = (TextView)findViewById(R.id.age);
        Bundle bundle = getIntent().getExtras();
        height.setText(bundle.getString("ft")+"ft"+bundle.getString("inch")+"inch");
        age.setText("Age:"+bundle.getString("birthday"));
        if(bundle.getString("isMale").equals("true")){
        gender2.setText("Male");
        }else {
            gender2.setText("Female");
        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setClass(Main3Activity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

}
