package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDatabase.ConnectDatabase;
import entity.ChiTietHoaDon;

public class ChiTietHoaDonDAO {
	private Connection con;

	public ChiTietHoaDonDAO() {
		try {
			con = ConnectDatabase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getBillDetailByBillID(String maHD) throws SQLException {
		ArrayList<String> cthds = new ArrayList<>();
		
		String query = "select kh.hoTenKH, kh.maKhachHang, kh.diaChiKH, kh.soDienThoaiKH, lk.maLinhKien, lk.tenLinhKien,"
				+ "lk.loaiLinhKien, lk.thuongHieu, lk.soLuongTon, lk.donGia from ChiTietHoaDon cthd "
				+ "join HoaDon hd on hd.maHoaDon = cthd.maHoaDon "
				+ "join LinhKien lk on lk.maLinhKien = cthd.maLinhKien "
				+ "join KhachHang kh on hd.maKhachHang = kh.maKhachHang "
				+ "where hd.maHoaDon = ?";
		
		PreparedStatement pState = con.prepareStatement(query);
		pState.setString(1, maHD);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next())
			cthds.add(res.getString(1) + ";" + res.getString(2) + ";" + res.getString(3)
			 + ";" + res.getString(4) + ";" + res.getString(5) + ";" + res.getString(6)
			 + ";" + res.getString(7) + ";" + res.getString(8) + ";" + res.getString(9)
			 + ";" + res.getString(10));
		
		return cthds;
	}

	public boolean addNewBillDetail(ChiTietHoaDon cthd) throws SQLException { 
		String query = "insert ChiTietHoaDon values(?, ?, ?)";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, cthd.getMaHoaDon().getMaHoaDon());
		pState.setString(2, cthd.getMaLinhKien().getMaLK());
		pState.setInt(3, cthd.getSoLuong());
		
		return pState.executeUpdate() > 0;
	}
}