public class Card implements Playable {

    public void playCard(Player p1, Player com) {
        if (p1.specThrowOnePlayed || p1.specThrowTwoPlayed || p1.specThrowThreePlayed) { //if any of these booleans representing a card in play is true
            if (com.specBlockOnePlayed || com.specBlockTwoPlayed || com.specBlockThreePlayed) { //if the card in play is up against something it beats
                //This is if p1 puts down a throw card and com puts down a block card, p1 win
                System.out.println("Player 1 Throws, Computer blocks");
                Throw card = new Throw();
                card.playCard(p1, com);
            } else if (com.specAttackOnePlayed || com.specAttackTwoPlayed || com.specAttackThreePlayed) { //if the computer plays a card that beats the users card in play
                //This is if com puts down a attack card and p1 puts down a throw card, p1 loss
                System.out.println("Computer Attacks, Player 1 Throws");
                Attack card = new Attack();
                card.playCard(com, p1);
            } else {
                //tie, when both the user and the computer play the same sub class card type
                System.out.println("Both players put down a Throw card, which results in a tie.");
                p1.discard.add(p1.hand.get(p1.getUserPickedCard()));
                com.discard.add(com.hand.get(com.getUserPickedCard()));
                p1.hand.remove(p1.getUserPickedCard());
                com.hand.remove(com.getUserPickedCard());
                p1.fillHand(p1);
                com.fillHand(com);
            }
        } else if (p1.specAttackOnePlayed || p1.specAttackTwoPlayed || p1.specAttackThreePlayed) {
            if (com.specThrowOnePlayed || com.specThrowTwoPlayed || com.specThrowThreePlayed) {
                //This is if p1 puts down an attack card, and com puts down a throw card, p1 win
                System.out.println("Player 1 attacks, computer throws");
                Attack card = new Attack();
                card.playCard(p1, com);
            } else if (com.specBlockOnePlayed || com.specBlockTwoPlayed || com.specBlockThreePlayed) {
                //This is if com puts down a block card and p1 puts down an attack card, p1 loss
                System.out.println("Computer Blocks, Player 1 attacks");
                Block card = new Block();
                card.playCard(com, p1);
            } else {
                //tie
                System.out.println("Both players put down an Attack card, which results in a tie.");
                p1.discard.add(p1.hand.get(p1.getUserPickedCard()));
                com.discard.add(com.hand.get(com.getUserPickedCard()));
                p1.hand.remove(p1.getUserPickedCard());
                com.hand.remove(com.getUserPickedCard());
                p1.fillHand(p1);
                com.fillHand(com);
            }
        } else if (p1.specBlockOnePlayed || p1.specBlockTwoPlayed || p1.specBlockThreePlayed) {
            if (com.specAttackOnePlayed || com.specAttackTwoPlayed || com.specAttackThreePlayed) {
                //This is if p1 puts down a block card and com puts down an attack card, p1 win
                System.out.println("Player 1 Blocks, computer attacks");
                Block card = new Block();
                card.playCard(p1, com);
            } else if (com.specThrowOnePlayed || com.specThrowTwoPlayed || com.specThrowThreePlayed) {
                //This is if p1 puts down a block card and p1 puts down a throw card, p1 loss
                System.out.println("Computer Throws, Player 1 blocks");
                Throw card = new Throw();
                card.playCard(com, p1);
            } else {
                //tie
                System.out.println("Both players put down a Block card, which results in a tie.");
                p1.discard.add(p1.hand.get(p1.getUserPickedCard()));
                com.discard.add(com.hand.get(com.getUserPickedCard()));
                p1.hand.remove(p1.getUserPickedCard());
                com.hand.remove(com.getUserPickedCard());
                p1.fillHand(p1);
                com.fillHand(com);
            }
        } else { //if for some circumstance something else occurs, it results in a tie
            System.out.println("Both players tied!");
            p1.discard.add(p1.hand.get(p1.getUserPickedCard()));
            com.discard.add(com.hand.get(com.getUserPickedCard()));
            p1.hand.remove(p1.getUserPickedCard());
            com.hand.remove(com.getUserPickedCard());
            p1.fillHand(p1);
            com.fillHand(com);
        }
    }
}
