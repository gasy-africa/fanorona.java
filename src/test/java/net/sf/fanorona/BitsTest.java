package net.sf.fanorona;

import logic.board.Bits;
import logic.board.Board;
import logic.engine.MoveGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class BitsTest {

    Board b;
    MoveGenerator mg;

    @BeforeClass
    public void setUp() {
        b = new Board();
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        String myPieces = Bits.fill64(Long.toBinaryString(b.myPieces));
        System.out.println(myPieces);
        Bits.display(myPieces);
        String opponentPieces = Bits.fill64(Long.toBinaryString(b.opponentPieces));
        System.out.println(opponentPieces);
        Bits.display(opponentPieces);
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
