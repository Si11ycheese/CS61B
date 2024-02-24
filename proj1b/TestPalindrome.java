import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.

     */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual = actual + d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome(){
        Assert.assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("racecar"));

    }
    @Test
    public void testIsPalindrome_Offbyone(){
        OffByOne a=new OffByOne();
        assertFalse(palindrome.isPalindrome("cat",a));
        assertTrue(palindrome.isPalindrome("flake",a));
        assertFalse(palindrome.isPalindrome("aba",a));
    }

}
