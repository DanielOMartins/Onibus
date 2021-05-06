import java.util.Scanner;

public class Onibus {
    private int n;
    private int x, y, bilhete;
    private int pessoas = 0;
    private int voltas = 0;
    private int normal = 0;
    private int estudante = 0;
    private int idoso = 0;
    private int total = 0;

    Scanner ler = new Scanner(System.in);
    Scanner ler2 = new Scanner(System.in);

    //inicia as informações do ônibus
    public void iniciarOnibus() {
        System.out.printf("Quantidade de pessoas sentadas: ");
        x = ler.nextInt();
        System.out.printf("Quantidade de pessoas em pé: ");
        y = ler.nextInt();
        System.out.printf("Quantidade de pontos: ");
        n = ler.nextInt();

        System.out.printf("O ônibus tem capacidade máxima para %d pessoas sentadas mais %d pessoas em pé. e percorre uma linha com %d pontos.\n", x, y, n);
        total = x + y;

        for(int i = 1; i <= n; i++){
            System.out.println("\n***************************************");
            System.out.println("1 - Entrar passageiro.");
            System.out.println("2 - Remover passageiro.");
            System.out.println("3 - Pedir para descer.");
            System.out.printf("O que deseja fazer na proxima parada: ");
            int opcao = ler2.nextInt();

            if(opcao == 1){
                System.out.printf("\nQual o bilhete do passageiro (1 - normal, 2 - estudante, 3 - idoso): ");
                bilhete = ler2.nextInt();
                if (bilhete == 1) {
                    normal = contarTipoBilhete(bilhete, normal, estudante, idoso, total, pessoas);
                }
                if (bilhete == 2) {
                    estudante = contarTipoBilhete(bilhete, normal, estudante, idoso, total, pessoas);
                }
                if (bilhete == 3) {
                    idoso = contarTipoBilhete(bilhete, normal, estudante, idoso, total, pessoas);
                }

                pessoas = entrar(x, pessoas, total);
                System.out.println("***************************************\n");
                voltas = numeroViagens(n, i, voltas); 
            }
            if(opcao == 2){
                pessoas = sair(total, pessoas);
                System.out.println("***************************************\n");
                voltas = numeroViagens(n, i, voltas);
            }
            if(opcao == 3){
                pessoas = pedirDescer(y, x, pessoas);
                System.out.println("***************************************\n");
                voltas = numeroViagens(n, i, voltas);
            }
            if(voltas == 8){
                break;
            }else{
                if(i == n){
                    i = 0 ;
                }
            }
        }
    }

    //Adiciona um passageiro
    public int entrar(int x, int p, int total) {
        if(p < total){
            p++;
            if (p <= x) {
                System.out.println("Todos estão sentados por enquanto: "+ p);
            }else{
                System.out.printf("Assentos lotados, agora %d pessoas estão em pé\n", (p - x));
            }
            System.out.println("Total de pessoas: " + p);
        }

        return p;
    }

    //Remove um passageiro
    public int sair(int total, int p) {
        if(p != 0){
            p--;
            if(p > (total - y)){
                System.out.printf("Assentos lotados, agora %d pessoas estão em pé\n", p);                
            }else{
                System.out.println("\nQuantidade de pessoas sentadas: " + p);
            }
            System.out.println("Total de pessoas: " + p);
        }else{
            System.out.println("O ônibus está vazio!!");
        }
        return p;
    }

    //Conta os tipos de bilhetes utilizados
    public int contarTipoBilhete(int b, int normal, int estu, int idoso, int total, int p) {
        if(p < total){
            if(b == 1){
                normal++;
                System.out.println("\nBilhete normal: " + normal);
                return normal;
            }
            if(b == 2){
                estu++;
                System.out.println("\nBilhetes de estudante: " + estu);
                return estudante;
            }
            if(b == 3){
                idoso++;
                System.out.println("\nBilhetes de idoso: " + idoso);
                return idoso;
            }
        }else{
            System.out.println("\nO ônibus está lotado!!");
        }
        return 0;
    }

    //Um passageiro pede para descer do ônibus
    public int pedirDescer(int y, int x, int p) {
        System.out.println("\nUm passageiro deseja descer do ônibus.");
        int pessoas = sair(total, p);

        return pessoas;
    }

    //Conta quantas voltas o ônibus completou do percurso todo
    public int numeroViagens(int n, int ponto, int voltas) {
        if(ponto == n){
            voltas++;
            System.out.println("Voltas completas: " + voltas);
        }
        return voltas;
    }
}
