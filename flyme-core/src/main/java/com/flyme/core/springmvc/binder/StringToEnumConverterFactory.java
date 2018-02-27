package com.flyme.core.springmvc.binder;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

@SuppressWarnings("rawtypes")
final class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

	public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToEnum<T>(targetType);
	}

	private class StringToEnum<T extends Enum> implements Converter<String, T> {

		private final Class<T> enumType;

		public StringToEnum(Class<T> enumType) {
			this.enumType = enumType;
		}

		@SuppressWarnings("unchecked")
		public T convert(String source) {
			if (source.length() == 0) {
				return null;
			}
			return (T) Enum.valueOf(this.enumType, source.trim());
		}
	}

}