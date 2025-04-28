# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy all Java files
COPY . .

# Compile the Java files
RUN javac SignalGenerator.java Backtester.java

# Default command to run the SignalGenerator
CMD ["java", "SignalGenerator"]
