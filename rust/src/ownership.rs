// 所有权
pub fn main() {
    ownership();
    ownership_2();
    reference();
}

fn ownership() {
    let s = String::from("hello");
    // s 被声明有效

    takes_ownership(s);
    // s 的值被当作参数传入函数
    // 所以可以当作 s 已经被移动，从这里开始已经无效

    let x = 5;
    // x 被声明有效

    makes_copy(x);
    // x 的值被当作参数传入函数
    // 但 x 是基本类型，依然有效
    // 在这里依然可以使用 x 却不能使用 s

} // 函数结束, x 无效, 然后是 s. 但 s 已被移动, 所以不用被释放

fn takes_ownership(some_string: String) {
    // 一个 String 参数 some_string 传入，有效
    println!("{}", some_string);
} // 函数结束, 参数 some_string 在这里释放

fn makes_copy(some_integer: i32) {
    // 一个 i32 参数 some_integer 传入，有效
    println!("{}", some_integer);
} // 函数结束, 参数 some_integer 是基本类型, 无需释放

fn ownership_2() {
    let s1 = gives_ownership();
    // gives_ownership 移动它的返回值到 s1

    let s2 = String::from("hello");
    // s2 被声明有效

    let s3 = takes_and_gives_back(s2);
    // s2 被当作参数移动, s3 获得返回值所有权
} // s3 无效被释放, s2 被移动, s1 无效被释放.

fn gives_ownership() -> String {
    let some_string = String::from("hello");
    // some_string 被声明有效

    return some_string;
    // some_string 被当作返回值移动出函数
}

fn takes_and_gives_back(a_string: String) -> String {
    // a_string 被声明有效

    a_string  // a_string 被当作返回值移出函数
}

// 被当作函数返回值的变量所有权将会被移动出函数并返回到调用函数的地方，而不会直接被无效释放。
// 和函数传递道理一致
fn reference() {
    let s1 = String::from("hello");
    let s2 = &s1;
    println!("s1 is {}, s2 is {}", s1, s2);
}

// fn reference_2() {
//     let s1 = String::from("hello");
//     let s2 = &s1;
//     // s1 的所有权已经转移给 s2，所以 s1 不能再使用
//     // let s3 = &s2;
//     let s3 = s1;
//     println!("{}", s2);
// }

// s2 尝试修改 s1 的值被阻止，租借的所有权不能修改所有者的值。
// fn reference_3() {
//     let s1 = String::from("run");
//     let s2 = &s1;
//     println!("{}", s2);
//     // s2 是不可变的引用
//     s2.push_str("oob"); // 错误，禁止修改租借的值
//     println!("{}", s2);
// }

fn reference_4() {
    let mut s1 = String::from("run");
    // s1 是可变的

    let s2 = &mut s1;
    // s2 是可变的引用

    s2.push_str("oob");
    println!("{}", s2);
}


