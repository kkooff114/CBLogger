package android.loujiwei.cn.cbloggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.loujiwei.cblogger.logger.CBLogger;
import cn.loujiwei.cblogger.utils.FileUtils;

public class MainActivity extends AppCompatActivity {

    TextView totalSize, deleteAll, deleteDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalSize = (TextView) findViewById(R.id.tv_total_size);
        deleteAll = (TextView) findViewById(R.id.tv_delet_all);
        deleteDay = (TextView) findViewById(R.id.tv_delet_7);

        for (int i = 0; i < 20; i++) {
            CBLogger.d("" + i);
        }


        totalSize.setText("总大小" + CBLogger.getLogFolderSize() + "/ 空余:" + FileUtils.getSDAvailableSize() / 1024 / 1024);
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CBLogger.deleteLogFolder();
            }
        });

        deleteDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CBLogger.deleteLogFolderByDay(1);
            }
        });
    }
}
