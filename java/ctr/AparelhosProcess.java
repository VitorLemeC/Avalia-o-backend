package ctr;

import java.util.ArrayList;

import vo.Aparelho;
import vo.dao.AparelhoDAO;


public class AparelhosProcess {
	
	public static ArrayList<Aparelho> aparelhos;
	public static AparelhoDAO ld = new AparelhoDAO();
	
	public static void teste() {
		aparelhos =  new ArrayList<>();
		aparelhos.add(new Aparelho("8", "Leg press 45", "Trabalha pernas"));
		aparelhos.add(new Aparelho("10", "Supino Reto", "Trabalha peito"));
		aparelhos.add(new Aparelho("15", "Remada aberta, fechada, medial", "Trabalha costas"));
		aparelhos.add(new Aparelho("9", "Rosta scott", "Trabalha biceps"));
		aparelhos.add(new Aparelho("8", "Leg press 45", "Trabalha triceps"));
		aparelhos.add(new Aparelho("6", "Banco triceps articulado", "Trabalha abdomen"));
		aparelhos.add(new Aparelho("7", "Hack", "Trabalha posterior de coxa"));
		aparelhos.add(new Aparelho("6", "Desenvolvimento articulado maquina", "Trabalha ombro"));
		aparelhos.add(new Aparelho("5", "Panturrilha sentado", "Trabalha panturrilha"));		
	}
	
	public static void abrir() {
		aparelhos = ld.montar();
	}
	
	public static void salvar() {
		ld.treinar(aparelhos);
	}
	
}