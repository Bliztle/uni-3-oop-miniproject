package com.bliztle.uni.oop;

import java.util.ArrayList;

public class ReservationCollection {

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public boolean addReservation(Reservation reservation) {
        return reservations.add(reservation);
    }

    public boolean hasReservation(Reservation reservation) {
        return reservations.contains(reservation);
    }

    public int size() {
        return reservations.size();
    }
}