# GuessMaster
**Authors:** Evginiy Lestopadov, Andrey Manturov
GuessMaster is a simple Java console game.

The player chooses **Start Game** and tries to guess a secret number. The number is generated randomly inside a small range. The player has a limited number of attempts.

The game also keeps a score. Each successfully completed round gives the player one point.

## Features

- Simple console interface
    
- Random number generation
    
- Limited number of attempts
    
- Input validation
    
- Score tracking
    
- Executable JAR
    
- Javadoc documentation
    


## Requirements

- Java 16 or newer
    
- JDK with `javac`, `java`, `jar`, and `javadoc`
    

## Build

Compile the application:

```bash
mkdir -p out
javac -encoding UTF-8 -d out -sourcepath src src/com/guessmaster/Main.java
```

Generate Javadoc:

```bash
javadoc -encoding UTF-8 \
        -d docs \
        -sourcepath src \
        -subpackages com.guessmaster \
        -author -version -quiet
```

Create the executable JAR using the existing manifest:

```bash
jar --create --verbose \
    --file=guessmaster.jar \
    --manifest=MANIFEST.MF \
    -C out .
```

`MANIFEST.MF` is already included in the project and defines the application entry point.

## Run

Run the application with:

```bash
java -jar guessmaster.jar
```

The application will ask for the player's name and then show the main menu.

```text
=================================
         GuessMaster 1.0
=================================
Enter your name:
```

Choose `1` to start a game or `2` to exit.

## How the Game Works

A new round creates a random number range.

The player has 3 attempts to guess the secret number.

Possible results are:

- **Too low** - the guess is lower than the secret number.
    
- **Too high** - the guess is higher than the secret number.
    
- **Correct** - the player wins the round and gets one point.
    
- **Out of range** - the guess is outside the current range and does not use an attempt.
    
- **Game over** - all attempts were used.
    

## Documentation

Javadoc is generated in the `docs` directory.

Open:

```text
docs/index.html
```

in a web browser to view the generated documentation.

## Build Output

After building, the project contains:

```text
out/              compiled .class files
docs/             generated Javadoc
guessmaster.jar   executable application
```

These generated files can be excluded from version control using `.gitignore`.

## License

This project is licensed under the Apache License 2.0.
