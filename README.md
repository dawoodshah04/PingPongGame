``**Pong Game**``


🎮 A classic Pong game built in Java with modern enhancements like a ripple effect on scoring, a persistent leaderboard, and customizable player names. Designed to provide an engaging retro gaming experience with a touch of flair!

📝 **Features Two-Player Gameplay:**

Play against a friend using keyboard controls. Ripple Effect: Visual feedback with colorful ripple animations when a goal is scored. Persistent Leaderboard: Top scores are saved locally, ensuring progress is retained between game sessions. Dynamic Boundaries: The ball bounces off boundaries for consistent gameplay. Customizable Player Names: Add a personal touch by entering your name at the start. Responsive Controls: Smooth paddle movement and collision detection.

🎯 **How to Play?**


**Player 1 Controls**:

Move Up: W Move Down: S

**Player 2 Controls:**

Move Up: UP Arrow Move Down: DOWN Arrow Score by hitting the ball past your opponent's paddle!

🚀 Getting Started Prerequisites Java Development Kit (JDK) 8 or higher Any IDE (e.g., IntelliJ IDEA, Eclipse) or terminal with javac and java commands. Installation Clone the Repository

bash Copy code git clone https://github.com/your-username/pong-game.git cd pong-game Compile the Code

bash Copy code javac *.java Run the Game

bash Copy code java PongGame

🛠️ **Code Structure**

Ball.java: Handles ball movement, direction, and collision logic. Paddle.java: Manages paddle behavior and player input. GamePanel.java: Core game mechanics, rendering, and game loop. GameFrame.java: Creates the main game window. Score.java: Displays the score and manages leaderboard logic. PongGame.java: Entry point for the game.

💾 **Persistent Leaderboard**

Scores are saved in leaderboard.txt in the project directory. On startup, the game compares past scores with new ones and ranks players accordingly. Top 10 scores are displayed in-game.

🎨 **Visual Enhancements Ripple Effect**:

Vibrant, random-colored ripples trigger when a goal is scored. Boundaries: A sleek gray rectangle frames the game area for better visibility. 🖥️ Screenshots

🙌 Contribution Contributions are welcome! If you'd like to enhance the game, follow these steps:

Fork the repository. Create a new feature branch: git checkout -b feature-name. Commit your changes: git commit -m 'Add feature-name'. Push to the branch: git push origin feature-name. Open a pull request.
