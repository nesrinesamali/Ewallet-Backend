package com.nesryne.wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesryne.wallet.requests.Budget;
import com.nesryne.wallet.requests.Depense;
import com.nesryne.wallet.responses.JsonResponse;

@RestController
@RequestMapping("/main")
public class AppController {
	
	@GetMapping("/hello")
	public String helloMessage() {
		return "hello world";
	}
	
	
	
@PostMapping("/add_montantBudget")
public ResponseEntity<?> addBudget(@RequestBody Budget budget){
	JsonResponse res = new JsonResponse();
	
	res.setSuccess(true);
	res.setMessage("le montant "+ budget.getMontantbuget()+"pour le budget est inséré");
	
							
	return ResponseEntity.ok( res );
	
}

@PostMapping("/add_montantDépense")
public ResponseEntity<?> addBudget(@RequestBody Depense depense){
	JsonResponse res = new JsonResponse();
	
	res.setSuccess(true);
	res.setMessage("le montant "+ depense.getMontantDepense()+"pour les dépenses est inséré");
	
							
	return ResponseEntity.ok( res );
	
	}

@DeleteMapping("/budget/delete/{id}")
public ResponseEntity<?> deleteBudget(@PathVariable(name="id") long id){
System.out.println(id);
	JsonResponse res = new JsonResponse();
	
	res.setSuccess(true);
	res.setMessage("le budget est supprimé");
	
							
	return ResponseEntity.ok( res );
	
	
}

@PutMapping("/update/budget/{id}")
public ResponseEntity<?> updateBudget ( @RequestBody Budget budget,@PathVariable(name="id") long id){
	System.out.println(id);
	JsonResponse res = new JsonResponse();
	
	res.setSuccess(true);
	res.setMessage("le budget est changé");
	return ResponseEntity.ok( res );
}



} 

