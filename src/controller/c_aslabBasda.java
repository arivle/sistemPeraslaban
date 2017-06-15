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
import model.m_Aslab;
import model.m_aslabBasda;
import view.v_homeBasdaLoginAslab;

/**
 *
 * @author dallasarivle
 */
public class c_aslabBasda {

    private v_homeBasdaLoginAslab v_homeBasdaLoginAslab;
    private m_aslabBasda m_aslabBasda;
    private m_Aslab m_Aslab;
    private String usr;

    public c_aslabBasda(String usr) {
        this.usr = usr;
        v_homeBasdaLoginAslab = new v_homeBasdaLoginAslab();
        v_homeBasdaLoginAslab.setLocationRelativeTo(null);
        try {
            v_homeBasdaLoginAslab.setVisible(true);
            m_aslabBasda = new m_aslabBasda();
            v_homeBasdaLoginAslab.lblNama().setText(m_aslabBasda.getUser(usr));
            v_homeBasdaLoginAslab.inputNilai().addActionListener(new menuInputNilai());
        } catch (SQLException ex) {
            v_homeBasdaLoginAslab.pesan("koneksi ke database gagal");
            System.exit(0);
        }

    }


    private class menuInputNilai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           v_homeBasdaLoginAslab.dispose();
           new c_nilaiBasda(usr);
        }
    }
}
