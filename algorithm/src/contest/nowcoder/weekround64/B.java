package contest.nowcoder.weekround64;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * java 提交模板
 * atcoder、nowcoder 需要修改类名为 Main,并且去掉 package 语句
 * codeforces 只需要去掉包名
 */
public class B {
    
    public static void main(String[] args) throws Exception {
        
        int x = sc.nextInt();
        StringBuilder ans = new StringBuilder(x + "").append("\n").append("=").append(x).append("^1\n");
        for (int b = 2; b <= (int) (Math.log(x) / Math.log(2)); b++) {
            int a = (int) Math.round(Math.pow(x, 1.0 / b));
            if (Math.pow(a, b) == x) {
                ans.append("=" + a + "^" + b + "\n");
            }
        }
        
        out.println(ans);
        
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
