import java.sql.*;

public class DevMedia5 {

    public static void main(String[] args) {

        try {
            Class.forName("com.msql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
            String dbUser = "root";
            String dbPassword = "12345";

            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);

            Statement statement = connection.createStatement();

            statement.addBatch("INSERT INTO emp VALUES ('Bananna de Pijamas', 45)");
            statement.addBatch("INSERT INTO emp VALUES ('Bananna de Pijamas 2', 45)");

            statement.executeBatch();

            connection.close();
        }catch (SQLException sqle){
            sqle.getStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.getStackTrace();
        }


    }

}
