package br.univel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

public class XML {
	public boolean verificarArquivoExport(String arquivo) {
		File f = new File(arquivo);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	public boolean verificarImportCliente(String arquivo) {
		File f = new File(arquivo);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	public boolean verificarImportProduto(String arquivo) {
		File f = new File(arquivo);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	public String exportar(Object pc, String arquivo) {
		String xml = null;
		if (verificarArquivoExport(arquivo)) {
			StringWriter out = new StringWriter();
			JAXBContext context = null;
			try {
				context = JAXBContext.newInstance(pc.getClass());
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				marshaller.marshal(pc, new StreamResult(out));
			} catch (PropertyException e1) {
				e1.printStackTrace();
			} catch (JAXBException e1) {
				e1.printStackTrace();
			}
			xml = out.toString();
			FileWriter fw;
			try {
				fw = new FileWriter(arquivo);
				try {
					fw.write(xml);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return xml;
	}

	public void importarProduto(String arquivo) {
		if (verificarImportProduto(arquivo)) {
			try {
				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				String xml = sb.toString();
				br.close();
				fr.close();
				StringReader in = new StringReader(xml);
				JAXBContext context = JAXBContext.newInstance(ProdutosContainer.class);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				ProdutosContainer Prd = (ProdutosContainer) unmarshaller.unmarshal(in);
				Prd.getProduto().forEach(e -> {
					System.out.println(e.getId() + " " + e.getDescricao() + " " + e.getPreco());
				});
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	}

	public void importarCliente(String arquivo) {
		if (verificarImportCliente(arquivo)) {
			try {
				FileReader fr = new FileReader(arquivo); // arquivo
				BufferedReader br = new BufferedReader(fr);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				String xml = sb.toString();
				br.close();
				fr.close();
				StringReader in = new StringReader(xml);
				JAXBContext context = JAXBContext.newInstance(ClienteContainer.class);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				ClienteContainer C = (ClienteContainer) unmarshaller.unmarshal(in);
				C.getCliente().forEach(e -> {
					System.out.println(e.getId() + " " + e.getNome() + " " + e.getEndereço() + " " + e.getNumero() + " "
							+ e.getComplemento() + " " + e.getBairro() + " " + e.getCidade() + " " + e.getEstado() + " "
							+ e.getCEP() + " " + e.getTelefone() + " " + e.getCelular());
				});
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	}
}
