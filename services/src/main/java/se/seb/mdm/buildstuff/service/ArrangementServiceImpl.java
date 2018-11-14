package se.seb.mdm.buildstuff.service;

import com.github.javafaker.Faker;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.stereotype.Service;
import se.seb.mdm.buildstuff.Arrangement;
import se.seb.mdm.buildstuff.ArrangementService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

@Service
public class ArrangementServiceImpl implements ArrangementService {

    @Override
    public List<Arrangement> getArrangements(String customerId) {
        Faker faker = new Faker();
        List<Arrangement> arrangementList = EnhancedRandom.randomListOf(10, Arrangement.class);

        arrangementList.forEach(arrangement -> {

            arrangement.setCustomerId(customerId);
            arrangement.setAccountNumber(faker.finance().iban());
            arrangement.setArrangementId(faker.number().digits(10));
            arrangement.setArrangementName(faker.beer().style());
            arrangement.setProductId(faker.number().digits(5));

            arrangement.setValidFrom(LocalDate
                    .now()
                    .minus(Period.ofDays((new Random().nextInt(365 * 3))))
                    .toString());
            arrangement.setValidTo(LocalDate
                    .now()
                    .plus(Period.ofDays((new Random().nextInt(365 * 3))))
                    .toString());
        });
        return arrangementList;
    }
}
