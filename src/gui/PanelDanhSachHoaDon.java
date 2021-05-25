package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.HoaDonDAO;
import entity.HoaDon;

public class PanelDanhSachHoaDon extends javax.swing.JPanel implements MouseListener{
    
    private static final long serialVersionUID = 1L;

    public PanelDanhSachHoaDon() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(model = new DefaultTableModel(
        		new String [] {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày lập hóa đơn"},0));
        jLabel1 = new javax.swing.JLabel();
        btnXem = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách hóa đơn");

        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(429, 429, 429))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnXem)
                        .addGap(515, 515, 515))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loadBillsData();
    }

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {
    	int idx = jTable1.getSelectedRow();
    	
    	if(idx != -1) {
    		String maHD = jTable1.getValueAt(idx, 0).toString();
    		if(!maHD.isEmpty())
    			new FrameChiTietHoaDon(maHD).setVisible(true);
    	}
    	
    }

    private void loadBillsData() {
    	try {
			ArrayList<HoaDon> bills = new HoaDonDAO().getBills();
			
			for(HoaDon bill : bills)
				model.addRow(new Object[] {
						bill.getMaHoaDon(), bill.getMaNhanVien().getMaNhanVien(), bill.getMaKhachHang().getMaKH(), bill.getNgayLapHD()
				});
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private javax.swing.JButton btnXem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private DefaultTableModel model;

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
