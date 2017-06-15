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
import model.m_kalabPemro;
import view.v_homePemroLoginKalab;

/**
 *
 * @author dallasarivle
 */
public class c_kalabPemro {

    private v_homePemroLoginKalab v_homePemroLoginKalab;
    private m_kalabPemro m_kalabPemro;
    private String usr;

    public c_kalabPemro(String usr) {
        this.usr = usr;
        v_homePemroLoginKalab = new v_homePemroLoginKalab();
        v_homePemroLoginKalab.setLocationRelativeTo(null);
        try {
            m_kalabPemro = new m_kalabPemro();
            v_homePemroLoginKalab.setVisible(true);
            v_homePemroLoginKalab.lblNama().setText(m_kalabPemro.getUser(usr));
            v_homePemroLoginKalab.ListAslab().addActionListener(new menuListAslab());
            v_homePemroLoginKalab.ListCalonAslab().addActionListener(new menuListCalonAslab());
        } catch (SQLException ex) {
            v_homePemroLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }

    private class menuListAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarAslabPemro(usr);
            v_homePemroLoginKalab.dispose();
        }
    }

    private class menuListCalonAslab implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new c_daftarCalonAslabPemro(usr);
            v_homePemroLoginKalab.dispose();
        }
    }

}
