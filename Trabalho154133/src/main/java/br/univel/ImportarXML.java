package br.univel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ImportarXML {
	public void importar() {
		try {
			FileReader fr = new FileReader("arq.xml");// cria o leitor de
														// arquivo
			BufferedReader br = new BufferedReader(fr);// cria o buffer de
														// caracteres
			StringBuilder sb = new StringBuilder();// cria o construtor de
													// string
			String line = null;
			while ((line = br.readLine()) != null) {// enquanto a linha do
													// arquivo contiver dados
													// contiua lendo
				sb.append(line).append("\n");// coloca no contrutor os dados
												// retornados
			}
			String xml = sb.toString(); // adiciona a string construida em uma
										// variavel string
			br.close();// fecha buffer
			fr.close();// fecha File Reader
			StringReader in = new StringReader(xml);// cria StringReader
			JAXBContext context = JAXBContext.newInstance(Produto.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Produto Prd = (Produto) unmarshaller.unmarshal(in);

			System.out.println(Prd.getId());
			System.out.println(Prd.getDescricao());
			System.out.println(Prd.getPreco());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}