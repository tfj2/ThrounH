package entities;

import java.sql.Date;

//Er þetta lokaútfærsla af date from og to? Gerði bara svoldið hér, þurfum að ræða þetta betur.
public class Occupancy {
    private Date dateFrom;
    private Date dateTo;
    public Occupancy(Date from, Date to) {
        this.dateFrom = from;
        this.dateTo = to;
    }
}
