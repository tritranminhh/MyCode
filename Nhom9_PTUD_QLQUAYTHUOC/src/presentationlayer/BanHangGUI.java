package presentationlayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BanHangGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHangGUI frame = new BanHangGUI();
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
	public BanHangGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 145, 738);
		contentPane.add(panel);
		
		JButton button = new JButton("Trang Chủ");
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD));
		button.setContentAreaFilled(false);
		button.setBackground(Color.WHITE);
		button.setBounds(1, 114, 128, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Liên hệ");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(button_1.getFont().deriveFont(button_1.getFont().getStyle() | Font.BOLD));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(1, 162, 128, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Hỗ trợ");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(button_2.getFont().deriveFont(button_2.getFont().getStyle() | Font.BOLD));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(1, 212, 128, 23);
		panel.add(button_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 100, 0));
		separator.setBounds(1, 148, 144, 3);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 100, 0));
		separator_1.setBounds(1, 198, 144, 3);
		panel.add(separator_1);
		ImageIcon icon=new ImageIcon(new ImageIcon(this.getClass().getResource("/Hospital-512.png")).getImage());
		JLabel label = new JLabel(icon);
		label.setBounds(32, 0, 75, 64);
		panel.add(label);
		ImageIcon iconTiltedSmall=new ImageIcon(new ImageIcon(this.getClass().getResource("/pharmarcypartner.png")).getImage());
		JLabel label_1 = new JLabel(iconTiltedSmall);
		label_1.setBounds(1, 62, 134, 23);
		panel.add(label_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(155, 102, 946, 636);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Bán thuốc không kê đơn", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 921, 413);
		panel_1.add(scrollPane);
		String[] itemThuoc= {"Mã thuốc","Tên Thuốc","Loại","Số Lượng","Chức năng","Dạng thuốc","Hạn sử dụng","Đơn Gía","Nhà Sản Xuất","Nhà Cung Cấp"};
		DefaultTableModel dftbmodelBanKKD;
		table = new JTable(dftbmodelBanKKD=new DefaultTableModel(itemThuoc,0));
		scrollPane.setViewportView(table);
		
		JButton btnThmVoGi = new JButton("Thêm vào giỏ hàng");
		btnThmVoGi.setBounds(10, 435, 165, 42);
		panel_1.add(btnThmVoGi);
		
		JButton btnNhpLi = new JButton("Xóa Trắng");
		btnNhpLi.setBounds(185, 435, 165, 42);
		panel_1.add(btnNhpLi);
		
		JComboBox cbTimKiemThuoc = new JComboBox();
		cbTimKiemThuoc.setBounds(371, 443, 111, 26);
		panel_1.add(cbTimKiemThuoc);
		
		textField = new JTextField();
		textField.setBounds(492, 446, 245, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnTmKim = new JButton("Tìm Kiếm");
		btnTmKim.setBounds(748, 435, 111, 42);
		panel_1.add(btnTmKim);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Bán thuốc có kê đơn", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 921, 418);
		panel_2.add(scrollPane_1);
		String[] listDon= {"Mã đơn thuốc","Số lượng bán","Thông tin Khách Hàng","Thuốc"};

		DefaultTableModel dftbbanDonThuoc;
		table_1 = new JTable(dftbbanDonThuoc=new DefaultTableModel(listDon,0));
		scrollPane_1.setViewportView(table_1);
		
		JButton button_3 = new JButton("Thêm vào giỏ hàng");
		button_3.setBounds(10, 440, 165, 42);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("Xóa Trắng");
		button_4.setBounds(185, 440, 165, 42);
		panel_2.add(button_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(371, 448, 111, 26);
		panel_2.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(492, 451, 245, 26);
		panel_2.add(textField_1);
		
		JButton button_5 = new JButton("Tìm Kiếm");
		button_5.setBounds(748, 440, 111, 42);
		panel_2.add(button_5);
	}
}
