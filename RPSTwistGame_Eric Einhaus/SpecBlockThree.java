public class SpecBlockThree extends Block implements Playable{
    @Override
    public String toString() {
        return "Cardtaker: Special Block 3";
    }

    public void playCard(Player winner, Player loser) {
        System.out.println("Block beats Attack! Special Ability 3 activated...");
        if (loser.specAttackOnePlayed || loser.specAttackTwoPlayed || loser.specAttackThreePlayed) {
            winner.hand.add(loser.hand.get(loser.getUserPickedCard()));
            loser.hand.remove(loser.hand.get(loser.getUserPickedCard()));
        }else {
            System.out.println("Card has no effect...");
        }
        //loser discards the card
        loser.discard.add(loser.hand.get(loser.getUserPickedCard()));
        loser.hand.remove(loser.getUserPickedCard());

        winner.fillHand(winner);
        loser.fillHand(loser);
        System.out.println("Loser's blocked card placed in winner's hand.");
    }
}