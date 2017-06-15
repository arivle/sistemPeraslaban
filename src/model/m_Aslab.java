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
public abstract class m_Aslab {

    private koneksiDatabase conDatabase;

    public m_Aslab() throws SQLException {
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

    public abstract void inputNilaiAslab();
}
