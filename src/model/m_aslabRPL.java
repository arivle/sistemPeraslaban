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
public class m_aslabRPL extends m_Aslab {

    private koneksiDatabase conDatabase;
    private int id;
    private String nilaiPRPL;
    private String nilaiOOD;
    private String nilaiAPS;

    public m_aslabRPL(int id, String nilaiPRPL, String nilaiOOD, String nilaiAPS) throws SQLException {
        super();
        this.id = id;
        this.nilaiAPS = nilaiAPS;
        this.nilaiOOD = nilaiOOD;
        this.nilaiPRPL = nilaiPRPL;
        conDatabase = new koneksiDatabase();
    }

    public m_aslabRPL() throws SQLException {
        super();
        conDatabase = new koneksiDatabase();
    }

    public String getUser(String usr) throws SQLException {
        String perintah = "select c.namaCalon from aslab as a join calonPendaftar as c  on a.idCalon =  "
                + "c.idCalon join loginIdentity as l on l.idLogin = a.idLogin where l.username= '" + usr + "'";
        return super.getUser(perintah);
    }

    @Override
    public void inputNilaiAslab() {
        String query = "UPDATE `labRPL` set `PRPL` = '" + nilaiPRPL + "',`OOD` = '" + nilaiOOD + "',`APS` = '" + nilaiAPS + "' where `idCalon` = " + id;
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
