import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlCon2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sonoo?createDatabaseIfNotExist=true&serverTimezone=UTC";
        String user = "root";
        String password = "12345";

        try {
            //Estabelecendo conex�o.
            Connection connection = DriverManager.getConnection(url, user, password);

            //String de inser��o no DB
            String sql = "INSERT INTO users (username, password, fullname, email)" +
                        "VALUES ('Digorys', '123456', 'Diego Ferreira Maia', 'diego.maia@montreal.com')";

            //Statement s�o objetos para alterar o banco.
            Statement statement = connection.createStatement();

            //Aqui ele altera conforme a string.
            // Ele retorna tamb�m um n�mero. 0 para n�o adicionou nada
            // e um n�mero tal para o n�mero de linhas que adicionou.
            int row = statement.executeUpdate(sql);

            if(row > 0){
                System.out.println("A new user has been inserted successfully");
            }

            //Fechando conex�o
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
