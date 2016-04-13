import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class InterfaceCadastro extends JFrame implements ActionListener {
	// retorna qual conteiner do frame
	
	private Container tela1 = getContentPane();
	
	OperacoesDoSistema o = new OperacoesDoSistema();
	private JPanel painelCidade = new JPanel(), panelCenter = new JPanel(),
			panelBotton = new JPanel(), painelCimaInterno = new JPanel(),
			painelDosRadios = new JPanel(), painelCentroNome = new JPanel(),
			painelCentroCepData = new JPanel(),
			painelCentroCidEnder = new JPanel(), painelTelefone = new JPanel(),
			painelTelefoneOk = new JPanel(), painelRadioCpf = new JPanel(),
			painelCpf = new JPanel(), painelMascaraTel = new JPanel(),
			painelAtualizaTel = new JPanel();

	private JButton bComfimar, bOk1, bOk2, bOk3, bAtualizar, btOkAtualTel,
			btAlteraTelefone1, btAlteraTelefone2, btAlteraTelefone3;
	private JLabel rotulocep, rotuloender, rotulocpf, rotulodata_nascimento,
			rotulotel, rotulotelcel, rotulosexo, rotulocidade, rotulonome,
			rotuloTelefone1, rotuloTelefone2, rotuloTelefone3;
	private JTextField textnome;
	private JFormattedTextField cep, tel, cpf, data_nascimento, telcel,
			telcomerc;
	private MaskFormatter mascaracep, mascaratel, mascaratelcel, mascaracpf,
			mascaradata_nascimento, mascaratelcomer;
	private JRadioButton radioMascul, radioFemin;
	private ButtonGroup grup;

	private JTextArea textoEnd;
	private JComboBox listaCid;

	private JComboBox comboTel1 = new JComboBox(), comboTel2 = new JComboBox(),
			comboTel3 = new JComboBox();

	private ArrayList<Telefone> listaTelefone = new ArrayList<Telefone>();
	private ArrayList<Telefone> telefone;
	private JScrollPane painelRolagem;

	// FALTA A CIDADE

	Cliente cliente;

	public InterfaceCadastro(Cliente c) {
		super("CADASTRO DE CLIENTE");
		this.cliente = c;
		if (cliente == null) {
			cadatrarCliente(cliente);
		} else {
			setTitle("ATUALIZAR CLIENTE");
			cadatrarCliente(cliente);
		}
	}

	public void cadatrarCliente(Cliente c) {
		OperacoesDoSistema o = new OperacoesDoSistema();
		try {
			mascaracpf = new MaskFormatter(" ######### - ##");
			mascaradata_nascimento = new MaskFormatter(" ####-##-##");
			mascaracep = new MaskFormatter(" ##### - ###");
			mascaratel = new MaskFormatter("(##)####-####");
			mascaratelcel = new MaskFormatter("(##)####-####");
			mascaratelcomer = new MaskFormatter("(##)####-####");

			mascaracep.setPlaceholderCharacter('_');
			mascaratel.setPlaceholderCharacter('_');
			mascaracpf.setPlaceholderCharacter('_');
			mascaradata_nascimento.setPlaceholderCharacter('_');
			mascaratelcel.setPlaceholderCharacter('_');
			mascaratelcomer.setPlaceholderCharacter('_');

		} catch (ParseException excp) {

		}

		FlowLayout flo = new FlowLayout();
		//panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		painelDosRadios.setLayout(new BoxLayout(painelDosRadios,
				BoxLayout.Y_AXIS));
		painelTelefone
				.setLayout(new BoxLayout(painelTelefone, BoxLayout.Y_AXIS));
		painelCpf.setLayout(new BoxLayout(painelCpf, BoxLayout.Y_AXIS));
		painelCidade.setLayout(new BoxLayout(painelCidade, BoxLayout.Y_AXIS));
		painelMascaraTel.setLayout(new BoxLayout(painelMascaraTel,
				BoxLayout.Y_AXIS));
		
		tela1.add(panelBotton, BorderLayout.SOUTH);
		tela1.add(panelCenter, BorderLayout.CENTER);

		panelCenter.add(painelCentroNome);
		panelCenter.add(painelRadioCpf);
		panelCenter.add(painelCentroCepData);
		panelCenter.add(painelCentroCidEnder);
		panelCenter.add(painelTelefoneOk);

		rotulonome = new JLabel("NOME :");
		textnome = new JTextField(32);
		painelCentroNome.setLayout(flo);
		painelCentroNome.add(rotulonome);
		painelCentroNome.add(textnome);

		rotulosexo = new JLabel("SEXO :");
		radioFemin = new JRadioButton("Feminino");
		radioMascul = new JRadioButton("Masculino");
		grup = new ButtonGroup();
		grup.add(radioFemin);
		grup.add(radioMascul);
		painelRadioCpf.setLayout(flo);
		painelRadioCpf.add(rotulosexo);
		painelRadioCpf.add(painelDosRadios);
		painelDosRadios.add(radioFemin);
		painelDosRadios.add(radioMascul);
		painelDosRadios.setBorder(BorderFactory.createEtchedBorder());

		rotulocpf = new JLabel("CPF :");
		cpf = new JFormattedTextField(mascaracpf);
		painelRadioCpf.add(rotulocpf);
		painelRadioCpf.add(painelCpf);
		painelCpf.add(cpf);

		rotulodata_nascimento = new JLabel("Data de nascimento :");
		data_nascimento = new JFormattedTextField(mascaradata_nascimento);
		painelCentroCepData.setLayout(flo);
		painelCentroCepData.add(rotulodata_nascimento);
		painelCentroCepData.add(data_nascimento);

		rotulocep = new JLabel("CEP :");
		cep = new JFormattedTextField(mascaracep);
		painelCentroCepData.add(rotulocep);
		painelCentroCepData.add(cep);

		// adicionando lista JcomboBox
		ArrayList<Cidade> listCidades;
		listCidades = o.listCidades();
		listaCid = new JComboBox();
		for (int i = 0; i < listCidades.size(); i++) {
			listaCid.addItem(listCidades.get(i));
		}
		rotulocidade = new JLabel("CIDADE:");

		// listaCid.setEditable(true);
		listaCid.setMaximumRowCount(3);
		painelCentroCidEnder.setLayout(flo);
		painelCentroCidEnder.add(rotulocidade);
		painelCentroCidEnder.add(painelCidade);
		painelCidade.add(new JScrollPane(listaCid));
		//

		rotuloender = new JLabel("ENDEREÇO :");
		painelCentroCidEnder.add(rotuloender);
		textoEnd = new JTextArea(3, 13);
		painelCentroCidEnder.add(textoEnd);
		painelRolagem = new JScrollPane(textoEnd);
		painelRolagem
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		painelRolagem
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		painelCentroCidEnder.add(painelRolagem);

		bOk1 = new JButton("OK");
		bOk2 = new JButton("OK");
		bOk3 = new JButton("OK");
		btOkAtualTel = new JButton("OK");
		bComfimar = new JButton("CONFIRMAR");
		bAtualizar = new JButton("ATUALIZAR");
		btAlteraTelefone1 = new JButton("Alterar");
		btAlteraTelefone2 = new JButton("Alterar");
		btAlteraTelefone3 = new JButton("Alterar");
		// idCliente = id;
		if (c == null) {
			cadastro2();
		} else
			atualizaCliente(c);

		bOk1.addActionListener(this);
		bOk2.addActionListener(this);
		bOk3.addActionListener(this);
		bComfimar.addActionListener(this);
		bAtualizar.addActionListener(this);
		btOkAtualTel.addActionListener(this);
		btAlteraTelefone1.addActionListener(this);
		btAlteraTelefone2.addActionListener(this);
		btAlteraTelefone3.addActionListener(this);
		getRootPane().setDefaultButton(bComfimar);

		panelBotton.setBackground(Color.blue);
		setSize(420, 400);
		setVisible(true);
		setResizable(false);// nao deixa ser maximizada
		setLocationRelativeTo(null);
		
	}

	public void cadastro2() {
		FlowLayout flo = new FlowLayout();
		listaCid.setSelectedItem(1);
		listaCid.setSelectedItem(null);
		// Adicionando JCheckBox
		rotuloTelefone1 = new JLabel("Telefone Fixo");
		rotuloTelefone2 = new JLabel("Telefone Comercial");
		rotuloTelefone3 = new JLabel("Telefone Celular");

		painelTelefoneOk.setLayout(flo);
		painelTelefoneOk.add(painelTelefone);
		painelTelefone.setLayout(new GridLayout(3, 1, 8, 8));
		painelTelefone.add(rotuloTelefone1);
		painelTelefone.add(rotuloTelefone2);
		painelTelefone.add(rotuloTelefone3);

		tel = new JFormattedTextField(mascaratel);
		telcel = new JFormattedTextField(mascaratelcel);
		telcomerc = new JFormattedTextField(mascaratelcomer);
		painelTelefoneOk.add(painelMascaraTel);
		painelMascaraTel.setLayout(new GridLayout(3, 1, 7, 7));
		painelMascaraTel.add(tel);
		painelMascaraTel.add(telcel);
		painelMascaraTel.add(telcomerc);
		painelTelefone = new JPanel();
		painelTelefone.setLayout(new GridLayout(3, 1, 4, 4));
		painelTelefone.add(bOk1);
		painelTelefone.add(bOk2);
		painelTelefone.add(bOk3);
		painelTelefoneOk.add(painelTelefone);
		panelBotton.add(bComfimar);
	}

	// Seta a interface do cadastro do cliente
	public void atualizaCliente(Cliente c) {
		setTitle("ATUALIZAR CLIENTE");
		textnome.setText(c.getNome());
		if (c.getSexo() == 'M') {
			radioMascul.setSelected(true);
		} else if (c.getSexo() == 'F') {
			radioFemin.setSelected(true);
		}
		cpf.setText(c.getCPF());
		textoEnd.setText(c.getEndereco());
		// Cliente c = o.selectClienteid(id);

		for (int i = 0; i < listaCid.getItemCount(); i++)
			if (c.getCidade().getIdCidade() == ((Cidade) listaCid.getItemAt(i))
					.getIdCidade())
				listaCid.setSelectedIndex(i);

		rotuloTelefone1 = new JLabel("Telefone Fixo");
		rotuloTelefone2 = new JLabel("Telefone Comercial");
		rotuloTelefone3 = new JLabel("Telefone Celular");

		telefone = o.selecionaTelefone1(c.getIdCliente());

		for (int i = 0; i < telefone.size(); i++) {
			if (telefone.get(i).getTipo().equals("FIXO")) {
				comboTel1.addItem(telefone.get(i).getNumero());

			} else if (telefone.get(i).getTipo().equals("CELULAR")) {
				comboTel2.addItem(telefone.get(i).getNumero());

			} else if (telefone.get(i).getTipo().equals("COMERCIAL")) {
				comboTel3.addItem(telefone.get(i).getNumero());

			}
		}
		FlowLayout flo = new FlowLayout();
		painelTelefoneOk.setLayout(flo);
		painelTelefoneOk.add(painelTelefone);
		painelTelefone.setLayout(new GridLayout(3, 1, 8, 8));
		painelTelefone.add(rotuloTelefone1);
		painelTelefone.add(rotuloTelefone2);
		painelTelefone.add(rotuloTelefone3);
		painelTelefoneOk.add(painelMascaraTel);

		if (telefone.size() == 0) {
			
			tel = new JFormattedTextField(mascaratel);
			telcel = new JFormattedTextField(mascaratelcel);
			telcomerc = new JFormattedTextField(mascaratelcomer);
			painelTelefoneOk.add(painelMascaraTel);
			painelMascaraTel.setLayout(new GridLayout(3, 1, 7, 7));
			painelMascaraTel.add(tel);
			painelMascaraTel.add(telcel);
			painelMascaraTel.add(telcomerc);
			painelTelefone = new JPanel();
			painelTelefone.setLayout(new GridLayout(3, 1, 4, 4));
			painelTelefone.add(bOk1);
			painelTelefone.add(bOk2);
			painelTelefone.add(bOk3);
			painelTelefoneOk.add(painelTelefone);
		} else {

			// colocar pamasc como grid
			painelMascaraTel.setLayout(new GridLayout(3, 1, 8, 8));
			painelMascaraTel.add(comboTel1);
			painelMascaraTel.add(comboTel2);
			painelMascaraTel.add(comboTel3);
			painelAtualizaTel.setLayout(new GridLayout(3, 1, 4, 4));
			painelAtualizaTel.add(btAlteraTelefone1);
			painelAtualizaTel.add(btAlteraTelefone2);
			painelAtualizaTel.add(btAlteraTelefone3);
			painelTelefoneOk.add(painelAtualizaTel);
			panelBotton.add(bAtualizar);

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bComfimar) {
			if (testando()) {
				OperacoesDoSistema o = new OperacoesDoSistema();
				

				
				Cliente ce = new Cliente(textnome.getText(), radioMascul
						.isSelected() ? 'M' : 'F', cpf.getText(),
						data_nascimento.getText(), cep.getText(), textoEnd
								.getText());
				ce.setCidade((Cidade) listaCid.getSelectedItem());

				
				ce.setTelefone(listaTelefone);
				o.casdrataCliente(ce);
				o.casdrataTelefone(listaTelefone);
				
				
				
				limpar();
				
			}
		} else if (e.getSource() == bAtualizar) {

			OperacoesDoSistema o = new OperacoesDoSistema();
			System.out.println(radioMascul.isSelected() ? 'M' : 'F');
			Cliente ce = new Cliente(cliente.getIdCliente(),
					textnome.getText(), radioMascul.isSelected() ? 'M' : 'F',
					cpf.getText(), data_nascimento.getText(), cep.getText(),
					textoEnd.getText());
			Cidade cid = (Cidade) listaCid.getSelectedItem();
			ce.setCidade(cid);
			System.out.println("sexo " + ce.getSexo());
			o.atualizaCliente(ce);
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso",
					"Mensagem", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (e.getSource() == bOk1) {
			int i = 1;
			boolean a = testandoTelefone(i);
			if (a == false) {
				Telefone te = null;
				OperacoesDoSistema o = new OperacoesDoSistema();
				int x = o.pegaUltimoIdClienteMais1();
				System.out.println(" Utimo id do cliente eh mais 1 " + x);

				te = new Telefone("FIXO", tel.getText(), x);
				listaTelefone.add(te);
				tel.setText(null);

			}
		} else if (e.getSource() == bOk2) {
			int i = 2;
			boolean a = testandoTelefone(i);
			if (a == false) {

				Telefone te = null;
				OperacoesDoSistema o = new OperacoesDoSistema();
				int x = o.pegaUltimoIdClienteMais1();

				te = new Telefone("CELULAR", telcel.getText(), x);
				listaTelefone.add(te);
				telcel.setText(null);

			}
		} else if (e.getSource() == bOk3) {
			int i = 3;
			boolean a = testandoTelefone(i);
			if (a == false) {

				Telefone te = null;
				OperacoesDoSistema o = new OperacoesDoSistema();
				int x = o.pegaUltimoIdClienteMais1();

				te = new Telefone("COMERCIAL", telcomerc.getText(), x);
				listaTelefone.add(te);
				telcomerc.setText(null);

			}
		} else if (e.getSource() == btAlteraTelefone1) {
			int i = 1;
		

			OperacoesDoSistema o = new OperacoesDoSistema();
			String p = null;
			if (comboTel1.getSelectedIndex() > -1
					& !(comboTel1.getSelectedItem().toString()
							.equals("                      "))) {
				p = comboTel1.getSelectedItem().toString();
				System.out.println("pegado num " + p);
				int x = pegaIdTelefone(p);
				Telefone te = o.selecionaTelefone2(x);
				System.out.println("pegado eh " + x);
				InterfaceTelefone tel = new InterfaceTelefone(te);
			}

			// }
		} else if (e.getSource() == btAlteraTelefone2) {
			int i = 3;
			
			OperacoesDoSistema o = new OperacoesDoSistema();
			String p = null;
			if (comboTel2.getSelectedIndex() > -1
					& !(comboTel1.getSelectedItem().toString()
							.equals("                      "))) {
				p = comboTel2.getSelectedItem().toString();

				System.out.println("pegado num2 " + p);
				int x = pegaIdTelefone(p);
				Telefone te = o.selecionaTelefone2(x);
				
				InterfaceTelefone tel = new InterfaceTelefone(te);
			}
			// }
		} else if (e.getSource() == btAlteraTelefone3) {
			int i = 3;
		

			OperacoesDoSistema o = new OperacoesDoSistema();
			String p = null;
			if (comboTel3.getSelectedIndex() > -1
					& !(comboTel1.getSelectedItem().toString()
							.equals("                      "))) {
				p = comboTel3.getSelectedItem().toString();

				System.out.println("pegado num3 " + p);
				int x = pegaIdTelefone(p);
				Telefone te = o.selecionaTelefone2(x);
				// System.out.println("pegado eh3 " + x);
				InterfaceTelefone tel = new InterfaceTelefone(te);
			}
		}
	}

	public int pegaIdTelefone(String a) {
		int idTelefone = 0;
		String x = a;
		System.out.println("Numero eh " + x);
		for (int i = 0; i < telefone.size(); i++) {
			if (telefone.get(i).getNumero().equals(x)) {
				idTelefone = telefone.get(i).getIdtelefone();
				System.out.println("Id eh " + idTelefone);
			}
		}
		return idTelefone;
	}

	// LIMPA OS CAMPOS
	public void limpar() {

		telcel.setText(null);
		cep.setText(null);
		cpf.setText(null);
		data_nascimento.setText(null);
		textnome.setText(null);
		tel.setText(null);
		textoEnd.setText("");
		telcomerc.setText(null);
		radioFemin.setSelected(false);
		radioMascul.setSelected(false);
		// lista.setSelectedItem(1);
		listaCid.setSelectedItem(null);

	}

	// TESTA CLIENTE
	boolean testando() {
		String mErros = "";
		boolean erro = false;
		if (textnome.getText().equals("")) {
			mErros = "Este campo não pode ficar em branco!";
			textnome.grabFocus();
			erro = true;
		} else if (!radioFemin.isSelected() && !radioMascul.isSelected()) {
			mErros = "Não selecionou o SEXO!";
			radioMascul.grabFocus();
			erro = true;
		} else if (cpf.getText().equals(" _________ - __")) {
			mErros = " Não foi fornecido o CPF !";
			cpf.grabFocus();
			erro = true;
		} else if (data_nascimento.getText().equals(" ____-__-__")) {
			mErros = " Não foi fornecido a Data de Nascimento !";
			data_nascimento.grabFocus();
			erro = true;
		} else if (cep.getText().equals(" _____ - ___")) {
			mErros = " Não foi fornecido o CEP da Cidade!";
			cep.grabFocus();
			erro = true;
		} else if (listaCid.getSelectedItem() == null) {
			mErros = "Não foi fornecido a Cidade";
			listaCid.grabFocus();
			erro = true;
		} else if (textoEnd.getText().equals("")) {
			mErros = "Não foi fornecido o Endereço";
			textoEnd.grabFocus();
			erro = true;
		} else if (textnome.getText().equals("")
				&& (!radioFemin.isSelected() && !radioMascul.isSelected())
				&& (cpf.getText() != "")) {
			mErros = " Não forneceu os dados do cliente ! ";
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErros, " Erro ",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	// TESTA O TELEFONE
	boolean testandoTelefone(int i) {
		boolean erro = false;
		String mErros = "";
		
		if (tel.getText().equals("(__)____-____") && (i == 1)) {
			mErros = " Não forneceu os dados do TELEFONE FIXO ! ";
			erro = true;
		} else if (telcel.getText().equals("(__)____-____") && (i == 2)) {
			mErros = " Não forneceu os dados do TELEFONE CELULAR! ";
			erro = true;
		} else if (telcomerc.getText().equals("(__)____-____") && (i == 3)) {
			mErros = " Não forneceu os dados do TELEFONE COMERCIAL ! ";
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErros, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}

}
