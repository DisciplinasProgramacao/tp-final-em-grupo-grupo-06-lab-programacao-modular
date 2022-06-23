package dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import cliente.Clientes;




public class ClientesDAO implements DAO<Clientes, String> {
	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public ClientesDAO(String filename) throws IOException {
		file = new File(filename);
		if (file.exists())
			file.delete();
		fos = new FileOutputStream(file, false); 
		outputFile = new ObjectOutputStream(fos);
	}

	public void add(Clientes cliente) {
		try {
			outputFile.writeObject(cliente);
		} catch (Exception e) {
			System.out.println("ERRO ao gravar o Cliente" + cliente.getNome() + "' no disco!");
			e.printStackTrace();
		}
	}

	public Clientes get(String chave) {
		Clientes Clientes = null;

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {
			while (fis.available() > 0) {
				Clientes = (Clientes) inputFile.readObject();

				if (chave.equals(Clientes.getCpf())) {
					return Clientes;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler o Cliente '" + chave + "' do disco!");
			e.printStackTrace();
		}
		return null;
	}

	public List<Clientes> getAll() {
		List<Clientes> clientes = new ArrayList<Clientes>();
		Clientes cliente = null;
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				cliente = (Clientes) inputFile.readObject();
				clientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Clientes no disco!");
			e.printStackTrace();
		}
		return clientes;
	}

	public void update(Clientes p) {
		List<Clientes> clientes = getAll();
		int index = clientes.indexOf(p);
		if (index != -1) {
			clientes.set(index, p);
		}
		saveToFile(clientes);
	}

	public void delete(Clientes p) {
		List<Clientes> clientes = getAll();
		int index = clientes.indexOf(p);
		if (index != -1) {
			clientes.remove(index);
		}
		saveToFile(clientes);
	}

	private void saveToFile(List<Clientes> clientes) {
		try {
			close();
			fos = new FileOutputStream(file, false); 
			outputFile = new ObjectOutputStream(fos);

			for (Clientes cliente : clientes) {
				outputFile.writeObject(cliente);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Clientes no disco!");
			e.printStackTrace();
		}
	}
	
	private void close() throws IOException {
		outputFile.close();
		fos.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.close();
	}

}
