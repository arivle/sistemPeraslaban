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
public class m_aslabBasda extends m_Aslab {

    private koneksiDatabase conDatabase;
    private int id;
    private String nilaiSBD;
    private String nilaiSQL;

    public m_aslabBasda(int id, String nilaiSBD, String nilaiSQL) throws SQLException {
        super();
        this.nilaiSBD = nilaiSBD;
        this.nilaiSQL = nilaiSQL;
        conDatabase = new koneksiDatabase();
    }

    public m_aslabBasda() throws SQLException {
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
        String query = "UPDATE `labBasda` set `SBD` = '" + nilaiSBD + "',`SQL` = '" + nilaiSQL + "' where `idCalon` = " + id;
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
