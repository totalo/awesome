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
