/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.KiemTraQua;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.ChildModel;
import services.MysqlConnection;
/**
 *
 * @author Microsoft Windows
 */
public class AddController {
    public boolean addChild(ChildModel t) throws SQLException, ClassNotFoundException{
        try (Connection connection = MysqlConnection.getMysqlConnection()) {
            String query = "INSERT INTO child (ID, tenTre, ngaySinh, tenChuHo, lop, truong, thanhTich, gioiTinh, diaChi, daNhanQua, ngayNhanQua, loaiQUa, soLuongQua)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, t.getID());
                preparedStatement.setString(2, t.getTenTre());
                
                preparedStatement.setDate(3, new Date( t.getNgaySinh().getTime()));
                preparedStatement.setString(4, t.getTenChuHo());
                preparedStatement.setString(5, t.getLop());
                preparedStatement.setString(6, t.getTruong());
                preparedStatement.setString(7, t.getThanhTich());
                preparedStatement.setString(8, t.getGioiTinh());
                preparedStatement.setString(9, t.getDiaChi());
                
                String kt = new KiemTraQua().giftcheck(t.isDaNhanQua());
                preparedStatement.setString(10, kt);
                preparedStatement.setDate(11, new Date( t.getNgayNhanQua().getTime()));
                preparedStatement.setString(12, t.getLoaiQua());
                preparedStatement.setInt(13, t.getSoLuongQua());
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
            }
        }
    return true;
    }
}
