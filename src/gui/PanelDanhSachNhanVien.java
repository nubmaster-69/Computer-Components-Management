package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import entity.NhanVien;

public class PanelDanhSachNhanVien extends JPanel implements MouseListener,KeyListener {

    private static final long serialVersionUID = 1L;
    
    private JButton btnChinhSua;
	private JButton btnThem;
	private JButton btnTimKiem;
	private JButton btnXoa;
	private JCheckBox chkNu;
	private JComboBox<String> cmbBoxDanhMuc;
	private JComboBox<String> cmbBoxQuyenDangNhap;
	private JLabel jLabel1;
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
	private JScrollPane jScrollPane1;
	private JTable tableDanhSachNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtHoTen;
	private JTextField txtMaNhanVien;
	private JTextField txtMatKhau;
	private JTextField txtNgaySinh;
	private JTextField txtSDT;
	private JTextField txtTimKiem;
	private DefaultTableModel model;
	private NhanVienDAO dao;
    
    public PanelDanhSachNhanVien() {
        dao = new NhanVienDAO();
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tableDanhSachNhanVien = new JTable(model = new DefaultTableModel(
				new String[] { "Mã nhân viên", "Họ tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Quyền truy cập" }, 0));
        btnThem = new JButton();
        btnChinhSua = new JButton();
        btnXoa = new JButton();
        jLabel8 = new JLabel();
        jLabel3 = new JLabel();
        txtDiaChi = new JTextField();
        jLabel4 = new JLabel();
        txtMaNhanVien = new JTextField();
        txtHoTen = new JTextField();
        jLabel5 = new JLabel();
        jLabel11 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        txtMatKhau = new JTextField();
        txtNgaySinh = new JTextField();
        jLabel2 = new JLabel();
        txtSDT = new JTextField();
        chkNu = new JCheckBox();
        jLabel12 = new JLabel();
        cmbBoxQuyenDangNhap = new JComboBox<>();
        jLabel9 = new JLabel();
        cmbBoxDanhMuc = new JComboBox<>();
        txtTimKiem = new JTextField();
        btnTimKiem = new JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Danh sách nhân viên");

        jScrollPane1.setViewportView(tableDanhSachNhanVien);
        if (tableDanhSachNhanVien.getColumnModel().getColumnCount() > 0) {
            tableDanhSachNhanVien.getColumnModel().getColumn(0).setResizable(false);
            tableDanhSachNhanVien.getColumnModel().getColumn(1).setResizable(false);
            tableDanhSachNhanVien.getColumnModel().getColumn(2).setResizable(false);
            tableDanhSachNhanVien.getColumnModel().getColumn(3).setResizable(false);
            tableDanhSachNhanVien.getColumnModel().getColumn(4).setResizable(false);
            tableDanhSachNhanVien.getColumnModel().getColumn(5).setResizable(false);
            tableDanhSachNhanVien.getColumnModel().getColumn(6).setResizable(false);
        }
        
        btnTimKiem.addMouseListener(this);

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
        
        txtTimKiem.addKeyListener(this);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel8.setText("Địa chỉ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel3.setText("Mã nhân viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel4.setText("Họ và tên");

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

        cmbBoxQuyenDangNhap.setModel(new DefaultComboBoxModel<>(new String[] { "Nhân viên", "Admin" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel9.setText("Danh mục");

        cmbBoxDanhMuc.setModel(new DefaultComboBoxModel<>(new String[] { "Mã nhân viên", "Tên nhân viên"}));

        btnTimKiem.setIcon(new ImageIcon(getClass().getResource("/img/loupe.png")));
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setContentAreaFilled(false);
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setFocusable(false);
        
        
        tableDanhSachNhanVien.addMouseListener(this);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnXoa)
                .addGap(318, 318, 318)
                .addComponent(btnChinhSua)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(185, 185, 185))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cmbBoxDanhMuc, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cmbBoxQuyenDangNhap, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtMatKhau)))
                    .addComponent(jLabel12)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(chkNu)))
                                    .addGap(60, 60, 60)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel3)
                                .addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(44, 44, 44))
                                .addComponent(txtSDT)
                                .addComponent(jLabel4)
                                .addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimKiem)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTimKiem, GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbBoxDanhMuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkNu)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26))
                                    .addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(26, 26, 26)))
                                    .addGap(94, 94, 94)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbBoxQuyenDangNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChinhSua)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addGap(11, 11, 11))
        );
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
					JOptionPane.showMessageDialog(this,"Mã nhân viên trùng");
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(this,"Thêm thành công");
				removeForm();
				loadEmployeesData();
			} catch (ParseException e) {
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
				model.addRow(new Object[] { emp.getMaNhanVien(), emp.getHoTen(), emp.getGioiTinh(), emp.getNgaySinh(),emp.getSoDT(),emp.getDiaChi(),
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
					int t1 = JOptionPane.showConfirmDialog(null, "bạn có muốn sửa ?", "Sửa", JOptionPane.YES_NO_OPTION);
					if (t1 == JOptionPane.YES_OPTION && nv!=null) {
						String maNV = tableDanhSachNhanVien.getValueAt(row, 0).toString();
						try {
							dao.updateEmployeeInfoByID(maNV, nv);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(this,"Sửa thông tin nhân viên thành công");
						loadEmployeesData();
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
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


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(btnTimKiem)) {
			int idx = cmbBoxDanhMuc.getSelectedIndex();
			String key = txtTimKiem.getText().trim();
			switch (idx) {
			case 0: {
				model.getDataVector().removeAllElements();
				try {
					NhanVien emp = dao.getEmployeeByID(key);
					model.addRow(new Object[] { emp.getMaNhanVien(), emp.getHoTen(), emp.getGioiTinh(), emp.getNgaySinh(),emp.getSoDT(),emp.getDiaChi(),
								emp.getQuyenTryCap() });

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại");
					ex.printStackTrace();
				}
				break;
			}
			case 1: {
				model.getDataVector().removeAllElements();
				try {
					NhanVien emp = dao.getEmployeeByID(key);
					model.addRow(new Object[] { emp.getMaNhanVien(), emp.getHoTen(), emp.getGioiTinh(), emp.getNgaySinh(),emp.getSoDT(),emp.getDiaChi(),
								emp.getQuyenTryCap() });

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại");
					ex.printStackTrace();
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idx);
			}
		}
		else if(e.getSource().equals(tableDanhSachNhanVien)) {
			
			int idx = tableDanhSachNhanVien.getSelectedRow();
			txtMaNhanVien.setText(tableDanhSachNhanVien.getValueAt(idx, 0).toString());
			
			txtHoTen.setText(tableDanhSachNhanVien.getValueAt(idx, 1).toString());
			
			if(tableDanhSachNhanVien.getValueAt(idx, 2).toString().equals("Nữ")) {
				chkNu.setSelected(true);
			}
			txtNgaySinh.setText(tableDanhSachNhanVien.getValueAt(idx, 3).toString());
			
			txtSDT.setText(tableDanhSachNhanVien.getValueAt(idx, 4).toString());
			
			txtDiaChi.setText(tableDanhSachNhanVien.getValueAt(idx, 5).toString());
			
			if(tableDanhSachNhanVien.getValueAt(idx, 6).toString().equalsIgnoreCase("user")) {
				
				cmbBoxQuyenDangNhap.setSelectedIndex(0);
				
			}else {
				
				cmbBoxQuyenDangNhap.setSelectedIndex(1);
			}
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(txtTimKiem)) {
			int idx = cmbBoxDanhMuc.getSelectedIndex();
			String key = txtTimKiem.getText().trim();
			key = key.toUpperCase() + "%";
			switch (idx) {
			case 0: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<NhanVien> NV = dao.getCusBySTD(key);
					
					for (NhanVien nv : NV)
						model.addRow(new Object[] { nv.getMaNhanVien(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(),nv.getSoDT(),nv.getDiaChi(),
								nv.getQuyenTryCap() });

				} catch (SQLException ex) {
//					return;
//					JOptionPane.showMessageDialog(this,"Khong co linh kien");
//					ex.printStackTrace();
				}
				break;
			}
			case 1: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<NhanVien> NV = dao.getCusByName(key);
					
					for (NhanVien nv : NV)
						model.addRow(new Object[] { nv.getMaNhanVien(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(),nv.getSoDT(),nv.getDiaChi(),
								nv.getQuyenTryCap() });

				} catch (SQLException ex) {
//					return;
//					JOptionPane.showMessageDialog(this,"Khong co linh kien");
//					ex.printStackTrace();
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idx);
			}
			if(txtTimKiem.getText().trim().equals("")) {
				loadEmployeesData();
				tableDanhSachNhanVien.clearSelection();
			}
		}
	}
}