package services;

import java.util.Optional;

public interface AddressBookService {
    long countMales();
    Optional<AddressBook> getOldest();
    Integer getAgeDiff();
}
