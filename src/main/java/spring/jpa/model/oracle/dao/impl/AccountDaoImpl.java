package spring.jpa.model.oracle.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import lombok.AllArgsConstructor;
import spring.jpa.model.dao.AccountDao;
import spring.jpa.model.dto.AccountDto;
import spring.jpa.model.oracle.entity.Account;

@Repository
@AllArgsConstructor
public class AccountDaoImpl implements AccountDao {

	private final spring.jpa.model.oracle.repository.AccountRepository accountRepo;

	@Override
	public boolean existsById(Long id)
	{
		return accountRepo.existsById(id);
	}

	@Override
	public List<AccountDto> findAll(Sort sort)
	{
		List<Account> list = accountRepo.findAll(sort);
		return list.stream().map(AccountDto::valueOf).collect(Collectors.toList());
	}

	@Override
	public Optional<AccountDto> findById(Long id)
	{
		Optional<Account> accountOpt = accountRepo.findById(id);
		return accountOpt.map(AccountDto::valueOf);
	}

	@Override
	public AccountDto save(AccountDto accountDto)
	{
		Account account = Account.builder().id(accountDto.getId()).name(accountDto.getName())
				.sex(accountDto.getSex()).phone(accountDto.getPhone()).build();
		return AccountDto.valueOf(accountRepo.save(account));
	}

	@Override
	public void deleteById(Long id)
	{
		accountRepo.deleteById(id);
	}

}
