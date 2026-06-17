public class TesteData { 
    public static void main(String[] args) {
        /*
		aluno: Igo lima borges
		aluno: Guilherme silvestre de farias 
		exercicio 2
		Agora, desenvolva um programa capaz de testar a classe e os métodos desenvolvidos no
		exercício anterior.
		*/
        System.out.println(" CRIANDO DATA COM DADOS NO CÓDIGO ");
        Data dataPronta = new Data(20, 4, 2024);
        
        System.out.println("Formato 1: " + dataPronta.mostra1());
        System.out.println("Formato 2: " + dataPronta.mostra2());
        System.out.println("O ano é bissexto? " + dataPronta.bissexto());
        System.out.println("Dias que já se passaram: " + dataPronta.diasTranscorridos());

        System.out.println("\n  CRIANDO DATA PELO TECLADO ");
        System.out.println("DICA: Tente digitar o dia 35 ou uma letra para ver o erro funcionar!");
        Data dataUsuario = new Data();
        
        System.out.println("\n Você digitou a data: " + dataUsuario.mostra2());

        System.out.println("\n ALTERANDO UM VALOR (DIA) ");
        dataUsuario.entraDia();
        
        System.out.println("O dia foi alterado e o método retDia() devolveu: " + dataUsuario.retDia());
        System.out.println("Como ficou a data inteira agora: " + dataUsuario.mostra1());
        
        System.out.println("\n  DATA ATUAL DO SISTEMA ");
        dataUsuario.apresentaDataAtual();
    }
}
