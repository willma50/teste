import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.print.DocFlavor.STRING;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class InterfaceServicosDiarios extends JFrame implements ActionListener {

	private JLabel rotulodata_abertura;
	private Container tela1 = getContentPane();
	private JFormattedTextField data_abertura;
	private MaskFormatter mascaradata_abertura;
	private JPanel panelCenter = new JPanel();
	private JPanel painelCentroData = new JPanel();
	private JButton bOk = new JButton("OK");

	public InterfaceServicosDiarios() {
		super("RELATÓRIO DIÁRIO");
		setSize(420, 200);
		setVisible(true);
		try {
			mascaradata_abertura = new MaskFormatter("####-##-##");

			mascaradata_abertura.setPlaceholderCharacter('_');
		} catch (ParseException excp) {

		}
		data_abertura = new JFormattedTextField(mascaradata_abertura);
		rotulodata_abertura = new JLabel("Data de Abertura :");

		FlowLayout flo = new FlowLayout();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		tela1.add(panelCenter, BorderLayout.CENTER);

		panelCenter.add(painelCentroData);

		painelCentroData.setLayout(flo);
		painelCentroData.add(rotulodata_abertura);
		painelCentroData.add(data_abertura);
		painelCentroData.add(bOk);

		bOk.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bOk) {
			if(testando()== false){
			OperacoesDoSistema o = new OperacoesDoSistema();
			System.out.println(data_abertura.getText());
			String a = String.valueOf(data_abertura.getText());
			o.relatorioDeServiosDiarios(a);
			}
		}
	}
// para que isso
	String getData_abertura() {
		return data_abertura.getText();
	}

	public boolean testando() {
		boolean erro = false;
		if (data_abertura.getText().equals("____-__-__")) {
			erro = true;
			JOptionPane
					.showMessageDialog(
							null,
							"Para Exibir os Serviços Feitos durante algum dia deve informar a DATA!",
							" Erro ", JOptionPane.ERROR_MESSAGE);
			data_abertura.grabFocus();
		}
		return erro;
	}
}