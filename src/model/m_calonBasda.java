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
public class m_calonBasda extends m_Calon {

    private koneksiDatabase conDatabase;
    private int id;
    private String nilaiSBD;
    private String nilaiSQL;

    public m_calonBasda(int id, String nilaiSBD, String nilaiSQL) throws SQLException {
        super();
        this.nilaiSBD = nilaiSBD;
        this.nilaiSQL = nilaiSQL;
        conDatabase = new koneksiDatabase();
    }

    public m_calonBasda() throws SQLException {
        super();
        conDatabase = new koneksiDatabase();
    }

    public String getUser(String usr) throws SQLException {
        String perintah = "select c.namaCalon from calonPendaftar as c join loginIdentity as l on c.idLogin =  l.idLogin "
                + "where l.username = '" + usr + "'";
        return super.getUser(perintah);
    }

    @Override
    public void inputNilaiCalon() {
        String query = "INSERT INTO labBasda(`idCalon`, `SBD`, 'SQL') VALUES (" + id + ",'"
                + nilaiSBD + "','" + nilaiSQL + "')";
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
