package br.com.memento;

public class FormularioCadastro {

    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public MementoFormulario salvarEstado() {
        return new MementoFormulario(nome, email, telefone, endereco);
    }

    public void restaurarEstado(MementoFormulario memento) {
        this.nome = memento.getNome();
        this.email = memento.getEmail();
        this.telefone = memento.getTelefone();
        this.endereco = memento.getEndereco();
    }

    @Override
    public String toString() {
        return "FormularioCadastro{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
