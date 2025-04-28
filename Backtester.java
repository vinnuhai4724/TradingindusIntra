import java.util.*;

public class Backtester {

    public static void main(String[] args) {
        List<Double> historicalPrices = generateHistoricalPrices();
        double movingAveragePeriod = 5;

        double totalProfit = 0;
        boolean holdingStock = false;
        double buyPrice = 0;

        for (int i = (int) movingAveragePeriod; i < historicalPrices.size(); i++) {
            double avg = calculateMovingAverage(historicalPrices.subList(i - (int)movingAveragePeriod, i));
            double price = historicalPrices.get(i);

            if (!holdingStock && price > avg) {
                holdingStock = true;
                buyPrice = price;
                System.out.println("BUY at: " + price);
            } else if (holdingStock && price < avg) {
                holdingStock = false;
                totalProfit += (price - buyPrice);
                System.out.println("SELL at: " + price + " | Profit: " + (price - buyPrice));
            }
        }

        System.out.println("Total Profit from Backtest: " + totalProfit);
    }

    private static List<Double> generateHistoricalPrices() {
        Random random = new Random();
        List<Double> prices = new ArrayList<>();
        double price = 100;

        for (int i = 0; i < 100; i++) {
            price += random.nextDouble() * 4 - 2; // simulate random walk
            prices.add(price);
        }
        return prices;
    }

    private static double calculateMovingAverage(List<Double> prices) {
        double sum = 0;
        for (double p : prices) {
            sum += p;
        }
        return sum / prices.size();
    }
}
