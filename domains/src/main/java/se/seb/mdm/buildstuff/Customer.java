package se.seb.mdm.buildstuff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customerId;
    private String personalIdNumber;

    private String firstName;
    private String lastName;

}
