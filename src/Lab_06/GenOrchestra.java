/*
 *   Name: Ngoc Duy Nguyen
 *   Date: 3/1/2022
 *   Description: Gen Orchestra class
 * */
package Lab_06;

import java.util.ArrayList;
import java.util.Iterator;


public class GenOrchestra<T> implements Iterable<T> {
    ArrayList<Instruments> instrumentsList = new ArrayList<>();
    int currentIndex = 0;

    /**
     * Add an instrument into arrayList
     *
     * @param instrument
     */
    public void addInstruments(Instruments instrument) {
        instrumentsList.add(instrument);
        currentIndex++;
    }

    /**
     * Override iterator
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            int currentIndexIterator = 0;

            @Override
            public boolean hasNext() {
                return currentIndexIterator < currentIndex;
            }

            @Override
            public T next() {
                return (T) instrumentsList.get(currentIndexIterator++);
            }

        };
        return it;
    }

    /**
     * This method plays all the instrument songs in the orchestra
     *
     * @param genOrchestra
     */
    public void playAll(GenOrchestra genOrchestra) {
        Iterator<Instruments> iterator = genOrchestra.iterator();
        while (iterator.hasNext()) {
            iterator.next().play();
        }
    }

    /**
     * This method tune all the instrument note in the orchestra
     *
     * @param note
     */
    public void tuneAll(char note, GenOrchestra genOrchestra) {
        Iterator<Instruments> iterator = genOrchestra.iterator();
        while (iterator.hasNext()) {
            iterator.next().tune(note);
        }
    }
}



