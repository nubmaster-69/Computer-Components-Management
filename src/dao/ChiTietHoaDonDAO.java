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
				+ "lk.loaiLinhKien, lk.thuongHieu, cthd.soLuong, lk.donGia from ChiTietHoaDon cthd "
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
	
	public String getProductTop1Selling(String time) throws SQLException {
		String nameSp = "";
		String query ="";
		switch (time.toUpperCase()) {
		case "DAY": {
			query = "select top 1 lk.maLinhKien,tenLinhKien,sum(soLuong) from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where day(ngayLapHoaDon) = day(getdate())\r\n"
					+ "and month(ngayLapHoaDon) = month(getdate())\r\n"
					+ "and year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "group by lk.maLinhKien,tenLinhKien\r\n"
					+ "order by sum(soLuong) desc";
			break;
		}
		case "MONTH": {
			query = "select top 1 lk.maLinhKien,tenLinhKien,sum(soLuong) from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where month(ngayLapHoaDon) = month(getdate())\r\n"
					+ "and year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "group by lk.maLinhKien,tenLinhKien\r\n"
					+ "order by sum(soLuong) desc";
			break;
		}
		case "YEAR": {
			query = "select top 1 lk.maLinhKien,tenLinhKien,sum(soLuong) from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "group by lk.maLinhKien,tenLinhKien\r\n"
					+ "order by sum(soLuong) desc";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + time);
		}
		 
		
		ResultSet res = con.createStatement().executeQuery(query);
		while(res.next()) {
			nameSp = res.getString(2) + "/Đã bán:"+res.getString(3);
		}
		return nameSp;
	}
	
	public double getSumTotal(String time) throws SQLException {
		double SumTotal = 0;
		String query = "";
		switch (time.toUpperCase()) {
		case "DAY": {
			query = "select sum(soLuong * donGia) from HoaDon as h \r\n"
						+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
						+ "join KhachHang as kh on h.maKhachHang = kh.maKhachHang\r\n"
						+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
						+ "where day(ngayLapHoaDon) = day(getdate())\r\n"
						+ "and month(ngayLapHoaDon) = month(getdate())\r\n"
						+ "and year(ngayLapHoaDon) = year(getdate())";
			break;
		}
		case "MONTH": {
			query = "select sum(soLuong * donGia) from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join KhachHang as kh on h.maKhachHang = kh.maKhachHang\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where month(ngayLapHoaDon) = month(getdate())\r\n"
					+ "and year(ngayLapHoaDon) = year(getdate())";
			break;
		}
		case "YEAR": {
			query = "select sum(soLuong * donGia) from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join KhachHang as kh on h.maKhachHang = kh.maKhachHang\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where year(ngayLapHoaDon) = year(getdate())";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + time);
		}
		
		ResultSet res = con.createStatement().executeQuery(query);
		while(res.next()) {
			SumTotal = res.getDouble(1);
		}
		return SumTotal;
	}
	
	public String getCusTop1Buy(String time) throws SQLException {
		String nameCus = "";
		String query = "";
		switch (time.toUpperCase()) {
		case "DAY": {
			query = "select top 1 hoTenKH,soDienThoaiKH from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join KhachHang as kh on h.maKhachHang = kh.maKhachHang\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where day(ngayLapHoaDon) = day(getdate())\r\n"
					+ "and month(ngayLapHoaDon) = month(getdate())\r\n"
					+ "and year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "order by soLuong * donGia desc";
			break;
		}
		case "MONTH": {
			query = "select top 1 hoTenKH,soDienThoaiKH from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join KhachHang as kh on h.maKhachHang = kh.maKhachHang\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where month(ngayLapHoaDon) = month(getdate())\r\n"
					+ "and year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "order by soLuong * donGia desc";
			break;
		}
		case "YEAR": {
			query = "select top 1 hoTenKH,soDienThoaiKH from HoaDon as h \r\n"
					+ "join ChiTietHoaDon as cthd on h.maHoaDon = cthd.maHoaDon\r\n"
					+ "join KhachHang as kh on h.maKhachHang = kh.maKhachHang\r\n"
					+ "join LinhKien as lk on cthd.maLinhKien = lk.maLinhKien\r\n"
					+ "where year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "order by soLuong * donGia desc";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + time);
		}
		
		ResultSet res = con.createStatement().executeQuery(query);
		while(res.next()) {
			nameCus = "Khách hàng: " + res.getString(1) + "/Sđt: " + res.getString(2);
		}
		return nameCus;
	}
	
	public String getCusTop1BuyMore(String time) throws SQLException {
		String nameCus = "";
		String query = "";
		switch (time.toUpperCase()) {
		case "DAY": {
			query = "select top 1 kh.maKhachHang,hoTenKH,count(maHoaDon) from HoaDon as hd\r\n"
					+ "join KhachHang as kh on hd.maKhachHang = kh.maKhachHang\r\n"
					+ "where day(ngayLapHoaDon) = day(getdate())\r\n"
					+ "and month(ngayLapHoaDon) = month(getdate())\r\n"
					+ "and year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "group by kh.maKhachHang,hoTenKH\r\n"
					+ "order by count(maHoaDon) desc";
			
			break;
		}
		case "MONTH": {
			query = "select top 1 kh.maKhachHang,hoTenKH,count(maHoaDon) from HoaDon as hd\r\n"
					+ "join KhachHang as kh on hd.maKhachHang = kh.maKhachHang\r\n"
					+ "where month(ngayLapHoaDon) = month(getdate())\r\n"
					+ "and year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "group by kh.maKhachHang,hoTenKH\r\n"
					+ "order by count(maHoaDon) desc";
			break;
		}
		case "YEAR": {
			query = "select top 1 kh.maKhachHang,hoTenKH,count(maHoaDon) from HoaDon as hd\r\n"
					+ "join KhachHang as kh on hd.maKhachHang = kh.maKhachHang\r\n"
					+ "where year(ngayLapHoaDon) = year(getdate())\r\n"
					+ "group by kh.maKhachHang,hoTenKH\r\n"
					+ "order by count(maHoaDon) desc";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + time);
		}
		
		ResultSet res = con.createStatement().executeQuery(query);
		while(res.next()) {
			nameCus = "Khách hàng: " + res.getString(2) + "/đã mua: " + res.getString(3)+" đơn hàng" ;
		}
		return nameCus;
	}
	
}