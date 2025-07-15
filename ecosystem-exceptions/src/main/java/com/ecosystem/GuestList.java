package com.ecosystem;

import lombok.Data;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Data
public class GuestList {

    public GuestList(String path) throws IOException {
        try {
            Files.write(Paths.get(path), new ArrayList<>());
        }catch (IOException e){
            throw new IOException("Failed to initialize the guest list", e);
        }
    }

    public List<String> setGuestList(List<String> guestList, String path) throws IOException {
        try {
            Files.write(Paths.get(path), guestList);
        }catch (IOException e){
            throw new IOException("Failed to write guest list to file", e);
        }
        return guestList;
    }

    public List<String> getGuestList(String path) throws IOException {
        try {
            return java.nio.file.Files.readAllLines(java.nio.file.Paths.get(path));
        }catch (IIOException e){
            throw new IOException("Failed to get the guest list to file", e);
        }
    }

    public String addGuest(String guest, String path) throws IOException {
        try {
            List<String> guests = getGuestList(path);
            guests.add(guest);
            setGuestList(guests, path);
        }catch (IIOException e){
            throw new IOException("Failed to add the new guest to the list", e);
        }
        return guest;
    }

}
