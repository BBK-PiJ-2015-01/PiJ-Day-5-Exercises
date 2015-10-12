
public class Exercise4 {

    public static void main(String[] args) {

        new Exercise4().exercise4Runner();
    }

    private void exercise4Runner() {

        String candidate = "rotavator";
        System.out.println(candidate + (isPalindrome(candidate.toLowerCase()) ? " IS a palindrome" : " is NOT a palindrome"));        
    }

    private boolean isPalindrome(String candidate) {

        if (candidate.length() < 1) {
            return true;
        }
        if (candidate.charAt(0) != candidate.charAt(candidate.length() - 1)) {
            return false;
        }
        return isPalindrome(candidate.substring(1, Math.max(1, candidate.length() - 1)));
    }
}
