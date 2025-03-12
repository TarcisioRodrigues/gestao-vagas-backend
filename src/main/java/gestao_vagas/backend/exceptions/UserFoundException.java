package gestao_vagas.backend.exceptions;

public class UserFoundException extends RuntimeException  {
    public UserFoundException(){
        super("Usuário já existe!");
    }
}
