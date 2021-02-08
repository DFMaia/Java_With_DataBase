import java.sql.*;

public class DevMedia {

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException cnfe){
            cnfe.getStackTrace();
        }

        try{
            String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
            String dbuser = "root";
            String dbPassword = "12345";

            Connection connection = DriverManager.getConnection(url,dbuser,dbPassword);

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM users");

            while (result.next()){
                System.out.print(result.getInt("user_id") + " ");
                System.out.print(result.getString(2) + " ");
                System.out.print(result.getString(3) + " ");
                System.out.print(result.getString(4) + " ");
                System.out.println(result.getString(5));
            }

            statement.close();
            result.close();
            connection.close();

        }catch (SQLException sqle){
            sqle.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }

    }

}
