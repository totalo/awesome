import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    
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
    
    static void solve() throws IOException {
        int n = sc.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);
        int idx = n / 2;
        if (n <= 2) {
            writer.write("-1\n");
            return;
        }
//        if (nums[idx] <= ((sum - 1 ) / (2L * n))) {
//            writer.write("0\n");
//            return;
//        }
        
        long ans = Math.max(0, nums[idx] * 2L * n + 1 - sum);
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
