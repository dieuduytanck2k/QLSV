package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {
	public QLSVModel model;
	public JTextField textField_maThiSinh_timKiem;
	public JTable table;
	public JPanel contentPane;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public JComboBox comboBox_QueQuan;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox comboBox_QueQuan_timKiem;

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 688);

		QLSVController action = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuAbout.add(menuAboutMe);

		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel label_QueQuan = new JLabel("Quê quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_QueQuan.setBounds(49, 11, 92, 51);
		contentPane.add(label_QueQuan);

		JLabel label_maSinhVien = new JLabel("Mã thí sinh");
		label_maSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_maSinhVien.setBounds(360, 11, 121, 51);
		contentPane.add(label_maSinhVien);

		JButton btn_Tim = new JButton("Tìm");
		btn_Tim.addActionListener(action);
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Tim.setBounds(671, 11, 135, 51);
		contentPane.add(btn_Tim);

		textField_maThiSinh_timKiem = new JTextField();
		textField_maThiSinh_timKiem.setColumns(10);
		textField_maThiSinh_timKiem.setBounds(491, 11, 170, 51);
		contentPane.add(textField_maThiSinh_timKiem);

		comboBox_QueQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_QueQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan_timKiem.setBounds(163, 15, 170, 51);
		contentPane.add(comboBox_QueQuan_timKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 73, 918, 2);
		contentPane.add(separator_1);

		JLabel label_danhSachThiSinh = new JLabel("Danh sách thí sinh");
		label_danhSachThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_danhSachThiSinh.setBounds(10, 92, 164, 25);
		contentPane.add(label_danhSachThiSinh);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
				}
				));
		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 128, 918, 177);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 316, 918, 2);
		contentPane.add(separator_1_1);

		JLabel label_ID = new JLabel("Mã thí sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_ID.setBounds(10, 374, 97, 25);
		contentPane.add(label_ID);

		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(141, 380, 113, 20);
		contentPane.add(textField_ID);

		JLabel lblNewLabel = new JLabel("Thông tin thí sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 323, 170, 27);
		contentPane.add(lblNewLabel);

		JLabel label_HoVaTen = new JLabel("Họ và tên");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_HoVaTen.setBounds(10, 410, 87, 25);
		contentPane.add(label_HoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(141, 416, 113, 20);
		contentPane.add(textField_HoVaTen);

		JLabel label_queQuan = new JLabel("Quê quán");
		label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_queQuan.setBounds(10, 446, 86, 25);
		contentPane.add(label_queQuan);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(141, 488, 113, 20);
		contentPane.add(textField_NgaySinh);

		JLabel label_ngaySinh = new JLabel("Ngày sinh");
		label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_ngaySinh.setBounds(10, 482, 87, 25);
		contentPane.add(label_ngaySinh);

		comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}

		comboBox_QueQuan.setBounds(141, 451, 113, 22);
		contentPane.add(comboBox_QueQuan);

		JLabel label_gioiTinh = new JLabel("Giới tính");
		label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_gioiTinh.setBounds(289, 374, 97, 25);
		contentPane.add(label_gioiTinh);

		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioButton_nam.setBounds(392, 376, 53, 25);
		contentPane.add(radioButton_nam);

		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioButton_nu.setBounds(452, 376, 53, 25);
		contentPane.add(radioButton_nu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);

		textField_Mon1 = new JTextField();
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(406, 416, 113, 20);
		contentPane.add(textField_Mon1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(406, 452, 113, 20);
		contentPane.add(textField_Mon2);

		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(406, 488, 113, 20);
		contentPane.add(textField_Mon3);

		JLabel label_Mon1 = new JLabel("Môn 1");
		label_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon1.setBounds(289, 410, 87, 25);
		contentPane.add(label_Mon1);

		JLabel label_Mon2 = new JLabel("Môn 2");
		label_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon2.setBounds(289, 446, 87, 25);
		contentPane.add(label_Mon2);

		JLabel label_Mon3 = new JLabel("Môn 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon3.setBounds(289, 482, 87, 25);
		contentPane.add(label_Mon3);

		JButton btn_Them = new JButton("Thêm");
		btn_Them.addActionListener(action);
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Them.setBounds(10, 530, 83, 33);
		contentPane.add(btn_Them);

		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.addActionListener(action);
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Xoa.setBounds(141, 530, 67, 33);
		contentPane.add(btn_Xoa);

		JButton btn_CapNhat = new JButton("Cập nhật");
		btn_CapNhat.addActionListener(action);
		btn_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_CapNhat.setBounds(251, 530, 113, 33);
		contentPane.add(btn_CapNhat);

		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.addActionListener(action);
		btn_Luu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Luu.setBounds(406, 530, 113, 33);
		contentPane.add(btn_Luu);

		JButton btn_HuyBo = new JButton("Hủy bỏ");
		btn_HuyBo.addActionListener(action);
		btn_HuyBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_HuyBo.setBounds(548, 530, 113, 33);
		contentPane.add(btn_HuyBo);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 519, 918, 2);
		contentPane.add(separator_1_1_1);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuyTim.setBounds(809, 11, 135, 51);
		contentPane.add(btnHuyTim);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_maThiSinh_timKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_QueQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = df.format(ts.getNgaySinh());
		model_table.addRow(new Object[]{
				ts.getMaThiSinh()+"", 
				ts.getTenThiSinh(),
				ts.getQueQuan().getTenTinh(),
				dateString,
				(ts.isGioiTinh()?"Nam":"Nữ"),
				ts.getDiemMon1()+"",
				ts.getDiemMon2()+"",
				ts.getDiemMon3()+"",
		});
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = df.format(ts.getNgaySinh());
		if(!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		}else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(ts.getMaThiSinh()+"")) {
					model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
					model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"", i, 2);
					model_table.setValueAt(dateString, i, 3);
					model_table.setValueAt((ts.isGioiTinh()?"Nam":"Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
					model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
					model_table.setValueAt(ts.getDiemMon3()+"", i, 7);
				}
			}
		}
	}

	public void capNhatThiSinh(ThiSinh ts) {

	}

	public ThiSinh getThiSinhDaChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDaChon();

		this.textField_ID.setText(ts.getMaThiSinh()+"");
		this.textField_HoVaTen.setText(ts.getTenThiSinh()+"");
		this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = df.format(ts.getNgaySinh());
		this.textField_NgaySinh.setText(dateString);
		if(ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		}else {
			radioButton_nu.setSelected(true);
		}

		this.textField_Mon1.setText(ts.getDiemMon1()+"");
		this.textField_Mon2.setText(ts.getDiemMon2()+"");
		this.textField_Mon3.setText(ts.getDiemMon3()+"");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn?");
		if(luaChon==JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDaChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemThiSinh() {
		// Get dữ liệu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_QueQuan.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		if(this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		}else if(this.radioButton_nu.isSelected()){
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTim() {
		//Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		//Thuc hien tim kiem
		int queQuan = this.comboBox_QueQuan_timKiem.getSelectedIndex()-1;
		String maThiSinhTimKiem = this.textField_maThiSinh_timKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id = model_table.getValueAt(i, 0) + "";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if(maThiSinhTimKiem.length()>0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if(idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: "+i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, 
				"Bạn có chắc chắn muốn thoát khỏi chương trình?",
				"Exit",
				JOptionPane.YES_NO_OPTION
				);
		if(luaChon==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			ThiSinh ts = null;
			while((ts =(ThiSinh) ois.readObject())!= null) {
				ds.add(ts);
			}
			
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
	}
}

