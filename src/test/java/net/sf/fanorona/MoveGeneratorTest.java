package net.sf.fanorona;

import logic.board.Bits;
import logic.board.Board;
import logic.engine.MoveGenerator;
import org.testng.annotations.*;

public class MoveGeneratorTest {

    Board b;
    MoveGenerator mg;
    long storedFrom;
    long storedTo;


    @BeforeClass
    public void setUp() {
        b = new Board();
//        b.myPieces = Bits.INITIAL_TOP;
//        b.myPieces = 544790103982080L;
        b.myPieces = 4611686018600926719L;
//        storedFrom = 4611686018600926719L;
//        storedFrom = b.myPieces;
//        storedTo = 16777216L; // Bits.ON_BOARD & ~(b.myPieces | b.opponentPieces);
//        b.opponentPieces = 562399469895680L;
//        System.out.println("myPieces   : --------------");
//        Bits.display(storedFrom);
//        Bits.display(storedTo);
//        Bits.display(b.opponentPieces);

        mg = new MoveGenerator(b);
        // Bits.display(mg.set); // the set is empty when starting
    }

    @Test(groups = { "fast" })
    public void aFastTest() {

        System.out.println("# Move Generator - General Scenario\n");

        while (mg.hasMoreElements()) {
            System.out.println("\n### :bulb: finding Next Element \n");
            System.out.println("\n:round_pushpin: Working on Set \n");
            Bits.display(mg.set);
            System.out.println("\n\n");
            System.out.println("| moveSetIndex | type | capt? | shift |");
            System.out.println("|--------------|------|-------|-------|");
            System.out.println("|" + mg.moveSetIndex + " | " + mg.captureType + " | " + mg.madeCapture + " | "+ mg.shift + " |");
            // find next move in sequence by pulling bits out of set
            System.out.println("\n:round_pushpin: pulling bits out of Set \n");
            Bits.display(mg.nextElement());
        }
    }

    //@Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
