package com.tirkesh.service.services;

import com.tirkesh.service.comparators.EarlierComparator;
import com.tirkesh.service.comparators.LaterComparator;
import com.tirkesh.service.comparators.ServiceComparator;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceFilter {

    public List<Service> filter(List<Service> list) {
        System.out.println("start filtering list of service !");
        list.sort(new LaterComparator());
        Set<Service> services = new TreeSet<>(new ServiceComparator());
        services.addAll(list);
        List<Service> collect = services.stream()
                .sorted(new EarlierComparator())
                .collect(Collectors.toList());

        System.out.println("end of filtering !");
        System.out.println("result => "+ collect);
        return collect;
    }
}
