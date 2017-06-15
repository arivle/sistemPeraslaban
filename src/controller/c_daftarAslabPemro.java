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
import view.v_MenuDaftarAslabPemroLoginKalab;
import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_daftarAslabPemro {
    
    private v_MenuDaftarAslabPemroLoginKalab v_MenuDaftarAslabPemroLoginKalab;
private m_kalabPemro m_kalabPemro;
    private v_login v_login;
    private String usr;

    
    public c_daftarAslabPemro(String usr) {
        this.usr = usr;
        v_MenuDaftarAslabPemroLoginKalab = new v_MenuDaftarAslabPemroLoginKalab();
        v_MenuDaftarAslabPemroLoginKalab.setLocationRelativeTo(null);
        v_MenuDaftarAslabPemroLoginKalab.setVisible(true);
        try {
            m_kalabPemro= new m_kalabPemro();
            v_MenuDaftarAslabPemroLoginKalab.setTabel(m_kalabPemro.getTableDaftarAslab());
            v_MenuDaftarAslabPemroLoginKalab.tblDetailAslabPemroClicked().addActionListener(new detailAslabPemro());
            v_MenuDaftarAslabPemroLoginKalab.tblDeleteAslabPemroClicked().addActionListener(new deleteAslabPemro());
            v_MenuDaftarAslabPemroLoginKalab.tblKembaliClicked().addActionListener(new kembali());
        } catch (SQLException ex) {
            ex.getStackTrace();
            v_MenuDaftarAslabPemroLoginKalab.pesan("Koneksi ke database gagal");
            System.exit(0);
        }
    }
    
    private class detailAslabPemro implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            v_MenuDaftarAslabPemroLoginKalab.setTabel(m_kalabPemro.getTableDetailDaftarAslab());
        }
    }
    
    private class deleteAslabPemro implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        new c_deleteAslab(usr);    
        }
    }
    
    private class kembali implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new c_kalabPemro(usr);
            v_MenuDaftarAslabPemroLoginKalab.dispose();
        }
    }
}
