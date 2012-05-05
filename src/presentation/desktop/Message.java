package presentation.desktop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Message extends JFrame {

	private static Message instance;

	private JButton quitButton;

	private JLabel messageLabel;

	private ResourceBundle bundle;

	public static Message getInstance() {
		if (instance == null) {
			instance = new Message();
		}
		return instance;
	}

	private Message() {
		this.initComponents();
	}

	private void initComponents() {
		messageLabel = new JLabel();
		quitButton = new JButton();

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
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent event) {
				frameShow(event);
			}
		});

		messageLabel.setText(bundle.getString("passwordMessage"));
		quitButton.setText("OK");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quitButtonActionPerformed(evt);
			}
		});

		this.getContentPane().add(BorderLayout.NORTH, messageLabel);
		this.getContentPane().add(BorderLayout.SOUTH, quitButton);
		pack();
	}

	private void frameShow(ComponentEvent event) {
		bundle = ResourceBundle.getBundle("I18n.Resources");
		messageLabel.setText(bundle.getString("passwordMessage"));
		this.pack();
	}

	private void frameHidden(ComponentEvent event) {
		this.setVisible(false);
		Login.getInstance().setVisible(true);
	}

	private void quitButtonActionPerformed(ActionEvent event) {
		this.setVisible(false);
		Login.getInstance().setVisible(true);
	}
}
