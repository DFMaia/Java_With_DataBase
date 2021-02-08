import java.sql.*;

public class MysqlCon6 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
        String user = "root";
        String dbPassword = "12345";

        String password = "javaguy";
        String fullname = "John Doe";
        String email = "john.ji@gmail.com";
        String username = "John";

        try {
            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            String sql = "UPDATE users SET password = ?, fullname = ?, email = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, fullname);
            statement.setString(3, email);
            statement.setString(4, username);

            int rows = statement.executeUpdate();

            if (rows > 0){
                System.out.println("The user's information has been updated");
            }

            connection.close();
        }catch (SQLException e){
            e.getStackTrace();
        }

    }

}
