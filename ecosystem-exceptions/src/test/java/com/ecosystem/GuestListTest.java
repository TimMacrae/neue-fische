package com.ecosystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuestListTest {
    GuestList guestList;
    String path = "guests.txt";
    String invalidPath = "/invalid/path/guests.txt";

    @BeforeEach
    public void setup() throws IOException {
        guestList = new GuestList(path);
    }

    @Test
    void guestList_ShouldBeEmpty_byDefault() throws IOException {
        assertEquals(0, guestList.getGuestList(path).size());
    }

    @Test
    void guestList_ShouldThrowAnIoException_whenInitializeWithWrongPath() {
        assertThrows(IOException.class, () -> new GuestList(invalidPath)
        );
    }

    @Test
    void guestList_shouldReadSameGuestsAsWrittenBefore() throws IOException {
        List<String> newGuestList = new ArrayList<>(Set.of("Guest1", "Guest2", "Guest3"));
        List<String> textFileList = guestList.setGuestList(newGuestList, path);
        assertEquals(3, textFileList.size());
        assertEquals(newGuestList, textFileList);
    }

    @Test
    void guestList_shouldWriteToFileSystem() throws IOException {
        List<String> newGuestList = new ArrayList<>(Set.of("Theodor", "Anette"));
        guestList.setGuestList(newGuestList, path);

        assertEquals(newGuestList, guestList.getGuestList(path));
    }

    @Test
    void setGuestList_shouldThrowIoException_whenFileWriteFails() {
        List<String> guests = List.of("A", "B");

        assertThrows(IOException.class, () -> {
            guestList.setGuestList(guests, invalidPath);
        });
    }

    @Test
    void getGuestList_ShouldThrowIoException_whenFileReadFails() {
        assertThrows(IOException.class, () -> guestList.getGuestList(invalidPath));
    }

    @Test
    void addGuest_ShouldThrowIoException_whenFileWriteFails() {
        assertThrows(IOException.class, () -> guestList.getGuestList(invalidPath));
    }

    @Test
    void addGuest_ShouldAddedToTheList() throws IOException {
        List<String> newGuestList = new ArrayList<>(Set.of("Guest1", "Guest2", "Guest3"));
        List<String> textFileList = guestList.setGuestList(newGuestList, path);
        assertEquals(3, textFileList.size());

        List<String> updatedList = new ArrayList<>(Set.of("Guest1", "Guest2", "Guest3", "Tim"));
        guestList.addGuest("Tim", path);
        assertEquals(new HashSet<>(updatedList), new HashSet<>(guestList.getGuestList(path)));
        assertEquals(4, guestList.getGuestList(path).size());
    }
}
