import org.junit.Test;

import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void testSameNumber(){
        int a=128;
        int b=128;
        assertTrue(Flik.isSameNumber(a,b));

    }

}
