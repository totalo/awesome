package contest.nowcoder.month101;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B {
    
    static BufferedReader reader;
    static BufferedWriter writer;
    
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String n = reader.readLine();
        String s = reader.readLine();
        
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == 'c' && !st.isEmpty() && st.peek() == 'f') {
                st.pop();
            } else  if (c == 'b' && !st.isEmpty() && st.peek() == 't') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        
        writer.write(st.size() + "\n");
        reader.close();
        writer.close();
    }
}
