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
import model.m_aslabRPL;
import view.v_homeRPLLoginAslab;

/**
 *
 * @author dallasarivle
 */
public class c_aslabRPL {

    private v_homeRPLLoginAslab v_homeRPLLoginAslab;
    private m_aslabRPL m_aslabRPL;
    private String usr;

    public c_aslabRPL(String usr) {
        this.usr = usr;
        v_homeRPLLoginAslab = new v_homeRPLLoginAslab();
        v_homeRPLLoginAslab.setLocationRelativeTo(null);
        v_homeRPLLoginAslab.setVisible(true);
        try {
            m_aslabRPL = new m_aslabRPL();
            v_homeRPLLoginAslab.lblNama().setText(m_aslabRPL.getUser(usr));
            v_homeRPLLoginAslab.inputNilai().addActionListener(new menuInputNilai());
        } catch (SQLException ex) {
            v_homeRPLLoginAslab.pesan("koneksi ke database gagal");
            System.exit(0);
        }

    }



    private class menuInputNilai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_homeRPLLoginAslab.dispose();
            new c_nilaiRPL(usr);
        }
    }
}
