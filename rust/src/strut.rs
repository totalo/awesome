// 结构体
pub fn main() {
    sysout();
    struct_1();
}

#[derive(Debug)]

struct Rectangle {
    width: u32,
    height: u32,
}

fn sysout() {
    let rect1 = Rectangle { width: 30, height: 50 };
    println!("rect1 is {:?}", rect1);
}

// 结构体方法的第一个参数必须是 &self，不需声明类型，因为 self 不是一种风格而是关键字。
impl Rectangle {
    fn area(&self) -> u32 {
        self.width * self.height
    }
    
    fn wider(&self, rect: Rectangle) -> bool {
        self.width > rect.width
    }
}

fn struct_1 () {
    let rect1 = Rectangle { width: 30, height: 50 };
    let rect2 = Rectangle { width: 40, height: 20 };
    println!("rect1's area is {}", rect1.area());
    println!("{}", rect1.wider(rect2));
}