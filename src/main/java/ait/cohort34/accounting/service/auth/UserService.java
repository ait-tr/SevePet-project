package ait.cohort34.accounting.service.auth;

import ait.cohort34.accounting.dao.UserAccountRepository;
import ait.cohort34.accounting.model.Role;
import ait.cohort34.accounting.model.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserAccountRepository repository;
public UserAccount save(UserAccount account) {
    return repository.save(account);
}
public UserAccount create(UserAccount account) {
    if(repository.existsByUsername(account.getUsername())) {
        throw new RuntimeException("Username already exists");
    }
    return save(account);
}
public UserAccount getByUsername(String username) {
    return repository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Username not found"));
}
public UserDetailsService getUserDetailsService() {
    return this::getByUsername;
}

public UserAccount getCurrentUser() {
    var username = SecurityContextHolder.getContext().getAuthentication().getName();
    return getByUsername(username);
}

@Deprecated
    public void getAdmin(){
    var user=getCurrentUser();
    user.setRole(Role.ADMINISTRATOR);
    save(user);
}

}
