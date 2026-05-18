public class Recurse{
    
    public static void main(String[] args) {
        // recurse(10);
        // recurseCleaner(10);
        // System.out.println(factorial(7));
        System.out.println(power(4, 3));
        System.out.println(remainder(10, 3));
        System.out.println(palindrome("hello"));
    }

    public static double power(double x, int n){
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

    public static int remainder(int a, int b){
        if (a % b == a) return a;
        return remainder(a - b, b);

    }

    public static boolean palindrome(String word){
        if (word.length() < 2) return true;
        return word.charAt(0) == word.charAt(word.length() - 1) && palindrome(word.substring(1, word.length() - 1));
    }

    public static int factorial(int n){
        if (n == 0) return 1;
        return n * factorial(n - 1); // leap of faith: if we can get the factorial of n - 1 this line will work just fine
    }

    // Three ingredients for effective recursion:
    // 1. a method that calls itself
    // 2. a base case - when to stop recursing
    // 3. code that progresses towards the base case
    public static void recurse(int n){
        if (n < 0){ // condition 2
            return;
        }
        System.out.println(n);
        n--; // condition 3
        recurse(n); // condition 1
    }  

    public static void recurseCleaner(int n){
        System.out.println(n);
        if (n > 0) recurseCleaner(n - 1);
    }


}


