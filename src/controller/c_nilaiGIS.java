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
import model.m_aslabGIS;
import model.m_calonGIS;
import model.m_login;
import view.v_inputNilaiGIS;

import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_nilaiGIS {

    private m_calonGIS m_calonGIS;
    private m_aslabGIS m_aslabGIS;
    private v_inputNilaiGIS v_inputNilaiGIS;
    private v_login v_login;
    private m_login m_login;
    private String usr;

    public c_nilaiGIS(String usr) {
        this.usr = usr;
        this.v_inputNilaiGIS = new v_inputNilaiGIS();
        v_inputNilaiGIS.setLocationRelativeTo(null);
        try {
            v_inputNilaiGIS.setVisible(true);
            m_login = new m_login();
            if (m_login.jabatanAslab(usr)) {
                m_aslabGIS = new m_aslabGIS();
            } else if (m_login.jabatanCalon(usr)) {
                m_calonGIS = new m_calonGIS();
            }
            v_inputNilaiGIS.tblInput().addActionListener(new klikInput());
        } catch (SQLException ex) {
            v_inputNilaiGIS.pesan("koneksi ke database gagal");
        }
    }

    private class klikInput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (v_login.getPeran() == "Asisten Laboratorium") {
                try {
                    m_aslabGIS = new m_aslabGIS(m_login.getIDCalon(v_login.getUsername()),
                            v_inputNilaiGIS.getNilaiMulmed(), v_inputNilaiGIS.getNilaiJarkom(), v_inputNilaiGIS.getNilaiAI());

                    m_aslabGIS.inputNilaiAslab();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiGIS.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (v_login.getPeran() == "Calon Aslab") {
                try {
                    m_calonGIS = new m_calonGIS(m_login.getIDCalon(v_login.getUsername()),
                            v_inputNilaiGIS.getNilaiMulmed(), v_inputNilaiGIS.getNilaiJarkom(), v_inputNilaiGIS.getNilaiAI());
                    m_calonGIS.inputNilaiCalon();
                } catch (SQLException ex) {
                    Logger.getLogger(c_nilaiGIS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
