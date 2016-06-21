package br.univel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	private NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));

	public List<Produto> getProduto(List<String> listaStr) {
		List<Produto> listaPrd = new ArrayList<>();

		Pattern p = Pattern.compile("[0-9]+.*");

		listaStr.forEach(e -> {

			if (!e.startsWith("----")) {
				Matcher m = p.matcher(e);
				if (m.matches()) {
					listaPrd.add(getProduto(e));
				}
			}

		});

		return listaPrd;
	}
	
	public List<Cliente> getCliente(List<String> listaStr) {
	List<Cliente> listaCli = new ArrayList<>();

	Pattern p = Pattern.compile("[0-9]+.*");

	listaStr.forEach(e -> {

		if (!e.startsWith("----")) {
			Matcher m = p.matcher(e);
			if (m.matches()) {
				listaCli.add((getCliente(e)));
			}
		}

	});

	return listaCli;
}

	private Produto getProduto(String str) {

		int indexPrimeiroEspaco = str.indexOf(' ');
		String subStringCodigo = str.substring(0, indexPrimeiroEspaco);
		int id = Integer.parseInt(subStringCodigo);

		String strSemCodigo = str.substring(indexPrimeiroEspaco).trim();

		int indexDolar = strSemCodigo.indexOf("US$");

		String descricao = strSemCodigo.substring(0, indexDolar).trim();

		BigDecimal preco = null;
		String strPreco = null;

		try {
			strPreco = strSemCodigo.substring(indexDolar + 3).trim();
			preco = new BigDecimal(format.parse(strPreco).doubleValue());
			preco.setScale(2, RoundingMode.HALF_EVEN);

		} catch (NumberFormatException | ParseException e) {

			System.out.println(strPreco);

			e.printStackTrace();
		}

		Produto p = new Produto(id, descricao, preco);
		return p;
	}
	private Cliente getCliente(String str) {
		
		

		Cliente c = new Cliente();
		return c;
	}

}
