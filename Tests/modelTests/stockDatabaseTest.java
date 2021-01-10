package modelTests;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.model.stockDatabase;

public class stockDatabaseTest {
    stockDatabase testDb = new stockDatabase();

    @Test
    public void testDbSearch() {
        ArrayList<String> testArray = new ArrayList<>(testDb.searchStock(0));
        System.out.println(testArray);
    }

    @Test
    public void testDbCheckStock() {
        ArrayList<String> testArray = new ArrayList<>(testDb.checkStock());
        System.out.println(testArray);
    }

    @Test
    public void testUpdateStock() {
        testDb.updateStock();
    }

    @Test
    public void testReadStock() {
        testDb.readStock();
    }
}
