package cn.loujiwei.cblogger.utils;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by LJW on 16/7/19.
 */
public class FileUtils {

    public static String fileWrite(String path, String fileName, String content) {

        try {

            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }

            File file1 = new File(path + fileName);
            if (file1.exists() && file1.isDirectory()) {
                file1.delete();
            }

            if (!file1.exists()) {
                file1.createNewFile();
            }

            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(path + fileName, true);
            writer.write(content);
            writer.close();

            return "s";
        } catch (Exception e) {
            e.printStackTrace();
            return "e";
        }
    }
}
