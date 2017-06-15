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
import model.m_aslabGIS;
import view.v_homeGISLoginAslab;

/**
 *
 * @author dallasarivle
 */
public class c_aslabGIS {

    private v_homeGISLoginAslab v_homeGISLoginAslab;
    private m_aslabGIS m_aslabGIS;
    private String usr;

    public c_aslabGIS(String usr) {
        this.usr = usr;
        v_homeGISLoginAslab = new v_homeGISLoginAslab();
        v_homeGISLoginAslab.setLocationRelativeTo(null);
        v_homeGISLoginAslab.setVisible(true);
        try {
            m_aslabGIS = new m_aslabGIS();
            v_homeGISLoginAslab.lblNama().setText(m_aslabGIS.getUser(usr));
            v_homeGISLoginAslab.inputNilai().addActionListener(new menuInputNilai());
        } catch (SQLException ex) {
            v_homeGISLoginAslab.pesan("koneksi ke database gagal");
            System.exit(0);
        }

    }


    private class menuInputNilai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_homeGISLoginAslab.dispose();
            new c_nilaiGIS(usr);
        }
    }
}
