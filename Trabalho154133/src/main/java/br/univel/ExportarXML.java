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
	public void exportar(List<Produto> lista){
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
			}catch(PropertyException h){
				h.printStackTrace();
			}catch(JAXBException H){
				H.printStackTrace();
			}
			String xml = out.toString();
			FileWriter fw;
			try {
				fw = new FileWriter("arq.xml");
				fw.write(xml);
				fw.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		});	
	}
}
