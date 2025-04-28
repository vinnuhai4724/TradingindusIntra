import java.util.*;
import java.util.concurrent.*;
import java.net.*;
import java.io.*;

public class SignalGenerator {

    private static final String TELEGRAM_BOT_TOKEN = "7616911905:AAFRgJbwfNHO7Hh9RHnlv1Q_FhBjmX3s74I";
    private static final String TELEGRAM_CHAT_ID = "6611743925";

    public static void main(String[] args) throws Exception {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(SignalGenerator::fetchDataAndAnalyze, 0, 5, TimeUnit.MINUTES);
    }

    private static void fetchDataAndAnalyze() {
        try {
            // Simulated stock data fetch (replace with real API fetch later)
            Random random = new Random();
            double price = 100 + random.nextDouble() * 10;
            double movingAverage = 105;

            if (price > movingAverage) {
                sendTelegramMessage("BUY Signal generated at price: " + price);
            } else {
                sendTelegramMessage("SELL Signal generated at price: " + price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendTelegramMessage(String message) {
        try {
            String urlString = "https://api.telegram.org/bot" + TELEGRAM_BOT_TOKEN + "/sendMessage?chat_id=" + TELEGRAM_CHAT_ID + "&text=" + URLEncoder.encode(message, "UTF-8");
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            conn.getInputStream(); // Send the message
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
