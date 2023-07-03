package com.ewallet.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.ewallet.wallet.config.JwtUtils;
import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.payload.Request.LoginRequest;
import com.ewallet.wallet.payload.Request.SignupRequest;
import com.ewallet.wallet.payload.Response.JwtResponse;
import com.ewallet.wallet.payload.Response.MessageResponse;
import com.ewallet.wallet.repository.UtilisateurRepository;


@RestController
@RequestMapping("/api/auth")
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
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getMotDePasse()));
        } catch(Exception e )
        {
            e.printStackTrace();
        }
       

                Utilisateur user =  utilisateurRepository.findByEmail(loginRequest.getEmail()).get();
        String jwt = jwtUtils.generateJwtToken(user);

      

        return ResponseEntity.ok(new JwtResponse(jwt,
        user.getIdUtilisateur(),
        user.getNom() + " " + user.getPrenom(),
        user.getRole()
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
        Utilisateur utilisateur = new Utilisateur(signUpRequest.getNom(),signUpRequest.getPrenom(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getMotDePasse()));

     
        utilisateur.setRole("ROLE_USER");     
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
