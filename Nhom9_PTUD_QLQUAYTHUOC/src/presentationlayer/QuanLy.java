package presentationlayer;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.toedter.calendar.JDateChooser;

import bussinesslayer.QLChucnang;
import bussinesslayer.QLDangthuoc;
import bussinesslayer.QLDanhmucThuoc;
import bussinesslayer.QLDonthuoc;
import bussinesslayer.QLLoai;
import bussinesslayer.QLNhacungcap;
import bussinesslayer.QLNhanvien;
import bussinesslayer.QLThuoc;
import entitylayer.Donthuoc;
import entitylayer.Nhacungcap;
import entitylayer.Nhanvien;
import entitylayer.Thuoc;

import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDayChooser;


public class QuanLy extends JFrame {

	private JPanel contentPane;
	private JTextField filterTextNCC;
	private JTextField filterTextThuoc;
	private JTextField filterTextDonThuoc;
	private JTextField filterTextNV;
	private JTextField txtTenThuoc;
	private JTextField txtSoLuong;
	private JTextField txtHSD;
	private JTextField txtDonGia;
	private JTable tbDon;
	private JTable tbThuoc;
	private JTable tbNV;
	private JTable tbNCC;
	private JTextField txttenNV;
	private JTextField txtGTinh;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField txtMK;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtSDTNCC;
	private JTextField txtEmailNCC;
	private JTextField txtmaDon;
	private JTextField txtKHdonThuoc;
	private JTextField txtNVdonThuoc;
	private JTable tbDonThuocKeDon;
	private TableRowSorter<TableModel> sorterThuoc;
	private TableRowSorter<TableModel> sorterNhanVien;
	private TableRowSorter<TableModel> sorterNCC;
	private TableRowSorter<TableModel> sorterDonThuoc;
	private QLThuoc dsThuoc=new QLThuoc();
	private QLDonthuoc dsDonThuoc=new QLDonthuoc();
	private Donthuoc donThuoc=new Donthuoc();
	private QLNhanvien dsNV=new QLNhanvien();
	private QLNhacungcap dsNCC=new QLNhacungcap();
	private QLChucnang dsCN=new QLChucnang();
	private QLLoai dsLoai=new QLLoai();
	private QLDangthuoc dsDangthuoc=new QLDangthuoc();
	private QLDanhmucThuoc dsDanhmucthuoc=new QLDanhmucThuoc();
	private JTextField txtMaThuoc;
	private DefaultTableModel dftbNCC;
	private DefaultTableModel dftbNV;
	private DefaultTableModel dftbDon;
	private DefaultTableModel dftbThuocDeKeDon;
	private DefaultTableModel dfmodelThuoc;
	private DefaultTableModel dfmodelGioThuoc;
	private JButton btnKiemTraThuc;
	private JButton btnClear;
	private JButton btnXoaThuc;
	private JButton btnSuaThuoc;
	private JButton btnThemDon;
	private JButton button_4;
	private JButton btnSuaDon;
	private JButton btnXoaDon;
	private JButton btnNhapLaiDon;
	private JButton btnThemNCC;
	private JButton btnXoaNCC;
	private JButton btnSuaNCC;
	private JButton btnNhapLaiNCC;
	private JTextField txtMaNV;
	private JButton btnThemNV;
	private JButton btnSuaNV;
	private JButton btnXoaNV;
	private JButton btnNhapLaiNV;
	private JButton btnThemThuoc;
	Locale local=new Locale("vi", "VN");
	NumberFormat format=NumberFormat.getCurrencyInstance(local);
	SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox<String> cbFilterThuoc;
	private JComboBox<String> cbFilterDonThuoc;
	private JComboBox<String> cbFilterNV;
	private JComboBox<String> cbFilterNCC;
	private JComboBox<String> cbDangThuoc;
	private JComboBox<String> cbChucNang;
	private JComboBox<String> cbLoaiThuoc;
	private JComboBox<String> cbNCC;
	private JTable tbChiTietDonThuoc;
	private DefaultTableModel dftbChiTietDonThuoc;
	private JDateChooser dateChooserforNVbirth;
	private JDateChooser dateChooserforDonThuoc;
	private JDateChooser dateChooserforThuoc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties p=new Properties();
					p.put("windowDecoration", "off");
					LunaLookAndFeel.setCurrentTheme(p);
					//UIManager.setLookAndFeel(new LunaLookAndFeel());
					QuanLy frame = new QuanLy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLy() {
		/*java.awt.Toolkit tk=java.awt.Toolkit.getDefaultToolkit();
		int xsize= (int) tk.getScreenSize().getWidth();
		int ysize=(int) tk.getScreenSize().getHeight();
		setSize(xsize, ysize);
		setAlwaysOnTop(true);*/

		//this.setUndecorated(true);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1509, 773);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 102, 51));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(new Color(0, 153, 102));
		tabbedPane.setBounds(152, 114, 1329, 616);
		tabbedPane.setBorder(null);
		String[] itemThuoc= {"Mã thuốc","Tên Thuốc","Loại","Số Lượng","Chức năng","Dạng thuốc","Hạn sử dụng","Đơn Gía","Ngày Sản Xuất","Nhà Cung Cấp"};

		DefaultTableModel dfmodelGioThuoc;

		JPanel panelThuoc = new JPanel();
		panelThuoc.setForeground(new Color(51, 153, 102));
		panelThuoc.setBackground(Color.WHITE);
		tabbedPane.addTab("Quản lý thuốc", null, panelThuoc, null);

		filterTextThuoc = new JTextField();
		filterTextThuoc.setBounds(957, 9, 157, 20);
		filterTextThuoc.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(0, 1, 319, 320);
		panel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.setBorder(new TitledBorder(null, "Qu\u1EA3n l\u00FD Thu\u1ED1c ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JLabel lblMThuc = new JLabel("Mã Thuốc:");
		lblMThuc.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMThuc.setBounds(10, 32, 97, 14);
		panel.add(lblMThuc);

		JLabel lblTnThuc = new JLabel("Tên Thuốc:");
		lblTnThuc.setFont(new Font("Dialog", Font.BOLD, 11));
		lblTnThuc.setBounds(10, 57, 97, 14);
		panel.add(lblTnThuc);

		JLabel lblLoiThuc = new JLabel("Loại thuốc:");
		lblLoiThuc.setFont(new Font("Dialog", Font.BOLD, 11));
		lblLoiThuc.setBounds(10, 83, 97, 14);
		panel.add(lblLoiThuc);

		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Dialog", Font.BOLD, 11));
		lblSoLuong.setBounds(10, 108, 97, 14);
		panel.add(lblSoLuong);

		JLabel lblChcNng = new JLabel("Chức năng:");
		lblChcNng.setFont(new Font("Dialog", Font.BOLD, 11));
		lblChcNng.setBounds(10, 133, 97, 14);
		panel.add(lblChcNng);

		JLabel lblDngThuc = new JLabel("Dạng thuốc:");
		lblDngThuc.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDngThuc.setBounds(10, 158, 97, 14);
		panel.add(lblDngThuc);

		JLabel lblHnSDng = new JLabel("Hạn sử dụng:");
		lblHnSDng.setFont(new Font("Dialog", Font.BOLD, 11));
		lblHnSDng.setBounds(10, 183, 97, 14);
		panel.add(lblHnSDng);

		JLabel lblnGa = new JLabel("Đơn Gía:");
		lblnGa.setFont(new Font("Dialog", Font.BOLD, 11));
		lblnGa.setBounds(10, 208, 97, 14);
		panel.add(lblnGa);

		JLabel lblNhSnXut = new JLabel("Ngày Sản Xuất:");
		lblNhSnXut.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNhSnXut.setBounds(10, 235, 97, 14);
		panel.add(lblNhSnXut);

		JLabel lblNhCungCp = new JLabel("Nhà cung cấp:");
		lblNhCungCp.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNhCungCp.setBounds(10, 263, 97, 14);
		panel.add(lblNhCungCp);

		txtTenThuoc = new JTextField();
		txtTenThuoc.setBackground(Color.WHITE);
		lblTnThuc.setLabelFor(txtTenThuoc);
		txtTenThuoc.setColumns(10);
		txtTenThuoc.setBounds(117, 48, 191, 20);
		panel.add(txtTenThuoc);

		txtSoLuong = new JTextField();
		txtSoLuong.setBackground(Color.WHITE);
		lblSoLuong.setLabelFor(txtSoLuong);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(117, 102, 191, 20);
		panel.add(txtSoLuong);

		txtHSD = new JTextField();
		txtHSD.setBackground(Color.WHITE);
		lblHnSDng.setLabelFor(txtHSD);
		txtHSD.setColumns(10);
		txtHSD.setBounds(117, 179, 191, 20);
		panel.add(txtHSD);

		txtDonGia = new JTextField();
		txtDonGia.setBackground(Color.WHITE);
		lblnGa.setLabelFor(txtDonGia);
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(117, 204, 191, 20);
		panel.add(txtDonGia);

		cbDangThuoc = new JComboBox();
		cbDangThuoc.setBackground(Color.WHITE);
		lblDngThuc.setLabelFor(cbDangThuoc);
		cbDangThuoc.setBounds(117, 152, 191, 22);
		panel.add(cbDangThuoc);

		cbChucNang = new JComboBox();
		cbChucNang.setBackground(Color.WHITE);
		lblChcNng.setLabelFor(cbChucNang);
		cbChucNang.setBounds(117, 127, 191, 22);
		panel.add(cbChucNang);

		cbLoaiThuoc = new JComboBox<String>();
		cbLoaiThuoc.setModel(new DefaultComboBoxModel<String>());
		cbLoaiThuoc.setBackground(Color.WHITE);
		lblLoiThuc.setLabelFor(cbLoaiThuoc);
		cbLoaiThuoc.setBounds(117, 73, 191, 22);
		panel.add(cbLoaiThuoc);

		cbNCC = new JComboBox();
		cbNCC.setBackground(Color.WHITE);
		lblNhCungCp.setLabelFor(cbNCC);
		cbNCC.setBounds(117, 260, 191, 22);
		panel.add(cbNCC);

		JScrollPane spaneThuoc = new JScrollPane();
		spaneThuoc.setBounds(397, 35, 807, 276);
		spaneThuoc.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		spaneThuoc.setAutoscrolls(true);

		tbThuoc = new JTable(dfmodelThuoc= new DefaultTableModel(itemThuoc,0));

		tbThuoc.setAutoCreateRowSorter(true);
		sorterThuoc=new TableRowSorter<TableModel>(tbThuoc.getModel());
		tbThuoc.setRowSorter(sorterThuoc);
		tbThuoc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		spaneThuoc.setViewportView(tbThuoc);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 326, 319, 104);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);

		btnKiemTraThuc = new JButton("Kiểm Tra Thuốc Tồn");
		btnKiemTraThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKiemTraThuc.setSelectedIcon(new ImageIcon(QuanLy.class.getResource("/com/jtattoo/plaf/texture/icons/thumb_hor.gif")));
		btnKiemTraThuc.setIcon(new ImageIcon(QuanLy.class.getResource("/Tests-iconfinal.png")));
		btnKiemTraThuc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKiemTraThuc.setBounds(0, 0, 318, 36);
		panel_1.add(btnKiemTraThuc);
		btnKiemTraThuc.setForeground(Color.WHITE);
		btnKiemTraThuc.setBorderPainted(false);
		btnKiemTraThuc.setBackground(SystemColor.textHighlight);
		panelThuoc.setLayout(null);
		panelThuoc.add(panel);

		txtMaThuoc = new JTextField();
		txtMaThuoc.setBounds(117, 21, 192, 22);
		panel.add(txtMaThuoc);
		txtMaThuoc.setColumns(10);

		dateChooserforThuoc = new JDateChooser();
		dateChooserforThuoc.setBounds(117, 229, 191, 20);
		panel.add(dateChooserforThuoc);
		panelThuoc.add(panel_1);
		panelThuoc.add(filterTextThuoc);
		panelThuoc.add(spaneThuoc);

		JButton button_5 = new JButton("Tìm Kiếm");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_5.setBorderPainted(false);
		button_5.setBackground(new Color(51, 51, 255));
		button_5.setBounds(1111, 9, 83, 20);
		panelThuoc.add(button_5);

		JScrollPane spaneGioThuocDon = new JScrollPane();
		spaneGioThuocDon.setBounds(397, 345, 807, 255);
		panelThuoc.add(spaneGioThuocDon);
		String[] itemGioThuoc= {"Mã Thuốc","Tên Thuốc","Số Lượng","Đơn Gía","Thành Tiền"};
		tbDonThuocKeDon = new JTable(dfmodelGioThuoc= new DefaultTableModel(itemGioThuoc, 0));
		spaneGioThuocDon.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		spaneGioThuocDon.setViewportView(tbDonThuocKeDon);

		JButton btnKeDon = new JButton("Kê Thuốc vào Đơn");
		btnKeDon.setIcon(new ImageIcon(QuanLy.class.getResource("/com/jtattoo/plaf/texture/icons/medium/arrow_down_9x8.png")));
		btnKeDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKeDon.setBorderPainted(false);
		btnKeDon.setBackground(new Color(102, 205, 170));
		btnKeDon.setBounds(500, 313, 165, 30);
		panelThuoc.add(btnKeDon);

		JButton btnXoaKeDon = new JButton("Xóa thuốc khỏi Đơn");
		btnXoaKeDon.setIcon(new ImageIcon(QuanLy.class.getResource("/com/jtattoo/plaf/texture/icons/medium/arrow_up_9x8.png")));
		btnXoaKeDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaKeDon.setBorderPainted(false);
		btnXoaKeDon.setBackground(new Color(60, 179, 113));
		btnXoaKeDon.setBounds(878, 313, 165, 30);
		panelThuoc.add(btnXoaKeDon);

		JLabel lblNewLabel_12 = new JLabel("Danh Sách Thuốc");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(722, 1, 138, 30);
		panelThuoc.add(lblNewLabel_12);

		JLabel lblPhiuKn = new JLabel("Phiếu Kê Đơn");
		lblPhiuKn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhiuKn.setBounds(722, 316, 117, 20);
		panelThuoc.add(lblPhiuKn);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(317, 35, 71, 278);
		panelThuoc.add(panel_9);
		panel_9.setLayout(null);

		btnThemThuoc = new JButton("Thêm");
		btnThemThuoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemThuoc.setBounds(-4, 5, 75, 51);
		panel_9.add(btnThemThuoc);

		btnClear = new JButton("Clear");
		btnClear.setBounds(-4, 67, 79, 52);
		panel_9.add(btnClear);

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setSelectedIcon(new ImageIcon(QuanLy.class.getResource("/com/jtattoo/plaf/icons/medium/arrow_right_6x9.png")));
		btnClear.setPressedIcon(new ImageIcon(QuanLy.class.getResource("/com/jtattoo/plaf/acryl/icons/medium/check_symbol_14x13.png")));
		btnClear.setIcon(new ImageIcon(QuanLy.class.getResource("/undo-icon.png")));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(Color.ORANGE);

		btnSuaThuoc = new JButton("Sửa ");
		btnSuaThuoc.setBounds(-4, 145, 77, 51);
		panel_9.add(btnSuaThuoc);
		btnSuaThuoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuaThuoc.setIcon(new ImageIcon(QuanLy.class.getResource("/pill-pencil-icon.png")));
		btnSuaThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnSaThucActionPerformed(e);
			}
		});
		btnSuaThuoc.setForeground(Color.WHITE);
		btnSuaThuoc.setBorderPainted(false);
		btnSuaThuoc.setBackground(new Color(0, 191, 255));

		btnXoaThuc = new JButton("Xóa ");
		btnXoaThuc.setBounds(-6, 216, 77, 51);
		panel_9.add(btnXoaThuc);
		btnXoaThuc.setIcon(new ImageIcon(QuanLy.class.getResource("/pill-delete-icon (1).png")));
		btnXoaThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnXaThucactionPerformed(e);
			}
		});
		btnXoaThuc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaThuc.setForeground(Color.WHITE);
		btnXoaThuc.setBorderPainted(false);
		btnXoaThuc.setBackground(Color.RED);

		cbFilterThuoc = new JComboBox();
		cbFilterThuoc.setBounds(870, 8, 83, 23);
		panelThuoc.add(cbFilterThuoc);

		JPanel paneldonThuoc = new JPanel();
		paneldonThuoc.setBackground(Color.WHITE);
		tabbedPane.addTab("Quản lý đơn thuốc", null, paneldonThuoc, null);

		filterTextDonThuoc = new JTextField();
		filterTextDonThuoc.setBounds(121, 394, 219, 20);
		filterTextDonThuoc.setColumns(10);

		JScrollPane sPaneDon = new JScrollPane();
		sPaneDon.setBounds(27, 21, 538, 362);
		String[] listDon= {"Mã đơn thuốc","Khách hàng","Nhân Viên","Ngày lập đơn","Tổng Tiền"};
		tbDon = new JTable(dftbDon=new DefaultTableModel(listDon,0));
		tbDon.setAutoCreateRowSorter(true);
		sorterDonThuoc=new TableRowSorter<TableModel>(tbDon.getModel());
		tbDon.setRowSorter(sorterDonThuoc);
		sPaneDon.setViewportView(tbDon);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(467, 424, 98, 187);
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);

		btnThemDon = new JButton("Thêm");
		btnThemDon.setForeground(Color.WHITE);
		btnThemDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemDon.setBorderPainted(false);
		btnThemDon.setBackground(SystemColor.textHighlight);
		btnThemDon.setBounds(0, 0, 94, 49);
		panel_5.add(btnThemDon);

		btnXoaDon = new JButton("Xóa ");
		btnXoaDon.setForeground(Color.WHITE);
		btnXoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaDon.setBorderPainted(false);
		btnXoaDon.setBackground(Color.RED);
		btnXoaDon.setBounds(0, 93, 94, 49);
		panel_5.add(btnXoaDon);

		btnSuaDon = new JButton("Sửa ");
		btnSuaDon.setForeground(Color.WHITE);
		btnSuaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuaDon.setBorderPainted(false);
		btnSuaDon.setBackground(new Color(0, 191, 255));
		btnSuaDon.setBounds(0, 137, 94, 49);
		panel_5.add(btnSuaDon);

		btnNhapLaiDon = new JButton("Nhập Lại");
		btnNhapLaiDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNhapLaiDon.setBorderPainted(false);
		btnNhapLaiDon.setBackground(Color.ORANGE);
		btnNhapLaiDon.setBounds(0, 47, 94, 49);
		panel_5.add(btnNhapLaiDon);

		button_4 = new JButton("Tìm Kiếm");
		button_4.setBounds(346, 394, 107, 20);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_4.setBorderPainted(false);
		button_4.setBackground(new Color(51, 51, 255));
		paneldonThuoc.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 417, 470, 194);
		panel_8.setBorder(new TitledBorder(null, "Qu\u1EA3n l\u00FD \u0110\u01A1n Thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBackground(Color.WHITE);
		panel_8.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Mã đơn thuốc:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(10, 21, 91, 14);
		panel_8.add(lblNewLabel_11);

		JLabel lblKhachHang = new JLabel("Khách hàng");
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKhachHang.setBounds(10, 52, 91, 14);
		panel_8.add(lblKhachHang);

		JLabel lb = new JLabel("Nhân Viên");
		lb.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb.setBounds(10, 86, 138, 14);
		panel_8.add(lb);

		JLabel lblThuc = new JLabel("Ngày lập đơn");
		lblThuc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThuc.setBounds(10, 121, 91, 14);
		panel_8.add(lblThuc);

		txtmaDon = new JTextField();
		txtmaDon.setBounds(148, 15, 231, 20);
		panel_8.add(txtmaDon);
		txtmaDon.setColumns(10);

		txtKHdonThuoc = new JTextField();
		txtKHdonThuoc.setBounds(147, 46, 232, 20);
		panel_8.add(txtKHdonThuoc);
		txtKHdonThuoc.setColumns(10);

		txtNVdonThuoc = new JTextField();
		txtNVdonThuoc.setBounds(148, 80, 231, 20);
		panel_8.add(txtNVdonThuoc);
		txtNVdonThuoc.setColumns(10);
		paneldonThuoc.add(panel_8);

		dateChooserforDonThuoc = new JDateChooser();
		dateChooserforDonThuoc.setBounds(148, 115, 231, 20);
		panel_8.add(dateChooserforDonThuoc);
		paneldonThuoc.add(panel_5);
		paneldonThuoc.add(sPaneDon);
		paneldonThuoc.add(filterTextDonThuoc);
		paneldonThuoc.add(button_4);

		cbFilterDonThuoc = new JComboBox();
		cbFilterDonThuoc.setBounds(10, 394, 107, 23);
		paneldonThuoc.add(cbFilterDonThuoc);

		JScrollPane scChiTietDonThuoc = new JScrollPane();
		scChiTietDonThuoc.setBounds(603, 21, 557, 362);
		paneldonThuoc.add(scChiTietDonThuoc);

		tbChiTietDonThuoc = new JTable(dfmodelGioThuoc=new DefaultTableModel(itemGioThuoc,0));
		scChiTietDonThuoc.setViewportView(tbChiTietDonThuoc);
		JPanel panelNV = new JPanel();
		panelNV.setBackground(Color.WHITE);
		tabbedPane.addTab("Quản lý nhân viên", null, panelNV, null);

		filterTextNV = new JTextField();
		filterTextNV.setBounds(629, 150, 219, 20);
		filterTextNV.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(438, 188, 876, 389);
		String[] itemNV= {"Mã Nhân Viên","Tên Nhân Viên","Giới Tính","Ngày Sinh","Địa Chỉ","Email","Số Điện thoại","Mật khẩu"};

		tbNV = new JTable(dftbNV=new DefaultTableModel(itemNV,0));
		tbNV.setAutoCreateRowSorter(true);
		sorterNhanVien=new TableRowSorter<TableModel>(tbNV.getModel());
		tbNV.setRowSorter(sorterNhanVien);
		scrollPane.setViewportView(tbNV);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(98, 188, 315, 256);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);

		JLabel lblNhnVin = new JLabel("Mã Nhân Viên:");
		lblNhnVin.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNhnVin.setBounds(10, 36, 84, 14);
		panel_2.add(lblNhnVin);

		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên:");
		lblTnNhnVin.setFont(new Font("Dialog", Font.BOLD, 11));
		lblTnNhnVin.setBounds(10, 61, 84, 14);
		panel_2.add(lblTnNhnVin);

		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setFont(new Font("Dialog", Font.BOLD, 11));
		lblGiiTnh.setBounds(10, 84, 84, 14);
		panel_2.add(lblGiiTnh);

		JLabel lblaCh = new JLabel("Địa Chỉ:");
		lblaCh.setFont(new Font("Dialog", Font.BOLD, 11));
		lblaCh.setBounds(10, 132, 84, 14);
		panel_2.add(lblaCh);

		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNgySinh.setBounds(10, 109, 84, 14);
		panel_2.add(lblNgySinh);

		JLabel lblSinThoi = new JLabel("Số Điện thoại:");
		lblSinThoi.setFont(new Font("Dialog", Font.BOLD, 11));
		lblSinThoi.setBounds(10, 180, 84, 14);
		panel_2.add(lblSinThoi);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 11));
		lblEmail.setBounds(10, 157, 84, 14);
		panel_2.add(lblEmail);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMtKhu.setBounds(10, 205, 84, 14);
		panel_2.add(lblMtKhu);

		txttenNV = new JTextField();
		txttenNV.setBounds(97, 59, 186, 20);
		panel_2.add(txttenNV);
		txttenNV.setColumns(10);

		txtGTinh = new JTextField();
		txtGTinh.setBounds(97, 86, 186, 20);
		panel_2.add(txtGTinh);
		txtGTinh.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(97, 136, 186, 20);
		panel_2.add(txtDiaChi);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(97, 161, 186, 20);
		panel_2.add(txtEmail);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(97, 184, 186, 20);
		panel_2.add(txtSDT);

		txtMK = new JTextField();
		txtMK.setColumns(10);
		txtMK.setBounds(97, 209, 186, 20);
		panel_2.add(txtMK);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(68, 462, 345, 107);
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);

		btnThemNV = new JButton("Thêm");
		btnThemNV.setIcon(new ImageIcon(QuanLy.class.getResource("/Preppy-icon.png")));
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemNV.setForeground(Color.WHITE);
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemNV.setBorderPainted(false);
		btnThemNV.setBackground(SystemColor.textHighlight);
		btnThemNV.setBounds(0, 0, 94, 49);
		panel_3.add(btnThemNV);

		btnXoaNV = new JButton("Xóa ");
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaNV.setForeground(Color.WHITE);
		btnXoaNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaNV.setBorderPainted(false);
		btnXoaNV.setBackground(Color.RED);
		btnXoaNV.setBounds(187, 0, 83, 49);
		panel_3.add(btnXoaNV);

		btnSuaNV = new JButton("Sửa ");
		btnSuaNV.setForeground(Color.WHITE);
		btnSuaNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuaNV.setBorderPainted(false);
		btnSuaNV.setBackground(new Color(0, 191, 255));
		btnSuaNV.setBounds(268, 0, 77, 49);
		panel_3.add(btnSuaNV);

		btnNhapLaiNV = new JButton("Nhập Lại");
		btnNhapLaiNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhapLaiNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNhapLaiNV.setBorderPainted(false);
		btnNhapLaiNV.setBackground(Color.ORANGE);
		btnNhapLaiNV.setBounds(94, 0, 94, 49);
		panel_3.add(btnNhapLaiNV);
		panelNV.setLayout(null);
		panelNV.add(filterTextNV);
		panelNV.add(panel_2);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(97, 34, 186, 20);
		panel_2.add(txtMaNV);
		txtMaNV.setColumns(10);

		dateChooserforNVbirth = new JDateChooser();
		dateChooserforNVbirth.setBounds(97, 109, 186, 20);
		panel_2.add(dateChooserforNVbirth);
		panelNV.add(panel_3);
		panelNV.add(scrollPane);

		JButton button_3 = new JButton("Tìm Kiếm");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_3.setBorderPainted(false);
		button_3.setBackground(new Color(51, 51, 255));
		button_3.setBounds(844, 150, 107, 20);
		panelNV.add(button_3);

		cbFilterNV = new JComboBox();
		cbFilterNV.setBounds(500, 149, 107, 23);
		panelNV.add(cbFilterNV);


		JPanel panelCC = new JPanel();
		panelCC.setBackground(Color.WHITE);
		tabbedPane.addTab("Quản lý nhà cung cấp", null, panelCC, null);
		panelCC.setLayout(null);

		JButton button_12 = new JButton("New button");
		button_12.setForeground(Color.WHITE);
		button_12.setBorderPainted(false);
		button_12.setBackground(new Color(46, 139, 87));
		button_12.setBounds(602, 564, 89, 23);
		panelCC.add(button_12);

		JButton button_13 = new JButton("New button");
		button_13.setForeground(Color.WHITE);
		button_13.setBorderPainted(false);
		button_13.setBackground(new Color(46, 139, 87));
		button_13.setBounds(701, 564, 89, 23);
		panelCC.add(button_13);

		JButton button_14 = new JButton("New button");
		button_14.setForeground(Color.WHITE);
		button_14.setBorderPainted(false);
		button_14.setBackground(new Color(46, 139, 87));
		button_14.setBounds(800, 564, 89, 23);
		panelCC.add(button_14);

		filterTextNCC = new JTextField();
		filterTextNCC.setBounds(628, 131, 219, 20);
		panelCC.add(filterTextNCC);
		filterTextNCC.setColumns(10);

		JButton btnTmKim = new JButton("Tìm Kiếm");
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setBorderPainted(false);
		btnTmKim.setBackground(new Color(51, 51, 255));
		btnTmKim.setBounds(848, 131, 107, 20);
		panelCC.add(btnTmKim);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(403, 170, 673, 362);
		panelCC.add(scrollPane_1);
		String[] itemNCC= {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp","Số Điện thoại","Email"};


		tbNCC = new JTable(dftbNCC=new DefaultTableModel(itemNCC,0));
		tbNCC.setAutoCreateRowSorter(true);
		sorterNCC=new TableRowSorter<TableModel>(tbNCC.getModel());
		tbNCC.setRowSorter(sorterNCC);
		scrollPane_1.setViewportView(tbNCC);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(48, 446, 345, 107);
		panelCC.add(panel_6);

		btnThemNCC = new JButton("Thêm");
		btnThemNCC.setForeground(Color.WHITE);
		btnThemNCC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemNCC.setBorderPainted(false);
		btnThemNCC.setBackground(SystemColor.textHighlight);
		btnThemNCC.setBounds(0, 0, 94, 49);
		panel_6.add(btnThemNCC);

		btnXoaNCC = new JButton("Xóa ");
		btnXoaNCC.setForeground(Color.WHITE);
		btnXoaNCC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaNCC.setBorderPainted(false);
		btnXoaNCC.setBackground(Color.RED);
		btnXoaNCC.setBounds(187, 0, 83, 49);
		panel_6.add(btnXoaNCC);

		btnSuaNCC = new JButton("Sửa ");
		btnSuaNCC.setForeground(Color.WHITE);
		btnSuaNCC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuaNCC.setBorderPainted(false);
		btnSuaNCC.setBackground(new Color(0, 191, 255));
		btnSuaNCC.setBounds(268, 0, 77, 49);
		panel_6.add(btnSuaNCC);

		btnNhapLaiNCC = new JButton("Nhập Lại");
		btnNhapLaiNCC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNhapLaiNCC.setBorderPainted(false);
		btnNhapLaiNCC.setBackground(Color.ORANGE);
		btnNhapLaiNCC.setBounds(94, 0, 94, 49);
		panel_6.add(btnNhapLaiNCC);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Qu\u1EA3n l\u00FD Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(48, 170, 343, 265);
		panelCC.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Mã Nhà Cung Cấp");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 29, 98, 14);
		panel_7.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Tên Nhà Cung Cấp");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 64, 111, 14);
		panel_7.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Số Điện Thoại");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(10, 98, 98, 14);
		panel_7.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Email");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(10, 136, 48, 14);
		panel_7.add(lblNewLabel_10);

		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(118, 26, 215, 17);
		panel_7.add(txtMaNCC);
		txtMaNCC.setColumns(10);

		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(118, 61, 215, 20);
		panel_7.add(txtTenNCC);
		txtTenNCC.setColumns(10);

		txtSDTNCC = new JTextField();
		txtSDTNCC.setBounds(118, 95, 215, 17);
		panel_7.add(txtSDTNCC);
		txtSDTNCC.setColumns(10);

		txtEmailNCC = new JTextField();
		txtEmailNCC.setBounds(118, 133, 215, 20);
		panel_7.add(txtEmailNCC);
		txtEmailNCC.setColumns(10);

		cbFilterNCC = new JComboBox();
		cbFilterNCC.setBounds(511, 130, 107, 23);
		panelCC.add(cbFilterNCC);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1, 1, 145, 740);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(46, 139, 87));

		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setFont(btnTrangChu.getFont().deriveFont(btnTrangChu.getFont().getStyle() | Font.BOLD));
		btnTrangChu.setContentAreaFilled(false);
		btnTrangChu.setBackground(Color.WHITE);
		btnTrangChu.setBounds(1, 114, 128, 23);
		panel_4.add(btnTrangChu);

		JButton btnLienHe = new JButton("Liên hệ");
		btnLienHe.setForeground(Color.WHITE);
		btnLienHe.setFont(btnLienHe.getFont().deriveFont(btnLienHe.getFont().getStyle() | Font.BOLD));
		btnLienHe.setContentAreaFilled(false);
		btnLienHe.setBorderPainted(false);
		btnLienHe.setBackground(Color.WHITE);
		btnLienHe.setBounds(1, 162, 128, 23);
		panel_4.add(btnLienHe);

		JButton btnHoTro = new JButton("Hỗ trợ");
		btnHoTro.setForeground(Color.WHITE);
		btnHoTro.setFont(btnHoTro.getFont().deriveFont(btnHoTro.getFont().getStyle() | Font.BOLD));
		btnHoTro.setContentAreaFilled(false);
		btnHoTro.setBorderPainted(false);
		btnHoTro.setBackground(Color.WHITE);
		btnHoTro.setBounds(1, 212, 128, 23);
		panel_4.add(btnHoTro);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 100, 0));
		separator.setBounds(1, 148, 144, 3);
		panel_4.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 100, 0));
		separator_1.setBounds(1, 198, 144, 3);
		panel_4.add(separator_1);


		try {
			ImageIcon icon=new ImageIcon(new ImageIcon(this.getClass().getResource("/Hospital-512.png")).getImage());
			ImageIcon iconhospital=new ImageIcon(new ImageIcon(this.getClass().getResource("/42491-hospital-icon.png")).getImage());
			ImageIcon iconDoctor=new ImageIcon(new ImageIcon(this.getClass().getResource("/Doctor-iconfix.png")).getImage());
			JLabel lblIconcross = new JLabel(icon);
			lblIconcross.setBounds(32, 0, 75, 64);
			panel_4.add(lblIconcross);
			ImageIcon iconTitled=new ImageIcon(new ImageIcon(this.getClass().getResource("/titledCC.png")).getImage());
			JLabel lblNewLabel = new JLabel(iconTitled);
			lblNewLabel.setBounds(573, 68, 350, 45);
			JLabel lblNewLabel_1 = new JLabel(icon);
			lblNewLabel_1.setBounds(705, 11, 78, 65);
			ImageIcon iconTiltedSmall=new ImageIcon(new ImageIcon(this.getClass().getResource("/pharmarcypartner.png")).getImage());
			JLabel lblNewLabel_2 = new JLabel(iconTiltedSmall);
			lblNewLabel_2.setBounds(1, 62, 134, 23);
			panel_4.add(lblNewLabel_2);
			JLabel lblQLQT = new JLabel("Phần Mềm Quản Lí Quầy Thuốc Chuyên Nghiệp");
			lblQLQT.setBounds(627, 99, 251, 14);
			lblQLQT.setFont(new Font("Times New Roman", Font.BOLD, 11));
			ImageIcon pill1=new ImageIcon(new ImageIcon(this.getClass().getResource("/pill-3-icon.png")).getImage());
			ImageIcon pill2=new ImageIcon(new ImageIcon(this.getClass().getResource("/pill-2-iconbigbigupdate.png")).getImage());
			JLabel lblNewLabel_3 = new JLabel(iconDoctor);
			lblNewLabel_3.setBounds(720, 11, 183, 65);

			JLabel lblNewLabel_4 = new JLabel(pill1);
			lblNewLabel_4.setBounds(586, 7, 124, 81);
			contentPane.setLayout(null);
			contentPane.add(panel_4);
			contentPane.add(tabbedPane);
			contentPane.add(lblNewLabel);
			contentPane.add(lblNewLabel_1);
			contentPane.add(lblQLQT);
			contentPane.add(lblNewLabel_3);
			contentPane.add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel(pill2);
			lblNewLabel_5.setBounds(518, 28, 103, 75);
			contentPane.add(lblNewLabel_5);

			JLabel lblNewLabel_6 = new JLabel(iconhospital);
			lblNewLabel_6.setBounds(900, 1, 110, 102);
			contentPane.add(lblNewLabel_6);






		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public void btnLogoutActionPerformed(ActionEvent e){
		if (JOptionPane.showConfirmDialog(this,"Bạn có muốn logout ko??",
				"Cảnh báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			new DangNhapGUI().setVisible(true);
			dispose();
		}
	}	
	public void updateTableThuocData() {
		while(dfmodelThuoc.getRowCount()>0) {
			dfmodelThuoc.removeRow(0);
		}
		for(Thuoc x : dsThuoc.getDsThuoc()) {
			dfmodelThuoc.addRow(new Object[] {
					x.getMaThuoc(), x.getTenThuoc(), x.getLoaiThuoc().getTenLoai(),x.getSoLuong(),x.getChucNang().getTenCN(),
					x.getDangThuoc().getTenDT(),x.getHDS(),format.format(x.getDonGia()),x.getNSX(),x.getNCC()

			});
		}
		//setJTableColumnsWidth
		//setJTableColumnsWidth(tbThuoc, 80, 120, 10, 10, 10, 10, 10, 10, 10, 10, 30, 30);
	}
	public void updateTablePhieuKeDonData() {
		if(donThuoc.getMaDonThuoc()!=null) {
			while(dfmodelGioThuoc.getRowCount()>0) {
				dfmodelGioThuoc.removeRow(0);
			}
			for(int i=0;i<donThuoc.getDsThuoc().size();i++) {
				Thuoc x=donThuoc.getDsThuoc().get(i);
				int sl=donThuoc.getSoLuong().get(i);
				dfmodelGioThuoc.addRow(new Object[]{i+1,x.getMaThuoc(),x.getTenThuoc(),sl,format.format(x.getDonGia()),format.format(donThuoc.getthanhTien(i))});
			}
			//tongTien
			//thueVAT
			//tiensauThue
		}
	}
	/*public void updateTableChiTietDonThuocData() {
		if(donThuoc.getMaDonThuoc()!=null) {
			while(dfmodelGioThuoc.getRowCount()>0) {
				dfmodelGioThuoc.removeRow(0);
			}
			for(int i=0;i<donThuoc.getDsThuoc().size();i++) {
				Thuoc x=donThuoc.getDsThuoc().get(i);
				int sl=donThuoc.getSoLuong().get(i);
				dfmodelGioThuoc.addRow(new Object[]{i+1,x.getMaThuoc(),x.getTenThuoc(),sl,format.format(x.getDonGia()),format.format(donThuoc.getthanhTien(i))});
			}
			//tongTien
			//thueVAT
			//tiensauThue
		}
	}*/
	public void updateTableDSDonThuocData() {
		while(dftbDon.getRowCount()>0) {
			dftbDon.removeRow(0);
		}
		if(!dsDonThuoc.getDSDONTHUOC().isEmpty()) {
			for(Donthuoc x:dsDonThuoc.getDSDONTHUOC()) {
				dftbDon.addRow(new Object[] {x.getMaDonThuoc(),x.getKhachHang().getTenKH(),
						x.getNhanVien().getTenNV(),sf.format(x.getNgayLapDon().getTime()),format.format(x.gettongTien())});
			}
		}
	}
	public void updateTableNVData() {
		while(dftbNV.getRowCount()>0) {
			dftbNV.removeRow(0);
		}
		for(Nhanvien x : dsNV.getListAcc()) {
			dftbNV.addRow(new Object[] {
					x.getMaNV(), x.getTenNV(), x.getGtinh(),
					x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getSdt()
			});
		}
	}
	public void updateTableCCData() {
		while(dftbNCC.getRowCount()>0) {
			dftbNCC.removeRow(0);
		}
		for(Nhacungcap x : dsNCC.getDSNCC()) {
			dftbNCC.addRow(new Object[] {
					x.getMaNCC(), x.getTenNCC(),
					x.getSdt(), x.getEmail()
			});	
		}
	}
	public void tableThuocMouseCLicked(MouseEvent e) {
		int rowselected=tbThuoc.getSelectedRow();
		if(rowselected!=-1) {
			Thuoc x=new Thuoc();
			x=dsThuoc.TimThuoc(tbThuoc.getValueAt(rowselected, 0).toString());
			txtMaThuoc.setText(x.getMaThuoc());
			txtTenThuoc.setText(x.getTenThuoc());
			txtDonGia.setText(String.format("%.0lf", x.getDonGia()));
			txtHSD.setText(String.format("%d", x.getHDS()));
			txtSoLuong.setText(String.format("%d", x.getSoLuong()));
			dateChooserforThuoc.setDate(x.getNSX().getTime());
			cbChucNang.setSelectedItem(x.getLoaiThuoc().getTenLoai());
			cbDangThuoc.setSelectedItem(x.getDangThuoc().getTenDT());
			cbLoaiThuoc.setSelectedItem(x.getLoaiThuoc().getTenLoai());
			cbNCC.setSelectedItem(x.getNCC().getTenNCC());
			btnKiemTraThuc.setEnabled(true);
			btnSuaThuoc.setEnabled(true);
			btnXoaThuc.setEnabled(true);

		}
	}
	public void tableNVMouseClicked(MouseEvent e) {
		int rowselected=tbNV.getSelectedRow();
		if(rowselected!=-1) {
			Nhanvien x=new Nhanvien();
			x=dsNV.TimNV(tbNV.getValueAt(rowselected, 0).toString());
			txtMaNV.setText(x.getMaNV());
			txttenNV.setText(x.getTenNV());
			txtGTinh.setText(x.getGtinh());
			dateChooserforNVbirth.setDate(x.getNgaySinh().getTime());
			txtDiaChi.setText(x.getDiaChi());
			txtEmail.setText(x.getEmail());
			txtSDT.setText(x.getSdt());
			btnThemNV.setEnabled(false);
			btnXoaNV.setEnabled(true);
			btnSuaNV.setEnabled(true);
		}
	}
	public void tableNCCMouseClicked(MouseEvent e) {
		int rowselected=tbNCC.getSelectedRow();
		if(rowselected!=-1) {
			Nhacungcap x=new Nhacungcap();
			x=dsNCC.TimNCC(tbNCC.getValueAt(rowselected, 0).toString());
			txtMaNCC.setText(x.getMaNCC());
			txtTenNCC.setText(x.getTenNCC());
			txtEmailNCC.setText(x.getEmail());
			txtSDTNCC.setText(x.getSdt());
			btnThemNCC.setEnabled(false);
			btnSuaNCC.setEnabled(true);
			btnXoaNCC.setEnabled(true);
		}
	}
	public void tableDonThuocMouseClicked(MouseEvent e) {
		int rowselected=tbDon.getSelectedRow();
		Donthuoc x=new Donthuoc();
		x=dsDonThuoc.TimDonThuoc(tbDon.getValueAt(rowselected, 0).toString());
		txtmaDon.setText(x.getMaDonThuoc());
		txtKHdonThuoc.setText(x.getKhachHang().getTenKH());
		txtNVdonThuoc.setText(x.getNhanVien().getTenNV());
		dateChooserforDonThuoc.setDate(x.getNgayLapDon().getTime());
	}
	public void newFilterThuoc() {
		RowFilter<TableModel, Object> rf=null;
		int selected=cbFilterThuoc.getSelectedIndex();
		try {
			rf=RowFilter.regexFilter("(?)"+filterTextThuoc.getText().trim(),selected);
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			return;
		}
		sorterThuoc.setRowFilter(rf);
	}
	public void newFilterdonThuoc() {
		RowFilter<TableModel, Object> rf=null;
		int selected=cbFilterDonThuoc.getSelectedIndex();
		try {
			rf=RowFilter.regexFilter("(?)"+filterTextDonThuoc.getText().trim(), selected);
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			return;
		}
		sorterDonThuoc.setRowFilter(rf);
	}
	public void newFilterNV() {
		RowFilter<TableModel, Object> rf=null;
		int selected=cbFilterNV.getSelectedIndex();
		try {
			rf=RowFilter.regexFilter("(?)"+filterTextNV.getText().trim(),selected);
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			return;
		}
		sorterNhanVien.setRowFilter(rf);
	}
	public void newFilterNCC() {
		RowFilter<TableModel, Object> rf=null;
		int selected=cbFilterNCC.getSelectedIndex();
		try {
			rf=RowFilter.regexFilter("(?)"+filterTextNCC.getText().trim(),selected);
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			return;
		}
		sorterNCC.setRowFilter(rf);
	}
	public void btnThemMoiThuocActionPerformed(ActionEvent e) {
		Thuoc x=new Thuoc();
		GregorianCalendar ngaySX=new GregorianCalendar();
		x.setMaThuoc(txtMaThuoc.getText().trim());
		x.setTenThuoc(txtTenThuoc.getText().trim());
		x.setLoaiThuoc(dsLoai.timLoaiThuoc(cbLoaiThuoc.getItemAt(cbLoaiThuoc.getSelectedIndex())));
		x.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
		x.setChucNang(dsCN.timChucNangThuoc(cbChucNang.getItemAt(cbChucNang.getSelectedIndex())));
		x.setDangThuoc(dsDangthuoc.timDangThuoc(cbDangThuoc.getItemAt(cbDangThuoc.getSelectedIndex())));
		x.setHDS(Integer.parseInt(txtHSD.getText().trim()));
		x.setDonGia(Double.parseDouble(txtDonGia.getText().trim()));
		try {
			ngaySX.setTime(dateChooserforThuoc.getDate());
			x.setNSX(ngaySX);
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e2,"Lỗi",1);
		}
		x.setNCC(dsNCC.TimNCCTheoTen(cbNCC.getItemAt(cbNCC.getSelectedIndex())));
		if(dsThuoc.ThemThuoc(x)) {
			updateTableThuocData();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công","Thông báo",1);
		}else {
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công","Thông báo",1);
		}
	}
	public void btnThemMoiNVActionPerfomed(ActionEvent e) {
		Nhanvien x=new Nhanvien();
		GregorianCalendar ngaySinh=new GregorianCalendar();
		x.setMaNV(txtMaNV.getText().trim());
		x.setTenNV(txttenNV.getText().trim());
		x.setGtinh(txtGTinh.getText().trim());
		try {
			ngaySinh.setTime(dateChooserforNVbirth.getDate());
			x.setNgaySinh(ngaySinh);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		x.setDiaChi(txtDiaChi.getText().trim());
		x.setEmail(txtEmail.getText().trim());
		x.setSdt(txtSDT.getText().trim());
		if(dsNV.addAcc(x)) {
			updateTableNVData();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công","Thông báo",1);
		}else {
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công","Thông báo",1);
		}
	}
	public void btnThemMoiNCCActionPerformed(ActionEvent e) {
		Nhacungcap x=new Nhacungcap();
		x.setMaNCC(txtMaNCC.getText().trim());
		x.setTenNCC(txtTenNCC.getText().trim());
		x.setSdt(txtSDTNCC.getText().trim());
		x.setEmail(txtEmailNCC.getText().trim());
		if(dsNCC.addNCC(x)) {
			updateTableCCData();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công","Thông báo",1);
		}else {
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công","Thông báo",1);
		}
	}
}
