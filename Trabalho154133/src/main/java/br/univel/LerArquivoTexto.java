package br.univel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoTexto {
	public boolean verificarArquivo(String arquivo){
		
		File f = new File(arquivo);
		if(f.exists() && !f.isDirectory()){
			return true;
		}
		return false;
	}
	public List<String> lerArquivo(String arquivo) {
		ArrayList<String> lista = new ArrayList<>();			
		if (verificarArquivo(arquivo)) {
			try (FileReader fr = new FileReader(new File(arquivo));
					BufferedReader br = new BufferedReader(fr)) {
				
				String linha = null;
				while ((linha = br.readLine()) != null) {
					lista.add(linha);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}
