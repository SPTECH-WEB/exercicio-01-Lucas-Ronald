package br.com.exemplo.apifaturas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão não pode estar em branco")
    @Pattern(regexp = "\\d{16}", message = "O número do cartão deve possuir 16 dígitos")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar em branco")
    @Size(min = 3, max = 100, message = "O nome do titular deve ter entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "O valor não pode estar em branco")
    @DecimalMin(value = "10.0", message = "O valor mínimo é 10")
    @DecimalMax(value = "5000.0", message = "O valor máximo é 5.000")
    private Double valor;

    @NotNull(message = "A data de vencimento não pode estar em branco")
    @FutureOrPresent(message = "A data de vencimento deve ser a data atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O Email não pode estar em branco")
    @Email(message = "O email do pagador deve ser válido")
    private String emailContato;
}
