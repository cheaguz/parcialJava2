package parcial2java;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class parcialGrafico extends JFrame {

	private JPanel contentPane;
	private int temperaturaSeleccionada=0;
	private int recintoSeleccionado;
	private JTextPane selectTemperatura;
	private JTextPane recSeleccionado;
	private JTextPane recStatus;
	private int barra = 110;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parcialGrafico frame = new parcialGrafico();
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
	public parcialGrafico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		recSeleccionado = new JTextPane();
		recSeleccionado.setFont(new Font("Sylfaen", Font.ITALIC, 15));
		recSeleccionado.setEditable(false);
		recSeleccionado.setBounds(438, 218, 136, 23);
		contentPane.add(recSeleccionado);
		
		JButton btnIzq = new JButton("<<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tempText = Integer.parseInt(selectTemperatura.getText());
				if(tempText!=0) {
					temperaturaSeleccionada =tempText - 10;
					selectTemperatura.setText(String.valueOf(temperaturaSeleccionada));
				}
				if(barra>110) {
					barra = barra - 20;
					repaint();
				}
				
			}
		});
		
		btnIzq.setBounds(110, 207, 76, 49);
		contentPane.add(btnIzq);
		
		JButton btnDer = new JButton(">>");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tempText = Integer.parseInt(selectTemperatura.getText());
				if(tempText!=100) {
					temperaturaSeleccionada =tempText + 10;
					selectTemperatura.setText(String.valueOf(temperaturaSeleccionada));
				}
				if(barra < 300) {
					barra = barra+20;
					repaint();	
				}
			}
		});
		btnDer.setBounds(261, 207, 76, 49);
		contentPane.add(btnDer);
		
		JButton btnCalefaccionar = new JButton("Calefaccionar");
		btnCalefaccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(recintoSeleccionado==1 && temperaturaSeleccionada<=50) {
					recStatus.setText("Correcto!");
				}else if(recintoSeleccionado==1 && temperaturaSeleccionada >50) {
					recStatus.setText("Incorrecto");
				}
				
				//recinto 2
				else if(recintoSeleccionado==2 && temperaturaSeleccionada<=80) {
					recStatus.setText("Correcto!");
				}else if (recintoSeleccionado==2 && temperaturaSeleccionada > 80){
					recStatus.setText("Incorrecto");
				}
				//recinto 3
				else if(recintoSeleccionado==3&&temperaturaSeleccionada>=0) {
					recStatus.setText("Correcto!");
				}else if(recintoSeleccionado==0){
					recStatus.setText("Incorrecto");
				}
			}
		});
		btnCalefaccionar.setBounds(55, 281, 126, 49);
		contentPane.add(btnCalefaccionar);
		
		
		JButton btnInicializar = new JButton("Inicialiar");
		btnInicializar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectTemperatura.setText("0");
				recSeleccionado.setText("");
				recStatus.setText("");
				recintoSeleccionado = 0;
				barra = 110;
				repaint();
			}
		});
		btnInicializar.setBounds(261, 281, 126, 49);
		contentPane.add(btnInicializar);
		
		JLabel Temperatura = new JLabel("Temperatura");
		Temperatura.setBounds(55, 37, 88, 23);
		contentPane.add(Temperatura);
		
		JButton btnRec1 = new JButton("Recinto 1");
		btnRec1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recintoSeleccionado = 1;
				recSeleccionado.setText("  Recinto 1");
				
			}
		});
		btnRec1.setBounds(438, 60, 136, 23);
		contentPane.add(btnRec1);
		
		JButton btnRec2 = new JButton("Recinto 2");
		btnRec2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recintoSeleccionado = 2;
				recSeleccionado.setText("  Recinto 2");
				
			}
		});
		btnRec2.setBounds(438, 109, 136, 23);
		contentPane.add(btnRec2);
		
		JButton btnRec3 = new JButton("Recinto 3");
		btnRec3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recintoSeleccionado = 3;
				recSeleccionado.setText("  Recinto 3");
			}
		});
		btnRec3.setBounds(438, 158, 136, 23);
		contentPane.add(btnRec3);
		
		recStatus = new JTextPane();
		recStatus.setEditable(false);
		recStatus.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		recStatus.setBounds(424, 281, 150, 49);
		contentPane.add(recStatus);
		
		
		selectTemperatura = new JTextPane();
		selectTemperatura.setBackground(Color.WHITE);
		selectTemperatura.setForeground(Color.BLACK);
		selectTemperatura.setEditable(false);
		selectTemperatura.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		selectTemperatura.setText("0");
		selectTemperatura.setBounds(170, 22, 76, 61);
		contentPane.add(selectTemperatura);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(100, 162, 33, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("20");
		lblNewLabel_1.setBounds(140, 162, 23, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("40");
		lblNewLabel_2.setBounds(180, 162, 23, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("60");
		lblNewLabel_3.setBounds(220, 162, 17, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("80");
		lblNewLabel_4.setBounds(260, 162, 23, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("100");
		lblNewLabel_5.setBounds(300, 162, 33, 14);
		contentPane.add(lblNewLabel_5);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		 g.drawRect(100,130,240,60);
		 //linea 
		 g.setColor(Color.red);
		 g.drawLine(barra, 190, barra, 130);
	
	}
}
