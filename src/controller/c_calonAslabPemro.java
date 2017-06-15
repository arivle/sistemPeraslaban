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
import model.m_calonPemro;
import view.v_homePemroLoginCalon;

/**
 *
 * @author dallasarivle
 */
public class c_calonAslabPemro {

    private v_homePemroLoginCalon v_homePemroLoginCalon;
    private m_calonPemro m_calonPemro;
    private String usr;

//    public c_homePemroLoginCalon(v_homePemroLoginCalon v_homePemroLoginCalon, m_homeCalonAslab m_homeCalonAslab, String usr) {
//        this.v_homePemroLoginCalon = v_homePemroLoginCalon;
//        this.m_homeCalonAslab = m_homeCalonAslab;
//        this.usr = usr;
//        v_homePemroLoginCalon.statusDaftar().addActionListener(new menuStatusDaftar());
//    }
    public c_calonAslabPemro(String usr) {
        this.usr = usr;
        v_homePemroLoginCalon = new v_homePemroLoginCalon();
        v_homePemroLoginCalon.setLocationRelativeTo(null);
        try {
            m_calonPemro = new m_calonPemro();
            v_homePemroLoginCalon.setVisible(true);
            v_homePemroLoginCalon.lblNama().setText(m_calonPemro.getUser(usr));
        } catch (SQLException ex) {
            v_homePemroLoginCalon.pesan("koneksi database gagal");
            System.exit(0);
        }
    }

    private class menuStatusDaftar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_homePemroLoginCalon.dispose();
        }
    }
}
