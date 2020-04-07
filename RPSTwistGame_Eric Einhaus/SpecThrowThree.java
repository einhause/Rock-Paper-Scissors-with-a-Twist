public class SpecThrowThree extends Throw implements Playable{
    @Override
    public String toString() {
        return "No throws: Special Throw 3";
        
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Throw beats block! Special Ability 2 activated...");
        loser.cannotThrow = true; //opponent cannot throw next turn
        //winner and loser both discard the card
        winner.discard.add(winner.hand.get(winner.getUserPickedCard()));
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        winner.hand.remove(winner.getUserPickedCard());
        loser.hand.remove(loser.getUserPickedCard());
        // +1 damage for loser
        loser.setLives(loser.getLives() - 1);
        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("Finders Keepers, below is your opponents hand!");
        System.out.println();
        loser.printHand(); //peek at the opponents hand
        
    }
}