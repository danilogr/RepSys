package presentation.desktop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import vo.ContaVO;
import vo.UserVO;
import business.BusinessException;
import business.BusinessFactory;
import business.spec.IConta;
import business.spec.IUsuario;

public class Menu extends JFrame {

	private static Menu instance;

	private JMenu menu;

	private JMenuBar menuBar;

	private JMenuItem listUsers;

	private JMenuItem getBalance;

	private JMenuItem logout;

	private JScrollPane mainPane;

	private JTable table;

	private ResourceBundle bundle;

	private Menu() {
		initComponents();
	}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}

	private void initComponents() {
		mainPane = new JScrollPane();
		table = new JTable();
		menuBar = new JMenuBar();
		menu = new JMenu();
		listUsers = new JMenuItem();
		getBalance = new JMenuItem();
		logout = new JMenuItem();

		bundle = ResourceBundle.getBundle("I18n.Resources");

		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent event) {
				frameShow(event);
			}

			public void componentHidden(ComponentEvent event) {
				frameHidden(event);
			}
		});
		this.setSize(200, 200);

		mainPane.setEnabled(true);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null },
				{ null, null }, { null, null }, { null, null } }, new String[] {
				"Title 1", "Title 2" }));
		mainPane.setViewportView(table);

		menu.setText(bundle.getString("menuTitle"));
		listUsers.setText(bundle.getString("userList"));
		listUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				listUsersActionPerformed(event);
			}
		});

		menu.add(listUsers);

		getBalance.setText(bundle.getString("balance"));
		getBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				getBalanceActionPerformed(event);
			}
		});

		menu.add(getBalance);

		logout.setText(bundle.getString("logout"));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				logoutActionPerformed(event);
			}
		});

		menu.add(logout);

		menuBar.add(menu);

		this.setJMenuBar(menuBar);

		this.getContentPane().add(BorderLayout.NORTH, mainPane);
		pack();
	}

	private void frameShow(ComponentEvent event) {
		mainPane.setVisible(false);
		bundle = ResourceBundle.getBundle("I18n.Resources");
		menu.setText(bundle.getString("menuTitle"));
		listUsers.setText(bundle.getString("userList"));
		getBalance.setText(bundle.getString("balance"));
		logout.setText(bundle.getString("logout"));
	}

	private void frameHidden(ComponentEvent event) {
		this.setVisible(false);
		Login.getInstance().setVisible(true);
	}

	private void logoutActionPerformed(ActionEvent event) {
		this.setVisible(false);
		Login.getInstance().setVisible(true);
	}

	private void getBalanceActionPerformed(ActionEvent event) {
		String[] header;
		String[][] data;
		BusinessFactory factory = BusinessFactory.getInstance();
		try {
			String login = Login.getInstance().getLogin();
			IUsuario user = factory.getUser();
			UserVO userVO = user.getUsuarioByLogin(login);
			IConta account = factory.getAccount();
			ContaVO accountVO = account.getContaByUsuario(userVO.getId());
			header = new String[2];
			header[0] = bundle.getString("login");
			header[1] = bundle.getString("balance");
			data = new String[1][2];
			data[0][0] = login;
			data[0][1] = accountVO.getSaldo().toString();
			table.setModel(new DefaultTableModel(data, header));
		} catch (BusinessException e) {
                    e.printStackTrace();
			table.setModel(null);
		}
		mainPane.setVisible(true);
		mainPane.setViewportView(table);
	}

	private void listUsersActionPerformed(ActionEvent event) {

		String[] header;
		String[][] data;
		BusinessFactory factory = BusinessFactory.getInstance();
		try {
			IUsuario user = factory.getUser();
			List list = user.getAll();
			int size = list.size();
			header = new String[2];
			header[0] = bundle.getString("login");
			header[1] = bundle.getString("name");
			data = new String[size][2];

			for (int i = 0; i < size; i++) {
				UserVO vo = (UserVO) list.get(i);
				data[i][0] = vo.getLogin();
				data[i][1] = vo.getNome();
			}
			table.setModel(new DefaultTableModel(data, header));
		} catch (BusinessException e) {
			table.setModel(null);
		}
		mainPane.setVisible(true);
		mainPane.setViewportView(table);
	}
}
