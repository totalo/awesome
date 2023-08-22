package top.totalo.leetcode.towpointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 同向双指针、滑动窗口
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 */
public class Leetcode_3 {
    
    // 滑动窗口
    // 时间复杂度：O（n）
    // 空间复杂度：O(n)
    public static int lengthOfLongestSubstring_1(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果当前字符出现过， 则移动左指针到大值
            if (map.containsKey(s.charAt(i))) {
                // 这里之所以需要取最大值时，如 pwwkew 时，当遇到第二个w时,需要更新为第二个w的位置，而，bvbf时
                // 遇到第二个b时，需要更新到v的下标而不是b，所以满足最大值的的逻辑
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
            
        }
        return ans;
    }
    
    // 滑动窗口
    // 时间复杂度：O（n）
    // 空间复杂度：O(1)  or O(128)
    public static int lengthOfLongestSubstring_2(String s) {
        int left = 0, right = 0, ans = 0, len = s.length();
        int[] cc = new int[128];
        while (right < len) {
            char c = s.charAt(right);
            cc[c - ' ']++;
            while (cc[c - ' '] > 1) {
                cc[s.charAt(left) - ' ']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_1("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring_2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_1("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring_2("bbbbb"));
        System.out.println(lengthOfLongestSubstring_1("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring_2("pwwkew"));
    }
    
}
