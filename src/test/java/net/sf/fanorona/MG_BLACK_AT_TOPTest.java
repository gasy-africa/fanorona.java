package net.sf.fanorona;

import gui.widgets.Options;
import logic.board.Bits;
import logic.board.Board;
import logic.engine.MoveGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MG_BLACK_AT_TOPTest {

    Board b;
    MoveGenerator mg;

    @BeforeClass
    public void setUp() {

        b = new Board();
        b.myPieces = Bits.INITIAL_BOT;
        b.opponentPieces = Bits.INITIAL_TOP;
        mg = new MoveGenerator(b);
        // Bits.display(mg.set); // the set is empty when starting
    }

    @Test(groups = { "bottom" })
    public void bottomTest() {

        System.out.println("# Move Generator - INITIAL_BOT Scenario\n");

        int moves = 0; // total number of moves before getting out

        while (mg.hasMoreElements()) {
            moves += 1;
            System.out.println("\n### :bulb: Move # " + moves + " - finding Next Element \n");
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

        System.out.println("\n :+1: Total Number of Moves : " + moves);

    }

    //@Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
