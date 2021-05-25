package gui;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import entity.NhanVien;

public class PanelDanhSachNhanVien extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	public PanelDanhSachNhanVien() {
		dao = new NhanVienDAO();
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		btnThem = new javax.swing.JButton();
		btnChinhSua = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtDiaChi = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		txtMaNhanVien = new javax.swing.JTextField();
		txtChucVu = new javax.swing.JTextField();
		txtHoTen = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		txtMatKhau = new javax.swing.JTextField();
		txtNgaySinh = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtSDT = new javax.swing.JTextField();
		chkNu = new javax.swing.JCheckBox();
		jLabel12 = new javax.swing.JLabel();
		cmbBoxQuyenDangNhap = new javax.swing.JComboBox<>();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setText("Danh sách nhân viên");

		tableDanhSachNhanVien = new javax.swing.JTable(model = new DefaultTableModel(
				new String[] { "Mã nhân viên", "Họ tên nhân viên", "Giới tính", "Số điện thoại", "Chức vụ" }, 0));

		jScrollPane1.setViewportView(tableDanhSachNhanVien);
		if (tableDanhSachNhanVien.getColumnModel().getColumnCount() > 0) {
			tableDanhSachNhanVien.getColumnModel().getColumn(0).setResizable(false);
			tableDanhSachNhanVien.getColumnModel().getColumn(1).setResizable(false);
			tableDanhSachNhanVien.getColumnModel().getColumn(2).setResizable(false);
			tableDanhSachNhanVien.getColumnModel().getColumn(3).setResizable(false);
			tableDanhSachNhanVien.getColumnModel().getColumn(4).setResizable(false);
		}

		btnThem.setText("Thêm");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnChinhSua.setText("Chỉnh sửa");
		btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChinhSuaActionPerformed(evt);
			}
		});

		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel8.setText("Địa chỉ");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel3.setText("Mã nhân viên");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel4.setText("Họ và tên");

		jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel9.setText("Chức vụ");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel5.setText("Nữ");

		jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel11.setText("Mật khẩu");

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel6.setText("Ngày sinh");

		jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel7.setText("Số điện thoại");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel2.setText("Thông tin nhân viên");

		jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel12.setText("Quyền đăng nhập");

		cmbBoxQuyenDangNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Admin" }));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(200, 200, 200).addComponent(jLabel1))
								.addGroup(layout
										.createSequentialGroup().addGap(177, 177, 177).addComponent(btnXoa)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnChinhSua).addGap(47, 47, 47)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout
												.createSequentialGroup().addGroup(layout.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGap(8, 8, 8)
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel5).addGroup(layout
																				.createSequentialGroup().addGap(3, 3, 3)
																				.addComponent(chkNu)))
																.addGap(60, 60, 60)
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																		.addComponent(jLabel6,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(txtNgaySinh)))
														.addGroup(layout.createSequentialGroup().addGap(5, 5, 5)
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel3).addComponent(
																				txtMaNhanVien,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				198,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(layout
																.createSequentialGroup().addGap(5, 5, 5)
																.addComponent(jLabel8))
														.addGroup(layout.createSequentialGroup().addGap(5, 5, 5)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel12).addComponent(
																						txtDiaChi,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						215,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(layout.createSequentialGroup().addGap(7, 7, 7)
																.addComponent(cmbBoxQuyenDangNhap,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGap(27, 27,
																27).addComponent(jLabel7))
														.addGroup(layout
																.createSequentialGroup().addGap(21, 21, 21)
																.addComponent(jLabel4))
														.addGroup(layout.createSequentialGroup().addGap(3, 3, 3)
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		false).addComponent(txtMatKhau)
																		.addComponent(txtChucVu,
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel11)
																				.addGroup(layout.createSequentialGroup()
																						.addGap(3, 3, 3)
																						.addGroup(layout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.LEADING,
																										false)
																								.addComponent(jLabel9)
																								.addComponent(txtSDT,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										183,
																										Short.MAX_VALUE)
																								.addComponent(
																										txtHoTen))))))))
										.addGroup(layout.createSequentialGroup().addGap(102, 102, 102)
												.addComponent(jLabel2)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(btnThem).addGap(168, 168, 168)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(32, 32, 32)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtMaNhanVien,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
														.createSequentialGroup().addComponent(jLabel5)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(chkNu).addGap(18, 18, 18).addComponent(jLabel8)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(76, 76, 76))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
														.createSequentialGroup()
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jLabel7).addGap(47, 47, 47)
																		.addComponent(jLabel9))
																.addGroup(layout.createSequentialGroup().addGap(3, 3, 3)
																		.addGroup(layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(txtNgaySinh,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(layout.createSequentialGroup()
																						.addComponent(jLabel6)
																						.addGap(26, 26, 26))
																				.addComponent(txtSDT,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel11).addComponent(jLabel12))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(txtMatKhau,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(cmbBoxQuyenDangNhap,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))))
								.addGap(0, 0, Short.MAX_VALUE)))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnChinhSua).addComponent(btnThem).addComponent(btnXoa))
				.addGap(11, 11, 11)));

		loadEmployeesData();
	}

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
		xoa();
		tableDanhSachNhanVien.clearSelection();
	}

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
		if(regex()) {
			try {
				NhanVien nv = getNhanVien();
				try {
					dao.addEmployee(nv);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this,"Mã nhân viên trùng");
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(this,"Thêm thành công");
				removeForm();
				loadEmployeesData();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {
		sua();
		tableDanhSachNhanVien.clearSelection();
	}
	
	
	private void removeForm() {
		txtMaNhanVien.setText("");
		txtHoTen.setText("");
		txtNgaySinh.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtMatKhau.setText("");
	}
	private boolean regex() {
		String maNV = txtMaNhanVien.getText().trim();
		String hoTen = txtHoTen.getText().trim();
		String ngay = txtNgaySinh.getText();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String matKhau = txtMatKhau.getText().trim();
		
		
		if (!(maNV.length() > 0 && hoTen.length() > 0 && ngay.length() > 0 && sdt.length() > 0 && diaChi.length() > 0
				&& matKhau.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Phải nhập đủ thông tin");
		}

		if (!(maNV.length() > 0)) {
			txtMaNhanVien.requestFocus();
			return false;
		}

		if (!(hoTen.length() > 0)) {
			txtHoTen.requestFocus();
			return false;
		}

		if (!(ngay.length() > 0)) {
			txtNgaySinh.requestFocus();
			return false;
		}
		
		if (!(sdt.length() > 0)) {
			txtSDT.requestFocus();
			return false;
		}

		if (!(diaChi.length() > 0)) {
			txtDiaChi.requestFocus();
			return false;
		}

		if (!(matKhau.length() > 0)) {
			txtMatKhau.requestFocus();
			return false;
		}

		if (!(hoTen.matches(
				"^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$"))) {
			JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		}
		
		if (!(ngay.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))) {
			JOptionPane.showMessageDialog(this, "Ngày sinh phải theo dạng: YYYY-MM-DD");
			txtNgaySinh.selectAll();
			txtNgaySinh.requestFocus();
			return false;
		}

		if (!(sdt.matches("^0[0-9]{9}$"))) {
			JOptionPane.showInternalMessageDialog(this, "Số điện thoại k hợp lệ");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}

		String[] ngayFormat = ngay.split("-");
		LocalDate ngaysinh = null;
		LocalDate ngayHienTai = null;
		try {
			ngaysinh = LocalDate.of(Integer.parseInt(ngayFormat[0]), Integer.parseInt(ngayFormat[1]),Integer.parseInt(ngayFormat[2]));
			ngayHienTai = LocalDate.now();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Ngày sinh Không hợp lệ");
			txtNgaySinh.selectAll();
			txtNgaySinh.requestFocus();
			return false;
		}
		
		if (!(ngaysinh.isBefore(ngayHienTai))) {
			JOptionPane.showMessageDialog(this, "Ngày sinh phải bé hơn ngày hiện tại");
			txtNgaySinh.selectAll();
			txtNgaySinh.requestFocus();
			return false;
		}
		
		return true;
	}

	private void loadEmployeesData() {
		model.getDataVector().removeAllElements();
		try {
			ArrayList<NhanVien> emps = dao.getEmployees();
			
			for (NhanVien emp : emps)
				model.addRow(new Object[] { emp.getMaNhanVien(), emp.getHoTen(), emp.getGioiTinh(), emp.getSoDT(),
						emp.getQuyenTryCap() });

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void xoa() {
		int row = tableDanhSachNhanVien.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa");
			return;
		} else {
			int t = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa ?", "Xóa", JOptionPane.YES_NO_OPTION);
			if (t == JOptionPane.YES_OPTION) {
				String maNV = tableDanhSachNhanVien.getValueAt(row, 0).toString();
				try {
					dao.removeEmployeeByID(maNV);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				loadEmployeesData();
			}
		}
	}
	
	private void sua() {

		int row = tableDanhSachNhanVien.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(null, "chọn dòng muốn sửa");
			return;
		} else {
			NhanVien nv = null;
			try {
				if(regex()) {
					nv = getNhanVien();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int t1 = JOptionPane.showConfirmDialog(null, "bạn có muốn sửa ?", "Sửa", JOptionPane.YES_NO_OPTION);
			if (t1 == JOptionPane.YES_OPTION && nv!=null) {
				String maNV = tableDanhSachNhanVien.getValueAt(row, 0).toString();
				try {
					dao.updateEmployeeInfoByID(maNV, nv);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(this,"Sửa thông tin nhân viên thành công");
				loadEmployeesData();
			}
		}
	}
	
	@SuppressWarnings("unused")
	private NhanVien getNhanVien() throws ParseException{
		NhanVien nv ;
		String maNV = txtMaNhanVien.getText().trim();
		String hoTen = txtHoTen.getText().trim();
		String ngay = txtNgaySinh.getText();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String quyenDangNhap = (String) (cmbBoxQuyenDangNhap.getSelectedItem());
		String matKhau = txtMatKhau.getText().trim();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse(ngay);
        java.sql.Date ngaySinh = new java.sql.Date(parsed.getTime());
		
		if(chkNu.isSelected()) {
			nv = new NhanVien(maNV,hoTen,"Nữ",ngaySinh,sdt,diaChi,matKhau,quyenDangNhap);
		}
		else{
			nv = new NhanVien(maNV,hoTen,"Nam",ngaySinh,sdt,diaChi,matKhau,quyenDangNhap);
		}
		return nv;
	}

	private javax.swing.JButton btnChinhSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXoa;
	private javax.swing.JCheckBox chkNu;
	private javax.swing.JComboBox<String> cmbBoxQuyenDangNhap;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tableDanhSachNhanVien;
	private javax.swing.JTextField txtChucVu;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtMaNhanVien;
	private javax.swing.JTextField txtMatKhau;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtSDT;
	private DefaultTableModel model;
	private NhanVienDAO dao;

}
