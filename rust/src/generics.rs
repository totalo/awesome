pub fn main() {
    max(&[1, 2, 3, 4, 5]);
}

fn max(array: &[i32]) -> i32 {
    let mut idx = 0;
    let mut i = 0;
    while i < array.len() {
        if array[i] > array[idx] {
            idx = i;
        }
        i += 1;
    }
    array[idx]
}

struct Point<T>{ 
    x:T, 
    y:T
}

// 类似于 java 的类的方法实现
impl <T> Point<T> {
    fn x(&self) -> &T {
        &self.x
    }
}

// 特性，类似 java 的接口


struct Person { 
    name: String,
    age: u8
}

trait Descriptive {
    fn describe(&self) -> String;
}

impl Descriptive for Person {
    fn describe(&self) -> String { 
        format!("{} {}", self.name, self.age) 
    }
}