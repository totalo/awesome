package contest.codeforces.educationRound170_div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * java 提交模板
 * atcoder、nowcoder 需要修改类名为 Main,并且去掉 package 语句
 * codeforces 只需要去掉包名
 */
public class A {
    
    public static void main(String[] args) throws Exception {
        
        int q = sc.nextInt();
        while (q-- > 0) {
            String s = sc.next();
            String t = sc.next();
            int i = 0, j = 0;
            int len = Math.min(s.length(), t.length());
            while (i < len && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            out.println((i > 0 ? i + 1 : 0) + s.length() - i + t.length() - i);
            
        }
        
        out.close();
    }
    
    static Kattio sc = new Kattio();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    static class Kattio {
        static BufferedReader r;
        static StringTokenizer st;
        
        public Kattio() {
            r = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
