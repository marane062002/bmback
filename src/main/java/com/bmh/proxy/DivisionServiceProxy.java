package com.bmh.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "microservice-organisation")
public interface DivisionServiceProxy {

	@GetMapping(value = "${division.show.url}")
	com.bmh.beans.DivisionBean getDivisionById(@PathVariable("id") long id);
	
}
