public class Turma {
    private int ano;
    private int numerovagas;
    private Disciplina[] disciplinas;
    private Matricula[] matriculas;

    private Turma(int ano, int numerovagas) {

        if (ano != 0 && numerovagas != 0) {
            this.ano = ano;
            this.numerovagas = numerovagas;
            this.disciplinas = new Disciplina[numerovagas];
            this.matriculas = new Matricula[10];
        }
    }

    public static Turma criarTurma(int ano, int numerovagas) {
        if (ano > 0 && numerovagas > 0) {
            return new Turma(ano, numerovagas);
        } else {
            return null;
        }
    }

    public boolean adiciona(Matricula a) {
        if (a == null) {
            return false;
        }

        for (int i = 0; i < matriculas.length; i++) {
            if (matriculas[i] == null) {
                matriculas[i] = a;
                return true;
            }
        }
        return false;
    }

    public boolean adiciona(Disciplina b) {

        if (b == null) {
            return false;
        }

        for (int i = 0; i < disciplinas.length; i++) {

            if (disciplinas[i] == null) {
                disciplinas[i] = b;
                return true;
            }
        }
        return false;
    }

    public int getAno() {
        return ano;
    }

    public int getVagas() {
        return numerovagas;
    }

    public Matricula[] getMatriculas() {
        return matriculas;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        }

    }

    public void setNumerovagas(int numerovagas) {
        if (numerovagas > 15) {
            this.numerovagas = numerovagas;
        }

    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        if (disciplinas != null)
            this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma{");
        sb.append("ano=").append(ano);
        sb.append(", numerovagas=").append(numerovagas);
        sb.append(", disciplinas=").append(disciplinas);
        sb.append(", matriculas=").append(matriculas);
        sb.append('}');
        return sb.toString();
    }

}
