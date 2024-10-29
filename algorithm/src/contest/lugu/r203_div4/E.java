package contest.lugu.r203_div4;

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
public class E {
    
    public static void main(String[] args) throws Exception {
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();
        
        boolean[] vis = new boolean[n + 1];
        vis[0] = true; vis[1] = true;
        int[] prime = new int[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                prime[cnt++] = i;
                for (int j = i + i; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }
        
        int i = n;
        for (; i >= 0; i--) {
            if (prime[i] != 0 && prime[i] % m == r) {
                k--;
            }
            if (k == 0) {
                break;
            }
        }
        out.println(i >= 0 ? prime[i] : -1);
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
