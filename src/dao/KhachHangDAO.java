package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDatabase.ConnectDatabase;
import entity.KhachHang;
import entity.LinhKien;

public class KhachHangDAO {
	private Connection con;

	public KhachHangDAO() {
		try {
			con = ConnectDatabase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<KhachHang> getCustomers() throws SQLException {
		ArrayList<KhachHang> cus = new ArrayList<>();

		ResultSet res = con.createStatement().executeQuery("Select * from KhachHang");

		while (res.next())
			cus.add(new KhachHang(res.getString(1), res.getString(2),
					res.getString(3),res.getString(4)));

		return cus;
	}

	public KhachHang getCustomerByID(String maKH) throws SQLException {
		KhachHang kh = null;

		String query = "select * from KhachHang where maKhachHang = ?";

		PreparedStatement pState = con.prepareStatement(query);

		pState.setString(1, maKH);

		ResultSet res = pState.executeQuery();

		while (res.next())
			kh = new KhachHang(res.getString(1), res.getString(2), 
					res.getString(3), res.getString(4));

		return kh;
	}

	public String getLastCustomerID() {
		String cusID = "";
		
		ResultSet res;
		try {
			res = con.createStatement().executeQuery("select top 1 maKhachHang from KhachHang "
					+ "order by maKhachHang desc");
			while(res.next())
				cusID = res.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cusID;
	}
	
	public int customerQuantity() throws SQLException {
		int quan = 0;

		String query = "select count(maKhachHang) as SoLuong from KhachHang";

		ResultSet res = con.createStatement().executeQuery(query);

		while (res.next())
			quan = res.getInt(1);

		return quan;
	}

	public boolean addCustomer(KhachHang kh) throws SQLException {
		String query = "insert KhachHang values (?, ?, ?, ?)";

		PreparedStatement pState = con.prepareStatement(query);

		pState.setString(1, kh.getMaKH());
		pState.setString(2, kh.getHoTen());
		pState.setString(3, kh.getSoDT());
		pState.setString(4, kh.getDiaChi());

		return pState.executeUpdate() > 0;
	}

	public boolean removeCustomerByID(String maKH) throws SQLException {
		String query = "delete KhachHang where maKhachHang = ?";

		PreparedStatement pState = con.prepareStatement(query);

		pState.setString(1, maKH);

		return pState.executeUpdate() > 0;
	}
	
	public boolean updateCustomerInfoByID(String maKH, KhachHang kh) throws SQLException {
		String query = "update KhachHang set hoTenKH = ?,soDienThoaiKH = ?, diaChiKH = ? where maKhachHang = ?";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, kh.getHoTen());
		pState.setString(2, kh.getSoDT());
		pState.setString(3, kh.getDiaChi());
		
		pState.setString(4, maKH);
		
		return pState.executeUpdate() > 0;
	}
	
	public ArrayList<KhachHang> getCusByID(String maKhachHang) throws SQLException {
		ArrayList<KhachHang> Cus = new ArrayList<>();
		
		String query = "select * from KhachHang where maKhachHang like ? ";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, maKhachHang);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next()) {
			Cus.add(new KhachHang(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
		}
		
		return Cus;
	}
	
	public ArrayList<KhachHang> getCusByName(String Name) throws SQLException {
		ArrayList<KhachHang> Cus = new ArrayList<>();
		
		String query = "select * from KhachHang where hoTenKH like ? ";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, Name);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next()) {
			Cus.add(new KhachHang(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
		}
		
		return Cus;
	}
	
	public ArrayList<KhachHang> getCusBySTD(String STD) throws SQLException {
		ArrayList<KhachHang> Cus = new ArrayList<>();
		
		String query = "select * from KhachHang where soDienThoaiKH like ? ";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, STD);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next()) {
			Cus.add(new KhachHang(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
		}
		
		return Cus;
	}
	
	public KhachHang getOneCusBySdt(String sdt) throws SQLException {
		KhachHang Cus = null;
		
		String query = "select * from KhachHang where soDienThoaiKH like ? ";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, sdt);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next()) {
			Cus =new KhachHang(res.getString(1),res.getString(2),res.getString(3),res.getString(4));
		}
		
		return Cus;
	}
}