package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import entity.KhachHang;

public class PanelDanhSachKhachHang extends JPanel implements ActionListener, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JButton btnChinhSua;
	private JButton btnTimKiem;
	private JButton btnXoa;
	private JComboBox<String> cmbBoxDanhMuc;
	private JLabel jLabel1;
	private JLabel jLabel12;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JScrollPane jScrollPane1;
	private JTable tableDanhSachKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtMaKhachHang;
	private JTextField txtSDT;
	private JTextField txtTenKhachHang;
	private JTextField txtTimKiem;
	private DefaultTableModel model;
	KhachHangDAO khachHangDAO;

	public PanelDanhSachKhachHang() {
		initComponents();
		khachHangDAO = new KhachHangDAO();
	}

	private void initComponents() {

		jScrollPane1 = new JScrollPane();
		tableDanhSachKhachHang = new JTable(
				model = new DefaultTableModel(new String[] { "Mã khách hàng", "Tên khách hàng", "SDT", "Địa chỉ" }, 0));
		tableDanhSachKhachHang.addMouseListener(this);
		btnChinhSua = new JButton();
		jLabel1 = new JLabel();
		btnXoa = new JButton();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		txtTenKhachHang = new JTextField();
		jLabel4 = new JLabel();
		txtMaKhachHang = new JTextField();
		jLabel5 = new JLabel();
		txtSDT = new JTextField();
		jLabel6 = new JLabel();
		txtDiaChi = new JTextField();
		jLabel12 = new JLabel();
		cmbBoxDanhMuc = new JComboBox<>();
		txtTimKiem = new JTextField();
		btnTimKiem = new JButton();

		jScrollPane1.setViewportView(tableDanhSachKhachHang);
		if (tableDanhSachKhachHang.getColumnModel().getColumnCount() > 0) {
			tableDanhSachKhachHang.getColumnModel().getColumn(0).setResizable(false);
			tableDanhSachKhachHang.getColumnModel().getColumn(1).setResizable(false);
			tableDanhSachKhachHang.getColumnModel().getColumn(2).setResizable(false);
			tableDanhSachKhachHang.getColumnModel().getColumn(3).setResizable(false);
		}

		btnTimKiem.addMouseListener(this);

		btnChinhSua.setText("Chỉnh sửa");
		btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChinhSuaActionPerformed();
			}
		});

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setText("Danh sách khách hàng");

		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed();
			}
		});

		txtTimKiem.addKeyListener(this);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel2.setText("Thông tin khách hàng");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel3.setText("Tên khách hàng");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel4.setText("Mã khách hàng");

		txtMaKhachHang.setEditable(false);

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel5.setText("Số điện thoại");

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel6.setText("Địa chỉ");

		jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel12.setText("Danh mục");

		cmbBoxDanhMuc.setModel(
				new DefaultComboBoxModel<>(new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại" }));

		btnTimKiem.setIcon(new ImageIcon(getClass().getResource("/img/loupe.png")));
		btnTimKiem.setBorderPainted(false);
		btnTimKiem.setContentAreaFilled(false);
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setFocusable(false);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 799, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(365, 365, 365).addComponent(btnXoa)))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
								.addComponent(btnChinhSua).addGap(107, 107, 107))
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5)
												.addComponent(jLabel6).addComponent(txtSDT).addComponent(txtMaKhachHang)
												.addComponent(txtTenKhachHang, GroupLayout.Alignment.TRAILING)
												.addComponent(txtDiaChi, GroupLayout.Alignment.TRAILING))
										.addContainerGap())))
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(layout
										.createParallelGroup(
												GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addContainerGap()
												.addComponent(jLabel12).addGap(18, 18, 18)
												.addComponent(cmbBoxDanhMuc, GroupLayout.PREFERRED_SIZE, 130,
														GroupLayout.PREFERRED_SIZE)
												.addGap(123, 123, 123)
												.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 278,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnTimKiem).addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup().addGap(229, 229, 229)
												.addComponent(jLabel1)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 294,
														GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(btnTimKiem)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(txtTimKiem, GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel12).addComponent(cmbBoxDanhMuc, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(jLabel2))
				.addGap(18, 18, 18)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(btnChinhSua).addComponent(btnXoa)))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtTenKhachHang, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jLabel4)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtMaKhachHang, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jLabel5)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jLabel6)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		loadCustomersData();
	}

	private void btnXoaActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa ?", "Xác nhận",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (confirm == 0) {
			while (tableDanhSachKhachHang.getSelectedRowCount() != 0) {
				int selectedRow = tableDanhSachKhachHang.getSelectedRow();
				String maKH = tableDanhSachKhachHang.getValueAt(selectedRow, 0).toString();
				try {
					if (khachHangDAO.removeCustomerByID(maKH))
						model.removeRow(selectedRow);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		txtDiaChi.setText("");
		txtMaKhachHang.setText("");
		txtSDT.setText("");
		txtTenKhachHang.setText("");
	}

	private void btnChinhSuaActionPerformed() {
		sua();
	}

	private void loadCustomersData() {
		model.getDataVector().removeAllElements();
		try {
			ArrayList<KhachHang> customers = new KhachHangDAO().getCustomers();

			for (KhachHang cus : customers)
				model.addRow(new Object[] { cus.getMaKH(), cus.getHoTen(), cus.getSoDT(), cus.getDiaChi() });

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean regex() {
		String tenKH = txtTenKhachHang.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();

		if (!(tenKH.length() > 0 && sdt.length() > 0 && diaChi.length() > 0 && sdt.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Phải nhập đủ thông tin");
		}

		if (!(tenKH.length() > 0)) {
			txtTenKhachHang.requestFocus();
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

		if (!(tenKH.matches(
				"^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$"))) {
			JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
			txtTenKhachHang.requestFocus();
			txtTenKhachHang.selectAll();
			return false;
		}

		if (!(sdt.matches("^0[0-9]{9}$"))) {
			JOptionPane.showInternalMessageDialog(this, "Số điện thoại k hợp lệ");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}

		return true;
	}

	private void sua() {

		int row = tableDanhSachKhachHang.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(null, "chọn dòng muốn sửa");
			return;
		} else {
			KhachHang kh = null;
			if (regex()) {
				kh = getKhachHang();
			}
			int t1 = JOptionPane.showConfirmDialog(null, "bạn có muốn sửa ?", "Sửa", JOptionPane.YES_NO_OPTION);
			if (t1 == JOptionPane.YES_OPTION && kh != null) {
				String maKH = tableDanhSachKhachHang.getValueAt(row, 0).toString();
				try {
					khachHangDAO.updateCustomerInfoByID(maKH, kh);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Sửa thông tin Khách hàng thành công");
				loadCustomersData();
			}
		}
		tableDanhSachKhachHang.clearSelection();
	}

	private KhachHang getKhachHang() {

		String tenKH = txtTenKhachHang.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String maKH = txtMaKhachHang.getText().trim();

		return new KhachHang(maKH, tenKH, sdt, diaChi);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(btnTimKiem)) {
			int idx = cmbBoxDanhMuc.getSelectedIndex();
			String key = txtTimKiem.getText().trim();
			switch (idx) {
			case 0: {
				model.getDataVector().removeAllElements();
				try {
					KhachHang cus = khachHangDAO.getCustomerByID(key);
					model.addRow(new Object[] { cus.getMaKH(), cus.getHoTen(), cus.getSoDT(), cus.getDiaChi() });
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idx);
			}
		} else if (e.getSource().equals(tableDanhSachKhachHang)) {
			int idx = tableDanhSachKhachHang.getSelectedRow();
			txtTenKhachHang.setText(tableDanhSachKhachHang.getValueAt(idx, 1).toString());
			txtMaKhachHang.setText(tableDanhSachKhachHang.getValueAt(idx, 0).toString());
			txtSDT.setText(tableDanhSachKhachHang.getValueAt(idx, 2).toString());
			txtDiaChi.setText(tableDanhSachKhachHang.getValueAt(idx, 3).toString());

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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnXoa))
			btnXoaActionPerformed();
		else if (o.equals(btnChinhSua))
			btnChinhSuaActionPerformed();

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
			int idx = cmbBoxDanhMuc.getSelectedIndex();
			String key = txtTimKiem.getText().trim();
			key = key.toUpperCase() + "%";
			switch (idx) {
			case 0: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<KhachHang> Cus = khachHangDAO.getCusByID(key);
					for (KhachHang cus : Cus)
						model.addRow(new Object[] { cus.getMaKH(), cus.getHoTen(), cus.getSoDT(), cus.getDiaChi() });
				} catch (SQLException ex) {

				}
				break;
			}
			case 1: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<KhachHang> Cus = khachHangDAO.getCusByName(key);
					for (KhachHang cus : Cus)
						model.addRow(new Object[] { cus.getMaKH(), cus.getHoTen(), cus.getSoDT(), cus.getDiaChi() });

				} catch (SQLException ex) {

				}
				break;
			}
			case 2: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<KhachHang> Cus = khachHangDAO.getCusBySTD(key);

					for (KhachHang cus : Cus)
						model.addRow(new Object[] { cus.getMaKH(), cus.getHoTen(), cus.getSoDT(), cus.getDiaChi() });

				} catch (SQLException ex) {

				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idx);
			}
			if (txtTimKiem.getText().trim().equals("")) {
				System.out.print("here");
				loadCustomersData();
				tableDanhSachKhachHang.clearSelection();
			}

		}
	}
}