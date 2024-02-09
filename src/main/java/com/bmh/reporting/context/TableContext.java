package com.bmh.reporting.context;

import java.util.HashSet;
import java.util.Set;

public class TableContext {
	Set<IContext> values = new HashSet();

	public Set<IContext> getValues() {
		return values;
	}

	public void setValues(Set<IContext> values) {
		this.values = values;
	}

	
	
}
