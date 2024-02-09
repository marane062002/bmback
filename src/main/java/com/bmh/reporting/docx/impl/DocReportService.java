package com.bmh.reporting.docx.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.docx4j.TraversalUtil;
import org.docx4j.TraversalUtil.CallbackImpl;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.CommentsPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Body;
import org.docx4j.wml.CommentRangeEnd;
import org.docx4j.wml.CommentRangeStart;
import org.docx4j.wml.Comments;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.R.CommentReference;
import org.jvnet.jaxb2_commons.ppp.Child;
import org.springframework.stereotype.Service;
import org.wickedsource.docxstamper.api.coordinates.ParagraphCoordinates;
import org.wickedsource.docxstamper.api.coordinates.TableRowCoordinates;
import org.wickedsource.docxstamper.util.walk.BaseCoordinatesWalker;
import org.wickedsource.docxstamper.util.walk.CoordinatesWalker;

import com.bmh.reporting.context.ReportContext;
import com.bmh.reporting.docx.IDocReportService;

@Service
public class DocReportService extends AbstracDocx4j implements IDocReportService {
 
 


	public OutputStream generateDoc(String reportName, Map<String, Object> values) throws IOException, Docx4JException {

		ReportContext context = new ReportContext();
		context.setValues(values); 
		InputStream template = getClass().getResourceAsStream("/templates/"+reportName); 
		WordprocessingMLPackage document = stampAndLoad(template, context);
		OutputStream reslt = getOutputDocument(document);

		try {
			removeCommentsFromDoc(reslt,document);
		} catch (Exception e) {
			e.printStackTrace();
		}
		saveAndLoadDocument(document);
		return reslt;
	}

	public OutputStream generateDocWithTable(String reportName, ReportContext values) throws Docx4JException, IOException {
		InputStream template = getClass().getResourceAsStream("/templates/"+reportName); 
		WordprocessingMLPackage document = stampAndLoad(template, values);
		final List<TableRowCoordinates> rowCoordinates = getTableRowCoordinats(document);
		OutputStream reslt = getOutputDocument(document);
		
		try {
			removeCommentsFromDoc(reslt,document);
		} catch (Exception e) {
			e.printStackTrace();
		}
		saveAndLoadDocument(document);
		return reslt;
	}

	
	private List<TableRowCoordinates> getTableRowCoordinats(WordprocessingMLPackage document) {
		final List<TableRowCoordinates> resultList = new ArrayList<>();
		CoordinatesWalker walker = new BaseCoordinatesWalker(document) {
			@Override
			protected void onTableRow(TableRowCoordinates tableRowCoordinates) {
				resultList.add(tableRowCoordinates);
			}
		};
		walker.walk();
		return resultList;
	}

	private List<ParagraphCoordinates> getParagraphCoordinats(WordprocessingMLPackage document) {
		final List<ParagraphCoordinates> titleCoords = new ArrayList<>();
		CoordinatesWalker walker = new BaseCoordinatesWalker(document) {
			@Override
			protected void onParagraph(ParagraphCoordinates paragraphCoordinates) {
				titleCoords.add(paragraphCoordinates);

			}
		};
		walker.walk();
		return titleCoords;
	}

	public void generateDocAndPrint() {
	}

	 

	 

	 

	/**
	 * comments were supposed to be removed after stamper finishes with repeat
	 * operations, but it doesn't so i had to use this
	 */
	public void removeCommentsFromDoc(OutputStream outputStream,WordprocessingMLPackage document) throws Exception {
		if(document !=null && document.getMainDocumentPart()!=null) {
			CommentsPart cmtsPart = document.getMainDocumentPart().getCommentsPart();
			if(cmtsPart!=null) {
				org.docx4j.wml.Comments cmts = cmtsPart.getJaxbElement();
				if(cmts!=null) {
					List<Comments.Comment> coms = cmts.getComment();
					coms.clear();
				}
			}
		}
		
//		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
//
//		org.docx4j.wml.Document wmlDocumentEl = (org.docx4j.wml.Document) documentPart.getJaxbElement();
//		Body body = wmlDocumentEl.getBody();
//
//		CommentFinder cf = new CommentFinder();
//		new TraversalUtil(body, cf);
//
//		for (Child commentElement : cf.commentElements) {
//			System.out.println(commentElement.getClass().getName());
//			Object parent = commentElement.getParent();
//			List<Object> theList = ((ContentAccessor) parent).getContent();
//			boolean removeResult = remove(theList, commentElement);
//			System.out.println(removeResult);
//		}
//		Docx4J.save(wordMLPackage,outputStream, 0);
	}
	public void removeCommentsFromDoc(InputStream inputStream,WordprocessingMLPackage document) throws Exception {

		WordprocessingMLPackage wordMLPackage = document;
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

		org.docx4j.wml.Document wmlDocumentEl = (org.docx4j.wml.Document) documentPart.getJaxbElement();
		Body body = wmlDocumentEl.getBody();

		CommentFinder cf = new CommentFinder();
		new TraversalUtil(body, cf);

		for (Child commentElement : cf.commentElements) {
			System.out.println(commentElement.getClass().getName());
			Object parent = commentElement.getParent();
			List<Object> theList = ((ContentAccessor) parent).getContent();
			boolean removeResult = remove(theList, commentElement);
			System.out.println(removeResult);
		}
		
//		Docx4J.save(wordMLPackage,inputStream, 0);
	}

	private boolean remove(List<Object> theList, Object bm) {
		// Can't just remove the object from the parent,
		// since in the parent, it may be wrapped in a JAXBElement
		for (Object ox : theList) {
			if (XmlUtils.unwrap(ox).equals(bm)) {
				return theList.remove(ox);
			}
		}
		return false;
	}

	public class CommentFinder extends CallbackImpl {

		List<Child> commentElements = new ArrayList<Child>();

		@Override
		public List<Object> apply(Object o) {

			if (o instanceof javax.xml.bind.JAXBElement
					&& (((JAXBElement) o).getName().getLocalPart().equals("commentReference")
							|| ((JAXBElement) o).getName().getLocalPart().equals("commentRangeStart")
							|| ((JAXBElement) o).getName().getLocalPart().equals("commentRangeEnd"))) {
				System.out.println(((JAXBElement) o).getName().getLocalPart());
				commentElements.add((Child) XmlUtils.unwrap(o));
			} else if (o instanceof CommentReference || o instanceof CommentRangeStart
					|| o instanceof CommentRangeEnd) {
				System.out.println(o.getClass().getName());
				commentElements.add((Child) o);
			}
			return null;
		}

		@Override // to setParent
		public void walkJAXBElements(Object parent) {

			List children = getChildren(parent);
			if (children != null) {

				for (Object o : children) {

					if (o instanceof javax.xml.bind.JAXBElement
							&& (((JAXBElement) o).getName().getLocalPart().equals("commentReference")
									|| ((JAXBElement) o).getName().getLocalPart().equals("commentRangeStart")
									|| ((JAXBElement) o).getName().getLocalPart().equals("commentRangeEnd"))) {

						((Child) ((JAXBElement) o).getValue()).setParent(XmlUtils.unwrap(parent));
					} else {
						o = XmlUtils.unwrap(o);
						if (o instanceof Child) {
							((Child) o).setParent(XmlUtils.unwrap(parent));
						}
					}

					this.apply(o);

					if (this.shouldTraverse(o)) {
						walkJAXBElements(o);
					}
				}
			}
		}
	}

}
