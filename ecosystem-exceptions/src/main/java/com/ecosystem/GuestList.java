package com.ecosystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GuestList {
    private List<String> guestList = new ArrayList<>();

}
