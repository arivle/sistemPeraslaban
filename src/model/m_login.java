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
public class m_login extends koneksiDatabase {

//    private koneksiDatabase conDatabase;

    public m_login() throws SQLException {
//        conDatabase = new koneksiDatabase();
    }

    public boolean usernameValid(String usr) throws SQLException {
        String query = "select username from loginIdentity where username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        if (hasil.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean passwordValid(String usr, String pass) throws SQLException {
        String query = "select passwd from loginIdentity where username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        String dbPassword = null;
        if (hasil.next()) {
            dbPassword = hasil.getString(1);
        }
        if (dbPassword.equals(pass)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean jabatanKalab(String usr) throws SQLException {
        String query = "select k.idKalab from loginIdentity as l join kalab as k on l.idLogin = k.idLogin where l.username = '" + usr + "'";
        ResultSet hasil = getResult(query);

        if (hasil.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean jabatanAslab(String usr) throws SQLException {
        String query = "select a.idAslab from loginIdentity as l join aslab as a on l.idLogin = a.idLogin join calonPendaftar as c on a.idCalon = c.idCalon where l.username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        if (hasil.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean jabatanCalon(String usr) throws SQLException {
        String query = "select c.idCalon from loginIdentity as l join calonPendaftar as c on l.idLogin = c.idLogin where l.username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        if (hasil.next()) {
            return true;
        } else {
            return false;
        }
    }

    public int getIDCalon(String usr) throws SQLException {
        String query = "select l.idCalon from calonPendaftar as c join loginIdentity as log on log.idLogin = c.idLogin where log.username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        int idcalon = 0;
        if (hasil.next()) {
            idcalon = Integer.parseInt(hasil.getString(1));
        }
        return idcalon;
    }

    public String labCalon(String usr) throws SQLException {
        String query = "select l.namaLab from calonPendaftar as c join laboratorium as l on c.idLab = l.idLab join loginIdentity as log on log.idLogin = c.idLogin where log.username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        String namaLab = null;
        if (hasil.next()) {
            namaLab = hasil.getString(1);
        }

        return namaLab;

    }

    public String labKalab(String usr) throws SQLException {
        String query = "select k.namaKalab from kalab as k join laboratorium as l on k.idKalab = l.idKalab join loginIdentity as log on log.idLogin = k.idLogin where log.username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        String namaLab = null;
        if (hasil.next()) {
            namaLab = hasil.getString(1);
        }

        return namaLab;
    }

    public String labAslab(String usr) throws SQLException {
        String query = "select l.namaLab from aslab as a join calonPendaftar as c on a.idAslab = c.idCalon join laboratorium as l on l.idLab = c.idLab join loginIdentity as log on log.idLogin = c.idLogin where log.username = '" + usr + "'";
        ResultSet hasil = getResult(query);
        String namaLab = null;
        if (hasil.next()) {
            namaLab = hasil.getString(1);
        }

        return namaLab;
    }
}
