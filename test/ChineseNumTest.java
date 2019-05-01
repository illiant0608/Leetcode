import org.junit.Test;

import static org.junit.Assert.*;

public class ChineseNumTest {

    @Test
    public void convert() {
        ChineseNum test = new ChineseNum();
        String chinese = "三百五十";
        System.out.println(test.convert(chinese));
    }
}