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
public class F {
    
    public static void main(String[] args) throws Exception {
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[2 * m];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            for (int j = 2 * l - 1; j <= 2 * r - 1; j++) {
                if (t == 1 && j != 2 * l - 1 && j != 2 * r - 1) {
                    a[j] = 1;
                } else if (t == 2) {
                    a[j] = 1;
                }
            }
        }
        int x = 0, y = 0;
        for (int i = 1; i <= 2 * m - 1; i++) {
            if (a[i] == 0 && i % 2 == 0) {
                y++;
            } else if (a[i] == 0) {
                x++;
            }
        }
        out.println(x + " " + y);
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
