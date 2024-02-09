package com.bmh.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import java.net.MalformedURLException;


public class HeaderFooterPageEvent extends PdfPageEventHelper {
	
	private PdfTemplate t;
	private Image total;

	public void onOpenDocument(PdfWriter writer, Document document) {
		t = writer.getDirectContent().createTemplate(40, 26);
		try {
			total = Image.getInstance(t);
			total.setRole(PdfName.ARTIFACT);
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		//addHeader(writer);
		//addFooter(writer);
	}

	private void addHeader(PdfWriter writer) {
		PdfPTable header = new PdfPTable(2);
		try {
			// set defaults
			header.setWidths(new int[] { 2, 24 });
			header.setTotalWidth(527);
			//header.setLockedWidth(true);
			//header.getDefaultCell().setFixedHeight(40);
			header.getDefaultCell().setBorder(0);
			//header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

			// add image
			Image logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/templates/logo.png"));
			if (logo.getScaledWidth() > 70 || logo.getScaledHeight() > 70) {
				logo.scaleToFit(50, 50);
	        }
			header.addCell(logo);
			
			PdfPTable imageAndHeaderTable = new PdfPTable(1);
	        PdfPCell header1Cell = new PdfPCell(new Paragraph("Example iText PDF With Logo, Array and Individual Cells"));
	        header1Cell.setBorder(0);
	        header1Cell.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
	        imageAndHeaderTable.addCell(header1Cell);
			
			// add text
			PdfPCell text = new PdfPCell();
			text.setPaddingBottom(15);
			text.setPaddingLeft(10);
			text.setBorder(0);
			text.setBorderColor(BaseColor.LIGHT_GRAY);
			text.addElement(new Phrase("ROYAUME DU MAROC", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD)));
			text.addElement(new Phrase("MINISTERE DE L’INTERIEUR", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD)));
			text.addElement(new Phrase("WILAYA REGION MARRAKECH SAFI", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD)));
			text.addElement(new Phrase("ET PREFECTURE DE MARRAKECH", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD)));
			text.addElement(new Phrase("COMMUNE DE MARRAKECH", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD)));
			text.addElement(new Phrase("DIRECTION GENERALE DES SERVICES", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD)));
			text.addElement(new Phrase("DIVISION DES MARCHES", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD)));
			text.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			header.addCell(text);

			// write content
			header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		} catch (MalformedURLException e) {
			throw new ExceptionConverter(e);
		} catch (IOException e) {
			throw new ExceptionConverter(e);
		}
	}

	private void addFooter(PdfWriter writer) {
		PdfPTable footer = new PdfPTable(3);
		try {
			// set defaults
			footer.setWidths(new int[] { 24, 2, 1 });
			footer.setTotalWidth(527);
			footer.setLockedWidth(false);
			footer.getDefaultCell().setFixedHeight(40);
			footer.getDefaultCell().setBorder(Rectangle.TOP);
			footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

			// add copyright
			footer.addCell(new Phrase("\u00A9 Commune Marrakech", new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD)));

			// add current page count
			footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			footer.addCell(new Phrase(String.format("page %d |", writer.getPageNumber()),
					new Font(Font.FontFamily.HELVETICA, 8)));

			// add placeholder for total page count
			PdfPCell totalPageCount = new PdfPCell(total);
			totalPageCount.setBorder(Rectangle.TOP);
			totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
			footer.addCell(totalPageCount);

			// write page
			PdfContentByte canvas = writer.getDirectContent();
			canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
			footer.writeSelectedRows(0, -1, 34, 50, canvas);
			canvas.endMarkedContentSequence();
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	public void onCloseDocument(PdfWriter writer, Document document) {
		int totalLength = String.valueOf(writer.getPageNumber()).length();
		int totalWidth = totalLength * 5;
		ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
				new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)), totalWidth,
				6, 0);
	}
}
