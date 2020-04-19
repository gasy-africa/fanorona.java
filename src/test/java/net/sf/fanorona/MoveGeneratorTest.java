package net.sf.fanorona;

import logic.board.Bits;
import logic.board.Board;
import logic.engine.MoveGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveGeneratorTest {

    Board b;
    MoveGenerator mg;

    @BeforeClass
    public void setUp() {
        b = new Board();
//        b.previousPosition.myPieces = b.myPieces;
        b.myPieces = 544790103982080L;
        b.opponentPieces = 562399469895680L;
        mg = new MoveGenerator(b);
    }

    @Test(groups = { "next" })
    public void aNextTest() {
//        b.previousPosition.myPieces;
        Bits.display(b.myPieces);
        Bits.display(b.opponentPieces);
        Bits.display(190316031);

        for (int i = 0;i < 3;i++) {
            System.out.println("------------ \nnext   : ");
            Bits.display(mg.nextElement());
            System.out.println("hasCapture : "+ mg.hasCapture());
        }

    }

}
