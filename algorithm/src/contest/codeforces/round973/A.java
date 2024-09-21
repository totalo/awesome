package contest.codeforces.round973;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    
    static BufferedReader reader;
    static BufferedWriter writer;
    
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < t; i++) {
            solve();
        }
        
        reader.close();
        writer.close();
    }
    
    static void solve() throws Exception {
        int n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        
        int f = Math.min(x, y);
        
        // n / f 取整
        int ans = n % f == 0 ? n / f : n / f + 1;
        
        writer.write(ans + "\n");
    }
}
