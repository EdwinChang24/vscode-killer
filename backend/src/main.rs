use sysinfo::{ProcessExt, System, SystemExt};

fn main() {
    let s = System::new_all();
    for process in s.processes_by_exact_name("code") {
        process.kill();
    }
}
