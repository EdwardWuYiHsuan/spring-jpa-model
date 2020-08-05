package spring.jpa.model.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import spring.jpa.model.entity.PhoneEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder  // Create Builder with Inheritance, Way-2
@Entity
@Table(name = "account")
public class Account extends PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
	@SequenceGenerator(sequenceName = "seq_account", allocationSize = 1, name = "account_generator")
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	private Character sex;
	
//	@Builder   // Create Builder with Inheritance, Way-1
//	public Account(Long id, String name, Character sex, String phone) {
//		super(phone);
//		this.id = id;
//		this.name = name;
//		this.sex = sex;
//	}

}
