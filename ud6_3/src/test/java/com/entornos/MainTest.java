package com.entornos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {
        assertDoesNotThrow(() -> Main.main(new String[] {}));
    }

    @Test
    void testConstructor() {
        // Main is usually not instantiated, but to get 100% coverage on the class
        // itself
        // if there's an implicit constructor.
        Main main = new Main();
        assertNotNull(main);
    }
}
