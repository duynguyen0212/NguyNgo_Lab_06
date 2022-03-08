/**
 * Name: Ngoc Duy Nguyen
 * Date: 3/1/2022
 * Description: Main class
 */
package Lab_06;

import java.util.Iterator;

public class Main extends Orchestra {

    public static void main(String[] args) {

        // Create anonymous class Trumpet

        Instruments Trumpet = new Instruments() {
            @Override
            public void play() {
                System.out.println("Buuup Buuup Buuup");
            }

            @Override
            public void tune(char note) {
                System.out.println("Tuning Trumpet to note: " + note);
            }
        };
        System.out.println("Testing anonymous class:");
        Trumpet.tune('C');
        Trumpet.play();

        // Create an Orchestra
        Orchestra<Instruments> orchestra = new Orchestra<>();

        orchestra.addInstruments(new Cello("Sonata no 1"));
        orchestra.addInstruments(new Viola("Suite no 1"));
        orchestra.addInstruments(new Tuba("The Great Square of Pegasus", 3));
        orchestra.addInstruments(new Cello("River Flows in you"));
        orchestra.addInstruments(new Viola("Love me"));
        orchestra.addInstruments(new Viola("Never gonna give you up"));

        // Create Gen Orchestra
        GenOrchestra<Instruments> genOrchestra = new GenOrchestra<>();

        genOrchestra.addInstruments(new Cello("Sonata no 1"));
        genOrchestra.addInstruments(new Cello("Suite no 1"));
        genOrchestra.addInstruments(new Tuba("The Great Square of Pegasus", 3));
        genOrchestra.addInstruments(new Viola("River Flows in you"));
        genOrchestra.addInstruments(new Viola("Love me"));
        genOrchestra.addInstruments(new Tuba("Never gonna give you up", 4));

        Iterator<Instruments> iterator1 = orchestra.iterator();
        System.out.println("\nOverride remove method test:");
        // Initial size was 5, after add the 6th instrument array's size resize to 7
        // Since we have 6 instrument the 7th (index 6) would be null
        // So after remove the null current size is expected to be 6
        iterator1.remove();

        // Printing list of instruments of Orchestra
        System.out.println("\nHere's the list of instruments in Orchestra: ");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + ", ");
        }

        System.out.println("\nTuning all instruments: ");
        orchestra.tuneAll('D', orchestra);
        System.out.println("\nAll instruments play songs: ");
        orchestra.playAll(orchestra);

        Iterator<Instruments> iterator2 = genOrchestra.iterator();

        // Printing list of instruments of Gen Orchestra
        System.out.println("\nHere's the list of instruments in Gen Orchestra: ");
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + ", ");
        }

        System.out.println("\nTuning all instruments: ");
        genOrchestra.tuneAll('G', genOrchestra);
        System.out.println("\nAll instruments play songs: ");
        genOrchestra.playAll(genOrchestra);

        System.out.println("\nTuning and play some Instruments:");
        Tuba tuba = new Tuba("Symphony no 1", 2);
        Viola viola = new Viola("Winter Sonata");
        tuba.tune('E');
        tuba.play();
        viola.tune('B');
        viola.play();
    }
}
