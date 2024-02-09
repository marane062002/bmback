package com.bmh.reporting.docx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.docx4j.openpackaging.exceptions.Docx4JException;

import com.bmh.reporting.context.ReportContext;

public interface IDocReportService {
  OutputStream generateDoc(String reportName, Map<String, Object> values) throws FileNotFoundException, IOException, Docx4JException;
  OutputStream generateDocWithTable(String reportName, ReportContext values) throws FileNotFoundException, Docx4JException, IOException;
}
