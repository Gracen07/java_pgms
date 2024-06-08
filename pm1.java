import java.sql.*;
import java.util.*;

public class pm1{
    private Connection connection;

    public pm1() {
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?characterEncoding=utf8", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isPlayerExists(String playerName) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM players WHERE name = '" + playerName + "'");
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addPlayer(String name) {
        if (isPlayerExists(name)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Player with the same name already exists.");
            System.out.print("Do you want to add points to this player? (yes/no): ");
            String addPointsChoice = scanner.nextLine().toLowerCase();

            if (addPointsChoice.equals("yes")) {
                System.out.print("Enter points scored: ");
                int points = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                updateScore(name, points);
            } else {
                System.out.println("Skipping adding points.");
            }
        } else {
            try {
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO players (name, score, games_played, highest_score, average_score) " +
                        "VALUES ('" + name + "', 0, 0, 0, 0)";
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateScore(String playerName, int points) {
        if (!isPlayerExists(playerName)) {
            System.out.println("Player does not exist. Please enter a valid player name.");
            return;
        }

        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE players SET score = score + " + points +
                    ", games_played = games_played + 1" +
                    ", highest_score = GREATEST(highest_score, " + points + ")" +
                    ", average_score = (average_score * games_played + " + points + ") / (games_played + 1)" +
                    " WHERE name = '" + playerName + "'";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayScoreboard() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM players ORDER BY score DESC");

            System.out.println("Scoreboard:");
            int rank = 1;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");
                System.out.println(rank + ". " + name + ": " + score);
                rank++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPlayerStatistics(String playerName) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM players WHERE name = '" + playerName + "'");

            if (resultSet.next()) {
                int gamesPlayed = resultSet.getInt("games_played");
                int highestScore = resultSet.getInt("highest_score");
                double averageScore = resultSet.getDouble("average_score");

                System.out.println("Player Statistics for " + playerName + ":");
                System.out.println("Games Played: " + gamesPlayed);
                System.out.println("Highest Score: " + highestScore);
                System.out.println("Average Score: " + averageScore);
            } else {
                System.out.println("Player not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayGameOptions() {
        System.out.println("Select a game:");
        System.out.println("1. Game 1");
        System.out.println("2. Game 2");
        // Add more games as needed
    }

    public void updateScore(String playerName, int points, String game) {
        // Implement updateScore method to support multiple games
    }

    public void displayPlayerBadges(String playerName) {
        // Implement method to display player badges
    }

    public void displayEventLeaderboard(String event) {
        // Implement method to display leaderboard for a specific event
    }

    public void shareScore(String playerName, int score) {
        // Implement method to share player's score on social media
    }

    public void customizeProfile(String playerName) {
        // Implement method to allow player to customize their profile
    }

    public void visualizePlayerStatistics(String playerName) {
        // Implement method to visualize player statistics using charts/graphs
    }

    public void syncDataWithCloud(String playerName) {
        // Implement method to synchronize player data with cloud storage
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scoreboard scoreboard = new Scoreboard();

        System.out.println("Welcome to the Gaming Scoreboard System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Player");
            System.out.println("2. Update Score");
            System.out.println("3. View Scoreboard");
            System.out.println("4. View Player Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String playerName = scanner.nextLine();
                    scoreboard.addPlayer(playerName);
                    break;
                case 2:
                    System.out.print("Enter player name: ");
                    playerName = scanner.nextLine();
                    if (scoreboard.isPlayerExists(playerName)) {
                        System.out.print("Enter points scored: ");
                        int points = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        scoreboard.updateScore(playerName, points);
                    } else {
                        System.out.println("Player does not exist. Please add the player first.");
                    }
                    break;
                case 3:
                    scoreboard.displayScoreboard();
                    break;
                case 4:
                    System.out.print("Enter player name: ");
                    playerName = scanner.nextLine();
                    scoreboard.displayPlayerStatistics(playerName);
                    break;
                case 5:
                    System.out.println("Thank you for using the Gaming Scoreboard System!");
                    scanner.close();
                    try {
                        scoreboard.connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
