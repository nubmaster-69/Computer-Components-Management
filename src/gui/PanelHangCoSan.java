package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.LinhKienDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

public class PanelHangCoSan extends  JPanel implements MouseListener,ActionListener,KeyListener{

    private static final long serialVersionUID = 1L;
	
    private  JButton btnLamMoi;
    private  JButton btnTaoDon;
    private  JButton btnTimKiem;
    private  JComboBox<String> cmbDanhMuc;
    private  JLabel jLabel1;
    private  JLabel jLabel2;
    private  JLabel jLabel3;
    private  JLabel jLabel4;
    private  JLabel jLabel5;
    private  JLabel jLabel6;
    private  JLabel jLabel7;
    private  JLabel jLabel8;
    private  JLabel jLabel9;
    private  JScrollPane jScrollPane1;
    private  JScrollPane jScrollPane2;
    private  JTextField jTextField1;
    private  JTextField jTextField2;
    private  JTextField jTextField3;
    private  JTable tableDonHang;
    private  JTable tableHangCoSan;
    private  JTextField txtDiaChi;
    private  JTextField txtHoTen;
    private  JTextField txtSDT;
    private  JTextField txtTimKiem;
    private DefaultTableModel model;
	private DefaultTableModel modelTaoDonHang;
	private LinhKienDAO linhKienDao;
	private KhachHangDAO khachHangDAO;
	private HoaDonDAO hoaDonDAO;
	private ChiTietHoaDonDAO chiTietHoaDonDAO;
	private DecimalFormat df;
	private NhanVien nhanVienLogin;
    
    public PanelHangCoSan(NhanVien nv) {
        initComponents();
        khachHangDAO = new KhachHangDAO();
        linhKienDao = new LinhKienDAO();
        hoaDonDAO = new HoaDonDAO();
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        nhanVienLogin = nv;
    }

    private void initComponents() {
    	df = new DecimalFormat("#,##0.00");
        jLabel1 = new  JLabel();
        jScrollPane1 = new  JScrollPane();
        tableHangCoSan = new  JTable();
        btnTaoDon = new  JButton();
        btnLamMoi = new  JButton();
        jLabel2 = new  JLabel();
        txtHoTen = new  JTextField();
        jLabel4 = new  JLabel();
        txtDiaChi = new  JTextField();
        jScrollPane2 = new  JScrollPane();
        tableDonHang = new  JTable();
        jLabel5 = new  JLabel();
        jLabel7 = new  JLabel();
        txtSDT = new  JTextField();
        jLabel3 = new  JLabel();
        cmbDanhMuc = new  JComboBox<>();
        txtTimKiem = new  JTextField();
        btnTimKiem = new  JButton();
        jLabel6 = new  JLabel();
        jLabel8 = new  JLabel();
        jLabel9 = new  JLabel();
        jTextField1 = new  JTextField();
        jTextField2 = new  JTextField();
        jTextField3 = new  JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Danh sách sản phẩm tại cửa hàng");

        model = new DefaultTableModel(new String[] { "Mã linh kiện", "Tên linh kiện", "Loại linh kiện", "Thương hiệu", "Giá", "Số lượng", "Chọn" }, 0);

		tableHangCoSan = new  JTable(model) {

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
        
        txtTimKiem.addKeyListener(this);
        
        btnTimKiem.addMouseListener(this);

        btnTaoDon.setText("Tạo đơn hàng");
        btnTaoDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDonActionPerformed();
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed();
            }
        });

        jLabel2.setText("Họ và tên khách hàng");

        jLabel4.setText("Địa chỉ");

        tableDonHang = new  JTable(modelTaoDonHang = new DefaultTableModel(
				new String[] { "Mã linh kiện", "Tên linh kiện", "Loại linh kiện", "Thương hiệu", "Số lượng", "Giá" },
				0));

        jScrollPane2.setViewportView(tableDonHang);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel5.setText("Tạo đơn hàng mới");

        jLabel7.setText("Số điện thoại");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel3.setText("Danh mục");

        cmbDanhMuc.setModel(new  DefaultComboBoxModel<>(new String[] { "Mã linh kiện", "Tên linh kiện", "Loại linh kiện", "Thương hiệu" }));

        btnTimKiem.setIcon(new  ImageIcon(getClass().getResource("/img/loupe.png"))); // NOI18N
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setContentAreaFilled(false);
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setFocusable(false);

        jLabel6.setText("Tổng thành tiền");

        jLabel8.setText("Tiền khách đưa");

        jLabel9.setText("Tiền thối lại");

        jTextField1.setEditable(false);

        jTextField3.setEditable(false);
        
        modelTaoDonHang.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				jTextField1.setText(String.valueOf(df.format(tongTien())));
			}
		});
        
        jTextField2.addKeyListener(this);

         GroupLayout layout = new  GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 656,  GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbDanhMuc,  GroupLayout.PREFERRED_SIZE, 130,  GroupLayout.PREFERRED_SIZE)
                                        .addGap(123, 123, 123)
                                        .addComponent(txtTimKiem,  GroupLayout.PREFERRED_SIZE, 278,  GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2,  GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txtHoTen,  GroupLayout.PREFERRED_SIZE, 200,  GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(134, 134, 134))
                                            .addComponent(txtSDT,  GroupLayout.PREFERRED_SIZE, 209,  GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtDiaChi)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(btnTimKiem)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextField2,  GroupLayout.PREFERRED_SIZE, 229,  GroupLayout.PREFERRED_SIZE))))
                            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(91, 91, 91))
                                    .addComponent(jTextField1,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 229,  GroupLayout.PREFERRED_SIZE)))))
                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(btnLamMoi)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoDon)
                        .addGap(135, 135, 135))
                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3,  GroupLayout.PREFERRED_SIZE, 229,  GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimKiem)
                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTimKiem,  GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbDanhMuc,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2,  GroupLayout.PREFERRED_SIZE, 216,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField2,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField3,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 448,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoDon)
                    .addComponent(btnLamMoi))
                .addContainerGap())
        );
        loadProductsData();
    }

    private void btnTaoDonActionPerformed() {
    	KhachHang checkSdt = null;
    	KhachHang cus = null;
		String newBillID = Integer.parseInt(hoaDonDAO.getLastBillID()) + 1 + "";
		if(checkSL() && validateCusData()) {
			long millis=System.currentTimeMillis();  
	        java.sql.Date ngayLapHoaDon =new java.sql.Date(millis); 
			try {
				checkSdt = khachHangDAO.getOneCusBySdt(txtSDT.getText().trim());
			}catch (Exception e) {
				checkSdt = null;
			}
			if(checkSdt != null) 
			{
				cus = checkSdt;
				if(JOptionPane.showConfirmDialog(null, "Số điện thoại đã có trong hệ thống có muốn thay đổi thông tin ??", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
					HoaDon hoadon = new HoaDon(newBillID, nhanVienLogin, cus ,ngayLapHoaDon ); 
					try {
						hoaDonDAO.addNewBill(hoadon);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for(int i = 0;i< tableDonHang.getRowCount();i++) {
						LinhKien lk = null;
						try {
							lk = linhKienDao.getComponentByID((String) tableDonHang.getValueAt(i, 0));
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int soluong = Integer.parseInt((String) tableDonHang.getValueAt(i, 4)) ;
						ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon,lk,soluong);
						try {
							chiTietHoaDonDAO.addNewBillDetail(cthd);
							lk.setSoLuongTon(lk.getSoLuongTon() - soluong);
							linhKienDao.updateComponentByID((String)tableDonHang.getValueAt(i, 0), lk);
						} catch (SQLException e) {
							e.printStackTrace();
							
						}
					}
			}
			else {
				cus = new KhachHang(cus.getMaKH(), txtHoTen.getText().trim(), txtSDT.getText().trim(),
						txtDiaChi.getText().trim());
				try {
					khachHangDAO.updateCustomerInfoByID(cus.getMaKH(), cus);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				HoaDon hoadon = new HoaDon(newBillID, nhanVienLogin, cus ,ngayLapHoaDon );
				try {
					hoaDonDAO.addNewBill(hoadon);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				for(int i = 0;i< tableDonHang.getRowCount();i++) {
					LinhKien lk = null;
					try {
						lk = linhKienDao.getComponentByID((String) tableDonHang.getValueAt(i, 0));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					int soluong = Integer.parseInt((String) tableDonHang.getValueAt(i, 4)) ;
					ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon,lk,soluong);
					try {
						chiTietHoaDonDAO.addNewBillDetail(cthd);
						lk.setSoLuongTon(lk.getSoLuongTon() - soluong);
						linhKienDao.updateComponentByID((String)tableDonHang.getValueAt(i, 0), lk);
					} catch (SQLException e) {
						e.printStackTrace();
						
					}
				}
			}
		}
		else{
				String cusID = Integer.parseInt(khachHangDAO.getLastCustomerID()) + 1 + "";
				cus = new KhachHang(cusID, txtHoTen.getText().trim(), txtSDT.getText().trim(),
						txtDiaChi.getText().trim());
			HoaDon hoadon = new HoaDon(newBillID, nhanVienLogin, cus ,ngayLapHoaDon ); 
			try {
				khachHangDAO.addCustomer(cus);
				hoaDonDAO.addNewBill(hoadon);
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			for(int i = 0;i< tableDonHang.getRowCount();i++) {
				LinhKien lk = null;
				try {
					lk = linhKienDao.getComponentByID((String) tableDonHang.getValueAt(i, 0));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int soluong = Integer.parseInt((String) tableDonHang.getValueAt(i, 4)) ;
				ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon,lk,soluong);
				try {
					chiTietHoaDonDAO.addNewBillDetail(cthd);
					lk.setSoLuongTon(lk.getSoLuongTon() - soluong);
					linhKienDao.updateComponentByID((String)tableDonHang.getValueAt(i, 0), lk);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			}
			JOptionPane.showMessageDialog(this,"Thêm thành công đơn hàng");
			clear();
		}
	}

    private void clear() {
    	txtHoTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		jTextField2.setText("");
		jTextField1.setText("");
		jTextField3.setText("");
		
		modelTaoDonHang.setRowCount(0);
		
		loadProductsData();
    }
    
    private boolean validateCusData() {
		String hoTen = txtHoTen.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String tienTra = jTextField2.getText().trim();
		String tienThoi = jTextField3.getText().trim();
		
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

		if(! (tienTra.length() > 0)) {
			showMsg("Chưa nhập tiền khách trả");
			jTextField2.selectAll();
			jTextField2.requestFocus();
			return false;
		}
		
		if(! (tienThoi.length() > 0)) {
			showMsg("Nhập lại tiền khách trả");
			jTextField2.selectAll();
			jTextField2.requestFocus();
			return false;
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
	
	private boolean checkSL() {
		int rowCount = modelTaoDonHang.getRowCount();
		if(rowCount > 0) {
			for(int i = 0 ;i< rowCount; i++) {
				if(((String)modelTaoDonHang.getValueAt(i, 4)).equals("")) {
					JOptionPane.showMessageDialog(this, "Sản phẩm " + (String)modelTaoDonHang.getValueAt(i, 0) + " chưa confirm số lượng");
					return false;
				}
			}
		}
		return true;
	}
	
	private void loadProductsData() {
		model.getDataVector().removeAllElements();
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

	
	public double tongTien() {
		double tong = 0;
		int soLuongMH = modelTaoDonHang.getRowCount();
		boolean check = true;
		String malk = "";
		String soluong = "";
		for (int i = 0;i < soLuongMH;i++ ) {
			if(modelTaoDonHang.getValueAt(i, 4).equals("")) {
				tong += 0;
			}
			else if(Integer.parseInt(model.getValueAt(i, 5).toString()) >= Integer.parseInt((String) modelTaoDonHang.getValueAt(i, 4).toString())){
				tong += Integer.parseInt((String)modelTaoDonHang.getValueAt(i, 4))*Double.parseDouble((modelTaoDonHang.getValueAt(i, 5).toString()));
			}
			else if(check == true) {
				check = false;
				malk = modelTaoDonHang.getValueAt(i, 0).toString();
				soluong = tableHangCoSan.getValueAt(i, 5).toString();
			}
		}
		if(check == false) {
			JOptionPane.showMessageDialog(this,"Sản phẩm " +malk + " số lượng chỉ còn " + soluong);
		}
		return tong;
	}
	
	public boolean tinhTienThoi() {
		if (!jTextField1.getText().equals("")) {
			String tienKT = jTextField2.getText().trim();
			double tienKhachTra = 0;
			double tongTien = 0;
			try {
				tienKhachTra = Double.parseDouble(tienKT);
				tongTien = tongTien();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Tiền khách trả không hợp lệ");
				return false;
			}

			if (tienKT.matches("^\\d+$") && tienKhachTra >= tongTien) {
				jTextField3.setText(df.format(tienKhachTra - tongTien));
			} else {
				JOptionPane.showMessageDialog(this, "Số tiền trả Không đủ");
				jTextField2.selectAll();
				jTextField2.requestFocus();
				return false;
			}
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(btnTaoDon)) {
			
		}
		else if(e.getSource().equals(btnTimKiem)) {
			int idx = cmbDanhMuc.getSelectedIndex();
			String key = txtTimKiem.getText().trim();
			key = key.toUpperCase();
			switch (idx) {
			case 0: {
				model.getDataVector().removeAllElements();
				try {
					LinhKien lk = linhKienDao.getComponentByID(key);
					model.addRow(new Object[] { lk.getMaLK(), lk.getTenLk(), lk.getLoaiLK(), lk.getThuongHieu(),
							lk.getDonGia(), lk.getSoLuongTon(), false });

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
		else if(e.getSource().equals(tableHangCoSan)) {
			
			modelTaoDonHang.setRowCount(0);
			
			for(int i = 0; i < tableHangCoSan.getRowCount(); i++) {
				tableHangCoSan.clearSelection();
				if(Boolean.parseBoolean(tableHangCoSan.getValueAt(i, 6).toString().trim())) {
					modelTaoDonHang.addRow(new Object[] {
							tableHangCoSan.getValueAt(i, 0),
							tableHangCoSan.getValueAt(i, 1),
							tableHangCoSan.getValueAt(i, 2),
							tableHangCoSan.getValueAt(i, 3),
							"",
							tableHangCoSan.getValueAt(i, 4)
					});
				}
				tableHangCoSan.clearSelection();
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
			if(e.getSource().equals(jTextField2)) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					if(tinhTienThoi()) {
						jTextField2.setText(df.format(Double.parseDouble(jTextField2.getText().trim())));
					}
				}
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(txtTimKiem)) {
			int idx = cmbDanhMuc.getSelectedIndex();
			String key = txtTimKiem.getText().trim();
			key = key.toUpperCase() + "%";
			switch (idx) {
			case 0: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByKeyMa(key);
					
					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getThuongHieu(),
								comp.getDonGia(), comp.getSoLuongTon(), false });

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
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByName(key);
					
					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getThuongHieu(),
								comp.getDonGia(), comp.getSoLuongTon(), false });

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại");
					ex.printStackTrace();
				}
				break;
			}
			case 2: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByCategory(key);
					
					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getThuongHieu(),
								comp.getDonGia(), comp.getSoLuongTon(), false });

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại");
					ex.printStackTrace();
				}
				break;
			}
			case 3: {
				model.getDataVector().removeAllElements();
				try {
					ArrayList<LinhKien> comps = new LinhKienDAO().getComponentByThuongHieu(key);
					
					for (LinhKien comp : comps)
						model.addRow(new Object[] { comp.getMaLK(), comp.getTenLk(), comp.getLoaiLK(), comp.getThuongHieu(),
								comp.getDonGia(), comp.getSoLuongTon(), false });

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this,"Nhân viên không tồn tại");
					ex.printStackTrace();
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idx);
			}
			
			if(txtTimKiem.getText().trim().equals("")) {
				loadProductsData();
				tableHangCoSan.clearSelection();
			}
		}
		
	}
}
