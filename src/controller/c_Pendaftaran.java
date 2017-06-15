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
import model.m_calonBasda;
import model.m_calonGIS;
import model.m_calonPemro;
import model.m_calonRPL;
import view.v_Daftaraslab;

/**
 *
 * @author dallasarivle
 */
public class c_Pendaftaran {

    private m_calonBasda m_calonBasda;
    private m_calonPemro m_calonPemro;
    private m_calonGIS m_calonGIS;
    private m_calonRPL m_calonRPL;
    private v_Daftaraslab v_Daftaraslab;

    public c_Pendaftaran() {
        v_Daftaraslab = new v_Daftaraslab();
        v_Daftaraslab.setLocationRelativeTo(null);
        try {
            m_calonBasda = new m_calonBasda();
            v_Daftaraslab.setVisible(true);
            m_calonPemro = new m_calonPemro();
            m_calonGIS = new m_calonGIS();
            m_calonRPL = new m_calonRPL();
        } catch (SQLException ex) {
            v_Daftaraslab.pesan("koneksi ke database gagal");
            v_Daftaraslab.tblDaftarClicked().addActionListener(new daftar());
        }
    }

    public class daftar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (v_Daftaraslab.getCalonLab() == 1) {
                    if (m_calonPemro.usernameExist(v_Daftaraslab.getUsernamaCalon())) {
                        if (m_calonPemro.passwordExist(v_Daftaraslab.getPasswordCalon())) {
                            m_calonPemro.isiDataLoginCalon(v_Daftaraslab.getUsernamaCalon(), v_Daftaraslab.getPasswordCalon());
                            m_calonPemro.isiDataCalon(m_calonPemro.getIDLoginCalon(v_Daftaraslab.getUsernamaCalon()), v_Daftaraslab.getNamaCalon(), v_Daftaraslab.getNIM(), v_Daftaraslab.getAlamat(), v_Daftaraslab.getTahunLahir(), v_Daftaraslab.getCalonLab(), v_Daftaraslab.getTahunDaftar());
                            new c_nilaiPemro(v_Daftaraslab.getUsernamaCalon());
                            v_Daftaraslab.dispose();
                        }
                    }
                } else if (v_Daftaraslab.getCalonLab() == 2) {
                    if (m_calonRPL.usernameExist(v_Daftaraslab.getUsernamaCalon())) {
                        if (m_calonRPL.passwordExist(v_Daftaraslab.getPasswordCalon())) {
                            m_calonRPL.isiDataLoginCalon(v_Daftaraslab.getUsernamaCalon(), v_Daftaraslab.getPasswordCalon());
                            m_calonRPL.isiDataCalon(m_calonRPL.getIDLoginCalon(v_Daftaraslab.getUsernamaCalon()), v_Daftaraslab.getNamaCalon(), v_Daftaraslab.getNIM(), v_Daftaraslab.getAlamat(), v_Daftaraslab.getTahunLahir(), v_Daftaraslab.getCalonLab(), v_Daftaraslab.getTahunDaftar());
                            new c_nilaiRPL(v_Daftaraslab.getUsernamaCalon());
                            v_Daftaraslab.dispose();
                        }
                    }
                } else if (v_Daftaraslab.getCalonLab() == 3) {
                    if (m_calonBasda.usernameExist(v_Daftaraslab.getUsernamaCalon())) {
                        if (m_calonBasda.passwordExist(v_Daftaraslab.getPasswordCalon())) {
                            m_calonBasda.isiDataLoginCalon(v_Daftaraslab.getUsernamaCalon(), v_Daftaraslab.getPasswordCalon());
                            m_calonBasda.isiDataCalon(m_calonBasda.getIDLoginCalon(v_Daftaraslab.getUsernamaCalon()), v_Daftaraslab.getNamaCalon(), v_Daftaraslab.getNIM(), v_Daftaraslab.getAlamat(), v_Daftaraslab.getTahunLahir(), v_Daftaraslab.getCalonLab(), v_Daftaraslab.getTahunDaftar());
                            new c_nilaiBasda(v_Daftaraslab.getUsernamaCalon());
                            v_Daftaraslab.dispose();
                        }
                    }
                } else if (v_Daftaraslab.getCalonLab() == 4) {
                    if (m_calonGIS.usernameExist(v_Daftaraslab.getUsernamaCalon())) {
                        if (m_calonGIS.passwordExist(v_Daftaraslab.getPasswordCalon())) {
                            m_calonGIS.isiDataLoginCalon(v_Daftaraslab.getUsernamaCalon(), v_Daftaraslab.getPasswordCalon());
                            m_calonGIS.isiDataCalon(m_calonGIS.getIDLoginCalon(v_Daftaraslab.getUsernamaCalon()), v_Daftaraslab.getNamaCalon(), v_Daftaraslab.getNIM(), v_Daftaraslab.getAlamat(), v_Daftaraslab.getTahunLahir(), v_Daftaraslab.getCalonLab(), v_Daftaraslab.getTahunDaftar());
                            new c_nilaiGIS(v_Daftaraslab.getUsernamaCalon());
                            v_Daftaraslab.dispose();
                        }
                    }
                } else {
                    v_Daftaraslab.pesan("username sudah ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_Pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
