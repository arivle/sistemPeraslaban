/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dallasarivle
 */
public class m_kalabBasda extends m_Kalab {

    private koneksiDatabase conDatabase;

    public m_kalabBasda() throws SQLException {
        super();
        conDatabase = new koneksiDatabase();
    }

    @Override
    public String getUser(String usr) throws SQLException {
        String perintah = "select k.namaKalab from kalab as k join loginIdentity as l on k.idLogin =  l.idLogin "
                + "where l.username =  '" + usr + "'";
        return super.getUser(perintah);
    }

    public DefaultTableModel getTableDaftarCalonAslab() {
        String judulKolom[] = {"id Calon", "nama Calon", "NIM", "alamat", "tahun Lahir", "tahun Daftar"};
        DefaultTableModel modelTabel = new DefaultTableModel(null, judulKolom);
        try {
            String query = "select idCalon, idLogin, namaCalon, NIM, alamat, thnLahir, idLab, tahunDaftar"
                    + " from calonPendaftar where idLab = 3";
            ResultSet hasil = conDatabase.getResult(query);
            while (hasil.next()) {
                String kolom[] = new String[judulKolom.length];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = hasil.getString(i + 1);
                }
                modelTabel.addRow(kolom);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return modelTabel;
    }

    public DefaultTableModel getTableDetailDaftarCalonAslab() {
        String judulKolom[] = {"id Calon", "nama Aslab", "NIM", "nilai SBD", "nilai SQL"};
        DefaultTableModel modelTabel = new DefaultTableModel(null, judulKolom);
        try {
            String query = "select c.idCalon, c.namaCalon, c.NIM, b.SBD, b.SQL"
                    + "from calonPendaftar as c join labBasda as b on b.idCalon = c.idCalon where c.idLab = 3";
            ResultSet hasil = conDatabase.getResult(query);
            while (hasil.next()) {
                String kolom[] = new String[judulKolom.length];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = hasil.getString(i + 1);
                }
                modelTabel.addRow(kolom);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return modelTabel;
    }

    public DefaultTableModel getTableDaftarAslab() {
        String judulKolom[] = {"id Aslab", "nama Aslab", "NIM", "alamat", "tahun Lahir", "tahun Daftar"};
        DefaultTableModel modelTabel = new DefaultTableModel(null, judulKolom);
        try {
            String query = "select a.idAslab, c.namaCalon, c.NIM, c.alamat, c.tahunLahir, c.tahunDaftar "
                    + "from aslab as a join calonPendaftar as c on a.idCalon = c.idCalon where c.idLab = 3";
            ResultSet hasil = conDatabase.getResult(query);
            while (hasil.next()) {
                String kolom[] = new String[judulKolom.length];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = hasil.getString(i + 1);
                }
                modelTabel.addRow(kolom);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return modelTabel;
    }

    public DefaultTableModel getTableDetailDaftarAslab() {
        String judulKolom[] = {"id Aslab", "nama Aslab", "NIM", "nilai SBD", "nilai SQL"};
        DefaultTableModel modelTabel = new DefaultTableModel(null, judulKolom);
        try {
            String query = "select a.idAslab, c.namaCalon, c.NIM, b.SBD, b.SQL"
                    + "from aslab as a join calonPendaftar as c on a.idCalon = c.idCalon join labBasda as b on b.idCalon = c.idCalon where c.idLab = 3";
            ResultSet hasil = conDatabase.getResult(query);
            while (hasil.next()) {
                String kolom[] = new String[judulKolom.length];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = hasil.getString(i + 1);
                }
                modelTabel.addRow(kolom);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return modelTabel;
    }
}
