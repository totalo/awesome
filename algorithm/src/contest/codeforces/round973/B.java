package contest.codeforces.round973;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class B {
    
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));;
    
    public static void main(String[] args) throws Exception {
        
        int t = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < t; i++) {
            solve();
        }
        
        reader.close();
        writer.close();
    }
    
    static void solve() throws Exception {
        int n = Integer.parseInt(reader.readLine());
        long[] nums = new long[n];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(s[i]);
        }
        
        long sum = 0;
        for (int i = 0; i < n - 2; i++) {
            sum += nums[i];
        }
        
        nums[n - 2] -= sum;
        
        writer.write(nums[n - 1] - nums[n - 2] + "\n");
    }
}
