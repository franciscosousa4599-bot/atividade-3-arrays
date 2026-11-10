import java.util.ArrayList;
import java.util.Scanner;

public class AnaliseCursos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array fixo para armazenar as 10 cargas horárias
        int[] cargaHoraria = new int[10];

        System.out.println("=== CADASTRO DE CURSOS ===");
        
        // 1. LEITURA E VALIDAÇÃO
        for (int i = 0; i < cargaHoraria.length; i++) {
            int horas;
            do {
                System.out.print("Informe a carga horária do Curso " + (i + 1) + " (entre 1 e 400 horas): ");
                horas = scanner.nextInt();
                if (horas <= 0 || horas > 400) {
                    System.out.println("Valor inválido! A carga horária deve ser maior que 0 e menor ou igual a 400.");
                }
            } while (horas <= 0 || horas > 400);
            
            cargaHoraria[i] = horas;
        }

        // 2. LISTAGEM DOS CURSOS
        System.out.println("\n=== LISTAGEM DAS CARGAS HORÁRIAS ===");
        for (int i = 0; i < cargaHoraria.length; i++) {
            System.out.println("Curso " + (i + 1) + ": " + cargaHoraria[i] + " horas");
        }

        // 3. TOTAL E MÉDIA / 4. MAIOR E MENOR / 5. CLASSIFICAÇÃO E CURSOS LONGOS
        int totalHoras = 0;
        int maiorHoras = cargaHoraria[0];
        int posicaoMaior = 0;
        int menorHoras = cargaHoraria[0];
        int posicaoMenor = 0;

        int curtaDuracao = 0;  // < 40h
        int mediaDuracao = 0;  // 40h a 99h
        int longaDuracao = 0;  // >= 100h

        // ArrayList para guardar apenas as cargas dos cursos longos
        ArrayList<Integer> cursosLongos = new ArrayList<>();

        for (int i = 0; i < cargaHoraria.length; i++) {
            int horas = cargaHoraria[i];
            
            // Soma para o total
            totalHoras += horas;

            // Verifica o maior
            if (horas > maiorHoras) {
                maiorHoras = horas;
                posicaoMaior = i;
            }

            // Verifica o menor
            if (horas < menorHoras) {
                menorHoras = horas;
                posicaoMenor = i;
            }

            // Classificação por duração
            if (horas < 40) {
                curtaDuracao++;
            } else if (horas <= 99) {
                mediaDuracao++;
            } else {
                longaDuracao++;
                cursosLongos.add(horas);
            }
        }

        double mediaHoras = (double) totalHoras / cargaHoraria.length;

        // Exibição dos resultados acumulados
        System.out.println("\n=== TOTAL E MÉDIA ===");
        System.out.println("Total de horas: " + totalHoras + " horas");
        System.out.printf("Média de horas por curso: %.2f horas\n", mediaHoras);

        System.out.println("\n=== MAIOR E MENOR CARGA ===");
        System.out.println("Maior carga: Curso " + (posicaoMaior + 1) + " com " + maiorHoras + " horas");
        System.out.println("Menor carga: Curso " + (posicaoMenor + 1) + " com " + menorHoras + " horas");

        System.out.println("\n=== CLASSIFICAÇÃO DOS CURSOS ===");
        System.out.println("Curta duração (< 40h): " + curtaDuracao);
        System.out.println("Média duração (40h a 99h): " + mediaDuracao);
        System.out.println("Longa duração (>= 100h): " + longaDuracao);

        // Exibição da lista de cursos longos utilizando ArrayList
        System.out.println("\n=== LISTA DE CURSOS LONGOS ===");
        if (cursosLongos.isEmpty()) {
            System.out.println("Nenhum curso de longa duração.");
        } else {
            System.out.print("Cargas horárias dos cursos longos: ");
            for (int carga : cursosLongos) {
                System.out.print(carga + "h ");
            }
            System.out.println();
        }

        // 6. BUSCA POR CARGA HORÁRIA
        System.out.println("\n=== BUSCA DE CURSO ===");
        System.out.print("Digite uma carga horária para pesquisar: ");
        int cargaBusca = scanner.nextInt();

        int quantidadeEncontrada = 0;
        String numerosCursos = "";

        for (int i = 0; i < cargaHoraria.length; i++) {
            if (cargaHoraria[i] == cargaBusca) {
                quantidadeEncontrada++;
                numerosCursos += "Curso " + (i + 1) + " ";
            }
        }

        if (quantidadeEncontrada > 0) {
            System.out.println("Quantidade de cursos com " + cargaBusca + "h: " + quantidadeEncontrada);
            System.out.println("Encontrado em: " + numerosCursos);
        } else {
            System.out.println("Nenhum curso com essa carga horária.");
        }

        // 7. ORDEM INVERSA
        System.out.println("\n=== LISTAGEM EM ORDEM INVERSA ===");
        for (int i = cargaHoraria.length - 1; i >= 0; i--) {
            System.out.println("Curso " + (i + 1) + ": " + cargaHoraria[i] + " horas");
        }

        scanner.close();
    }
}