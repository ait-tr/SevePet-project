package ait.cohort34.accounting.controller;


import ait.cohort34.accounting.dto.UserRegisterDto;
import ait.cohort34.accounting.dto.auth.SignInRequest;
import ait.cohort34.accounting.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ait.cohort34.accounting.dto.auth.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService ;

    @PostMapping("/sign-up")
    public AuthResponse signUp(@RequestBody @Valid UserRegisterDto request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public AuthResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
