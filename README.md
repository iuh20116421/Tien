package QlCongTrinh;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FrmCongTrinh extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenCT;
	private JTextField txtChiPhiUocTinh;
	private JComboBox cboLoaiCT;
	private JTextField txtMaCT;
	private JTextField txtChuDauTu;
	private JTextField txtMess;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTim;
	private JButton btnLamMoi;
	private JButton btnLuu;
	private JButton btnThem;
	private JTextField txtMaCTSearch;
	private int selectedRow;
	private File file = new File("src/QlCongTrinh/congtrinh.txt");

	public FrmCongTrinh() {
		setTitle("Quản lý Công Trình");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
		loadDataFromFile();
	}

	private void buildUI() {

		// North Panel (Form nhập liệu)
		JPanel pnlNorth = new JPanel();
		add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));

		TitledBorder titledBorder = BorderFactory.createTitledBorder("- THÔNG TIN CÔNG TRÌNH -");
		titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 18));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		pnlNorth.setBorder(titledBorder);
		pnlNorth.setLayout(null);
		// Khi
//		pnlNorth.setBorder(BorderFactory.createTitledBorder("Thông Tin Công Trình"));
//		pnlNorth.setLayout(null);

		JLabel lblMaCT, lblTenCT, lblChiPhiUocTinh, lblLoaiCT, lblChuDauTu;
		pnlNorth.add(lblMaCT = new JLabel("Mã Công Trình: "));
		pnlNorth.add(lblTenCT = new JLabel("Tên Công Trình: "));
		pnlNorth.add(lblChiPhiUocTinh = new JLabel("Chi Phí Ước Tính: "));
		pnlNorth.add(lblLoaiCT = new JLabel("Loại Công Trình: "));
		pnlNorth.add(lblChuDauTu = new JLabel("Chủ Đầu Tư: "));

		pnlNorth.add(txtMaCT = new JTextField());
		pnlNorth.add(txtTenCT = new JTextField());
		pnlNorth.add(txtChiPhiUocTinh = new JTextField());
		pnlNorth.add(cboLoaiCT = new JComboBox<>(new String[] { "Nhà ở", "Kho xưởng" }));
		pnlNorth.add(txtChuDauTu = new JTextField());

		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 150, w2 = 300, w3 = 300, h = 20;

		// Kéo dài mã công trình
		lblMaCT.setBounds(20, 20, w1, h);
		txtMaCT.setBounds(120, 20, 750, h); // Kéo dài txtMaCT

		// Tên công trình và chi phí ước tính chung hàng
		lblTenCT.setBounds(20, 45, w1, h);
		txtTenCT.setBounds(120, 45, w2, h);
		lblChiPhiUocTinh.setBounds(450, 45, w1, h);
		txtChiPhiUocTinh.setBounds(570, 45, w3, h);

		// Loại công trình và chủ đầu tư chung hàng
		lblLoaiCT.setBounds(20, 70, w1, h);
		cboLoaiCT.setBounds(120, 70, 100, h);
		lblChuDauTu.setBounds(450, 70, w1, h);
		txtChuDauTu.setBounds(570, 70, w3, h);

		txtMess.setBounds(20, 95, 550, 20);
		// Center Panel (Table)
		JPanel pnlCenter = new JPanel();
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout());

		String[] headers = "MaCT;TenCT;TongChiPhi;LoaiCT;ChuDauTu".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		table = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane(table);
		pnlCenter.add(scroll, BorderLayout.CENTER);
//		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách công trình"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		table.addMouseListener(new MouseAdapter() {
			private int selectedRow;

			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					txtMaCT.setText(tableModel.getValueAt(selectedRow, 0).toString());
					txtTenCT.setText(tableModel.getValueAt(selectedRow, 1).toString());
					txtChiPhiUocTinh.setText(tableModel.getValueAt(selectedRow, 2).toString());
					cboLoaiCT.setSelectedItem(tableModel.getValueAt(selectedRow, 3).toString());
					txtChuDauTu.setText(tableModel.getValueAt(selectedRow, 4).toString());
					txtMess.setText("Đã chọn công trình để sửa!");
				}
			}
		});

		// South Panel (Nút sự kiện)
		JPanel pnlSouth = new JPanel();
		add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout());

		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnLuu = new JButton("Lưu File");
		btnLamMoi = new JButton("Làm Mới");
		btnTim = new JButton("Tìm");

		txtMaCTSearch = new JTextField(10);

		pnlSouth.add(new JLabel("Nhập mã công trình cần tìm: "));
		pnlSouth.add(txtMaCTSearch);
		pnlSouth.add(btnTim);
		pnlSouth.add(btnThem);
		pnlSouth.add(btnLamMoi);
		pnlSouth.add(btnSua);
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnLuu);

		// Event listener cho các nút
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTim.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btnThem)) {
			// Kiểm tra các trường hợp rỗng
			if (txtMaCT.getText().trim().isEmpty() || txtTenCT.getText().trim().isEmpty()) {
				txtMess.setText("Các trường mã công trình và tên công trình không được để trống!");
				return;
			}

			// Kiểm tra mã công trình đã tồn tại hay chưa
			String maCT = txtMaCT.getText().trim();
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				if (tableModel.getValueAt(i, 0).equals(maCT)) {
					txtMess.setText("Mã công trình đã tồn tại!");
					return;
				}
			}

			// Thêm công trình vào bảng và cboMaCT
			String[] rowData = { maCT, txtTenCT.getText().trim(), txtChiPhiUocTinh.getText().trim(),
					cboLoaiCT.getSelectedItem().toString(), txtChuDauTu.getText().trim() };
			tableModel.addRow(rowData);

			txtMess.setText("Thêm thành công!");
		} else if (source.equals(btnXoa)) {
			if (selectedRow != -1) {
				tableModel.removeRow(selectedRow);
				txtMess.setText("Xóa thành công!");
				clearFields();
			} else {
				txtMess.setText("Vui lòng chọn công trình để xóa!");
			}

		} else if (source.equals(btnTim)) {
			String maCTSearch = txtMaCTSearch.getText();
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				if (tableModel.getValueAt(i, 0).equals(maCTSearch)) {
					table.setRowSelectionInterval(i, i);
					return;
				}
			}
			JOptionPane.showMessageDialog(this, "Không tìm thấy công trình!");

		} else if (source.equals(btnSua)) {
			if (selectedRow != -1) {
				tableModel.setValueAt(txtMaCT.getText().trim(), selectedRow, 0);
				tableModel.setValueAt(txtTenCT.getText().trim(), selectedRow, 1);
				tableModel.setValueAt(txtChiPhiUocTinh.getText().trim(), selectedRow, 2);
				tableModel.setValueAt(cboLoaiCT.getSelectedItem().toString(), selectedRow, 3);
				tableModel.setValueAt(txtChuDauTu.getText().trim(), selectedRow, 4);
				txtMess.setText("Sửa thành công!");
			} else {
				txtMess.setText("Vui lòng chọn công trình để sửa!");
			}
		} else if (source.equals(btnLuu)) {
			// Lưu dữ liệu từ JTable vào file txt
			saveDataToFile();
		} else if (source.equals(btnLamMoi)) {
			clearFields();
		}
	}

	private void saveDataToFile() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				for (int j = 0; j < tableModel.getColumnCount(); j++) {
					bw.write(tableModel.getValueAt(i, j).toString());
					if (j < tableModel.getColumnCount() - 1) {
						bw.write(";");
					}
				}
				bw.newLine();
			}
			txtMess.setText("Dữ liệu đã được lưu vào file!");
		} catch (IOException e) {
			txtMess.setText("Lỗi khi lưu dữ liệu!");
			e.printStackTrace();
		}
	}

	private void clearFields() {
		txtMaCT.setText("");
		txtTenCT.setText("");
		txtChiPhiUocTinh.setText("");
		cboLoaiCT.setSelectedIndex(0);
		txtChuDauTu.setText("");
		selectedRow = -1;
	}

	private void searchCongTrinh() {
		String maCTSearch = txtMaCTSearch.getText();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (tableModel.getValueAt(i, 0).equals(maCTSearch)) {
				table.setRowSelectionInterval(i, i);
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Không tìm thấy công trình!");
	}

	private void loadDataFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				tableModel.addRow(data);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FrmCongTrinh().setVisible(true);
	}
}
