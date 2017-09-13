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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edit = (Button)findViewById(R.id.back3);
        height = (TextView)findViewById(R.id.height);
        gender2=(TextView)findViewById(R.id.gender2);
        Bundle bundle = getIntent().getExtras();
        height.setText(bundle.getString("ft")+"ft"+bundle.getString("inch")+"inch");

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
