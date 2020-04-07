public class SpecAttackThree extends Attack implements Playable{
    @Override
    public String toString() {
        return "Sacrafice: Special Attack 3";
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Attack beats Throws! Special Ability 3 activated...");
        int counter = 0;
        for (int i = 0; i < winner.hand.size(); i++) {
            winner.discard.add(winner.hand.get(i));
            winner.hand.remove(winner.hand.get(i));
            counter++;
        }
        
        if (counter % 2 == 1) {
            counter = counter - 1;
        } else {
            counter = counter;
        }
        
        int damageCount = counter / 2;
        loser.setLives(loser.getLives() - damageCount);
        
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        loser.hand.remove(loser.getUserPickedCard());
        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("All of the winner's cards discarded. +1 damage to enemy for every 2 cards discarded...");
        System.out.println("Total damage taken by loser: " + damageCount);
        
    }
}