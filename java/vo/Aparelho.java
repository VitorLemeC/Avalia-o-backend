package vo;

import java.util.Objects;

public class Aparelho {
	
	private int pecas;
	private String maquina;
	private String areatrabalhada;
	private float preco;
	
	public Aparelho() {
	}
	
	public Aparelho(String peças) {
		this.pecas = Integer.valueOf(peças);
	}

	public Aparelho(String[] vetor) {
		this.pecas = Integer.valueOf(vetor[0]);
		this.maquina = vetor[1];
		this.areatrabalhada = vetor[2];
		this.preco = Float.valueOf(vetor[3]);
	}

	public Aparelho(String id, String autor, String titulo, String preco) {
		this.pecas = Integer.valueOf(id);
		this.maquina = autor;
		this.areatrabalhada = titulo;
		this.preco = Float.valueOf(preco);
	}

	public int getId() {
		return pecas;
	}

	public void setId(int pecas) {
		this.pecas = pecas;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getAreatrabalhada() {
		return areatrabalhada;
	}

	public void setAreatrabalhada(String areatrabalhada) {
		this.areatrabalhada = areatrabalhada;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pecas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aparelho other = (Aparelho) obj;
		return pecas == other.pecas;
	}

	@Override
	public String toString() {
		return pecas + "\t" + maquina + "\t" + areatrabalhada + "\t" + preco + "\n";
	}

	public String toCSV() {
		return pecas + ";" + maquina + ";" + areatrabalhada + ";" + preco + "\r\n";
	}

	public String toHTML() {
		return "<td>" + pecas + "</td><td>" + maquina + "</td><td>" + areatrabalhada + "</td><td>" + preco + "</td>";
	}

	public Aparelho(String string, String string2, String string3) {

	}

}
