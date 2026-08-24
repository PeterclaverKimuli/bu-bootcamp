import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeAnalyzerTest {
    @Test
    public void calculateAverage_returnsZero_whenListIsEmpty() {
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_returnsCorrectAverage_forTypicalScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_returnsCorrectAverage_forTenScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(87, 92, 76, 84, 95, 68, 90, 73, 88, 81));
        assertEquals(83.4, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_returnsSingleValue_whenListHasOneItem() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75));
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_returnsDouble_notInteger() {
        // 1 + 2 = 3, divided by 2 = 1.5, not 1
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2));
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_handlesAllSameValues() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88));
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void getLetterGrade_returnsB_forScoreOf89() {
        assertEquals("B", GradeAnalyzer.getLetterGrade(89));
    }

    @Test
    public void getLetterGrade_returnsA_forScoreOf90() {
        assertEquals("A", GradeAnalyzer.getLetterGrade(90));
    }

    @Test
    public void getLetterGrade_returnsC_forScoreOf79() {
        assertEquals("C", GradeAnalyzer.getLetterGrade(79));
    }

    @Test
    public void getLetterGrade_returnsB_forScoreOf80() {
        assertEquals("B", GradeAnalyzer.getLetterGrade(80));
    }

    @Test
    public void getLetterGrade_returnsD_forScoreOf69() {
        assertEquals("D", GradeAnalyzer.getLetterGrade(69));
    }

    @Test
    public void getLetterGrade_returnsC_forScoreOf70() {
        assertEquals("C", GradeAnalyzer.getLetterGrade(70));
    }

    @Test
    public void getLetterGrade_returnsF_forScoreOf59() {
        assertEquals("F", GradeAnalyzer.getLetterGrade(59));
    }

    @Test
    public void getLetterGrade_returnsD_forScoreOf60() {
        assertEquals("D", GradeAnalyzer.getLetterGrade(60));
    }
}
