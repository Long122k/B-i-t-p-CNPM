/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import java.util.List;
import model.ChildModel;
import models.GiftModel;

/**
 *
 * @author LONG
 */
public class ChildBean {
    private ChildModel childModel;
    private GiftModel giftModel;
    private List<ChildModel> listChildModel;
    
    public ChildBean() {
        this.childModel = childModel;
        this.giftModel = giftModel;
        this.listChildModel = new ArrayList<>();
    }
    
    public ChildBean(ChildModel childModel, GiftModel giftModel, List<ChildModel> listChildModel) {
        this.childModel = childModel;
        this.giftModel = giftModel;
        this.listChildModel = listChildModel;
    }

    public ChildModel getChildModel() {
        return childModel;
    }

    public GiftModel getGiftModel() {
        return giftModel;
    }

    public List<ChildModel> getListChildModel() {
        return listChildModel;
    }
    
    public void setChildModel(ChildModel childModel) {
        this.childModel = childModel;
    }

    public void setGiftModel(GiftModel giftModel) {
        this.giftModel = giftModel;
    }

    public void setListChildModel(List<ChildModel> listChildModel) {
        this.listChildModel = listChildModel;
    }

//    @Override
//    public String toString() {
//        String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, "
//                + "td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
//                + "<h3>Thông tin cơ bản"
//                + "<p>Mã hộ khẩu: <b>" + childModel.getTenTre() + "</p>"
//                + "<p>Họ tên chủ hộ: <b>" + chuHo.getHoTen() + "</p>"
//                + "<p>Địa chỉ: <b>" + hoKhauModel.getDiaChi() + "</p>"
//                + "<p>Ngày lập: <b>" + hoKhauModel.getNgayLap().toString() + "</p>"
//                + "<h4>Danh sách thành viên<table>"
//                + "<tr>"
//                + "<th>Họ tên</th>"
//                + "<th>Ngày sinh</th>"
//                + "<th>Giới tính</th>"
//                + "<th>Quan hệ với chủ hộ</th>"
//                + "</tr>";
//        for (int i = 0; i < listNhanKhauModels.size(); i++) {
//            res += "<tr>"
//                    + "<td>"
//                    + listNhanKhauModels.get(i).getHoTen()
//                    + "</td>"
//                    + "<td>"
//                    + listNhanKhauModels.get(i).getNamSinh().toString()
//                    + "</td>"
//                    + "<td>"
//                    + listNhanKhauModels.get(i).getGioiTinh()
//                    + "</td>"
//                    + "<td>"
//                    + listThanhVienCuaHo.get(i).getQuanHeVoiChuHo()
//                    + "</td>"
//                    + "</tr>";
//        }
//        res += "</table></div></html>";
//        return res;
//    }
//}
}
