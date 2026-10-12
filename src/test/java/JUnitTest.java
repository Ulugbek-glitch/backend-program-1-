import org.junit.jupiter.api.*;

public class JUnitTest {

    @DisplayName("1+2는 3이다.")
    @Test
    public void junitTest1() {

        int a = 1;
        int b = 2;
        int sum = 3;

        int result = a + b;

        System.out.println("1+2는 3이다");
        Assertions.assertEquals(sum , result);
    }

    @Test
    @DisplayName("1+2는 3이다.")
    public void junitTest2() {

        int a = 1; int b = 3;
        int result = a + b;

        System.out.println("1+2는 3이다");
        Assertions.assertEquals(3, result);
    }

    @BeforeEach
    public void prepare() {
        System.out.println("준비");
    }

    @AfterEach
    public void wash() {
        System.out.println("설겆이");
    }

    @BeforeAll
    public static void prepareAll() {
        System.out.println("최초 준비");
    }

    @AfterAll
    public static void cleanupAll() {
        System.out.println("최종마무리");
    }
}
