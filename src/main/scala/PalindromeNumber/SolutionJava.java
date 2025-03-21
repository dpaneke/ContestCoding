package PalindromeNumber;

public class SolutionJava {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        String xStrReversed = new StringBuilder(xStr).reverse().toString();
        return xStr.equals(xStrReversed);
    }
}
