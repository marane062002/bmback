package com.bmh.services;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface Mapper {
	<T> T map(Object source, Class<T> targetClass);

	<S, T> List<T> mapList(List<S> source, Class<T> targetClass);

	<S, T> Set<T> mapSet(Set<S> source, Class<T> targetClass);

	<S,T> Page<T> mapPageToOther(Page<S> sourceClassPage, Class<T> targetClass);
}
