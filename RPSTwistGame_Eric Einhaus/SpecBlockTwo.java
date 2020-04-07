import java.util.Random;
public class SpecBlockTwo extends Block implements Playable{
    @Override
    public String toString() {
        return "Random discard: Special Block 2";
    }
    
    public void playCard(Player winner, Player loser) {
        System.out.println("Block beats Attack! Special Ability 2 activated...");
        Random rand = new Random();
        int randomNum = rand.nextInt(loser.hand.size());
        loser.discard.add(loser.hand.get(randomNum));
        loser.hand.remove(loser.hand.get(randomNum));
        //loser discards the card
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        loser.hand.remove(loser.getUserPickedCard());

        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("Random loser's card removed...");
    }
}