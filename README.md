# Minesweeper

This is a Java-based implementation of the classic Minesweeper game made in my second year of Lancaster University. It features a graphical interface where players can reveal squares on a board, flag potential bombs, and test their logic to avoid bombs while uncovering safe spaces.

## Features

- **Game Board**: A dynamic, customizable grid layout for the Minesweeper board.
- **Bomb Square**: Each square has a chance to contain a bomb, which can be flagged or revealed.
- **Recursive Checking**: Safe areas automatically reveal adjacent squares when clicked.
- **Interactive UI**: Left-click to reveal a square, and right-click to flag or unflag squares.

## Components

### 1. **BombSquare**
- Represents an individual square on the game board.
- Key functionalities:
  - **`leftClicked()`**: Reveals whether the square contains a bomb or the number of adjacent bombs.
  - **`rightClicked()`**: Flags or unflags a square.
  - Bomb probabilities and recursive checking mechanisms are implemented.

### 2. **GameBoard**
- The main game frame that manages the layout and user interactions.
- Key functionalities:
  - Dynamically creates a grid of `GameSquare` objects.
  - Handles click events to invoke appropriate square actions.
  - Ensures valid boundaries for board operations.

### 3. **GameSquare**
- An abstract base class for individual game squares.
- Key functionalities:
  - Maintains square coordinates and associated images.
  - Defines the abstract methods `leftClicked()` and `rightClicked()` for subclasses.

## How to Run

### Prerequisites
- Java Development Kit (JDK) installed.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a terminal with `javac` and `java` commands.

### Steps
1. Compile the project:
   ```bash
   javac *.java
   ```
2. Run the main class:
   ```bash
   java GameBoard
   ```
3. The game board will appear in a new window. Start playing by left-clicking or right-clicking squares!

## Customization

- **Board Dimensions**: Modify the `GameBoard` constructor to change the board size.
- **Bomb Probability**: Adjust the `MINE_PROBABILITY` constant in `BombSquare` to control the density of bombs.

## Notes

- Ensure all image assets (e.g., `blank.png`, `bomb.png`, `flag.png`) are available in the correct directory.
- 
- The recursive checking mechanism ensures that safe areas are efficiently revealed.
- The program adheres to object-oriented principles, allowing for easy extension and modifications.

## Author

This project is based on the contributions of **Joe Finney**, **Lancaster University**and enhanced with additional functionality to implement Minesweeper logic.
