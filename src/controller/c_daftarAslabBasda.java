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

import view.v_MenuDaftarAslabBasdaLoginKalab;
import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_daftarAslabBasda {
    
    private v_MenuDaftarAslabBasdaLoginKalab v_MenuDaftarAslabBasdaLoginKalab;
private m_kalabBasda m_kalabBasda;
    private v_login v_login;
    private String usr;

    
    public c_daftarAslabBasda(String usr) {
       this.usr = usr;
        v_MenuDaftarAslabBasdaLoginKalab = new v_MenuDaftarAslabBasdaLoginKalab();
        v_MenuDaftarAslabBasdaLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarAslabBasdaLoginKalab.setVisible(true);
        try {
            m_kalabBasda = new m_kalabBasda();
            v_MenuDaftarAslabBasdaLoginKalab.setTabel(m_kalabBasda.getTableDaftarAslab());
            v_MenuDaftarAslabBasdaLoginKalab.tblDetailAslabBasdaClicked().addActionListener(new detailAslabBasda());
            v_MenuDaftarAslabBasdaLoginKalab.tblDeleteAslabBasdaClicked().addActionListener(new deleteAslabBasda());
            v_MenuDaftarAslabBasdaLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarAslabBasdaLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }
    
    private class detailAslabBasda implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarAslabBasdaLoginKalab.setTabel(m_kalabBasda.getTableDetailDaftarAslab());
        }
    }
    
    private class deleteAslabBasda implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        new c_deleteAslab(usr);    
        }
    }
    
    private class kembali implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarAslabBasdaLoginKalab.dispose();
            new c_kalabBasda(v_login.getUsername());
        }
    }
}
