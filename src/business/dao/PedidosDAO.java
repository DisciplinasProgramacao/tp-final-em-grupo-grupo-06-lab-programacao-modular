package dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Business.Pedidos;


public class PedidosDAO implements DAO<Pedidos, String> {
	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public PedidosDAO(String filename) throws IOException {
		file = new File(filename);
		if (file.exists())
			file.delete();
		fos = new FileOutputStream(file, false); 
		outputFile = new ObjectOutputStream(fos);
	}

	public void add(Pedidos Pedidos) {
		try {
			outputFile.writeObject(Pedidos);
		} catch (Exception e) {
			System.out.println("ERRO ao gravar o Pedidos" + Pedidos.getNome() + "' no disco!");
			e.printStackTrace();
		}
	}

	public Pedidos get(String chave) {
		Pedidos Pedidos = null;

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {
			while (fis.available() > 0) {
				Pedidos = (Pedidos) inputFile.readObject();

				if (chave.equals(Pedidos.getId())) {
					return Pedidos;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler o Pedidos '" + chave + "' do disco!");
			e.printStackTrace();
		}
		return null;
	}

	public List<Pedidos> getAll() {
		List<Pedidos> Pedidoss = new ArrayList<Pedidos>();
		Pedidos Pedidos = null;
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				Pedidos = (Pedidos) inputFile.readObject();
				Pedidoss.add(Pedidos);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Pedidos no disco!");
			e.printStackTrace();
		}
		return Pedidoss;
	}

	public void update(Pedidos p) {
		List<Pedidos> Pedidoss = getAll();
		int index = Pedidoss.indexOf(p);
		if (index != -1) {
			Pedidoss.set(index, p);
		}
		saveToFile(Pedidoss);
	}

	public void delete(Pedidos p) {
		List<Pedidos> Pedidoss = getAll();
		int index = Pedidoss.indexOf(p);
		if (index != -1) {
			Pedidoss.remove(index);
		}
		saveToFile(Pedidoss);
	}

	private void saveToFile(List<Pedidos> Pedidoss) {
		try {
			close();
			fos = new FileOutputStream(file, false); 
			outputFile = new ObjectOutputStream(fos);

			for (Pedidos Pedidos : Pedidoss) {
				outputFile.writeObject(Pedidos);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Pedidos no disco!");
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
