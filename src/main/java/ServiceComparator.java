import java.util.Comparator;

public class ServiceComparator implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        int departure = Long.compare(o1.getDepartureTime(), o2.getDepartureTime());
        int arrive = Long.compare(o1.getArriveTime(), o2.getArriveTime());

        if (departure == 0 && arrive == 0) {
            return 0;
        }

        if (departure == -1 && arrive == 0 ){
            return 0;
        }

        if (departure == -1 && arrive == 1){
            return 0;
        }

        return departure  == 0 ? arrive : departure;
    }
}
