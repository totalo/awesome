package contest.codeforces.round974;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// todo fix me
public class C {
    
    static BufferedReader reader;
    static BufferedWriter writer;
    
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = sc.nextInt();  // 读取测试用例数量
        
        for (int i = 0; i < t; i++) {
            solve();
        }
        
        reader.close();
        writer.close();
    }
    
    static void solve() throws IOException {
        int n = sc.nextInt();  // 人数
        long[] nums = new long[n];
        long sum = 0;  // 总财富
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
            sum += nums[i];  // 计算总财富
        }
        
        // 如果只有一个人，Robin Hood无法出现，直接输出-1
        if (n == 1) {
            writer.write("-1\n");
            return;
        }
        
        // 找到最富有者
        long maxWealth = 0;
        for (long wealth : nums) {
            maxWealth = Math.max(maxWealth, wealth);
        }
        
        // 计算当前平均财富
        long avg = (sum + n - 1) / n;  // 向上取整平均数
        
        // 如果最富有者已经使一半人不满，输出 0
        if (maxWealth >= avg) {
            writer.write("0\n");
            return;
        }
        
        // 计算增加的最小黄金 x
        long result = (avg * (n - 1)) - sum;
        
        writer.write(result + "\n");
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
