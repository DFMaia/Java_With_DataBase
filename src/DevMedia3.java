import java.sql.*;

public class DevMedia3 {

    public static void main(String[] args) {


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
            String dbuser = "root";
            String dbPassword = "12345";

            Connection connection = DriverManager.getConnection(url, dbuser, dbPassword);

            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO newusers (username,age) VALUES ('Diego Maia',29)",
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet result = statement.getGeneratedKeys();

            if(result.first()){
                System.out.println("Generated code: " + result.getInt(1));
            } else {
                System.out.println("None code was generated.");
            }

            statement.close();
            connection.close();

        }catch (SQLException sqle){
            sqle.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }

    }

}
