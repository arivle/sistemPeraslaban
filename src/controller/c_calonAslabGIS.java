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
import model.m_calonGIS;
import view.v_homeGISLoginCalon;

/**
 *
 * @author dallasarivle
 */
public class c_calonAslabGIS {

    private v_homeGISLoginCalon v_homeGISLoginCalon;
    private m_calonGIS m_calonGIS;
    private String usr;

    public c_calonAslabGIS(String usr) {
        this.usr = usr;
        v_homeGISLoginCalon = new v_homeGISLoginCalon();
        v_homeGISLoginCalon.setLocationRelativeTo(null);
        try {
            m_calonGIS = new m_calonGIS();
            v_homeGISLoginCalon.setVisible(true);
            v_homeGISLoginCalon.lblNama().setText(m_calonGIS.getUser(usr));
        } catch (SQLException ex) {
            v_homeGISLoginCalon.pesan("koneksi database gagal");
            System.exit(0);
        }
    }

    private class menuStatusDaftar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_homeGISLoginCalon.dispose();

        }
    }
}
