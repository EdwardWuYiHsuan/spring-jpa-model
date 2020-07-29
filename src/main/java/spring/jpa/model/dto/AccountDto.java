package spring.jpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

	private Long id;
	private String name;
	private Character sex;
	private String phone;

	public static AccountDto valueOf(spring.jpa.model.oracle.entity.Account account)
	{
		return new AccountDto(account.getId(), account.getName(), account.getSex(), account.getPhone());
	}
	
	public static AccountDto valueOf(spring.jpa.model.sql_server.entity.Account account)
	{
		return new AccountDto(account.getId(), account.getName(), account.getSex(), account.getPhone());
	}
}
