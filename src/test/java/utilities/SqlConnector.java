package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SqlConnector {
    private static final String Url = "jdbc:postgresql://localhost:5432/mortgage_calculator";
    private static final String User = "postgres";
    private static final String Password = "kitkat65";

    private static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);

    /**
     * Connet to the postgreSQL database
     *
     * @return a Connection Object
     */

    private static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Url, User, Password);
        } catch (Exception e) {
            LOGGER.error("SQL Connection Exception" + e.getMessage());
        }
        return conn;
    }

    /**
     * Reading data from the Database
     * @param SQL is the method parameter to accept the SQL query
     * @return a Resultset object
     * @throws SQLException
     */

    public static ResultSet readData(String SQL) {
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = connect();
            LOGGER.debug("Connection object value:" + conn);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);


        } catch (SQLException e) {
            LOGGER.error("SQL Connection Exception" + e.getMessage());
        }finally {
          //  conn.close();

        }
        return rs;
    }
}

