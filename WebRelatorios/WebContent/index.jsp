<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/redmond/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
		<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				 	$(".data").datepicker({
				 		changeMonth: true,
				        changeYear: true,
						dateFormat: 'dd/mm/yy',
						dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
						dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
						dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
						monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
						monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
						nextText: 'Próximo',
						prevText: 'Anterior'
					});
			});
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Relatórios Jasper</title>
	</head>
	<body>
		<h1>Gerar relatório de clientes</h1>
		<form action="ProcessaRelatorio" method="post">
			<table>
				<tr>
					<td>Data Inicial</td><td><input type="text" readonly="true" name="dataInicial" class="data"/></td>
								
				</tr>
				<tr>
					<td>Data Final</td><td><input type="text" readonly="true" name="dataFinal" class="data" /></td>
				
				</tr>
				<tr>
					<td><input type="submit" value="Buscar" />
				</tr>
			</table>			
		</form>
	</body>
</html>