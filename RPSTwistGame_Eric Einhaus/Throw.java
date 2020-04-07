public class Throw extends Card implements Playable {
    //Throw beats Block
    public void playCard(Player winner, Player loser) {
        //checks to see what exact sub sub class is played
        if (winner.specThrowOnePlayed) {
            SpecThrowOne card = new SpecThrowOne();
            card.playCard(winner, loser);
        } else if (winner.specThrowTwoPlayed) {
            SpecThrowTwo card = new SpecThrowTwo();
            card.playCard(winner, loser);
        } else {
            SpecThrowThree card = new SpecThrowThree();
            card.playCard(winner, loser);
        }
    }
}