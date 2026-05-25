public class Nota {
    private Disciplina disc;
    private Matricula matricula;
    private double valor;
    
    private Nota(Disciplina disc, Matricula matricula, double valor){
        setDisc(disc);
        setMatricula(matricula);
        setValor(valor);
    }

    public static Nota getInstance(Disciplina disc, Matricula matricula, double valor){
        return new Nota(disc, matricula, valor);
    }
    
    
    public Disciplina getDisc() {
        return disc;
    }
    public void setDisc(Disciplina disc) {
        this.disc = disc;
    }
    public Matricula getMatricula() {
        return matricula;
    }
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }


    
}
