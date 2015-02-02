<%@page import="entidades.Television"%>
<%@page import="entidades.Lavarropas"%>
<%@page import="entidades.Electrodomestico"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Electrodomesticos</title>
</head>
<body>
<h1 style="color: green">Listado</h1>
<%ArrayList<Electrodomestico> elec=((ArrayList <Electrodomestico>)request.getAttribute("elect")); %>
<table border="2" bordercolor="green">
<tr style="font-weight: bold;">
<td>id</td>
<td>Descripcion</td>
<td>Color</td>
<td>Peso</td>
<td>consumo</td>
<td>Precio</td>
<td>carga</td>
<td>Resolucion</td>
<td>Sintonizador</td>
</tr>
<% for(int i=0;i<elec.size();i++){ %>
<tr>
	<td align="center"> <%=elec.get(i).getIndice()%></td>
	<td align="center"> <%=elec.get(i).getDesc() %></td>
	<td align="center"> <%=elec.get(i).getColor().getNombreColor() %></td>
	<td align="center"> <%=elec.get(i).getPeso() %></td>
	<td align="center"> <%=elec.get(i).getConsumo().getLetra() %></td>
	<td align="center"><%=elec.get(i).getPreciobase() %></td>
	<td align="center"> <%if(elec.get(i) instanceof Lavarropas) 
			{%> <%=((Lavarropas)elec.get(i)).getCarga() %>
			<%}else{ %> <%=" "%> <%} %></td>
 	<td align="center"> <%if(elec.get(i) instanceof Television)
 			{%> <%=((Television)elec.get(i)).getResolucion() %>
 			<%}else{%> <%=" "%> <%}%></td>
 	<td align="center"> <%if(elec.get(i) instanceof Television)
 			{%> <%=((Television)elec.get(i)).getTDT()%>
 			<%}else{%> <%=" "%> <%}%></td>
 			
				
</tr>
<%} %>
</table>
<a href="listado.html">Volver</a>
</body>
</html>