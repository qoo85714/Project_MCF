package tw.jason.app.helloworld.mybletestprogect;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button logbtn,gubtn;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logbtn = (Button)findViewById(R.id.Login);
        gubtn = (Button)findViewById(R.id.guest);
        linearLayout = (LinearLayout) findViewById(R.id.root);
        controlKeyboardLayout(linearLayout, gubtn);
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main1Activity.class);
                startActivity(intent);
            }
        });
        gubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main1Activity.class);
                startActivity(intent);
            }
        });
    }

        private void controlKeyboardLayout(final View root, final View scrollToView) {
            // 注册一个回调函数，当在一个视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变时调用这个回调函数。
            root.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            Rect rect = new Rect();
                            // 获取root在窗体的可视区域
                            root.getWindowVisibleDisplayFrame(rect);
                            // 当前视图最外层的高度减去现在所看到的视图的最底部的y坐标
                            int rootInvisibleHeight = root.getRootView()
                                    .getHeight() - rect.bottom;
                            Log.i("tag", "最外层的高度" + root.getRootView().getHeight());
                            // 若rootInvisibleHeight高度大于100，则说明当前视图上移了，说明软键盘弹出了
                            if (rootInvisibleHeight > 300) {
                                //软键盘弹出来的时候
                                int[] location = new int[2];
                                // 获取scrollToView在窗体的坐标
                                scrollToView.getLocationInWindow(location);
                                // 计算root滚动高度，使scrollToView在可见区域的底部
                                int srollHeight = (location[1] + scrollToView
                                        .getHeight()) - rect.bottom;
                                root.scrollTo(0, srollHeight);
                            } else {
                                // 软键盘没有弹出来的时候
                                root.scrollTo(0, 0);
                            }
                        }
                    });


    }

}
