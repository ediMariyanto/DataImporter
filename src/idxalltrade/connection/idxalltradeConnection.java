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
public class idxalltradeConnection
{

    private Connection con = null;
    private final String driver;
    private final String jdbc;
    private final String host;
    private final String port;
    private final String databaseName;
    private final String url;
    private final String username;
    private final String password;

    public idxalltradeConnection()
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

    private void connect() throws SQLException
    {
        try
        {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(idxalltradeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection()
    {
        try
        {
            if (this.con == null)
            {
                connect();
            } else if (this.con.isClosed())
            {
                connect();
            }
            return con;
        } catch (SQLException ex)
        {
            Logger.getLogger(idxalltradeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void closeConnection()
    {
        try
        {
            this.con.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(idxalltradeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args)
    {
        try
        {
            idxalltradeConnection id = new idxalltradeConnection();
            System.out.println(id.getConnection().isClosed());
        } catch (SQLException ex)
        {
            Logger.getLogger(idxalltradeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

