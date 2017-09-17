package tw.jason.app.helloworld.mybletestprogect;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class Main1Activity extends AppCompatActivity {
    private Button backbtn;
    private ListView list;
    private List<Map<String, String>> bledata;
    private String[] from = {"title"};
    private int[] to = {R.id.bledevice};
    private SimpleAdapter adapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        backbtn = (Button) findViewById(R.id.back1);
        list = (ListView) findViewById(R.id.list);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initList();
            }
        }, 5000);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Main1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initList() {
        bledata = new LinkedList<>();
        Map<String, String> d0 = new HashMap<>();
        d0.put(from[0], "MCF-0000-0000-000");
        bledata.add(d0);

        adapter = new SimpleAdapter(this, bledata, R.layout.layout_item, from, to);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(Main1Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
