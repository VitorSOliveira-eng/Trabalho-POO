
import java.sql.Date;

public class Matricula {
    private Date data;
    private Turma turma;
    private Aluno aluno;

    private Matricula(Date data, Turma turma, Aluno aluno) {
        this.data = data;
        this.turma = turma;
        this.aluno = aluno;
    }

    public static Matricula criarMatricula(Date data, Turma turma, Aluno aluno){
        if(data != null && turma != null && aluno != aluno) {
            return new Matricula(data,turma,aluno);
        } else {
            return null;
        }
    }  

    public Date getData() { 
        return data; 
    }
    public Turma getTurma() { 
        return turma; 
    }
    public Aluno getAluno() { 
        return aluno; 
    }




}
