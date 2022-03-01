/*
 *   Name: Ngoc Duy Nguyen
 *   Date: 3/1/2022
 *   Description: Orchestra class
 * */
package Lab_06;

import java.util.Iterator;

public class Orchestra<T> implements Iterable<T> {

    Instruments[] instrumentsArray = new Instruments[5];
    int size = instrumentsArray.length;
    int currentIndex = 0;
    int counter = 0;
    int newSize;

    /**
     * Add an instrument to the array
     * Increase array's size by 50% when array is full
     *
     * @param instrument
     */
    public void addInstruments(Instruments instrument) {

        int i;
        // The if statement executed when array is full
        if (counter >= size) {
            newSize = (int) (size + size * 0.5);
            // Create a new array with a newSize and add instrument into new array
            Instruments[] newInstrumentsArray = new Instruments[newSize];
            for (int j = 0; j < size; j++) {
                newInstrumentsArray[j] = instrumentsArray[j];
            }

            // Assign new array into instrumentArray and resize
            instrumentsArray = newInstrumentsArray;
            size = newSize;
        }

        // for loop to add instrument into array
        for (i = counter; i < counter + 1; i++) {
            instrumentsArray[i] = instrument;
        }
        counter++; // counter get updated to represent array index
        // and compare with array's size

        currentIndex++; // currentIndex is used for hasNext method in iterator
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
                return (T) instrumentsArray[currentIndexIterator++];
            }

            // Check if there's any null value in the array
            // if yes the array will resize by n null value
            @Override
            public void remove() {
                System.out.println("Size before remove: " + size);
                for (int i = 0; i < size; i++) {
                    if (instrumentsArray[i] == null) {
                        newSize = size - 1;
                        Instruments[] newInstruments = new Instruments[newSize];
                        for (int j = 0; j < newSize; j++) {
                            newInstruments[j] = instrumentsArray[j];
                        }
                        instrumentsArray = newInstruments;
                        size = newSize;
                    }
                }
                System.out.println("Current size is: " + size);
            }
        };
        return it;
    }

    /**
     * This method plays all the instrument songs in the orchestra
     *
     * @param orchestra
     */
    public void playAll(Orchestra orchestra) {
        Iterator<Instruments> iterator = orchestra.iterator();
        while (iterator.hasNext()) {
            iterator.next().play();
        }
    }

    /**
     * This method tune all the instrument note in the orchestra
     *
     * @param note
     */
    public void tuneAll(char note, Orchestra orchestra) {
        Iterator<Instruments> iterator = orchestra.iterator();
        while (iterator.hasNext()) {
            iterator.next().tune(note);
        }
    }
}

