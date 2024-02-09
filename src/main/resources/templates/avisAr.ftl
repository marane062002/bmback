<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head dir="rtl" lang="ar">
<meta http-equiv="content-type" content="text/html;charset=utf-8"></meta>
<meta charset="UTF-8" />
<title>Avis AR</title>
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
	font-family: "Times New Roman";
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
	direction: rtl !important
}

html, body, h1, h2, h3, h4, p, img {
	margin: 0;
}

html {
	font-size: 13px !important;
	color: #000 !important;
	font-family: "Times New Roman";
	direction: rtl !important
}

body {
	font-family: "Times New Roman";
	direction: rtl !important
}

.marge_page {
	margin-top: 10px !important;
	margin-bottom: 40px !important;
}

.font-report {
	font-family: "Times New Roman";
	font-size: 1.5em !important;
}

.font-reportAR {
	font-family: "Times New Roman";
	font-size: 18px !important;
	direction: rtl !important
}

h3.titreAR {
	font-family: "Times New Roman";
	text-decoration: underline;
	font-size: 25px;
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
	direction: rtl;
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
						<dir style="font-size: 16px;">
							<p>المملكـــــة المغربيـــــة</p>
							<p>ﻭﺯاﺭﺓ اﻟﺪاﺧﻠﻴــــﺔ</p>
							<p>ﻭﻻﻳـﺔ ﺟﻬﺔ ﻣﺮاﻛـﺶ ﺁﺳﻔﻲ</p>
							<p>ﻋﻤﺎﻟﺔ ﻣﺮاﻛﺶ</p>
							<p>ﺟﻤﺎﻋـــﺔ ﻣﺮاﻛــﺶ</p>
							<p>اﻟﻤﺪﻳﺮﻳﺔ اﻟﻌﺎﻣﺔ ﻟﻠﻤﺼﺎﻟﺢ اﻟﺠﻤﺎﻋﻴﺔ</p>
							<p>ﻗﺴﻢ اﻟﻤﻴﺰاﻧﻴﺔ - اﻟﺼﻔﻘـــﺎﺕ –اﻟﻠﻮﺟﻴﺴﺘﻴﻚ</p>
							<p>ﻣﺼﻠﺤﺔ اﻟﺼﻔﻘﺎﺕ</p>
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
				style="text-decoration: underline;">إعـــلان
				عــن طلــب عــروض مفتــوح</h3>
			<h3>ﺭﻗﻢ: ${detail.numAo}</h3>
			<p>(ﺟﻠﺴــﺔ ﻋﻤﻮﻣﻴــﺔ)</p>
			<p style="color: red;"><#if detail.typeAO != "Autre">مخصص للمقاولات الصغرى و المتوسطة ، التعاونيات ، اتحاد التعاونيات و المقاول الذاتي.</#if></p>
			<p style="color: red;">${_typeMarche}</p>
		</div>
		<br />
		<p class="font-reportAR">
			<b>ﻓﻲ</b>&nbsp;<#if detail.dateOuverturePlis??>${detail.dateOuverturePlis?string["yyyy/MM/dd"]}<#else>...</#if>&nbsp;<b>ﻋﻠﻰ
				اﻟﺴﺎﻋﺔ</b>&nbsp;<#if detail.dateOuverturePlis??>${detail.dateOuverturePlis?string["HH:mm"]}<#else>...</#if>, ﺳﻴﺘﻢ ﻓﻲ
			ﻣﻜﺘﺐ اﻟﺴﻴﺪ ﺭﺋﻴﺲ ﺟﻤﺎﻋﺔ ﻣﺮاﻛﺶ <b>ﺑﺸﺎﺭﻉ ﻣﺤﻤﺪ اﻟﺴﺎﺩﺱ ﺑﻤﺮاﻛﺶ</b>, ﻓﺘﺢ
			اﻷﻇﺮﻓﺔ اﻟﻤﺘﻌﻠﻘﺔ ﺑﻄﻠﺐ اﻟﻌﺮﻭﺽ ﺑﻌﺮﻭﺽ ﺃﺛﻤﺎﻥ ﻷﺟﻞ :
		</p>
		<p class="font-reportAR" style="font-weight: 600; font-size: 18px;">-
			${detail.objetAR}.</p>
		<p class="font-reportAR">
			ﻳﻤﻜﻦ ﺳﺤﺐ ﻣﻠﻒ ﻃﻠﺐ اﻟﻌﺮﻭﺽ ﺑﻤﻜﺘﺐ ﻗﺴﻢ اﻟﺼﻔﻘﺎﺕ ﺑﺠﻤﺎﻋﺔ ﻣﺮاﻛﺶ <b>ﻣﻠﺤﻘﺔ
				ﺷﺎﺭﻉ ﻣﺤﻤﺪ اﻟﺴﺎﺩﺱ - ﻣﺮاﻛﺶ</b>, ﻭﻳﻤﻜﻦ ﻛﺬﻟﻚ ﺗﺤﻤﻴﻠﻪ ﺇﻟﻜﺘﺮﻭﻧﻴﺎ ﻣﻦ ﺑﻮاﺑﺔ
			اﻟﺼﻔﻘﺎﺕ اﻟﻌﻤﻮﻣﻴﺔ <a href="http:// www.marchéspublics.gov.ma."
				target="_blank" rel="noopener noreferrer">
				www.marchéspublics.gov.ma.</a>
		</p>
		<!-- Start::budget & caution -->
		<#if detail.caution != 0>
		<p class="font-reportAR">
			حدد مبلغ الضمان المؤقتة في : <b>${detail.cautionLettreAr}.&nbsp;${_caution}&nbsp;د.م</b>
		</p>
		<p class="font-reportAR">
			كلفة تقدير الأعمال محددة من طرف صاحب المشروع في مبلغ: <b>${detail.mtnLettreAr}.&nbsp;${_budget}&nbsp;د.م
				( مع احتساب الرسوم)</b>
		</p>
		</#if>
		<!-- End::budget & caution -->

		<!-- Start::Gestion des lots -->
		<#list _lotslist>
		<ul>
			<#items as lot>
			<li style="font-size: 20px !important;"><span
				style="font-weight: 600;">الحصة رقم </span> <span
				style="font-weight: 600;">${lot.numLot}</span> <span
				style="font-weight: 600;">:</span> <span style="font-weight: 600;">${ lot.objetAr}</span>
				<br /> <span>حدد مبلغ الضمان المؤقتة في : </span> <span
				style="font-weight: 600; text-align: left;">${ lot.cautionAr}&nbsp;
					(${lot.cautionFormatter})</span> <br /> <span>كلفة تقدير الأعمال
					محددة من طرف صاحب المشروع في مبلغ: </span> <span
				style="font-weight: 600; text-align: left;">${ lot.mtnLettreAr}&nbsp;
					(${lot.budgetFormatter})</span></li> </#items>
		</ul>
		</#list>
		<!-- End::Gestion des lots -->

		<p class="font-reportAR">ﻳﺠﺐ ﺃﻥ ﻳﻜﻮﻥ ﻛﻞ ﻣﺤﺘﻮﻯ ﻭﺗﻘﺪﻳﻢ ﻭﺇﻳﺪاﻉ ﻣﻠﻔﺎﺕ
			اﻟﻤﺘﻨﺎﻓﺴﻴﻦ ﻣﻄﺎﺑﻖ ﻟﻤﻘﺘﻀﻴﺎﺕ اﻟﻤﻮاﺩ 27 ﻭ29 ﻭ31 ﻣﻦ اﻟﻤﺮﺳﻮﻡ ﺭﻗﻢ 2-12-349
			اﻟﺼﺎﺩﺭ ﻓﻲ 08 ﺟﻤﺎﺩﻯ اﻷﻭﻟﻰ 1434 (20 ﻣﺎﺭﺱ2013) اﻟﻤﺘﻌﻠﻖ ﺑﺎﻟﺼﻔﻘﺎﺕ
			اﻟﻌﻤﻮﻣﻴﺔ.</p>
		&nbsp;
		<p class="font-reportAR" style="text-decoration: underline;">ﻭﻳﻤﻜﻦ
			ﻟﻠﻤﺘﻨﺎﻓﺴﻴﻦ:</p>
		<ul class="font-reportAR">
			<li>ﺇﻣﺎ ﺇﺭﺳﺎﻝ ﺃﻇﺮﻓﺘﻬﻢ ﺑﻄﺮﻳﻘﺔ ﺇﻟﻜﺘﺮﻭﻧﻴﺔ ﻋﺒﺮ ﺑﻮاﺑﺔ اﻟﺼﻔﻘﺎﺕ
				اﻟﻌﻤﻮﻣﻴﺔ <a href="http:// www.marchéspublics.gov.ma."
				target="_blank" rel="noopener noreferrer">
					www.marchéspublics.gov.ma.</a>
			</li>
			<li>ﺇﻣﺎ ﺇﺭﺳﺎﻝ ﺃﻇﺮﻓﺘﻬﻢ ﻋﻦ ﻃﺮﻳﻖ اﻟﺒﺮﻳﺪ اﻟﻤﻀﻤﻮﻥ ﺑﺈﻓﺎﺩﺓ ﺑﺎﻻﺳﺘﻼﻡ ﺇﻟﻰ
				اﻟﻤﻜﺘﺐ اﻟﻤﺬﻛﻮﺭ.</li>
			<li>ﺇﻣﺎ ﺇﻳﺪاﻋﻬﺎ ، ﻣﻘﺎﺑﻞ ﻭﺻﻞ، ﺑﻤﻜﺘﺐ ﻗﺴﻢ اﻟﺼﻔﻘﺎﺕ ﺑﺠﻤﺎﻋﺔ ﻣﺮاﻛﺶ
				ﻣﻠﺤﻘﺔ ﺷﺎﺭﻉ ﻣﺤﻤﺪ اﻟﺴﺎﺩﺱ ﺑﻤﺮاﻛﺶ.</li>
			<li>ﺇﻣﺎ ﺗﺴﻠﻴﻤﻬﺎ ﻣﺒﺎﺷﺮﺓ ﻟﺮﺋﻴﺲ ﻟﺠﻨﺔ ﻃﻠﺐ اﻟﻌﺮﻭﺽ ﻋﻨﺪ ﺑﺪاﻳﺔ اﻟﺠﻠﺴﺔ
				ﻭﻗﺒﻞ ﻓﺘﺢ اﻷﻇﺮﻓﺔ</li>
			<li>ﺑﺎﻟﻨﺴﺒﺔ ﻟﻠﻤﻘﺎﻭﻻﺕ اﻟﻤﻘﻴﻤﺔ ﻓﻲ اﻟﻤﻐﺮﺏ ﻳﺴﺘﻮﺟﺐ ﻋﻠﻴﻬﺎ اﻹﺩﻻء ﺑﻨﺴﺨﺔ
				ﻣﺼﺎﺩﻕ ﻋﻠﻴﻬﺎ ﻣﻦ ﺷﻬﺎﺩﺓ اﻟﺘﺄﻫﻴﻞ ﻭ اﻟﺘﺼﻨﻴﻒ</li>
			<li>ﺑﺎﻟﻨﺴﺒﺔ ﻟﻠﻤﻘﺎﻭﻻﺕ اﻟﻐﻴﺮ اﻟﻤﻘﻴﻤﺔ ﻓﻲ اﻟﻤﻐﺮﺏ ﻳﺘﻌﻴﻦ ﻋﻠﻴﻬﺎ اﻹﺩﻻء
				ﺑﺎﻟﻤﻠﻒ اﻟﺘﻘﻨﻲ ﻛﻤﺎ ﻫﻮ ﻣﺤﺪﺩ ﻓﻲ ﻧﻈﺎﻡ اﻻﺳﺘﺸﺎﺭﺓ</li>
		</ul>
		<br />
		<!-- start::table-secteur -->
		<#list _secteursList>
		<table class="table table-dir" width="100%">
			<thead
				style="background-color: #ececec; border-top: 1px solid #686969;">
				<tr>
					<td class="table-header">القطاع</td>
					<td class="table-header">الترتيب</td>
					<td class="table-header">المواصفات المطلوبة</td>
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
		<#if _echantillion??>
		<!--start::ecantillons -->
		<p class="font-reportAR" style="text-align: right;">
			<b>(${_echantillion.libelle})</b> إن العينات  و النماذج و شهادات المطابقة التي يستوجبها ملف طلب العروض يجب وضعها
		</p>
		<p class="font-reportAR" style="text-align: right;">
			بواسطة ملف طلب العروض يجب (.................) مراكش وذلك يوم  <b><#if _echantillion.echantillon.dateExamen??>${_echantillion.echantillon.dateExamen?string["yyyy/MM/dd"]}<#else>...</#if></b>
			على الساعة <b><#if _echantillion.echantillon.dateExamen??>${_echantillion.echantillon.dateExamen?string["HH:mm"]}<#else>...</#if></b>
		</p>
		<!--end::ecantillons -->
		</#if> <#if _visite??>
		<!--start::visites -->
		<p class="font-reportAR" style="text-align: right;">
			ستكون زيارة الأماكن يوم <b><#if _visite.dateVisite??>${_visite.dateVisite?string["yyyy/MM/dd"]}<#else>...</#if></b>
			على الساعة <b><#if _visite.dateVisite??>${_visite.dateVisite?string["HH:mm"]}<#else>...</#if></b> ستكون الانطلاقة من  <b>${_visiteDivision}</b>
		</p>
		</#if>
		<!--end::visites -->
		<p>
			ﺇﻥ اﻟﻮﺛﺎﺋﻖ اﻟﻤﺜﺒﺘﺔ اﻟﻮاﺟﺐ اﻹﺩﻻء ﺑﻬﺎ ﻫﻲ ﺗﻠﻚ اﻟﻤﻨﺼﻮﺹ ﻋﻠﻴﻬﺎ ﻓﻲ <b>اﻟﻤﺎﺩﺓ
				${detail.codeArticle}</b> ﻣﻦ ﻧﻈﺎﻡ اﻻﺳﺘﺸﺎﺭﺓ
		</p>
		<br />
		<div
			style="text-align: center; font-weight: 600; text-decoration: underline;">
			<span style="text-align: center;">
				 <br />
				<p>ﺭﺋﻴﺲ ﺟﻤﺎﻋـﺔ ﻣﺮاﻛﺶ</p> <br />
				<p>ﻓﻲ ﻣﺮاﻛﺶ</p> <br />
			</span>
		</div>
	</div>
</body>
</html>