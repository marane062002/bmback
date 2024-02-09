<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="fr">
<meta http-equiv="content-type" content="text/html;charset=utf-8"></meta>
<meta charset="UTF-8" />
<title>Lettre de maintien</title>
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
    padding: 10px;
    font-size: 16px;
    font-family: Arial, Helvetica, sans-serif !important;
}

.template_header {
	text-align: left;
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
					<dir style="font-size: 16px; padding-top: 10%; text-align: center;">
						<p>LE PRESIDENT DE LA COMMUNE DE MARRAKECH</p>
						<p>A</p>
						<p>MONSIEUR LE DIRECTEUR STE &nbsp;<b>${_destinataire}</b></p>
					</dir>
				</td>
			</tr>
		</table>
		<br />
		<br />
		<div class="template_header">
			<p><b style="font-size:18px; text-decoration: underline; font-family: 'Times New Roman', Times, serif !important; font-style: italic;">OBJET:</b> <b>${detail.objet}.</b> </p>
			<p><b style="font-size:18px; text-decoration: underline; font-family: 'Times New Roman', Times, serif !important; font-style: italic;">REF:</b> Marché après appel d’offres ouvert n° <b>${detail.numAo}</b>.</p>
		</div>
		<br /><br /><br /><br />
		<p style="padding: 20px;text-indent: 30px;">Conformément aux articles  153 du décret n° 2-12-349 du 20/03/2013 , J’ai l’honneur de vous faire savoir que le délai d’approbation de 75 (Soixante Quinze ) jours, risque d’être terminé .</p>
		<p style="padding: 20px;text-indent: 30px;">Sur ce je vous prie de bien vouloir nous confirmer le maintien de votre offre pour <b>une durée bien déterminée</b> ou <b>jusqu’à la notification d’approbation.</b></p>
		<br /><br /><br /><br />
		<p style="text-align: center;">LE PRESIDENT  DE LA COMMUNE DE MARRAKECH</p>
	</div>
	<br />
</body>
</html>