package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDatabase.ConnectDatabase;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDonDAO {

	private Connection con;

	public HoaDonDAO() {
		try {
			con = ConnectDatabase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<HoaDon> getBills() throws SQLException {
		ArrayList<HoaDon> bills = new ArrayList<>();
		
		String query = "select * from hoadon";
		
		ResultSet res = con.createStatement().executeQuery(query);
		
		while(res.next()) {
			NhanVien emp = new NhanVien(res.getString(2));
			KhachHang cus = new KhachHang(res.getString(3));
			bills.add(new HoaDon(res.getString(1), emp, cus, res.getDate(4)));
		}
		
		return bills;
	}
	
	public String getLastBillID() {
		String billID = "";
		
		try {
			ResultSet res = con.createStatement().executeQuery("select maHoaDon from HoaDon order by maHoaDon desc");
			
			while(res.next())
				billID = res.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return billID;
	}
	
	public boolean addNewBill(HoaDon hoaDon) throws SQLException {
		String query = "insert HoaDon values(?, ?, ?, ?)";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, hoaDon.getMaHoaDon());
		pState.setString(2, hoaDon.getMaNhanVien().getMaNhanVien());
		pState.setString(3, hoaDon.getMaKhachHang().getMaKH());
		pState.setDate(4, new Date(System.currentTimeMillis()));
		
		return pState.executeUpdate() > 0;
	}
	
	public Double getTotalUnitPriceByDay(int day) throws SQLException {

		String query = "select h.maHoaDon, sum(ct.soLuong*lk.donGia) from HoaDon as h join ChiTietHoaDon as ct"
				+ "	on h.maHoaDon = ct.maHoaDon join LinhKien as lk on lk.maLinhKien = ct.maLinhKien"
				+ "	where day(h.ngayLapHoaDon) = ?" + "	group by h.maHoaDon";

		double totalPrice = 0;

		PreparedStatement pState = con.prepareStatement(query);

		pState.setInt(1, day);

		ResultSet res = pState.executeQuery();

		while (res.next())
			totalPrice += res.getDouble(2);

		return totalPrice;
	}

	public Double getTotalUnitPriceByYear(int year) throws SQLException {

		String query = "select h.maHoaDon, sum(ct.soLuong*lk.donGia) from HoaDon as h join ChiTietHoaDon as ct"
				+ "	on h.maHoaDon = ct.maHoaDon join LinhKien as lk on lk.maLinhKien = ct.maLinhKien"
				+ "	where year(h.ngayLapHoaDon) = ?" + "	group by h.maHoaDon";

		double totalPrice = 0;

		PreparedStatement pState = con.prepareStatement(query);

		pState.setInt(1, year);

		ResultSet res = pState.executeQuery();

		while (res.next())
			totalPrice += res.getDouble(2);

		return totalPrice;
	}

}