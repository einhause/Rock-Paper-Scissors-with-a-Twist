import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Player  {
    ArrayList<Card> hand = new ArrayList<>(); //hand
    ArrayList<Card> deck = new ArrayList<>(); //deck
    ArrayList<Card> discard = new ArrayList<>(); //discard pile

    int lives; //player lives

    boolean specThrowOnePlayed;
    boolean specThrowTwoPlayed;
    boolean specThrowThreePlayed;
    boolean specAttackOnePlayed;
    boolean specAttackTwoPlayed;
    boolean specAttackThreePlayed;
    boolean specBlockOnePlayed;
    boolean specBlockTwoPlayed;
    boolean specBlockThreePlayed;

    boolean cannotBlock;
    boolean cannotAttack;
    boolean cannotThrow;
    boolean noValidPlays;

    int userPickedCard;

    public Player() { //constructor
        lives = 10; //player lives
        specThrowOnePlayed = false;
        specThrowTwoPlayed = false;
        specThrowThreePlayed = false;
        specAttackOnePlayed = false;
        specAttackTwoPlayed = false;
        specAttackThreePlayed = false;
        specBlockOnePlayed = false;
        specBlockTwoPlayed = false;
        specBlockThreePlayed = false;

        cannotBlock = false;
        cannotAttack = false;
        cannotThrow = false;
        noValidPlays = false;

        userPickedCard = 0;
    }
    //getters and setters
    public int getLives() {
        return lives;
    }

    public void setLives(int num) {
        lives = num;
    }

    public int getUserPickedCard() {
        return userPickedCard;
    }

    public void setUserPickedCard(int num) {
        userPickedCard = num;
    }

    public void fillDeck() { //fills deck at start of game with 3 of each card
        //Creating new card objects in deck
        Attack saOne = new SpecAttackOne();
        Attack saTwo = new SpecAttackTwo();
        Attack saThree = new SpecAttackThree();
        Throw stOne = new SpecThrowOne();
        Throw stTwo = new SpecThrowTwo();
        Throw stThree = new SpecThrowThree();
        Block sbOne = new SpecBlockOne();
        Block sbTwo = new SpecBlockTwo();
        Block sbThree = new SpecBlockThree();
        //now adding 3 of each into the deck array...
        deck.add(saOne);
        deck.add(saOne);
        deck.add(saOne);
        deck.add(saTwo);
        deck.add(saTwo);
        deck.add(saTwo);
        deck.add(saThree);
        deck.add(saThree);
        deck.add(saThree);
        deck.add(stOne);
        deck.add(stOne);
        deck.add(stOne);
        deck.add(stTwo);
        deck.add(stTwo);
        deck.add(stTwo);
        deck.add(stThree);
        deck.add(stThree);
        deck.add(stThree);
        deck.add(sbOne);
        deck.add(sbOne);
        deck.add(sbOne);
        deck.add(sbTwo);
        deck.add(sbTwo);
        deck.add(sbTwo);
        deck.add(sbThree);
        deck.add(sbThree);
        deck.add(sbThree);
    }

    public void fillHand(Player player) { //draws one card until the deck is empty
        if (player.deck.size() > 0) {
            Random rand = new Random();
            int randNumber;
            if (player.deck.size() > 1) {
                randNumber = rand.nextInt(player.deck.size() - 1);
            } else {
                randNumber = 0;
            }
            player.hand.add(player.deck.get(randNumber));
            player.deck.remove(randNumber);
        } else {
            //do not draw, deck is empty
        }
    }

    public void fillInitialHand(Player player) { //draws 3 cards for each user at the beginning of the game
        for (int i = 0; i < 3 ; i++) {
            fillHand(player);
        }
    }

    public void printHand() { //prints out the hand in a organized matter, using toString() for each of the Card object's string representations
        System.out.println();
        System.out.println("Deck:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.print("[ " + hand.get(i).toString() + " ]");
        }
        System.out.println();
        System.out.println();
    }

    public void pickCard(Player player) { //procedure for picking a card in valid play
        boolean done = false;
        while (!done) {
            int randCard;

            if (Game.comTurn) { //The computer uses the static boolean variable to pick a random card from the hand to put into play
                Random rand = new Random();
                if (player.hand.size() > 1) {
                    randCard = rand.nextInt((player.hand.size() - 1));
                } else {
                    randCard = 0;
                }
                player.setUserPickedCard(randCard);

            } else { //user can either pick a card from position 0 to the size of the hand - 1 or display details for each of the 9 special cards
                System.out.println("Player 1, Pick a card from 0 to " + (player.hand.size() - 1));
                System.out.println("OR");
                System.out.println("Input any of the following about any card listed below");
                System.out.println("111 - Special Throw 1");
                System.out.println("222 - Special Throw 2");
                System.out.println("333 - Special Throw 3");
                System.out.println("444 - Special Attack 1");
                System.out.println("555 - Special Attack 2");
                System.out.println("666 - Special Attack 3");
                System.out.println("777 - Special Block 1");
                System.out.println("888 - Special Block 2");
                System.out.println("999 - Special Block 3");
                Scanner scan = new Scanner(System.in);
                boolean doneHere = false;
                while (!doneHere) {
                    if (player.getUserPickedCard() == (int)player.getUserPickedCard()) { 
                        player.setUserPickedCard(scan.nextInt());
                        doneHere = true;
                    } else {
                        System.out.println("Please input a number.");
                    }
                }
            }

            if (player.getUserPickedCard() == 111) { //instructions
                System.out.println("This card beats Blocks, loses to Attacks. +1 Damage to opponent if win. Plus, an additional +1 damage and draw an extra card. Opponent cannot play a block next turn.");
            } else if (player.getUserPickedCard() == 222) {
                System.out.println("This card beats Blocks, loses to Attacks. +1 Damage to opponent if win. Plus, an additional 2 life to the winner. Opponent cannot play an attack the next turn.");
            } else if (player.getUserPickedCard() == 333) {
                System.out.println("This card beats Blocks, loses to Attacks. +1 Damage to opponent if win. Plus, you get to look at your opponents hand. Opponent cannot play a throw next turn.");
            } else if (player.getUserPickedCard() == 444) {
                System.out.println("This card beats Throws, loses to Blocks. +1 Damage to opponent if win. Plus, an additinal +1 damage to opponent and draw an extra card");
            } else if (player.getUserPickedCard() == 555) {
                System.out.println("This card beats Throws, loses to Blocks. +1 Damage to opponent if win. Plus, opponent takes an additonal 2 damage.");
            } else if (player.getUserPickedCard() == 666) {
                System.out.println("This card beats Throws, loses to Blocks. +1 Damage to opponent if win. Plus, winner discards hand, and for every 2 cards discarded (rounded down), +1 damage to opponent.");
            } else if (player.getUserPickedCard() == 777) {
                System.out.println("This card beats Attacks, loses to Throws. You keep the card if win. Plus, an additional 2 life to winner.");
            } else if (player.getUserPickedCard() == 888) {
                System.out.println("This card beats Attacks, loses to Throws. You keep the card if win. Plus, the opponent discards a card at random.");
            } else if (player.getUserPickedCard() == 999) {
                System.out.println("This card beats Attacks, loses to Throws. You keep the card if win. Plus, the card that your opponent played goes into your hand (if win).");
            }
            else if (player.hand.get(player.getUserPickedCard()) instanceof SpecThrowOne) { //if the Card object is an instance of a certain sub sub class
                if (player.cannotThrow) { //if the user cannot play a certain card, loop resets until a valid card is played
                    System.out.println("You cannot pick a Throw card at this time.");
                } else { //a card is played, a boolean variable representing a card in play is set to true, the cannot boolean variables are all set to false, and the loop stops
                    System.out.println("Card played.");
                    player.specThrowOnePlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecThrowTwo) {
                if (player.cannotThrow) {
                    System.out.println("You cannot pick a Throw card at this time.");
                } else {
                    System.out.println("Card played.");
                    player.specThrowTwoPlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecThrowThree) {
                if (player.cannotThrow) {
                    System.out.println("You cannot pick a Throw card at this time.");
                } else {
                    System.out.println("Card played.");
                    player.specThrowThreePlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecAttackOne) {
                if (player.cannotAttack) {
                    System.out.println("You cannot pick an Attack card at this time.");
                } else {
                    System.out.println("Card played.");
                    player.specAttackOnePlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecAttackTwo) {
                if (player.cannotAttack) {
                    System.out.println("You cannot pick an Attack card at this time.");
                } else { 
                    System.out.println("Card played.");
                    player.specAttackTwoPlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecAttackThree) {
                if (player.cannotAttack) {
                    System.out.println("You cannot pick an Attack card at this time.");
                } else {
                    System.out.println("Card played.");
                    player.specAttackThreePlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecBlockOne) {
                if (player.cannotBlock) {
                    System.out.println("You cannot pick a Block card at this time.");
                } else {
                    System.out.println("Card played.");
                    player.specBlockOnePlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecBlockTwo) {
                if (player.cannotBlock) {
                    System.out.println("You cannot pick a Block card at this time.");
                } else { 
                    System.out.println("Card played.");
                    player.specBlockTwoPlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            } else if (player.hand.get(player.getUserPickedCard()) instanceof SpecBlockThree) {
                if (player.cannotBlock) {
                    System.out.println("You cannot pick a Block card at this time.");
                } else {
                    System.out.println("Card played.");
                    player.specBlockThreePlayed = true;
                    player.cannotThrow = false;
                    player.cannotAttack = false;
                    player.cannotBlock = false;
                    done = true;
                }
            }  else { //if the user inputs something invalid, the loop continues
                System.out.println("Invalid input. Please Try Again.");
            }
        } 
    }

}
