import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerBreakTest {

    @Test
    public void integerBreak() {
        IntegerBreak integerBreak = new IntegerBreak();
        assertEquals(9, integerBreak.integerBreak(6));
    }
}