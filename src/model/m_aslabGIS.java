/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author dallasarivle
 */
public class m_aslabGIS extends m_Aslab {

    private koneksiDatabase conDatabase;
    private int id;
    private String nilaiMultimedia;
    private String nilaiJarkom;
    private String nilaiAI;

    public m_aslabGIS(int id, String nilaiMultimedia, String nilaiJarkom, String nilaiAI) throws SQLException {
        super();
        this.id = id;
        this.nilaiAI = nilaiAI;
        this.nilaiJarkom = nilaiJarkom;
        this.nilaiMultimedia = nilaiMultimedia;
        conDatabase = new koneksiDatabase();
    }

    public m_aslabGIS() throws SQLException {
        super();
        conDatabase = new koneksiDatabase();
    }

    @Override
    public String getUser(String usr) throws SQLException {
        String perintah = "select c.namaCalon from aslab as a join calonPendaftar as c  on a.idCalon =  "
                + "c.idCalon join loginIdentity as l on l.idLogin = a.idLogin where l.username= '" + usr + "'";
        return super.getUser(perintah);
    }

    @Override
    public void inputNilaiAslab() {
        String query = "UPDATE `labGIS` set `nilai_multimedia` = '" + nilaiMultimedia + "',`nilai_jarkom` = '" + nilaiJarkom + "',`nilai_AI` = '" + nilaiAI + "' where `idCalon` = " + id;
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
