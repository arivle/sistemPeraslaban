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
import view.v_homeBasdaLoginKalab;
import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_kalabBasda {

    private v_homeBasdaLoginKalab v_homeBasdaLoginKalab;
    private m_kalabGIS m_kalabGIS;
    private String usr;
    private v_login v_login;

    public c_kalabBasda(String usr) {
        this.usr = usr;
        v_homeBasdaLoginKalab = new v_homeBasdaLoginKalab();
        v_homeBasdaLoginKalab.setLocationRelativeTo(null);
        v_homeBasdaLoginKalab.setVisible(true);
        try {
            m_kalabGIS = new m_kalabGIS();
            v_homeBasdaLoginKalab.lblNama().setText(m_kalabGIS.getUser(usr));
            v_homeBasdaLoginKalab.ListAslab(new menuListAslab());
            v_homeBasdaLoginKalab.ListCalonAslab().addActionListener(new menuListCalonAslab());
        } catch (SQLException ex) {
            v_homeBasdaLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class menuListAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarAslabBasda(usr);
            v_homeBasdaLoginKalab.dispose();
        }
    }

    private class menuListCalonAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarCalonAslabBasda(usr);
            v_homeBasdaLoginKalab.dispose();
        }
    }


}
