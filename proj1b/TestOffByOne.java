import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testEqualChars(){
        char a='a';
        char b='b';
        assertTrue(offByOne.equalChars(a,b));
        assertTrue(offByOne.equalChars(b,a));
    }
}
