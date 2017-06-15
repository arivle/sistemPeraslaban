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
import model.m_calonPemro;
import model.m_login;
import view.v_inputNilaiPemro;

import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_nilaiPemro {

    private m_aslabPemro m_aslabPemro;
    private m_calonPemro m_calonPemro;
    private v_inputNilaiPemro v_inputNilaiPemro;
    private v_login v_login;
    private m_login m_login;
    private String usr;

    public c_nilaiPemro(String usr) {
        this.v_inputNilaiPemro = new v_inputNilaiPemro();
        v_inputNilaiPemro.setLocationRelativeTo(null);
        try {
            m_login = new m_login();
            v_inputNilaiPemro.setVisible(true);
            if (m_login.jabatanAslab(usr)) {
                m_aslabPemro = new m_aslabPemro();
            } else if (m_login.jabatanCalon(usr)) {
                m_calonPemro = new m_calonPemro();
            }
            v_inputNilaiPemro.tblInput().addActionListener(new klikInput());
        } catch (SQLException ex) {
            v_inputNilaiPemro.pesan("koneksi ke database gagal");
        }
    }

    private class klikInput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (v_login.getPeran() == "Asisten Laboratorium") {
                try {
                    m_aslabPemro = new m_aslabPemro(m_login.getIDCalon(v_login.getUsername()),
                            v_inputNilaiPemro.getNilaiAlgo(), v_inputNilaiPemro.getNilaiAlgoII(), v_inputNilaiPemro.getNilaiPBO(), v_inputNilaiPemro.getNilaiPBOII(), v_inputNilaiPemro.getNilaiPemgraf(), v_inputNilaiPemro.getNilaiWeb());
                    m_aslabPemro.inputNilaiAslab();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiPemro.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    m_calonPemro = new m_calonPemro(m_login.getIDCalon(v_login.getUsername()),
                            v_inputNilaiPemro.getNilaiAlgo(), v_inputNilaiPemro.getNilaiAlgoII(), v_inputNilaiPemro.getNilaiPBO(), v_inputNilaiPemro.getNilaiPBOII(), v_inputNilaiPemro.getNilaiPemgraf(), v_inputNilaiPemro.getNilaiWeb());
                    m_calonPemro.inputNilaiCalon();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiPemro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
