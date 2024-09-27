package contest.nowcoder.practice._129;

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
        
        int n = sc.nextInt();
        
        boolean[] isPrime = new boolean[n + 1];
        int[] cnt = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i; j <= n; j += i) {
                    cnt[j]++;
                    isPrime[j] = true;
                }
            }
        }
        
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (cnt[i] > 1) {
                ans++;
            }
        }
        
        
        
        writer.write(ans + "\n");
        
        reader.close();
        writer.close();
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
