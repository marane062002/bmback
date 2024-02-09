<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="fr">
<meta http-equiv="content-type" content="text/html;charset=utf-8"></meta>
<meta charset="UTF-8" />
<title>Bordereau</title>
<style>
page {
	background: white;
	display: block;
	margin: 0 auto;
	margin-bottom: 0.5cm;
	box-shadow: 0 0 0.5cm rgba(0, 0, 0, 0.5);
}

page[size="A4"] {
	width: 21cm;
	height: 29.7cm;
}

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
.container{
    margin: 0;
    padding: 0;
  	height : 1020px;
  }
body {
	font: normal 16px Times, "Times New Roman", Georgia, serif !important;
	height : 100%;
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
	border: 1px solid #c3c3c3;
	padding: 5px;
}

.boder-table {
	border: 1px solid #c3c3c3;
	padding: 3px;
	text-align: left;
}

.td-qualif {
	width: 35%;
	font-size: 14px;
	height: 560px; 
 	overflow: auto;
}

.td-action {
	width: 11%;
}

.td-classe {
	width: 15%;
	font-size: 14px;
	text-align: center;
	height: 560px; 
 	overflow: auto;
}

.td-secteur {
 	height: 560px; 
 	overflow: auto;
 	width: 50%;
	font-size: 14px;
}

.txt-weight {
	font-weight: bold;
}
.tdBorder {
  height: 30px;
}
</style>
</head>
<body>
	<div class="template_top_header">
		<table width="100%">
			<tr>
				<td width="30%">
					<dir style="font-size: 12px;">
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
			<tr>
				<td width="30%"></td>
				<td width="40%"></td>
				<td width="30%">
					<dir style="font-size: 16px; padding-top: 10%;">
						<p>LE PRESIDENT DE LA COMMUNE DE MARRAKECH</p>
						<p>A</p>
						<p>MONSIEUR LE TRESORIER PREFECTORAL DE  MARRAKECH</p>
					</dir>
				</td>
			</tr>
		</table>
		<br />
		<br />
		<div class="template_header">
			<h1 class="titreAR"
				style="text-decoration: underline; font-family: 'Times New Roman', Times, serif !important;">BORDEREAU D’ENVOI</h1>
		</div>
		<br />
		<table class="table" width="100%">
			<thead
				style="background-color: #ececec; border-top: 1px solid #686969;">
				<tr>
					<td class="table-header">Désignation des pièces</td>
					<td class="table-header">Nombre des pièces</td>
					<td class="table-header">Observations</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="boder-table td-secteur" style="text-align:left;vertical-align:top;padding:0;padding-top:10px"><span class="txt-weight">Dossier d’appel d’offre : </span>
					<ul class="list-group">
                            <li style=" display: flex;"> Cahier des charges</li>
							<li style=" display: flex;"> Règlement de consultation </li>
							<li style=" display: flex;"> Avis arabe</li>
							<li style=" display: flex;"> Avis français</li>
							<li style=" display: flex;"> Modèle déclaration sur l’honneur et acte d’engagement  relatif à l’appel d’offres ouvert n°<b>${detail.numAo}</b> . pour :</li>
                        </ul>
						<br /><br />
						<p>&nbsp; - <b>${detail.objet}</b>. </p>
						<br /><br />
					</td>
					<td class="boder-table td-classe"><b>1</b></td>
					<td class="boder-table td-qualif" style="text-align:left;vertical-align:top;padding:0;padding-top:10px">
					<p>« Pour Consultation et Appréciation dans <b>un délai de 8 jours dès réception</b> du dossier »</p>
					<br />
					<h4 style="padding-top: 318px">LE PRESIDENT DE LA COMMUNE DE MARRAKECH</h4>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br />
</body>
</html>