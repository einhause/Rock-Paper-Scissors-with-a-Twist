public class Attack extends Card implements Playable {
    //Attack beats Throw
    public void playCard(Player winner, Player loser) {   
       
        if (winner.specAttackOnePlayed) {
            SpecAttackOne card = new SpecAttackOne();
            card.playCard(winner, loser);
        } else if (winner.specAttackTwoPlayed) {
            SpecAttackTwo card = new SpecAttackTwo();
            card.playCard(winner, loser);
        } else {
            SpecAttackThree card = new SpecAttackThree();
            card.playCard(winner, loser);
        }
    }
}