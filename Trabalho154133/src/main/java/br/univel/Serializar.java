package br.univel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializar {

	public void SerializarProdutos(List<Produto> lista, String arquivo){
		File file = new File(arquivo);
	
		lista.forEach(e ->{
			try(FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(e);			
			}catch(Exception E){
				E.printStackTrace();
			}
		});
	}
	public void SerializarClientes(List<Cliente> lista, String arquivo){
		File file = new File(arquivo);
		
		lista.forEach(e ->{
			try(FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(e);			
			}catch(Exception E){
				E.printStackTrace();
			}
		});
	}
	
	public void ImportSerialClientes(String arquivo) {
		File file = new File(arquivo);
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Cliente C = (Cliente) ois.readObject();
			
			System.out.println(C.getId());
			System.out.println(C.getNome());
			System.out.println(C.getEndereço());
			System.out.println(C.getNumero());
			System.out.println(C.getComplemento());
			System.out.println(C.getBairro());
			System.out.println(C.getCidade());
			System.out.println(C.getEstado());
			System.out.println(C.getCEP());
			System.out.println(C.getTelefone());
			System.out.println(C.getCelular());		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void ImportSerialProdutos(String arquivo) {
		File file = new File(arquivo);
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Produto p = (Produto) ois.readObject();
			
			System.out.println(p.getId()+" "+p.getDescricao()+" "+p.getPreco());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
