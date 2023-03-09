package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class PaymentData {
    private String cardNumber;
    private String expiryDate;
    private String cvcCode;
}
