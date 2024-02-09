<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="fr">
<meta http-equiv="content-type" content="text/html;charset=utf-8"></meta>
<meta charset="UTF-8" />
<title>Avis FR</title>
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
}

.td-qualif {
	width: 47%;
	font-size: 14px;
}

.td-action {
	width: 11%;
}

.td-classe {
	width: 15%;
	font-size: 14px;
}

.td-secteur {
	width: 26%;
	font-size: 14px;
}

.txt-weight {
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
								src="http://sicm-tr1.optimgov.com/jamaati/assets/media/logos/logo-mini-md.png"
								style="width: 40%;" />
						</div>
					</td>
					<td width="30%"></td>
				</tr>
			</table>
		</div>
		<div class="template_header">
			<h3 class="titreAR"
				style="text-decoration: underline; font-family: 'Times New Roman', Times, serif !important;">AVIS
				D’APPEL D’OFFRES OUVERT</h3>
			<h3>N° : ${detail.numAo}</h3>
			<p>(Séance Publique)</p>
			<p style="color: red;"><#if detail.typeAO != "Autre">RESERVE AU
				PME</#if></p>
			
		</div>
		<br />
		<p class="font-reportAR">
			<b>Le</b>&nbsp;<#if detail.dateOuverturePlis??>${detail.dateOuverturePlis?string["dd/MM/yyyy"]}<#else>...</#if>&nbsp;<b>à</b>&nbsp;<#if detail.dateOuverturePlis??>${detail.dateOuverturePlis?string["HH:mm"]}<#else>...</#if>&nbsp;,
			il sera procédé dans le bureau de Monsieur le Président de la Commune
			de Marrakech sise à <b>l’annexe AV Mohamed VI– Marrakech</b>, à
			l’ouverture des plis relatifs à l’appel d’offres sur offre de prix
			pour :
		</p>
		<p class="font-reportAR" style="font-weight: 600; font-size: 18px;">&nbsp;-&nbsp;
			${detail.objet}.</p>
		<p>
			Le dossier d’appels d’offres peut être retiré du bureau de la
			division des marchés de la Commune de Marrakech, <b>l’annexe AV
				Mohamed VI– Marrakech</b>, il peut également être téléchargés à partir
			du portail des marchés publics : <a
				href="http:// www.marchéspublics.gov.ma." target="_blank"
				rel="noopener noreferrer"> www.marchéspublics.gov.ma.</a>
		</p>
		<!-- Start::budget & caution -->
		<#if detail.caution != 0>
		<p class="font-reportAR">
			Le cautionnement provisoire est fixe à la somme de : <b>${detail.cautionLettreFr}.&nbsp;${_caution}&nbsp;Dhs</b>
		</p>
		<p class="font-reportAR">
			L’Estimation des coûts des prestations établie par le maître
			d’ouvrage est fixée à la somme de : <b>${detail.mtnLettre}.&nbsp;${_budget}&nbsp;Dhs
				( T.T.C)</b>
		</p>
		</#if>
		<!-- End::budget & caution -->

		<!-- Start::Gestion des lots -->
		<#list _lotslist>
		<ul>
			<#items as lot>
			<li><span style="font-weight: 600;">Lot </span> <span
				style="font-weight: 600;">${lot.numLot}</span> <span
				style="font-weight: 600;">:</span> <span style="font-weight: 600;">${ lot.objetFr}</span>
				<br /> <span>Le cautionnement provisoire est fixe à la somme
					de : </span> <span style="font-weight: 600; text-align: left;">${ lot.cautionFr}&nbsp;
					(${lot.cautionFormatter} Dhs)</span> <br /> <span>L’Estimation des
					coûts des prestations établie par le maître d’ouvrage est fixée à
					la somme de :</span> <span style="font-weight: 600; text-align: left;">${ lot.mtnLettre}&nbsp;
					(${lot.budgetFormatter}) T.T.C</span></li> </#items>
		</ul>
		</#list>
		<!-- End::Gestion des lots -->

		<p>Le contenu, la présentation ainsi que le dépôt des dossiers des
			concurrents doivent être conformes aux dispositions des articles 27,
			29 et 31 du décret n°2-12-349 relatif aux marchés publics.</p>
		&nbsp;&nbsp;
		<p
			style="text-decoration: underline; font-style: oblique; text-transform: uppercase;">Les
			concurrents peuvent :</p>
		<ul>
			<li>Soit envoyer, par courrier électronique au portail des
				marchés publics : <a href="http:// www.marchéspublics.gov.ma."
				target="_blank" rel="noopener noreferrer">
					www.marchéspublics.gov.ma.</a>
			</li>
			<li>Soit envoyer, par courrier recommandé avec accusé de
				réception, au bureau précité ;</li>
			<li>Soit déposer contre récépissé leurs plis dans le bureau de
				la Division des marchés de la Commune de Marrakech, annexe AV
				Mohamed VI – Marrakech.</li>
			<li>Soit les remettre au Président de la commission d’appel
				d’offres au début de la séance et avant l’ouverture des plis.</li>
			<li>Pour les entreprises installées au Maroc produire la copie
				certifiée conforme à l’original du certificat de qualification et de
				classification.</li>
		</ul>
		<br />
		<!-- start::table-secteur -->
		<#list _secteursList>
		<table class="table" width="100%">
			<thead
				style="background-color: #ececec; border-top: 1px solid #686969;">
				<tr>
					<td class="table-header">Secteur</td>
					<td class="table-header">Classe minimale</td>
					<td class="table-header">Qualification exigé</td>
				</tr>
			</thead>
			<tbody>
				<#items as secteur>
				<tr>
					<td class="boder-table td-secteur"><span class="txt-weight">${secteur.secteur.code}
							: </span>${secteur.secteur.libelle}</td>
					<td class="boder-table td-classe">${secteur.classe.libelle}</td>
					<td class="boder-table td-qualif"><#list
						secteur.qualifications>
						<ul class="list-group">
							<#items as row>
							<li style="display: flex;"><span class="txt-weight">${row.code}:</span>&nbsp;${row.libelle}
							</li> </#items>
						</ul> </#list>
					</td>
				</tr>
				</#items>
			</tbody>
		</table>
		</#list> <br />
		<!-- end::table-secteur -->
		<br />
		<ul>
			<li>Pour les entreprises non installés au Maroc doivent fournir
				le dossier technique tel que prévu par le règlement de la
				consultation.</li>
		</ul>
		<#if _echantillion??>
		<!--start::ecantillons -->
		<p>Les échantillons exigés des articles <b>(${_echantillion.libelle})</b> par le
			dossier d’appel d’offres doivent (......) Marrakech le
			<b><#if _echantillion.echantillon.dateExamen??>${_echantillion.echantillon.dateExamen?string["dd/MM/yyyy"]}<#else>...</#if></b> à <b><#if _echantillion.echantillon.dateExamen??>${_echantillion.echantillon.dateExamen?string["HH:mm"]}<#else>...</#if></b></p>
		<!--end::ecantillons -->
		</#if>
		<#if _visite??>
		<!--start::visites -->
		<p>une visite des lieux et Prévu le <b><#if _visite.dateVisite??>${_visite.dateVisite?string["dd/MM/yyyy"]}<#else>...</#if></b> à <b><#if _visite.dateVisite??>${_visite.dateVisite?string["HH:mm"]}<#else>...</#if></b> et
			le départ sera de la division <b>${_visiteDivision}</b></p>
		<!--end::visites -->
		</#if>
		<p>
			Les pièces justificatives à fournir sont celles prévues par <b>l’article
				${detail.codeArticle}</b> du règlement de la consultation.
		</p>
		<br />
		<div
			style="text-align: center; font-weight: 600; text-decoration: underline;">
			<span style="text-align: center;">
				<p>Marrakech,</p> <br />
				<p>Le Président de la Commune</p> <br />
				<p>De Marrakech</p> <br />
			</span>
		</div>
	</div>
</body>
</html>