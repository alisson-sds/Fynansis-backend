package br.fynansis.Fynansis.exceptions;

import br.fynansis.Fynansis.entities.Usuario;

public class UsuarioException extends Exception{

    public UsuarioException(String mensagem){
        super(mensagem);
    }

}
