import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlCon5 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
        String user = "root";
        String dbPassword = "12345";

        try{
            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            String sql = "UPDATE users set password = 'ohlala ' WHERE username = 'Digorys'";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);

            if(rows > 0){
                System.out.println("The user's information has been update");
            }

            connection.close();
        }catch (SQLException e){
            e.getStackTrace();
        }

    }

}
