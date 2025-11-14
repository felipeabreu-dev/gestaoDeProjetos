package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.controller.dto.LoginRequestDTO;
import dev.matheuslf.desafio.inscritos.controller.dto.LoginResponseDTO;
import dev.matheuslf.desafio.inscritos.controller.dto.RegisterRequestDTO;
import dev.matheuslf.desafio.inscritos.model.User;
import dev.matheuslf.desafio.inscritos.service.TokenService;
import dev.matheuslf.desafio.inscritos.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());

        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generate((User) auth.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDTO dto) {
        var passwordEncoded = passwordEncoder.encode(dto.password());

        User newUser = new User();
        newUser.setLogin(dto.login());
        newUser.setPassword(passwordEncoded);
        newUser.setRole(dto.role());

        userService.save(newUser);

        return ResponseEntity.ok().build();
    }

}
