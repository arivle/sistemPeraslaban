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
import model.m_kalabPemro;
import view.v_MenuDaftarCalonAslabPemroLoginKalab;
import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_daftarCalonAslabPemro {
    
    private v_MenuDaftarCalonAslabPemroLoginKalab v_MenuDaftarCalonAslabPemroLoginKalab;
    private m_kalabPemro m_kalabPemro;
    private v_login v_login;
    private String usr;
    
    public c_daftarCalonAslabPemro(String usr) {
        this.usr = usr;
        v_MenuDaftarCalonAslabPemroLoginKalab = new v_MenuDaftarCalonAslabPemroLoginKalab();
        v_MenuDaftarCalonAslabPemroLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarCalonAslabPemroLoginKalab.setVisible(true);
        try {
            m_kalabPemro= new m_kalabPemro();
            v_MenuDaftarCalonAslabPemroLoginKalab.setTabel(m_kalabPemro.getTableDaftarCalonAslab());
            v_MenuDaftarCalonAslabPemroLoginKalab.tblDetailCalonAslabPemroClicked().addActionListener(new detailCalonAslabPemro());
            v_MenuDaftarCalonAslabPemroLoginKalab.tblTolakCalonAslabPemroClicked().addActionListener(new tolakCalonAslabPemro());
            v_MenuDaftarCalonAslabPemroLoginKalab.tblTerimaCalonAslabPemroClicked().addActionListener(new terimaCalonAslabPemro());
            v_MenuDaftarCalonAslabPemroLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarCalonAslabPemroLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }
    
    private class detailCalonAslabPemro implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarCalonAslabPemroLoginKalab.setTabel(m_kalabPemro.getTableDetailDaftarAslab());
        }
    }
    
    private class tolakCalonAslabPemro implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            m_kalabPemro.tolak(v_MenuDaftarCalonAslabPemroLoginKalab.getID());
        }
    }

    private class terimaCalonAslabPemro implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_kalabPemro.terima(v_MenuDaftarCalonAslabPemroLoginKalab.getID(), m_kalabPemro.queryTerima(v_MenuDaftarCalonAslabPemroLoginKalab.getID()));
            } catch (SQLException ex) {
                v_MenuDaftarCalonAslabPemroLoginKalab.pesan("gagal terima");
            }
        }
    }
    
    private class kembali implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new c_kalabPemro(usr);
            v_MenuDaftarCalonAslabPemroLoginKalab.dispose();
        }
    }
}
