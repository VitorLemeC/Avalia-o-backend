<%@ page import="vo.Aparelho"%>
<%@ page import="ctr.AparelhosProcess"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novos Aparelhos</title>
<link rel=stylesheet href="crud.css">
</head>
<body>
	<%
	String pecas = request.getParameter("id");
	String maquina = request.getParameter("id");
	String areatrabalhada = request.getParameter("id");
	String preco = request.getParameter("id");
	AparelhosProcess.teste();
	%>

	<form>
		<label>pecas</label><input type="number" name="pecas" required/> <label>maquina</label><input
			type="text" name="maquina" required/> <label>areatrabalhada</label><input
			type="text" name="areatrabalhada" required/> <label>Preco</label><input
			type="number" name="preco" required/>
		<button type="submit">Enviar</button>
	</form>
	<div class="msg">
		<%
		if (pecas != null && maquina != null && areatrabalhada != null && preco != null) {
			Aparelho aparelho = new Aparelho(pecas,maquina,areatrabalhada,preco); //Preenche um novo modelo
			if(AparelhosProcess.aparelhos.contains(aparelho)){ //Verifica se não é duplicado
				out.print("Id duplicado"); //Da uma mensagem
			}else{//Se não for duplicado
				AparelhosProcess.aparelhos.add(aparelho); //Adicona o livro na lista
				AparelhosProcess.salvar();//Salva a lista no arquivo
				response.sendRedirect("crud.jsp");//Redireciona limpando o verbo GET
			}
		} else {
			if(pecas != null){//Se chegou apenas um id para ser removido
				AparelhosProcess.aparelhos.remove(new Aparelho(pecas)); //Remove da lista
				AparelhosProcess.salvar(); //Salva a lista sem o item removido
				response.sendRedirect("crud.jsp");

		} else {
			out.print("Aguardando requisicoes");
		}
		%>
	</div>
	<table border="1">
		<tr>
			<th>pecas</th>
			<th>maquina</th>
			<th>areatrabalhada</th>
			<th>Preco</th>
			<th>Acoes</th>
		</tr>
		<%
		AparelhosProcess.abrir();
		for (Aparelho l : AparelhosProcess.aparelhos) {
			out.print("<tr>");
			out.print("<form>");
			out.print(l.toHTML());
			out.print("<td>");
			out.print("<input type='hiden' name='id' value'" + l.getId() + "'/>");
			out.print("<td><button type='submit'>Del</button></td>");
			out.print("</td>");
			out.print("</form>");
			out.print("</tr>");
		}
		%>
	</table>

</body>
</html>