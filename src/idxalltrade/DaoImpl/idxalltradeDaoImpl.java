package idxalltrade.DaoImpl;

import idxalltrade.connection.idxalltradeConnection;
import idxalltrade.dao.idxalltradeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cakra
 */
public class idxalltradeDaoImpl implements idxalltradeDao
{

    private Connection con = null;
    private final idxalltradeConnection idxConn = new idxalltradeConnection();

    @Override
    public DefaultComboBoxModel getChannelTrx() throws Exception
    {
        try
        {
            String sql = "select CHANNELCODE from main.B_CHANNEL";
            this.con = this.idxConn.getConnection();
            PreparedStatement ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            while (rs.next())
            {
                dcm.addElement(rs.getString("CHANNELCODE"));
            }
            return dcm;

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Please Check Configuration Database" + e,
                    "Connection Failed", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}
