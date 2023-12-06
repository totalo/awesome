
### 窗口函数

- rank() : 阶梯排序-前两个是并列的1，接下来就是第3名
- dense_rank(): 连续排序-前两个是并列的1，接下来就是第2名
- row_number(): 不会出现重复的排序

<窗口函数> over (partition by <分组列名> order by <排序列名>)

