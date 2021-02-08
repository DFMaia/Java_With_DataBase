import java.sql.*;

public class MysqlCon4 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
        String user = "root";
        String dbPassword = "12345";

        try {
            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                //veja a classe MysqlCon. O exemplo é bem melhor.
                String username = result.getString(2);
                System.out.println(username);
                System.out.println();

                //Posso consulta pelo nome da coluna ao invés do número.
                int userid2 = result.getInt("user_id");
                String username2 = result.getString("username");
                String password2 = result.getString("password");
                String fullname2 = result.getString("fullname");
                String email2 = result.getString("email");
                System.out.println(userid2 + ": " + username2 + ", " + password2 + ", " +
                        fullname2 + ", " + email2 + ".");

            }

            connection.close();
        }catch (SQLException e){
            e.getStackTrace();
        }

    }
}
