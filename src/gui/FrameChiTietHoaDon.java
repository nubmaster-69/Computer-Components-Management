/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDonDAO;

public class FrameChiTietHoaDon extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public FrameChiTietHoaDon(String maHD) {
		initComponents(maHD);
	}

	private void initComponents(String maHD) {

		jLabel1 = new javax.swing.JLabel();
		txtHoTen = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtDiaChi = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		jLabel6 = new javax.swing.JLabel();
		txtMaKhachHang = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtSDT = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setText("Chi tiết hóa đơn");

		txtHoTen.setEditable(false);
		txtHoTen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtHoTenActionPerformed(evt);
			}
		});

		jLabel4.setText("Địa chỉ");

		txtDiaChi.setEditable(false);
		tableDonHang = new javax.swing.JTable(model = new DefaultTableModel(
				new String[] { "Mã linh kiện", "Tên linh kiện", "Loại linh kiện", "Thương hiệu", "Số lượng", "Giá" },
				0));

		jScrollPane2.setViewportView(tableDonHang);

		jLabel6.setText("Mã khách hàng");

		txtMaKhachHang.setEditable(false);

		jLabel7.setText("Số điện thoại");

		txtSDT.setEditable(false);

		jLabel2.setText("Họ và tên khách hàng");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(133, 133, 133).addComponent(jLabel1)
						.addContainerGap(154, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel4)).addGap(58, 58, 58)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(txtSDT).addComponent(jLabel6).addComponent(jLabel7)
												.addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
														194, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addContainerGap(458,
						Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(57, 57, 57)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel7)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGap(58, 58, 58))));
		loadData(maHD);
		pack();
		setLocationRelativeTo(null);
	}

	private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void loadData(String maHD) {

		try {
			ArrayList<String> cthds = new ChiTietHoaDonDAO().getBillDetailByBillID(maHD);

			for (String cthd : cthds) {
				String[] str = cthd.split(";");

				txtHoTen.setText(str[0]);
				txtMaKhachHang.setText(str[1]);
				txtDiaChi.setText(str[2]);
				txtSDT.setText(str[3]);

				model.addRow(new Object[] { str[4], str[5], str[6], str[7], str[8], str[9] });
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableDonHang;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtMaKhachHang;
	private javax.swing.JTextField txtSDT;
	private DefaultTableModel model;
}
