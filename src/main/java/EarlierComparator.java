import java.util.Comparator;

public class EarlierComparator implements Comparator<Service> {
    @Override
    public int compare(Service o2, Service o1) {
        if (o1.getCompanyName().compareTo(o2.getCompanyName()) == 0){
            return Long.compare(o2.getDepartureTime(), o1.getDepartureTime());
        }else {
            return o1.getCompanyName().compareTo(o2.getCompanyName());
        }
    }
}
