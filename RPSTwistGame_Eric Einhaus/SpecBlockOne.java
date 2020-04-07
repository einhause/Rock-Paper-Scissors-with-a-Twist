public class SpecBlockOne extends Block implements Playable{
    @Override
    public String toString() {
        return "Lifesaver: Special Block 1";
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Block beats Attack! Special Ability 1 activated...");
        winner.setLives(winner.getLives() + 2);
        System.out.println("+2 Lives for winner");
        //loser discards the card
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        loser.hand.remove(loser.getUserPickedCard());

        winner.fillHand(winner);
        loser.fillHand(loser);
    }
}