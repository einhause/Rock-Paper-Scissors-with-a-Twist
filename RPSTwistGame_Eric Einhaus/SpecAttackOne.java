public class SpecAttackOne extends Attack implements Playable{
    @Override
    public String toString() {
        return "1 and 1: Special Attack 1";
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Attack beats Throw! Special Ability 1 activated...");
        loser.setLives(loser.getLives() - 1); //-1 life for loser
        winner.fillHand(winner); //draw an extra card
        //winner and loser both discard the card
        winner.discard.add(winner.hand.get(winner.getUserPickedCard()));
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        winner.hand.remove(winner.getUserPickedCard());
        loser.hand.remove(loser.getUserPickedCard());
        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("+1 damage by loser. winner draws card.");
    }
}