package contest.codeforces.daily;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 灵神的cf 每日一题
 * 2024-09-24 https://codeforces.com/problemset/problem/812/C
 */
public class _240924 {
    
    static BufferedReader reader;
    static BufferedWriter writer;
    
    static long v;
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        solve();
        
        reader.close();
        writer.close();
    }
    
    private static void solve() throws Exception {
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int l = 0, r = n;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (check(nums, n, mid, s)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        writer.write(l - 1 + " " + v + "\n");
        
    }
    
    static boolean check(int[] nums, int n, int k, int s) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] + (long) (i + 1) * k;
        }
        Arrays.sort(a);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += a[i];
        }
        if (ans <= s) {
            v = ans;
            return true;
        } else {
            return false;
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
