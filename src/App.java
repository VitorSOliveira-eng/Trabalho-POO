public class App {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        sistema.init(); // <--- Adicione essa linha aqui!
        
        // Agora chame o seu método de listar para ver a mágica acontecer:
        System.out.println("--- ALUNOS PRÉ-CADASTRADOS NO INIT ---");
        sistema.listarAlunos();
        
        System.out.println("\n--- DISCIPLINAS PRÉ-CADASTRADAS NO INIT ---");
        sistema.listarDisciplinas();

        System.out.println("Turmas pre cadastradas");
        sistema.listarTurma();
    }
}
