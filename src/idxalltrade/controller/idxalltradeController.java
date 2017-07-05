package idxalltrade.controller;

import idxalltrade.DaoImpl.idxalltradeDaoImpl;
import idxalltrade.dao.idxalltradeDao;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cakra
 */
public class idxalltradeController 
{

    idxalltradeDao idxDao;

    public DefaultComboBoxModel setListChannel()
    {
        try
        {
            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            idxDao = new idxalltradeDaoImpl();
            dcm = idxDao.getChannelTrx();
            return dcm;
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Check Configuration Database" + ex,
                    "Connection Failed", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }

    public static void main(String[] args)
    {
        System.out.println("Cetak");
    }
}
