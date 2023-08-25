pub fn main() {
    slice();
    // slice_error();
}

fn slice() {
    let s = String::from("hello world");
    let hello = &s[0..5];
    let world = &s[6..11];
    println!("{} {}", hello, world);
}

// 在 Rust 中有两种常用的字符串类型：str 和 String。str 是 Rust 核心语言类型，就是本章一直在讲的字符串切片（String Slice），常常以引用的形式出现（&str）。
// 凡是用双引号包括的字符串常量整体的类型性质都是 &str：
// String 类型是 Rust 标准公共库提供的一种数据类型，它的功能更完善——它支持字符串的追加、清空等实用的操作
// String 和 str 除了同样拥有一个字符开始位置属性和一个字符串长度属性以外还有一个容量（capacity）属性。
// String 和 str 都支持切片，切片的结果是 &str 类型的数据。
// fn slice_error() {
//     let s = String::from("hello world");
//     let hello = &s[0..5];
//     hello.push_str("abc");
//     println!("{}", hello);
// }