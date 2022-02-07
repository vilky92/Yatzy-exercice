import java.util.Arrays;

public class Yatzy {
	
	
    protected byte[] dice;
    public Yatzy(byte d1, byte d2, byte d3, byte d4, byte _5)
    {
        dice = new byte[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

	//@param byte
	// this function return the sum of all dices
	//@return byte
    public static byte chance(byte d1, byte d2, byte d3, byte d4, byte d5)
    {
        return (byte) (d1 + d2 + d3 + d4 + d5);
    }

    //@param Byte...
    // return 50 only if all dices in the List of dice is equals else return 0
    // return byte
    public static byte yatzy(Byte... dice)
    {
        for(int i = 1; i < dice.length; i++)
        {
            if(Arrays.stream(dice).allMatch(s -> s.equals(dice[0])))
                return (byte) 50;
        }

        return (byte) 0;
    }
    
    //@param Byte...
    // return the number of 1 present in the dice
    // return byte
    public static int ones(Byte... dice) {
    	byte sum = 0;
    	for (byte i = 0; i < dice.length ; i++) {
    		if (dice[i] == 1) sum++;
    	}
        return sum;
    }

    //@param Byte...
    // return the number of 2 present in the dice
    // return byte
    public static byte twos(Byte... dice) {
    	byte sum = 0;
    	for (byte i = 0; i < dice.length ; i++) {
    		if (dice[i] == 2) sum+=2;
    	}
        return sum;
    }

    //@param Byte...
    // return the number of 3 present in the dice
    // return byte
    public static int threes(Byte... dice) {
    	byte sum = 0;
    	for (byte i = 0; i < dice.length ; i++) {
    		if (dice[i] == 3) sum+=3;
    	}
        return sum;
    }


    //@param Byte...
    // return the number of 4 present in the dice
    // return byte
    public static byte fours(Byte... dice)
    {
    	byte sum = 0;
    	for (byte i = 0; i < dice.length ; i++) {
    		if (dice[i] == 4) sum+=4;
    	}
        return sum;
    }

    //@param Byte...
    // return the number of 5 present in the dice
    // return byte
    public static byte fives(Byte... dice)
    {
    	byte sum = 0;
    	for (byte i = 0; i < dice.length ; i++) {
    		if (dice[i] == 5) sum+=5;
    	}
        return sum;
    }

    //@param Byte...
    // return the number of 6 present in the dice
    // return byte
    public static byte sixes(Byte... dice)
    {
    	byte sum = 0;
    	for (byte i = 0; i < dice.length ; i++) {
    		if (dice[i] == 6) sum+=6;
    	}
        return sum;
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



