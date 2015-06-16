package services;

import java.util.Optional;

public interface AddressBookService {
    long countMales();

    Optional<AddressBook> getOldest();

    Integer getAgeDiff(String firstName1, String firstName2);
}
