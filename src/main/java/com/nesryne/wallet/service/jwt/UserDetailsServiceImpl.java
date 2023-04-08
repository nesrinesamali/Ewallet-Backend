package com.nesryne.wallet.service.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.repository.UtilisateurRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
		Utilisateur utilisateur= utilisateurRepository.findByNom(nom)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + nom));

		return UserDetailsImpl.build(utilisateur);
	}

}