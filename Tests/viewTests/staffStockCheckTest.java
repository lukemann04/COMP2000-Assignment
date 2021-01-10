package viewTests;

import org.junit.jupiter.api.Test;
import com.view.StaffArea;

public class staffStockCheckTest {
    StaffArea stockTest = new StaffArea();

    @Test
    public void testLowStock() {
        stockTest.checkStock();
    }
}
