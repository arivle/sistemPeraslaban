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
public class m_calonGIS extends m_Calon {

    private koneksiDatabase conDatabase;
    private int id;
    private String nilaiMultimedia;
    private String nilaiJarkom;
    private String nilaiAI;

    public m_calonGIS(int id, String nilaiMultimedia, String nilaiJarkom, String nilaiAI) throws SQLException {
        super();
        this.id = id;
        this.nilaiAI = nilaiAI;
        this.nilaiJarkom = nilaiJarkom;
        this.nilaiMultimedia = nilaiMultimedia;
        conDatabase = new koneksiDatabase();
    }

    public m_calonGIS() throws SQLException {
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
    public void inputNilaiCalon() {
        String query = "INSERT INTO labGIS(`idCalon`, `nilai_multimedia`, 'nilai_jarkom', 'nilai_AI') VALUES (" + id + ",'"
                + nilaiMultimedia + "','" + nilaiJarkom + "','" + nilaiAI + "')";
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
