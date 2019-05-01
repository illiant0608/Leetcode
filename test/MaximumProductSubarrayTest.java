import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumProductSubarrayTest {

    @Test
    public void maxProduct() {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] arr = {2, 3, -2, 4};
        assertEquals(6, test.maxProduct(arr));
    }
}