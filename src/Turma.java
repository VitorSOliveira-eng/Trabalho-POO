public class Turma {
    private int ano;
    private int numerovagas;
    private Disciplina[] disciplinas;
    private Matricula[] matriculas;
    
    
    private Turma(int ano, int numerovagas) {
        
        if(ano != 0 && numerovagas != 0 && disciplinas != null && matriculas != null){
            this.ano = ano;
            this.numerovagas = numerovagas;
            this.disciplinas = new Disciplina[10];
            this.matriculas = new Matricula[10];
        }
    }
    
    public static Turma criarTurma(int ano, int numerovagas) {
        if(ano != 0 && numerovagas > 0) {
            return new Turma(ano, numerovagas);
        } else {
            return null;
        }



    }
    
    //private Disciplina disciplina;
    //private Aluno alunosmatriculados;
}
