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
public class m_calonRPL extends m_Calon {

    private koneksiDatabase conDatabase;
    private int id;
    private String nilaiPRPL;
    private String nilaiOOD;
    private String nilaiAPS;

    public m_calonRPL(int id, String nilaiPRPL, String nilaiOOD, String nilaiAPS) throws SQLException {
        super();
        this.id = id;
        this.nilaiAPS = nilaiAPS;
        this.nilaiOOD = nilaiOOD;
        this.nilaiPRPL = nilaiPRPL;
        conDatabase = new koneksiDatabase();
    }

    public m_calonRPL() throws SQLException {
        super();
        conDatabase = new koneksiDatabase();
    }

    public String getUser(String usr) throws SQLException {
        String perintah = "select c.namaCalon from aslab as a join calonPendaftar as c  on a.idCalon =  "
                + "c.idCalon join loginIdentity as l on l.idLogin = a.idLogin where l.username= '" + usr + "'";
        return super.getUser(perintah);
    }

    @Override
    public void inputNilaiCalon() {
        String query = "INSERT INTO labRPL(`idCalon`, `PRPL`, 'OOD', 'APS') VALUES (" + id + ",'"
                + nilaiPRPL + "','" + nilaiOOD + "','" + nilaiAPS + "')";
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
