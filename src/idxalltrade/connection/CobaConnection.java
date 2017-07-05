package idxalltrade.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cakra
 */
public class CobaConnection
{

    private Connection con = null;
    private String driver;
    private String jdbc;
    private String host;
    private String port;
    private String databaseName;
    private String url;
    private String username;
    private String password;

    public CobaConnection()
    {
        this.driver = "net.sourceforge.jtds.jdbc.Driver";
        this.jdbc = "jdbc:jtds:sqlserver://";
        this.host = "127.0.0.1:";
        this.port = "1433/";
        this.databaseName = "Nayaga_Hashcheck";
        this.username = "sa";
        this.password = "Cakra123$";
        this.url = this.jdbc + this.host + this.port + this.databaseName;

    }

    public void getConnection() throws SQLException
    {
        try
        {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CobaConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
