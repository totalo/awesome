package top.totalo.template;

/**
 * 最大公约数
 */
public class Gcd {
    
    public static int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
    
    public static void main(String[] args) {
        System.out.println(gcd(12, 15));
    }
}
