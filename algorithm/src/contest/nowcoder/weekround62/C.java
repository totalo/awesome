package contest.nowcoder.weekround62;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * java 提交模板
 * atcoder、nowcoder 需要修改类名为 Main,并且去掉 package 语句
 * codeforces 只需要去掉包名
 */
public class C {
    
    public static void main(String[] args) throws Exception {
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long r = sc.nextLong();
            
            double d = Math.sqrt(x * x + y * y);
            
            if (r >= d) {
                a[i] = (r - d) * Math.PI * r * r;
            }
        }
        Arrays.sort(a);
        double ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += a[i];
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
