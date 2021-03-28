package storage;

import entities.Accommodation;

import java.util.ArrayList;

public interface Database {
    ArrayList<Accommodation> getAllHotels();
    ArrayList<Accommodation> getHotelsByLocation(String location);
    //ArrayList<Accommodation> getHotelsByTimePeriod(String location);
    ArrayList<Accommodation> getHotelsByRating(double minRating);
    //ArrayList<Accommodation> getHotelsByFacilities(String facilities);
    //ArrayList<Accommodation> getHotelsByPrice(String maxPrice);
    ArrayList<Accommodation> getHotelsByName(String name);

    // Í Database interface á að vera listi af öllum methods sem á að vera hægt að leita eftir
    //      og munu verða notuð.
    // Database verður svo implementað bæði af mock objects og af alvöru Database klasanum.
    // Við viljum ekki hafa fall í Database fyrir almennt query heldur útfæra queries innan
    //      fallanna miðað við nöfnin á þeim (getAllBookings, getHotelsBylocation etc.)
    // Höfum nokkra möguleika á útfærslu samskipta við gagnagrunn. Eins og ég útfærði
    //      findByLocation er verið að gera ráð fyrir því að við biðjum um öll hotel
    //      og filtering fari fram í minni. Viljum ákveða hvort við látum SQL sjá um
    //      filteringuna eða hvort við gerum það þannig. Hallast að SQL, þarf þá að útfæra.
    // Hvernig er best að leita eftir mörgum skilyrðum?
    //
    // Varðandi tests sem á að skila á sunnudag:
    //      Við skilum um 10-13 test cases úr um það bil 3 föllum sem við veljum úr t.d.
    //          search controller. T.d. ef testa á findByLocation gerum við nokkur test
    //          case fyrir það. Kannski eitt sem fær inn gilda leit, eitt tóma, eitt null
    //          o.s.frv. Ath. að Tests eru keyrð í random röð. Fyrir hvert test er keyrt
    //          Setup og eftir hvert test er Tear down keyrt. Sjá glærur for inspo.
}

