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
import view.v_MenuDaftarCalonAslabRPLLoginKalab;

import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_daftarCalonAslabRPL {

    private v_MenuDaftarCalonAslabRPLLoginKalab v_MenuDaftarCalonAslabRPLLoginKalab;
    private m_kalabRPL m_kalabRPL;
    private v_login v_login;
    private String usr;

    public c_daftarCalonAslabRPL(String usr) {
        this.usr = usr;
        v_MenuDaftarCalonAslabRPLLoginKalab = new v_MenuDaftarCalonAslabRPLLoginKalab();
        v_MenuDaftarCalonAslabRPLLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarCalonAslabRPLLoginKalab.setVisible(true);
        try {
            m_kalabRPL = new m_kalabRPL();
            v_MenuDaftarCalonAslabRPLLoginKalab.setTabel(m_kalabRPL.getTableDaftarCalonAslab());
            v_MenuDaftarCalonAslabRPLLoginKalab.tblDetailCalonAslabRPLClicked().addActionListener(new detailCalonAslabRPL());
            v_MenuDaftarCalonAslabRPLLoginKalab.tblTolakAslabRPLClicked().addActionListener(new tolakCalonAslabRPL());
            v_MenuDaftarCalonAslabRPLLoginKalab.tblTerimaAslabRPLClicked().addActionListener(new terimaCalonAslabRPL());
            v_MenuDaftarCalonAslabRPLLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarCalonAslabRPLLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class detailCalonAslabRPL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarCalonAslabRPLLoginKalab.setTabel(m_kalabRPL.getTableDetailDaftarAslab());
        }
    }

    private class tolakCalonAslabRPL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            m_kalabRPL.tolak(v_MenuDaftarCalonAslabRPLLoginKalab.getID());
        }
    }

    private class terimaCalonAslabRPL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_kalabRPL.terima(v_MenuDaftarCalonAslabRPLLoginKalab.getID(), m_kalabRPL.queryTerima(v_MenuDaftarCalonAslabRPLLoginKalab.getID()));
            } catch (SQLException ex) {
                v_MenuDaftarCalonAslabRPLLoginKalab.pesan("gagal terima");
            }
        }
    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_kalabRPL(usr);
            v_MenuDaftarCalonAslabRPLLoginKalab.dispose();
        }
    }
}
