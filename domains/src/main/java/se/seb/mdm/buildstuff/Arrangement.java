package se.seb.mdm.buildstuff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arrangement {

    private String customerId;
    private String arrangementId;
    private String productId;

    private String accountNumber;
    private String arrangementName;

    private String validFrom;
    private String validTo;

}
