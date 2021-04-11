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

    }

}
