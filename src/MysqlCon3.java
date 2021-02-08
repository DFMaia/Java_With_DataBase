import java.sql.*;

public class MysqlCon3 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
        String user = "root";
        String dbPassword = "12345";

        String username = "Jhon_Doe";
        String password = "mysecret";
        String fullname = "Jhon Doe";
        String email = "jhondoe@gmail.com";

        try {
            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            //Quando você não sabe os dados que serão inseridos no banco.
            //Então quando for escanear do teclado por exemplo...
            String sql = "INSERT INTO users (username, password, fullname, email)" +
                    "VALUES (?,?,?,?)";

            //Aqui entram as variáveis escaneadas por exemplo.
            //Número da coluna e a variável. As colunas tem que estar na mesma ordem que a String de cima.
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3, fullname);
            statement.setString(4, email);

            int row = statement.executeUpdate();

            if(row > 0){
                System.out.println("A new user has been inserted successfully");
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}