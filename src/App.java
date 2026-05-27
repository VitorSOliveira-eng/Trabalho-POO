import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        // Inicializa os dados pré-cadastrados
        sistema.init(); 

        Scanner scanner = new Scanner(System.in);
        int opcaoPrincipal;
        int subOpcao;

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
                scanner.next(); // Limpa a entrada inválida
                opcaoPrincipal = -1; // Mantém o loop rodando
                continue;
            }
            
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do teclado

            switch (opcaoPrincipal) {
                case 1:
                    System.out.println("\n--- 1. CADASTRAR ---");
                    System.out.println("1. Alunos");
                    System.out.println("2. Disciplina");
                    System.out.println("3. Turma");
                    System.out.print("Escolha a subopção: ");
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
                        default:
                            System.out.println("Opção de cadastro inválida.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n--- 2. EXCLUIR ---");
                    System.out.println("1. Alunos");
                    System.out.println("2. Disciplina");
                    System.out.println("3. Turma");
                    System.out.print("Escolha a subopção: ");
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
                        default:
                            System.out.println("Opção de exclusão inválida.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("\n--- 3. ALTERAR ---");
                    System.out.println("1. Alunos");
                    System.out.println("2. Disciplina");
                    System.out.println("3. Turma");
                    System.out.print("Escolha a subopção: ");
                    subOpcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (subOpcao) {
                        case 1: {
                            System.out.print("Digite a matrícula do aluno que deseja alterar: ");
                            long mat = scanner.nextLong();
                            scanner.nextLine();
                            Aluno a = sistema.buscarAluno(mat);
                            if (a != null) {
                                System.out.print("Novo nome para o aluno (Atual: " + a.getNome() + "): ");
                                String novoNome = scanner.nextLine();
                                a.setNome(novoNome); 
                                System.out.println("Dados do aluno atualizados.");
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Digite o código da disciplina que deseja alterar: ");
                            long cod = scanner.nextLong();
                            scanner.nextLine();
                            Disciplina d = sistema.buscarDisciplina(cod);
                            if (d != null) {
                                System.out.print("Novo nome da disciplina (Atual: " + d.getNome() + "): ");
                                String novoNome = scanner.nextLine();
                                System.out.print("Novo professor (Atual: " + d.getProfessor() + "): ");
                                String novoProf = scanner.nextLine();
                                d.setNome(novoNome);
                                d.setProfessor(novoProf);
                                System.out.println("Disciplina atualizada com sucesso.");
                            } else {
                                System.out.println("Disciplina não encontrada.");
                            }
                            break;
                        }
                        case 3: {
                            System.out.print("Digite o ano da turma que deseja buscar para gerenciar: ");
                            int ano = scanner.nextInt();
                            scanner.nextLine();
                            Turma t = sistema.buscarTurma(ano);
                            if (t != null) {
                                System.out.println("Turma localizada. Vincular nova disciplina existente?");
                                System.out.print("Digite o código da disciplina: ");
                                long cdDisc = scanner.nextLong();
                                scanner.nextLine();
                                Disciplina disc = sistema.buscarDisciplina(cdDisc);
                                if (disc != null && t.adiciona(disc)) {
                                    System.out.println("Disciplina vinculada à turma com sucesso!");
                                } else {
                                    System.out.println("Não foi possível vincular a disciplina.");
                                }
                            } else {
                                System.out.println("Turma não encontrada.");
                            }
                            break;
                        }
                        default:
                            System.out.println("Opção de alteração inválida.");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("\n--- 4. LISTAR ---");
                    System.out.println("1. Alunos");
                    System.out.println("2. Disciplina");
                    System.out.println("3. Turma");
                    System.out.print("Escolha a subopção: ");
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
                        default:
                            System.out.println("Opção de listagem inválida.");
                            break;
                    }
                    break;

                case 5:
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
                    break;

                case 6: 
                    System.out.print("Digite a nova largura das colunas da tabela: ");
                    if (scanner.hasNextInt()) {
                        int largura = scanner.nextInt();
                        sistema.setLarguraColuna(largura);
                        System.out.println("Largura das tabelas alterada para " + largura + " caracteres.");
                    } else {
                        System.out.println("Valor inválido.");
                    }
                    scanner.nextLine();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    // Se o número digitado não corresponder a nenhum case válido
                    if (opcaoPrincipal != -1) { 
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                    break;
            }
            
        } while (opcaoPrincipal != 0);
        
        scanner.close();
    }
}
