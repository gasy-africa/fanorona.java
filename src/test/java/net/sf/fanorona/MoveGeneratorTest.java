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
//        b.myPieces = 544790103982080L;
//        b.myPieces = 4611686018600926719L;
//        storedFrom = 4611686018600926719L;
//        storedFrom = b.myPieces;
//        storedTo = 16777216L; // Bits.ON_BOARD & ~(b.myPieces | b.opponentPieces);
//        b.opponentPieces = 562399469895680L;
//        System.out.println("myPieces   : --------------");
//        Bits.display(storedFrom);
//        Bits.display(storedTo);
//        Bits.display(b.opponentPieces);

        mg = new MoveGenerator(b);
        System.out.println("||||||||||||||| Working on Set:\t -Start---");
        Bits.display(mg.set);
        System.out.println("||||||||||||||| Working on Set:\t -End---");
        System.out.println("--\nmoveSetIndex : " + mg.moveSetIndex + " type: " + mg.captureType + " capt? " + mg.madeCapture + " shift: "+ mg.shift);
    }

    @Test(groups = { "fast" })
    public void aFastTest() {

        while (mg.hasMoreElements()) {
            System.out.println("Working on Set:\t -Start---");
            Bits.display(mg.set);
            System.out.println("Working on Set:\t -End---");
            // find next move in sequence by pulling bits out of set
            Bits.display(mg.nextElement());
            System.out.println("--\nmoveSetIndex : " + mg.moveSetIndex + " type: " + mg.captureType + " capt? " + mg.madeCapture + " shift: "+ mg.shift);
        }
    }

    //@Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
