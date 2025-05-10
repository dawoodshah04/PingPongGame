<h1>Pong Game</h1>


🎮 A classic Pong game built in Java with modern enhancements like a ripple effect on scoring, a persistent leaderboard, and customizable player names. Designed to provide an engaging retro gaming experience with a touch of flair!


<h2>📝Features Two-Player Gameplay:</h2>

Play against a friend using keyboard controls. Ripple Effect: Visual feedback with colorful ripple animations when a goal is scored. Persistent Leaderboard: Top scores are saved locally, ensuring progress is retained between game sessions. Dynamic Boundaries: The ball bounces off boundaries for consistent gameplay. Customizable Player Names: Add a personal touch by entering your name at the start. Responsive Controls: Smooth paddle movement and collision detection.

<h3>🎯How to Play?</h3>


<h4>Player 1 Controls</h4>

Move Up: W Move Down: S

<h4>Player 2 Controls</h4>

Move Up: UP Arrow Move Down: DOWN Arrow Score by hitting the ball past your opponent's paddle!<br>

🚀 Getting Started Prerequisites Java Development Kit (JDK) 8 or higher Any IDE (e.g., IntelliJ IDEA, Eclipse) or terminal with javac and java commands. Installation Clone the Repository

``bash Copy code git clone https://github.com/dawoodshah04/pong-game.git cd pong-game Compile the Code``

``bash Copy code javac *.java Run the Game``

``bash Copy code java PongGame``

<h3>🛠️ Code Structure</h3>

Ball.java: Handles ball movement, direction, and collision logic. Paddle.java: Manages paddle behavior and player input. GamePanel.java: Core game mechanics, rendering, and game loop. GameFrame.java: Creates the main game window. Score.java: Displays the score and manages leaderboard logic. PongGame.java: Entry point for the game.

<h3>💾 Persistent Leaderboard</h3>

Scores are saved in leaderboard.txt in the project directory. On startup, the game compares past scores with new ones and ranks players accordingly. Top 10 scores are displayed in-game.

 <h3>🎨Visual Enhancements Ripple Effect</h3>

Vibrant, random-colored ripples trigger when a goal is scored. Boundaries: A sleek gray rectangle frames the game area for better visibility. 🖥️ Screenshots

🙌 Contribution Contributions are welcome! If you'd like to enhance the game, follow these steps:

Fork the repository. <br>
Create a new feature branch: ``git checkout -b feature-name``<br>
Commit your changes: ``git commit -m 'Add feature-name'``<br>
Push to the branch: ``git push origin feature-name``<br>
Open a pull request.
