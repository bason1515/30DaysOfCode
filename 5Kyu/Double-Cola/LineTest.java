import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTest {
    @Test
    public void test1() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 1;
        assertEquals("Sheldon", Line.WhoIsNext(names, n));
    }
    @Test
    public void test2() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 6;
        assertEquals("Sheldon", Line.WhoIsNext(names, n));
    }
    @Test
    public void test3() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 16;
        assertEquals("Sheldon", Line.WhoIsNext(names, n));
    }
    @Test
    public void ShouldBeHoward() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 5;
        assertEquals("Howard", Line.WhoIsNext(names, n));
    }
    @Test
    public void ShouldBeLastHoward() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 75;
        assertEquals("Howard", Line.WhoIsNext(names, n));
    }
    @Test
    public void ShouldBeFirstSheldonOutOf() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 75;
        assertEquals("Howard", Line.WhoIsNext(names, n));
    }
    @Test
    public void BigN() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 163839;
        assertEquals("Sheldon", Line.WhoIsNext(names, n));
    }
    @Test
    public void every4thShouldBeDifferent() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 16;
        assertEquals("Sheldon", Line.WhoIsNext(names, n));
        n = 20;
        assertEquals("Leonard", Line.WhoIsNext(names, n));
        n = 24;
        assertEquals("Penny", Line.WhoIsNext(names, n));
        n = 28;
        assertEquals("Rajesh", Line.WhoIsNext(names, n));
        n = 32;
        assertEquals("Howard", Line.WhoIsNext(names, n));
    }
    @Test
    public void every8thShouldBeDifferent() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 36;
        assertEquals("Sheldon", Line.WhoIsNext(names, n));
        n = 44;
        assertEquals("Leonard", Line.WhoIsNext(names, n));
        n = 52;
        assertEquals("Penny", Line.WhoIsNext(names, n));
        n = 60;
        assertEquals("Rajesh", Line.WhoIsNext(names, n));
        n = 68;
        assertEquals("Howard", Line.WhoIsNext(names, n));
    }
    @Test
    public void shouldBe8Penny() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 52;
        for (; n < 60; n++) {
            assertEquals("Penny", Line.WhoIsNext(names, n));
        }
    }
}