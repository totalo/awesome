package top.totalo.leetcode.towpointers;

/**
 * 双指针 滑动窗口
 * <a href="https://leetcode.cn/problems/longest-repeating-character-replacement/description/">424. 替换后的最长重复字符</a>
 */
public class Leetcode_424 {
    
    // 双指针，统计判断当前当前窗口内的字符串是否可以在k次替换，满足最长的
    // 时间复杂度：O(n)
    // 空间复杂度：O(26)
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int l = 0, r = 0, max = 0, ans = 0;
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        // 枚举右端点
        while (r < len) {
            // 统计当前字符的次数
            count[cs[r] - 'A']++;
            // 统计窗口内的字符最大值
            max = Math.max(max, count[cs[r] - 'A']);
            r++;
            // 若当前窗口内去除最多的字符后，剩余的字母替换的次数还超过K，则一定左端点
            while (r - l - max > k) {
                count[cs[l]- 'A']--;
                l++;
            }
            // 统计答案
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2)); // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
    }
}
