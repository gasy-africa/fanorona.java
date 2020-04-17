package logic.board;

// Game of Fanorona
// David Eppstein, UC Irvine, 11 Jun 1997
//
// Bit manipulation
//
// We represent Fanorona positions using two bitboards (64-bit longs)
// one for the pieces of each player.  The bits in the bitboard form
// six 10-bit groups: an empty group followed by one for each row of the board.
// Each row has an empty bit followed by a bit for each position in the row.
// The empty bits help avoid extra range checking while finding captures.
//
// The top four bits are free for other purposes; we use one
// to determine which color pieces are on each side, and one to determine
// whether the side on move's most recent move was a capture.
//
// This class is not instantiable; instead it consists of constants
// for various board configurations, used in game setup, move generation,
// and evaluation.

// The original version presented the Bit Constants in Octal then decimal
// the following is a binary representation which helps avoiding scratching too much head

public abstract class Bits {
    public static final long IS_WHITE    = 0b0100000000000000000000000000000000000000000000000000000000000000L; // 1L << 62
    public static final long CAPTURED    = 0b1000000000000000000000000000000000000000000000000000000000000000L; // 1L << 63; sign
                                                                                                                // bit speeds
                                                                                                                // tests
    // BINARY Annotation
    // 5 rows (numbers) 9 columns (letters)
    // C(capt) W(White) x, numbers(Empty)    CWxxxxxxxxxxxx5abcdefghi4abcdefghi3abcdefghi2abcdefghi1abcdefghi
	public static final long INITIAL_BOT = 0b0000000000000000000000000000000000001010010101111111110111111111L;
	public static final long INITIAL_TOP = 0b0000000000000001111111110111111111010100101000000000000000000000L;
	public static final long TOP_ROW     = 0b0000000000000001111111110000000000000000000000000000000000000000L;
	public static final long BOTTOM_ROW  = 0b0000000000000000000000000000000000000000000000000000000111111111L;
	public static final long LEFT_COL    = 0b0000000000000001000000000100000000010000000001000000000100000000L;
	public static final long RIGHT_COL   = 0b0000000000000000000000010000000001000000000100000000010000000001L;
	public static final long DIAGONAL    = 0b0000000000000001010101010010101010010101010100101010100101010101L;
	public static final long ON_BOARD    = 0b0000000000000001111111110111111111011111111101111111110111111111L;
	public static final long CENTER      = 0b0000000000000000000000000000000000000111110000000000000000000000L;

	// Fanorona Board
	// 4 control bits (1st bit is used for capture, 2nd bit for Color - White and Black)
    // 60 bits board representation
    //
	//	C	W	x	x
    //	~	a	b	c	d	e	f	g	h	i <- (Empty Row - Representing the board letters - filled with 0)
    //	5	1	0	1	0	1	0	1	0	1
    //	4	0	1	0	1	0	1	0	1	0
    //	3	1	0	1	0	1	0	1	0	1
    //	2	0	1	0	1	0	1	0	1	0
    //	1	1	0	1	0	1	0	1	0	1
    //  ^
    //  | (Empty Column - Representing the board numbers - filled with 0)

	// turn screen coordinates into bit position
	public static long at(int row, int col) {
		return 1L << (10 * (4 - row)) + (8 - col);
	}

	// isolate one of the bits from a bitboard
	public static long lastBit(long bitboard) {
		return bitboard & -bitboard;
	}

	// how much to shift from coordinates
	public static final int SHIFT_VERTICAL = 10;
	public static final int SHIFT_HORIZONTAL = 1;
	public static final int SHIFT_SLANT = 11;
	public static final int SHIFT_BACKSLANT = 9;

	// count number of set bits in a word
	static final long ONES = 0x5555555555555555L; // A series of 0101 0101 0101 on all 64 bits
	static final long TWOS = 0x3333333333333333L; // A series of 0011 0011 0011 on all 64 bits
	static final int FOURS = 0x0f0f0f0f; // A series 0f 0000 1111 0000 1111 on only last 32 bits

	public static int count(long set) {
		set -= (set >>> 1) & ONES;
		set = (set & TWOS) + ((set >>> 2) & TWOS);
		int result = (int) set + (int) (set >>> 32);
		return (((result & FOURS) + ((result >>> 4) & FOURS)) * 0x01010101) >>> 24;
	}
}