import java.sql.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tabela extends JFrame implements ActionListener {
	private Connection connection;
	private JTable table;

	private JButton delete = new JButton("Deletar Cliente"),
			atualizar = new JButton("Atualizar Cliente"),
			abriOs = new JButton("Abrir Ordem de Servi�o"),
			deletaOs = new JButton("Deletar Ordem de Servi�o"),
			atualizaOs = new JButton("Atualizar Ordem de Servi�o"),
			atualizarOs2 = new JButton("Atualizar Ordem de Servi�o"),
			exibirOs2 = new JButton("Exibir Ordem de Servi�o"),
			btInsereServ = new JButton("Inserir Servi�o"), 
			btInsereNovoServ = new JButton("Inserir Novo Servi�o"), 
			exibirServico = new JButton("Exibir Servi�o"),
			btInserePreca = new JButton("Inserir Pe�a"),
			inserePecaNova = new JButton("Inserir Nova Pe�a"), 
		    agendarVisitaCliente = new JButton("Agendar"),
		    exirirPagamento = new JButton("Exibir Pagamento");

	private JPanel painelBaixo = new JPanel();
	private int opcao = 0;
	// private int idd;
	OperacoesDoSistema o = new OperacoesDoSistema();

	public Tabela(String sql, int d) {
		opcao = d;
		setSize(600, 200);
		setVisible(true);
		painelBaixo.setBackground( Color.blue);
		getContentPane().add(painelBaixo, BorderLayout.SOUTH);
		if (opcao == 0) {
			setTitle("TABELA CLIENTE");
			painelBaixo.add(atualizar);
			painelBaixo.add(delete);
		} else if (opcao == 1) {
			setTitle("TABELA CLIENTE");
			painelBaixo.add(abriOs);
		} else if (opcao == 2) {
			setTitle("TABELA ORDEM SERVI�O");
			painelBaixo.add(atualizaOs); // para atualizar a os
			painelBaixo.add(deletaOs);
		} else if (opcao == 3) {
			setTitle("TABELA 	ORDEM DE SERVI�O");
			 painelBaixo.add(deletaOs);
		} else if (opcao == 4) {
			setTitle("TABELA CLIENTE");
			painelBaixo.add(agendarVisitaCliente);
		} else if (opcao == 5) {
			setTitle("");
			painelBaixo.add(exibirOs2);
		} else if (opcao == 6) {
			setTitle("RELATORIO ");
		} else if (opcao == 7) {
			setTitle("RELATORIO DI�RIO DAS ORDENS DE SERVI�O");
		} else if (opcao == 8) {
			painelBaixo.add(btInsereServ);
			painelBaixo.add(btInsereNovoServ);
		} else if (opcao == 10) {
			painelBaixo.add(btInserePreca);
			painelBaixo.add(inserePecaNova);
		} else if (opcao == 11) {
			painelBaixo.add(exibirServico);

		} else if (opcao == 13) {
			painelBaixo.add(exirirPagamento);

		} else if (opcao == 16) {
			painelBaixo.add(atualizaOs);
			painelBaixo.add(deletaOs);
		} else if (opcao == 17) {
			painelBaixo.add(atualizarOs2);
			painelBaixo.add(deletaOs);
			
		} else if (opcao == 18) {
			painelBaixo.add(atualizarOs2);
		}
		

		
		setLocationRelativeTo(null);
		displayResultSet(o.getTable(sql));  //��������������������������������������������������������������������
		
		delete.addActionListener(this);
		atualizar.addActionListener(this);
		abriOs.addActionListener(this);
		deletaOs.addActionListener(this);
		atualizaOs.addActionListener(this);
		atualizarOs2.addActionListener(this);
		agendarVisitaCliente.addActionListener(this);
		btInsereServ.addActionListener(this);
		btInsereNovoServ.addActionListener(this);
		exibirOs2.addActionListener(this);
		btInserePreca.addActionListener(this);
		inserePecaNova.addActionListener(this);
		exibirServico.addActionListener(this);
		exirirPagamento.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == delete) { // okkkkkkkkkkkkkkkkkkkkkkkkkkk
		
			Object[] options = { "Confirmar", "Cancelar" };
			int m = JOptionPane.showOptionDialog(null,
					"Deseja realmente exluir o cliente selecionado?",
					"Informa��o", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (m == 0) {
				int p = table.getSelectedRow();
				if (p == -1)
					JOptionPane.showMessageDialog(null,
							"Selecione uma linha da tabela", "Erro",
							JOptionPane.ERROR_MESSAGE);
				else {
					System.out.println("mouseClicked "
							+ table.getValueAt(table.getSelectedRow(), 0));
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int id = Integer.parseInt(p1);

					o.excluiCliente(id);
					atualizartabela(o.getTable("SELECT * FROM cliente c"));
				}
			}
		} else if (e.getSource() == atualizar) {// okkkkkkkkkkkkkkkkkkkkkkkkkkk
			// chama a tela de cliente com os dados
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane.showOptionDialog(null,
						"Deseja realmente alterar o cliente selecionado?",
						"Informa��o", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (m == 0) {
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int id = Integer.parseInt(p1);
					Cliente c = (Cliente) o.selectClienteid(id);
					InterfaceCadastro inter = new InterfaceCadastro(c);
					atualizartabela(o.getTable("SELECT * FROM cliente c"));
				}
			}

		}
		if (e.getSource() == agendarVisitaCliente) {// okkkkkkkkkkkkkkkkkkkkkkkkkkk
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente agendar a consulta do cliente selecionado?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
				
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int id = Integer.parseInt(p1);
					Cliente c = (Cliente) o.selectClienteid(id);
					
					InterfaceAgendarVisita agenda = new InterfaceAgendarVisita(
							c);
				}
			}

		}
		if (e.getSource() == abriOs) {// okkkkkkkkkkkkkkkkkkkkkkkkkkk
			// chama a tela de cliente com os dados
		
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				String p1 = String.valueOf(table.getValueAt(p, 0));
				int id = Integer.parseInt(p1);
				Cliente c = (Cliente) o.selectClienteid(id);
				int idOs = 0;
				int op = 1;
				OrdemServico os = null;
				InterfaceOrdemServico inter = new InterfaceOrdemServico(c, os,
						op);
			}
		}
		if (e.getSource() == atualizaOs) {
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente atualizar a Ordem de Servi�o selecionada?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 2));
					int idos = Integer.parseInt(p1);
					OrdemServico os = (OrdemServico) o.selecionaOSid(idos);
					int idCli = os.getIdcliente();// ou poderia pegar direto da
					// tabela
					Cliente c = (Cliente) o.selectClienteid(idCli);
					int opcao = 2;
					InterfaceOrdemServico inter = new InterfaceOrdemServico(os,
							c, opcao);

				}
			}
		}
		else if (e.getSource() == atualizarOs2) {
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente atualizar a Ordem de Servi�o selecionada?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 2));
					int idos = Integer.parseInt(p1);
					OrdemServico os = (OrdemServico) o.selecionaOSid(idos);
					int idCli = os.getIdcliente();// ou poderia pegar direto da
					// tabela
					Cliente c = (Cliente) o.selectClienteid(idCli);
					int opcao = 2;
					os.setValor(o.pegarvalorOS(idos));
					InterfaceOrdemServico inter = new InterfaceOrdemServico(
							opcao, c, os); // chama 3� construtor

				}
			}
		} else if (e.getSource() == deletaOs) {

			
			Object[] options = { "Confirmar", "Cancelar" };
			int m = JOptionPane.showOptionDialog(null,
					"Deseja realmente exluir a Ordem de Servi�o selecionada?",
					"Informa��o", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (m == 0) {
				int p = table.getSelectedRow();
				if (p == -1)
					JOptionPane.showMessageDialog(null,
							"Selecione uma linha da tabela", "Erro",
							JOptionPane.ERROR_MESSAGE);
				else {
					System.out.println("mouseClicked "
							+ table.getValueAt(table.getSelectedRow(), 2));
					String p1 = String.valueOf(table.getValueAt(p, 2));
					int idos = Integer.parseInt(p1);
					o.excluiOS(idos);
					atualizartabela(o.getTable("SELECT * FROM ordemservico "));
				}
			}

		} else if (e.getSource() == btInsereServ) { 
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente inserir Servi�o(s)nessa Ordem de Servi�o?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int idOs = Integer.parseInt(p1);
					OrdemServico os = o.selecionaOSid(idOs);
					InterfaceServico2 in2 = new InterfaceServico2(os);
				}
			}
		} else if (e.getSource() == exibirOs2) { // 0kkkkkkkkkkkkkkkkkkkkk
		
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente exibir a Ordem de Servi�o desse cliente selecionado?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int idCli = Integer.parseInt(p1);
					String sql = "SELECT * FROM ordemservico where idCliente ="
							+ idCli + " and  status = 'Diagnosticada'";
					
					int op = 8;
					Tabela table = new Tabela(sql, op);

				}
			}
		} else if (e.getSource() == btInsereNovoServ) {// okkkkkkkkkkkkkkkkkkkkkkkkkkk
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela para Inserir o Servi�o",
						"Erro", JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente exibir a Ordem de Servi�o desse cliente selecionado?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int idOs = Integer.parseInt(p1);
					OrdemServico os = o.selecionaOSid(idOs);
					InterfaceServico inServ = new InterfaceServico(os);

				}
			}
		} else if (e.getSource() == btInserePreca) { // okkkkkkkkkkkkkkkkkkk
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela para Inserir o Servi�o",
						"Erro", JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente exibir a Ordem de Servi�o desse cliente selecionado?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int idItem = Integer.parseInt(p1);
					// = o.pegaIdItemOs(idOs);

					InterfacePeca2 inP2 = new InterfacePeca2(idItem);
				}
			}
		} else if (e.getSource() == inserePecaNova) {// okkkkkkkkkkkkkkkkkkkkkkkkkkk
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela para Inserir a Pe�a",
						"Erro", JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente exibir a Ordem de Servi�o desse cliente selecionado?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 0));
					int idItem = Integer.parseInt(p1);
					// int idItemOs = o.pegaIdItemOs(idOs);
					InterfacePeca inP = new InterfacePeca(idItem);

				}
			}

		} else if (e.getSource() == exibirServico) {// okkkkkkkkkkkkkkkkkkkkkkkk
		
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente exibir a Ordem de Servi�o desse cliente selecionado?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 2));
					int idOs = Integer.parseInt(p1);
					String sql = " SELECT s.idItemOs , se.descricao,se.id_servico FROM "
							+ "itemordemservico s left join servico se on "
							+ "s.idservico=se.id_servico where s.idOs =" + idOs;

					int op = 10;
					Tabela table = new Tabela(sql, op);
				}
			}
		}
			else if (e.getSource() == exirirPagamento) {// okkkkkkkkkkkkkkkkkkkkk
			
			int p = table.getSelectedRow();
			if (p == -1)
				JOptionPane.showMessageDialog(null,
						"Selecione uma linha da tabela", "Erro",
						JOptionPane.ERROR_MESSAGE);
			else {
				Object[] options = { "Confirmar", "Cancelar" };
				int m = JOptionPane
						.showOptionDialog(
								null,
								"Deseja realmente pagar essa Ordem de Servi�o selecionado?",
								"Informa��o", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					
					String p1 = String.valueOf(table.getValueAt(p, 2));
					int idOS = Integer.parseInt(p1);
					OrdemServico os = o.selecionaOSid(idOS);
					double d = o.pegarvalorOS(idOS);
					String vOS = String.valueOf(d);
					os.setValor(d);
					
					
					InterfacePagamento i = new InterfacePagamento(os);

				}
			}
		}
	}

	private void displayResultSet(ResultSet rs) {
		boolean moreRecords = false;
		try {
			moreRecords = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!moreRecords) {
			JOptionPane.showMessageDialog(this,
					"N�O FOI ENCOMTRADO NENHUM REGISTRO");
			setVisible(false);
			return;
		}
		Vector columnHeads = new Vector();
		Vector rows = new Vector();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i)
				columnHeads.addElement(rsmd.getColumnName(i));
			do {
				rows.addElement(getNextRow(rs, rsmd));

			} while (rs.next());

			table = new JTable(rows, columnHeads);
			JScrollPane scroller = new JScrollPane(table);
			getContentPane().add(scroller, BorderLayout.CENTER);
			validate();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

	void atualizartabela(ResultSet rs) {
		boolean moreRecords = false;
		try {
			moreRecords = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Vector columnHeads = new Vector();
		Vector rows = new Vector();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i)
				columnHeads.addElement(rsmd.getColumnName(i));
			do {
				rows.addElement(getNextRow(rs, rsmd));

			} while (rs.next());
			table.setModel(new javax.swing.table.DefaultTableModel(rows,
					columnHeads));
			// JScrollPane scroller = new JScrollPane(table);
			// getContentPane().add(scroller, BorderLayout.CENTER);
			// validate();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

	private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd)
			throws SQLException {
		Vector currentRow = new Vector();
		for (int i = 1; i <= rsmd.getColumnCount(); ++i)
			switch (rsmd.getColumnType(i)) {
			case Types.VARCHAR:
				currentRow.addElement(rs.getString(i));
				break;
			case Types.INTEGER:
				currentRow.addElement(new Long(rs.getLong(i)));
				break;
			case Types.DATE:
				currentRow.addElement(rs.getString(i));
				break;
			default:
				currentRow.addElement(rs.getString(i));
			}
		return currentRow;
	}

}
