package contest.atcoder.abc_b372;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class B {
    
    static BufferedReader reader;
    static BufferedWriter writer;
    
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int m = Integer.parseInt(reader.readLine());
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        for (i = 1; i <= 20; i++) {
            for (int j = 10; j >= 0; j--) {
                int power = (int) Math.pow(3, j);
                if (m >= power) {
                    ans.add(j);
                    m -= power;
                    break;
                }
            }
            
            if (m == 0) {
                break;
            }
        }
        
        writer.write(i + "\n");
        for (i = ans.size() - 1; i >= 0; i--) {
            writer.write(ans.get(i) + "");
            if (i > 0) {
                writer.write(" ");
            }
        }
        writer.write("\n");
        
        reader.close();
        writer.close();
    }
}
