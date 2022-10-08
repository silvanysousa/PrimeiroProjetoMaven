import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		final String db_url = "jdbc:mysql://localhost:3306/reuniao";
		final String db_query = "SELECT * FROM pessoa";
		final String db_user = "root";
		final String db_password = "";
		
		
		System.out.println("Iniciando conexao ao DB");
		try (Connection c = DriverManager.getConnection(db_url, db_user, db_password);
				Statement statement = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet resultSet = statement.executeQuery(db_query)) {
			System.out.println("Conectado ao MySql");	
			
			while (resultSet.next()) {
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" \t"+resultSet.getString(3)+" \t"+resultSet.getString(4));
                System.out.println();
            }
			
		} catch (SQLException sqlException ) {
			sqlException.printStackTrace();
		}

	} 

}