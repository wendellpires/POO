package atividadepoo;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Questao03 {
    private static Scanner sc = new Scanner(System.in);
    private static int numPessoas;
    private static LinkedHashSet<Pessoa> pessoas = new LinkedHashSet<Pessoa>();

    private static void recebeNPessoas() throws InputMismatchException, NullPointerException {

        for (int x = 0; x < 1; x++) {
            try {
                System.out.println("DIGITE A QUANTIDADE DE PESSOAS A SEREM REGISTRADAS: ");
                numPessoas = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este valor deve ser um inteiro!");
                x -= 1;
            }
            sc.nextLine();
        }
    }

    private static Pessoa recebeNome(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println("DIGITE O NOME DA PESSOA " + (i + 1));
        pessoa.setNome(sc.nextLine());
        return pessoa;
    }

    private static Pessoa recebeIdade(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println("DIGITE A IDADE DA PESSOA " + (i + 1));
        pessoa.setIdade(sc.nextInt());
        return pessoa;
    }

    private static Pessoa recebeCpf(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println("DIGITE O CPF DA PESSOA " + (i + 1));
        pessoa.setCpf(sc.nextInt());
        return pessoa;
    }

    private static boolean verificaCpf(Pessoa pessoa) {
        boolean cpfContain = true;

        Iterator<Pessoa> pessoasAsIterator = pessoas.iterator();
        if (pessoas.size() == 0) {
            cpfContain = false;
        } else {
            while (pessoasAsIterator.hasNext()) {
                Pessoa p = pessoasAsIterator.next();
                if (p.getCpf() == pessoa.getCpf()) {
                    cpfContain = true;
                } else {
                    cpfContain = false;
                }
            }
        }
        return cpfContain;
    }

    public static void main(String args[]) {

        recebeNPessoas();

        for (int i = 0; i < numPessoas; i++) {
            Pessoa pessoa = new Pessoa();
            try {
                recebeCpf(i, recebeIdade(i, recebeNome(i, pessoa)));

                if (verificaCpf(pessoa)) {
                    System.out.println("Esta pessoa já está cadastrada");
                    System.out.println("  ");
                    System.out.println("TENTE NOVAMENTE");
                    i -= 1;
                } else {
                    pessoas.add(pessoa);
                }

            } catch (InputMismatchException e) {
                System.out.println("Os campos em questão têm tipos específicos, por favor preencha de acordo!");
                i -= 1;
            }
            sc.nextLine();
        }

        Iterator<Pessoa> pessoasAsIterator = pessoas.iterator();
        while (pessoasAsIterator.hasNext()) {
            Pessoa p = pessoasAsIterator.next();
            System.out.println(p.getNome());
            System.out.println(p.getIdade());
            if (p.getCpf() != 0) {
                System.out.println(p.getCpf());
            } else {
                System.out.println("vazio");
            }

        }
    }

}
