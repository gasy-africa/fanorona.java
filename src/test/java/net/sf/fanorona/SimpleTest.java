package net.sf.fanorona;

import logic.board.Bits;
import logic.board.Board;
import logic.engine.MoveGenerator;
import org.testng.annotations.*;

public class SimpleTest {

    Board b;
    MoveGenerator mg;

    @BeforeClass
    public void setUp() {
        b = new Board();
        b.myPieces = 544790103982080L;
        mg = new MoveGenerator(b);
    }

//    @Test(groups = { "fast" })
    public void aFastTest() {

        String myPieces = Bits.fill64(Long.toBinaryString(b.myPieces));
        System.out.println("myPieces   : "+ myPieces);
        Bits.display(myPieces);
        for (int i = 0;i < 3;i++) {
            System.out.println("------------ \nnext   : ");
            String next = Bits.fill64(Long.toBinaryString(mg.nextElement()));
            Bits.display(next);
            System.out.println("hasCapture : "+ mg.hasCapture());
        }
    }

    //@Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
