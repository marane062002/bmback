package com.bmh.reporting.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportContext {

	private Map<String, Object> values = new HashMap<>();
	private List<IContext> rows = new ArrayList<>();

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	public List<IContext> getRows() {
		return rows;
	}

	public void setRows(List<IContext> rows) {
		this.rows = rows;
	}

	 
}
