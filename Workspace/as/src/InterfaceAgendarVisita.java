import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

public class InterfaceAgendarVisita extends JFrame implements ActionListener {
	private JPanel painelNorte;
	private JLabel rotuloData;
	private JLabel LabelPonto;
	private JTextField TextFieldEndereco;
	private JButton ButtonCancelar;
	private JButton ButtonConfirmar;
	private JTextField TextFieldNome;
	private JFormattedTextField FormattedTextData,FormattedTextHora,FormattedTextMinuto;
	private JLabel rotuloHorario;
	private JLabel rotuloNome;
	private JPanel painelCentro;
	private JLabel imagem;
	private JPanel painelSul;
	private JLabel rotuloEndereco;
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraHora,mascaraMinuto;

	private int idCliente = 0;

	public InterfaceAgendarVisita(Cliente cli) {
		super("");
		idCliente = cli.getIdCliente();
		
		initGUI(cli);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void initGUI(Cliente cli) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			{
				painelSul = new JPanel();
				getContentPane().add(painelSul, BorderLayout.SOUTH);
				painelSul.setPreferredSize(new java.awt.Dimension(391, 36));
				{
					ButtonConfirmar = new JButton();
					painelSul.setBackground( Color.blue);
					painelSul.add(ButtonConfirmar);
					ButtonConfirmar.setText("Confirmar");
					ButtonConfirmar.setPreferredSize(new java.awt.Dimension(91,
							21));
				}
				{
					ButtonCancelar = new JButton();
					painelSul.add(ButtonCancelar);
					ButtonCancelar.setText("Cancelar");
					ButtonCancelar.setPreferredSize(new java.awt.Dimension(88,
							20));
				}
			}
			{
				painelNorte = new JPanel();
				
				getContentPane().add(painelNorte, BorderLayout.NORTH);

				painelNorte.setPreferredSize(new java.awt.Dimension(484, 39));
				{
					imagem = new JLabel();
					painelNorte.add(imagem);
					imagem.setText("imagem");
					imagem.setBounds(68, 19, 36, 14);
				}
			}
			{
				painelCentro = new JPanel();
				getContentPane().add(painelCentro, BorderLayout.CENTER);

				painelCentro.setPreferredSize(new java.awt.Dimension(395, 318));
				painelCentro.setLayout(null);
				{
					rotuloNome = new JLabel();
					painelCentro.add(rotuloNome);
					rotuloNome.setText("Nome");
					rotuloNome.setBounds(29, 12, 43, 14);
				
					TextFieldNome = new JTextField();
					painelCentro.add(TextFieldNome);
					TextFieldNome.setBounds(79, 9, 307, 21);
					TextFieldNome.setText(cli.getNome());

				}
				{
					rotuloEndereco = new JLabel();
					painelCentro.add(rotuloEndereco);
					rotuloEndereco.setText("Endereço");
					rotuloEndereco.setBounds(29, 60, 63, 14);
					TextFieldEndereco = new JTextField();
					painelCentro.add(TextFieldEndereco);
					TextFieldEndereco.setBounds(91, 57, 295, 21);
				}
				{
					rotuloData = new JLabel();
					painelCentro.add(rotuloData);
					rotuloData.setText("Data");
					rotuloData.setBounds(29, 111, 51, 14);
					mascaraData = new MaskFormatter(" ####-##-##");
					mascaraData.setPlaceholderCharacter('_');
					FormattedTextData = new JFormattedTextField(mascaraData);
					painelCentro.add(FormattedTextData);
					FormattedTextData.setBounds(84, 108, 78, 21);
				}
				{
					rotuloHorario = new JLabel();
					painelCentro.add(rotuloHorario);
					rotuloHorario.setText("Horario");
					rotuloHorario.setBounds(292, 111, 47, 14);
				}
				{
					mascaraHora = new MaskFormatter("##");
					mascaraHora.setPlaceholderCharacter('_');
					FormattedTextHora = new JFormattedTextField(mascaraHora);
					painelCentro.add(FormattedTextHora);
					FormattedTextHora.setBounds(344, 108, 18, 21);
				}
				{
					mascaraMinuto = new MaskFormatter("##");
					mascaraMinuto.setPlaceholderCharacter('_');
					FormattedTextMinuto = new JFormattedTextField(mascaraMinuto);
					painelCentro.add(FormattedTextMinuto);
					FormattedTextMinuto.setBounds(368, 108, 18, 21);
				}
				{
					LabelPonto = new JLabel();
					painelCentro.add(LabelPonto);
					LabelPonto.setText(":");
					LabelPonto.setBounds(363, 110, 6, 14);
				}
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ButtonConfirmar.addActionListener(this);
		ButtonCancelar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== ButtonConfirmar){
			System.out.println(FormattedTextData.getText());
			System.out.println(FormattedTextHora.getText());
			System.out.println(FormattedTextMinuto.getText());
			OperacoesDoSistema o = new OperacoesDoSistema();
		String	TextHorario= (FormattedTextHora.getText()+":"+FormattedTextMinuto.getText());
		System.out.println(TextHorario);
		System.out.println("id Cliente eh4  "+idCliente );
			AgendamentoVisita agenda = new AgendamentoVisita(TextFieldNome.getText(),
					TextFieldEndereco.getText(),FormattedTextData.getText(),TextHorario,this.idCliente);
			
			o.agendaVisita(agenda);
			
		}
		
	}
	
	boolean testandoAgendVisita(int i) {
		boolean erro = false;
		String mErros = "";
		 if (TextFieldEndereco.getText().equals("")) {
			mErros = " Não forneceu o Endereço !";
			TextFieldEndereco.grabFocus();
			erro = true;
		} else if (FormattedTextData.getText().equals(" ____-__-__")) {
			mErros = " Não forneceu a Data da Visita do Cliente";
			FormattedTextData.grabFocus();
			erro = true;
			} else if (FormattedTextHora.getText().equals("__")& (FormattedTextMinuto.getText().equals("__"))) {
			mErros = " Não forneceu o Horário da Visita! ";
			FormattedTextHora.grabFocus();
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErros, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}

}
