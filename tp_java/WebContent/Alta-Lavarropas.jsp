<%@page import="entidades.Lavarropas"%>
<%@page import="entidades.Electrodomestico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Lavarropas</title>
</head>
<body>
<%Electrodomestico e=((Electrodomestico)request.getAttribute("elect"));%>
<%if(e==null){ %>
<h1 align="left">Alta Lavarropas</h1>
<form action="AltaLavarropas" method="post">
<table>
<tr>
<td>Precio Base</td>
<td><input type="text" value="100" name="preciobase" id="preciobase"></td>
</tr>
<tr>
<td>Color</td>
<td><select name="color">
      <option value="blanco">Blanco</option>
      <option value="negro">Negro</option>
      <option value="rojo">Rojo</option>
      <option value="azul">Azul</option>
      <option value="gris">Gris</option>
    </select></td>
</tr>
<tr>
<td>Conaumo Energetico</td>
<td><select name="consumo">
      <option value="F">F</option>
      <option value="A">A</option>
      <option value="B">B</option>
      <option value="C">C</option>
      <option value="D">D</option>
      <option value="E">E</option>   
    </select></td></tr>
    
<tr>
<td>Peso</td>
<td><input type="text" value="5" name="peso" id="peso"></td>
</tr>
<tr>
<td>Carga</td>
<td><input type="text" value="5" name="carga" id="carga"></td>
</tr>
<tr>
<td></td>
<td align="right"><input type="submit" value="Aceptar">
</tr>
</table>
</form>
<a href="alta.html">Volver</a>
<%}else{ %>
<h1 align="left">Alta Lavarropas</h1>
<form action="AltaLavarropas" method="post">
<table>
<tr>
<td>Precio Base</td>
<td><input type="text" value="<%=e.getPreciobase()%>" name="preciobase" id="preciobase"></td>
</tr>
<tr>
<td>Color</td>
<td><select name="color">
      <option value="<%=e.getColor().getNombreColor()%>"><%=e.getColor().getNombreColor() %></option>
      <option value="blanco">Blanco</option>
      <option value="negro">Negro</option>
      <option value="rojo">Rojo</option>
      <option value="azul">Azul</option>
      <option value="gris">Gris</option>
    </select></td>
</tr>
<tr>
<td>Conaumo Energetico</td>
<td><select name="consumo" >
      <option value="<%=e.getConsumo().getLetra()%>"><%=e.getConsumo().getLetra() %></option>
      <option value="F">F</option>
      <option value="A">A</option>
      <option value="B">B</option>
      <option value="C">C</option>
      <option value="D">D</option>
      <option value="E">E</option>   
    </select></td></tr>
    
<tr>
<td>Peso</td>
<td><input type="text" value="<%=e.getpeso() %>" name="peso" id="peso"></td>
</tr>
<tr>
<td>Carga</td>
<td><input type="text" value=" <%=((Lavarropas)e).getCarga()%>" name="carga" id="carga"></td>
</tr>
<tr>
<td></td>
<td align="right"><input type="submit" value="Aceptar">
</tr>
</table>
</form>
<%} %>
</body>
</html>