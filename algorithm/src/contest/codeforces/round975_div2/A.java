package contest.codeforces.round975_div2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * java 提交模板
 * atcoder、nowcoder 需要修改类名为 Main,并且去掉 package 语句
 * codeforces 只需要去掉包名
 */
public class A {
    
    static BufferedReader reader;
    static BufferedWriter writer;
    
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            solve();
        }
        
        reader.close();
        writer.close();
    }
    
    private static void solve() throws Exception {
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int mx1 = 0, cnt1 = 0, mx2 = 0, cnt2 = 0;
        for (int i = 0; i < n; i += 2) {
            mx1 = Math.max(mx1, a[i]);
            cnt1++;
        }
        for (int i = 1; i < n; i += 2) {
            mx2 = Math.max(mx2, a[i]);
            cnt2++;
        }
        int ans = 0;
        ans = Math.max(mx1 + cnt1, mx2 + cnt2);
        writer.write(ans + "\n");
    }
    
    static Kattio sc = new Kattio();
    
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
