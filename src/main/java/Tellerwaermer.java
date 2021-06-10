import exceptions.IsEmptyException;
import exceptions.MaxSizeReachedException;
import exceptions.NotDeletableException;
import exceptions.NotInitializedException;

import java.util.ArrayList;

public class Tellerwaermer {

    public static final String TELLERSTAPEL_NOT_INITALISED = "Tellerstapel ist nicht initialisiert!";
    public static final String TELLERSTAPEL_IS_EMPTY = "Tellerstapel ist leer!";
    public static final String TELLERSTAPEL_IS_FULL = "Tellerstapel ist voll!";
    public static final String TELLERSTAPEL_NOT_DELETABLE = "Tellerstapel kann nicht gelöscht werden!";
    private ArrayList<Integer> teller;
    private int maxSize;

    public void init(int maxSize){
        this.maxSize = maxSize;
        teller = new ArrayList<>();
    }

    public void push() throws NotInitializedException, MaxSizeReachedException {
        if(teller != null) {
            if(teller.size() < maxSize) {
                teller.add(1);
            } else {
                throw new MaxSizeReachedException(TELLERSTAPEL_IS_FULL);
            }

        } else {
            throw new NotInitializedException(TELLERSTAPEL_NOT_INITALISED);
        }
    }

    public void pop() throws NotInitializedException, IsEmptyException {
        if(teller != null && !teller.isEmpty()) {
            teller.remove(teller.size() - 1);
        } else {
            if(teller == null) {
                throw new NotInitializedException(TELLERSTAPEL_NOT_INITALISED);
            } else {
                throw new IsEmptyException(TELLERSTAPEL_IS_EMPTY);
            }
        }
    }

    public Integer peek() throws NotInitializedException, IsEmptyException {
        if (teller != null && !teller.isEmpty()) {
            return teller.get(teller.size() - 1);
        } else {
            if(teller == null) {
                throw new NotInitializedException(TELLERSTAPEL_NOT_INITALISED);
            } else {
                throw new IsEmptyException(TELLERSTAPEL_IS_EMPTY);
            }
        }
    }

    public void delete() throws NotDeletableException {


        if(teller != null && teller.isEmpty()){
            setTeller(null);
            System.out.println("Good night");
        } else {
            throw new NotDeletableException(TELLERSTAPEL_NOT_DELETABLE);
        }

    }

    public ArrayList<Integer> getTeller() {
        return teller;
    }

    public void setTeller(ArrayList<Integer> teller) {
        this.teller = teller;
    }
}
