package services;

import org.joda.time.Days;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class AddressBookServiceImpl implements AddressBookService {
    private final AddressBookDataService addressBookDataService;

    public AddressBookServiceImpl(AddressBookDataService addressBookDataService) {
        this.addressBookDataService = addressBookDataService;
    }


    @Override
    public long countMales() {
       return getAddressBookStream()
                              .filter(ad -> ad.isMale())
                              .count();

    }

    private Stream<AddressBook> getAddressBookStream() {
        return addressBookDataService.retrieveAll();
    }

    @Override
    public Optional<AddressBook> getOldest() {
        Comparator<AddressBook> byAge = (e1, e2) -> e1.getBirthDate().compareTo(e2.getBirthDate());
        return getAddressBookStream().sorted(byAge).findFirst();
    }

    private Optional<AddressBook> findByFistName(String firstName) {
        return getAddressBookStream().filter(ad -> ad.getFirstName().equals(firstName))
                                     .findFirst();
    }

    @Override
    public Optional<Integer> getAgeDiff(String firstName1, String firstName2) {
        Optional<AddressBook> byFistName1 = findByFistName(firstName1);
        Optional<AddressBook> byFistName2 = findByFistName(firstName2);
        if(byFistName1.isPresent() && byFistName2.isPresent())
            return Optional.of(Days.daysBetween(byFistName1.get().getBirthDate(),byFistName2.get().getBirthDate()).getDays());
        else
            return Optional.empty();
    }
}
