public class SpecThrowTwo extends Throw implements Playable{
    @Override
    public String toString() {
        return "No Attacks: Special Throw 2";
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Throw beats Block! Special Ability 2 activated...");
        loser.cannotAttack = true; //loser cannot attack next turn
        winner.setLives(winner.getLives() + 2); //winner gets 2 lives
        //winner and loser both discard the card
        winner.discard.add(winner.hand.get(winner.getUserPickedCard()));
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        winner.hand.remove(winner.getUserPickedCard());
        loser.hand.remove(loser.getUserPickedCard());
        // +1 damage for loser
        loser.setLives(loser.getLives() - 1);
        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("Loser cannot play an attack the next turn, +2 life for winner");
    }
}