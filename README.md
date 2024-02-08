# Rock Paper Scissors Game

This is an extended version of the classic game Rock Paper Scissors. The game now supports 3, 5, and 7 move versions.

## Game Versions

1. **Classic Rock Paper Scissors**: This is the traditional game with three moves: Rock, Paper, and Scissors.
2. **Rock Paper Scissors Lizard Spock**: This is an extended version of the game with five moves: Rock, Paper, Scissors, Lizard, and Spock.
3. **Seven-move version**: This is the most complex version of the game with seven moves: Rock, Paper, Scissors, Fire, Water, Air, and Sponge.

## Rules

The rules for each version of the game are as follows:

- **Classic Rock Paper Scissors**: Rock crushes Scissors, Scissors cuts Paper, Paper covers Rock.
- **Rock Paper Scissors Lizard Spock**: Rock crushes Scissors and Lizard, Scissors cuts Paper and decapitates Lizard, Paper covers Rock and disproves Spock, Lizard eats Paper and poisons Spock, Spock vaporizes Rock and smashes Scissors.
- **Seven-move version**: Each move wins over two other moves and loses against two other moves. For example, Rock crushes Scissors and Sponge, but loses to Paper and Air.

## How to Play

To play the game, you need to pass the moves as command-line arguments when running the game. The moves should be passed in the following order:

- For the classic game: `java -jar game.jar rock paper scissors`
- For the five-move game: `java -jar game.jar rock paper scissors lizard Spock`
- For the seven-move game: `java -jar game.jar rock paper scissors fire water air sponge`

Please note that the order of moves is important and should match the order specified above.

Enjoy the game!
