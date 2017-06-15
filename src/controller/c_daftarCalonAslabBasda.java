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
import model.m_kalabBasda;
import view.v_MenuDaftarCalonAslabBasdaLoginKalab;

import view.v_login;

/**
 *
 * @author dallasarivleKalab
 */
public class c_daftarCalonAslabBasda {

    private v_MenuDaftarCalonAslabBasdaLoginKalab v_MenuDaftarCalonAslabBasdaLoginKalab;
    private m_kalabBasda m_kalabBasda;
    private v_login v_login;
    private String usr;

    public c_daftarCalonAslabBasda(String usr) {
        this.usr = usr;
        v_MenuDaftarCalonAslabBasdaLoginKalab = new v_MenuDaftarCalonAslabBasdaLoginKalab();
        v_MenuDaftarCalonAslabBasdaLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarCalonAslabBasdaLoginKalab.setVisible(true);
        try {
            m_kalabBasda = new m_kalabBasda();
            v_MenuDaftarCalonAslabBasdaLoginKalab.setTabel(m_kalabBasda.getTableDaftarCalonAslab());
            v_MenuDaftarCalonAslabBasdaLoginKalab.tblDetailCalonAslabBasdaClicked().addActionListener(new detailCalonAslabBasda());
            v_MenuDaftarCalonAslabBasdaLoginKalab.tblTolakCalonAslabBasdaClicked().addActionListener(new tolakCalonAslabBasda());
            v_MenuDaftarCalonAslabBasdaLoginKalab.tblTerimaCalonAslabBasdaClicked().addActionListener(new terimaCalonAslabBasda());
            v_MenuDaftarCalonAslabBasdaLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarCalonAslabBasdaLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class detailCalonAslabBasda implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarCalonAslabBasdaLoginKalab.setTabel(m_kalabBasda.getTableDetailDaftarCalonAslab());
        }
    }

    private class tolakCalonAslabBasda implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            m_kalabBasda.tolak(v_MenuDaftarCalonAslabBasdaLoginKalab.getID());
        }
    }

    private class terimaCalonAslabBasda implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_kalabBasda.terima(v_MenuDaftarCalonAslabBasdaLoginKalab.getID(), m_kalabBasda.queryTerima(v_MenuDaftarCalonAslabBasdaLoginKalab.getID()));
            } catch (SQLException ex) {
                v_MenuDaftarCalonAslabBasdaLoginKalab.pesan("gagal terima");
            }
        }
    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_kalabBasda(usr);
            v_MenuDaftarCalonAslabBasdaLoginKalab.dispose();
        }
    }
}
