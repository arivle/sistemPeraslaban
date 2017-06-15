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
import view.v_homeBelumLogin;
import view.v_login;

/**
 *
 * @author dallasarivle
 */
public class c_homeBelumLogin {

    private v_homeBelumLogin v_homeBelumLogin;
    private v_login v_login;
    private c_login c_login;
    private m_login m_login;

    public c_homeBelumLogin() {
        v_homeBelumLogin = new v_homeBelumLogin();
        v_homeBelumLogin.setLocationRelativeTo(null);
        v_homeBelumLogin.setVisible(true);
        v_homeBelumLogin.tblLoginClicked().addActionListener(new menuLogin());
        v_homeBelumLogin.tblDaftarClicked().addActionListener(new menuDaftar());
    }

    private class menuLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new c_login(new v_login(), new m_login());
                v_homeBelumLogin.dispose();
//            v_login = new v_login();
//            v_login.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(c_homeBelumLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class menuDaftar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_homeBelumLogin.dispose();
            new c_Pendaftaran();
        }
    }
}
