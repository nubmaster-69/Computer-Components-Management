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
import entity.KhachHang;

public class PanelDanhSachKhachHang extends javax.swing.JPanel implements ActionListener, MouseListener{

    private static final long serialVersionUID = 1L;
    
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDanhSachKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKhachHang;
    private DefaultTableModel model;
    KhachHangDAO khachHangDAO;
    
    public PanelDanhSachKhachHang() {
        initComponents();
        khachHangDAO = new KhachHangDAO();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDanhSachKhachHang = new javax.swing.JTable(model = new DefaultTableModel(new String[] { "Mã khách hàng", "Tên khách hàng", "SDT", "Địa chỉ" },0));
        tableDanhSachKhachHang.addMouseListener(this);
        btnChinhSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();

        jScrollPane1.setViewportView(tableDanhSachKhachHang);
        if (tableDanhSachKhachHang.getColumnModel().getColumnCount() > 0) {
            tableDanhSachKhachHang.getColumnModel().getColumn(0).setResizable(false);
            tableDanhSachKhachHang.getColumnModel().getColumn(1).setResizable(false);
            tableDanhSachKhachHang.getColumnModel().getColumn(2).setResizable(false);
            tableDanhSachKhachHang.getColumnModel().getColumn(3).setResizable(false);
        }

        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(this);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách khách hàng");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(this);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Thông tin khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tên khách hàng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Mã khách hàng");

        txtMaKhachHang.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Số điện thoại");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Địa chỉ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnXoa)
                        .addGap(426, 426, 426))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDiaChi)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnChinhSua)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChinhSua)
                    .addComponent(btnXoa))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        loadCustomersData();
    }

    private void btnXoaActionPerformed() {
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa ?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
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
    
    private boolean regex(){
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
			if(regex()) {
				kh = getKhachHang();
			}
			int t1 = JOptionPane.showConfirmDialog(null, "bạn có muốn sửa ?", "Sửa", JOptionPane.YES_NO_OPTION);
			if (t1 == JOptionPane.YES_OPTION && kh!=null) {
				String maKH = tableDanhSachKhachHang.getValueAt(row, 0).toString();
				try {
					khachHangDAO.updateCustomerInfoByID(maKH, kh);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(this,"Sửa thông tin Khách hàng thành công");
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
    	int idx = tableDanhSachKhachHang.getSelectedRow();
    	txtTenKhachHang.setText(tableDanhSachKhachHang.getValueAt(idx, 1).toString());
    	txtMaKhachHang.setText(tableDanhSachKhachHang.getValueAt(idx, 0).toString());
    	txtSDT.setText(tableDanhSachKhachHang.getValueAt(idx, 2).toString());
    	txtDiaChi.setText(tableDanhSachKhachHang.getValueAt(idx, 3).toString());
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
		
		if(o.equals(btnXoa))
			btnXoaActionPerformed();
		else if(o.equals(btnChinhSua))
			btnChinhSuaActionPerformed();
		
	}
}
