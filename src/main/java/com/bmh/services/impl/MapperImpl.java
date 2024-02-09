package com.bmh.services.impl;

import com.bmh.services.Mapper;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperImpl implements Mapper {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public <T> T map(Object source, Class<T> targetClass) {
		return modelMapper.map(source, targetClass);
	}

	@Override
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source
			.stream()
			.map(element -> modelMapper.map(element, targetClass))
			.collect(Collectors.toList());
	}

	@Override
	public <S, T> Set<T> mapSet(Set<S> source, Class<T> targetClass) {
		return source
			.stream()
			.map(element -> modelMapper.map(element, targetClass))
			.collect(Collectors.toSet());
	}

	@Override
	public <S, T> Page<T> mapPageToOther(Page<S> sourceClassPage, Class<T> targetClass) {
		return sourceClassPage.map(i -> modelMapper.map(i, targetClass));
	}
}
