import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice; // 0 is Rock, 1 is Paper, 2 is Scissor
    private final String name;

    public RPS_Player(String name) {
        this.name = name;
        clear();
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     *
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    /**
     * Returns the number of games won since a clear() was issued.
     *
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     *
     * @return win percentage as a double.
     */
    public double getWinPercentage() {
        return (double) numberOfGamesWon / numberOfGamesPlayed;

    }

    /**
     * Starts a new game.
     */
    public void clear() {
        numberOfGamesWon = 0;
        numberOfGamesPlayed = 0;
        choice = -1; // Reset choice
    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     *
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer) {
        Random random = new Random();
        int thisChoice = random.nextInt(3); // Random choice for this player
        int otherChoice = random.nextInt(3); // Random choice for the other player

        this.choice = thisChoice;

        if (thisChoice == otherChoice) {
            // Draw
            numberOfGamesPlayed++;
            return null;

        } else if ((thisChoice == 0 && otherChoice == 2) ||
                (thisChoice == 1 && otherChoice == 0) ||
                (thisChoice == 2 && otherChoice == 1)) {
            // This player wins
            numberOfGamesWon++;
            numberOfGamesPlayed++;
            return this;
        } else {
            // Another player wins
            anotherPlayer.numberOfGamesWon++;
            anotherPlayer.numberOfGamesPlayed++;
            numberOfGamesPlayed++;
            return anotherPlayer;
        }
    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     *
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer) {
        if (choice == -1) {
            // If no previous choice is available, resort to regular challenge
            return challenge(anotherPlayer);
        }
        Random random = new Random();
        int otherChoice = random.nextInt(3); // Random choice for the other player

        if (choice == otherChoice) {
            // Draw
            numberOfGamesPlayed++;
            return null;
        } else if ((choice == 0 && otherChoice == 2) ||
                (choice == 1 && otherChoice == 0) ||
                (choice == 2 && otherChoice == 1)) {
            // This player wins
            numberOfGamesWon++;
            numberOfGamesPlayed++;
            return this;
        } else {
            // Another player wins
            anotherPlayer.numberOfGamesWon++;
            anotherPlayer.numberOfGamesPlayed++;
            numberOfGamesPlayed++;
            return anotherPlayer;
        }


    }
}

