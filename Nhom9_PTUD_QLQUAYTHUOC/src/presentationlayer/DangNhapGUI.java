package presentationlayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class DangNhapGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTK;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					DangNhapGUI frame = new DangNhapGUI();
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
	public DangNhapGUI() {
		
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 392);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 128, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setForeground(new Color(255, 255, 255));
		btnTrangChu.setContentAreaFilled(false);
		btnTrangChu.setFont(btnTrangChu.getFont().deriveFont(btnTrangChu.getFont().getStyle() | Font.BOLD));
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setBounds(1, 114, 128, 23);
		panel.add(btnTrangChu);
		
		JButton btnLienHe = new JButton("Liên hệ");
		btnLienHe.setForeground(new Color(255, 255, 255));
		btnLienHe.setContentAreaFilled(false);
		btnLienHe.setFont(btnLienHe.getFont().deriveFont(btnLienHe.getFont().getStyle() | Font.BOLD));
		btnLienHe.setBackground(new Color(255, 255, 255));
		btnLienHe.setBorderPainted(false);
		btnLienHe.setBounds(1, 162, 128, 23);
		panel.add(btnLienHe);
		
		JButton btnHoTro = new JButton("Hỗ trợ");
		btnHoTro.setForeground(new Color(255, 255, 255));
		btnHoTro.setContentAreaFilled(false);
		btnHoTro.setFont(btnHoTro.getFont().deriveFont(btnHoTro.getFont().getStyle() | Font.BOLD));
		btnHoTro.setBackground(new Color(255, 255, 255));
		btnHoTro.setBorderPainted(false);
		btnHoTro.setBounds(1, 212, 128, 23);
		panel.add(btnHoTro);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 100, 0));
		separator.setBounds(1, 149, 128, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 100, 0));
		separator_1.setBounds(1, 199, 128, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MinhTri\\Pictures\\Hospital-512.png"));
		lblNewLabel.setBounds(27, 0, 75, 64);
		panel.add(lblNewLabel);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(lblTaiKhoan.getFont().deriveFont(lblTaiKhoan.getFont().getStyle() | Font.BOLD));
		lblTaiKhoan.setBounds(208, 133, 71, 14);
		contentPane.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(lblMatKhau.getFont().deriveFont(lblMatKhau.getFont().getStyle() | Font.BOLD));
		lblMatKhau.setBounds(208, 174, 56, 14);
		contentPane.add(lblMatKhau);
		
		textFieldTK = new JTextField();
		textFieldTK.setBounds(274, 126, 240, 28);
		contentPane.add(textFieldTK);
		textFieldTK.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(274, 167, 240, 28);
		contentPane.add(passwordField);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setFont(btnDangNhap.getFont().deriveFont(btnDangNhap.getFont().getStyle() | Font.BOLD));
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBorderPainted(false);
		btnDangNhap.setBackground(SystemColor.textHighlight);
		btnDangNhap.setBounds(165, 207, 194, 37);
		contentPane.add(btnDangNhap);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setFont(btnThoat.getFont().deriveFont(btnThoat.getFont().getStyle() | Font.BOLD));
		btnThoat.setBackground(new Color(220, 20, 60));
		btnThoat.setBorderPainted(false);
		btnThoat.setBounds(354, 207, 206, 37);
		contentPane.add(btnThoat);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnX.setBorderPainted(false);
		btnX.setBackground(Color.WHITE);
		btnX.setBounds(569, 0, 50, 37);
		contentPane.add(btnX);
		
	
		try {
			ImageIcon icon=new ImageIcon(new ImageIcon(this.getClass().getResource("/Hospital-512.png")).getImage());
			ImageIcon iconTitled=new ImageIcon(new ImageIcon(this.getClass().getResource("/titledCC.png")).getImage());
			JLabel label = new JLabel(iconTitled);
			label.setBounds(210, 57, 350, 45);
			contentPane.add(label);
			JLabel label_1 = new JLabel(icon);
			label_1.setBounds(342, 0, 78, 65);
			contentPane.add(label_1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		JLabel label_2 = new JLabel("Phần Mềm Quản Lí Quầy Thuốc Chuyên Nghiệp");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_2.setBounds(264, 88, 251, 14);
		contentPane.add(label_2);
	}
}
