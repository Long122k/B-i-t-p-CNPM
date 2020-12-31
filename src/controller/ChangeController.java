/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.KiemTraQua;
import Service.XoaBang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.ChildModel;
import services.MysqlConnection;

/**
 *
 * @author Microsoft Windows
 */
public class ChangeController {
    KiemTraQua ktq;
    XoaBang xb;
    public ArrayList<ChildModel> getList() throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM child" ;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            ArrayList<ChildModel> list = new ArrayList<>();
            while (rs.next()){
			ChildModel child = new ChildModel();
			child.setID(rs.getInt("ID"));
			child.setTenTre(rs.getString("tenTre"));
			child.setNgaySinh(rs.getDate("ngaySinh"));
			child.setTenChuHo(rs.getString("tenChuHo"));
			child.setLop(rs.getString("lop"));
			child.setTruong(rs.getString("truong"));
			child.setThanhTich(rs.getString("thanhTich"));
			child.setGioiTinh(rs.getString("gioiTinh"));
			child.setDiaChi(rs.getString("diaChi"));
			if(rs.getString("daNhanQua").equals("đã nhận")){
                            child.setDaNhanQua(true);
                            
                        } else{
                            child.setDaNhanQua(false);                        
                        }
			child.setNgayNhanQua(rs.getDate("ngayNhanQua"));
			child.setLoaiQua(rs.getString("loaiQua"));
			child.setSoLuongQua(rs.getInt("soLuongQua"));
			list.add(child);
            }
        return list;
    }
    public boolean changeChild(int ID,ChildModel t) throws SQLException, ClassNotFoundException{
         String query = "DELETE FROM child WHERE ID = " + ID;
      try {
                Connection connection = MysqlConnection.getMysqlConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                int rs = preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
      try (Connection connection = MysqlConnection.getMysqlConnection()) {
            String query1 = "INSERT INTO child (ID, tenTre, ngaySinh, tenChuHo, lop, truong, thanhTich, gioiTinh, diaChi, daNhanQua, ngayNhanQua, loaiQUa, soLuongQua)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query1)) {
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
    int i=1;
    public void CreatAll(ArrayList<ChildModel> list,DefaultTableModel model){
        xb = new XoaBang();
        xb.clear(model);
        list.forEach(t -> {
            ktq = new KiemTraQua();
            model.addRow(new Object[]{i++,t.getID(),t.getTenTre(),t.getNgaySinh(),t.getGioiTinh(),t.getTenChuHo(),t.getDiaChi(),t.getTruong(),t.getLop(),t.getThanhTich(),ktq.giftcheck(t.isDaNhanQua())});
        });
    }
}
