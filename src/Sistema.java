public class Sistema {

    private static Sistema instance;

    private Disciplina[] disciplinas;
    private Turma[] turmas;
    private Aluno[] alunos;
    private Matricula[] matriculas;
    private Nota[] notas;
    private int larguraColuna = 20;

    private Sistema() {

        disciplinas = new Disciplina[100];
        turmas = new Turma[100];
        alunos = new Aluno[100];
        matriculas = new Matricula[100];
        notas = new Nota[100];
    }

    public static Sistema getInstance() {

        if (instance == null) {
            instance = new Sistema();
        }

        return instance;
    }

    public void init() {
        Disciplina d1 = Disciplina.criarDisciplina("Matemática", "Mateus");
        Disciplina d2 = Disciplina.criarDisciplina("Portugues", "Cecilia");
        Disciplina d3 = Disciplina.criarDisciplina("Banco de Dados", "Balbino");

        cadastradisc(d1);
        cadastradisc(d2);
        cadastradisc(d3);

        Turma t1 = Turma.criarTurma(2024, 40);
        t1.adiciona(d1); // Adicionando as matérias na turma
        t1.adiciona(d2);
        t1.adiciona(d3);
        cadastraturma(t1);

        Aluno a1 = Aluno.criarAluno("Joao Silva", "11122233344");
        Aluno a2 = Aluno.criarAluno("Maria Souza", "22233344455");
        Aluno a3 = Aluno.criarAluno("Carlos Oliveira", "33344455566");
        Aluno a4 = Aluno.criarAluno("Ana Santos", "44455566677");
        Aluno a5 = Aluno.criarAluno("Lucas Pereira", "55566677788");

        cadastraaluno(a1);
        cadastraaluno(a2);
        cadastraaluno(a3);
        cadastraaluno(a4);
        cadastraaluno(a5);

        // usa a data atual do sistema
        java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());

        Matricula m1 = Matricula.criarMatricula(dataAtual, t1, a1);
        Matricula m2 = Matricula.criarMatricula(dataAtual, t1, a2);
        Matricula m3 = Matricula.criarMatricula(dataAtual, t1, a3);
        Matricula m4 = Matricula.criarMatricula(dataAtual, t1, a4);
        Matricula m5 = Matricula.criarMatricula(dataAtual, t1, a5);

        cadastramatricula(m1);
        cadastramatricula(m2);
        cadastramatricula(m3);
        cadastramatricula(m4);
        cadastramatricula(m5);
    }

    public boolean cadastradisc(Disciplina disc) {
        if (disc != null) {
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null && disciplinas[i].getCddisciplina() == disc.getCddisciplina()
                        && disciplinas[i].getNome().equals(disc.getNome())) {
                    return false;
                }
            }
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] == null) {
                    disciplinas[i] = disc;
                    return true;
                }
            }

        }
        return false;
    }

    public boolean cadastraaluno(Aluno aluno) {
        if (aluno != null) {
            for (int i = 0; i < alunos.length; i++) {
                if (alunos[i] != null && alunos[i].getNome().equals(aluno.getNome())) {
                    return false;
                }
            }
            for (int i = 0; i < alunos.length; i++) {
                if (alunos[i] == null) {
                    alunos[i] = aluno;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cadastraturma(Turma turma) {
        if (turma != null) {
            for (int i = 0; i < turmas.length; i++) {
                if (turmas[i] != null && turmas[i].getAno() == turma.getAno()) {
                    return false;
                }
            }
            for (int i = 0; i < turmas.length; i++) {
                if (turmas[i] == null) {
                    turmas[i] = turma;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cadastramatricula(Matricula matricula) {
        if (matricula != null) {
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] != null && matriculas[i].getAluno() == matricula.getAluno()) {
                    return false;
                }
            }
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] == null) {
                    matriculas[i] = matricula;
                    return true;
                }
            }
        }
        return false;
    }

    public Aluno buscarAluno(long nmatricula) {
        if (alunos != null && nmatricula > 0) {
            for (int i = 0; i < alunos.length; i++) {
                if (alunos[i] != null && alunos[i].getNumMatricula() == nmatricula) {
                    return alunos[i];

                }
            }
            return null;
        }
        return null;
    }

    public Disciplina buscarDisciplina(long cddisciplina) {
        if (disciplinas != null && cddisciplina > 0) {
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null && disciplinas[i].getCddisciplina() == cddisciplina) {
                    return disciplinas[i];
                }
            }
            return null;
        }
        return null;
    }

    public Turma buscarTurma(int ano) {
        if (turmas != null && ano > 0) {
            for (int i = 0; i < turmas.length; i++) {
                if (turmas[i] != null && turmas[i].getAno() == ano) {
                    return turmas[i];

                }
            }
            return null;
        }
        return null;
    }

    public Matricula buscarMatricula(long nmatriculaAluno) {
        if (matriculas != null) {
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] != null && matriculas[i].getAluno().getNumMatricula() == nmatriculaAluno) {
                    return matriculas[i];
                }
            }
            return null;
        }
        return null;
    }

    private String ajustarColuna(String texto) {
        String resultado = texto;

        while (resultado.length() < larguraColuna) {
            resultado += " ";
        }
        return resultado;
    }

    public void listarAlunos() {
        boolean encontrou = false;

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {

                String mat = ajustarColuna(alunos[i].getNumMatricula() + "");
                String nome = ajustarColuna(alunos[i].getNome());

                System.out.println(mat + nome);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno cadastrado no sistema");
        }
    }

    public void listarDisciplinas() {
        boolean encontrou = false;

        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] != null) {
                String cod = ajustarColuna(disciplinas[i].getCddisciplina() + "");
                String nome = ajustarColuna(disciplinas[i].getNome());
                String prof = ajustarColuna(disciplinas[i].getProfessor());

                System.out.println(cod + nome + prof);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma disciplina cadastrada no sistema");
        }
    }

    public void listarTurma() {
        boolean encontrou = false;

        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i] != null) {
                String ano = ajustarColuna(turmas[i].getAno() + "");
                String vagas = ajustarColuna(turmas[i].getVagas() + "");

                System.out.println(ano + vagas);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma turma cadastrada no sistema");
        }
    }

    public void listarMatriculas() {
        boolean encontrou = false;

        System.out.println(ajustarColuna("ALUNO") + ajustarColuna("TURMA (ANO)") + ajustarColuna("DATA MATRÍCULA"));
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < matriculas.length; i++) {
            if (matriculas[i] != null) {
                String nomeAluno = ajustarColuna(matriculas[i].getAluno().getNome());
                String anoTurma = ajustarColuna(matriculas[i].getTurma().getAno() + "");
                String dataMat = ajustarColuna(matriculas[i].getData().toString());

                System.out.println(nomeAluno + anoTurma + dataMat);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma matrícula realizada no sistema.");
        }
    }

  
public void listarAlunosOrdemCadastro() {
    boolean encontrou = false;
    imprimirCabecalhoTabelaAlunos();
    
    for (int i = 0; i < alunos.length; i++) {
        if (alunos[i] != null) {
            imprimirLinhaAluno(alunos[i]);
            encontrou = true;
        }
    }
    
    if (!encontrou) {
        System.out.println("Nenhum aluno cadastrado no sistema.");
    }
}


public void listarAlunosOrdemMedia() {
    int totalAlunos = 0;
    for (int i = 0; i < alunos.length; i++) {
        if (alunos[i] != null) totalAlunos++;
    }
    
    if (totalAlunos == 0) {
        System.out.println("Nenhum aluno cadastrado no sistema.");
        return;
    }
    
    Aluno[] copiaAlunos = new Aluno[totalAlunos];
    int index = 0;
    for (int i = 0; i < alunos.length; i++) {
        if (alunos[i] != null) {
            copiaAlunos[index++] = alunos[i];
        }
    }
    
    for (int i = 0; i < totalAlunos - 1; i++) {
        for (int j = 0; j < totalAlunos - 1 - i; j++) {
            double mediaA = calcularMediaAluno(copiaAlunos[j]);
            double mediaB = calcularMediaAluno(copiaAlunos[j + 1]);
            
            if (mediaA < mediaB) {
                Aluno temp = copiaAlunos[j];
                copiaAlunos[j] = copiaAlunos[j + 1];
                copiaAlunos[j + 1] = temp;
            }
        }
    }
    
    imprimirCabecalhoTabelaAlunos();
    for (int i = 0; i < totalAlunos; i++) {
        imprimirLinhaAluno(copiaAlunos[i]);
    }
}

    public boolean excluirAluno(long numMatricula) {
        if (numMatricula > 0) {

            if (buscarMatricula(numMatricula) != null) {
                return false;
            }

            for (int i = 0; i < alunos.length; i++) {

                if (alunos[i] != null && alunos[i].getNumMatricula() == numMatricula) {
                    alunos[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean excluirTurma(int ano) {
        if (ano > 0) {
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] != null && matriculas[i].getTurma().getAno() == ano) {
                    return false;
                }
            }
            for (int i = 0; i < turmas.length; i++) {
                if (turmas[i] != null && turmas[i].getAno() == ano) {
                    turmas[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean excluirDisciplina(long cddisciplina) {
        if (cddisciplina > 0) {
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] != null && matriculas[i].getTurma() != null) {
                    Disciplina[] discDaTurma = matriculas[i].getTurma().getDisciplinas();
                    for (int j = 0; j < discDaTurma.length; j++) {
                        if (discDaTurma[j] != null && discDaTurma[j].getCddisciplina() == cddisciplina) {
                            return false;
                        }
                    }

                }
            }
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null && disciplinas[i].getCddisciplina() == cddisciplina) {
                    disciplinas[i] = null;
                    return true;
                }
            }
        }
        return false;

    }

    public boolean lancarNota(long numMatricula, long cddisciplina, double valor) {

        Matricula matricula = buscarMatricula(numMatricula);
        if (matricula == null) {
            return false;
        }

        Turma turmaDoAluno = matricula.getTurma();
        if (turmaDoAluno == null) {
            return false;
        }

        Disciplina disciplinaEncontrada = null;
        Disciplina[] disciplinasDaTurma = turmaDoAluno.getDisciplinas();

        if (disciplinasDaTurma != null) {
            for (int i = 0; i < disciplinasDaTurma.length; i++) {
                if (disciplinasDaTurma[i] != null && disciplinasDaTurma[i].getCddisciplina() == cddisciplina) {
                    disciplinaEncontrada = disciplinasDaTurma[i];
                    break;
                }
            }
        }

        if (disciplinaEncontrada == null) {
            return false;
        }

        Nota novaNota = Nota.criarNota(disciplinaEncontrada, matricula, valor);

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == null) {
                notas[i] = novaNota;
                return true;
            }
        }

        return false;
    }

    public void setLarguraColuna(int larguraColuna) {
        if (larguraColuna > 0) {
            this.larguraColuna = larguraColuna;
        }
    }

    public boolean alterarAluno(long numMatricula, String novonome, String novocpf) {
        Aluno aluno = buscarAluno(numMatricula);
        if (aluno != null) {
            aluno.setNome(novonome);
            aluno.setCpf(novocpf);
            return true;
        }
        return false;
    }

    public boolean alterarDisciplina(long cddisciplina, String novonome, String novoprofessor) {
        Disciplina disci = buscarDisciplina(cddisciplina);
        if (disci != null) {
            disci.setNome(novonome);
            disci.setProfessor(novoprofessor);
            return true;
        }
        return false;
    }

    public boolean alterarTurma(int anoAntigo, int novoAno, int novasVagas, long cdDisciplinaNova) {
        Turma turma = buscarTurma(anoAntigo);
        if (turma == null) {
            return false;
        }

        if (novoAno > 0) {
            if (anoAntigo != novoAno && buscarTurma(novoAno) != null) {
                return false;
            }
            turma.setAno(novoAno);
        }

        if (novasVagas > 0) {
            turma.setNumerovagas(novasVagas);
        }

        if (cdDisciplinaNova > 0) {
            Disciplina disc = buscarDisciplina(cdDisciplinaNova);
            if (disc == null) {
                return false;
            }

            boolean adicionou = turma.adiciona(disc);
            if (!adicionou) {
                return false;
            }
        }

        return true;
    }

    private int contarDisciplinasAluno(Aluno aluno) {
        Matricula mat = buscarMatricula(aluno.getNumMatricula());
        if (mat == null || mat.getTurma() == null) {
            return 0;
        }

        Disciplina[] discs = mat.getTurma().getDisciplinas();
        int qtd = 0;
        for (int i = 0; i < discs.length; i++) {
            if (discs[i] != null) {
                qtd++;
            }
        }
        return qtd;
    }

    private double calcularMediaAluno(Aluno aluno) {
        Matricula mat = buscarMatricula(aluno.getNumMatricula());
        if (mat == null || mat.getTurma() == null) {
            return 0.0;
        }

        Disciplina[] discs = mat.getTurma().getDisciplinas();
        double soma = 0;
        int contNotas = 0;

        for (int i = 0; i < discs.length; i++) {
            if (discs[i] != null) {

                for (int j = 0; j < notas.length; j++) {
                    if (notas[j] != null && notas[j].getMatricula() == mat && notas[j].getDisc() == discs[i]) {
                        soma += notas[j].getValor();
                        contNotas++;
                        break;
                    }
                }
            }
        }

        return contNotas > 0 ? soma / contNotas : 0.0;
    }

    private void imprimirLinhaAluno(Aluno aluno) {
      
        String cod = ajustarColuna(aluno.getNumMatricula() + "");
        String nome = ajustarColuna(aluno.getNome());
        String qtd = ajustarColuna(contarDisciplinasAluno(aluno) + "");
        System.out.print(cod + nome + qtd);
    
        
        Matricula mat = buscarMatricula(aluno.getNumMatricula());
        StringBuilder sbDisciplinas = new StringBuilder();
        
        if (mat != null && mat.getTurma() != null) {
            Disciplina[] discs = mat.getTurma().getDisciplinas();
            boolean primeiro = true;
            
            for (int i = 0; i < discs.length; i++) {
                if (discs[i] != null) {
                    if (!primeiro) {
                        sbDisciplinas.append(", ");
                    }
                    sbDisciplinas.append(discs[i].getNome());
                    primeiro = false;
                }
            }
        }
        
        
        if (sbDisciplinas.length() == 0) {
            sbDisciplinas.append("-");
        }
        
        
        System.out.print(ajustarColuna(sbDisciplinas.toString()));
    
       
        String media = ajustarColuna(String.format("%.1f", calcularMediaAluno(aluno)));
        System.out.println(media);
    }

    private void imprimirCabecalhoTabelaAlunos() {
        System.out.println(ajustarColuna("CÓDIGO") + 
                           ajustarColuna("NOME") + 
                           ajustarColuna("QTD DISC") + 
                           ajustarColuna("DISCIPLINAS") + 
                           ajustarColuna("MÉDIA"));
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }
}
