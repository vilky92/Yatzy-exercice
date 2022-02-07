import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy.chance((byte)2, (byte)3, (byte)4, (byte)5, (byte)1);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance((byte) 3, (byte)3, (byte)4, (byte)5, (byte)1));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy((byte)4, (byte)4, (byte)4, (byte)4, (byte)4);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy((byte)6, (byte)6, (byte)6, (byte)6, (byte)6));
        assertEquals(0, Yatzy.yatzy((byte)6, (byte)6, (byte)6, (byte)6, (byte)3));
    }

    @Test public void test_1s() {
        assertTrue(Yatzy.ones((byte)1, (byte)2, (byte)3, (byte)4, (byte)5) == (byte)1);
        assertEquals(2, Yatzy.ones((byte)1, (byte)2, (byte)1, (byte)4, (byte)5));
        assertEquals(0, Yatzy.ones((byte)6, (byte)2, (byte)2, (byte)4, (byte)5));
        assertEquals(4, Yatzy.ones((byte)1, (byte)2, (byte)1, (byte)1, (byte)1));
    }

    @Test
    public void test_2s() {
        assertEquals(4, Yatzy.twos((byte)1, (byte)2, (byte)3, (byte)2, (byte)6));
        assertEquals(10, Yatzy.twos((byte)2, (byte)2, (byte)2, (byte)2, (byte)2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.threes((byte)1, (byte)2, (byte)3, (byte)2, (byte)3));
        assertEquals(12, Yatzy.threes((byte)2, (byte)3, (byte)3, (byte)3, (byte)3));
    }

    @Test
    public void fours_test() 
    {
        assertTrue(Yatzy.fours((byte)1, (byte)2, (byte)3, (byte)4, (byte)5) == (byte)4);
        assertEquals(12, Yatzy.fours((byte)4, (byte)4, (byte)4, (byte)5, (byte)5));
        assertEquals(8, Yatzy.fours((byte)4, (byte)4, (byte)5, (byte)5, (byte)5));
        assertEquals(4, Yatzy.fours((byte)4, (byte)5, (byte)5, (byte)5, (byte)5));
    }

    @Test
    public void fives() {
        assertTrue(Yatzy.fives((byte)1, (byte)2, (byte)3, (byte)4, (byte)5) == (byte)5);
        assertEquals(10, Yatzy.fives((byte)4, (byte)4, (byte)4, (byte)5, (byte)5));
        assertEquals(15, Yatzy.fives((byte)4, (byte)4, (byte)5, (byte)5, (byte)5));
        assertEquals(20, Yatzy.fives((byte)4, (byte)5, (byte)5, (byte)5, (byte)5));

    }

    @Test
    public void sixes_test() {
        assertTrue(Yatzy.sixes((byte)6, (byte)2, (byte)3, (byte)4, (byte)5) == (byte)6);
        assertEquals(0, Yatzy.sixes((byte)4, (byte)4, (byte)4, (byte)5, (byte)5));
        assertEquals(6, Yatzy.sixes((byte)4, (byte)4, (byte)6, (byte)5, (byte)5));
        assertEquals(18, Yatzy.sixes((byte)6, (byte)5, (byte)6, (byte)6, (byte)5));
    }
    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.score_pair(3,4,3,5,6));
        assertEquals(10, Yatzy.score_pair(5,3,3,3,5));
        assertEquals(12, Yatzy.score_pair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.two_pair(3,3,5,4,5));
        assertEquals(16, Yatzy.two_pair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, Yatzy.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
