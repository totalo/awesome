package contest.codeforces.round975_div2;

import java.util.*;
import java.io.*;

/**
 * java 提交模板
 * atcoder、nowcoder 需要修改类名为 Main,并且去掉 package 语句
 * codeforces 只需要去掉包名
 */
public class B {
    
    public static void main(String[] args) throws Exception {
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), q = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long key = (long) (i + 1) * (n - i) - 1;
                map.merge(key, 1, Integer::sum);
            }
            for (int i = 1; i < n; i++) {
                int d = a[i] - a[i - 1] - 1;
                map.merge((long) i * (n - i), d, Integer::sum);
            }
            for (int i = 0; i < q; i++) {
                long k = sc.nextLong();
                out.print(map.getOrDefault(k, 0) +" ");
            }
            out.println();
        }
        
        out.close();
        sc.close();
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
        
        public void close() throws Exception {
            r.close();
        }
    }
}
