import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        
        sistema.init(); 

        Scanner scanner = new Scanner(System.in);
        int opcaoPrincipal;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Excluir");
            System.out.println("3. Alterar");
            System.out.println("4. Listar");
            System.out.println("5. Lançar Nota de Aluno");
            System.out.println("6. Mudar Largura das Colunas da Tabela");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            // Validação para evitar que o programa quebre se o usuário digitar uma letra
            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
                opcaoPrincipal = -1; 
            }
            
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoPrincipal) {
                case 1:
                    menuCadastrar(sistema, scanner);
                    break;

                case 2:
                    menuExcluir(sistema, scanner);
                    break;

                case 3:
                    menuAlterar(sistema, scanner);
                    break;

                case 4:
                    menuListar(sistema, scanner);
                    break;

                case 5:
                    menuLancarNota(sistema, scanner);
                    break;

                case 6: 
                    menuMudarLargura(sistema, scanner);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    if (opcaoPrincipal != -1) { 
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                    break;
            }
            
        } while (opcaoPrincipal != 0);
        
        scanner.close();
    }

    private static void menuCadastrar(Sistema sistema, Scanner scanner) {
        int subOpcao;
        do {
            System.out.println("\n--- 1. CADASTRAR ---");
            System.out.println("1. Alunos");
            System.out.println("2. Disciplina");
            System.out.println("3. Turma");
            System.out.println("0. Voltar");
            System.out.print("Escolha a subopção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
                subOpcao = -1;
                continue;
            }

            subOpcao = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcao) {
                case 1: {
                    System.out.print("Nome do Aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Aluno: ");
                    String cpf = scanner.nextLine();
                    
                    Aluno aluno = Aluno.criarAluno(nome, cpf);
                    if (sistema.cadastraaluno(aluno)) {
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar aluno.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nome da Disciplina: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nome do Professor: ");
                    String professor = scanner.nextLine();

                    Disciplina disc = Disciplina.criarDisciplina(nome, professor);
                    if (sistema.cadastradisc(disc)) {
                        System.out.println("Disciplina cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar disciplina.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Ano da Turma: ");
                    int ano = scanner.nextInt();
                    System.out.print("Número de Vagas: ");
                    int vagas = scanner.nextInt();
                    scanner.nextLine();

                    Turma turma = Turma.criarTurma(ano, vagas);
                    if (sistema.cadastraturma(turma)) {
                        System.out.println("Turma cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar turma.");
                    }
                    break;
                }
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção de cadastro inválida.");
                    break;
            }
        } while (subOpcao != 0);
    }

    private static void menuExcluir(Sistema sistema, Scanner scanner) {
        int subOpcao;
        do {
            System.out.println("\n--- 2. EXCLUIR ---");
            System.out.println("1. Alunos");
            System.out.println("2. Disciplina");
            System.out.println("3. Turma");
            System.out.println("0. Voltar");
            System.out.print("Escolha a subopção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
                subOpcao = -1;
                continue;
            }

            subOpcao = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcao) {
                case 1:
                    System.out.print("Digite o número da matrícula do aluno a excluir: ");
                    long matAluno = scanner.nextLong();
                    scanner.nextLine();
                    if (sistema.excluirAluno(matAluno)) {
                        System.out.println("Aluno excluído com sucesso.");
                    } else {
                        System.out.println("Não foi possível excluir o aluno.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o código da disciplina a excluir: ");
                    long codDisc = scanner.nextLong();
                    scanner.nextLine();
                    if (sistema.excluirDisciplina(codDisc)) {
                        System.out.println("Disciplina excluída com sucesso.");
                    } else {
                        System.out.println("Não foi possível excluir a disciplina.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ano da turma a excluir: ");
                    int anoTurma = scanner.nextInt();
                    scanner.nextLine();
                    if (sistema.excluirTurma(anoTurma)) {
                        System.out.println("Turma excluída com sucesso.");
                    } else {
                        System.out.println("Não foi possível excluir a turma.");
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção de exclusão inválida.");
                    break;
            }
        } while (subOpcao != 0);
    }

    private static void menuAlterar(Sistema sistema, Scanner scanner) {
        int subOpcao;
        do {
          

System.out.println("\n====== MENU DE ALTERAÇÕES ======");
System.out.println("1. Alterar Aluno");
System.out.println("2. Alterar Disciplina");
System.out.println("3. Alterar Turma");
System.out.println("0. Voltar");
System.out.print("Escolha uma opção: ");
subOpcao = scanner.nextInt();
scanner.nextLine();

switch (subOpcao) {
    case 1: {
        System.out.print("Digite a matrícula do aluno que deseja alterar: ");
        long mat = scanner.nextLong();
        scanner.nextLine(); 

        Aluno a = sistema.buscarAluno(mat);
        if (a != null) {
            System.out.println("\n--- Editando Aluno: " + a.getNome() + " ---");
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo CPF: ");
            String novoCpf = scanner.nextLine();

            
            if (sistema.alterarAluno(mat, novoNome, novoCpf)) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar os dados do aluno.");
            }
        } else {
            System.out.println("Aluno não encontrado no sistema.");
        }
        break;
    }

    case 2: {
        System.out.print("Digite o código da disciplina que deseja alterar: ");
        long cod = scanner.nextLong();
        scanner.nextLine(); 

        Disciplina d = sistema.buscarDisciplina(cod);
        if (d != null) {
            System.out.println("\n--- Editando Disciplina: " + d.getNome() + " ---");
            System.out.print("Digite o novo nome da disciplina: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo professor responsável: ");
            String novoProf = scanner.nextLine();

            
            if (sistema.alterarDisciplina(cod, novoNome, novoProf)) {
                System.out.println("Disciplina atualizada com sucesso!");
            } else {
                System.out.println("Erro ao atualizar os dados da disciplina.");
            }
        } else {
            System.out.println("Disciplina não encontrada no sistema.");
        }
        break;
    }

    case 3: {
        System.out.print("Digite o ano da turma que deseja alterar: ");
        int anoAntigo = scanner.nextInt();
        scanner.nextLine(); 

        Turma t = sistema.buscarTurma(anoAntigo);
        if (t != null) {
            System.out.println("\n--- Editando Turma do Ano: " + t.getAno() + " ---");
            

            System.out.print("Digite o novo ano para esta turma (ou " + t.getAno() + " para manter): ");
            int novoAno = scanner.nextInt();
            
            System.out.print("Digite a nova quantidade de vagas (ou " + t.getVagas() + " para manter): ");
            int novasVagas = scanner.nextInt();
            
            System.out.print("Deseja adicionar uma nova disciplina? Digite o código (ou 0 para pular): ");
            long cdDisc = scanner.nextLong();
            scanner.nextLine(); 

           
            if (sistema.alterarTurma(anoAntigo, novoAno, novasVagas, cdDisc)) {
                System.out.println("Processo de alteração da turma concluído!");
            } else {
                System.out.println("Não foi possível alterar a turma (Verifique se o novo ano já existe).");
            }
        } else {
            System.out.println("Turma não encontrada no sistema.");
        }
        break;
    }

    case 0:
        System.out.println("Voltando ao menu principal...");
        break;

    default:
        System.out.println("Opção inválida!");
        break;
}
        } while (subOpcao != 0);
    }

    private static void menuListar(Sistema sistema, Scanner scanner) {
        int subOpcao;
        do {
            System.out.println("\n--- 4. LISTAR ---");
            System.out.println("1. Alunos");
            System.out.println("2. Disciplina");
            System.out.println("3. Turma");
            System.out.println("0. Voltar");
            System.out.print("Escolha a subopção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
                subOpcao = -1;
                continue;
            }

            subOpcao = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcao) {
                case 1:
                    System.out.println("\n--- RELATÓRIO DE ALUNOS ---");
                    sistema.listarAlunos();
                    break;
                case 2:
                    System.out.println("\n--- RELATÓRIO DE DISCIPLINAS ---");
                    sistema.listarDisciplinas();
                    break;
                case 3:
                    System.out.println("\n--- RELATÓRIO DE TURMAS ---");
                    sistema.listarTurma();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção de listagem inválida.");
                    break;
            }
        } while (subOpcao != 0);
    }

    private static void menuLancarNota(Sistema sistema, Scanner scanner) {
        System.out.println("\n--- LANÇAMENTO DE NOTAS ---");
        System.out.print("Digite o número de matrícula do aluno: ");
        long numMatricula = scanner.nextLong();
        System.out.print("Digite o código da disciplina: ");
        long cddisciplina = scanner.nextLong();
        System.out.print("Digite o valor da nota: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        if (sistema.lancarNota(numMatricula, cddisciplina, valor)) {
            System.out.println("Nota lançada e registrada com sucesso no sistema!");
        } else {
            System.out.println("Falha ao lançar nota. Verifique os dados inseridos.");
        }
    }

    private static void menuMudarLargura(Sistema sistema, Scanner scanner) {
        System.out.print("Digite a nova largura das colunas da tabela: ");
        if (scanner.hasNextInt()) {
            int largura = scanner.nextInt();
            sistema.setLarguraColuna(largura);
            System.out.println("Largura das tabelas alterada para " + largura + " caracteres.");
        } else {
            System.out.println("Valor inválido.");
        }
        scanner.nextLine();
    }
    
}
