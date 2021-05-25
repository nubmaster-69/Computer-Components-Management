package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import dao.LinhKienDAO;
import entity.KhachHang;
import entity.LinhKien;

public class PanelHangCoSan extends javax.swing.JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton btnLamMoi;
	private javax.swing.JButton btnTaoDon;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableDonHang;
	private javax.swing.JTable tableHangCoSan;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtSDT;
	private DefaultTableModel model;
	private DefaultTableModel modelTaoDonHang;
	private KhachHangDAO khachHangDAO;
	
	public PanelHangCoSan() {
		initComponents();
		khachHangDAO = new KhachHangDAO();
	}
	
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableHangCoSan = new javax.swing.JTable();
		btnTaoDon = new javax.swing.JButton();
		btnLamMoi = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		txtHoTen = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtDiaChi = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtSoLuong = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtSDT = new javax.swing.JTextField();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setText("Danh sách sản phẩm tại cửa hàng");

		model = new DefaultTableModel(new String[] { "Mã linh kiện", "Tên linh kiện", "Loại linh kiện", "Thương hiệu",
				"Giá", "Số lượng", "Chọn" }, 0);

		tableHangCoSan = new javax.swing.JTable(model) {

			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;

				default:
					return Boolean.class;
				}
			}
		};
		
		tableHangCoSan.addMouseListener(this);
		
		jScrollPane1.setViewportView(tableHangCoSan);
		if (tableHangCoSan.getColumnModel().getColumnCount() > 0) {
			tableHangCoSan.getColumnModel().getColumn(0).setResizable(false);
			tableHangCoSan.getColumnModel().getColumn(1).setResizable(false);
			tableHangCoSan.getColumnModel().getColumn(2).setResizable(false);
			tableHangCoSan.getColumnModel().getColumn(3).setResizable(false);
			tableHangCoSan.getColumnModel().getColumn(4).setResizable(false);
			tableHangCoSan.getColumnModel().getColumn(5).setResizable(false);
			tableHangCoSan.getColumnModel().getColumn(6).setResizable(false);
		}

		btnTaoDon.setText("Tạo đơn hàng");
		btnTaoDon.addActionListener(this);

		btnLamMoi.setText("Làm mới");
		btnLamMoi.addActionListener(this);

		jLabel2.setText("Họ và tên khách hàng");
		
		jLabel4.setText("Địa chỉ");

		tableDonHang = new javax.swing.JTable(modelTaoDonHang = new DefaultTableModel(
				new String[] { "Mã linh kiện", "Tên linh kiện", "Loại linh kiện", "Thương hiệu", "Số lượng", "Giá" },
				0));

		jScrollPane2.setViewportView(tableDonHang);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel5.setText("Tạo đơn hàng mới");

		jLabel6.setText("Số lượng mua");

		jLabel7.setText("Số điện thoại");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGap(281, 281, 281).addComponent(btnLamMoi))
						.addGroup(layout.createSequentialGroup().addGap(123, 123, 123).addComponent(jLabel1)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnTaoDon).addGap(172, 172, 172))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		false)
																.addComponent(txtDiaChi,
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(txtHoTen,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel4)).addGap(58, 58, 58)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(txtSDT).addComponent(jLabel6)
																.addComponent(jLabel7).addComponent(txtSoLuong,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 194,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addGroup(layout.createSequentialGroup().addGap(112, 112, 112).addComponent(jLabel5)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1).addComponent(jLabel5))
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
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
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
										jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnTaoDon).addComponent(btnLamMoi))
						.addContainerGap()));
		loadProductsData();
	}

	private void btnTaoDonActionPerformed() {
		String cusID = Integer.parseInt(khachHangDAO.getLastCustomerID()) + 1 + "";
		
		if(validateCusData()) {
			KhachHang cus = new KhachHang(cusID, txtHoTen.getText().trim(), txtSDT.getText().trim(),
					txtDiaChi.getText().trim());
			try {
				khachHangDAO.addCustomer(cus);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private boolean validateCusData() {
		String hoTen = txtHoTen.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		int soLuong = Integer.parseInt(txtSoLuong.getText().trim());

		if (hoTen.trim().equals("")) {
			showMsg("Họ tên khách hàng trống !");
			txtHoTen.selectAll();
			txtHoTen.requestFocus();
			return false;
		} else {

			if ((hoTen.matches(
					"^[a-zA-Z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]"))) {
				showMsg("tên khách hàng không hợp lệ");
				txtHoTen.requestFocus();
				txtHoTen.selectAll();
				return false;
			}
		}

		if (sdt.trim().equals("")) {
			showMsg("Số điện thoại khách hàng trống !");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		} else {

			if (!(sdt.matches("^[0-9]{10}$"))) {
				showMsg("Số điện thoại khách hàng không hợp lệ");
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return false;
			}
		}

		if (diaChi.trim().equals("")) {
			showMsg("Địa chỉ không được trống !");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		} else {

			if (diaChi.matches(
					"^[a-z0-9A-Z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]")) {
				showMsg("Địa chỉ không hợp lê");
				txtDiaChi.requestFocus();
				txtDiaChi.selectAll();
				return false;

			}
		}

		return true;
	}
	
	private void btnLamMoiActionPerformed() {
		if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn làm mới đơn hàng?", "Xác nhận", JOptionPane.YES_NO_OPTION) == 0) {
			uncheckedAll();
			clearModel();
			tableHangCoSan.clearSelection();
		}
	}
	
	private void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void clearModel() {
		modelTaoDonHang.setRowCount(0);
	}
	
	private void uncheckedAll() {
		int len = tableHangCoSan.getRowCount();
		for(int i = 0; i < len; i++)
			tableHangCoSan.setValueAt(false, i, 6);
	}
	
	private void loadProductsData() {
		try {
			ArrayList<LinhKien> comps = new LinhKienDAO().getComponents();
			
			for (LinhKien comp : comps)
				model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getThuongHieu(),
						comp.getDonGia(), comp.getSoLuongTon(), false });

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnTaoDon))
			btnTaoDonActionPerformed();
		else if(o.equals(btnLamMoi))
			btnLamMoiActionPerformed();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int idx = tableHangCoSan.getSelectedRow();
		
		if(Boolean.parseBoolean(tableHangCoSan.getValueAt(idx, 6).toString())) {
			modelTaoDonHang.addRow(new Object[] {
					tableHangCoSan.getValueAt(idx, 0),
					tableHangCoSan.getValueAt(idx, 1),
					tableHangCoSan.getValueAt(idx, 2),
					tableHangCoSan.getValueAt(idx, 3),
					tableHangCoSan.getValueAt(idx, 5),
					tableHangCoSan.getValueAt(idx, 4)
			});
		}
		else {
			for(int i = 0; i < tableDonHang.getRowCount(); i++) {
				if(tableDonHang.getValueAt(i, 0).toString().equalsIgnoreCase(tableHangCoSan.getValueAt(idx, 0).toString()))
					modelTaoDonHang.removeRow(i);
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
}
