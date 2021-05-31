package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ChiTietHoaDonDAO;

public class PanelThongKe extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnBanCham;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JTextField txtBanChay;
    private JTextField txtDoanhThu;
    private JTextField txtHoaDonCao;
    private JTextField txtMuaNhieu;
    private ChiTietHoaDonDAO cthdDao;
	
    public PanelThongKe() {
        initComponents();
        cthdDao = new ChiTietHoaDonDAO();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        txtBanChay = new JTextField();
        txtDoanhThu = new JTextField();
        txtHoaDonCao = new JTextField();
        txtMuaNhieu = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jComboBox1 = new JComboBox<>();
        btnBanCham = new JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Thống kê bán hàng");

        txtBanChay.setEditable(false);
        txtBanChay.setFont(new java.awt.Font("Tahoma", 0, 24));

        txtDoanhThu.setEditable(false);
        txtDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 24));

        txtHoaDonCao.setEditable(false);
        txtHoaDonCao.setFont(new java.awt.Font("Tahoma", 0, 24));

        txtMuaNhieu.setEditable(false);
        txtMuaNhieu.setFont(new java.awt.Font("Tahoma", 0, 24));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel2.setText("Sản phẩm bán chạy nhất");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel3.setText("Sản phẩm bán chậm nhất");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel4.setText("Tổng doanh thu cửa hàng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel5.setText("Khách hàng mua hóa đơn cao nhất");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel6.setText("Khách hàng mua nhiều lần nhất");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel7.setText("Thống kê theo");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        jComboBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Handle();
			}
		});
        btnBanCham.setText("Xem thông tin");

        btnBanCham.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnBanChamActionPerformed();
			}
		});
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMuaNhieu)
                                .addComponent(txtHoaDonCao)
                                .addComponent(txtDoanhThu)
                                .addComponent(txtBanChay, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBanCham, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jLabel1)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBanChay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnBanCham))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoanhThu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoaDonCao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtMuaNhieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }

    private void Handle() {
    	DecimalFormat df;
    	df = new DecimalFormat("#,##0.00");
    	String nameSP = "";
  	  	double sumTotal = 0;
  	  	String nameCus = "";
  	  	String nameCusBuyMore = "";
	    	  switch (jComboBox1.getSelectedIndex())
	    	  { 
	    	      case 0:
						try {
							nameSP = cthdDao.getProductTop1Selling("day");
						} catch (SQLException e) {
							e.printStackTrace();
							nameSP = "";
						}
						try {
							sumTotal = cthdDao.getSumTotal("day");
						} catch (SQLException e) {
							e.printStackTrace();
							sumTotal = 0;
						}
						try {
							nameCus = cthdDao.getCusTop1Buy("day");
						} catch (SQLException e) {
							e.printStackTrace();
							sumTotal = 0;
						}
						try {
							nameCusBuyMore = cthdDao.getCusTop1BuyMore("day");
						} catch (SQLException e) {
							e.printStackTrace();
						}

						txtBanChay.setText(nameSP);
						txtDoanhThu.setText(df.format(sumTotal));
						txtHoaDonCao.setText(nameCus);
						txtMuaNhieu.setText(nameCusBuyMore);
	    	          break;
	    	      case 1:
	    	    	  try {
							nameSP = cthdDao.getProductTop1Selling("month");
						} catch (SQLException e) {
							e.printStackTrace();
							nameSP = "";
						}
						try {
							sumTotal = cthdDao.getSumTotal("month");
						} catch (SQLException e) {
							e.printStackTrace();
							sumTotal = 0;
						}
						try {
							nameCus = cthdDao.getCusTop1Buy("month");
						} catch (SQLException e) {
							e.printStackTrace();
							sumTotal = 0;
						}
						try {
							nameCusBuyMore = cthdDao.getCusTop1BuyMore("month");
						} catch (SQLException e) {
							e.printStackTrace();
						}

						txtBanChay.setText(nameSP);
						txtDoanhThu.setText(df.format(sumTotal));
						txtHoaDonCao.setText(nameCus);
						txtMuaNhieu.setText(nameCusBuyMore);
	    	          break;
	    	      case 2:
	    	    	  try {
							nameSP = cthdDao.getProductTop1Selling("year");
						} catch (SQLException e) {
							e.printStackTrace();
							nameSP = "";
						}
						try {
							sumTotal = cthdDao.getSumTotal("year");
						} catch (SQLException e) {
							e.printStackTrace();
							sumTotal = 0;
						}
						try {
							nameCus = cthdDao.getCusTop1Buy("year");
						} catch (SQLException e) {
							e.printStackTrace();
							sumTotal = 0;
						}
						try {
							nameCusBuyMore = cthdDao.getCusTop1BuyMore("year");
						} catch (SQLException e) {
							e.printStackTrace();
						}

						txtBanChay.setText(nameSP);
						txtDoanhThu.setText(df.format(sumTotal));
						txtHoaDonCao.setText(nameCus);
						txtMuaNhieu.setText(nameCusBuyMore);
	    	          break;
	    	  }
    	}

    private void btnBanChamActionPerformed() {                                           
        new FrameBanCham().setVisible(true);
    }  
}