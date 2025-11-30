public class GCD {

    public static int recursiveMethod(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return recursiveMethod(y, x % y);
        }
    }

    public static void main(String[] args) {
        int gcd = recursiveMethod(1482, 819); 
        System.out.println(gcd);
    }
}