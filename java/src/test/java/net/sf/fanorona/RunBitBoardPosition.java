package net.sf.fanorona;

import logic.board.Bits;

import java.util.Arrays;
import java.util.List;


public class RunBitBoardPosition {

    long white = Bits.INITIAL_BOT | Bits.IS_WHITE;
    long black = Bits.INITIAL_TOP;

    public final String fill64(String bin) {
        return String.format("%0"+(64-bin.length())+"d%s", 0, bin+"L");
    }

    public void boardNumbers() {
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Displays Bit Positioning ");

        List<Character> Row = Arrays.asList('a','b','c','d','e','f','g','h','i');

        System.out.println("Black       = 0b"+fill64(Long.toBinaryString(black)));
        System.out.println("White       = 0b"+fill64(Long.toBinaryString(white)));
		for (int row=0, Col=5;row<=4;row++,Col--) {
			for (int col=0;col<=8;col++) {
				long b = Bits.at(row, col);
				System.out.println("("+row+","+col+") ["+Col+","+Row.get(col)+"] = 0b"+fill64(Long.toBinaryString(b)));
			}
		}
        System.out.println("White       = 0b"+fill64(Long.toBinaryString(white)));
	}

	public void constantInBinary() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Displays in BINARY ");
        System.out.println("INITIAL_BOT = 0b" + fill64(Long.toBinaryString(Bits.INITIAL_BOT)));
        System.out.println("INITIAL_TOP = 0b" + fill64(Long.toBinaryString(Bits.INITIAL_TOP)));
        System.out.println("TOP_ROW     = 0b" + fill64(Long.toBinaryString(Bits.TOP_ROW)));
        System.out.println("BOTTOM_ROW  = 0b" + fill64(Long.toBinaryString(Bits.BOTTOM_ROW)));
        System.out.println("LEFT_COL    = 0b" + fill64(Long.toBinaryString(Bits.LEFT_COL)));
        System.out.println("RIGHT_COL   = 0b" + fill64(Long.toBinaryString(Bits.RIGHT_COL)));
        System.out.println("DIAGONAL    = 0b" + fill64(Long.toBinaryString(Bits.DIAGONAL)));
        System.out.println("ON_BOARD    = 0b" + fill64(Long.toBinaryString(Bits.ON_BOARD)));
        System.out.println("CENTER      = 0b" + fill64(Long.toBinaryString(Bits.CENTER)));
    }

    public void constantInDecimal() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Displays in DECIMAL ");
        System.out.println("INITIAL_BOT = "+Bits.INITIAL_BOT+"L");
        System.out.println("INITIAL_TOP = "+Bits.INITIAL_TOP+"L");
        System.out.println("TOP_ROW     = "+Bits.TOP_ROW+"L");
        System.out.println("BOTTOM_ROW  = "+Bits.BOTTOM_ROW+"L");
        System.out.println("LEFT_COL    = "+Bits.LEFT_COL+"L");
        System.out.println("RIGHT_COL   = "+Bits.RIGHT_COL+"L");
        System.out.println("DIAGONAL    = "+Bits.DIAGONAL+"L");
        System.out.println("ON_BOARD    = "+Bits.ON_BOARD+"L");
        System.out.println("CENTER      = "+Bits.CENTER+"L");
	}

	public static void main(String [ ] args) {
		
		RunBitBoardPosition run = new RunBitBoardPosition();
		run.constantInBinary();
		run.boardNumbers();
        run.constantInDecimal();

	}


}
