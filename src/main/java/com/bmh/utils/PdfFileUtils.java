package com.bmh.utils;

import java.io.OutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.bmh.view.HeaderFooterPageEvent;

public class PdfFileUtils {

	 public static void savePdf(Document document,OutputStream out, String html) {
	        //Document document = new Document(PageSize.A4, 50, 50, 60, 60);
	        //Document document = new Document(PageSize.A4, 110, 110, 120, 140);
	        try {
	            PdfWriter writer = PdfWriter.getInstance(document, out);
	            /*writer.setEncryption(null, "AUBB@NR+2021".getBytes(), PdfWriter.ALLOW_PRINTING,
	                    PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);*/
	            HeaderFooterPageEvent event = new HeaderFooterPageEvent();
	            writer.setPageEvent(event);
	            document.open();
	            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(html));
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            document.close();
	        }
	    }
}
