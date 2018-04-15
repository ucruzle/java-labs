package br.northwind.otimize.jdbc.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import br.northwind.otimize.jdbc.bo.LoginBO;
import br.northwind.otimize.jdbc.dto.LoginDTO;
import br.northwind.otimize.jdbc.exception.NegocioException;
import br.northwind.otimize.jdbc.util.MensagensUtil;

import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LoginFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton btnSair;
	private JButton btnLogar;
	private JPanel panelLogin;
	private JTextField txtLogin;
	private JPasswordField passSenha;
	private JLabel lblSenha;
	private JLabel lblLogin;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginFrame inst = new LoginFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				btnSair = new JButton();
				btnSair.setText("Sair");
				btnSair.setFont(new java.awt.Font("Segoe UI",1,16));
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.exit(0);
					}
				});
			}
			{
				panelLogin = new JPanel();
				GroupLayout panelLoginLayout = new GroupLayout((JComponent)panelLogin);
				panelLogin.setLayout(panelLoginLayout);
				panelLogin.setBorder(BorderFactory.createTitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				panelLogin.setFont(new java.awt.Font("Segoe UI",1,20));
				{
					lblLogin = new JLabel();
					lblLogin.setText("Login:");
				}
				{
					txtLogin = new JTextField();
				}
				{
					lblSenha = new JLabel();
					lblSenha.setText("Senha:");
				}
				{
					passSenha = new JPasswordField();
				}
				panelLoginLayout.setHorizontalGroup(panelLoginLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLoginLayout.createParallelGroup()
					    .addComponent(lblLogin, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblSenha, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLoginLayout.createParallelGroup()
					    .addComponent(passSenha, GroupLayout.Alignment.LEADING, 0, 285, Short.MAX_VALUE)
					    .addComponent(txtLogin, GroupLayout.Alignment.LEADING, 0, 285, Short.MAX_VALUE))
					.addContainerGap());
				panelLoginLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {passSenha, txtLogin});
				panelLoginLayout.setVerticalGroup(panelLoginLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtLogin, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblLogin, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(passSenha, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblSenha, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, 25));
				panelLoginLayout.linkSize(SwingConstants.VERTICAL, new Component[] {passSenha, txtLogin});
			}
			{
				btnLogar = new JButton();
				btnLogar.setText("Logar");
				btnLogar.setFont(new java.awt.Font("Segoe UI",1,16));
				btnLogar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						LoginDTO dto = new LoginDTO();
						dto.setLogin(txtLogin.getText());
						dto.setSenha(passSenha.getSelectedText());
						
						LoginBO bo = new LoginBO();
						
						try {
							
							if (bo.logar(dto)) {
								MensagensUtil.addMsg(LoginFrame.this, "Login efetuado com sucesso!");
							} else {
								MensagensUtil.addMsg(LoginFrame.this, "Dados inválidos!");
							}
							
						} catch (NegocioException e) {
							e.printStackTrace();
							MensagensUtil.addMsg(LoginFrame.this, e.getMessage());
						}
						
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(btnLogar, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnSair, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(panelLogin, 0, 359, Short.MAX_VALUE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 178, Short.MAX_VALUE)
				        .addComponent(btnLogar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
				        .addGap(11)))
				.addContainerGap());
			thisLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnLogar, btnSair});
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnSair, btnLogar});
			pack();
			this.setSize(400, 224);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/*private void btnSairActionPerformed(ActionEvent evt) {
		System.out.println("btnSair.actionPerformed, event="+evt);
		//TODO add your code for btnSair.actionPerformed
	}*/

}
