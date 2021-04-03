package com.tirkesh.service.comparators;

import com.tirkesh.service.services.Service;

import java.util.Comparator;

public class LaterComparator implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        return Long.compare(o2.getDepartureTime(), o1.getDepartureTime());
    }
}
