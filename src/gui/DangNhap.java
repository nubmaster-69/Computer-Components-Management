package gui;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.NhanVienDAO;
import entity.NhanVien;

public class DangNhap extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private javax.swing.JButton btnDangNhap;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPasswordField txtMatKhau;
	private javax.swing.JTextField txtTenDangNhap;
	NhanVienDAO dao;

	public DangNhap() {
		initComponents();
		dao = new NhanVienDAO();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtTenDangNhap = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtMatKhau = new javax.swing.JPasswordField();
		btnDangNhap = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Ứng dụng mua bán linh kiện");
		setResizable(false);
		

		jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
		jLabel1.setText("Đăng nhập nhân viên");

		jLabel2.setText("Tên đăng nhập: ");

		jLabel3.setText("Mật khẩu: ");

		btnDangNhap.setText("Đăng nhập");
		
		btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnDangNhapMouseClicked();
			}
		});
		
		btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDangNhapActionPerformed();
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_IUH.png"))); // NOI18N
		jButton2.setBorderPainted(false);
		jButton2.setContentAreaFilled(false);
		jButton2.setFocusable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(38, 38, 38)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
						.addComponent(jButton2))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel3).addComponent(jLabel2)
										.addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 350,
												Short.MAX_VALUE)
										.addComponent(txtMatKhau))
								.addGap(0, 0, Short.MAX_VALUE))))
				.addGroup(layout.createSequentialGroup().addGap(169, 169, 169).addComponent(btnDangNhap).addGap(0, 0,
						Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jButton2))
				.addGap(20, 20, 20).addComponent(jLabel2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18).addComponent(jLabel3)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(33, 33, 33).addComponent(btnDangNhap).addContainerGap(32, Short.MAX_VALUE)));

		txtTenDangNhap.setText("19521341");
		txtMatKhau.setText("admin");
		
		pack();
		setLocationRelativeTo(null);
	}

	private void btnDangNhapActionPerformed() {

		if (validateAccount()) {
			try {
				String userRole = dao.getEmployeeRole(txtTenDangNhap.getText().trim());
				NhanVien nv = dao.getEmployeeByID(txtTenDangNhap.getText().trim());
				if (userRole.equalsIgnoreCase("admin"))
					new AdminFrame(nv).setVisible(true);
				else
					new EmployeeFrame(nv).setVisible(true);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.dispose();
		}
	}

	private void btnDangNhapMouseClicked() {
		btnDangNhapActionPerformed();
	}

	private boolean validateAccount() {

		String userName = txtTenDangNhap.getText().trim();
		@SuppressWarnings("deprecation")
		String pass = txtMatKhau.getText().trim();

		NhanVien nv = null;
		try {
			nv = dao.getEmployeeByID(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (userName.isEmpty()) {
			showMsg("Tên đăng nhập không được bỏ trống!");
			return false;
		} else if (nv == null) {
			showMsg("Tên đăng nhập không tồn tại!");
			return false;
		}

		if (pass.isEmpty()) {
			showMsg("Mật khẩu không được bỏ trống!");
			return false;
		} else if (!pass.equals(nv.getMatKhau())) {
			showMsg("Mật khẩu không chính xác!");
			return false;
		}

		return true;
	}

	private void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

}
