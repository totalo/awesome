mod conditions;
mod loops;
mod ownership;
mod slice;
mod strut;
mod enums;
mod generics;
mod fileio;

fn main() {
    println!("Hello, world!");
    shadowing();
    conditions::main();
    loops::main();
    ownership::main();
    slice::main();
    strut::main();
    generics::main();
    fileio::main();
}

fn shadowing() {
    let x = 5;
    let x = x + 1;
    let x = x * 2;
    println!("The value of x is: {}", x); // 12
}

pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
    let mut ans = vec![];
    for i in left..right+1 {
        if is_self_dividing(i) {
            ans.push(i);
        }
    }
    ans
}

pub fn is_self_dividing(n: i32) -> bool {
    let mut num = n;
    while num > 0 {
        let digit = num % 10;
        if digit == 0 || n % digit != 0 {
            return false;
        }
        num /= 10;
    }
    true
}
