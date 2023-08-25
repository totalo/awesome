
// 条件语句
pub fn main() {
    condition();
    condition_2();
}

// 正常的条件语句
fn condition() {
    let num = 3;
    if num < 5 {
        println!("condition was true");
    } else {
        println!("condition was false");
    }
}

// con ? A : B;

fn condition_2() {
    let a = 3;
    let num = if a > 5 { 1 } else { 0 };
    println!("num is {}", num);
}