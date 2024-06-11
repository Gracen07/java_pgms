import java.security.SecureRandom;
import java.sql.*;

public class PasswordManager1 {
    public static void main(String[] args) {
		Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?characterEncoding=utf8", "root", "");

            boolean exit = false;
            while (!exit) {
                System.out.println("1. Generate Password");
                System.out.println("2. Save Password");
                System.out.println("3. Retrieve Passwords");
                System.out.println("4. Update Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(System.console().readLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter length of the password: ");
                        int length = Integer.parseInt(System.console().readLine());
                        String generatedPassword = generatePassword(length);
                        System.out.println("Generated Password: " + generatedPassword);
                        System.out.println("Password Strength: " + checkPasswordStrength(generatedPassword));
                        break;
                    case 2:
                        System.out.print("Enter label/name for the password: ");
                        String label2 = System.console().readLine();
                        System.out.print("Enter password: ");
                        String newPassword = System.console().readLine();
                        savePassword(conn, label2, newPassword);
                        System.out.println("Password saved successfully.");
                        break;
                    case 3:
                        System.out.print("Enter label/name to retrieve password: ");
                        String retrieveLabel = System.console().readLine();
                        String retrievedPassword = retrievePassword(conn, retrieveLabel);
                        if (retrievedPassword != null) {
                            System.out.println("Retrieved Password: " + retrievedPassword);
                        } else {
                            System.out.println("No password found for the provided label.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter label/name to update password: ");
                        String updateLabel = System.console().readLine();
                        System.out.print("Enter new password: ");
                        String newPassword2 = System.console().readLine();
                        updatePassword(conn, updateLabel, newPassword2);
                        System.out.println("Password updated successfully.");
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }

            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading MySQL JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

 private static void savePassword(Connection conn, String label, String password) throws SQLException {
    // Check if a password with the provided label already exists
    if (passwordExists(conn, label)) {
        System.out.println("A password with the label '" + label + "' already exists.");
        return;
    }
    
    // If not, insert the new password
    String sql = "INSERT INTO passwords (label, password) VALUES (?, ?)";
    PreparedStatement st = conn.prepareStatement(sql);
    st.setString(1, label);
    st.setString(2, password);
    st.executeUpdate();
    System.out.println("Password saved successfully.");
    st.close();
}

private static boolean passwordExists(Connection conn, String label) throws SQLException {
    String sql = "SELECT COUNT(*) AS count FROM passwords WHERE label = ?";
    PreparedStatement st = conn.prepareStatement(sql);
    st.setString(1, label);
    ResultSet rs = st.executeQuery();
    rs.next();
    int count = rs.getInt("count");
    rs.close();
    st.close();
    return count > 0;
}


    private static String retrievePassword(Connection conn, String label) throws SQLException {
        String sql = "SELECT password FROM passwords WHERE label = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, label);
        ResultSet rs = st.executeQuery();
        String password = null;
        if (rs.next()) {
            password = rs.getString("password");
        }
        rs.close();
        st.close();
        return password;
    }

    private static String checkPasswordStrength(String password) {
        // Check password length and complexity and return a strength level
        int length = password.length();
        if (length < 8) {
            return "Weak : Increase the length of your password, to strengthen it.";
        } else if (length < 12) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }
    
    private static void updatePassword(Connection conn, String label, String newPassword) throws SQLException {
        String sql = "UPDATE passwords SET password = ? WHERE label = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, newPassword);
        st.setString(2, label);
        int rowsUpdated = st.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("No password found for the provided label.");
        }
        st.close();
    }
}
