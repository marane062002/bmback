package com.bmh.beans;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class TypeCriteria  {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String libelle;
	private String description;



	/*public void createCriteria(TypeCriteria other) {
		this.id = other.id == null ? null : other.id.copy();
		this.libelle=other.libelle==null?null:other.libelle.copy();
		this.description=other.description==null?null:other.description.copy();
	}*/


//	@Override
//	public Criteria copy() {
//		return null;
//	}
}
