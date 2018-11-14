package se.seb.mdm.buildstuff;

import java.util.List;

public interface ArrangementService {
    List<Arrangement> getArrangements(String customerId);
}
