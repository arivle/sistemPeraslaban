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
import model.m_kalabRPL;
import view.v_homeRPLLoginKalab;

/**
 *
 * @author dallasarivle
 */
public class c_kalabRPL {

    private v_homeRPLLoginKalab v_homeRPLLoginKalab;
    private m_kalabRPL m_kalabRPL;
    private String usr;

    public c_kalabRPL(String usr) {
        this.usr = usr;
        v_homeRPLLoginKalab = new v_homeRPLLoginKalab();
        v_homeRPLLoginKalab.setLocationRelativeTo(null);
        v_homeRPLLoginKalab.setVisible(true);
        try {
            m_kalabRPL= new m_kalabRPL();
            v_homeRPLLoginKalab.setlblNama(m_kalabRPL.getUser(usr));
            v_homeRPLLoginKalab.ListAslab().addActionListener(new menuListAslab());
            v_homeRPLLoginKalab.ListCalonAslab().addActionListener(new menuListCalonAslab());
        } catch (SQLException ex) {
            ex.printStackTrace();
            v_homeRPLLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class menuListAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarAslabRPL(usr);
            v_homeRPLLoginKalab.dispose();
        }
    }

    private class menuListCalonAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarCalonAslabRPL(usr);
            v_homeRPLLoginKalab.dispose();
        }
    }

   
}
