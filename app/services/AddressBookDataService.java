package services;

import java.util.stream.Stream;

public interface AddressBookDataService {
    Stream<AddressBook> retrieveAll();
}
