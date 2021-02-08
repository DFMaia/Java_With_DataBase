import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC", "root", "12345");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from emp");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " "
                + resultSet.getString(2) + " "
                + resultSet.getInt(3));
                //connection.close();
            }

            connection.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }

}