package com.bmh.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "microservice-personnel")
public interface PersonnelProxy {

	@GetMapping(value = "${personnels.show.url}")
	com.bmh.beans.PersonnelBean getPersonnelById(@PathVariable("id") long id);
}
