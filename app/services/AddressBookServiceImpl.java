package services;

public class AddressBookServiceImpl implements AddressBookService {
    private final AddressBookDataService addressBookDataService;

    public AddressBookServiceImpl(AddressBookDataService addressBookDataService) {
        this.addressBookDataService = addressBookDataService;
    }


    @Override
    public long countMales() {
       return addressBookDataService.retrieveAll()
                              .filter(ad -> ad.isMale())
                              .count();

    }

    @Override
    public AddressBook getOldest() {
        return null;
    }

    @Override
    public Integer getAgeDiff() {
        return null;
    }
}
