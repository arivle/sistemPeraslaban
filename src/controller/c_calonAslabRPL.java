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
import model.m_calonRPL;
import view.v_homeRPLLoginCalon;

/**
 *
 * @author dallasarivle
 */
public class c_calonAslabRPL {

    private v_homeRPLLoginCalon v_homeRPLLoginCalon;
    private m_calonRPL m_calonRPL;
    private String usr;

    public c_calonAslabRPL(String usr) {
        this.usr = usr;
        v_homeRPLLoginCalon = new v_homeRPLLoginCalon();
        v_homeRPLLoginCalon.setLocationRelativeTo(null);
        try {
            m_calonRPL = new m_calonRPL();
            v_homeRPLLoginCalon.setVisible(true);
            v_homeRPLLoginCalon.lblNama().setText(m_calonRPL.getUser(usr));
        } catch (SQLException ex) {
            v_homeRPLLoginCalon.pesan("koneksi database gagal");
            System.exit(0);
        }
    }

    private class menuStatusDaftar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_homeRPLLoginCalon.dispose();
        }
    }
}
