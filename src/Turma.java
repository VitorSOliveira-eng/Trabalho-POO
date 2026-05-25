public class Turma {
    private int ano;
    private int numerovagas;
    private Disciplina[] disciplinas;
    private Matricula[] matriculas;
    
    
    private Turma(int ano, int numerovagas) {
        
        if(ano != 0 && numerovagas != 0){
            this.ano = ano;
            this.numerovagas = numerovagas;
            this.disciplinas = new Disciplina[numerovagas];
            this.matriculas = new Matricula[10];
        }
    }
    
    public static Turma criarTurma(int ano, int numerovagas) {
        if(ano > 0 && numerovagas > 0) {
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

    
        for (int i = 0; i < matriculas.length; i++) {
        
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
    
    
    
    
    //private Disciplina disciplina;
    //private Aluno alunosmatriculados;
}
