package gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.LinhKienDAO;
import entity.LinhKien;

public class PanelDanhSachSanPham extends javax.swing.JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private javax.swing.JButton btnChinhSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXoa;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableDanhSachSanPham;
	private javax.swing.JTextArea txtAreaMoTa;
	private javax.swing.JTextField txtBaoHanh;
	private javax.swing.JTextField txtDonGia;
	private javax.swing.JTextField txtLoaiLinhKien;
	private javax.swing.JTextField txtMaLinhKien;
	private javax.swing.JTextField txtNgayNhap;
	private javax.swing.JTextField txtSoLuongTon;
	private javax.swing.JTextField txtTenSanPham;
	private javax.swing.JTextField txtThuongHieu;
	private DefaultTableModel model;
	LinhKienDAO linhKienDAO;

	public PanelDanhSachSanPham() {
		initComponents();
		linhKienDAO = new LinhKienDAO();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		btnThem = new javax.swing.JButton();
		btnChinhSua = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		btnXoa = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		txtNgayNhap = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		txtTenSanPham = new javax.swing.JTextField();
		txtDonGia = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtLoaiLinhKien = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		txtMaLinhKien = new javax.swing.JTextField();
		txtBaoHanh = new javax.swing.JTextField();
		txtThuongHieu = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		txtSoLuongTon = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		txtAreaMoTa = new javax.swing.JTextArea();
		jScrollPane1 = new javax.swing.JScrollPane();

		tableDanhSachSanPham = new javax.swing.JTable(
				model = new DefaultTableModel(new String[] { "Mã linh kiện", "Tên linh kiện", "Đơn giá", "Thương hiệu",
						"Loại linh kiện", "Số lượng tồn", "Ngày nhập", "Bảo hành" }, 0));

		tableDanhSachSanPham.addMouseListener(this);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		btnThem.setText("Thêm");
		btnThem.addActionListener(this);
		btnThem.setFocusable(false);

		btnChinhSua.setText("Chỉnh sửa");
		btnChinhSua.addActionListener(this);
		btnChinhSua.setFocusable(false);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setText("Danh sách sản phẩm");

		btnXoa.setText("Xóa");
		btnXoa.addActionListener(this);
		btnXoa.setFocusable(false);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel2.setText("Thông tin sản phẩm");

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel6.setText("Loại linh kiện");

		jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel8.setText("Ngày nhập");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel3.setText("Tên sản phẩm");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel4.setText("Đơn giá");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel5.setText("Thương hiệu");

		jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel7.setText("Số lượng tồn");

		jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel9.setText("Bảo hành");

		jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel10.setText("Mã linh kiện");

		jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel11.setText("Mô tả");

		txtAreaMoTa.setColumns(20);
		txtAreaMoTa.setRows(5);
		jScrollPane2.setViewportView(txtAreaMoTa);

		jScrollPane1.setFocusable(false);

		jScrollPane1.setViewportView(tableDanhSachSanPham);
		if (tableDanhSachSanPham.getColumnModel().getColumnCount() > 0) {
			tableDanhSachSanPham.getColumnModel().getColumn(0).setResizable(false);
			tableDanhSachSanPham.getColumnModel().getColumn(1).setResizable(false);
			tableDanhSachSanPham.getColumnModel().getColumn(2).setResizable(false);
			tableDanhSachSanPham.getColumnModel().getColumn(3).setResizable(false);
			tableDanhSachSanPham.getColumnModel().getColumn(4).setResizable(false);
			tableDanhSachSanPham.getColumnModel().getColumn(5).setResizable(false);
			tableDanhSachSanPham.getColumnModel().getColumn(6).setResizable(false);
			tableDanhSachSanPham.getColumnModel().getColumn(7).setResizable(false);
		}

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addGap(187, 187, 187).addComponent(btnXoa)
												.addGap(261, 261, 261).addComponent(btnChinhSua))
								.addGroup(
										javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addGap(156, 156, 156).addComponent(jLabel1)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel6)
												.addComponent(jLabel8).addComponent(jLabel11)).addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(txtLoaiLinhKien).addComponent(txtDonGia)
																.addComponent(txtTenSanPham).addComponent(
																		txtNgayNhap,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 150,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				jLabel10)
																		.addComponent(jLabel9).addComponent(
																				jLabel5)
																		.addComponent(jLabel7))
																.addGap(18, 18, 18)
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		false)
																		.addComponent(
																				txtSoLuongTon,
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(txtThuongHieu,
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(txtMaLinhKien)
																		.addComponent(txtBaoHanh,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				156,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(0, 0, Short.MAX_VALUE))
														.addComponent(jScrollPane2)))
										.addGroup(layout.createSequentialGroup().addGap(169, 169, 169)
												.addComponent(jLabel2)))
								.addGap(15, 15, 15))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnThem).addGap(180, 180, 180)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(jLabel2))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel10)
										.addComponent(txtMaLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5).addComponent(txtThuongHieu,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel7).addComponent(txtSoLuongTon,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel9).addComponent(txtBaoHanh,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3).addComponent(txtTenSanPham,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4).addComponent(txtDonGia,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel6).addComponent(txtLoaiLinhKien,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel8).addComponent(txtNgayNhap,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(13, 13, 13)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel11).addComponent(jScrollPane2,
										javax.swing.GroupLayout.PREFERRED_SIZE, 276,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnThem)
						.addComponent(btnChinhSua).addComponent(btnXoa))
				.addContainerGap()));
		loadProductsData();
	}

	private void btnThemActionPerformed() {
		if (validateData()) {

			String ma = txtMaLinhKien.getText().trim();
			String ten = txtTenSanPham.getText().trim();
			String mota = txtAreaMoTa.getText().trim();
			double gia = Double.parseDouble(txtDonGia.getText().trim());
			String loai = txtLoaiLinhKien.getText();
			String thuonghieu = txtThuongHieu.getText().trim();
			int soluong = Integer.parseInt(txtSoLuongTon.getText().trim());
			Date ngaynhap = Date.valueOf(txtNgayNhap.getText().trim());
			int bh = Integer.parseInt(txtBaoHanh.getText());

			try {

				LinhKien lk = new LinhKien(ma, ten, loai, mota, gia, thuonghieu, soluong, ngaynhap, bh);

				if (linhKienDAO.addComponent(lk)) {
					if (JOptionPane.showConfirmDialog(null, "Thêm sản phẩm thành công! Tiếp tục thêm?",
							"Thêm thông tin sản phẩm", JOptionPane.YES_NO_OPTION) == 1)
						clearTextFields();
					loadProductsData();
				}
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private void clearTextFields() {
		txtMaLinhKien.setText("");
		txtTenSanPham.setText("");
		txtDonGia.setText("");
		txtThuongHieu.setText("");
		txtLoaiLinhKien.setText("");
		txtSoLuongTon.setText("");
		txtNgayNhap.setText("");
		txtBaoHanh.setText("");
		txtAreaMoTa.setText("");
	}

	private void btnChinhSuaActionPerformed() {
	}

	private void btnXoaActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		if (confirm == 0) {

			while (tableDanhSachSanPham.getSelectedRowCount() != 0) {
				int selectedRow = tableDanhSachSanPham.getSelectedRow();
				String maLK = tableDanhSachSanPham.getValueAt(selectedRow, 0).toString();
				try {
					if (linhKienDAO.removeComponentByID(maLK))
						model.removeRow(selectedRow);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void loadProductsData() {
		try {
			ArrayList<LinhKien> comps = new LinhKienDAO().getComponents();

			for (LinhKien comp : comps)
				model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getDonGia(), comp.getThuongHieu(),
						comp.getLoaiLK(), comp.getSoLuongTon(), comp.getNgayNhap(), comp.getBaoHanh() });

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	private boolean validateData() {
		String ma = txtMaLinhKien.getText().trim();
		String ten = txtTenSanPham.getText().trim();
		String mota = txtAreaMoTa.getText().trim();
		String gia = txtDonGia.getText().trim();
		String loai = txtLoaiLinhKien.getText();
		String thuonghieu = txtThuongHieu.getText().trim();
		String soluong = txtSoLuongTon.getText().trim();
		String ngay = txtNgayNhap.getText().trim();
		String bh = txtBaoHanh.getText();

		if (!(ma.length() > 0 && ma.matches("^[A-Z]{2}[0-9]{6}$"))) {
			showMsg("Mã linh kiện không được để trống phải bắt đầu bằng 2 kí tự hoa và theo sau là 6 kí tự số");
			txtMaLinhKien.requestFocus();
			txtMaLinhKien.selectAll();
			return false;
		}

		try {
			if (linhKienDAO.getComponentByID(ma) != null) {
				showMsg("Mã trùng!");
				txtMaLinhKien.requestFocus();
				txtMaLinhKien.selectAll();
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			txtMaLinhKien.requestFocus();
			txtMaLinhKien.selectAll();
			return false;
		}

		if (!(ten.length() > 0)) {
			showMsg("Tên sản phẩm không được để trống và phải bắt đầu bằng kí tự hoa!!!");
			txtTenSanPham.requestFocus();
			txtTenSanPham.selectAll();
			return false;
		}

		if (!(mota.length() > 0)) {
			showMsg("Mô tả linh kiện không được để trống phải bắng đầu bằng kí tự tự hoa!!!");
			txtAreaMoTa.requestFocus();
			txtAreaMoTa.selectAll();
			return false;
		}
		double dongia = 0;
		try {
			if (!(gia.length() > 0)) {
				showMsg("Đơn giá linh kiện không được để trống!!!");
				txtDonGia.requestFocus();
				txtDonGia.selectAll();
				return false;
			}
			dongia = Double.parseDouble(gia);

		} catch (Exception e) {
			showMsg("Đơn giá chỉ được nhập số");
			txtDonGia.requestFocus();
			txtDonGia.selectAll();
			return false;
		}
		if (!(thuonghieu.length() > 0 && thuonghieu.matches(
				"^[a-z0-9A-Z_ ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ.-]*$"))) {
			showMsg("Thương Hiệu linh kiện không được để trống!!!");
			txtThuongHieu.requestFocus();
			txtThuongHieu.selectAll();
			return false;
		}
		int soLuongTon = 0;
		try {
			soLuongTon = Integer.parseInt(soluong);
			if (!(soluong.length() > 0)) {
				showMsg("Không được để trống số lượng linh kiện!!!!");
				txtSoLuongTon.requestFocus();
				return false;
			}
		} catch (Exception e) {
			showMsg("Số lượng linh kiện không được nhập số!!!");
			txtSoLuongTon.requestFocus();
			txtSoLuongTon.selectAll();
			return false;
		}

		long millis = System.currentTimeMillis();
		Date ngaht = new Date(millis);
		String txtNgay = txtNgayNhap.getText();
		String ngayn = "1990-01-01";
		Date ngaygoc = Date.valueOf(ngayn);
		if (!(txtNgay.length() > 0)) {
			showMsg("Ngày nhập không được để trống !");
			txtNgayNhap.requestFocus();
			return false;
		}
		if (!(txtNgay.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))) {
			showMsg("Ngày nhập phải có dạng: YYYY-MM-DD");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}
		Date ngaynhap = Date.valueOf(txtNgay);
		if (!(ngaynhap.before(ngaht))) {
			showMsg("Ngày nhập phải nhỏ hơn ngày hiện tại");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}
		if (!(ngaynhap.after(ngaygoc))) {
			showMsg("Ngày nhập phải lớn hơn 1990-01-01");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}

		int baoHanh = 0;
		try {
			if (!(bh.length() > 0)) {
				showMsg("Thời gian bảo hành linh kiện không được để trống");
				txtBaoHanh.requestFocus();
				return false;
			}
			baoHanh = Integer.parseInt(bh);
		} catch (Exception e) {
			showMsg("Thời gian bảo hành chỉ được nhập số !!!");
			txtBaoHanh.requestFocus();
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnThem))
			btnThemActionPerformed();
		else if (o.equals(btnXoa))
			btnXoaActionPerformed();
		else if (o.equals(btnChinhSua))
			btnChinhSuaActionPerformed();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedRow = tableDanhSachSanPham.getSelectedRow();
		String maLk = tableDanhSachSanPham.getValueAt(selectedRow, 0).toString();
		txtTenSanPham.setText(tableDanhSachSanPham.getValueAt(selectedRow, 1).toString());
		txtDonGia.setText(tableDanhSachSanPham.getValueAt(selectedRow, 2).toString());
		txtThuongHieu.setText(tableDanhSachSanPham.getValueAt(selectedRow, 3).toString());
		txtLoaiLinhKien.setText(tableDanhSachSanPham.getValueAt(selectedRow, 4).toString());
		txtSoLuongTon.setText(tableDanhSachSanPham.getValueAt(selectedRow, 5).toString());
		txtNgayNhap.setText(tableDanhSachSanPham.getValueAt(selectedRow, 6).toString());
		txtBaoHanh.setText(tableDanhSachSanPham.getValueAt(selectedRow, 7).toString());
		try {
			txtAreaMoTa.setText(linhKienDAO.getComponentDescription(maLk));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
