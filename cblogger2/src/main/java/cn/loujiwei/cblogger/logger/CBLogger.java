package cn.loujiwei.cblogger.logger;

import cn.loujiwei.cblogger.utils.FileUtils;
import cn.loujiwei.cblogger.utils.ThreadManager;
import android.os.Environment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by LJW on 16/7/18.
 */
public class CBLogger {

    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public final static String fileName = format.format(new Date()) + ".log";

    private static int maxLength = 10;
    static StringBuffer _stringBuffer = new StringBuffer(maxLength);

    private static String logPaht = Environment.getExternalStorageDirectory()
            + "/cestbon/baseData/log/";


    public static void d(String d) {
        System.out.println(":"+d);
        _stringBuffer.append(d);

        System.out.println("stringBuffer = "+_stringBuffer.toString());

        testWriteBufferToDisk();
    }


    public static synchronized void testWriteBufferToDisk() {

        System.out.println("长度----->"+_stringBuffer.length());
        if (_stringBuffer.length() > maxLength) {
            System.out.println("超了 "+_stringBuffer.length());
            final String cache = _stringBuffer.toString();

            _stringBuffer.delete(0, _stringBuffer.length());

            Future<String> future = ThreadManager.getFixedThreadPool().submit(new Callable<String>() {
                @Override
                public String call() throws Exception {

                    return FileUtils.fileWrite(logPaht, fileName, cache);

                }
            });
        }
    }
}
