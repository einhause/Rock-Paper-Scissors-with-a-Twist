import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Game {

    static boolean comTurn = false;
    boolean p1Win = false;
    boolean comWin = false;
    boolean tie = false;

    public void  mainMenu() { //main menu, waits for userinput to display rules of game
        Scanner scan = new Scanner(System.in);
        boolean start = false;
        System.out.println("Welcome to Attack, Block, Throw, the rock, paper, scissors twist! Press s to start!");
        while (!start) {
            String userInput = scan.next();
            if (userInput.equals("s")) {
                start = true;

            } else {
                continue;
            }
        }
    }

    public void rules() { //displays the rules of the game, waits for user input to start game
        System.out.println("INSTRUCTIONS! YOU SHOULD READ THESE!");
        System.out.println("____________________________________");
        System.out.println("* Both players start with 10 lives. You're playing against an AI");
        System.out.println("* Both players start with a deck of cards they draw from."); ;
        System.out.println("* Each player starts with three cards in hand.");
        System.out.println("* They draw a card at the start of each turn. They have no max hand size.");
        System.out.println("* Each player plays a card each turn from their own respective deck.");
        System.out.println("* That card is discarded and will not be used again.");
        System.out.println("* Repeat all of this until game ends.");
        System.out.println("* If out of cards in deck, don't draw and play out cards in hand.");
        System.out.println("* If no valid plays from either player, most lives wins.");
        System.out.println("* Else, it results in a tie");

        boolean done = false;
        System.out.println();
        System.out.println("If you read these instructions, press s");
        while (!done) {
            Scanner scan = new Scanner(System.in);
            String userInput = scan.next();
            if (userInput.equals("s")) {
                done = true;
            } else {
                continue;
            }
        }
    }

    public void printLives(Player one, Player two) { //Prints the lives for each user, in a graphically convinent way
        System.out.println();
        System.out.println("Lives: ");
        System.out.println("Player 1: " + one.getLives());
        System.out.println("AI: " + two.getLives());
    }

    public void setFalse(Player one, Player two) { //sets all booleans that indicate if a card has been played to false after each turn
        one.specThrowOnePlayed = false;
        one.specThrowTwoPlayed = false;
        one.specThrowThreePlayed = false;
        one.specAttackOnePlayed = false;
        one.specAttackTwoPlayed = false;
        one.specAttackThreePlayed = false;
        one.specBlockOnePlayed = false;
        one.specBlockTwoPlayed = false;
        one.specBlockThreePlayed = false;

        two.specThrowOnePlayed = false;
        two.specThrowTwoPlayed = false;
        two.specThrowThreePlayed = false;
        two.specAttackOnePlayed = false;
        two.specAttackTwoPlayed = false;
        two.specAttackThreePlayed = false;
        two.specBlockOnePlayed = false;
        two.specBlockTwoPlayed = false;
        two.specBlockThreePlayed = false;

    }
    
    public void checkWin(Player p1, Player com) { //checks the conditions for a win, as listed below
        if (p1.hand.size() <= 0 || com.hand.size() <= 0) { //when either player has no cards in their deck to play
            if (p1.getLives() == com.getLives()) {
                System.out.println("Tie! Both players ended with no lives"); //if both players have the same number of lives.
                tie = true;
            } else if (p1.getLives() > com.getLives()) {
                System.out.println("Player 1 wins! Player 1 had the most lives at the end"); //if either player has 0 cards to play and player 1 has the most lives
                p1Win = true;
            } else {
                System.out.println("Computer wins! Computer had the most lives at the end"); //if either player had 0 cards to play and the computer has the most lives
                comWin = true;
            } 

        } else if (p1.getLives() <= 0 && com.getLives() <= 0) {
            System.out.println("Tie! Both players ended with no lives"); //Rare circumstance if both players have the same number of lives at any point of the game.
            tie = true;

        } else if (p1.getLives() <= 0) {
            System.out.println("Computer wins! Computer had the most lives at the end"); //If player 1 has 0 lives at any point in the game.
            comWin = true;
        } else if (com.getLives() <= 0) {
            System.out.println("Player 1 wins! Player 1 had the most lives at the end"); //if the computer has 0 lives at any point in the game.
            p1Win = true;
        }  else {
            //game continues
        }

    }

    public void checkValidPlay(Player player) { //this method is checked before each turn. If the user cannot play a certain card (due to throw cards) and the user only has thoses forbidden cards, the noValidPlays boolean changes to true 
        int throwCount = 0;
        int attackCount = 0;
        int blockCount = 0;
        for (int i = 0; i < player.hand.size(); i++) { //loops the array for each type of card, and counts the amount per type
            if (player.hand.get(i) instanceof SpecThrowOne || player.hand.get(i) instanceof SpecThrowTwo || player.hand.get(i) instanceof SpecThrowThree) {
                throwCount++;
            } else if (player.hand.get(i) instanceof SpecAttackOne || player.hand.get(i) instanceof SpecAttackTwo || player.hand.get(i) instanceof SpecAttackThree) {
                attackCount++; 
            } else if (player.hand.get(i) instanceof SpecBlockOne || player.hand.get(i) instanceof SpecBlockTwo || player.hand.get(i) instanceof SpecBlockThree) {
                blockCount++; 
            } else {
                continue;
            }
        }
        if ((player.cannotThrow && throwCount == player.hand.size()) || (player.cannotAttack && attackCount == player.hand.size()) || (player.cannotBlock && attackCount == player.hand.size())) {
            player.noValidPlays = true; //if the boolean value is true and there are only the forbidden card in the user's hand, the noValidPlays boolean switches to true.
        }
        player.cannotThrow = false; //sets these to false for next turn
        player.cannotAttack = false;
        player.cannotBlock = false;
    }

    public void noValidPlayProcedure(Player winner, Player loser) { //procedure if the computer has no valid plays. Any effect the user does is automatically affected on the computer
        winner.pickCard(winner);
        if (winner.specThrowOnePlayed || winner.specThrowTwoPlayed || winner.specThrowThreePlayed) {
            Throw card = new Throw();
            card.playCard(winner, loser);
        } else if (winner.specAttackOnePlayed || winner.specAttackTwoPlayed || winner.specAttackThreePlayed) {
            Attack card = new Attack();
            card.playCard(winner, loser);
        } else { //if block card is played
            Block card = new Block();
            card.playCard(winner, loser);
        }        
    }
    
    
    public void noValidPlayProcedureCom(Player winner, Player loser) { //same as above, but for the computer, a seperate method was made due to the picking card procedures for the player and Ai being different
        comTurn = true;
        winner.pickCard(winner);
        comTurn = false;
        if (winner.specThrowOnePlayed || winner.specThrowTwoPlayed || winner.specThrowThreePlayed) {
            Throw card = new Throw();
            card.playCard(winner, loser);
        } else if (winner.specAttackOnePlayed || winner.specAttackTwoPlayed || winner.specAttackThreePlayed) {
            Attack card = new Attack();
            card.playCard(winner, loser);
        } else { //if block card is played
            Block card = new Block();
            card.playCard(winner, loser);
        }        
    }

    public void run() { //the run method
        Player p1 = new Player();
        Player com = new Player();
        mainMenu();
        rules();
        p1.fillDeck();
        com.fillDeck();
        p1.fillInitialHand(p1);
        com.fillInitialHand(com);
        while (!p1Win && !comWin && !tie) {
            printLives(p1, com);
            p1.printHand();
            System.out.println();

            checkValidPlay(p1);
            checkValidPlay(com);

            if (!p1.noValidPlays && !com.noValidPlays) { //if the computer and user have valid plays
                p1.pickCard(p1);

                comTurn = true;
                com.pickCard(com);
                comTurn = false;

                Card card = new Card();
                card.playCard(p1, com);

                setFalse(p1, com); 
                checkWin(p1, com);
            } else if (p1.noValidPlays){ //if the player has no valid plays,computer automatically wins no matter what card is put down
                noValidPlayProcedureCom(com, p1);
                setFalse(com, p1); 
                checkWin(com, p1);
                p1.noValidPlays = false;
            } else { //if the computer has no valid plays, same as above but for the player's advantage
                noValidPlayProcedure(p1, com);
                setFalse(p1, com); 
                checkWin(p1, com);
                com.noValidPlays = false;
            }

        }
    }
}
