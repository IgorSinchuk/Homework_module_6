import java.util.*;

public class Runner {
    public static void main(String[] args) {


        Shop Shop = new Shop();


        ArrayList<MusicalInstrument> instruments = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            instruments.add(new Guitar());
        }
        for (int i = 0; i < 2; i++) {
            instruments.add(new Piano());
        }
        for (int i = 0; i < 7; i++) {
            instruments.add(new Trumpet());
        }


        Shop.setInstruments(instruments);


        Map<String, Integer> order = new HashMap<>();
        Scanner num = new Scanner(System.in);
        System.out.println("Created a new shopping list");
        System.out.println("How many pianos would you like to buy?");
        order.put("piano", num.nextInt());
        System.out.println("How many trumpets would you like to buy?");
        order.put("trumpet", num.nextInt());
        System.out.println("How many guitars would you like to buy?");
        order.put("guitar", num.nextInt());



        System.out.print("Total in shop: ");
        for (Map.Entry<String, Integer> forNam : order.entrySet()) {
            String musInstruments = forNam.getKey();
            int number = 0;
            for (MusicalInstrument instrument : instruments) {
                if (instrument.getType().equals(musInstruments)) {
                    number++;
                }
            }
            System.out.print(number + " " + musInstruments + "s   ");
        }
        System.out.println("");


        try {
            Shop.prepareListOfInstrumentsToRemove(order);
            Shop.removeInstruments(order);


            System.out.print("After buying: ");
            for (Map.Entry<String, Integer> forNam : order.entrySet()) {
                String musInstruments = forNam.getKey();
                int number = 0;
                for (MusicalInstrument instrument : instruments) {
                    if (instrument.getType().equals(musInstruments)) {
                        number++;
                    }
                }
                System.out.print(number + " " + musInstruments + "s   ");


            }
        } catch (Exception e) {
            System.out.println("Exception happened : " + e.getMessage());

        }
    }
}

