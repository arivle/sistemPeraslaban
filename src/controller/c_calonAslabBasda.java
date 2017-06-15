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
import view.v_homeBasdaLoginCalon;

/**
 *
 * @author dallasarivle
 */
public class c_calonAslabBasda {
    
    private v_homeBasdaLoginCalon v_homeBasdaLoginCalon;
    private m_calonBasda m_calonBasda;
    private String usr;
    
    public c_calonAslabBasda(String usr) {
        this.usr = usr;
        v_homeBasdaLoginCalon = new v_homeBasdaLoginCalon();
        v_homeBasdaLoginCalon.setLocationRelativeTo(null);
        try {
            m_calonBasda = new m_calonBasda();
            v_homeBasdaLoginCalon.setVisible(true);
            v_homeBasdaLoginCalon.lblNama().setText(m_calonBasda.getUser(usr));
        } catch (SQLException ex) {
            v_homeBasdaLoginCalon.pesan("koneksi database gagal");
            System.exit(0);
        }
    }
    
    private class menuStatusDaftar implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        v_homeBasdaLoginCalon.dispose();   
        }
    }
}
