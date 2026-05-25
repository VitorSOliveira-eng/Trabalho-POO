public class Sistema {

    private static Sistema instance;

    private Disciplina[] disciplinas;
    private Turma[] turmas;
    private Aluno[] alunos;
    private Matricula[] matriculas;

    private Sistema() {

        disciplinas = new Disciplina[100];
        turmas = new Turma[100];
        alunos = new Aluno[100];
        matriculas = new Matricula[100];
    }

    public static Sistema getInstance() {

        if (instance == null) {
            instance = new Sistema();
        }

        return instance;
    }

    public boolean cadastradisc(Disciplina disc) {
        if (disc != null) {
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null && disciplinas[i].getCddisciplina() == disc.getCddisciplina()) {
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
    public Disciplina buscarDisciplina(long cddisciplina){
        if(disciplinas != null && cddisciplina>0){
            for(int i = 0; i<disciplinas.length;i++){
                if(disciplinas[i] != null && disciplinas[i].getCddisciplina() == cddisciplina){
                    return disciplinas[i];
                }
            }
            return null;
        }
        return null;
    }

    public Turma buscarTurma(int ano){
        if(turmas != null && ano > 0){
            for(int i = 0; i<turmas.length;i++){
                if(turmas[i] != null && turmas[i].getAno() == ano){
                    return turmas[i];

                }
            } 
            return null;
        }
        return null;
    }

    public Matricula buscarMatricula(long nmatriculaAluno){
        if(matriculas != null){
            for(int i = 0; i<matriculas.length; i++){
                if(matriculas[i] != null && matriculas[i].getAluno().getNumMatricula() == nmatriculaAluno){
                    return matriculas[i];
                }
            }
            return null;
        }
        return null;
    }
    


}
