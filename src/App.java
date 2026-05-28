import java.sql.Date;
import java.util.Scanner;

public class App {
    
    static Scanner sc = new Scanner(System.in);
    static Sistema sistema = Sistema.getInstance();

    public static void main(String[] args) {
        // Inicializa o sistema (dados pré-cadastrados)
        sistema.init();

        int opcao;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("0 - Sair");
            System.out.println("1 - Menu Disciplina");
            System.out.println("2 - Menu Alunos");
            System.out.println("3 - Menu Turmas e Matrículas");
            System.out.println("4 - Configurar o tamanho da tabela");
            System.out.print("Opção: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                sc.next();
                opcao = -1;
                continue;
            }
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                case 1:
                    menuDisciplina();
                    break;
                case 2:
                    menuAlunos();
                    break;
                case 3:
                    menuTurmasEMatriculas();
                    break;
                case 4:
                    configurarTamanhoTabela();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        sc.close();
    }

    // ==========================================
    // MENU DISCIPLINAS
    // ==========================================
    public static void menuDisciplina() {
        int opcao;
        do {
            System.out.println("\n--- Menu Disciplina ---");
            System.out.println("1 - Inserir Disciplina");
            System.out.println("2 - Listar Disciplinas");
            System.out.println("3 - Excluir Disciplinas");
            System.out.println("4 - Editar disciplinas");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nome da Disciplina: ");
                    String nome = sc.nextLine();
                    System.out.print("Nome do Professor: ");
                    String professor = sc.nextLine();

                    Disciplina disc = Disciplina.criarDisciplina(nome, professor);
                    if (sistema.cadastradisc(disc)) {
                        System.out.println("Disciplina cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar disciplina.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- RELATÓRIO DE DISCIPLINAS ---");
                    sistema.listarDisciplinas();
                    break;
                case 3:
                    System.out.print("Digite o código da disciplina para ser excluída: ");
                    long codExcluir = sc.nextLong();
                    if (sistema.excluirDisciplina(codExcluir)) {
                        System.out.println("Disciplina excluída com sucesso.");
                    } else {
                        System.out.println("Não foi possível excluir (não encontrada ou vinculada a uma turma).");
                    }
                    break;
                case 4:
                    System.out.print("Digite o código da disciplina para editar: ");
                    long codEditar = sc.nextLong();
                    sc.nextLine(); 
                    Disciplina d = sistema.buscarDisciplina(codEditar);
                    
                    if (d != null) {
                        System.out.println("Editando: " + d.getNome());
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo professor: ");
                        String novoProf = sc.nextLine();
                        
                        if (sistema.alterarDisciplina(codEditar, novoNome, novoProf)) {
                            System.out.println("Disciplina editada com sucesso!");
                        } else {
                            System.out.println("Erro ao atualizar.");
                        }
                    } else {
                        System.out.println("Disciplina não encontrada.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ==========================================
    // MENU ALUNOS
    // ==========================================
    public static void menuAlunos() {
        int opcao;
        do {
            System.out.println("\n--- Menu Alunos ---");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos (Cadastro)");
            System.out.println("3 - Listar Alunos (Por Média)");
            System.out.println("4 - Alterar Aluno");
            System.out.println("5 - Excluir Aluno");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nome do Aluno: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do Aluno: ");
                    String cpf = sc.nextLine();
                    
                    Aluno aluno = Aluno.criarAluno(nome, cpf);
                    if (sistema.cadastraaluno(aluno)) {
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Verifique os dados ou duplicidade.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- ALUNOS (ORDEM DE CADASTRO) ---");
                    sistema.listarAlunosOrdemCadastro();
                    break;
                case 3:
                    System.out.println("\n--- ALUNOS (ORDEM DE MÉDIA) ---");
                    sistema.listarAlunosOrdemMedia();
                    break;
                case 4:
                    System.out.print("Digite a matrícula do aluno para alterar: ");
                    long matEditar = sc.nextLong();
                    sc.nextLine(); 
                    
                    Aluno a = sistema.buscarAluno(matEditar);
                    if (a != null) {
                        System.out.println("Editando: " + a.getNome());
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo CPF: ");
                        String novoCpf = sc.nextLine();
                        
                        if (sistema.alterarAluno(matEditar, novoNome, novoCpf)) {
                            System.out.println("Dados alterados com sucesso!");
                        } else {
                            System.out.println("Erro ao atualizar.");
                        }
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite a matrícula do aluno para excluir: ");
                    long matExcluir = sc.nextLong();
                    if (sistema.excluirAluno(matExcluir)) {
                        System.out.println("Aluno excluído com sucesso.");
                    } else {
                        System.out.println("Erro: Aluno não encontrado ou já matriculado.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ==========================================
    // MENU TURMAS E MATRÍCULAS
    // ==========================================
    public static void menuTurmasEMatriculas() {
        int opcao;
        do {
            System.out.println("\n--- Menu Turmas e Matrículas ---");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Listar Turmas");
            System.out.println("3 - Excluir Turma");
            System.out.println("4 - Editar Turma");
            System.out.println("5 - Matricular Aluno em Turma");
            System.out.println("6 - Listar Matrículas");
            System.out.println("7 - Lançar Nota");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Ano da Turma: ");
                    int ano = sc.nextInt();
                    System.out.print("Número de Vagas: ");
                    int vagas = sc.nextInt();

                    Turma turma = Turma.criarTurma(ano, vagas);
                    if (sistema.cadastraturma(turma)) {
                        System.out.println("Turma cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar turma.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- RELATÓRIO DE TURMAS ---");
                    sistema.listarTurma();
                    break;
                case 3:
                    System.out.print("Digite o ano da turma a excluir: ");
                    int anoExcluir = sc.nextInt();
                    if (sistema.excluirTurma(anoExcluir)) {
                        System.out.println("Turma excluída com sucesso.");
                    } else {
                        System.out.println("Erro: Turma não encontrada ou possui alunos.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ano da turma que deseja alterar: ");
                    int anoAntigo = sc.nextInt();
                    
                    Turma t = sistema.buscarTurma(anoAntigo);
                    if (t != null) {
                        System.out.print("Novo ano (ou " + t.getAno() + " para manter): ");
                        int novoAno = sc.nextInt();
                        System.out.print("Novas vagas (ou " + t.getVagas() + " para manter): ");
                        int novasVagas = sc.nextInt();
                        System.out.print("Código da nova disciplina (ou 0 para pular): ");
                        long cdDisc = sc.nextLong();
                        
                        if (sistema.alterarTurma(anoAntigo, novoAno, novasVagas, cdDisc)) {
                            System.out.println("Turma alterada com sucesso!");
                        } else {
                            System.out.println("Erro ao alterar turma.");
                        }
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("\n--- EFETUAR MATRÍCULA ---");
                    System.out.print("Digite a matrícula do aluno: ");
                    long matAluno = sc.nextLong();
                    System.out.print("Digite o ano da turma: ");
                    int anoTurma = sc.nextInt();

                    Aluno al = sistema.buscarAluno(matAluno);
                    Turma tu = sistema.buscarTurma(anoTurma);

                    if (al != null && tu != null) {
                        Date dataAtual = new Date(System.currentTimeMillis());
                        Matricula novaMatricula = Matricula.criarMatricula(dataAtual, tu, al);
                        
                        if (sistema.cadastramatricula(novaMatricula)) {
                            tu.adiciona(novaMatricula);
                            System.out.println("Matrícula efetuada com sucesso!");
                        } else {
                            System.out.println("Falha na matrícula (possível duplicidade).");
                        }
                    } else {
                        System.out.println("Erro: Aluno ou Turma não encontrados.");
                    }
                    break;
                case 6:
                    System.out.println("\n--- RELATÓRIO DE MATRÍCULAS ---");
                    sistema.listarMatriculas();
                    break;
                case 7:
                    System.out.println("\n--- LANÇAMENTO DE NOTAS ---");
                    System.out.print("Matrícula do aluno: ");
                    long matNota = sc.nextLong();
                    System.out.print("Código da disciplina: ");
                    long codNota = sc.nextLong();
                    System.out.print("Valor da nota: ");
                    double valor = sc.nextDouble();

                    if (sistema.lancarNota(matNota, codNota, valor)) {
                        System.out.println("Nota lançada com sucesso!");
                    } else {
                        System.out.println("Falha ao lançar nota. Verifique os dados.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ==========================================
    // CONFIGURAÇÃO DA TABELA
    // ==========================================
    public static void configurarTamanhoTabela() {
        System.out.print("Digite a nova largura das colunas da tabela: ");
        if (sc.hasNextInt()) {
            int largura = sc.nextInt();
            sistema.setLarguraColuna(largura);
            System.out.println("Largura alterada para " + largura + " caracteres.");
        } else {
            System.out.println("Valor inválido.");
            sc.next();
        }
    }
}
