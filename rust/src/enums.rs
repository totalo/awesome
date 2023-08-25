#[dervie(Debug)]
// 枚举
pub fn main() {
    enum_1();
}

//enum Book {
//     Papery(u32),
//     Electronic(String),
// }
// 
// let book = Book::Papery(1001);
// let ebook = Book::Electronic(String::from("url://..."));

//enum Book {
//     Papery { index: u32 },
//     Electronic { url: String },
// }
// let book = Book::Papery{index: 1001};

enum Book {
    Papery, Electronic
}


fn enum_1() {
    let book = Book::Papery;
    let ebook = Book::Electronic;
    
    //match 枚举类实例 {
    //     分类1 => 返回值表达式,
    //     分类2 => 返回值表达式,
    //     ...
    // }
    // 即使在例外情况下没有任何要做的事 . 例外情况用下划线 _ 表示
    match book {
        Book::Papery => println!("this is a papery book"),
        Book::Electronic => println!("this is a electronic book"),
        _ => {
            println!("this is a unknown book");
        },
    }
    match ebook {
        Book::Papery => println!("this is a papery book"),
        Book::Electronic => println!("this is a electronic book"),
    }
}
