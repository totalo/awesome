
// 循环
pub fn main() {
    while_loop();
    for_loop();
    loop_loop();
}

// rust 没有 for-index 的循环，只有 while 和 loop
fn while_loop() {
    let mut num = 1;
    while num != 4 {
        println!("num is {}", num);
        num += 1;
    }
}

// for_loop

fn for_loop() {
    let a = [1, 2, 3, 4, 6];
    for i in a.iter() {
        println!("i is {}", i);
    }
}

fn for_loop_2() {
    let b = [1, 3, 4, 5, 6, 7];
    for i in 0..5 {
        println!("i is {}", b[i]);
    }
}

fn loop_loop() {
    let s = ['r', 'u', 's', 't'];
    let mut i = 0;
    let location = loop {
        let ch = s[i];
        if ch == 't' {
            break i;
        }
        i += 1;
    };
    println!("location is {}", location)
}



