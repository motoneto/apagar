package br.univel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnNewButton = new JButton("PreencheProdutos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LerArquivoTexto arq = new LerArquivoTexto();
				List<String> listaP = arq.lerArquivo("Produtos.txt");
				Parser parser = new Parser();
				List<Produto> listaPrd = parser.getProduto(listaP);
				preencheProdutoTabela(listaPrd);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnExportarXmlProdutos = new JButton("Export XML Produtos");
		btnExportarXmlProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExportarXmlProdutos();
			}

			private void ExportarXmlProdutos() {
				LerArquivoTexto arq = new LerArquivoTexto();
				List<String> listaP = arq.lerArquivo("Produtos.txt");
				Parser parser = new Parser();
				List<Produto> listaPrd = parser.getProduto(listaP);
				ProdutosContainer pc = new ProdutosContainer();
				pc.setProduto(listaPrd);
				XML xml = new XML();

				xml.exportar(pc.getProduto(), "ListaProduto.xml");
			}
		});

		JButton btnExportarXMLCliente = new JButton("Export XML Cliente");
		btnExportarXMLCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExportarXmlClientes();
			}

			private void ExportarXmlClientes() {
				LerArquivoTexto arq = new LerArquivoTexto();
				List<String> listaC = arq.lerArquivo("Clientes.txt");
				Parser parser = new Parser();
				List<Cliente> listaCli = parser.getCliente(listaC);
				ClienteContainer cc = new ClienteContainer();
				cc.setCliente(listaCli);
				XML xml = new XML();

				xml.exportar(cc.getCliente(), "ListaCliente.xml");
			}
		});

		JButton btnNewButton2 = new JButton("PreencheClientes");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LerArquivoTexto arq = new LerArquivoTexto();
				List<String> listaC = arq.lerArquivo("Clientes.txt");
				Parser parser = new Parser();
				List<Cliente> listaCli = parser.getCliente(listaC);
				preencheClienteTabela(listaCli);
			}
		});
		GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
		gbc_btnNewButton2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton2.gridx = 0;
		gbc_btnNewButton2.gridy = 1;
		contentPane.add(btnNewButton2, gbc_btnNewButton2);
		GridBagConstraints gbc_btnExportarXMLCliente = new GridBagConstraints();
		gbc_btnExportarXMLCliente.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportarXMLCliente.gridx = 0;
		gbc_btnExportarXMLCliente.gridy = 2;
		contentPane.add(btnExportarXMLCliente, gbc_btnExportarXMLCliente);
		GridBagConstraints gbc_btnExportarXmlProdutos = new GridBagConstraints();
		gbc_btnExportarXmlProdutos.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportarXmlProdutos.gridx = 0;
		gbc_btnExportarXmlProdutos.gridy = 3;
		contentPane.add(btnExportarXmlProdutos, gbc_btnExportarXmlProdutos);

		JButton btnImportarXMLProduto = new JButton("Importa XML Produto");
		btnImportarXMLProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportarXMLProduto();
			}

			private void ImportarXMLProduto() {
				XML xml = new XML();
				List<Produto> listaP = new ArrayList<Produto>();
				listaP = xml.importarProduto("ListaProduto.xml");
				preencheProdutoTabela(listaP);
			}
		});
		GridBagConstraints gbc_btnImportarXMLProduto = new GridBagConstraints();
		gbc_btnImportarXMLProduto.insets = new Insets(0, 0, 5, 0);
		gbc_btnImportarXMLProduto.gridx = 0;
		gbc_btnImportarXMLProduto.gridy = 4;
		contentPane.add(btnImportarXMLProduto, gbc_btnImportarXMLProduto);

		JButton btnImportarXMLCliente = new JButton("Import XML Cliente");
		btnImportarXMLCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportarXMLCliente();
			}

			private void ImportarXMLCliente() {
				XML xml = new XML();
				List<Cliente> listaC = new ArrayList<Cliente>();
				listaC = xml.importarCliente("ListaCliente.xml");
				preencheClienteTabela(listaC);
			}
		});
		GridBagConstraints gbc_btnImportarXMLCliente = new GridBagConstraints();
		gbc_btnImportarXMLCliente.insets = new Insets(0, 0, 5, 0);
		gbc_btnImportarXMLCliente.gridx = 0;
		gbc_btnImportarXMLCliente.gridy = 5;
		contentPane.add(btnImportarXMLCliente, gbc_btnImportarXMLCliente);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable() {

			public String getToolTipText(MouseEvent e) {

				String tip = null;

				Point p = e.getPoint();

				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				if (rowIndex == -1 || colIndex == -1) {
					return null;
				}

				try {
					tip = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {

				}

				return tip;

			}

		};

		scrollPane.setViewportView(table);

		// final
		configuraTabela();
	}

	private void configuraTabela() {
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					Produto p = getProdutoSelecionadoNaTabela();
					if (p != null) {
						JOptionPane.showMessageDialog(null, "Cliente: " + p.toString());
					}
				}
			}
		});
	}

	protected void preencheProdutoTabela(List<Produto> listaPrd) {

		List<Produto> list = new ArrayList<>();

		listaPrd.forEach(e -> {
			Produto p = new Produto(e.getId(), e.getDescricao(), e.getPreco());
			list.add(p);
		});
		ModeloProduto model = new ModeloProduto(list);
		table.setModel(model);

	}

	protected void preencheClienteTabela(List<Cliente> listaCli) {

		List<Cliente> list = new ArrayList<>();

		listaCli.forEach(e -> {
			Cliente c = new Cliente(e.getId(), e.getNome(), e.getEndereço(), e.getNumero(), e.getComplemento(),
					e.getBairro(), e.getCidade(), e.getEstado(), e.getCEP(), e.getTelefone(), e.getCelular());
			list.add(c);
		});
		ModeloCliente model = new ModeloCliente(list);
		table.setModel(model);

	}

	private Produto getProdutoSelecionadoNaTabela() {
		Produto p = null;
		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		} else {
			p = ((ModeloProduto) table.getModel()).getprodutoNaLinha(index);
		}
		return p;
	}
}
