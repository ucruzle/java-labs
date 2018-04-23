package br.northwind.otimize.jdbc.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.northwind.otimize.jdbc.bo.PessoaBO;
import br.northwind.otimize.jdbc.dto.PessoaDTO;
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
public class MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelCadastro;
	private JScrollPane scrollListConsulta;
	private JTable tableListConsulta;
	private JPanel panelTabelaList;
	private JButton btnConsulta;
	private ButtonGroup grpConsultaSexo;
	private JRadioButton rbtConsultaFeminino;
	private JLabel lblConsultaSexo;
	private JRadioButton rbtConsultaMasculino;
	private JTextField txtConsutaCPF;
	private JLabel lblEndereco;
	private JLabel lblConsultaCPF;
	private JLabel lblConsultaNome;
	private JTextField txtConsultaNome;
	private JPanel panelConsulta;
	private JScrollPane scrollListagem;
	private JTable tableListagem;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JLabel lblDtNascimento;
	private JTextField txtDtNascimento;
	private ButtonGroup grpSexo;
	private JLabel lblSexo;
	private JRadioButton rbtFeminino;
	private JRadioButton rbtMasculino;
	private JTextField txtEndereco;
	private JLabel lblCPF;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JLabel lblNome;
	private JPanel panelListagem;
	private JTabbedPane mainTablePane;
	
	// Formatter de Datas
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Principal");
			{
				mainTablePane = new JTabbedPane();
				{
					panelCadastro = new JPanel();
					GroupLayout panelCadastroLayout = new GroupLayout((JComponent)panelCadastro);
					panelCadastro.setLayout(panelCadastroLayout);
					mainTablePane.addTab("Cadastro", null, panelCadastro, null);
					panelCadastro.setEnabled(false);
					panelCadastro.setPreferredSize(new java.awt.Dimension(510, 262));
					{
						lblNome = new JLabel();
						lblNome.setText("Nome:");
					}
					{
						txtNome = new JTextField();
					}
					{
						txtEndereco = new JTextField();
					}
					{
						lblEndereco = new JLabel();
						lblEndereco.setText("Endereço:");
						lblEndereco.setName("lblEndereco");
					}
					{
						lblSexo = new JLabel();
						lblSexo.setText("Sexo:");
						lblSexo.setName("lblSexo");
					}
					{
						rbtMasculino = new JRadioButton();
						rbtMasculino.setText("Masculino");
						rbtMasculino.setSelected(true);
						getGrpSexo().add(rbtMasculino);
					}
					{
						rbtFeminino = new JRadioButton();
						rbtFeminino.setText("Feminino");
						getGrpSexo().add(rbtFeminino);
					}
					{
						txtCPF = new JTextField();
					}
					{
						lblCPF = new JLabel();
						lblCPF.setText("CPF:");
						lblCPF.setName("lblCPF");
					}
					panelCadastroLayout.setHorizontalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						        .addGap(18))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						        .addGap(18))
						    .addComponent(getJLabel1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblEndereco, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblSexo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addGroup(panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						    .addGroup(panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						    .addGroup(panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						    .addGroup(panelCadastroLayout.createSequentialGroup()
						        .addComponent(getJTextField1(), GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addGroup(panelCadastroLayout.createParallelGroup()
						            .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						                .addGap(79)
						                .addComponent(getbtnCadastrar(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						            .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						                .addComponent(rbtMasculino, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						                .addComponent(rbtFeminino, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						                .addGap(11)))
						        .addGap(17)
						        .addComponent(getBtnLimpar(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(89, Short.MAX_VALUE));
					panelCadastroLayout.setVerticalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(txtNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(21)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(txtCPF, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblCPF, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(20)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(txtEndereco, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblEndereco, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(22)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(rbtMasculino, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(rbtFeminino, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblSexo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(16)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getJTextField1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getbtnCadastrar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getBtnLimpar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap());
				}
				{
					panelListagem = new JPanel();
					GroupLayout panelListagemLayout = new GroupLayout((JComponent)panelListagem);
					panelListagem.setLayout(panelListagemLayout);
					mainTablePane.addTab("Listagem", null, panelListagem, null);
					mainTablePane.addTab("Consulta", null, getPanelConsulta(), null);
					panelListagemLayout.setHorizontalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollListagem(), GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
					panelListagemLayout.setVerticalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollListagem(), 0, 244, Short.MAX_VALUE)
						.addContainerGap());
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTablePane, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(21, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTablePane, 0, 445, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			this.setSize(485, 368);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getGrpSexo() {
		if(grpSexo == null) {
			grpSexo = new ButtonGroup();
		}
		return grpSexo;
	}
	
	private JTextField getJTextField1() {
		if(txtDtNascimento == null) {
			txtDtNascimento = new JTextField();
		}
		return txtDtNascimento;
	}
	
	private JLabel getJLabel1() {
		if(lblDtNascimento == null) {
			lblDtNascimento = new JLabel();
			lblDtNascimento.setText("Dt. Nasc:");
			lblDtNascimento.setName("lblDtNascimento");
		}
		return lblDtNascimento;
	}
	
	private JButton getBtnLimpar() {
		if(btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setText("Limpar");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					txtNome.setText("");
					txtCPF.setText("");
					txtEndereco.setText("");
					txtDtNascimento.setText("");
					rbtMasculino.setSelected(true);
				}
			});
		}
		return btnLimpar;
	}
	
	private JButton getbtnCadastrar() {
		if(btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					
					PessoaBO bo = new PessoaBO();
					PessoaDTO dto = new PessoaDTO();
					
					try {
						
						String nome = txtNome.getText();
						String cpf = txtCPF.getText();
						String endereco = txtEndereco.getText();
						String dtNasc = txtDtNascimento.getText();
						char sexo = rbtMasculino.isSelected() ? 'M' : 'F';

						// Validações de Valores
						bo.validaNome(nome);
						bo.validaCpf(cpf);
						bo.validaEndereco(endereco);
						bo.validaDataDeNascimento(dtNasc);

						// Atribuição de Valores
						dto.setNome(nome);
						dto.setEndereco(endereco);
						dto.setCpf(Long.parseLong(cpf));
						dto.setSexo(sexo);
						dto.setDtNascimento(dateFormat.parse(dtNasc));

						// Execução da Rotina de Cadastro
						bo.cadastrar(dto);
						MensagensUtil.addMsg(MainFrame.this, "Cadastro efetuado com sucesso!");
						MainFrame.this.dispose();
						main(null);
					} catch (Exception e) {
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this, e.getMessage());
					}
				}
			});
		}
		return btnCadastrar;
	}
	
	private JTable getTableListagem() {
		
		PessoaBO bo = new PessoaBO();

		try {
			
			String[][] lista = bo.listagem();
			
			if(tableListagem == null) {
			
				TableModel tableListagemModel = 
						new DefaultTableModel(
								lista,
								new String[] { "ID", "Nome", "CPF", "Endereço", "Sexo", "Nascimento" });
				
				tableListagem = new JTable();
				tableListagem.setModel(tableListagemModel);
				tableListagem.setPreferredSize(new java.awt.Dimension(413, 241));

			}
			
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tableListagem;
	}
	
	private JScrollPane getScrollListagem() {
		if(scrollListagem == null) {
			scrollListagem = new JScrollPane();
			scrollListagem.setViewportView(getTableListagem());
		}
		return scrollListagem;
	}
	
	private JPanel getPanelConsulta() {
		if(panelConsulta == null) {
			panelConsulta = new JPanel();
			GroupLayout panelConsultaLayout = new GroupLayout((JComponent)panelConsulta);
			panelConsulta.setLayout(panelConsultaLayout);
			panelConsultaLayout.setHorizontalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup()
				    .addGroup(panelConsultaLayout.createSequentialGroup()
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addComponent(getJLabel1x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1xx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJTextField1x(), GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
				                .addGap(7)
				                .addComponent(getJLabel2(), GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJRadioButton2(), GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(getJRadioButton1(), GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				                .addGap(20)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJTextField2(), GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addGap(0, 56, Short.MAX_VALUE)
				                .addComponent(getBtnConsulta(), GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
				    .addComponent(getPanelTabelaList(), GroupLayout.Alignment.LEADING, 0, 417, Short.MAX_VALUE))
				.addContainerGap());
			panelConsultaLayout.setVerticalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getBtnConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getPanelTabelaList(), 0, 181, Short.MAX_VALUE)
				.addContainerGap());
		}
		return panelConsulta;
	}
	
	private JTextField getJTextField1x() {
		if(txtConsultaNome == null) {
			txtConsultaNome = new JTextField();
		}
		return txtConsultaNome;
	}
	
	private JLabel getJLabel1x() {
		if(lblConsultaNome == null) {
			lblConsultaNome = new JLabel();
			lblConsultaNome.setText("Nome:");
		}
		return lblConsultaNome;
	}
	
	private JLabel getJLabel2() {
		if(lblConsultaCPF == null) {
			lblConsultaCPF = new JLabel();
			lblConsultaCPF.setText("CPF:");
		}
		return lblConsultaCPF;
	}
	
	private JTextField getJTextField2() {
		if(txtConsutaCPF == null) {
			txtConsutaCPF = new JTextField();
		}
		return txtConsutaCPF;
	}
	
	private JRadioButton getJRadioButton1() {
		if(rbtConsultaFeminino == null) {
			rbtConsultaFeminino = new JRadioButton();
			rbtConsultaFeminino.setText("Feminino");
			getGrpConsultaSexo().add(rbtConsultaFeminino);
		}
		return rbtConsultaFeminino;
	}
	
	private JRadioButton getJRadioButton2() {
		if(rbtConsultaMasculino == null) {
			rbtConsultaMasculino = new JRadioButton();
			rbtConsultaMasculino.setText("Masculino");
			rbtConsultaMasculino.setSelected(true);
			getGrpConsultaSexo().add(rbtConsultaMasculino);
		}
		return rbtConsultaMasculino;
	}
	
	private JLabel getJLabel1xx() {
		if(lblConsultaSexo == null) {
			lblConsultaSexo = new JLabel();
			lblConsultaSexo.setText("Sexo:");
			lblConsultaSexo.setName("lblConsultaSexo");
		}
		return lblConsultaSexo;
	}
	
	private ButtonGroup getGrpConsultaSexo() {
		if(grpConsultaSexo == null) {
			grpConsultaSexo = new ButtonGroup();
		}
		return grpConsultaSexo;
	}
	
	private JButton getBtnConsulta() {
		if(btnConsulta == null) {
			btnConsulta = new JButton();
			btnConsulta.setText("Consultar");
			btnConsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					
					getTableListConsulta();
				}
			});
		}
		return btnConsulta;
	}
	
	private JPanel getPanelTabelaList() {
		if(panelTabelaList == null) {
			panelTabelaList = new JPanel();
			GroupLayout panelTabelaListLayout = new GroupLayout((JComponent)panelTabelaList);
			panelTabelaList.setLayout(panelTabelaListLayout);
			panelTabelaList.setBorder(BorderFactory.createTitledBorder("Listagem"));
			panelTabelaListLayout.setVerticalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap(12, 12)
				.addComponent(getJScrollListConulta(), GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, 12));
			panelTabelaListLayout.setHorizontalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap(12, 12)
				.addComponent(getJScrollListConulta(), GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, 12));
		}
		return panelTabelaList;
	}
	
	private JTable getTableListConsulta() {
		
		String nome = txtConsultaNome.getText();
		String cpf  = txtConsutaCPF.getText();
		char sexo   = rbtConsultaMasculino.isSelected() ? 'M' : 'F';

		if(tableListConsulta == null) {
			tableListConsulta = new JTable();
		} else {

			try {

				PessoaBO bo = new PessoaBO();

				bo.validaNome(nome);
				bo.validaCpf(cpf);

				String[][] lista = bo.listaConsulta(nome, Long.parseLong(cpf), sexo);
				TableModel tableListConsultaModel = 
						new DefaultTableModel(
								lista,
								new String[] { "ID", "Nome", "CPF", "Endereço", "Sexo", "Nascimento" });

				tableListConsulta.setModel(tableListConsultaModel);
			} catch (Exception e) {
				e.printStackTrace();
				MensagensUtil.addMsg(MainFrame.this, e.getMessage());
			}
		}
		return tableListConsulta;
	}
	
	private JScrollPane getJScrollListConulta() {
		if(scrollListConsulta == null) {
			scrollListConsulta = new JScrollPane();
			scrollListConsulta.setViewportView(getTableListConsulta());
		}
		return scrollListConsulta;
	}

}
