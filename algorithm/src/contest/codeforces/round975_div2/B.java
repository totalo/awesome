package contest.codeforces.round975_div2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
    
    private static void solve() throws Exception {
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        
        long[] k = new long[q];
        for (int i = 0; i < q; i++) {
            k[i] = sc.nextLong();
        }
        
        TreeMap<Long, Long> map = new TreeMap<>();
        
        // 这里会优化
        
        // 遍历所有 (i, j) 对，更新差分数组
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long l = x[i];
                long r = x[j];
                map.merge(l, 1L, Long::sum);
                map.merge(r + 1, -1L, Long::sum);
            }
        }
        
        TreeMap<Long, Long> coverMap = new TreeMap<>();
        long cnt = 0;
        long prePos = 0;
        
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            long pos = entry.getKey();
            long len = entry.getValue();
            if (cnt > 0 && prePos > 0) {
                coverMap.merge(cnt, pos - prePos, Long::sum);
            }
            
            cnt += len;
            prePos = pos;
        }
        
        for (int i = 0; i < q; i++) {
            writer.write(coverMap.getOrDefault(k[i], 0L) + "");
            if (i < q - 1) {
                writer.write(" ");
            }
        }
        writer.write("\n");
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
