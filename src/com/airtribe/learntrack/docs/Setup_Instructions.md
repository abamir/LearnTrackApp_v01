# Setup Instructions

## JDK Version Used
- Java 17 (LTS) — recommended

## Installation Steps
1. Download JDK 17+ from https://www.oracle.com/in/java/technologies/downloads/
2. Set JAVA_HOME environment variable to the JDK install path
3. Add `$JAVA_HOME/bin` to your PATH

## Compile & Run (Terminal)
```bash
# From project root (src/ directory)
javac -d out -sourcepath src src/com/airtribe/learntrack/Main.java
java -cp out com.airtribe.learntrack.Main
```

## Compile & Run (IntelliJ IDEA)
1. Open project → File > Project Structure > Set SDK to Java 17
2. Right-click Main.java → Run 'Main.main()'