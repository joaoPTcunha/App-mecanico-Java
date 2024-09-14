
public class ArranjoVeiculo {
    private static int contadorId = 1;
    private int idArranjo;
    private String matricula;
    private String tipoVeiculo;
    private int idTrabalhador;
    private int idCliente;
    private float custoTotal;
    private String dataArranjo;
    private String observacoes;

    public ArranjoVeiculo(String matricula, String tipoVeiculo, int idTrabalhador, int idCliente, float custoTotal,
            String dataArranjo, String observacoes) {
        this.idArranjo = contadorId++;
        this.matricula = matricula;
        this.tipoVeiculo = tipoVeiculo;
        this.idTrabalhador = idTrabalhador;
        this.idCliente = idCliente;
        this.custoTotal = custoTotal;
        this.dataArranjo = dataArranjo;
        this.observacoes = observacoes;
    }

    public int getIdArranjo() {
        return idArranjo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getIdTrabalhador() {
        return idTrabalhador;
    }

    public void setIdTrabalhador(int idTrabalhador) {
        this.idTrabalhador = idTrabalhador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public String getDataArranjo() {
        return dataArranjo;
    }

    public void setDataArranjo(String dataArranjo) {
        this.dataArranjo = dataArranjo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getAllInfo() {
        return "ID Arranjo: " + idArranjo + ", Matrícula: " + matricula + ",Tipo de Veículo: " + tipoVeiculo
                + ", ID Trabalhador: " + idTrabalhador + ", ID Cliente: " + idCliente + ", Custo Total: " + custoTotal
                + ", Data do Arranjo: " + dataArranjo + ", Observações: " + observacoes;
    }
}
