import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Data {
    
    private int dia;
    private int mes;
    private int ano;
    private Scanner teclado = new Scanner(System.in);

    public Data() {
        boolean dadosValidos = false;

        while (dadosValidos == false) {
            try {
                System.out.println("--- Digite a Data ---");
                System.out.print("Dia: ");
                int d = teclado.nextInt();
                
                System.out.print("Mês: ");
                int m = teclado.nextInt();
                
                System.out.print("Ano: ");
                int a = teclado.nextInt();

                if (verificarDataExiste(d, m, a) == true) {
                    this.dia = d;
                    this.mes = m;
                    this.ano = a;
                    dadosValidos = true;
                } else {
                    System.out.println("Essa data não existe! Tente de novo.\n");
                }
            } catch (Exception erro) { 
                System.out.println("Erro: Você deve digitar apenas números!\n");
                teclado.nextLine();
            }
        }
    }

    public Data(int d, int m, int a) {
        if (verificarDataExiste(d, m, a) == true) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        } else {
            System.out.println("Data errada! Usando 01/01/2000 como segurança.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public void entraDia(int d) {
        if (verificarDataExiste(d, this.mes, this.ano) == true) {
            this.dia = d;
        } else {
            System.out.println("Dia inválido para o mês atual!");
        }
    }

    public void entraMes(int m) {
        if (verificarDataExiste(this.dia, m, this.ano) == true) {
            this.mes = m;
        } else {
            System.out.println("Mês inválido!");
        }
    }

    public void entraAno(int a) {
        if (verificarDataExiste(this.dia, this.mes, a) == true) {
            this.ano = a;
        } else {
            System.out.println("Ano inválido!");
        }
    }

    public void entraDia() {
        boolean valido = false;
        while (valido == false) {
            try {
                System.out.print("Digite o novo dia: ");
                int d = teclado.nextInt();
                
                if (verificarDataExiste(d, this.mes, this.ano) == true) {
                    this.dia = d;
                    valido = true;
                } else {
                    System.out.println("Dia inválido! Tente de novo.");
                }
            } catch (Exception erro) {
                System.out.println("Digite apenas números!");
                teclado.nextLine();
            }
        }
    }

    public void entraMes() {
        boolean valido = false;
        while (valido == false) {
            try {
                System.out.print("Digite o novo mês: ");
                int m = teclado.nextInt();
                
                if (verificarDataExiste(this.dia, m, this.ano) == true) {
                    this.mes = m;
                    valido = true;
                } else {
                    System.out.println("Mês inválido! Tente de novo.");
                }
            } catch (Exception erro) {
                System.out.println("Digite apenas números!");
                teclado.nextLine();
            }
        }
    }

    public void entraAno() {
        boolean valido = false;
        while (valido == false) {
            try {
                System.out.print("Digite o novo ano: ");
                int a = teclado.nextInt();
                
                if (verificarDataExiste(this.dia, this.mes, a) == true) {
                    this.ano = a;
                    valido = true;
                } else {
                    System.out.println("Ano inválido! Tente de novo.");
                }
            } catch (Exception erro) {
                System.out.println("Digite apenas números!");
                teclado.nextLine();
            }
        }
    }

    public int retDia() { return this.dia; }
    public int retMes() { return this.mes; }
    public int retAno() { return this.ano; }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String nomeDoMes = "";
        
        if (this.mes == 1) nomeDoMes = "Janeiro";
        if (this.mes == 2) nomeDoMes = "Fevereiro";
        if (this.mes == 3) nomeDoMes = "Março";
        if (this.mes == 4) nomeDoMes = "Abril";
        if (this.mes == 5) nomeDoMes = "Maio";
        if (this.mes == 6) nomeDoMes = "Junho";
        if (this.mes == 7) nomeDoMes = "Julho";
        if (this.mes == 8) nomeDoMes = "Agosto";
        if (this.mes == 9) nomeDoMes = "Setembro";
        if (this.mes == 10) nomeDoMes = "Outubro";
        if (this.mes == 11) nomeDoMes = "Novembro";
        if (this.mes == 12) nomeDoMes = "Dezembro";

        return String.format("%02d", this.dia) + "/" + nomeDoMes + "/" + this.ano;
    }

    public boolean bissexto() {
        if ((this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int diasTranscorridos() {
        int totalDeDias = 0;
        int[] diasDeCadaMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (bissexto() == true) {
            diasDeCadaMes[1] = 29;
        }
        
        for (int i = 0; i < (this.mes - 1); i++) {
            totalDeDias = totalDeDias + diasDeCadaMes[i];
        }
        
        totalDeDias = totalDeDias + this.dia;
        
        return totalDeDias;
    }

    public void apresentaDataAtual() {
        Date dataDeHoje = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data Atual (Sistema): " + formatador.format(dataDeHoje));
    }

   
}