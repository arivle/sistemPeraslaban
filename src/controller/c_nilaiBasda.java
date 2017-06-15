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
import model.m_aslabBasda;
import model.m_calonBasda;
import model.m_login;
import view.v_inputNilaiBasda;
import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_nilaiBasda {

    private m_calonBasda m_calonBasda;
    private m_aslabBasda m_aslabBasda;
    private v_inputNilaiBasda v_inputNilaiBasda;
    private v_login v_login;
    private m_login m_login;
    private String usr;

    public c_nilaiBasda(String usr) {
        this.v_inputNilaiBasda = new v_inputNilaiBasda();
        v_inputNilaiBasda.setLocationRelativeTo(null);
        try {
            v_inputNilaiBasda.setVisible(true);
            m_login = new m_login();
            if (m_login.jabatanAslab(usr)) {
                m_aslabBasda = new m_aslabBasda();
            } else if (m_login.jabatanCalon(usr)) {
                m_calonBasda = new m_calonBasda();
            }
            v_inputNilaiBasda.tblInput().addActionListener(new klikInput());
        } catch (SQLException ex) {
            v_inputNilaiBasda.pesan("koneksi ke database gagal");
        }
    }

    private class klikInput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (v_login.getPeran() == "Asisten Laboratorium") {
                try {
                    m_aslabBasda = new m_aslabBasda(m_login.getIDCalon(v_login.getUsername()), v_inputNilaiBasda.getNilaiSBD(), v_inputNilaiBasda.getNilaisql());
                    m_aslabBasda.inputNilaiAslab();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiBasda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (v_login.getPeran() == "Calon Aslab") {
                try {
                    m_calonBasda = new m_calonBasda(m_login.getIDCalon(v_login.getUsername()), v_inputNilaiBasda.getNilaiSBD(), v_inputNilaiBasda.getNilaisql());
                    m_calonBasda.inputNilaiCalon();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiBasda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
