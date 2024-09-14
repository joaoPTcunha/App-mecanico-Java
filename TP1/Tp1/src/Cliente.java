public class Cliente {
    private static int contadorId = 1;
    private int idCliente;
    private String nome;
    private String contato;
    private String NIF;

    public Cliente(String nome, String contato, String NIF) {
        this.idCliente = contadorId++;
        this.nome = nome;
        this.contato = contato;
        this.NIF = NIF;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getAllInfo() {
        return "ID Cliente: " + idCliente + ", Nome: " + nome + ", Contato: " + contato + ", NIF: " + NIF;
    }
}
