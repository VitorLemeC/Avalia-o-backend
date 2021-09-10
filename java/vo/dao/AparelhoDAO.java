package vo.dao;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import vo.Aparelho;

public class AparelhoDAO {
	
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "c:\\dbs\\aparelhos.csv";
	private ArrayList<Aparelho> aparelhos; // lista de modelos
	private Aparelho aparelho; // modelo

	public void escrever(ArrayList<Aparelho> aparelhos) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for (Aparelho l : aparelhos) {
				bw.write(l.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar: " + e);
		}
	}

	public ArrayList<Aparelho> treinar() {
		aparelhos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				aparelho = new Aparelho(linha.split(";"));
				aparelhos.add(aparelho);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado: " + e);
		} catch (IOException e) {
			System.out.println("Erro ao abrir: " + e);
		}
		return aparelhos;
	}


	public ArrayList<Aparelho> montar() {
		return null;
	}

	public void treinar(ArrayList<Aparelho> aparelhos) {
		
	}

}
