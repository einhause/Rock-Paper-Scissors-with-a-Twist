public class SpecAttackTwo extends Attack implements Playable{
    @Override
    public String toString() {
        return "Critical hit: Special Attack 2";
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Attack beats Throw! Special Ability 2 activated...");
        loser.setLives(loser.getLives() - 2);
        //winner and loser both discard the card
        winner.discard.add(winner.hand.get(winner.getUserPickedCard()));
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        winner.hand.remove(winner.getUserPickedCard());
        loser.hand.remove(loser.getUserPickedCard());
        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("+2 damage taken by enemy.");
    }
}