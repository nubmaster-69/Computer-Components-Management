package gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import dao.LinhKienDAO;
import entity.LinhKien;

public class PanelDanhSachSanPham extends JPanel implements MouseListener, ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JButton btnChinhSua;
	private JButton btnThem;
	private JButton btnTimKiem;
	private JButton btnXoa;
	private JComboBox<String> jComboBox1;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTable tableDanhSachSanPham;
	private JTextArea txtAreaMoTa;
	private JTextField txtBaoHanh;
	private JTextField txtDonGia;
	private JTextField txtLoaiLinhKien;
	private JTextField txtMaLinhKien;
	private JTextField txtNgayNhap;
	private JTextField txtSoLuongTon;
	private JTextField txtTenSanPham;
	private JTextField txtThuongHieu;
	private JTextField txtTimKiem;
	private DefaultTableModel model;
	LinhKienDAO linhKienDAO;
	
	public PanelDanhSachSanPham() {
		initComponents();
		linhKienDAO = new LinhKienDAO();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		btnThem = new JButton();
		btnChinhSua = new JButton();
		jLabel1 = new JLabel();
		btnXoa = new JButton();
		jLabel2 = new JLabel();
		txtNgayNhap = new JTextField();
		jLabel6 = new JLabel();
		jLabel8 = new JLabel();
		txtTenSanPham = new JTextField();
		txtDonGia = new JTextField();
		jLabel3 = new JLabel();
		txtLoaiLinhKien = new JTextField();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel7 = new JLabel();
		jLabel9 = new JLabel();
		txtMaLinhKien = new JTextField();
		txtBaoHanh = new JTextField();
		txtThuongHieu = new JTextField();
		jLabel10 = new JLabel();
		txtSoLuongTon = new JTextField();
		jLabel11 = new JLabel();
		jScrollPane2 = new JScrollPane();
		txtAreaMoTa = new JTextArea();
		jScrollPane1 = new JScrollPane();
		tableDanhSachSanPham = new JTable(
				model = new DefaultTableModel(new String[] { "M?? linh ki???n", "T??n s???n ph???m", "Lo???i linh ki???n",
						"????n gi??", "Th????ng hi???u", "S??? l?????ng t???n", "Ng??y nh???p", "B???o h??nh" }, 0));
		jLabel12 = new JLabel();
		jComboBox1 = new JComboBox<>();
		txtTimKiem = new JTextField();
		btnTimKiem = new JButton();

		tableDanhSachSanPham.addMouseListener(this);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		txtTimKiem.addKeyListener(this);

		btnThem.setText("Th??m");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed();
			}
		});

		btnChinhSua.setText("Ch???nh s???a");
		btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChinhSuaActionPerformed();
			}
		});

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setText("Danh s??ch s???n ph???m");

		btnXoa.setText("X??a");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed();
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel2.setText("Th??ng tin s???n ph???m");

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel6.setText("Lo???i linh ki???n");

		jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel8.setText("Ng??y nh???p");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel3.setText("T??n s???n ph???m");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel4.setText("????n gi??");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel5.setText("Th????ng hi???u");

		jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel7.setText("S??? l?????ng t???n");

		jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel9.setText("B???o h??nh");

		jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel10.setText("M?? linh ki???n");

		jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel11.setText("M?? t???");

		txtAreaMoTa.setColumns(20);
		txtAreaMoTa.setRows(5);
		jScrollPane2.setViewportView(txtAreaMoTa);

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

		jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel12.setText("Danh m???c");

		jComboBox1.setModel(new DefaultComboBoxModel<>(
				new String[] { "M?? linh ki???n", "T??n linh ki???n", "Lo???i linh ki???n", "Th????ng hi???u" }));

		btnTimKiem.setIcon(new ImageIcon(getClass().getResource("/img/loupe.png")));
		btnTimKiem.setBorderPainted(false);
		btnTimKiem.setContentAreaFilled(false);
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setFocusable(false);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addGap(187, 187, 187).addComponent(btnXoa)
												.addGap(261, 261, 261).addComponent(btnChinhSua))
								.addGroup(
										GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addGap(165, 165, 165).addComponent(jLabel1)))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(
												GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
														.addComponent(btnThem).addGap(180, 180, 180))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout
														.createSequentialGroup().addComponent(jLabel11)
														.addGap(65, 65, 65).addComponent(jScrollPane2,
																GroupLayout.PREFERRED_SIZE, 401,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3).addComponent(jLabel4)
														.addComponent(jLabel6).addComponent(jLabel8)).addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(txtLoaiLinhKien).addComponent(txtDonGia)
																.addComponent(txtTenSanPham)
																.addComponent(txtNgayNhap,
																		GroupLayout.PREFERRED_SIZE, 150,
																		GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING)
																.addComponent(jLabel10).addComponent(jLabel9)
																.addComponent(jLabel5).addComponent(jLabel7))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.TRAILING,
																		false)
																.addComponent(txtSoLuongTon,
																		GroupLayout.Alignment.LEADING)
																.addComponent(txtThuongHieu,
																		GroupLayout.Alignment.LEADING)
																.addComponent(txtMaLinhKien).addComponent(txtBaoHanh,
																		GroupLayout.PREFERRED_SIZE, 156,
																		GroupLayout.PREFERRED_SIZE))))
												.addContainerGap(14, Short.MAX_VALUE))))
								.addGroup(GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel2).addGap(117, 117, 117))))
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel12).addGap(18, 18, 18)
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 130,
								GroupLayout.PREFERRED_SIZE)
						.addGap(123, 123, 123)
						.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 278,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnTimKiem)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(btnTimKiem)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(txtTimKiem, GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel12)
												.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jLabel2))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel10).addComponent(
																txtMaLinhKien, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel5).addComponent(txtThuongHieu,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel7).addComponent(txtSoLuongTon,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel9)
																.addComponent(txtBaoHanh,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3).addComponent(
																txtTenSanPham, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel4).addComponent(txtDonGia,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel6).addComponent(txtLoaiLinhKien,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel8).addComponent(txtNgayNhap,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane2)
												.addGroup(layout.createSequentialGroup().addComponent(jLabel11)
														.addGap(0, 0, Short.MAX_VALUE))))
								.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(btnThem).addComponent(btnChinhSua).addComponent(btnXoa))
						.addContainerGap()));
		loadProductsData();
	}

	private void btnThemActionPerformed() {
		if (validateData("check")) {
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
					if (JOptionPane.showConfirmDialog(null, "Th??m s???n ph???m th??nh c??ng! Ti???p t???c th??m?",
							"Th??m th??ng tin s???n ph???m", JOptionPane.YES_NO_OPTION) == 1)
						clearTextFields();
					
				}
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		loadProductsData();
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
		if (validateData("noCheck")) {
			String ma = (String) tableDanhSachSanPham.getValueAt(tableDanhSachSanPham.getSelectedRow(),0);
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
				if (linhKienDAO.updateComponentByID(lk.getMaLK(),lk)) {
					JOptionPane.showMessageDialog(this,"Ch???nh s???a th??ng tin th??nh c??ng");
					clearTextFields();
				}
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		loadProductsData();
	}

	private void btnXoaActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a?", "X??c nh???n",
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
			model.getDataVector().removeAllElements();
			ArrayList<LinhKien> comps = new LinhKienDAO().getComponents();

			for (LinhKien comp : comps)
				model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getDonGia(),
						comp.getThuongHieu(), comp.getSoLuongTon(), comp.getNgayNhap(), comp.getBaoHanh() });

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	@SuppressWarnings("unused")
	private boolean validateData(String checkMa) {
		String ma = txtMaLinhKien.getText().trim();
		String ten = txtTenSanPham.getText().trim();
		String mota = txtAreaMoTa.getText().trim();
		String gia = txtDonGia.getText().trim();
		String loai = txtLoaiLinhKien.getText();
		String thuonghieu = txtThuongHieu.getText().trim();
		String soluong = txtSoLuongTon.getText().trim();
		String ngay = txtNgayNhap.getText().trim();
		String bh = txtBaoHanh.getText();
		if(checkMa.equalsIgnoreCase("check")) {
			if (!(ma.length() > 0 && ma.matches("^[A-Z]{2}[0-9]{6}$"))) {
				showMsg("M?? linh ki???n kh??ng ???????c ????? tr???ng ph???i b???t ?????u b???ng 2 k?? t??? hoa v?? theo sau l?? 6 k?? t??? s???");
				txtMaLinhKien.requestFocus();
				txtMaLinhKien.selectAll();
				return false;
			}

			try {
				if (linhKienDAO.getComponentByID(ma) != null) {
					showMsg("M?? tr??ng!");
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
		}
		if (!(ten.length() > 0)) {
			showMsg("T??n s???n ph???m kh??ng ???????c ????? tr???ng v?? ph???i b???t ?????u b???ng k?? t??? hoa!!!");
			txtTenSanPham.requestFocus();
			txtTenSanPham.selectAll();
			return false;
		}

		if (!(mota.length() > 0)) {
			showMsg("M?? t??? linh ki???n kh??ng ???????c ????? tr???ng ph???i b???ng ?????u b???ng k?? t??? t??? hoa!!!");
			txtAreaMoTa.requestFocus();
			txtAreaMoTa.selectAll();
			return false;
		}
		double dongia = 0;
		try {
			if (!(gia.length() > 0)) {
				showMsg("????n gi?? linh ki???n kh??ng ???????c ????? tr???ng!!!");
				txtDonGia.requestFocus();
				txtDonGia.selectAll();
				return false;
			}
			dongia = Double.parseDouble(gia);

		} catch (Exception e) {
			showMsg("????n gi?? ch??? ???????c nh???p s???");
			txtDonGia.requestFocus();
			txtDonGia.selectAll();
			return false;
		}
		if (!(thuonghieu.length() > 0 && thuonghieu.matches(
				"^[a-z0-9A-Z_ ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????? ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????.-]*$"))) {
			showMsg("Th????ng Hi???u linh ki???n kh??ng ???????c ????? tr???ng!!!");
			txtThuongHieu.requestFocus();
			txtThuongHieu.selectAll();
			return false;
		}
		try {
			Integer.parseInt(soluong);
			if (!(soluong.length() > 0)) {
				showMsg("Kh??ng ???????c ????? tr???ng s??? l?????ng linh ki???n!!!!");
				txtSoLuongTon.requestFocus();
				return false;
			}
		} catch (Exception e) {
			showMsg("S??? l?????ng linh ki???n kh??ng ???????c nh???p ch??? c??i!!!");
			txtSoLuongTon.requestFocus();
			txtSoLuongTon.selectAll();
			return false;
		}
		
		if(!checkMa.equalsIgnoreCase("check")) {
			String soLuongHienTai = tableDanhSachSanPham.getValueAt(tableDanhSachSanPham.getSelectedRow(), 5).toString();
			int soLuongTon = Integer.parseInt(soLuongHienTai);
			if(Integer.parseInt(soluong) < soLuongTon) {
				showMsg("S??? l?????ng linh ki???n kh??ng b?? h??n s??? l?????ng hi???n t???i!!!");
				txtSoLuongTon.requestFocus();
				txtSoLuongTon.selectAll();
				return false;
			}
		}

		long millis = System.currentTimeMillis();
		Date ngaht = new Date(millis);
		String txtNgay = txtNgayNhap.getText();
		String ngayn = "1990-01-01";
		Date ngaygoc = Date.valueOf(ngayn);
		if (!(txtNgay.length() > 0)) {
			showMsg("Ng??y nh???p kh??ng ???????c ????? tr???ng !");
			txtNgayNhap.requestFocus();
			return false;
		}
		if (!(txtNgay.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))) {
			showMsg("Ng??y nh???p ph???i c?? d???ng: YYYY-MM-DD");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}
		Date ngaynhap = Date.valueOf(txtNgay);
		if (!(ngaynhap.before(ngaht))) {
			showMsg("Ng??y nh???p ph???i nh??? h??n ng??y hi???n t???i");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}
		if (!(ngaynhap.after(ngaygoc))) {
			showMsg("Ng??y nh???p ph???i l???n h??n 1990-01-01");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}

		int baoHanh = 0;
		try {
			if (!(bh.length() > 0)) {
				showMsg("Th???i gian b???o h??nh linh ki???n kh??ng ???????c ????? tr???ng");
				txtBaoHanh.requestFocus();
				return false;
			}
			baoHanh = Integer.parseInt(bh);
		} catch (Exception e) {
			showMsg("Th???i gian b???o h??nh ch??? ???????c nh???p s??? !!!");
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
		txtDonGia.setText(tableDanhSachSanPham.getValueAt(selectedRow, 3).toString());
		txtThuongHieu.setText(tableDanhSachSanPham.getValueAt(selectedRow, 4).toString());
		txtLoaiLinhKien.setText(tableDanhSachSanPham.getValueAt(selectedRow, 2).toString());
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(txtTimKiem)) {
			int idx = jComboBox1.getSelectedIndex();
			String key = txtTimKiem.getText().trim();
			key = key.toUpperCase() + "%";
			switch (idx) {
			case 0: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByKeyMa(key);

					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getDonGia(),
								comp.getThuongHieu(), comp.getSoLuongTon(), comp.getNgayNhap(), comp.getBaoHanh() });

				} catch (SQLException ex) {
//						return;
//						JOptionPane.showMessageDialog(this,"Khong co linh kien");
//						ex.printStackTrace();
				}
				break;
			}
			case 1: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByName(key);

					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getDonGia(),
								comp.getThuongHieu(), comp.getSoLuongTon(), comp.getNgayNhap(), comp.getBaoHanh() });

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this, "Nh??n vi??n kh??ng t???n t???i");
					ex.printStackTrace();
				}
				break;
			}
			case 2: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByCategory(key);

					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getDonGia(),
								comp.getThuongHieu(), comp.getSoLuongTon(), comp.getNgayNhap(), comp.getBaoHanh() });
					
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this, "Nh??n vi??n kh??ng t???n t???i");
					ex.printStackTrace();
				}
				break;
			}
			case 3: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByThuongHieu(key);

					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getDonGia(),
								comp.getThuongHieu(), comp.getSoLuongTon(), comp.getNgayNhap(), comp.getBaoHanh() });

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this, "Nh??n vi??n kh??ng t???n t???i");
					ex.printStackTrace();
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idx);
			}
		}
	}
}