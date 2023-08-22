## 动态规划

> 学习视频：【动态规划入门：从记忆化搜索到递推【基础算法精讲 17】】https://www.bilibili.com/video/BV1Xj411K7oF?vd_source=90bae9b35791b8f2abfa8a4486eed023

### 核心

**状态定义和状态转移方程**，动态规划的核心是找到状态转移方程，然后用递归或者迭代的方式实现。核心思路：`选或者不选，选哪个`

### 萌新三步

1. 思考回溯怎么写

- 入参和返回值

- 递归到哪？

- 递归的边界和入口

2. 改成记忆化搜索

3. 1:1 翻译成递推

### 背包问题

- 0-1背包问题

有n个物品，第i个物品的体积为w[i],价值为v[i]，每个物品至多选择一个，求体积和不超过背包容量的最大价值。


```java
// cap 背包容量
// w[i] 第 i 个物品的体积
// v[i] 第 i 个物品的价值
// 返回：所选物品的体积和不超过cap的前提，所能得到的最大值

public int zero_one_knapsack(int cap, int[] w, int v) {
        int len = w.length;
        return dfs(len - 1, cap);
}

private int dfs(int i, int c) {
    if (i < 0) {
        return 0;
    }
    if (c < w[i]) {
        return dfs(i - 1, c);
    }
    return Math.max(dfs(i - 1, c), dfs(i, c - w[i]) + v[i]);
}

// 可以通过记忆化搜索优化，定义数组存储每次dfs的输入和输出。
```

- 完全背包

有n种物品，第i个物品的体积为w[i],价值为v[i],每个物品可以重复选，求体积和不超过cap的最大价值。

```java
public int unbounded_knapsack(int cap, int[] w, int v) {
    int len = w.length;
    return dfs(len - 1, cap);
}

private int dfs(int i, int c) {
    if (i < 0) {
        return 0;
    }
    if (c < w[i]) {
        return dfs(i - 1, c);
    }
    return Math.max(dfs(i - 1, c), dfs(i, c - w[i]) + v[i]);
}
```

#### 时间复杂度的分析

需要计算状态的个数 * 单个状态计算的时间

#### 术语解释（默认情况）

- 子数组、子串：连续的一段（subarray、subString）

- 子序列：不连续的一段（subsequence）

#### 类型

- 状态机DP

- 区间DP

- 树形DP