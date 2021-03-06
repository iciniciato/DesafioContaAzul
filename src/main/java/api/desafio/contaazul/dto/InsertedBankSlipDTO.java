package api.desafio.contaazul.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import api.desafio.contaazul.entitys.BankSlipEntity;
import api.desafio.contaazul.enums.BankSlipStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gscarabelo
 * @since 10/30/18 3:21 PM
 */
@Data
@ToString
@NoArgsConstructor
public class InsertedBankSlipDTO {

    private UUID id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-3")
    private Date due_date;

    @Column(precision = 11, scale = 0)
    private BigDecimal total_in_cents;

    private String customer;

    private BankSlipStatusEnum status;

    public InsertedBankSlipDTO(BankSlipEntity bankSlipEntity) {
        this.id = bankSlipEntity.getId();
        this.due_date = bankSlipEntity.getDue_date();
        this.total_in_cents = bankSlipEntity.getTotal_in_cents();
        this.customer = bankSlipEntity.getCustomer();
        this.status = bankSlipEntity.getStatus();
    }

}
