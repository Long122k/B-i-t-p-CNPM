/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ChildModel;
import services.MysqlConnection;
import java.util.ArrayList;
import services.MysqlConnection;

/**
 *
 * @author Microsoft Windows
 */
public class HomeController {
    
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
    
        
    public int chuaTang(ArrayList<ChildModel> Childlist){
        int s=0;
        for (int i=0; i<Childlist.size();i++){
            if(!Childlist.get(i).isDaNhanQua()){
                s++;
            }
        }
        return s;
    }
    public int daTang(ArrayList<ChildModel> Childlist){
        int s=0;
        for (int i=0; i<Childlist.size();i++){
            if(!Childlist.get(i).isDaNhanQua()){
                s++;
            }
        }
        return s;
    }
    public int chiPhi(ArrayList<ChildModel> Childlist){
        int s=0;
        for (int i=0;i<Childlist.size();i++){
            s=s+Childlist.get(i).getSoLuongQua()*10000;
        }
        return s;
    }
    public int danhSach(ArrayList<ChildModel> Childlist){
        return Childlist.size();
    }
}
