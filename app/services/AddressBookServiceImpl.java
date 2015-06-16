package services;

public class AddressBookServiceImpl implements AddressBookService {
    private AddressBookDataService addressBookDataService;

    public AddressBookServiceImpl(AddressBookDataService addressBookDataService) {
        this.addressBookDataService = addressBookDataService;
    }


    @Override
    public int countMales() {
        return 0;
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
