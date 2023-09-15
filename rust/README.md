## 基础语法

### 变量与常量

```rust
// 不可变量
let a = 123;

// 可变变量，需要加上 mut 关键字
let mut a = 123;
a = 456;

// 不可变量和常量的区别
let a = 123;
let a = 456; // 可以重新绑定

// 格式：变量名:数据类型 = 值;
const A: i32 = 123;
let A: i32 = 456; // 不能重新定义同名常量

```

重影和变量的重新赋值不是一个概念。重影是指用同一个名字重新代表另一个变量实体，其类型、可变属性和值都可以变化，但是可变变量的值只能变化，类型和可变属性不能变化。

### 数据类型

1 、整型

| 位长度 | 有符号 | 无符号 |
| --- |:---:| --- |
| 8-bit | i8 | u8 |
| 16-bit | i16 | u16 |
| 32-bit | i32 | u32 |
| 64-bit | i64 | u64 |
| 128-bit | i128 | u128 |
| arch | isize | usize |

isize 和 usize 两种整数类型是用来衡量数据大小的，它们的位长度取决于所运行的目标平台，如果是 32 位架构的处理器将使用 32 位位长度整型。

2 、浮点型

Rust 语言提供两种浮点数类型：f32 和 f64，分别对应 32 位和 64 位浮点数。

3 、布尔型

bool 类型只能取两个值：true 和 false。

4 、字符型

char 表示，占 4 个字节，存储的是 Unicode 标量值，可以用单引号表示。

5 、元组

元组是将多个其他类型的值组合成一个复合类型，元组长度固定：一旦声明，其长度不会增大或缩小。

```Rust
// 元组的声明，使用圆括号： ()
let tup: (i32, f64, u8) = (500, 6.4, 1);
// tup.0 等于 500
// tup.1 等于 6.4
// tup.2 等于 1
let (x, y, z) = tup;
// y 等于 6.4
```

6 、数组

数组中的每个元素必须类型相同，数组长度固定：一旦声明，其长度不会增大或缩小。

```Rust
let a = [1, 2, 3, 4, 5];
// a 是一个长度为 5 的整型数组

let b = ["January", "February", "March"];
// b 是一个长度为 3 的字符串数组

let c:[i32;5]=[1, 2, 3, 4, 5];
// c 是一个长度为 5 的 i32 数组

let d = [3; 5];
// 等同于 let d = [3, 3, 3, 3, 3];

let first = a[0];
let second = a[1];
// 数组访问

a[0] = 123; // 错误：数组 a 不可变
let mut a = [1, 2, 3];
a[0] = 4; // 正确
```

## 函数

### 函数的定义

```
fn <函数名> ( <参数> ) <函数体>
```

### 函数参数

Rust 中定义函数如果需要具备参数必须声明参数名称和类型：

```Rust
fn main() { 
    let x = 5;
    
    let y = { 
        let x = 3;
        x + 1
    };
    println!("x 的值为 : {}", x);
    println!("y 的值为 : {}", y);
}
```

### 条件语句

Rust 中的条件语句必须是 bool 类型。

### 循环

Rust 中没有 for-index 形式的 for 循环，而是采用 while 代替或者是 for in 形式的 for 循环。

```Rust
let a = [10, 20, 30, 40, 50];
let mut index = 0;
while index < 5 {
    println!("the value is: {}", a[index]);
    index = index + 1;
}
```

```Rust
let a = [10, 20, 30, 40, 50];
for element in a.iter() {
    println!("the value is: {}", element);
}
```

### 所有权

所有权的概念是为了让 Rust 在编译阶段更有效的分析内存资源的有用性以实现内存管理而诞生的概念。

#### 所有权规则

- Rust 中的每一个值都有一个被称为其 所有者（owner）的变量。
- 一次只能有一个所有者
- 当所有者（变量）离开作用域，这个值将被丢弃。

#### 变量范围

```rust
{
    // 在声明以前，变量 s 无效
    let s = "runoob";
    // 这里是变量 s 的可用范围
}
// 变量范围已经结束，变量 s 无效
```
变量范围是变量的一个属性，其代表变量的可行域，默认从声明变量开始有效直到变量所在域结束。

### 切片

切片（slice）类型代表了对一个数组（或者其他类型的序列）的引用，指定了序列的开始和结束位置。

### 结构体

结构体（struct）是一种自定义数据类型，允许你命名和包装多个相关的值，从而形成一个更加强大的类型。

定义

```Rust
struct Site {
    domain: String,
    name: String,
    nation: String,
    found: u32
}
```

### 组织管理

Rust 有三个比较重要的组织管理的概念：箱、包、模块。

#### 箱

箱（crate）是 Rust 中最高层的组织单元，它是一个二进制（或者动态库）文件。

箱"是二进制程序文件或者库文件，存在于"包"中。箱"是树状结构的，它的树根是编译器开始运行时编译的源文件所编译的程序。

注意："二进制程序文件"不一定是"二进制可执行文件"，只能确定是是包含目标机器语言的文件，文件格式随编译环境的不同而不同。


#### 包

包（package）是一个或者多个箱的集合，它包含一个 Cargo.toml 文件，这个文件描述了如何构建这些箱。

当我们使用 Cargo 执行 new 命令创建 Rust 工程时，工程目录下会建立一个 Cargo.toml 文件。工程的实质就是一个包，包必须由一个 Cargo.toml 文件来管理，该文件描述了包的基本信息以及依赖项。

src 目录下会生成一个 main.rs 源文件，Cargo 默认这个文件为二进制箱的根，编译之后的二进制箱将与包名相同。

#### 模块

Rust 中有两种简单的访问权：公共（public）和私有（private）。

默认情况下，如果不加修饰符，模块中的成员访问权将是私有的。

如果想使用公共权限，需要使用 pub 关键字。

对于私有的模块，只有在与其平级的位置或下级的位置才能访问，不能从其外部访问。

Rust 中的路径分隔符是 :: 。

路径分为绝对路径和相对路径。绝对路径从 crate 关键字开始描述。相对路径从 self 或 super 关键字或一个标识符开始描述

```rust
crate::nation::government::govern();
```

### 错误处理

Rust 有一套独特的处理异常情况的机制，它并不像其它语言中的 try 机制那样简单，程序中一般会出现两种错误：可恢复错误和不可恢复错误。

可恢复错误的典型案例是文件访问错误，如果访问一个文件失败，有可能是因为它正在被占用，是正常的，我们可以通过等待来解决。

但还有一种错误是由编程中无法解决的逻辑错误导致的，例如访问数组末尾以外的位置。

大多数编程语言不区分这两种错误，并用 Exception （异常）类来表示错误。在 Rust 中没有 Exception。

对于可恢复错误用 Result<T, E> 类来处理，对于不可恢复错误使用 panic! 宏来处理。

#### 可恢复的错误

在 Rust 中通过 Result<T, E> 枚举类作返回值来进行异常表达：

```rust
enum Result<T, E> {
    Ok(T),
    Err(E),
}
```
在 Rust 标准库中可能产生异常的函数的返回值都是 Result 类型的。例如：当我们尝试打开一个文件时：

```rust
use std::fs::File;

fn main() {
  let f = File::open("hello.txt");
  match f {
    Ok(file) => {
      println!("File opened successfully.");
    },
    Err(err) => {
      println!("Failed to open the file.");
    }
  }
}
```

如果想使一个可恢复错误按不可恢复错误处理，Result 类提供了两个办法：unwrap() 和 expect(message: &str) ：

```rust
use std::fs::File;

fn main() {
    let f1 = File::open("hello.txt").unwrap();
    let f2 = File::open("hello.txt").expect("Failed to open.");
}
```

这段程序相当于在 Result 为 Err 时调用 panic! 宏。两者的区别在于 expect 能够向 panic! 宏发送一段指定的错误信息。

### 泛型

泛型（Generics）是指在定义函数、结构体、枚举、trait（特性）时使用类型占位符（placeholder）来代表任意类型。

#### 特性

特性（trait）概念接近于 Java 中的接口（Interface），但两者不完全相同。特性与接口相同的地方在于它们都是一种行为规范，可以用于标识哪些类有哪些方法。

特性在 Rust 中用 trait 表示：

```rust
trait Descriptive {
    fn describe(&self) -> String;
}
```
Descriptive 规定了实现者必需有 describe(&self) -> String 方法。

格式：

```rust
impl <特性名> for <所实现的类型名>
```

Rust 同一个类可以实现多个特性，每个 impl 块只能实现一个。

接口只能规范方法而不能定义方法，但特性可以定义方法作为默认方法，因为是"默认"，所以对象既可以重新定义方法，也可以不重新定义方法使用默认的方法：

#### 特性做参数

很多情况下我们需要传递一个函数做参数，例如回调函数、设置按钮事件等。在 Java 中函数必须以接口实现的类实例来传递，在 Rust 中可以通过传递特性参数来实现：

```rust
fn output(object: impl Descriptive) {
    println!("{}", object.describe());
}
```

任何实现了 Descriptive 特性的对象都可以作为这个函数的参数，这个函数没必要了解传入对象有没有其他属性或方法，只需要了解它一定有 Descriptive 特性规范的方法就可以了。当然，此函数内也无法使用其他的属性与方法。

特性参数还可以用这种等效语法实现：

```rust
fn output<T: Descriptive>(object: T) {
    println!("{}", object.describe());
}
```

这是一种风格类似泛型的语法糖，这种语法糖在有多个参数类型均是特性的情况下十分实用：

```rust
fn output_two<T: Descriptive>(arg1: T, arg2: T) {
    println!("{}", arg1.describe());
    println!("{}", arg2.describe());
}
```

特性作类型表示时如果涉及多个特性，可以用 + 符号表示，例如：

```rust
fn notify(item: impl Summary + Display)
fn notify<T: Summary + Display>(item: T)
```
注意：仅用于表示类型的时候，并不意味着可以在 impl 块中使用。

复杂的实现关系可以使用 where 关键字简化，例如：

```rust
fn some_function<T: Display + Clone, U: Clone + Debug>(t: T, u: U)
```

可以简化为：

```rust
fn some_function<T, U>(t: T, u: U) -> i32
    where T: Display + Clone,
          U: Clone + Debug
```

#### 特性做返回值

特性也可以作为函数的返回值，例如：

```rust
fn person() -> impl Descriptive { 
    Person { 
        name: String::from("Cali"), 
        age: 24 
    }
}
```

但是有一点，特性做返回值只接受实现了该特性的对象做返回值且在同一个函数中所有可能的返回值类型必须完全一样。比如结构体 A 与结构体 B 都实现了特性 Trait，下面这个函数就是错误的：

```rust
fn some_function(bool bl) -> impl Descriptive { 
    if bl { 
        return A {}; 
    } else { 
        return B {}; 
    }
}
```

#### 有条件实现方法

impl 功能十分强大，我们可以用它实现类的方法。但对于泛型类来说，有时我们需要区分一下它所属的泛型已经实现的方法来决定它接下来该实现的方法：

```rust
struct A<T> {}

impl<T: B + C> A<T> {
    fn d(&self) {}
}
```

这段代码声明了 A<T> 类型必须在 T 已经实现 B 和 C 特性的前提下才能有效实现此 impl 块。