import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Long.MAX_VALUE;

public class Main {
    public static void main(String[] args) {

        /* Création d’un tableau
        Il y a deux possibilités lorsque l’on souhaite créer un tableau :
            — Soit on connaît sa taille ;
            — Soit on connaît tous ses éléments.
        Il faut alors utiliser une des deux instructions suivantes :

        int[] tableau = new int[100];
        char[] lettres = {’a’, ’b’, ’c’};
        */


            /* Comparaison des algorithmes de tri */
        Instant start = Instant.now();
        // Des instructions qui peuvent prendre du temps
        Instant end = Instant.now();
        // duration va donc contenir, en ms, la duree ecoulee entre end et start
        long duration = Duration.between(start, end).toMillis();
        //System.out.println(duration);


            /* Création d’un grand tableau d’entiers */
        // MAX_VALUE = récupère la plus grande valeur qu’il est possible de stocker dans une variable de type int
        //int SIZE = (int) MAX_VALUE / 1000;
        int SIZE = 100000;
        int[] tableau = new int[SIZE];


            /* Initialisation du tableau avec des valeurs aléatoires */
        System.out.println("*** Génération du tableau ***");
        initialiserTableau(tableau);
        //System.out.println(Arrays.toString(tableau));
        System.out.println("*** Fin Génération du tableau ***\n");


            /* Création des copies du tableau initial */
        //int[] tableauSelection = new int[SIZE];
        // arraycopy(src, startIndex, dest, startIndex, size)
        //System.arraycopy(tableau, 0, tableauSelection, 0, SIZE);
        //System.out.println(Arrays.toString(tableauSelection));


            /* Tri par sélection */
        int[] tbllTriSelection = new int[SIZE];
        System.arraycopy(tableau, 0, tbllTriSelection, 0, SIZE);
        //int[] res1 = triSelection(tbllTriSelection);
        //System.out.println(Arrays.toString(res1));


            /* Tri par insertion */
        int[] tbllTriInsertion = new int[SIZE];
        System.arraycopy(tableau, 0, tbllTriInsertion, 0, SIZE);
        //int[] res2 = triInsertion(tbllTriInsertion);
        //System.out.println(Arrays.toString(res2));


            /* Tri à bulles */
        int[] tbllTriBulles = new int[SIZE];
        System.arraycopy(tableau, 0, tbllTriBulles, 0, SIZE);
        //int[] res3 = triBulles(tbllTriBulles);
        //System.out.println(Arrays.toString(res3));

            /* Trie quick sort 1 */
        int[] tblQuickSort = new int[SIZE];
        System.arraycopy(tableau, 0, tblQuickSort, 0, SIZE);
        int[] res4 = triQuickSort(tblQuickSort, 50, 49);
        //System.out.println(Arrays.toString(res4));

            /* Tri natif de Java */
        int[] tblJava = new int[SIZE];
        System.arraycopy(tableau, 0, tblJava, 0, SIZE);
        //int[] res5 = triJava(tblJava);
        //System.out.println(Arrays.toString(res5));


    }



    public static void initialiserTableau(int[] tableau) {
        int SIZE = tableau.length;
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
    }


    public static int[] triSelection(int[] tableau) {
        System.out.println("*** Tri par selection ***");
        System.out.println("Complexité algorithmique du tri par sélection : " +
                "T(n) = 3n(n + (n − 1) + · · · + 1) = O(n^2)");
        // Début du temps de calcul
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        // Tri par selection
        for (int i = 0 ; i < tableau.length ; i++) {
            int indiceMin = i ;
            for (int j = i ; j < tableau.length ; j++) {
                if (tableau[j] < tableau[indiceMin]) {
                    indiceMin = j ;
                }
            }
            int swap = tableau[i] ;
            tableau[i] = tableau[indiceMin] ;
            tableau[indiceMin] = swap ;
            }
        // Fin du temps de calcul
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
        System.out.println("*** Fin tri par selection ***\n");
        return tableau;
    }


    public static int[] triInsertion(int[] tableau) {
        System.out.println("*** Tri par insertion ***");
        System.out.println("Complexité algorithmique du tri par insertion : " +
                "T(n) = 3n(n + (n − 1) + · · · + 1) = O(n^2)");
        // Début du temps de calcul
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        // Tri par intsertion
        for (int i = 0 ; i < tableau.length ; i++){
            int elementATrier = tableau[i] ;
            int j = i ;
            while (j > 0 && tableau[j-1] > elementATrier){
                tableau[j] = tableau[j-1] ;
                j-- ;
            }
            tableau[j] = elementATrier ;
        }
        // Fin du temps de calcul
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
        System.out.println("*** Fin tri par insertion ***\n");
        return tableau;
    }


    public static int[] triBulles(int[] tableau) {
        System.out.println("*** Tri à bulles ***");
        System.out.println("Complexité algorithmique du tri par insertion : " +
                "???");
        // Début du temps de calcul
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        // Tri à bulles
        boolean estTrie = false;
        while (!estTrie) {
            estTrie = true;
            for (int i = 1; i < tableau.length; i++) {
                if (tableau[i - 1] > tableau[i]) {
                    int swap = tableau[i - 1];
                    tableau[i - 1] = tableau[i];
                    tableau[i] = swap;
                    estTrie = false;
                }
            }
        }
        // Fin du temps de calcul
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
        System.out.println("*** Fin tri à bulles ***\n");
        return tableau;
    }



    public static int[] triQuickSort(int[] tableau, int indiceGauche, int indiceDroit) {
        System.out.println("*** Tri Quick sort ***");
        System.out.println("Complexité algorithmique du tri par insertion : " +
                "???");
        // Début du temps de calcul
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        // Tri Quick sort
        quicksort(tableau, 0, 50);
        // Fin du temps de calcul
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
        System.out.println("*** Fin tri Quick sort ***\n");
        return tableau;
    }

    public static void quicksort(int[] tableau, int indiceGauche, int indiceDroit) {
        if (indiceGauche < indiceDroit) {
            int indicePartition = partition(tableau, indiceGauche, indiceDroit);
            quicksort(tableau, indiceGauche, indicePartition);
            quicksort(tableau, indicePartition + 1, indiceDroit);
        }
    }


    public static int partition(int[] tableau, int indiceGauche, int indiceDroit) {
        int elementPivot = tableau[indiceGauche + (indiceDroit - indiceGauche) / 2];
        int left = indiceGauche - 1;
        int right = indiceDroit + 1;
        while (true) {
            do {
                left++;
            } while (tableau[left] < elementPivot);
            do {
                right--;
            } while (tableau[right] > elementPivot);
            if (left >= right) {
                return right;
            }
            int tmp = tableau[left];
            tableau[left] = tableau[right];
            tableau[right] = tmp;
        }
    }


    public static int[] triJava(int[] tableau) {
        System.out.println("*** Tri Java ***");
        System.out.println("Complexité algorithmique du tri par insertion : " +
                "???");
        // Début du temps de calcul
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        // Tri Java
        Arrays.sort(tableau);
        // Fin du temps de calcul
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
        System.out.println("*** Fin tri Java ***\n");
        return tableau;
    }
}