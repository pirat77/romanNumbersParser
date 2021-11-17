package algo;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class App1Test {

    @Test
    public void testParser() {
        assertEquals(App1.parser("IV"), 4);
        assertEquals(App1.parser("MCMLXXXVI"), 1986);
        assertEquals(App1.parser("XLIV"), 44);
        assertEquals(App1.parser("VIII"), 8);
    };

    @Test
    public void testIllegalInput(){
        assertEquals(App1.parser("IIII"), -1);
        assertEquals(App1.parser("O"), -1);
        assertEquals(App1.parser("IIIV"), -1);
        assertEquals(App1.parser(""), -1);
        assertEquals(App1.parser("XLIVM"), -1);
    }

}