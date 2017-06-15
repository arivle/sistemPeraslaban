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

import view.v_MenuDaftarAslabGISLoginKalab;

import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_daftarAslabGIS {

    private v_MenuDaftarAslabGISLoginKalab v_MenuDaftarAslabGISLoginKalab;
    private m_kalabGIS m_kalabGIS;
    private v_login v_login;
    private String usr;

    public c_daftarAslabGIS(String usr) {
        this.usr = usr;
        v_MenuDaftarAslabGISLoginKalab = new v_MenuDaftarAslabGISLoginKalab();
        v_MenuDaftarAslabGISLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarAslabGISLoginKalab.setVisible(true);
        try {
            m_kalabGIS = new m_kalabGIS();
            v_MenuDaftarAslabGISLoginKalab.setTabel(m_kalabGIS.getTableDaftarAslab());
            v_MenuDaftarAslabGISLoginKalab.tblDetailAslabGISClicked().addActionListener(new detailAslabGIS());
            v_MenuDaftarAslabGISLoginKalab.tblDeleteAslabGISClicked().addActionListener(new deleteAslabGIS());
            v_MenuDaftarAslabGISLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarAslabGISLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class detailAslabGIS implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarAslabGISLoginKalab.setTabel(m_kalabGIS.getTableDetailDaftarAslab());
        }
    }

    private class deleteAslabGIS implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_deleteAslab(usr);
        }
    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_kalabGIS(usr);
            v_MenuDaftarAslabGISLoginKalab.dispose();
        }
    }
}
