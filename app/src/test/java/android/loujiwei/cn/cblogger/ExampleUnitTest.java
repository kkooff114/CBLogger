package android.loujiwei.cn.cblogger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    static StringBuilder sb = new StringBuilder();


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        for(int i=0;i<10000;i++){
            TextStringAppend textStringAppend = new TextStringAppend(String.valueOf(i));

            new Thread(textStringAppend).start();
        }

        System.out.println(sb.toString());

    }

    class TextStringAppend implements Runnable{

        private String index = "-1";
        public TextStringAppend(String index) {
            this.index = index;
        }

        @Override
        public void run() {
            String s = index + Thread.currentThread().getName() + "\n";
            sb.append(s);
        }
    }
}