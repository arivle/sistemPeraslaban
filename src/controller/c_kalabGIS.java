/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_kalabGIS;
import view.v_homeGISLoginKalab;

/**
 *
 * @author dallasarivle
 */
public class c_kalabGIS {

    private v_homeGISLoginKalab v_homeGISLoginKalab;
    private m_kalabGIS m_kalabGIS;
    private String usr;

    public c_kalabGIS(String usr) {
        this.usr = usr;
        v_homeGISLoginKalab = new v_homeGISLoginKalab();
        v_homeGISLoginKalab.setLocationRelativeTo(null);
        v_homeGISLoginKalab.setVisible(true);
        try {
            m_kalabGIS = new m_kalabGIS();
            v_homeGISLoginKalab.lblNama().setText(m_kalabGIS.getUser(usr));
            v_homeGISLoginKalab.ListAslab().addActionListener(new menuListAslab());
            v_homeGISLoginKalab.ListCalonAslab().addActionListener(new menuListCalonAslab());
        } catch (SQLException ex) {
            v_homeGISLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class menuListAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarAslabGIS(usr);
            v_homeGISLoginKalab.dispose();
        }
    }

    private class menuListCalonAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarCalonAslabGIS(usr);
            v_homeGISLoginKalab.dispose();
        }
    }

}
