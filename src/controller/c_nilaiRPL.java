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
import model.m_aslabRPL;
import model.m_calonRPL;
import model.m_login;
import view.v_inputNilaiRPL;

import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_nilaiRPL {

    private m_aslabRPL m_aslabRPL;
    private m_calonRPL m_calonRPL;
    private v_inputNilaiRPL v_inputNilaiRPL;
    private v_login v_login;
    private m_login m_login;
    private String usr;

    public c_nilaiRPL(String usr) {
        this.v_inputNilaiRPL = new v_inputNilaiRPL();
        v_inputNilaiRPL.setLocationRelativeTo(null);
        try {
            m_login = new m_login();
            v_inputNilaiRPL.setVisible(true);
            if (m_login.jabatanAslab(usr)) {
                m_aslabRPL = new m_aslabRPL();
            } else if (m_login.jabatanCalon(usr)) {
                m_calonRPL = new m_calonRPL();
            }
            v_inputNilaiRPL.tblInput().addActionListener(new klikInput());
        } catch (SQLException ex) {
            v_inputNilaiRPL.pesan("koneksi ke database gagal");
        }
    }

    private class klikInput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (v_login.getPeran() == "Asisten Laboratorium") {
                try {
                    m_aslabRPL = new m_aslabRPL(m_login.getIDCalon(v_login.getUsername()),
                            v_inputNilaiRPL.getNilaiPRPL(), v_inputNilaiRPL.getNilaiOOD(), v_inputNilaiRPL.getNilaiAPS());
                    m_aslabRPL.inputNilaiAslab();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiRPL.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (v_login.getPeran() == "Calon Aslab") {
                try {
                    m_calonRPL = new m_calonRPL(m_login.getIDCalon(v_login.getUsername()),
                            v_inputNilaiRPL.getNilaiPRPL(), v_inputNilaiRPL.getNilaiOOD(), v_inputNilaiRPL.getNilaiAPS());
                    m_calonRPL.inputNilaiCalon();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiRPL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
