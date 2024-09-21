package contest.atcoder.abc_b372;

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
        
        String s = reader.readLine();
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                continue;
            }
            ans.append(c);
        }
        writer.write(ans + "\n");
        
        reader.close();
        writer.close();
    }
}
