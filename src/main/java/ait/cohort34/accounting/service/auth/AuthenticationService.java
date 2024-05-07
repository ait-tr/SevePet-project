package ait.cohort34.accounting.service.auth;

import ait.cohort34.accounting.dto.UserRegisterDto;
import ait.cohort34.accounting.dto.auth.AuthResponse;
import ait.cohort34.accounting.dto.auth.SignInRequest;
import ait.cohort34.accounting.model.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenProvider jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse signUp(UserRegisterDto request) {

        var user = UserAccount.builder()
                .login(request.getLogin())
                .avatar(request.getAvatar())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .email(request.getEmail())
                .website(request.getWebsite())
                .phone(request.getPhone())
                .telegram(request.getTelegram())
                .build();

        userService.create(user);

        var jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
    public AuthResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService
                .getUserDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
}
