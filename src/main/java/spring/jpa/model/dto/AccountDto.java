package spring.jpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.jpa.model.util.ModelTransferUtil;

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
//        return new AccountDto(account.getId(), account.getName(), account.getSex(), account.getPhone()); //way-1
        return ModelTransferUtil.transfer(account, AccountDto.class); // way-2
    }

    public static AccountDto valueOf(spring.jpa.model.sql_server.entity.Account account) 
    {
        return new AccountDto(account.getId(), account.getName(), account.getSex(), account.getPhone());
    }

}
