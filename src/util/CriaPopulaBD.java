package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class CriaPopulaBD {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Properties properties = new Properties();
                InputStream stream = CriaPopulaBD.class.getResourceAsStream("/configuration.properties");
                properties.load(stream);
                String driver = properties.getProperty("jdbc.driver");
                String url = properties.getProperty("jdbc.url");
                String user = properties.getProperty("jdbc.user");
                String password = properties.getProperty("jdbc.password");
                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static void populaDadosIniciais() {

        System.out.println("Populando com dados iniciais");

        Connection con = CriaPopulaBD.getConnection();

        InputStream stream = CriaPopulaBD.class.getResourceAsStream("/create.sql");

        Scanner scanner = new Scanner(stream);

        scanner.useDelimiter("\n\r");
        
        try
        {

            while (scanner.hasNext()) {

                    String q = scanner.next();
                    Statement stmt = con.createStatement();
                    if (q.length() > 0) {
                        System.out.println(q);
                        stmt.execute(q);
                    }
                    stmt.close();
            }
            
            con.close();
        } catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }

       
    }

    public static void main(String[] args) throws SQLException {
        populaDadosIniciais();
    }
}
