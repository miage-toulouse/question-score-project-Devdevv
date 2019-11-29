package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple questionAChoixMultiple;
    private ScoreCalculateur scorecalc;
    @Before
    public void setUp() throws Exception {
        //Given : Une instance QuestionAChoixMultiple et de ScoreCalculateur
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)), 5);
        scorecalc = new ScoreCalculateur();
    }

    @Test
    public void calculeScore0Point() {
        // When Quand un élève donne une liste de mauvaise réponse
        ArrayList reponses = new ArrayList<Integer>(Arrays.asList(1,4));
        // et que on demande le score totale
        float score = scorecalc.calculeScore(reponses, questionAChoixMultiple);

        //Then Le score obtenu est 0.
        assertEquals(0 , score, 0.01f);
    }

    @Test
    public void calculeScore66Points() {
        // When Quand un élève donne une liste de deux bonne réponse sur 3
        ArrayList reponses = new ArrayList<Integer>(Arrays.asList(2,3));
        // et que on demande le score totale
        float score = scorecalc.calculeScore(reponses, questionAChoixMultiple);

        //Then Le score obtenu est environ 66,66
        assertEquals( 2f*100f/3f, score, 0.01f);

    }

    @Test
    public void calculeScore100Points() {
        // When Quand un élève donne une liste avec toutes les bonnes réponses
        ArrayList reponses = new ArrayList<Integer>(Arrays.asList(2,3,5));
        // et que on demande le score totale
        float score = scorecalc.calculeScore(reponses, questionAChoixMultiple);

        //Then Le score obtenu est 100.
        assertEquals(100 , score, 0.01f);
    }

    @Test
    public void calculeScore0PointNegatif() {
        // When Quand un élève donne une liste avec toutes les réponses
        ArrayList reponses = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        // et que on demande le score totale
        float score = scorecalc.calculeScore(reponses, questionAChoixMultiple);

        //Then Le score obtenu est 0.
        assertEquals(0 , score, 0.01f);
    }

    @Test
    public void calculeScore16Points() {
        // When Quand un élève donne une liste avec 2 bonnes réponses et une mauvaise
        ArrayList reponses = new ArrayList<Integer>(Arrays.asList(1,2,3));
        // et que on demande le score totale
        float score = scorecalc.calculeScore(reponses, questionAChoixMultiple);

        //Then Le score obtenu est 16.66.
        assertEquals(16.66 , score, 0.01f);
    }
}