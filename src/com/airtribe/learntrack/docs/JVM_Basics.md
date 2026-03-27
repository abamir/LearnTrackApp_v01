# JVM Basics

## JDK vs JRE vs JVM
- **JVM (Java Virtual Machine)**: Executes Java bytecode. It is platform-specific
  (Windows JVM, Linux JVM) but the bytecode it runs is universal.
- **JRE (Java Runtime Environment)**: JVM + standard libraries needed to *run* Java programs.
- **JDK (Java Development Kit)**: JRE + compiler (javac) + tools needed to *develop* Java programs.

## What is Bytecode?
When you run `javac MyFile.java`, the compiler does NOT produce native machine code.
It produces an intermediate format called **bytecode** (stored in `.class` files).
The JVM then interprets/compiles this bytecode into native instructions at runtime.

## Write Once, Run Anywhere
Because bytecode is platform-neutral, you compile your Java source *once* and the
resulting `.class` files can run on any machine that has a compatible JVM installed —
whether that machine runs Windows, macOS, or Linux. You never need to recompile for
each operating system.