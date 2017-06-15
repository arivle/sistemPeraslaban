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
import model.m_kalabBasda;
import model.m_kalabGIS;
import model.m_kalabPemro;
import model.m_kalabRPL;
import model.m_login;
import view.v_deleteAsdos;

/**
 *
 * @author dallasarivle
 */
public class c_deleteAslab {

    private v_deleteAsdos v_deleteAsdos;
    private m_kalabPemro m_kalabPemro;
    private m_kalabBasda m_kalabBasda;
    private m_kalabRPL m_kalabRPL;
    private m_kalabGIS m_kalabGIS;
    private m_login m_login;
    private String usr;

    public c_deleteAslab(String usr) {
        this.usr = usr;
        v_deleteAsdos = new v_deleteAsdos();
        v_deleteAsdos.setLocationRelativeTo(null);
        v_deleteAsdos.setVisible(true);
        try {
            m_login = new m_login();
            if (m_login.labKalab(usr) == "NellyOktaviaAdiwijaya") {
                m_kalabPemro = new m_kalabPemro();
            } else if (m_login.labKalab(usr) == "Windi Eka Yuliaretnani") {
                m_kalabRPL = new m_kalabRPL();
            } else if (m_login.labKalab(usr) == "Muhammad Arief Hidayat") {
                m_kalabBasda = new m_kalabBasda();
            } else if (m_login.labKalab(usr) == "Yanuar Nurdiansyah") {
                m_kalabGIS = new m_kalabGIS();
            } else {
                v_deleteAsdos.pesan("gagal menyambung ke database");
            }

            v_deleteAsdos.tblOk(new klikOk());
        } catch (SQLException ex) {
            v_deleteAsdos.pesan("koneksi ke database gagal");
        }
    }

    private class klikOk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (m_login.labKalab(usr) == "NellyOktaviaAdiwijaya") {
                    m_kalabPemro.delete(v_deleteAsdos.getID());
                    v_deleteAsdos.dispose();
                } else if (m_login.labKalab(usr) == "Windi Eka Yuliaretnani") {
                    m_kalabRPL.delete(v_deleteAsdos.getID());
                    v_deleteAsdos.dispose();
                } else if (m_login.labKalab(usr) == "Muhammad Arief Hidayat") {
                    m_kalabBasda.delete(v_deleteAsdos.getID());
                    v_deleteAsdos.dispose();
                } else if (m_login.labKalab(usr) == "Yanuar Nurdiansyah") {
                    m_kalabGIS.delete(v_deleteAsdos.getID());
                    v_deleteAsdos.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_deleteAslab.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
