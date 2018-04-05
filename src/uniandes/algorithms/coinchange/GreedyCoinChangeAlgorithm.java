package uniandes.algorithms.coinchange;

public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm {

    @Override
    public int[] calculateOptimalChange(int totalValue, int[] denominations) {
        int[] coins = new int[denominations.length];
        int rest = totalValue;

        for ( int i = denominations.length - 1; i >= 0; i-- ) {
            int denom = denominations[i];
            int cantCoins = 0;

            if ( denom > rest ) { 
            	coins[i] = 0;
            	break;
            }
            while ( (rest - denom) >= 0 ) {
                rest = rest - denom;
                cantCoins++;
            }
            
            coins[i] = cantCoins;
        }

        return coins;
    }
}
