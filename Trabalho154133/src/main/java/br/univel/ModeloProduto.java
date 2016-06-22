package br.univel;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

public class ModeloProduto extends AbstractTableModel {

	private List<Produto> lista;
	NumberFormat formatBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	BigDecimal cotacao = new BigDecimal(3.37);
	public ModeloProduto(List<Produto> list) {
		this.lista = list;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Produto p = lista.get(row);

		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getDescricao();
		case 2:
			return formatBR.format(p.getPreco().multiply(cotacao));
		}

		return null;
	}

	public Produto getprodutoNaLinha(int index) {
		return lista.get(index);
	}

	public void removerProduto(Produto p) {
		int idx = this.lista.indexOf(p);
		this.lista.remove(p);
		super.fireTableRowsDeleted(idx, idx);
	}

	public void adicionarCliente(Produto p) {
		this.lista.add(p);
		super.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);

	}

}
