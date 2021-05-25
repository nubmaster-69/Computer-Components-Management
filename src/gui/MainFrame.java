package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JOptionPane;

public abstract class MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	protected javax.swing.JButton btnDonHang;
	protected javax.swing.JButton btnHoaDon;
	protected javax.swing.JButton btnKhachHang;
	protected javax.swing.JButton btnNhanVien;
	protected javax.swing.JButton btnSanPham;
	protected javax.swing.JButton btnThoat;
	protected javax.swing.JButton btnThongKe;
	protected javax.swing.JButton btnTimKiem;
	protected javax.swing.JLabel jLabel1;
	protected javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JPanel mainPanel;
	protected javax.swing.JPanel menuPanel;
	private javax.swing.JPanel panelHeader;
	protected javax.swing.JTextField txtTimKiem;

	public MainFrame() {
		initComponents();
		mainPanel.setLayout(new BorderLayout());
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		panelHeader = new javax.swing.JPanel();
		txtTimKiem = new javax.swing.JTextField();
		btnTimKiem = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		menuPanel = new javax.swing.JPanel();
		btnDonHang = new javax.swing.JButton();
		btnSanPham = new javax.swing.JButton();
		btnKhachHang = new javax.swing.JButton();
		btnHoaDon = new javax.swing.JButton();
		btnThongKe = new javax.swing.JButton();
		btnThoat = new javax.swing.JButton();
		btnNhanVien = new javax.swing.JButton();
		mainPanel = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jMenu1.setText("jMenu1");

		jMenu2.setText("jMenu2");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Ứng dụng quản lý bán linh kiện");
		setResizable(false);

		panelHeader.setBackground(new java.awt.Color(102, 153, 255));
		panelHeader.setPreferredSize(new java.awt.Dimension(400, 70));
		panelHeader.setLayout(null);

		txtTimKiem.setText("Tìm kiếm");
		txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTimKiemActionPerformed(evt);
			}
		});
		panelHeader.add(txtTimKiem);
		txtTimKiem.setBounds(290, 20, 600, 30);

		btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loupe.png")));  
		btnTimKiem.setBorderPainted(false);
		btnTimKiem.setContentAreaFilled(false);
		btnTimKiem.setFocusable(false);
		btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimKiemActionPerformed(evt);
			}
		});
		panelHeader.add(btnTimKiem);
		btnTimKiem.setBounds(900, 10, 75, 50);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_IUH.png")));  
		panelHeader.add(jLabel1);
		jLabel1.setBounds(0, 0, 120, 70);

		menuPanel.setBackground(new java.awt.Color(102, 153, 255));

		btnDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-cart.png")));  
		btnDonHang.setText("Đơn hàng");
		btnDonHang.setBorderPainted(false);
		btnDonHang.setContentAreaFilled(false);
		btnDonHang.setFocusPainted(false);
		btnDonHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDonHangActionPerformed(evt);
			}
		});

		btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/box.png")));  
		btnSanPham.setText("Sản phẩm");
		btnSanPham.setBorderPainted(false);
		btnSanPham.setContentAreaFilled(false);
		btnSanPham.setFocusPainted(false);
		btnSanPham.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSanPhamActionPerformed(evt);
			}
		});

		btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/multi-users.png")));  
		btnKhachHang.setText("Khách hàng");
		btnKhachHang.setBorderPainted(false);
		btnKhachHang.setContentAreaFilled(false);
		btnKhachHang.setFocusPainted(false);
		btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnKhachHangActionPerformed(evt);
			}
		});

		btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/invoice.png")));  
		btnHoaDon.setText("Hóa đợn");
		btnHoaDon.setBorderPainted(false);
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setFocusPainted(false);
		btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHoaDonActionPerformed(evt);
			}
		});

		btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trend.png")));  
		btnThongKe.setText("Thống kê");
		btnThongKe.setBorderPainted(false);
		btnThongKe.setContentAreaFilled(false);
		btnThongKe.setFocusPainted(false);
		btnThongKe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThongKeActionPerformed(evt);
			}
		});

		btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png")));  
		btnThoat.setText("Thoát");
		btnThoat.setBorderPainted(false);
		btnThoat.setContentAreaFilled(false);
		btnThoat.setFocusPainted(false);
		btnThoat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThoatActionPerformed(evt);
			}
		});

		btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png")));  
		btnNhanVien.setText("Nhân viên");
		btnNhanVien.setBorderPainted(false);
		btnNhanVien.setContentAreaFilled(false);
		btnNhanVien.setFocusPainted(false);
		btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNhanVienActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
		menuPanel.setLayout(menuPanelLayout);
		menuPanelLayout.setHorizontalGroup(menuPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(btnDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
				.addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(btnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		menuPanelLayout.setVerticalGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(menuPanelLayout.createSequentialGroup()
						.addComponent(btnDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnNhanVien)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
						.addComponent(btnThoat)));

		btnDonHang.getAccessibleContext().setAccessibleDescription("");

		mainPanel.setBackground(new java.awt.Color(255, 255, 255));

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/welcome.jpg")));  

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel2).addGap(231, 231, 231)));
		mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup().addGap(105, 105, 105).addComponent(jLabel2)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
								.addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(mainPanel,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}

	private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {
		Object obj = evt.getSource();
		if (obj.equals(btnDonHang)) {
			btnDonHang.setContentAreaFilled(true);
			btnHoaDon.setContentAreaFilled(false);
			btnKhachHang.setContentAreaFilled(false);
			btnSanPham.setContentAreaFilled(false);
			btnThongKe.setContentAreaFilled(false);
			btnNhanVien.setContentAreaFilled(false);

			mainPanel.removeAll();
			PanelHangCoSan panelDS = new PanelHangCoSan();
			mainPanel.add(panelDS, BorderLayout.CENTER);
			mainPanel.repaint();
			mainPanel.revalidate();
		}
	}

	private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
		btnDonHang.setContentAreaFilled(false);
		btnHoaDon.setContentAreaFilled(false);
		btnKhachHang.setContentAreaFilled(false);
		btnSanPham.setContentAreaFilled(true);
		btnThongKe.setContentAreaFilled(false);
		btnNhanVien.setContentAreaFilled(false);

		mainPanel.removeAll();
		PanelDanhSachSanPham panelDS = new PanelDanhSachSanPham();
		mainPanel.add(panelDS, BorderLayout.WEST);
		mainPanel.repaint();
		mainPanel.revalidate();
	}

	private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {
		btnDonHang.setContentAreaFilled(false);
		btnHoaDon.setContentAreaFilled(false);
		btnKhachHang.setContentAreaFilled(true);
		btnSanPham.setContentAreaFilled(false);
		btnThongKe.setContentAreaFilled(false);
		btnNhanVien.setContentAreaFilled(false);

		mainPanel.removeAll();
		PanelDanhSachKhachHang panelDS = new PanelDanhSachKhachHang();
		mainPanel.add(panelDS, BorderLayout.CENTER);
		mainPanel.repaint();
		mainPanel.revalidate();
	}

	private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {
		btnDonHang.setContentAreaFilled(false);
		btnHoaDon.setContentAreaFilled(true);
		btnKhachHang.setContentAreaFilled(false);
		btnSanPham.setContentAreaFilled(false);
		btnThongKe.setContentAreaFilled(false);
		btnNhanVien.setContentAreaFilled(false);

		mainPanel.removeAll();
		PanelDanhSachHoaDon panelDS = new PanelDanhSachHoaDon();
		mainPanel.add(panelDS, BorderLayout.CENTER);
		mainPanel.repaint();
		mainPanel.revalidate();
	}

	private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {
		mainPanel.removeAll();
		javax.swing.JLabel result = new javax.swing.JLabel("Không tìm thấy từ khóa cần tìm");
		result.setFont(new Font("Tahoma", 2, 72));
		result.setLocation(550, 400);
		mainPanel.add(result, BorderLayout.CENTER);
		mainPanel.repaint();
		mainPanel.revalidate();
	}

	private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {
		int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát ?");
		if (confirm == 0)
			System.exit(0);
	}

	private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {
		btnDonHang.setContentAreaFilled(false);
		btnHoaDon.setContentAreaFilled(false);
		btnKhachHang.setContentAreaFilled(false);
		btnSanPham.setContentAreaFilled(false);
		btnThongKe.setContentAreaFilled(true);
		btnNhanVien.setContentAreaFilled(false);

		mainPanel.removeAll();
		PanelThongKe panelTK = new PanelThongKe();
		mainPanel.add(panelTK, BorderLayout.CENTER);
		mainPanel.repaint();
		mainPanel.revalidate();
	}

	private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {
		btnDonHang.setContentAreaFilled(false);
		btnHoaDon.setContentAreaFilled(false);
		btnKhachHang.setContentAreaFilled(false);
		btnSanPham.setContentAreaFilled(false);
		btnThongKe.setContentAreaFilled(false);
		btnNhanVien.setContentAreaFilled(true);

		mainPanel.removeAll();
		PanelDanhSachNhanVien panelNV = new PanelDanhSachNhanVien();
		mainPanel.add(panelNV, BorderLayout.CENTER);
		mainPanel.repaint();
		mainPanel.revalidate();
	}
}
