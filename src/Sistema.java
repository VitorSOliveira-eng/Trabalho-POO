public class Sistema {
    private static Sistema instance;
    private Disciplina disciplina;
    private Turma turma;
    private Aluno aluno;
    public Sistema() {}
    public static Sistema getInstance(){
        if (instance == null) {
            instance = new Sistema(); 
        }
        return instance; 
    }
    }

   

