/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class koneksiDatabase {

    Connection con;
    Statement stm;

    public koneksiDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/aslab";
        String username = "root";
        String pass = "null";

        this.con = (Connection) DriverManager.getConnection(url, username, pass);
        this.stm = (Statement) this.con.createStatement();
    }

    public void executeQuery(String query) throws SQLException {
        this.stm.execute(query);
    }

    public ResultSet getResult(String query) throws SQLException {
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
}
