package gui;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDAO;
import entity.HoaDon;

public class PanelDanhSachHoaDon extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;

	private JButton btnTimKiem;
	private JButton btnXem;
	private JComboBox<String> cmbBoxDanhMuc;
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JTextField txtTimKiem;
	private DefaultTableModel model;

	public PanelDanhSachHoaDon() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable(model = new DefaultTableModel(
				new String[] { "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày lập hóa đơn" }, 0));
		jLabel1 = new JLabel();
		btnXem = new JButton();
		jLabel3 = new JLabel();
		cmbBoxDanhMuc = new JComboBox<>();
		txtTimKiem = new JTextField();
		btnTimKiem = new JButton();

		jScrollPane1.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setResizable(false);
			jTable1.getColumnModel().getColumn(1).setResizable(false);
			jTable1.getColumnModel().getColumn(2).setResizable(false);
			jTable1.getColumnModel().getColumn(3).setResizable(false);
		}

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setText("Danh sách hóa đơn");

		btnXem.setText("Xem");
		btnXem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXemActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel3.setText("Danh mục");

		cmbBoxDanhMuc.setModel(new DefaultComboBoxModel<>(
				new String[] { "Mã linh kiện", "Tên linh kiện", "Loại linh kiện", "Thương hiệu" }));

		btnTimKiem.setIcon(new ImageIcon(getClass().getResource("/img/loupe.png")));
		btnTimKiem.setBorderPainted(false);
		btnTimKiem.setContentAreaFilled(false);
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setFocusable(false);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btnXem)
										.addGap(499, 499, 499))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jLabel1)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel3).addGap(18, 18, 18)
										.addComponent(cmbBoxDanhMuc, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addGap(123, 123, 123).addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 278,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnTimKiem)
								.addGap(0, 0, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(btnTimKiem)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(txtTimKiem, GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3).addComponent(cmbBoxDanhMuc, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(18, 18, 18).addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE).addGap(18, 18, 18)
						.addComponent(btnXem).addContainerGap()));
		loadBillsData();
	}

	private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {
		int idx = jTable1.getSelectedRow();

		if (idx != -1) {
			String maHD = jTable1.getValueAt(idx, 0).toString();
			if (!maHD.isEmpty())
				new FrameChiTietHoaDon(maHD).setVisible(true);
		}

	}

	private void loadBillsData() {
		try {
			ArrayList<HoaDon> bills = new HoaDonDAO().getBills();

			for (HoaDon bill : bills)
				model.addRow(new Object[] { bill.getMaHoaDon(), bill.getMaNhanVien().getMaNhanVien(),
						bill.getMaKhachHang().getMaKH(), bill.getNgayLapHD() });

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
