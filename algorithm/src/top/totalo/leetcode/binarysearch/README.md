# 二分查找

### 模版 1 ：用于查找可以通过访问数组中的单个索引来确定的元素或条件，[left, right],闭区间
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}
```

### 模版 2 ：用于查找需要访问数组中当前索引及其直接右邻居索引的元素或条件，[left, right)， 左闭右开区间
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```

### 模版 3 ：用于查找需要访问当前索引及其在数组中的直接左右邻居索引的元素或条件
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = -1, right = nums.length;
  while(left < right) {
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left + 1 == right
  if(nums[left] == target) return left;
  if(nums[right] == target) return right;
  return -1;
}
```

#### 有序数组上的二分查找主要分为以下四种情况

>= 所有的基础
> -> >= (x + 1) 大于可以转化为大于等于x+1
< -> (>= x) - 1 小于可以转换为大于等于x的左边的那个数
<= -> (> x) - 1 小于等于可以转换为大于x的左边的那个数

