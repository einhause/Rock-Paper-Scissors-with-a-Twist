public class Block extends Card implements Playable {
    //Block beats attack
    public void playCard(Player winner, Player loser) {
         if (winner.specBlockOnePlayed) {
            SpecBlockOne card = new SpecBlockOne();
            card.playCard(winner, loser);
        } else if (winner.specBlockTwoPlayed) {
            SpecBlockTwo card = new SpecBlockTwo();
            card.playCard(winner, loser);
        } else {
            SpecBlockThree card = new SpecBlockThree();
            card.playCard(winner, loser);
        }
    }
    }