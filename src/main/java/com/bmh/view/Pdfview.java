package com.bmh.view;

import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.bmh.utils.FreemarkerUtils;

public class Pdfview extends AbstractITextPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		URL fileResource = Pdfview.class.getResource("/templates");
        String html = FreemarkerUtils.loadFtlHtml(new File(fileResource.getFile()), "avisAr.ftl", model);

        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(html));
	}

}
