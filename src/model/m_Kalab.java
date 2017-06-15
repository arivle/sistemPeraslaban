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
public class m_Kalab {

    private koneksiDatabase conDatabase;

    public m_Kalab() throws SQLException {
        conDatabase = new koneksiDatabase();
    }

    public String getUser(String query) throws SQLException {
        ResultSet hasil = conDatabase.getResult(query);
        String user = null;
        if (hasil.next()) {
            user = hasil.getString(1).toUpperCase();
        }
        return user;
    }

    public String queryTerima(int id) throws SQLException {
        String query = "select tahunDaftar from calonPendaftar where idCalon = " + id;
        ResultSet hasil = conDatabase.getResult(query);
        String terima = null;
        if (hasil.next()) {
            terima = hasil.getString(1);
        }

        return terima;
    }

    public void delete(int id) {
        try {
            String query = "DELETE from aslab where idAslab = " + id;
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void terima(int id, String tahunDaftar) {
        String query = "INSERT INTO aslab(`idCalon`, `tahunDaftar`) VALUES (" + id + ",'" + tahunDaftar + "')";
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tolak(int id) {
        try {
            String query = "DELETE from calonPendaftar where `idCalon` = " + id;
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
