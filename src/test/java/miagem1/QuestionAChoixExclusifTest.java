package miagem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {

    private QuestionAChoixExclusif question;

    //Permet de donner le Given commun à toutes les méthodes
    @Before
    public void setUp() throws Exception {
        //Given : Une instance QuestionAChoixExclusif
        question = new QuestionAChoixExclusif("Un énoncé", 2);
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
        //When quand l'étudiant fourni l'indice de la bonne réponse
        int indiceEtudiant = 2;
        //et que on demande le score de l'indice à la question
        float score = question.getScoreForIndice(indiceEtudiant);

        //Then Le score obtenu est 100
        assertEquals(100, score, 0.01f);
    }

    @Test
    public void getScoreForIndiceMauvaiseReponse() {
        //When quand l'étudiant fourni l'indice d'une mauvaise réponse
        int indiceEtudiant = 1;
        //et que on demande le score de l'indice à la question
        float score = question.getScoreForIndice(indiceEtudiant);

        //Then Le score obtenu est 0
        assertEquals(0f, score, 0.01f);
    }
}