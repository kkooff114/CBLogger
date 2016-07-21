package android.loujiwei.cn.cbloggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.loujiwei.cblogger.logger.CBLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < 100; i++) {
            CBLogger.d(""+i);
        }
    }
}
