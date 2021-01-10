package controllerTests;

import org.junit.jupiter.api.Test;
import com.controller.kioskSystem;

public class kioskSystemTest {
    kioskSystem testKs = new kioskSystem();

    @Test
    public void testKsSetup() {
        testKs.setUpStock();
    }
}
