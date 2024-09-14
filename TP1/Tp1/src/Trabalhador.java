public class Trabalhador {
    private static int contadorId = 1;
    private int idTrabalhador;
    private String nome;
    private int idade;
    private String contacto;
    private String cargo;
    private float salarioMensal;

    public Trabalhador(String nome, int idade, String contacto, String cargo, float salarioMensal) {
        this.idTrabalhador = contadorId++; // id automatico ao trabalhador
        this.nome = nome;
        this.idade = idade;
        this.contacto = contacto;
        this.cargo = cargo;
        this.salarioMensal = salarioMensal;
    }

    // getters
    public int getIdTrabalhador() {
        return idTrabalhador;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getContacto() {
        return contacto;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSalarioMensal() {
        return salarioMensal;
    }

    // seters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalarioMensal(float salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    // retornar todos os valores
    public String getAllInfo() {
        return "ID: " + idTrabalhador + ", Nome: " + nome + ", Idade: " + idade + ", Contacto: " + contacto
                + ", Cargo: " + cargo + ", Salário Mensal: " + salarioMensal;
    }

}