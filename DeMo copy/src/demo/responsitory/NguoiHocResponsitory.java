/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.responsitory;

import demo.model.NguoiHoc;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tt
 */
public class NguoiHocResponsitory {

    public ArrayList<NguoiHoc> getAll() {
        ArrayList<NguoiHoc> lstNguoiHoc = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            String sql = "select MaNH,HoTen,GioiTinh,NgaySinh from NguoiHoc";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc();
                nh.setMaNH(rs.getString("MaNH"));
                nh.setHoTen(rs.getString("HoTen"));
                nh.setGioiTinh(rs.getBoolean("GioiTinh"));
                nh.setNgaySinh(rs.getString("NgaySinh"));
                lstNguoiHoc.add(nh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiHocResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstNguoiHoc;
    }

    public Integer addNguoiHoc(NguoiHoc nh) {
        Integer row = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "insert into NguoiHoc(MaNH,HoTen,GioiTinh,NgaySinh)\n"
                    + "values(?,?,?,?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, nh.getMaNH());
            prsm.setString(2, nh.getHoTen());
            prsm.setBoolean(3, nh.isGioiTinh());
            prsm.setString(4, nh.getNgaySinh());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiHocResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return row;
    }

    public ArrayList<NguoiHoc> timKiem(String hoten) {

        ArrayList<NguoiHoc> lstKhoaHoc = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "select MaNH,HoTen,GioiTinh,NgaySinh from NguoiHoc \n"
                    + "where HoTen like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, "%" + hoten + "%");
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc();
                nh.setMaNH(rs.getString("MaNH"));
                nh.setHoTen(rs.getString("HoTen"));
                nh.setGioiTinh(rs.getBoolean("GioiTinh"));
                nh.setNgaySinh(rs.getString("NgaySinh"));
                lstKhoaHoc.add(nh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiHocResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstKhoaHoc;
    }
}
