package services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileAddressBookDataServiceImpl implements AddressBookDataService {
    private final String fileLocation;

    public FileAddressBookDataServiceImpl(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public Stream<AddressBook> retrieveAll() {
        return getLines().map(AddressBook::new);
    }

    private Stream<String> getLines() {
        try {
            return Files.lines(Paths.get(fileLocation), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

}
