package br.univel;

import java.io.FileWriter;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamResult;

public class ExportarXML {
	public void exportarProduto(List<Produto> lista){
		Produto p = new Produto();
		lista.forEach(e -> {
			StringWriter out = new StringWriter();
			JAXBContext context = null;
			
			try{
				context = JAXBContext.newInstance(p.getClass());
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(
						javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
						Boolean.TRUE);
				marshaller.marshal(p, new StreamResult(out));
			}catch(PropertyException e1){
				e1.printStackTrace();
			}catch(JAXBException e1){
				e1.printStackTrace();
			}
			String xml = out.toString();
			FileWriter fw;
			try {
				fw = new FileWriter("ListaProduto.xml");
				fw.write(xml);
				fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		});	
	}
	public void exportarCliente(List<Cliente> lista){
		Cliente c = new Cliente();
		lista.forEach(e -> {
			StringWriter out = new StringWriter();
			JAXBContext context = null;
			
			try{
				context = JAXBContext.newInstance(c.getClass());
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(
						javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
						Boolean.TRUE);
				marshaller.marshal(c, new StreamResult(out));
			}catch(PropertyException e1){
				e1.printStackTrace();
			}catch(JAXBException e1){
				e1.printStackTrace();
			}
			String xml = out.toString();
			FileWriter fw;
			try {
				fw = new FileWriter("ListaCliente.xml");
				fw.write(xml);
				fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		});	
	}
}
