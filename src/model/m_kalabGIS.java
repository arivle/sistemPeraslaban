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
public class m_kalabGIS extends m_Kalab {

    private koneksiDatabase conDatabase;

    public m_kalabGIS() throws SQLException {
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
        String judulKolom[] = {"id Calon", "nama calon", "NIM", "alamat", "tahun Lahir", "tahun Daftar"};
        DefaultTableModel modelTabel = new DefaultTableModel(null, judulKolom);
        try {
            String query = "select idCalon, idLogin, namaCalon, NIM, alamat, thnLahir, idLab, tahunDaftar"
                    + " from calonPendaftar where idLab = 4";
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
        String judulKolom[] = {"id Calon", "nama Calon", "NIM", "nilai multimedia", "nilai jarkom", "nilai AI"};
        DefaultTableModel modelTabel = new DefaultTableModel(null, judulKolom);
        try {
            String query = "select c.idCalon, c.namaCalon, c.NIM, g.nilai_multimedia, g.nilai_jarkom, g.nilai_AI"
                    + "from calonPendaftar as c join labGIS as g on g.idCalon = c.idCalon where c.idLab = 4";
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
                    + "from aslab as a join calonPendaftar as c on a.idCalon = c.idCalon where c.idLab = 4";
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
        String judulKolom[] = {"id Aslab", "nama Aslab", "NIM", "nilai multimedia", "nilai jarkom", "nilai AI"};
        DefaultTableModel modelTabel = new DefaultTableModel(null, judulKolom);
        try {
            String query = "select a.idAslab, c.namaCalon, c.NIM, g.nilai_multimedia, g.nilai_jarkom, g.nilai_AI"
                    + "from aslab as a join calonPendaftar as c on a.idCalon = c.idCalon join labGIS as g on g.idCalon = c.idCalon where c.idLab = 4";
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
