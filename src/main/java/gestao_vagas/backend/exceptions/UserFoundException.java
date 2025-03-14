package gestao_vagas.backend.exceptions;

public class UserFoundException extends RuntimeException  {
    public UserFoundException(String userNotFound){
        super("Usuário já existe!");
    }
}
