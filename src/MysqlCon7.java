import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlCon7 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
        String user = "root";
        String dbPassword = "12345";

        String username = "John";

        try{
            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            String sql = "DELETE FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            int rows = statement.executeUpdate();

            if (rows > 0){
                System.out.println("The user's information has been deleted");
            }

            connection.close();
        }catch (SQLException e){
            e.getStackTrace();
        }

    }

}
