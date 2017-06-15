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
import model.m_aslabPemro;
import view.v_homePemroLoginAslab;

/**
 *
 * @author dallasarivle
 */
public class c_aslabPemro {

    private v_homePemroLoginAslab v_homePemroLoginAslab;
    private m_aslabPemro m_aslabPemro;
    private String usr;

    public c_aslabPemro(String usr) {
        this.usr = usr;
        v_homePemroLoginAslab = new v_homePemroLoginAslab();
        v_homePemroLoginAslab.setLocationRelativeTo(null);

        try {
            m_aslabPemro = new m_aslabPemro();
            v_homePemroLoginAslab.setVisible(true);
            v_homePemroLoginAslab.lblNama().setText(m_aslabPemro.getUser(usr));
            v_homePemroLoginAslab.inputNilai().addActionListener(new menuInputNilai());
        } catch (SQLException ex) {
            v_homePemroLoginAslab.pesan("koneksi ke database gagal");
            System.exit(0);
        }

    }


    private class menuInputNilai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_homePemroLoginAslab.dispose();
            new c_nilaiPemro(usr);
        }
    }
}
