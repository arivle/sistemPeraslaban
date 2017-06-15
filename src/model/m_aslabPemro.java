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
public class m_aslabPemro extends m_Aslab {

    private koneksiDatabase conDatabase;
    private int id;
    private String nilaiAlgo;
    private String nilaiAlgo2;
    private String nilaiPBO;
    private String nilaiPBO2;
    private String nilaiPemgraf;
    private String nilaiweb;

    public m_aslabPemro(int id, String nilaiAlgo, String nilaiAlgo2, String nilaiPBO, String nilaiPBO2, String nilaiPemgraf, String nilaiweb) throws SQLException {
        super();
        this.id = id;
        this.nilaiAlgo = nilaiAlgo;
        this.nilaiAlgo2 = nilaiAlgo2;
        this.nilaiPBO = nilaiPBO;
        this.nilaiPBO2 = nilaiPBO2;
        this.nilaiPemgraf = nilaiPemgraf;
        this.nilaiweb = nilaiweb;
        this.conDatabase = new koneksiDatabase();
    }

    public m_aslabPemro() throws SQLException {
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
        String query = "UPDATE `labPemro` set `Algo1` = '" + nilaiAlgo + "',`Algo2` = '" + nilaiAlgo2 + "',`PBO1` = '" + nilaiPBO + "',`PBO2` = '" + nilaiPBO2 + "',`Pemgraf` = '" + nilaiPemgraf + "',`Web` = '" + nilaiweb + "' where `idCalon` = " + id;
        try {
            conDatabase.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
