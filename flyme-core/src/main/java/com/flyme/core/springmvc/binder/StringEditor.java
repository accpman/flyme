package com.flyme.core.springmvc.binder;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class StringEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text.equals("off")) {
			text = "0";
			setValue(Integer.parseInt(text));
		} else if (text.equals("on")) {
			text = "1";
			setValue(Integer.parseInt(text));
		} else {
			setValue(text);
		}
	}

	@Override
	public String getAsText() {
		return getValue().toString();
	}
}
