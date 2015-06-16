package services;

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

    @Override
    public Integer getAgeDiff() {
        return null;
    }
}
