import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
public class TestOffByN {
    @Test
    public void TestOffbyN(){
        OffByN offBy5=new OffByN(5);
        assertTrue(offBy5.equalChars('a','f'));
        assertTrue(offBy5.equalChars('f','a'));
        assertFalse(offBy5.equalChars('a','z'));

    }
}
