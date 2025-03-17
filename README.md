
package Regex_QLSach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class FrmDanhMucSach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;
	private DefaultTableModel tableModel;
	private JComboBox<String> cboMaSach;

	public FrmDanhMucSach() {
		setTitle("ÔN TẬP BIỂU THỨC CHÍNH QUY");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		pnlNorth.add(lblMaSach = new JLabel("Ma sach: "));
		pnlNorth.add(lblTuaSach = new JLabel("Tên Sách "));
		pnlNorth.add(lblTacGia = new JLabel("Tac giả: "));
		pnlNorth.add(lblNamXB = new JLabel("Năm Xuất bản: "));
		pnlNorth.add(lblNhaXB = new JLabel("Nhà  xuất bản "));
		pnlNorth.add(lblSoTrang = new JLabel("Số trang: "));
		pnlNorth.add(lblDonGia = new JLabel("Đơn giá: "));
		pnlNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

		pnlNorth.add(txtMaSach = new JTextField());
		pnlNorth.add(txtTuaSach = new JTextField());
		pnlNorth.add(txtTacGia = new JTextField());
		pnlNorth.add(txtNamXB = new JTextField());
		pnlNorth.add(txtNhaXB = new JTextField());
		pnlNorth.add(txtSoTrang = new JTextField());
		pnlNorth.add(txtDonGia = new JTextField());
		pnlNorth.add(txtISBN = new JTextField());

		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaSach.setBounds(20, 20, w1, h);
		txtMaSach.setBounds(120, 20, 200, h);

		lblTuaSach.setBounds(20, 45, w1, h);
		txtTuaSach.setBounds(120, 45, w2, h);
		lblTacGia.setBounds(450, 45, w1, h);
		txtTacGia.setBounds(570, 45, w2, h);

		lblNamXB.setBounds(20, 70, w1, h);
		txtNamXB.setBounds(120, 70, w2, h);
		lblNhaXB.setBounds(450, 70, w1, h);
		txtNhaXB.setBounds(570, 70, w2, h);

		lblSoTrang.setBounds(20, 95, w1, h);
		txtSoTrang.setBounds(120, 95, w2, h);
		lblDonGia.setBounds(450, 95, w1, h);
		txtDonGia.setBounds(570, 95, w2, h);

		lblISBN.setBounds(20, 120, 220, h);
		txtISBN.setBounds(240, 120, 180, h);
		txtMess.setBounds(20, 145, 550, 20);

		// Pháº§n Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm vào Table"));
		pnlCenter.add(btnXoaRong = new JButton("Làm rỗng"));
		// Pháº§n South
		JScrollPane scroll;
		String[] headers = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");

		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách các quyển sách:"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (isValdate()) {
				Sach s = revertSachFromTextFields();
				txtMess.setText("Thêm thành công 1 cuốn sách");
//				cboMaSach.addItem(txtMaSach.getText());
				tableModel.addRow(s.toRow());

			} else if (o.equals(btnXoaRong)) {
				txtMaSach.setText("");
				txtTuaSach.setText("");
				txtTacGia.setText("");
				txtNamXB.setText("");
				txtNhaXB.setText("");
				txtSoTrang.setText("");
				txtDonGia.setText("");
				txtISBN.setText("");
				txtMaSach.setEditable(true);
				txtMaSach.requestFocus();
			}
		}
		if (o.equals(btnXoaRong)) {
			txtMaSach.setText("");
			txtTuaSach.setText("");
			txtTacGia.setText("");
			txtNamXB.setText("");
			txtNhaXB.setText("");
			txtSoTrang.setText("");
			txtDonGia.setText("");
			txtISBN.setText("");
			txtMaSach.setEditable(true);
			txtMaSach.requestFocus();
		}
	}

	private Sach revertSachFromTextFields() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();

		String nam = txtNamXB.getText().trim();
		int namXB = nam.length() == 0 ? 0 : Integer.parseInt(nam); // Để trống thì coi như là 0

		String nhaXB = txtNhaXB.getText().trim();

		String trang = txtSoTrang.getText().trim();
		int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);

		String gia = txtDonGia.getText().trim();
		double donGia = gia.equals("") ? 0 : Double.parseDouble(gia);

		String isbn = txtISBN.getText().trim();
		return new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, isbn);
	}

	public boolean isValdate() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String nam = txtNamXB.getText().trim();
		String donGia = txtDonGia.getText().trim();
		String isbn = txtISBN.getText().trim();
		String soTrang = txtSoTrang.getText().trim();
		if (!(maSach.length() > 0 && maSach.matches("[A-Z]\\d{3}"))) {
			JOptionPane.showMessageDialog(this, "Error: Mã sách theo mẫu: [A-Z]\\d{3}");
			return false;
		}
		if (!(tuaSach.length() > 0 && tuaSach.matches("[a-zA-Z' ]+"))) {
			showMessage("Error: a sách theo mẫu: [a-zA-Z' ]+", txtTuaSach);
			return false;
		}
		if (!(tacGia.length() > 0 && tacGia.matches("[a-zA-Z' ]+"))) {
			showMessage("Error: tác giả theo mẫu: [a-zA-Z' ]+", txtTacGia);
			return false;
		}
		if (nam.length() > 0) {
			try {
				int x = Integer.parseInt(nam);
				int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
				if (!(x >= 1900 && x < namHienTai)) {
					showMessage("Error:Năm xuất bản >=1900 && <=" + namHienTai, txtNamXB);
					return false;
				}
			} catch (NumberFormatException ex) {
				showMessage("Năm xuất bản phải nhập số", txtNamXB);
				return false;
			}
			// TODO: handle exception
		}
		if (soTrang.length() > 0) {
			try {
				int x = Integer.parseInt(soTrang);
				if (x <= 0) {
					showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
					return false;
				}
			} catch (NumberFormatException ex) {
				showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
				return false;
			}
		}

		if (donGia.length() > 0) {
			try {
				double y = Double.parseDouble(donGia);
				if (y < 0) {
					showMessage("Error: Đơn giá phải > 0.", txtDonGia);
					return false;
				}
			} catch (NumberFormatException ex) {
				showMessage("Error: Đơn giá phải nhập số.", txtDonGia);
				return false;
			}
		}
		// ISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X).
		// Trong đó, X gồm các ký số, ít nhất là 1 ký số
		if (isbn.length() > 0)
			if (!isbn.matches("\\d+(-\\d+){3,4}")) {
				showMessage("Error: ISBN có mẫu dạng  X-X-X-X  (hoặc X-X-X-X-X).", txtISBN);
				return false;
			}

		return true;
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);

	}

}

