package com.nesryne.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.nesryne.wallet.config.JwtUtils;
import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.payload.Request.LoginRequest;
import com.nesryne.wallet.payload.Request.SignupRequest;
import com.nesryne.wallet.payload.Response.JwtResponse;
import com.nesryne.wallet.payload.Response.MessageResponse;
import com.nesryne.wallet.repository.UtilisateurRepository;
import com.nesryne.wallet.service.jwt.UserDetailsImpl;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)

public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository utilisateurRepository;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    @GetMapping("/pages-login")
    public String showLoginPage() {
        return "pages-login";
    }

    @GetMapping("/pages-register")
    public String showRegisterPage() {
        return "pages-register";
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getNom(), loginRequest.getMotDePasse()));

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getIdUtilisateur(),
                userDetails.getUsername(),
                userDetails.getEmail()
               ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (utilisateurRepository.existsByNom(signUpRequest.getNom())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (utilisateurRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Utilisateur utilisateur = new Utilisateur(signUpRequest.getNom(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getMotDePasse()));

     
                
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
