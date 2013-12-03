Game Controls
=============
+ ESC - Display the Main Menu
+ F1 - Display the Help Menu
+ F2 - Display Government Action(Not active)
+ F3 - Display Military actions(Not active)
+ F4 - Display Political actions menu(Not active)
+ F5 - Display Resource actions(Not active)
+ F6 - Display wealth actions(Not active)
+ WASD - Movement of the player
+ UP,DOWN,LEFT,RIGHT - Movement of the player
+ T - Display the teleport menu and world map
+ E - Get support of the territory
+ G - Start a government
+ I - Investigate an Item(Not active)
+ ENTER - In game select actions
+ K - Display Player coordinates in the terminal

Iteration 1 Goals
=================
- [ ] Implement an isometric tile-based board.
- [x] Implement a player sprite.
- [x] Control movement of the player sprite on the board.
- [x] Implement a start screen
- [ ] Have the player initialize their 'values' for happiness

Project Approach
----------------
We will be using a USE CASE driven approach for the development of our game.

### Iteration 1 Use Case: Start a New Game
1. User runs the application.
2. User selects "Start New Game".
3. User customizes player.
  1. User enters a name for the player.
  2. User adjusts happiness 'values'.
4. User moves the player around the game board.

### Future Iteration Use Case: Projected Finished Product
1. User runs the application.
2. User selects "Start New Game".
3. User creates a save file.
4. User customizes player.
  1. User enters a name for the player.
  2. User adjusts happiness 'values'.
5. User moves the player around the game board.
  1. Player can interact with territories.
6. Player creates country in current territory.
7. Player chooses type of government.

What changed?
-------------
+ Isometric board changed to orthogonal.
+ Did not implement start screen.
+ Did not initialize happiness values.
+ Started work on logic for creation of government.
+ Started work on determining the happiness of a player.

What we Achieved
----------------
+ Implemented an orthogonal board.
+ Implemented player sprite and animations for movement.
+ Implemented example/simple player stats.
+ Implemented multiple levels/territories and travel between them.

Essential for Future Iterations:
--------------------------------
+ [ ] Government and elections fully implemented.
+ [ ] Capturing player happiness is fully implemented.
+ [x] Start screen/menu.

Extras for Future Iterations:
----------------------------
+ [ ] Multi-player interactions
+ [x] NPCs
+ [ ] Items on the board to pickup
+ [ ] Trade items

Iteration 2 Goals
=================
- [x] Start Screen/menu.
- [x] Player attribute set screen.
- [ ] Government and elections fully implemented.
- [ ] Capturing player happiness is fully implemented.
- [x] Player attributes can be set.
- [x] Government initalization menu.
- [x] Create save games.
- [x] Fix governments across levels

What we Achieved so Far:
------------------------
+ Start Screen/menu.
+ Player attribute set screen.
+ Player attributes can be set.
+ Teleport system implemented.
+ Added new levels/maps
+ Added new animations.
+ Fix player HUD from disappearing.
+ Government partially implemented.
+ Elections partially implemented.
+ Action menus partially implemented.
+ Added a Help Menu
+ Government class now Garbage Collects properly.
+ Government and support is now tied to the level.
+ Create save game files upon proper exit of game.

Iteration 3 Goals:
==================
- [ ] Fix government logic (Country > Government > Election)
- [x] Map overview with player location
- 
Bugs to be fixed:
-----------------
* Player is in the main menu for the time, clicks load game. Window pops up blank and error occurs
* Player in in the main menu for the first time, clicks save game to disk. window closes. no game to save(?)
* Player is in a new game in any map, presses an action button and two equivalent windows pop up for several actions **have to click x on each window!**
* A current government is in place. No changing gov't(?)
* Close gov't menu after choosing gov't for a map
* When a player saves a game and exits, save game can be loaded only once after that time. cannot be loaded for several times in the future,
  even if player clicks "save and exit" each time
