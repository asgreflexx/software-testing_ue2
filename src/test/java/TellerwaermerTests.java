import exceptions.IsEmptyException;
import exceptions.MaxSizeReachedException;
import exceptions.NotDeletableException;
import exceptions.NotInitializedException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TellerwaermerTests {

    Tellerwaermer tellerwaermer;

    @Before
    public void setUp() {
        tellerwaermer = new Tellerwaermer();
    }

    @Test
    public void testInit(){
        tellerwaermer.init(3);

        assertEquals(0, tellerwaermer.getTeller().size());
    }

    @Test
    public void testPush() throws NotInitializedException, MaxSizeReachedException {
        tellerwaermer.init(3);
        tellerwaermer.push();

        assertEquals(1, tellerwaermer.getTeller().size());
    }

    @Test
    public void testPushUntilMaxSize() throws NotInitializedException, MaxSizeReachedException {
        tellerwaermer.init(3);

        tellerwaermer.push();
        tellerwaermer.push();
        tellerwaermer.push();

        assertEquals(3, tellerwaermer.getTeller().size());
    }

    @Test
    public void testPop() throws NotInitializedException, MaxSizeReachedException, IsEmptyException {
        tellerwaermer.init(3);
        tellerwaermer.push();
        tellerwaermer.push();

        tellerwaermer.pop();

        assertEquals(1, tellerwaermer.getTeller().size());
    }

    @Test
    public void testPeek() throws NotInitializedException, MaxSizeReachedException, IsEmptyException {
        tellerwaermer.init(3);
        tellerwaermer.push();

        assertEquals(Integer.valueOf(1), tellerwaermer.peek());
    }

    @Test
    public void testDelete() throws NotDeletableException {
        tellerwaermer.init(3);

        tellerwaermer.delete();

        assertEquals(null, tellerwaermer.getTeller());
    }

    @Test
    public void testDeleteNotDeleteable() {
        assertThrows(NotDeletableException.class , () -> {
            tellerwaermer.delete();
        });
    }

    @Test
    public void testPushButIsEmpty() {
        assertThrows(NotInitializedException.class, () -> {
            tellerwaermer.push();
        });
    }

    @Test
    public void testPopButIsEmpty() {
        assertThrows(NotInitializedException.class, () -> {
            tellerwaermer.pop();
        });
    }

    @Test
    public void testPushIsSize2() throws NotInitializedException, MaxSizeReachedException {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(1);
        tellerwaermer.init(3);
        tellerwaermer.setTeller(integerArrayList);

        tellerwaermer.push();

        assertEquals(2, tellerwaermer.getTeller().size());
    }

    @Test
    public void testPushMaxSizeReached() {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(1);
        tellerwaermer.init(1);
        tellerwaermer.setTeller(integerArrayList);

        assertThrows(MaxSizeReachedException.class, () -> {
            tellerwaermer.push();
        });
    }

    @Test
    public void testPopOneIsEmpty() {
        tellerwaermer.init(3);

        assertThrows(IsEmptyException.class, () -> {
            tellerwaermer.pop();
        });
    }

    @Test
    public void testPeekNotInitializedWaermer() {
        assertThrows(NotInitializedException.class, () -> {
            tellerwaermer.peek();
        });
    }

    @Test
    public void testPeekWithEmptyWaermer() {
        tellerwaermer.init(10);

        assertThrows(IsEmptyException.class, () -> {
            tellerwaermer.peek();
        });
    }
}
