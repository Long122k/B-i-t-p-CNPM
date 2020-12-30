/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.KiemTraQua;
import Service.XoaBang;
import java.sql.Connection;
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
    public boolean changeChild(ChildModel t){
        
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
