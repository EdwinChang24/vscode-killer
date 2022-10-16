# VS Code Killer

A VS Code killer that actually works.

## Background

Recently, JetBrains released a public preview of their new IDE called Fleet.
Many people in the programming community declared that Fleet would be the "VS Code killer".
So I installed Fleet on my computer and opened it, and to my disappointment,
the VS Code instance running on my computer was not affected.
I set out to create a new VS Code killer that actually works.
The result is this project.

## Structure

The frontend is written in Kotlin using Compose Desktop, and the backend is written in Rust as a command line tool.

## Install

### Backend

First, clone this repo and `cd` into the `backend` directory.

Then, run `cargo build --release` to build the `vscode-killer` binary.

Copy the binary to `/usr/bin/` or somewhere else in your system `PATH`:

```sh
sudo cp target/release/vscode-killer /usr/bin/vscode-killer
```

You may need to copy it somewhere else if you are using Windows.

To test it, run `vscode-killer` and any running instance of VS Code should be killed.

### Frontend

Go to the `frontend` directory:

```sh
cd ../frontend
```

Build the release binary for your system:

```sh
./gradlew packageReleaseDistributionForCurrentOS
```

This command might be slightly different on Windows.

Once the packaging is finished, you can install it to your system and run it.

## Known Issues

Smart mode is currently unavailable, but it will be coming soon™.

Also, this app currently cannot kill the web version of VS Code. I apologize for the inconvenience.

## Contributing

Please feel free to submit PRs and issues.
