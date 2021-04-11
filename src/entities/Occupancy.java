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
        long now = System.currentTimeMillis();
        Date sqlDateFrom = new Date(now);
        Date sqlDateTo = new Date(now + (1000 * 60 * 60 * 24 * 7));
        System.out.println(sqlDateFrom);
        System.out.println(sqlDateTo);

        Occupancy test = new Occupancy(sqlDateFrom, sqlDateTo);
        System.out.println(test.getDateFrom());
        System.out.println(test.getDateTo());
    }

}
