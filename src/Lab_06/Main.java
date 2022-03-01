/**
 * Name: Ngoc Duy Nguyen
 * Date: 3/1/2022
 * Description: Main class
 */
package Lab_06;

import java.util.Iterator;

public class Main extends Orchestra {

    public static void main(String[] args) {

        Orchestra<Instruments> orchestra = new Orchestra<>();

        orchestra.addInstruments(new Cello("Sonata no 1"));
        orchestra.addInstruments(new Viola("Suite no 1"));
        orchestra.addInstruments(new Tuba("The Great Square of Pegasus", 3));
        orchestra.addInstruments(new Cello("River Flows in you"));
        orchestra.addInstruments(new Viola("Love me"));
        orchestra.addInstruments(new Cello("Never gonna give you up"));

        GenOrchestra<Instruments> genOrchestra = new GenOrchestra<>();

        genOrchestra.addInstruments(new Cello("Sonata no 1"));
        genOrchestra.addInstruments(new Cello("Suite no 1"));
        genOrchestra.addInstruments(new Tuba("The Great Square of Pegasus", 3));
        genOrchestra.addInstruments(new Viola("River Flows in you"));
        genOrchestra.addInstruments(new Viola("Love me"));
        genOrchestra.addInstruments(new Tuba("Never gonna give you up", 4));

        Iterator<Instruments> iterator1 = orchestra.iterator();
        System.out.println("Override remove() method test:");
        // Initial size was 5, after add the 6th instrument array's size resize to 7
        // Since we have 6 instrument the 7th (index 6) would be null
        // So after remove the null current size is expected to be 6
        iterator1.remove();

        System.out.println("\nHere's the list of instruments in Orchestra: ");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + ", ");
        }

        System.out.println("\nTuning all instruments: ");
        orchestra.tuneAll('D', orchestra);
        System.out.println("\nAll instruments play songs: ");
        orchestra.playAll(orchestra);

        Iterator<Instruments> iterator2 = genOrchestra.iterator();

        System.out.println("\nHere's the list of instruments in Gen Orchestra: ");
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + ", ");
        }

        System.out.println("\nTuning all instruments: ");
        genOrchestra.tuneAll('G', genOrchestra);
        System.out.println("\nAll instruments play songs: ");
        genOrchestra.playAll(genOrchestra);

    }
}
