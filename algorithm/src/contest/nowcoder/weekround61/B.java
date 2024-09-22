package contest.nowcoder.weekround61;

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
public class B {
    
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
    
    static void solve() throws Exception {
        int n = sc.nextInt();
        // 判断是否为完全平方数
        int x = (int) Math.sqrt(n);
        boolean f1 = false;
        if (x * x == n) {
            f1 = true;
        }
        // 判断是否是等边三角形的面积
        // 为什么这么可以呢？
        boolean f2 = false;
        if (n % 3 == 0) {
            int y = n / 3;
            int z = y * 2;
            if (y * z == n) {
                f2 = true;
            }
        }
        if (f1 && f2) {
            writer.write("2\n");
        } else if (!f1 && !f2) {
            writer.write("3\n");
        } else if (f1){
            writer.write("0\n");
        } else {
            writer.write("1\n");
        }
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

