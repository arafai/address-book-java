import org.junit.Test;
import services.*;

import static org.fest.assertions.Assertions.assertThat;

public class IntegrationTest {

    private final AddressBookDataService addressBookDataService = new FileAddressBookDataServiceImpl(ClassLoader.getSystemResource("AddressBook").getPath());
    private final AddressBookService addressBookService = new AddressBookServiceImpl(addressBookDataService);

    @Test
    public void countMalesCheck() {
        assertThat(addressBookService.countMales()).isEqualTo(3l);
    }

    @Test
    public void getOldestCheck() {
        assertThat(addressBookService.getOldest().get().getFullName()).isEqualTo("Wes Jackson");
    }

    @Test
    public void getAgeDiff() {
        assertThat(addressBookService.getAgeDiff("Bill", "Paul").get()).isEqualTo(2862);
    }
    @Test
    public void getEmptyAgeDiff() {
        assertThat(addressBookService.getAgeDiff("John1", "me").isPresent()).isEqualTo(false);
    }

}
