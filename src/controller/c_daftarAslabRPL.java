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
import view.v_MenuDaftarAslabRPLLoginKalab;

import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_daftarAslabRPL {

    private v_MenuDaftarAslabRPLLoginKalab v_MenuDaftarAslabRPLLoginKalab;
    private m_kalabRPL m_kalabRPL;
    private v_login v_login;
    private String usr;

    public c_daftarAslabRPL(String usr) {
        this.usr = usr;
        v_MenuDaftarAslabRPLLoginKalab = new v_MenuDaftarAslabRPLLoginKalab();
        v_MenuDaftarAslabRPLLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarAslabRPLLoginKalab.setVisible(true);
        try {
            m_kalabRPL = new m_kalabRPL();
            v_MenuDaftarAslabRPLLoginKalab.setTabel(m_kalabRPL.getTableDaftarAslab());
            v_MenuDaftarAslabRPLLoginKalab.tblDetailAslabRPLClicked().addActionListener(new detailAslabRPL());
            v_MenuDaftarAslabRPLLoginKalab.tblDeleteAslabRPLClicked().addActionListener(new deleteAslabRPL());
            v_MenuDaftarAslabRPLLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarAslabRPLLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class detailAslabRPL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarAslabRPLLoginKalab.setTabel(m_kalabRPL.getTableDetailDaftarAslab());
        }
    }

    private class deleteAslabRPL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_deleteAslab(usr);
            
        }
    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_kalabRPL(usr);
            v_MenuDaftarAslabRPLLoginKalab.dispose();
        }
    }
}
