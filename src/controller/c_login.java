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
import model.m_login;
import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_login {

    private v_login v_login;
    private m_login m_login;

    public c_login(v_login v_login, m_login m_login) throws SQLException {
        this.v_login = v_login;
        this.m_login = m_login;
        this.v_login.setVisible(true);
        this.v_login.tbl_Loginclicked().addActionListener(new klikLogin());
    }

    private class klikLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (m_login.usernameValid(v_login.getUsername())) {
                    if (m_login.passwordValid(v_login.getUsername(), v_login.getPassword())) {
                        switch (v_login.getPeran()) {
                            case "Asisten Laboratorium":
                                if (m_login.jabatanAslab(v_login.getUsername()) && m_login.jabatanCalon(v_login.getUsername())) {
                                    switch (m_login.labAslab(v_login.getUsername())) {
                                        case "Pemrograman":
                                            new c_aslabPemro(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                        case "Rekayasa Perangkat Lunak":
                                            new c_aslabRPL(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                        case "Basis Data":
                                            new c_aslabBasda(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                        case "GIS":
                                            new c_aslabGIS(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                    }
                                } else {
                                    v_login.message("kamu bukan aslab");
                                }
                                break;
                            case "Kepala Laboratorium":
                                if (m_login.jabatanKalab(v_login.getUsername())) {
                                    switch (m_login.labKalab(v_login.getUsername())) {
                                        case "NellyOktaviaAdiwijaya":
                                           new c_kalabPemro(v_login.getUsername()); 
                                           v_login.dispose();
                                           break;
                                        case "Windi Eka Yuliaretnani":
                                            new c_kalabRPL(v_login.getUsername());
                                           v_login.dispose();
                                            break;
                                        case "Muhammad Arief Hidayat":
                                            new c_kalabBasda(v_login.getUsername());
                                           v_login.dispose();
                                            break;
                                        case "Yanuar Nurdiansyah":
                                            new c_kalabGIS(v_login.getUsername());
                                           v_login.dispose();
                                            break;
                                    }
                                } else {
                                    v_login.message("Anda bukan Kepala Laboratorium");
                                }
                                break;
                            case "Calon Aslab":
                                if (m_login.jabatanCalon(v_login.getUsername())) {
                                    switch (m_login.labCalon(v_login.getUsername())) {
                                        case "Pemrograman":
                                            new c_calonAslabPemro(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                        case "Rekayasa Perangkat Lunak":
                                            new c_calonAslabRPL(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                        case "Basis Data":
                                            new c_calonAslabBasda(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                        case "GIS":
                                            new c_calonAslabGIS(v_login.getUsername());
                                            v_login.dispose();
                                            break;
                                    }
                                } else {
                                    v_login.message("kamu bukan calon aslab");
                                }
                                break;
                        }
                    } else {
                        System.out.println("Password salah");
                    }
                } else {
                    v_login.message("username tidak ada");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                v_login.message("koneksi ke database gagal");
            }
        }
    }
}
