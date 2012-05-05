package presentation.desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import util.Configuration;
import vo.UserVO;
import business.BusinessFactory;
import business.spec.IUsuario;

public class Login extends JFrame {

	private static Login instance;

	private JButton submitButton;

	private JButton quitButton;

	private JLabel loginLabel;

	private JLabel passwordLabel;

	private JTextField loginText;

	private JPasswordField passwordText;

	private JMenu menu;

	private JMenuBar menuBar;

	private List<Locale> locales = new ArrayList<Locale>();

	// private JMenuItem english;

	// private JMenuItem portuguese;

	// private Locale pt_BR = new Locale("pt", "BR");

	private ResourceBundle bundle;

	public static Login getInstance() {
		if (instance == null) {
			instance = new Login();
		}
		return instance;
	}

	private Login() {
		this.initComponents();
	}

	public String getLogin() {
		return loginText.getText();
	}

	private void initComponents() {
		loginText = new JTextField();
		submitButton = new JButton();
		loginLabel = new JLabel();
		passwordText = new JPasswordField();
		passwordLabel = new JLabel();
		quitButton = new JButton();
		menuBar = new JMenuBar();
		menu = new JMenu();
		/*
		 * english = new JMenuItem(); portuguese = new JMenuItem();
		 */
		bundle = ResourceBundle.getBundle("I18n.Resources");

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent event) {
				frameShow(event);
			}

		});

		loginText.setText("");
		loginLabel.setText(bundle.getString("login"));

		passwordText.setText("");
		passwordLabel.setText(bundle.getString("password"));

		submitButton.setText(bundle.getString("submit"));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				submitButtonActionPerformed(event);
			}
		});

		quitButton.setText("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quitButtonActionPerformed(evt);
			}
		});

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 3));
		p.add(loginLabel);
		p.add(loginText);
		p.add(passwordLabel);
		p.add(passwordText);
		p.add(submitButton);
		p.add(quitButton);
		this.getContentPane().add(BorderLayout.CENTER, p);

		menu.setText(bundle.getString("language"));

		Configuration configuration = Configuration.getInstance();

		for (int i = 0; configuration.getProperty("Language_" + i) != null; i++) {
			String language = configuration.getProperty("Language_" + i);
			String country = configuration.getProperty("Country_" + i);
			JMenuItem item = new JMenuItem();
			final Locale locale;
			if (!country.isEmpty()) {
				locale = new Locale(language, country);

			} else {
				locale = new Locale(language);
			}
			locales.add(locale);
			item.setText(locale.getDisplayName());
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					Locale.setDefault(locale);
					bundle = ResourceBundle.getBundle("I18n.Resources");
					frameShow(null);
				}
			});
			menu.add(item);
		}

		/*
		 * english.setText(Locale.ENGLISH.getDisplayName());
		 * english.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent event) {
		 * Locale.setDefault(Locale.ENGLISH); bundle =
		 * ResourceBundle.getBundle("I18n.Resources"); frameShow(null); } });
		 * menu.add(english);
		 * 
		 * portuguese.setText(pt_BR.getDisplayName());
		 * portuguese.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent event) { Locale.setDefault(pt_BR); bundle =
		 * ResourceBundle.getBundle("I18n.Resources"); frameShow(null); } });
		 * menu.add(portuguese);
		 */
		menuBar.add(menu);

		this.setJMenuBar(menuBar);
		pack();
	}

	private void refreshComponents() {
		loginLabel.setText(bundle.getString("login"));
		passwordLabel.setText(bundle.getString("password"));
		passwordText.setText("");
		submitButton.setText(bundle.getString("submit"));
		for (int i = 0; i < locales.size(); i++) {
			((JMenuItem) menu.getMenuComponent(i)).setText(locales.get(i)
					.getDisplayName());
		}
		menu.setText(bundle.getString("language"));
	}

	private void frameShow(ComponentEvent event) {
		this.refreshComponents();
		this.pack();
	}

	private void quitButtonActionPerformed(ActionEvent event) {
		Menu.getInstance().dispose();
		Message.getInstance().dispose();
		this.dispose();
	}

	private boolean authenticate() {
		String login = loginText.getText();
		String password = String.copyValueOf(passwordText.getPassword());

		boolean isAuthenticated = false;
		IUsuario user = BusinessFactory.getInstance().getUser();
		UserVO vo = new UserVO(login, password);
		try {
			isAuthenticated = user.authenticate(vo);
		} catch (Exception e) {
			isAuthenticated = false;
		}
		return isAuthenticated;
	}

	private void submitButtonActionPerformed(ActionEvent event) {

		try {
			this.setVisible(false);
			if (authenticate()) {
				Menu.getInstance().setVisible(true);
			} else {
				Message.getInstance().setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Login.getInstance().setVisible(true);
			}
		});
	}

}
