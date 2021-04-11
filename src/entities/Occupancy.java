package entities;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//Er þetta lokaútfærsla af date from og to? Gerði bara svoldið hér, þurfum að ræða þetta betur.
public class Occupancy {
    private Date dateFrom;
    private Date dateTo;

    public Occupancy(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public static void main(String[] args) {
        Date testFrom = new Date();
        Instant instant = testFrom.toInstant();
        Instant nextWeek = instant.plus(7, ChronoUnit.DAYS);

        Date testTo = Date.from(nextWeek);

        Occupancy test = new Occupancy(testFrom, testTo);
        System.out.print(test.getDateFrom() + " " + test.getDateTo());
    }
}
