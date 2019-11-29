package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;

    //Permet de donner le Given commun à toutes les méthodes

    @Before
    public void setUp() throws Exception {
        //Given : Une instance QuestionAChoixMultiple
        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(1);
        indices.add(3);
        question = new QuestionAChoixMultiple("Un énoncé", indices, 5);
    }

    @Test
    public void getEnonce() {
        //When On demande son énoncé à la question
        String repEnonce = question.getEnonce();

        //Then L'énoncé retourné est l'énoncé fourni à la construction de l'objet
        assertEquals("Un énoncé", repEnonce);
    }

    @Test
    public void getScoreForIndiceBonneReponse() {
        //When quand l'étudiant fourni l'indice d'une bonne réponse
        int indiceEtudiant = 1;
        //et que on demande le score de l'indice à la question
        float score = question.getScoreForIndice(indiceEtudiant);

        //Then Le score obtenu est 50
        assertEquals(50, score, 0.01f);
    }

    @Test
    public void getScoreForIndiceEchec() {
        //When quand l'étudiant fourni l'indice d'une mauvaise réponse
        int indiceEtudiant = 0;
        //et que on demande le score de l'indice à la question
        float score = question.getScoreForIndice(indiceEtudiant);

        //Then Le score obtenu est -33,33
        assertEquals(-33.33f, score, 0.01f);
    }
}