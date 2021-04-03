
import java.util.*;
import java.util.stream.Collectors;

public class ServiceFilter {

    public List<Service> filter(List<Service> list) {
        list.sort(new LaterComparator());
        Set<Service> services = new TreeSet<>(new ServiceComparator());
        services.addAll(list);
        return services.stream()
                .sorted(new EarlierComparator())
                .collect(Collectors.toList());
    }
}
