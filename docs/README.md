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

### Scenarios

[MG-INITIAL_TOP](MG-INITIAL_TOP.md)
