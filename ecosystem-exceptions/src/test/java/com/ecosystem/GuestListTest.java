package com.ecosystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuestListTest {
    GuestList guestList;

    @BeforeEach
    public void setup() {
        guestList  = new GuestList();
    }

    @Test
    void guestList_ShouldBeEmpty_byDefault(){
        assertEquals(0, guestList.getGuestList().size());
    }

    @Test
    void guestList_shouldReadSameGuestsAsWrittenBefore(){
        List<String> newGuestList = new ArrayList<>(Set.of("Guest1", "Guest2", "Guest3"));
        guestList.setGuestList(newGuestList);
        assertEquals(3, guestList.getGuestList().size());
        assertEquals(newGuestList, guestList.getGuestList());
    }
}
