package net.byml.fund.md.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fund_type")
public class FundType {
	@Id
	@GeneratedValue
	@Column(name="fund_type_id")	
	private Long id;
	private String code;
	private String name;		
}
