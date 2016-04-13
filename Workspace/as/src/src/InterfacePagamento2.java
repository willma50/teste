package src;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
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
public class InterfacePagamento2 extends javax.swing.JFrame {
	private JTabbedPane jTabbedPane1;
	private JPanel labelAvista;
	private JPanel labelBoleto;
	private JTextField textValorRecebido;
	private JLabel labelValorRecebido;
	private JTextField textValorPagar;
	private JLabel labelValorPagar;
	private JTextField textDesconto;
	private JLabel labelDesconto;
	private JLabel labelTroco;
	private JButton btCancAvista;
	private JButton btConfirAvista;
	private JTextField textTroco;
	private JTextField textValorOS;
	private JLabel labelValorOS;
	private JPanel labelCartaoCred;
	private JPanel labelCartaoDebito;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfacePagamento2 inst = new InterfacePagamento2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public InterfacePagamento2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				{
					labelAvista = new JPanel();
					jTabbedPane1.addTab("A vista", null, labelAvista, null);
					labelAvista.setLayout(null);

					{
						labelValorOS = new JLabel();
						labelAvista.add(labelValorOS);
						labelValorOS.setText("Valor da Ordem Serviço");
						labelValorOS.setBounds(12, 32, 145, 14);
					}
					{
						textValorOS = new JTextField();
						labelAvista.add(textValorOS);
						textValorOS.setBounds(157, 29, 55, 21);
					}
					{
						labelDesconto = new JLabel();
						labelAvista.add(labelDesconto);
						labelDesconto.setText("Desconto");
						labelDesconto.setBounds(230, 32, 62, 14);
					}
					{
						textDesconto = new JTextField();
						labelAvista.add(textDesconto);
						textDesconto.setBounds(290, 29, 71, 21);
					}
					{
						labelValorPagar = new JLabel();
						labelAvista.add(labelValorPagar);
						labelValorPagar.setText("Valor a pagar");
						labelValorPagar.setBounds(12, 73, 87, 14);
					}
					{
						textValorPagar = new JTextField();
						labelAvista.add(textValorPagar);
						textValorPagar.setBounds(99, 70, 58, 21);
					}
					{
						labelValorRecebido = new JLabel();
						labelAvista.add(labelValorRecebido);
						labelValorRecebido.setText("Valor Recebido");
						labelValorRecebido.setBounds(181, 73, 93, 14);
					}
					{
						textValorRecebido = new JTextField();
						labelAvista.add(textValorRecebido);
						textValorRecebido.setBounds(286, 71, 74, 18);
					}
					{
						labelTroco = new JLabel();
						labelAvista.add(labelTroco);
						labelTroco.setText("Troco");
						labelTroco.setBounds(232, 116, 59, 14);
					}
					{
						textTroco = new JTextField();
						labelAvista.add(textTroco);
						textTroco.setBounds(290, 113, 70, 21);
					}
					{
						btConfirAvista = new JButton();
						labelAvista.add(btConfirAvista);
						btConfirAvista.setText("Confirmar");
						btConfirAvista.setBounds(85, 183, 96, 21);
					}
					{
						btCancAvista = new JButton();
						labelAvista.add(btCancAvista);
						btCancAvista.setText("Cancelar");
						btCancAvista.setBounds(199, 183, 99, 21);
					}
				}
				{
					labelCartaoDebito = new JPanel();
					jTabbedPane1.addTab("Cartão de Debito", null, labelCartaoDebito, null);
					
				}
				{
					labelCartaoCred = new JPanel();
					jTabbedPane1.addTab("Cartão de Credito", null, labelCartaoCred, null);
					
				}
				{
					labelBoleto = new JPanel();
					jTabbedPane1.addTab("Boleto Bancario", null, labelBoleto, null);
					
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
