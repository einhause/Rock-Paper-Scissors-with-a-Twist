public class SpecThrowOne extends Throw implements Playable{   
    @Override
    public String toString() {
        return "No Blocks: Special Throw 1";
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Throw beats Blocks! Special Ability Activated...");
        loser.cannotBlock = true; //cannot block next turn
        winner.fillHand(winner); //draw an extra card, winner
        loser.setLives(loser.getLives() - 1); //loser losses an extra life
        //winner and loser both discard the card
        winner.discard.add(winner.hand.get(winner.getUserPickedCard()));
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        winner.hand.remove(winner.getUserPickedCard());
        loser.hand.remove(loser.getUserPickedCard());
        // +1 damage for loser
        loser.setLives(loser.getLives() - 1);
        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("Loser cannot play a block next turn, 2 cards picked up for winner, +1 damage for loser");
    }
}