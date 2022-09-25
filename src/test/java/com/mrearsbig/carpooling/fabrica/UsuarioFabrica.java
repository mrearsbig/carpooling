package com.mrearsbig.carpooling.fabrica;

import com.mrearsbig.carpooling.modelos.Usuario;

public class UsuarioFabrica {
    public static Usuario usuario() {
        return new Usuario(
            "Alexander",
            "Viafara",
            "3124172917",
            "Cll 25 # 09 - 22",
            "alexander.viafara@gmail.com",
            "Alex*2022"
        );
    }

    public static Usuario usuarioInvalido() {
        return new Usuario(
            "Alexander",
            "Viafara",
            "3124172917",
            "Cll 25 # 09 - 22",
            "alexander.viafara@gmailcom",
            "Alex202"
        );
    }
}
