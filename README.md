# Build Your Own Shell

Welcome to the **Build Your Own Shell** project! In this project, we simulate a basic Unix shell environment, allowing users to run built-in commands, navigate the file system, and execute external commands. It provides a foundation for building more advanced shell functionality and serves as a great introduction to working with processes, file systems, and environment variables in Java.

---

## Features

- **Basic Shell Commands**:
    - `exit` — Exit the shell
    - `cd <directory>` — Change the current working directory
    - `pwd` — Print the current working directory
    - `echo <message>` — Print a message to the terminal
    - `type <command>` — Show whether a command is built-in or not
    - `ls` — List all files and subfolders in the current directory

- **External Command Execution**: Execute external commands such as `ls`, `cat`, `grep`, etc., that are available in the system’s `PATH`.

- **Environment Variables**: The shell passes environment variables and the current working directory to the executed commands.

---

## Table of Contents

- [Project Setup](#project-setup)
- [Usage](#usage)
- [Commands Supported](#commands-supported)
- [Contributing](#contributing)
- [License](#license)

---

## Project Setup

### Prerequisites

To run this project locally, ensure you have the following installed:

- **Java 8 or later** – The shell is implemented in Java. Ensure that `java` and `javac` are available in your terminal.
- **Maven** – We use Maven for building the project.

### Cloning the Repository

```bash
git clone https://github.com/sagar-cpp/build-your-own-shell.git
cd build-your-own-shell
