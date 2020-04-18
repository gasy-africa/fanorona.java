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
        mg = new MoveGenerator(b);
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("myPieces   : "+ Bits.fill64(Long.toBinaryString(b.myPieces)));
        System.out.println("NextElement: "+ Bits.fill64(Long.toBinaryString(mg.nextElement())) + " " + mg.hasMoreElements());
        System.out.println("NextElement: "+ Bits.fill64(Long.toBinaryString(mg.nextElement())) + " " + mg.hasMoreElements());
        System.out.println("NextElement: "+ Bits.fill64(Long.toBinaryString(mg.nextElement())) + " " + mg.hasMoreElements());
        System.out.println("hasCapture : "+ mg.hasCapture());
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
