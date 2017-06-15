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
import view.v_MenuDaftarCalonAslabGISLoginKalab;

import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_daftarCalonAslabGIS {

    private v_MenuDaftarCalonAslabGISLoginKalab v_MenuDaftarCalonAslabGISLoginKalab;
    private m_kalabGIS m_kalabGIS;
    private v_login v_login;
    private String usr;

    public c_daftarCalonAslabGIS(String usr) {
        this.usr = usr;
        v_MenuDaftarCalonAslabGISLoginKalab = new v_MenuDaftarCalonAslabGISLoginKalab();
        v_MenuDaftarCalonAslabGISLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarCalonAslabGISLoginKalab.setVisible(true);
        try {
            m_kalabGIS = new m_kalabGIS();
            v_MenuDaftarCalonAslabGISLoginKalab.setTabel(m_kalabGIS.getTableDaftarCalonAslab());
            v_MenuDaftarCalonAslabGISLoginKalab.tblDetailCalonAslabGISClicked().addActionListener(new detailCalonAslabGIS());
            v_MenuDaftarCalonAslabGISLoginKalab.tblTolakAslabGISClicked().addActionListener(new tolakCalonAslabGIS());
            v_MenuDaftarCalonAslabGISLoginKalab.tblTerimaAslabGISClicked().addActionListener(new terimaCalonAslabGIS());
            v_MenuDaftarCalonAslabGISLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarCalonAslabGISLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class detailCalonAslabGIS implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarCalonAslabGISLoginKalab.setTabel(m_kalabGIS.getTableDetailDaftarCalonAslab());
        }
    }

    private class tolakCalonAslabGIS implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            m_kalabGIS.tolak(v_MenuDaftarCalonAslabGISLoginKalab.getID());
        }
    }

    private class terimaCalonAslabGIS implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_kalabGIS.terima(v_MenuDaftarCalonAslabGISLoginKalab.getID(), m_kalabGIS.queryTerima(v_MenuDaftarCalonAslabGISLoginKalab.getID()));
            } catch (SQLException ex) {
                v_MenuDaftarCalonAslabGISLoginKalab.pesan("gagal terima");
            }
        }
    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_kalabGIS(usr);
            v_MenuDaftarCalonAslabGISLoginKalab.dispose();
        }
    }
}
