# Move Generator Analysis


```java
// what kind of move is represented by the bits in set
int captureType;
static final int CAPTURE_FORWARD = 0;
static final int CAPTURE_BACKWARD = 1;
static final int NO_CAPTURE = 2;
static final int PASS = 3;
static final int NO_MORE_MOVES = 4;
```


```java
// how much to shift from coordinates
public static final int SHIFT_VERTICAL = 10;
public static final int SHIFT_HORIZONTAL = 1;
public static final int SHIFT_SLANT = 11;
public static final int SHIFT_BACKSLANT = 9;
```

### :o: Setup

The full board is displayed below, the white pieces are displayed at the bottom which is considered the INITIAL_TOP and the black pieces at the top which is considered the INITIAL_BOTTOM

|:vs:    |`a`| `b`| `c`| `d`| `e`| `f`| `g`| `h`| `i`| Comments |
|--------|-|--|--|--|--|--|--|--|--|----------|
|:five:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:| INITIAL_BOTTOM |
|:four:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|:black_circle:|                |
|:three:|:black_circle:|:white_circle:|:black_circle:|:white_circle:||:black_circle:|:white_circle:|:black_circle:|:white_circle:|                 |
|:two:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|  INITIAL_TOP  |
|:one:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|:white_circle:|             |

In a programmatical point of view, the entire board is contained in a single 64-bit long. 

```java
// BINARY Annotation
// 5 rows (numbers) 9 columns (letters)
// C(capt) W(White) x, numbers(Empty)    CWxxxxxxxxxxxx5abcdefghi4abcdefghi3abcdefghi2abcdefghi1abcdefghi
public static final long INITIAL_BOT = 0b0000000000000000000000000000000000001010010101111111110111111111L;
public static final long INITIAL_TOP = 0b0000000000000001111111110111111111010100101000000000000000000000L;
```

The `Bits.java` source code has been rewritten using [binary literal](https://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html) to simplify code review.


### :a: Scenarios

##### :one: [MG-INITIAL_TOP](MG-INITIAL_TOP.md)

The game is at the beginning and the white player is the next to move.
