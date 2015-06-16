import org.joda.time.DateTime;
import org.junit.Test;
import services.AddressBook;
import services.AddressBookDataService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.fest.assertions.Assertions.assertThat;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class AddressBookTest {

    private Stream<AddressBook> createAddressBookMock() {
        final AddressBook ad1 = new AddressBook("John", "Doe", true, new DateTime(2000,1,1,0,0));
        final AddressBook ad2 = new AddressBook("John1", "Doe", true, new DateTime(2001,1,1,0,0));
        final AddressBook ad3 = new AddressBook("John2", "Doe", true, new DateTime(2001,2,1,0,0));
        final AddressBook ad4 = new AddressBook("Joanna2", "Doe", true, new DateTime(2005,1,1,0,0));
        List<AddressBook> addressBooks = Arrays.asList(ad1, ad3, ad2);
        return addressBooks.stream();

    }

    class MockAddressDataBookServiceImpl implements AddressBookDataService{

        @Override
        public Stream<AddressBook> retrieveAll() {
            return createAddressBookMock();
        }
    }

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
}
