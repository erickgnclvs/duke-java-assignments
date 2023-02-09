import edu.duke.*;

public class Part1
{
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna, int index) {
        int startIndex = dna.indexOf("ATG", index);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex;
        if (taaIndex != -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex+3);
    }

    public void processGenes(StorageResource sr) {
        int noLongerThanNine = 0;
        int higherCGRatio = 0;
        int longerThanSixty = 0;
        int geneCounter = 0;
        System.out.println("All genes: ");

        for (String gene : sr.data()) {
            System.out.println(gene);
            geneCounter++;
            if (gene.length() <= 9) {
                System.out.println("No longer than 9: " + gene);
                System.out.println("CTG codons count = " + countCTG(gene));
                int percentage = (int) (cgRatio(gene) * 100);
                System.out.println("CG Ratio: " + percentage + "%");
                System.out.println("CTG codons count = " + countCTG(gene));
                noLongerThanNine++;
            }
            if (gene.length() > 60) {
                System.out.println("Longer than 60: " + gene);
                System.out.println("CTG codons count = " + countCTG(gene));
                int percentage = (int) (cgRatio(gene) * 100);
                System.out.println("CG Ratio: " + percentage + "%");
                System.out.println("CTG codons count = " + countCTG(gene));
                longerThanSixty++;
            }
            if (cgRatio(gene) > 0.35) {
                System.out.println("CG Ratio higher than 35% :" + gene);
                int percentage = (int) (cgRatio(gene) * 100);
                System.out.println("CG Ratio: " + percentage + "%");
                System.out.println("CTG codons count = " + countCTG(gene));
                higherCGRatio++;
            }

        }
        System.out.println("Number of genes = " + geneCounter);
        System.out.println("Number of genes that are no longer than 9 = " + noLongerThanNine);
        System.out.println("Number of genes that are longer than 60 = " + longerThanSixty);
        System.out.println("Number of genes whose CG Ratio is higher than 35% = " + higherCGRatio);
    }

    public void testProcessGenes() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        StorageResource sr = new StorageResource();
        sr.add(dna);
        processGenes(sr);
    }

    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }

    public float cgRatio(String dna) {
        int counter = 0;
        int startIndex = 0;
        String lowerDna = dna.toLowerCase();

        while (true) {
            int currentIndex = lowerDna.indexOf("c", startIndex);
            if (currentIndex == -1) {
                break;
            }
            startIndex = currentIndex + 1;
            counter++;
        }

        startIndex = 0;
        while (true) {
            int currentIndex = lowerDna.indexOf("g", startIndex);
            if (currentIndex == -1) {
                break;
            }
            startIndex = currentIndex + 1;
            counter++;
        }

        float result = (float) counter/dna.length();
        return result;
    }

    public int countCTG(String dna) {
        int counter = 0;
        int startIndex = 0;
        String lowerDna = dna.toLowerCase();
        while (true) {
            int currentIndex = lowerDna.indexOf("ctg", startIndex);
            if (currentIndex == -1) {
                break;
            }
            startIndex = currentIndex + 3;
            counter++;
        }
        return counter;
    }

    public void testOn(String dna) {
        System.out.println("testing getAllGenes on " + dna + ":\n");
        StorageResource genes = getAllGenes(dna);
        for (String g : genes.data()) {
            System.out.println("gene found = " + g);
            System.out.printf("cg ratio of %s = %s%n", g, cgRatio(g));
            System.out.println("number of CTG codons = " + countCTG(g));
            System.out.println("\n");
        }
    }

    public void test() {
        String dna = "GTTAATGCTGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        testOn(dna);
    }
    
    public static void main(String[] args) {
        Part1 object = new Part1();
        object.testProcessGenes();
    }
}
