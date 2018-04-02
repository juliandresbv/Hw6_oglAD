package uniandes.algorithms.coinchange;

public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm {

    @Override
    public int[] calculateOptimalChange(int totalValue, int[] denominations) {
        int[] coins = new int[denominations.length];
        int rest = totalValue;

        for ( int i = denominations.length - 1; i >= 0; i-- ) {
            int denom = denominations[i];
            int cantCoins = (int) (rest/denom);

            if ( cantCoins == 0 ) { coins[i] = 0; }
            else if ( (rest - (denom * cantCoins)) >= 0 ) {
                rest = rest - (denom * cantCoins);
                coins[i] = cantCoins;
            }
        }

        return coins;
    }
}
