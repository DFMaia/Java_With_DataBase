import java.sql.*;

public class DevMedia2 {

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
            statement.getMoreResults(Statement.KEEP_CURRENT_RESULT);
            //Quando eu quero fazer duas consultas simultâneas.

            Statement statement1 = statement.getConnection().createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT * FROM emp");

            while (result.next()){
                System.out.println(result.getInt(1));
            }

            while (result1.next()){
                System.out.println(result1.getInt(1));
            }

            statement.close();
            statement1.close();

            result.close();
            result1.close();

            connection.close();

        }catch (SQLException sqle){
            sqle.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }

    }

}
