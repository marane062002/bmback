package com.bmh.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
/**
 * Created by RS on 07.04.2021
 */
public class FreemarkerUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerUtils.class);
	
	/**
     * @param baseDir Root directory
     * @param fileName file name
     * @param globalMap Data binding containing properties that feeds the ftl
     * @return html String HTML
     */
    public static String loadFtlHtml(File baseDir, String fileName,Map globalMap){
    	if(baseDir == null || !baseDir.isDirectory() || globalMap ==null || fileName == null || "".equals(fileName)){
            throw new IllegalArgumentException("Directory file");
        }
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        try {
            cfg.setDirectoryForTemplateLoading(baseDir);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);//.RETHROW
            cfg.setClassicCompatible(true);
            Template temp = cfg.getTemplate(fileName);

            StringWriter stringWriter = new StringWriter();
            temp.process(globalMap, stringWriter);
            LOGGER.info("Success !!");
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            LOGGER.error("Failler !!" + e.getStackTrace());
            throw new RuntimeException("load fail file");
        }
    }
}
