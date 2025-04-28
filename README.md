# Intraday Trading Bot (Nifty, BankNifty, FinNifty, US Stocks)

This bot fetches market data, generates trading signals using technical indicators, and sends alerts to Telegram automatically.

## Features
- Indian Markets: NIFTY, BANKNIFTY, FINNIFTY
- US Markets: Top stocks like AAPL, TSLA, MSFT
- Backtesting historical data with simple Moving Averages
- Sends real-time BUY/SELL signals to your Telegram
- Fully auto-run using Java and Docker on Cloud

## Project Structure
- `SignalGenerator.java` - Real-time signal generator
- `Backtester.java` - Strategy backtesting on historical data
- `config.properties` - Configuration file for token/chat id
- `Dockerfile` - Deployable container setup

## Deployment
### Steps to Deploy on Fly.io
1. Push code to GitHub
2. Install Fly.io CLI
3. Run:
    ```bash
    fly launch
    fly deploy
    ```
4. Done!

## Telegram Setup
- Bot Token: `7616911905:AAFRgJbwfNHO7Hh9RHnlv1Q_FhBjmX3s74I`
- Chat ID: `6611743925`

## Author
Created with love by **[You + ChatGPT]**

---
