<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="fr">
<meta http-equiv="content-type" content="text/html;charset=utf-8"></meta>
<meta charset="UTF-8" />
<title>PV Commission</title>
<style>
.template_top_header_logo {
	text-align: end;
}

.template_top_header {
	text-align: center;
	padding-top: 10px;
	padding-bottom: 20px;
	font-size: 12px;
	font-weight: 600;
	font-family: Arial, Helvetica, sans-serif !important;
}

.template_header {
	text-align: center;
	padding-top: 50px;
}

html.v_scrollbar {
	overflow-y: scroll;
}

html {
	height: 100%;
	font-size: 100%;
}

html, body, h1, h2, h3, h4, p, img {
	margin: 0;
}

html {
	font-size: 13px !important;
	color: #000 !important;
	font-family: Times, "Times New Roman", Georgia, serif !important;
}

body {
	font: normal 16px Times, "Times New Roman", Georgia, serif !important;
}

.marge_page {
	margin-top: 10px !important;
	margin-bottom: 40px !important;
}

.font-report {
	font-family: Times, "Times New Roman", Georgia, serif !important;
	font-size: 1.5em !important;
}

.font-reportAR {
	font-family: Times, "Times New Roman", Georgia, serif !important;
	font-size: 16px !important;
}

h3.titreFR {
	font-family: 'Andalus', Times, serif !important;
	text-decoration: underline;
	font-size: 20px;
}

.logoX {
	text-align: center !important;
	width: 50%;
}

table {
	border-collapse: collapse;
}

.table-dir {
	text-align: left;
	direction: ltr
}

.list-dir {
	text-align: right !important;
}

.table-header {
	text-align: center;
	border: 1px solid #566573;
	padding: 10px;
	text-transform: uppercase;
	color: #FFFFFF;
}

.boder-table {
	border: 1px solid #c3c3c3;
	padding: 3px;
}
/** styles personnalises**/
.td-presence {
	text-transform: uppercase;
	width: 10%;
	border: 1px solid #566573;
	padding: 10px;
}

.td-membre {
	text-transform: uppercase;
	width: 40%;
	font-size: 14px;
	border: 1px solid #566573;
	padding: 10px;
}

.td-role {
	text-transform: uppercase;
	width: 40%;
	font-size: 14px;
	border: 1px solid #566573;
	padding: 10px;
}

.txt-weight {
	font-weight: bold;
}

.titre-h3 {
	text-transform: uppercase !important;
	text-decoration: underline;
	font-size: 16px;
	font-family: 'Times New Roman', Times, serif !important;
}

.thead-table {
	background-color: #566573;
	border-top: 1px solid #566573;
}

.header-titre {
	font-size: 12px;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="marge_page font-reportAR">
		<div class="template_top_header">
			<table width="100%">
				<tr>
					<td width="30%">
						<dir class="header-titre">
							<p>ROYAUME DU MAROC</p>
							<p>MINISTERE DE L’INTERIEUR</p>
							<p>WILAYA REGION MARRAKECH SAFI</p>
							<p>ET PREFECTURE DE MARRAKECH</p>
							<p>COMMUNE DE MARRAKECH</p>
							<p>DIRECTION GENERALE DES SERVICES</p>
							<p>DIVISION DES MARCHES</p>
						</dir>
					</td>
					<td width="40">
						<div style="text-align: center;">
							<img
								src="http://marrakech.jamaati.hvc.ma:8080/jamaati/assets/media/logos/logo-mini-md.png"
								style="width: 40%;" />
						</div>
					</td>
					<td width="30%"></td>
				</tr>
			</table>
		</div>
		<div class="template_header">
			<p class="titre-h3"><b>PV DE PRESENCE DU COMMISSION
				${typeCommission?upper_case}</b></p>
			<h3>
				<b class="titre-h3">le</b>&nbsp;<#if
				detail.dateOuverturePlis??>${detail.dateOuverturePlis?string["dd/MM/yyyy"]}<#else>...</#if>&nbsp;
				<b class="titre-h3">à</b>&nbsp;<#if
				detail.dateOuverturePlis??>${detail.dateOuverturePlis?string["HH:mm"]}<#else>...</#if>&nbsp;
			</h3>
			<h3>
				<b class="titre-h3">APPEL D'OFFRES N° :</b>&nbsp; ${detail.numAo}
			</h3>
			<br />
			<h3>${detail.objet}</h3>
		</div>
		<br /> <br />
		<!-- start::table-secteur -->
		<#list _commissionlist>
		<table class="table" width="100%">
			<thead class="thead-table">
				<tr>
					<td class="table-header">Rôle membre du commission</td>
					<td class="table-header">Nom</td>
					<td class="table-header">Présence</td>
				</tr>
			</thead>
			<tbody>
				<#items as commission>
				<tr>
					<td class="td-role">${commission.role}</td>
					<td class="td-membre">${commission.membre}</td>
					<td class="td-presence">${commission.presence}</td>
				</tr>
				</#items>
			</tbody>
		</table>
		</#list> <br /> <br />
		<div
			style="text-align: center; font-weight: 600; text-decoration: underline;">
			<span style="text-align: center;">
				<p>Marrakech, le : <#if
					_dateExport??>${_dateExport?string["dd/MM/yyyy"]}<#else>...</#if></p> <br />
				<p>Le Président de la Commune</p> <br />
				<p>De Marrakech</p> <br />
			</span>
		</div>
	</div>
</body>
</html>