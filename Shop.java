
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Shop {
private List<MusicalInstrument> instruments;

public void setInstruments(List<MusicalInstrument> instruments) {
        this.instruments = instruments;
        }


public void prepareListOfInstrumentsToRemove(Map<String, Integer> order) throws NoInstrument {

        List<MusicalInstrument> prepareList = new ArrayList<>();

        for (Map.Entry<String, Integer> orderMap : order.entrySet()) {
        String musInstrumentsType = orderMap.getKey();
        Integer numberOfInstruments = orderMap.getValue();

        int numberFound = 0;

        for (MusicalInstrument instrument : instruments) {
        if (instrument.getType().equals(musInstrumentsType) && numberFound < numberOfInstruments) {
        prepareList.add(instrument);
        numberFound++;
        }
        }
        if (numberFound < numberOfInstruments) {
        throw new NoInstrument("Music shop doesn't have enough " + musInstrumentsType + "s");
        }
        }


        System.out.print("Ordered:        ");
        int numpiano = 0;
        int numtrumpet = 0;
        int numguitar = 0;
        for (MusicalInstrument instrument : prepareList) {
        String musInstruments = instrument.getType();
        if (musInstruments == "piano") {
        numpiano++;
        }
        if (musInstruments == "trumpet") {
        numtrumpet++;
        }
        if (musInstruments == "guitar") {
        numguitar++;
        }
        }
        System.out.println(numpiano + " pianos   " + numtrumpet + " trumpets   " + numguitar + " guitars  ");
        }

public void removeInstruments(Map<String, Integer> order) {
        for (Map.Entry<String, Integer> orderMap : order.entrySet()) {
        String musInstrumentsType = orderMap.getKey();
        Integer numberOfInstruments = orderMap.getValue();

        int numberRemoved = 0;

        Iterator<MusicalInstrument> iterator = instruments.iterator();
        while (iterator.hasNext()) {
        MusicalInstrument musicShopInstrument = iterator.next();
        if (musicShopInstrument.getType().equals(musInstrumentsType) && numberRemoved < numberOfInstruments) {
        iterator.remove();
        numberRemoved++;
        }
        }
        }
        }
        }