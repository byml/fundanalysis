package net.byml.fund.md.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fund")
@NamedQueries(value = {
		@NamedQuery(name = "fund.findByIdList", query = "from Fund where id in (:id)"),
		@NamedQuery(name = "fund.findByCodeList", query = "from Fund where code in (:code)") })
public class Fund implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -765883565260349635L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fund_id")
	private Long id;
	private String code;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "short_name")
	private String shortName;
	@ManyToOne
	@JoinColumn(name = "fund_type_id")
	private FundType fundType;

	@Column(name = "is_closed")
	private Boolean closed;
	@Column(name = "is_yield_agreed")
	private Boolean yieldAgreed;
	@Column(name = "is_floor_trade")
	private Boolean floorTrade;

}
