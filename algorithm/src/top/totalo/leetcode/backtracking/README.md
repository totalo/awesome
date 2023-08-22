### 回溯算法

回溯算法是枚举每一种可能情况，可以用递归实现。

做题的三问（以https://leetcode.cn/problems/letter-combinations-of-a-phone-number/为例）

- 当前操作： 枚举path[i]需要填入的字母

- 子问题：构造字符串>= i的部分

- 下一个子问题：构造字符串>= i+1的部分

### 子集型回溯

每个元素都可以选择或者不选择

- [78. 子集](https://leetcode-cn.com/problems/subsets/)
- [131. 分割回文串](https://leetcode.cn/problems/palindrome-partitioning/description/)

### 组合型回溯

- [77.组合](https://leetcode.cn/problems/combinations/)
- [22.括号生成](https://leetcode.cn/problems/generate-parentheses/description/)

### 排列型回溯