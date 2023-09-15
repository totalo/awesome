pub fn main() {
    sysargs();
}

fn sysargs() {
    let args = std::env::args();
    println!("{:?}", args);
}