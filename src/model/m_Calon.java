/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dallasarivle
 */
public abstract class m_Calon {

    private koneksiDatabase conDatabase;

    public m_Calon() throws SQLException {
        conDatabase = new koneksiDatabase();
    }

    public boolean usernameExist(String usr) throws SQLException {
        String query = "select idLogin from loginIdentity where username = '" + usr + "'";
        ResultSet hasil = conDatabase.getResult(query);
        if (hasil.next()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean passwordExist(String pass) throws SQLException {
        String query = "select idLogin from loginIdentity where passwd = '" + pass + "'";
        ResultSet hasil = conDatabase.getResult(query);
        if (hasil.next()) {
            return false;
        } else {
            return true;
        }
    }

    public void isiDataLoginCalon(String usr, String pass) {
        String query = "INSERT INTO loginIdentity(`username`, `passwd`) VALUES ('" + usr + "','" + pass + "')";
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIDLoginCalon(String usr) throws SQLException {
        String query = "select idLogin from loginIdentity where username= '" + usr + "'";
        ResultSet hasil = conDatabase.getResult(query);
        int id = 0;
        if (hasil.next()) {
            id = Integer.parseInt(hasil.getString(1));
        }

        return id;

    }

    public void isiDataCalon(int id, String namaCalon, String NIM, String alamat, String thnLahir, int idLab, String tahunDaftar) {
        String query = "INSERT INTO calonPendaftar(`idLogin`, `namaCalon`, 'NIM', 'alamat', 'thnLahir', 'idLab', 'tahunDaftar') VALUES ('" + id + "','" + namaCalon + "','" + NIM + "','" + alamat + "','" + thnLahir + idLab + ",'" + tahunDaftar + "')";
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUser(String query) throws SQLException {
//        String query = "select c.namaCalon from calonPendaftar as c join loginIdentity as l on c.idLogin =  l.idLogin "
//                + "where l.username = '" + usr + "'";
        ResultSet hasil = conDatabase.getResult(query);
        String user = null;
        if (hasil.next()) {
            user = hasil.getString(1).toUpperCase();
        }
        return user;
    }
    
    public abstract void inputNilaiCalon();
}
