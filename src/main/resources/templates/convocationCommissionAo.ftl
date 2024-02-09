<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head dir="rtl" lang="ar">
<meta http-equiv="content-type" content="text/html;charset=utf-8"></meta>
<meta charset="UTF-8" />
<title>Convocation commission Ao</title>
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
	direction: rtl !important
}

html, body, h1, h2, h3, h4, p, img {
	margin: 0;
}

html {
	font-size: 13px !important;
	color: #000 !important;
	font-family: Times, "Times New Roman", Georgia, serif !important;
	direction: rtl !important;
	margin: 20px !important;
	padding: 20px !important;
}

body {
	font: normal 16px Times, "Times New Roman", Georgia, serif !important;
	direction: rtl !important
}

.marge_page {
	margin: 20px !important;
	padding: 20px !important;
}

.font-report {
	font-family: Times, "Times New Roman", Georgia, serif !important;
	font-size: 1.5em !important;
}

.font-reportAR {
	font-family: Times, "Times New Roman", Georgia, serif !important;
	font-size: 18px !important;
	direction: rtl !important;
	line-height: 200%;
}

h3.titreAR {
	font-family: 'Andalus', Times, serif !important;
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
hr.style1{
	border-top: 1px solid #8c8b8b;
	text-align: center;
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
								src="http://marrakech.jamaati.hvc.ma:8080/jamaati/assets/media/logos/logo-mini-md.png"
								style="width: 40%;" />
						</div>
					</td>
					<td width="30%"
						style="position: relative; bottom: 0;">
						<p style="position: absolute; bottom: 0;">مراكش
							في: <b>${_dateConvocation?string["yyyy/MM/dd"]}</b></p>
					</td>
				</tr>
			</table>
			<hr class="style1" />
		</div>
		<div class="template_header">
			<h3 class="titreAR"
				style="text-decoration: underline; font-family: 'Times New Roman', Times, serif !important;">رئيـــس
				جماعــة مراكـش</h3>
			<h3 >إلــــــــــى</h3>
			<h3>السيد (ة) ${_participant}</h3>
		</div>
		<br />
		<p class="titreAR"
			style="font-family: 'Times New Roman', Times, serif !important;">
			<b style="text-decoration: underline;">الموضــــــوع :</b>اجتماع لجنة
			فتح الأغلفة
		</p>
		<br />

		<div class="template_header">
			<h3>ســــلام تام بوجود مولانا الإمام.</h3>
		</div>
		<br />
		<p class="titreAR"
			style="font-family: 'Times New Roman', Times, serif !important;">
			<b>و بـــــــعد،</b>
		</p>

		<p class="font-reportAR">يشرفني أن ألتمس منكم التفضل لحضور أشغال
			لجنة فتح الاغلفة أو ايفاد من يمثلكم يوم <b>${detail.dateOuverturePlis?string["yyyy/MM/dd"]}</b> على
			الساعة <b>${detail.dateOuverturePlis?string["HH:mm"]}</b>، بقاعة الاجتماعات لجماعة مراكش بشارع محمد
			السادس وذلك لفتح طلب العروض رقم <b>&nbsp;${detail.numAo}</b>
			والمتعلق ب :</p>
		<ul>
			<li style="font-size: 20px !important;"><span
				style="font-weight: 600;"><b>&nbsp;${detail.objetAR}</b></span></li>
		</ul>

		<div class="template_header">
			<h3>وتقـبلـــوا فــائــق التـقديــــر و الاحتـرام</h3>
		</div>
		<br />
		<br />
		<div style="text-align: center; font-weight: 600;">
			<span style="text-align: center;">
				<p>رئيـــس جماعــة مراكـش</p> <br />
			</span>
		</div>
	</div>
</body>
</html>